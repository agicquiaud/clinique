package fr.eni.clinique.ihm.login;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginManagerImpl;

public class Controller {
	
	private LoginManagerImpl mger;
	
	public Controller(){
		
		try {
			mger = LoginManagerImpl.getInstance();
		} catch (BLLException e1) {
			e1.getStackTrace();
		}
	}
	
	public String verif(String nom, String mdp){
		
		return null;
	}
}
