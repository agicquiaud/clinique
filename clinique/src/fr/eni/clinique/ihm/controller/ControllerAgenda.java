package fr.eni.clinique.ihm.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
		mgerPersonnel = PersonnelsManagerSingleton.getInstance();
		mgerAgenda = AgendaManagerSingleton.getinstance();
	}
	
	
	public Object[][] getTabAgenda(String NomVeto, String pdate) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH);
		Date date = null;
		User Veto = mgerPersonnel.getUser(NomVeto);
		try {
			date = (Date) format.parse(pdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(date.toString());
		System.out.println(Veto.toString());
		RendezVous rdv = new RendezVous(Veto.getId(), date);
		System.out.println(rdv.toString());
		liste = mgerAgenda.getRdvVetByDay(rdv);
		System.out.println(liste.toString());
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
