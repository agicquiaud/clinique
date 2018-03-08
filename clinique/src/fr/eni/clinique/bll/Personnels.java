package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.User;

public interface Personnels {
	public void add(User p);
	public void archive(User p);
	public void resetMotDePasse(User p);
	public User getUser(String nom);
	public List<User> getAll();
	
}
