package fr.eni.clinique.ihm.login;

import java.util.List;

import fr.eni.clinique.bll.ClientsUtil;
import fr.eni.clinique.bll.ClientsUtilImpl;
import fr.eni.clinique.bll.ClientsUtilSingleton;
import fr.eni.clinique.bo.Clients;

public class ControllerClients {
	
	private ClientsUtil bllclients;
	private List<Clients> liste;
	private Clients clients;
	
	
	public ControllerClients (){
		bllclients = ClientsUtilSingleton.getinstance();
		
	}
	
	public void insertClient (String text, String text2, String text3, String text4, String text5, String text6,
			String text7){
		clients = new Clients();
		bllclients.insert(clients);
	}
	
	public Object[][] getList(){
		liste = bllclients.getAll();
		Object[][] tab = new Object[liste.size()][5];
		for (int i = 0; i < liste.size(); i++){
			tab[i][0] = liste.get(i).getCodeClient();
			tab[i][1] = liste.get(i).getPrenom();
			tab[i][2] = liste.get(i).getNom();
			tab[i][3] = liste.get(i).getVille();
			tab[i][4] = liste.get(i).getCodePostal();
			tab[i][5] = liste.get(i).getAdresse1();
		}
		return tab;
	}
	
	
	public void deleteClient (Integer codeclient){
		bllclients.delete(codeclient);
	}
	
	public void updateClient (Clients client){
		bllclients.update(client);
	}
	
	
	
}
