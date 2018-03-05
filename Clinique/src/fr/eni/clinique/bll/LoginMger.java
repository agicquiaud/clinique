package fr.eni.clinique.bll;

public class LoginMger {
	//fonction pour savoir si le mdp est bon ou pas
	//Et ça va retourner la fonction de la DAL
	
	public String verifPassword(String password){
		String message ="";
		if(password.equals("") ) {
			message = "Connexion validée";
		}else{
			message = "Erreur mot de passe";
		}
	}
	
	

}
