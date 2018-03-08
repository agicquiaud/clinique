package fr.eni.clinique.ihm.login;

import java.util.List;

import fr.eni.clinique.bll.ClientsUtil;
import fr.eni.clinique.bll.ClientsUtilImpl;
import fr.eni.clinique.bll.ClientsUtilSingleton;
import fr.eni.clinique.bo.Clients;

public class ControllerClients {
	
	private static ClientsUtil bllclients;
	private List<Clients> liste;
	private Clients clients;
	
	
	public ControllerClients (){
		bllclients = ClientsUtilSingleton.getinstance();
		
	}
	
	public void insertClient (Clients client){
		bllclients.insert(client);
	}
	
	public Object[][] getList(){
		liste = bllclients.getAll();
		Object[][] tab = new Object[liste.size()][3];
		for (int i = 0; i < liste.size(); i++){
			tab[i][0] = liste.get(i).getLogin();
			tab[i][1] = pass;
			tab[i][2] = liste.get(i).getType();
		}
		return tab;
	}
	
	
	
}
