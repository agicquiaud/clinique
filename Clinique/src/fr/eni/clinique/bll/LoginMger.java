package fr.eni.clinique.bll;

public class LoginMger {
	//fonction pour savoir si le mdp est bon ou pas
	//Et �a va retourner la fonction de la DAL
	
	public String verifPassword(String password){
		String message ="";
		if(password.equals("") ) {
			message = "Connexion valid�e";
		}else{
			message = "Erreur mot de passe";
		}
	}
	
	

}
