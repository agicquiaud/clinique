package fr.eni.clinique.ihm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bll.AgendaManager;
import fr.eni.clinique.bll.AgendaManagerSingleton;
import fr.eni.clinique.bll.AnimalManager;
import fr.eni.clinique.bll.AnimalManagerSingleton;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bll.ClientsManagerSingleton;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bll.PersonnelsManagerSingleton;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.RendezVous;
import fr.eni.clinique.bo.User;

public class ControllerAgendaImpl extends Observable implements ControllerAgenda {

	private AnimalManager mgerAnimal;
	private ClientsManager mgerClient;
	private AgendaManager mgerAgenda;
	private PersonnelsManager mgerPersonnel;
	private List<RendezVous> liste;
	private Clients clients;
	private Animaux animaux;
	private Calendar cal = Calendar.getInstance();

	ControllerAgendaImpl() {
		mgerAnimal = AnimalManagerSingleton.getinstance(); // Instance
															// AnimalImpl
		mgerClient = ClientsManagerSingleton.getinstance();
		mgerPersonnel = PersonnelsManagerSingleton.getInstance();
		mgerAgenda = AgendaManagerSingleton.getinstance();
	}

	public void addRDV(RendezVous rdv) {
		// if (mgerAgenda.getRdvByDateCodeVet(rdv.getCodeVeto(), rdv.getDate())
		// == null) {
		try {
			mgerAgenda.insert(rdv);
		} catch (BLLException e) {
			e.getMessage();
		}

		setChanged();
		notifyObservers(rdv);
		// } else {
		// System.out.println("erreur, un rendez vous est deja prévu pour ce
		// créneau la");
		// }
	}

	public void removeRDV(RendezVous rdv) {
		try {
			mgerAgenda.delete(rdv);
		} catch (BLLException e) {
			e.getMessage();
		}

		setChanged();
		notifyObservers(rdv);
	}

	public List<RendezVous> getRdv(User veto, String date, Integer heure, Integer minute) {
		String[] str = date.split("/");
		cal.set(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), heure, minute);
		try {
			liste = mgerAgenda.getRdvVetByDay(new RendezVous(veto.getId(), cal.getTime()));
		} catch (BLLException e) {
			e.getMessage();
		}

		return liste;
	}

	public Object[][] getTabAgenda(String NomVeto, String pdate) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		User Veto = null;
		try {
			Veto = mgerPersonnel.getUser(NomVeto);
		} catch (BLLException e) {
			e.getMessage();
		}
		try {
			date = (Date) format.parse(pdate);
		} catch (ParseException e) {
			System.out.println("Erreur parse ControllerAgenda - getTabAgenda ");
		}
		RendezVous rdv = new RendezVous(Veto.getId(), date);
		try {
			liste = mgerAgenda.getRdvVetByDay(rdv);
		} catch (BLLException e) {
			e.getMessage();
		}
		Object[][] tab = new Object[liste.size()][5];
		format.applyPattern("HH:mm");
		for (int i = 0; i < liste.size(); i++) {
			try {
				animaux = mgerAnimal.animalById(liste.get(i).getCodeAnimal());
			} catch (BLLException e) {
				e.getMessage();
			}
			try {
				clients = mgerClient.getClientById(animaux.getCodeClient());
			} catch (BLLException e) {
				e.getMessage();
			}
			tab[i][0] = format.format(liste.get(i).getDate());
			tab[i][1] = clients.getNom() + " " + clients.getPrenom();
			tab[i][2] = animaux.getNom();
			tab[i][3] = animaux.getRace();
			tab[i][4] = animaux;
		}
		return tab;
	}

	public RendezVous getRdvByCodeVetDate(RendezVous rdv) {
		try {
			rdv = mgerAgenda.getRdvByDateCodeVet(rdv.getCodeVeto(), rdv.getDate());
		} catch (BLLException e) {
			e.getMessage();
		}

		return rdv;
	}

}
