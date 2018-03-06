package fr.eni.clinique.ihm.login;

import java.util.List;

import fr.eni.clinique.bll.Personnels;
import fr.eni.clinique.bll.PersonnelsSingleton;
import fr.eni.clinique.bo.User;

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

	public void ArchivePersonnel(User p) {
		mger.archive(p);
	}
	
	public Object[][] getList(){
		liste = mger.getAll();
		Integer i = 0;
		Object[][] tab = new Object[liste.size()][3];
		String pass = "*****";
		for (User user : liste) {
			
			tab[i][0] = user.getLogin();
			tab[i][1] = pass;
			tab[i][2] = user.getType();
			i++;
		}
		return tab;
	}


	public void resetMotDePasse(User p) {
		mger.resetMotDePasse(p);
	}
}
