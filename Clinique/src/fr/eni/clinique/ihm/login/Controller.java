package fr.eni.clinique.ihm.login;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginManager;
import fr.eni.clinique.bll.LoginManagerSingleton;

public class Controller {
	
	
	private static LoginManager mger;
	
	public Controller(){
		
		mger = LoginManagerSingleton.getInstance();
	}
	
	public static String verif(String nom, String mdp) throws BLLException{
		
		return mger.verifPassword(nom, mdp);
	}
}
