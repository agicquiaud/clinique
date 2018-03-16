package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.User;

public interface PersonnelsManager {
	public void add(User p);
	public void archive(User p);
	public void resetMotDePasse(User p);
	public User getUser(String nom);
	public List<User> getAll();
	public List<User> getVeterinaires();	
}
