package fr.eni.clinique.ihm.login;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.LoginManager;
import fr.eni.clinique.bll.LoginManagerSingleton;
import fr.eni.clinique.bll.Personnels;
import fr.eni.clinique.bll.PersonnelsSingleton;
import fr.eni.clinique.bo.User;

public class ControllerLogin {

	private static LoginManager mger;
	private static Personnels user;
	
	public ControllerLogin(){
		
		mger = LoginManagerSingleton.getInstance();
		user = PersonnelsSingleton.getInstance();
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
		if (message) {
			User userI; 
			userI = user.getUser(nom);

			if(userI.getType().equals("sec")){
				WindowAccueilRendezVous frame = new WindowAccueilRendezVous();
			}else if(userI.getType().equals("vet")){
				WindowAccueilAgenda frame = new WindowAccueilAgenda();
			}else if(userI.getType().equals("adm")){
				WindowAccueilGestionPersonnel frame = new WindowAccueilGestionPersonnel();
			}
			
		}
		return message;
	}
}
