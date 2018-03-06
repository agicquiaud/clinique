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
<<<<<<< HEAD
	
	public String[] getList(){
		liste = mger.getAll();
		String str;
		String pass = null;
		for (User user : liste) {
			str = user.getLogin();
			for(int i = 0; i<user.getPassword().length(); i++){
				pass = pass + "*";
			}
			str = str + pass;
			str = str + user.getType();
		}
		return null;
	}
	
	public void resetMotDePasse(User p){
=======

	public void resetMotDePasse(User p) {
>>>>>>> branch 'master' of https://github.com/agicquiaud/clinique.git
		mger.resetMotDePasse(p);
	}

}
