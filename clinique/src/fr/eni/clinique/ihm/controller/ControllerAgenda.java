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
import fr.eni.clinique.bo.RendezVous;

public class ControllerAgenda {

	private AnimalManager mgerAnimal;
	private ClientsManager mgerClient;
	private AgendaManager mgerAgenda;
	private List<RendezVous> listerdv;
	private Clients clients;
	private Animaux animaux;
	
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
		
		Object[][] tab = new Object[listerdv.size()][5];
		for (int i = 0; i < listerdv.size(); i++) {
//			tab[i][0] = listerdv.get(i).getCodeClient();
//			tab[i][1] = listerdv.get(i).getPrenom();
//			tab[i][2] = listerdv.get(i).getNom();
//			tab[i][3] = listerdv.get(i).getCodePostal();
//			tab[i][4] = listerdv.get(i).getVille();
		}
		return tab;
	}
	
}
