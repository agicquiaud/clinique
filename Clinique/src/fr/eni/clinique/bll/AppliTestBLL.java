package fr.eni.clinique.bll;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginManager;
import fr.eni.clinique.bll.LoginManagerSingleton;
import fr.eni.clinique.bo.User;

public class AppliTestBLL {

	public static void main(String[] args) {

		User u1 = new User("Edmond", "Bosapin", "adm", false);
		User u2 = new User("Mélanie", "Malalanich", "vet", false);
		User u3 = new User("Elisabeth", "Abondieu", "sec", true);

		LoginManager mger = LoginManagerSingleton.getInstance();

		// Verif mdp
		try {
			System.out.println(mger.verifPassword(u1.getLogin(), u1.getPassword()));

			System.out.println(mger.verifPassword(u2.getLogin(), u2.getPassword()));

			System.out.println(mger.verifPassword(u3.getLogin(), u3.getPassword()));

		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		
	}
}
