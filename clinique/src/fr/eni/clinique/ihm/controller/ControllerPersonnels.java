package fr.eni.clinique.ihm.controller;

import fr.eni.clinique.bo.User;

public interface ControllerPersonnels {
	
	public void addPersonnel(User p);
	public void ArchivePersonnel(String nom);
	public Object[][] getList();
	public void resetMotDePasse(String login, String mdp);
	public Boolean verifDroit();
	public User[] getVeterinaire();
	public String[] getNomVeterinaires();	

}
