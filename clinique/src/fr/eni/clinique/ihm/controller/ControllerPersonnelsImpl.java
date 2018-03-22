package fr.eni.clinique.ihm.controller;

import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bll.PersonnelsManagerSingleton;
import fr.eni.clinique.bo.User;

public class ControllerPersonnelsImpl extends Observable implements ControllerPersonnels{

	private static PersonnelsManager mger;
	private List<User> liste;
	private User user;

	ControllerPersonnelsImpl() {
		mger = PersonnelsManagerSingleton.getInstance();
	}

	public void addPersonnel(User p) {
		try {
			mger.add(p);
		} catch (BLLException e) {
			e.getMessage();
		}
		
		setChanged();
		notifyObservers(p);
	}
	
	public User getUserByNom(String nom){
		try {
			user = mger.getUser(nom);
		} catch (BLLException e) {
			e.getMessage();
		}
		return user;
	}

	public void ArchivePersonnel(String nom) {
		try {
			user = mger.getUser(nom);
		} catch (BLLException e) {
			e.getMessage();
		}
		try {
			mger.archive(user);
		} catch (BLLException e) {
			e.getMessage();
		}
		
		setChanged();
		notifyObservers(user);
	}

	public Object[][] getList() {
		try {
			liste = mger.getAll();
		} catch (BLLException e) {
			e.getMessage();
		}
		Object[][] tab = new Object[liste.size()][3];
		String pass = "*****";
		for (int i = 0; i < liste.size(); i++) {
			tab[i][0] = liste.get(i).getLogin();
			tab[i][1] = pass;
			tab[i][2] = liste.get(i).getType();
		}
		return tab;
	}

	public void resetMotDePasse(String login, String mdp) {
		try {
			user = mger.getUser(login);
		} catch (BLLException e) {
			e.getMessage();
		}
		user.setPassword(mdp);
		try {
			mger.resetMotDePasse(user);
		} catch (BLLException e) {
			e.getMessage();
		}
		
		setChanged();
		notifyObservers(user);
	}
	
	public User[] getVeterinaire(){
		try {
			liste = mger.getVeterinaires();
		} catch (BLLException e) {
			e.getMessage();
		}
		User[] tab = new User[liste.size()];
		for (User user : liste) {
			tab[liste.lastIndexOf(user)] = user;
		}
		return tab;
	}

	public String[] getNomVeterinaires() {
		try {
			liste = mger.getVeterinaires();
		} catch (BLLException e) {
			e.getMessage();
		}
		String[] tab = new String[liste.size()];
		for (int i = 0; i < liste.size(); i++) {
			tab[i] = liste.get(i).getLogin();
		}
		return tab;
	}
}
