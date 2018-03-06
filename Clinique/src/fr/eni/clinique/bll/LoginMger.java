package fr.eni.clinique.bll;

import fr.eni.clinique.bo.User;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.UserDAO;

public class LoginMger {

	// fonction pour savoir si le mdp est bon ou pas
	// Et ça va retourner la fonction de la DAL
	private UserDAO daoUser;
	private User user;
	private static LoginMger instance = null;

	private LoginMger() throws BLLException {
		// Instancier le Data Access Object
		daoUser = DAOFactory.getUserDAO();
	}

	public static synchronized LoginMger getInstance() throws BLLException {
		if (instance == null) {
			instance = new LoginMger();
		}
		return instance;
	}

	public String verifPassword(String password, String nom) throws BLLException {
		String message = "";
		try {
			user = daoUser.selectByNom(nom);
		} catch (DALException e) {
			user = null;
			e.printStackTrace();
		}
		if(user != null){
			if (password.equals(user.getPassword())) {
				message = "Identifiant correct.";
			} else {
				message = "Identifiant incorrect.";
			}
		}else{
			message = "Identifiant incorrect.";
		}
		
		return message;
	}

}
