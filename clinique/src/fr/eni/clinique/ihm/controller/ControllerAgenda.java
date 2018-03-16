package fr.eni.clinique.ihm.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.Locale;

import fr.eni.clinique.bll.AgendaManager;
import fr.eni.clinique.bll.AnimalManager;
import fr.eni.clinique.bll.AnimalManagerSingleton;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bll.ClientsManagerSingleton;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.RendezVous;
import fr.eni.clinique.bo.User;

public class ControllerAgenda {

	private AnimalManager mgerAnimal;
	private ClientsManager mgerClient;
	private AgendaManager mgerAgenda;
	private PersonnelsManager mgerPersonnel;
	private List<RendezVous> liste;
	private Clients clients;
	private Animaux animaux;
	
	public ControllerAgenda(){
		mgerAnimal = AnimalManagerSingleton.getinstance(); //Instance AnimalImpl
		mgerClient = ClientsManagerSingleton.getinstance();
	}
	
	
	public Object[][] getTabAgenda(String NomVeto, String pdate) {
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH);
		System.out.println(pdate);
		Date date = null;
		User Veto = mgerPersonnel.getUser(NomVeto);
		try {
			date = (Date) format.parse(pdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(date.toString());
		RendezVous rdv = new RendezVous(Veto.getId(), date);
		liste = mgerAgenda.getRdvVetByDay(rdv);
		Object[][] tab = new Object[liste.size()][4];
		for (int i = 0; i < liste.size(); i++) {
			animaux = mgerAnimal.animalById(liste.get(i).getCodeAnimal());
			clients = mgerClient.getClientById(animaux.getCodeClient());
			tab[i][0] = liste.get(i).getDate().toString();
			tab[i][1] = clients.getNom() + " " + clients.getPrenom();
			tab[i][2] = animaux.getNom();
			tab[i][3] = animaux.getRace();
		}
		return tab;
	}
	
}
