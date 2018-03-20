package fr.eni.clinique.ihm.controller;

import java.util.List;

import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bll.PersonnelsManagerSingleton;
import fr.eni.clinique.bo.User;
import fr.eni.clinique.ihm.view.WindowLogin;

public class ControllerPersonnelsImpl implements ControllerPersonnels{

	private static PersonnelsManager mger;
	private List<User> liste;
	private User user;

	ControllerPersonnelsImpl() {
		mger = PersonnelsManagerSingleton.getInstance();
	}

	public void addPersonnel(User p) {
		mger.add(p);
	}

	public void ArchivePersonnel(String nom) {
		user = mger.getUser(nom);
		mger.archive(user);
	}

	public Object[][] getList() {
		liste = mger.getAll();
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
		user = mger.getUser(login);
		user.setPassword(mdp);
		mger.resetMotDePasse(user);
	}

	public Boolean verifDroit() {
		Boolean droit = false;
		String nom = WindowLogin.getNom();
		user = mger.getUser(nom);
		if (user.getType().equals("adm")) {
			droit = true;
		}
		return droit;
	}

	public String[] getNomVeterinaires() {
		liste = mger.getVeterinaires();
		String[] tab = new String[liste.size()];
		for (int i = 0; i < liste.size(); i++) {
			tab[i] = liste.get(i).getLogin();
		}
		return tab;
	}
}
