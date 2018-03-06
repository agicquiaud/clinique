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

	public Object[][] getListe() {
		liste = mger.getAll();
		Integer i = 0;
		Object[][] data = new Object[liste.size()][];
		for (User user : liste) {
			
		}
		return data;
	}

	public void resetMotDePasse(User p) {
		mger.resetMotDePasse(p);
	}

}
