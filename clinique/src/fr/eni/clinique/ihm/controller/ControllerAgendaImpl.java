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
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bll.ClientsManagerSingleton;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bll.PersonnelsManagerSingleton;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.RendezVous;
import fr.eni.clinique.bo.User;

public class ControllerAgendaImpl extends Observable implements ControllerAgenda{

	private AnimalManager mgerAnimal;
	private ClientsManager mgerClient;
	private AgendaManager mgerAgenda;
	private PersonnelsManager mgerPersonnel;
	private List<RendezVous> liste;
	private Clients clients;
	private Animaux animaux;
	private Calendar cal = Calendar.getInstance();

	ControllerAgendaImpl() {
		mgerAnimal = AnimalManagerSingleton.getinstance(); // Instance AnimalImpl
		mgerClient = ClientsManagerSingleton.getinstance();
		mgerPersonnel = PersonnelsManagerSingleton.getInstance();
		mgerAgenda = AgendaManagerSingleton.getinstance();
	}

	public void addRDV(RendezVous rdv) {
		mgerAgenda.insert(rdv);
		
		setChanged();
		notifyObservers(rdv);
	}

	public void removeRDV(RendezVous rdv) {
		mgerAgenda.delete(rdv);
		
		setChanged();
		notifyObservers(rdv);
	}

	public List<RendezVous> getRdv(User veto, String date, Integer heure, Integer minute) {
		String[] str = date.split("/");
		cal.set(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), heure, minute);
		return mgerAgenda.getRdvVetByDay(new RendezVous(veto.getId(), cal.getTime()));
	}

	public Object[][] getTabAgenda(String NomVeto, String pdate) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		User Veto = mgerPersonnel.getUser(NomVeto);
		try {
			date = (Date) format.parse(pdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		RendezVous rdv = new RendezVous(Veto.getId(), date);
		liste = mgerAgenda.getRdvVetByDay(rdv);
		Object[][] tab = new Object[liste.size()][5];
		format.applyPattern("HH:mm");
		for (int i = 0; i < liste.size(); i++) {
			animaux = mgerAnimal.animalById(liste.get(i).getCodeAnimal());
			clients = mgerClient.getClientById(animaux.getCodeClient());
			tab[i][0] = format.format(liste.get(i).getDate());
			tab[i][1] = clients.getNom() + " " + clients.getPrenom();
			tab[i][2] = animaux.getNom();
			tab[i][3] = animaux.getRace();
			tab[i][4] = animaux;
		}
		return tab;
	}

}
