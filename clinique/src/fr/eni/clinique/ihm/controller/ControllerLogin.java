package fr.eni.clinique.ihm.controller;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginManager;
import fr.eni.clinique.bll.LoginManagerSingleton;
import fr.eni.clinique.bll.PersonnelsManager;
import fr.eni.clinique.bll.PersonnelsManagerSingleton;
import fr.eni.clinique.bo.User;
import fr.eni.clinique.ihm.view.WindowAccueilAdmin;
import fr.eni.clinique.ihm.view.WindowAccueilSecretaire;
import fr.eni.clinique.ihm.view.WindowAccueilVeterinaire;

public class ControllerLogin {

	private static LoginManager mger;
	private static PersonnelsManager user;
	
	public ControllerLogin(){
		
		mger = LoginManagerSingleton.getInstance();
		user = PersonnelsManagerSingleton.getInstance();
	}
	
	public Boolean verif(String nom, char[] pass){
		Boolean message = false;
		String mdp = "";
		try {
			for (char c : pass) {
				mdp = mdp + c;
			}
			message = mger.verifPassword(nom, mdp);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		if (message) {
			User userI = null; 
			try {
				userI = user.getUser(nom);
			} catch (BLLException e) {
				e.getMessage();
			}

			if(userI.getType().equals("sec")){
				new WindowAccueilSecretaire();
			}else if(userI.getType().equals("vet")){
				new WindowAccueilVeterinaire(nom.substring(0, 1).toUpperCase() + nom.substring(1));
			}else if(userI.getType().equals("adm")){
				new WindowAccueilAdmin();
			}
			
		}
		return message;
	}
}
