package fr.eni.clinique.ihm.login;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginManager;
import fr.eni.clinique.bll.LoginManagerSingleton;

public class ControllerLogin {
	
	private static LoginManager mger;
	
	public ControllerLogin(){
		
		mger = LoginManagerSingleton.getInstance();
	}
	
	public String verif(String nom, String mdp){
		String message = "";
		try {
			message = mger.verifPassword(nom, mdp);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		return message;
	}
}
