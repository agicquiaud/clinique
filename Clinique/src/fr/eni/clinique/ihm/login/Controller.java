package fr.eni.clinique.ihm.login;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginMger;

public class Controller {
	
	private LoginMger mger;
	
	public Controller(){
		
		try {
			mger = LoginMger.getInstance();
		} catch (BLLException e1) {
			e1.getStackTrace();
		}
	}
	
	public String verif(String nom, String mdp){
		
		return null;
	}
}
