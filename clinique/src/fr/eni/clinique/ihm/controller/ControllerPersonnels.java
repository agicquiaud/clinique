package fr.eni.clinique.ihm.controller;

import fr.eni.clinique.bo.User;

public interface ControllerPersonnels {
	
	public void addPersonnel(User p);
	public void ArchivePersonnel(String nom);
	public Object[][] getList();
	public User getUserByNom(String nom);
	public void resetMotDePasse(String login, String mdp);
	public User[] getVeterinaire();
	public String[] getNomVeterinaires();	

}
