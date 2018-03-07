package fr.eni.clinique.ihm.login;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginManager;
import fr.eni.clinique.bll.LoginManagerSingleton;

public class ControllerLogin {

	private static LoginManager mger;
	
	public ControllerLogin(){
		
		mger = LoginManagerSingleton.getInstance();
	}
	
	public Boolean verif(String nom, char[] pass){
		Boolean message = false;
		String mdp = "";
		try {
			for (char c : pass) {
				mdp = mdp + c;
			}
			System.out.println(mdp);
			message = mger.verifPassword(nom, mdp);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		if (message.equals("Identifiant correct.")) {
			WindowGestionPersonnels frame = new WindowGestionPersonnels();
		}
		return message;
	}
}
