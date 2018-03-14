package fr.eni.clinique.ihm.login;

import java.util.List;

import fr.eni.clinique.bll.ClientsUtil;
import fr.eni.clinique.bll.ClientsUtilSingleton;
import fr.eni.clinique.bo.Clients;

public class ControllerClients {

	private ClientsUtil bllclients;
	private List<Clients> liste;
	private Clients clients;

	public ControllerClients() {
		bllclients = ClientsUtilSingleton.getinstance();

	}

	public void addClient(String Nom, String Prenom, String Adresse1, String Adresse2, String CodePostal, String Ville, String NumTel,
			String Email) {
		clients = new Clients(Nom, Prenom, Adresse1, Adresse2, CodePostal, Ville, NumTel, Email, false);
		bllclients.insert(clients);
	}

	public Object[][] getList() {
		liste = bllclients.getAll();
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

	public void removeClient(String codeclient) {
		clients = bllclients.getClientById(Integer.parseInt(codeclient));
		System.out.println(clients.toString());
		clients.setArchive(true);
		bllclients.update(clients);
	}

	public void updateClient(String codeClient, String nomClient, String prenomClient, String adresse1, String adresse2,
			String codePostal, String ville, String numTel, String assurance, String email, String remarque) {
		clients = new Clients(Integer.parseInt(codeClient), nomClient, prenomClient, adresse1, adresse2, codePostal,
				ville, numTel, assurance, email, remarque, false);
		bllclients.update(clients);
	}

}
