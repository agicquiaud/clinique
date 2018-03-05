package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.User;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.UserDAO;

public class LoginMger {

	// fonction pour savoir si le mdp est bon ou pas
	// Et ça va retourner la fonction de la DAL
	private UserDAO daoUser;
	private User user;

	public String verifPassword(String password, String nom) {
		String message = "";
		
		try {
			user = daoUser.selectByNom(nom);
		} catch (DALException e) {
			e.printStackTrace();

		}
		
		if (password == user.getPassword()) {
			message = "Connexion validée";
		} else {
			message = "Erreur d'identifiant";
		}

		return message;
	}

}
