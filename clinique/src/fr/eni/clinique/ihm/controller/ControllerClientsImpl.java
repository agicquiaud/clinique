package fr.eni.clinique.ihm.controller;

import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bll.ClientsManagerSingleton;
import fr.eni.clinique.bo.Clients;

public class ControllerClientsImpl extends Observable implements ControllerClients{

	private ClientsManager bllclients;
	private List<Clients> liste;
	private Clients clients;

	ControllerClientsImpl() {
		bllclients = ClientsManagerSingleton.getinstance();
	}

	public void addClient(String Nom, String Prenom, String Adresse1, String Adresse2, String CodePostal, String Ville, String NumTel,
			String Email) {
		clients = new Clients(Nom, Prenom, Adresse1, Adresse2, CodePostal, Ville, NumTel, Email, false);
		try {
			bllclients.insert(clients);
		} catch (BLLException e) {
			e.getMessage();
		}
		
		setChanged();
		notifyObservers(clients);
	}
	/**
	 * fonction qui récupère une liste de clients
	 * @return un tableau a une dimension de client
	 */
	public Clients[] listeClient(){
		try {
			liste = bllclients.getAll();
		} catch (BLLException e) {
			e.getMessage();
		}
		Clients[] tab = new Clients[liste.size()];
		for (Clients clients : liste) {
			tab[liste.indexOf(clients)] = clients;
		}
		return tab;
	}

	public Object[][] getList() {
		try {
			liste = bllclients.getAll();
		} catch (BLLException e) {
			e.getMessage();
		}
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
		try {
			liste = bllclients.getClientByNom(nom);
		} catch (BLLException e) {
			e.getMessage();
		}
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
		try {
			liste = bllclients.getAll();
		} catch (BLLException e) {
			e.getMessage();
		}
		String[] tab = new String[liste.size()];
		for (int i = 0; i < liste.size(); i++) {
			tab[i] = liste.get(i).getPrenom() + " " + liste.get(i).getNom();
		}
		return tab;
	}
	
	public Clients getClientbyId(String id){
		try {
			clients = bllclients.getClientById(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			System.out.println("Erreur ControllerAnimaux NumberFormatException - getListByClient");
		} catch (BLLException e) {
			e.getMessage();
		}
		return clients;
	}

	public void removeClient(Integer codeclient) {
		try {
			clients = bllclients.getClientById(codeclient);
		} catch (BLLException e) {
			e.getMessage();
		}
		clients.setArchive(true);
		try {
			bllclients.update(clients);
		} catch (BLLException e) {
			e.getMessage();
		}
		
		setChanged();
		notifyObservers(clients);
	}

	public void updateClient(String codeClient, String nomClient, String prenomClient, String adresse1, String adresse2,
			String codePostal, String ville, String numTel, String assurance, String email, String remarque) {
		clients = new Clients(Integer.parseInt(codeClient), nomClient, prenomClient, adresse1, adresse2, codePostal,
				ville, numTel, assurance, email, remarque, false);
		try {
			bllclients.update(clients);
		} catch (BLLException e) {
			e.getMessage();
		}
		
		setChanged();
		notifyObservers(clients);
	}
}
