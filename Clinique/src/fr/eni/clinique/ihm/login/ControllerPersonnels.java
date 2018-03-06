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

	public Object[][] getListe() {
		liste = mger.getAll();
		Object[][] data = new Object[liste.size()][((List<User>) liste.get(0)).size()];
		for (int i = 0; i < liste.size(); i++) {
			data[i] = ((List<User>) liste.get(i)).toArray();
		}
		return data;
	}

	
	public Object[][] getList(){
		liste = mger.getAll();
		Integer i = 0;
		Object[][] albator = new Object[liste.size()][3];
		String pass = "*****";
		for (User user : liste) {
			
			albator[i][0] = user.getLogin();
			albator[i][1] = pass;
			albator[i][2] = user.getType();
			i++;
		}
		return albator;
	}

	public void resetMotDePasse(User p) {
		mger.resetMotDePasse(p);
	}
}
