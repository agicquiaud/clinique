package fr.eni.clinique.ihm.controller;

import java.util.List;

import fr.eni.clinique.bll.Personnels;
import fr.eni.clinique.bll.PersonnelsSingleton;
import fr.eni.clinique.bo.User;
import fr.eni.clinique.ihm.view.WindowLogin;

public class ControllerPersonnels {

	private static Personnels mger;
	private List<User> liste;
	private User user;

	public ControllerPersonnels() {
		mger = PersonnelsSingleton.getInstance();
	}

	public void addPersonnel(User p) {
		mger.add(p);
	}

	public void ArchivePersonnel(String nom) {
		user = mger.getUser(nom);
		mger.archive(user);
	}
	
	public Object[][] getList(){
		liste = mger.getAll();
		Object[][] tab = new Object[liste.size()][3];
		String pass = "*****";
		for (int i = 0; i < liste.size(); i++){
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
	
	public Boolean verifDroit(){
		Boolean droit = false;
		String nom = WindowLogin.getNom();
		user = mger.getUser(nom);
		if(user.getType().equals("adm")){
			droit = true;
		}
		return droit;
	}
}
