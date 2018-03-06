package fr.eni.clinique.bll;

import fr.eni.clinique.bo.User;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.UserDAO;

public class LoginManagerImpl implements LoginManager{

	// fonction pour savoir si le mdp est bon ou pas
	// Et ça va retourner la fonction de la DAL
	private UserDAO daoUser = new DAOFactory().getUserDAO();
	private User user;

	public String verifPassword(String password, String nom) throws BLLException {
		String message = "";
		try {
			user = daoUser.selectByNom(nom);
		} catch (DALException e) {
			e.printStackTrace();
		}

		if (password.equals(user.getPassword())) {
			message = "Identifiant correct.";
		} else {
			message = "Identifiant incorrect.";
		}
		return message;
	}

}
