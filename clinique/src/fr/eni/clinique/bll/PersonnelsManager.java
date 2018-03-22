package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.User;

public interface PersonnelsManager {
	public void add(User p) throws BLLException;
	public void archive(User p) throws BLLException;
	public void resetMotDePasse(User p) throws BLLException;
	public User getUser(String nom) throws BLLException;
	public List<User> getAll() throws BLLException;
	public List<User> getVeterinaires() throws BLLException;	
}
