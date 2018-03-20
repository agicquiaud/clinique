package fr.eni.clinique.ihm.controller;

import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bll.ClientsManagerSingleton;
import fr.eni.clinique.bo.Clients;

public class ControllerClients extends Observable{

	private ClientsManager bllclients;
	private List<Clients> liste;
	private Clients clients;

	public ControllerClients() {
		
		bllclients = ClientsManagerSingleton.getinstance();
	}

	public void addClient(String Nom, String Prenom, String Adresse1, String Adresse2, String CodePostal, String Ville, String NumTel,
			String Email) {
		clients = new Clients(Nom, Prenom, Adresse1, Adresse2, CodePostal, Ville, NumTel, Email, false);
		bllclients.insert(clients);
		System.out.println("jsuis ici");
		
		notifyObservers(clients);
		setChanged();
	}
	/**
	 * fonction qui récupère une liste de clients
	 * @return un tableau a une dimension de client
	 */
	public Clients[] listeClient(){
		liste = bllclients.getAll();
		Clients[] tab = new Clients[liste.size()];
		System.out.println(liste.size());
		for (Clients clients : liste) {
			tab[liste.indexOf(clients)] = clients;
		}
		return tab;
	}

	public Object[][] getList() {
		liste = bllclients.getAll();
		Object[][] tab = new Object[liste.size()][6];
		for (int i = 0; i < liste.size(); i++) {
			tab[i][0] = liste.get(i).getCodeClient();
			tab[i][1] = liste.get(i).getPrenom();
			tab[i][2] = liste.get(i).getNom();
			tab[i][3] = liste.get(i).getCodePostal();
			tab[i][4] = liste.get(i).getVille();
			tab[i][5] = liste.get(i).getAdresse1();
		}
		return tab;
	}

	public Object[][] getClient(String nom) {
		liste = bllclients.getClientByNom(nom);
		Object[][] tab = new Object[liste.size()][6];
		for (int i = 0; i < liste.size(); i++) {
			tab[i][0] = liste.get(i).getCodeClient();
			tab[i][1] = liste.get(i).getPrenom();
			tab[i][2] = liste.get(i).getNom();
			tab[i][3] = liste.get(i).getVille();
			tab[i][4] = liste.get(i).getCodePostal();
			tab[i][5] = liste.get(i).getAdresse1();
		}
		return tab;
	}
	
	public String[] getNomPrenomList(){
		liste = bllclients.getAll();
		String[] tab = new String[liste.size()];
		for (int i = 0; i < liste.size(); i++) {
			tab[i] = liste.get(i).getPrenom() + " " + liste.get(i).getNom();
		}
		return tab;
	}
	
	public Clients getClientbyId(String id){
		clients = bllclients.getClientById(Integer.parseInt(id));
		return clients;
	}

	public void removeClient(Integer codeclient) {
		clients = bllclients.getClientById(codeclient);
		System.out.println(clients.toString());
		clients.setArchive(true);
		bllclients.update(clients);
		
		setChanged();
		notifyObservers();
	}

	public void updateClient(String codeClient, String nomClient, String prenomClient, String adresse1, String adresse2,
			String codePostal, String ville, String numTel, String assurance, String email, String remarque) {
		clients = new Clients(Integer.parseInt(codeClient), nomClient, prenomClient, adresse1, adresse2, codePostal,
				ville, numTel, assurance, email, remarque, false);
		bllclients.update(clients);
		
		setChanged();
		notifyObservers();
	}

}
