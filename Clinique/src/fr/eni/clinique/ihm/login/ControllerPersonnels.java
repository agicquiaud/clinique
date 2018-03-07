package fr.eni.clinique.ihm.login;

import java.util.List;

import fr.eni.clinique.bll.Personnels;
import fr.eni.clinique.bll.PersonnelsSingleton;
import fr.eni.clinique.bo.User;

public class ControllerPersonnels {

	private static Personnels mger;
	private List<User> liste;

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
		Object[][] tab = new Object[liste.size()][3];
		String pass = "*****";
		for (int i = 0; i < liste.size(); i++){
			tab[i][0] = liste.get(i).getLogin();
			tab[i][1] = pass;
			tab[i][2] = liste.get(i).getType();
		}
		return tab;
	}


	public void resetMotDePasse(User p) {
		mger.resetMotDePasse(p);
	}
}
