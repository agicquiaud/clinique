package fr.eni.clinique.ihm.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import fr.eni.clinique.bll.AgendaManager;
import fr.eni.clinique.bll.AnimalManager;
import fr.eni.clinique.bll.AnimalManagerSingleton;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bll.ClientsManagerSingleton;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;

public class ControllerAgenda {

	private AnimalManager mgerAnimal;
	private ClientsManager mgerClient;
	private AgendaManager mgerAgenda;
	private List<Clients> listeclients;
	private List<Animaux> listeanimaux;
	
	public ControllerAgenda(){
		mgerAnimal = AnimalManagerSingleton.getinstance(); //Instance AnimalImpl
		mgerClient = ClientsManagerSingleton.getinstance();
	}
	
	
	public Object[][] getTabAgenda(String pdate) {
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		try {
			Date date = format.parse(pdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		listeclients = mgerClient.getAll();
		listeanimaux = mgerAnimal.getAll();
		Object[][] tab = new Object[listeclients.size()][5];
		for (int i = 0; i < listeclients.size(); i++) {
			tab[i][0] = listeclients.get(i).getCodeClient();
			tab[i][1] = listeclients.get(i).getPrenom();
			tab[i][2] = listeclients.get(i).getNom();
			tab[i][3] = listeclients.get(i).getCodePostal();
			tab[i][4] = listeclients.get(i).getVille();
		}
		return tab;
	}
	
}
