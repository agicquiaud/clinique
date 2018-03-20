package fr.eni.clinique.ihm.controller;

import fr.eni.clinique.bo.Clients;

public interface ControllerClients{
	
	public void addClient(String Nom, String Prenom, String Adresse1, String Adresse2, String CodePostal, String Ville, String NumTel,
			String Email);
	public Clients[] listeClient();
	public Object[][] getList();
	public Object[][] getClient(String nom);
	public String[] getNomPrenomList();
	public Clients getClientbyId(String id);
	public void removeClient(Integer codeclient);
	public void updateClient(String codeClient, String nomClient, String prenomClient, String adresse1, String adresse2,
			String codePostal, String ville, String numTel, String assurance, String email, String remarque);
}
