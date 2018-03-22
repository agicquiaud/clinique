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

	public Boolean verifPassword(String nom, String password) throws BLLException {
		Boolean message = false;
		try {
			user = daoUser.selectByNom(nom);
		} catch (DALException e) {
			user = null;
			throw new BLLException("Erreur BLL Login verifPassword - user=" + user);			
		}
		if (user == null) {
			message = false;
		}else{
			if (password.equalsIgnoreCase(user.getPassword()) && user.getArchive() == false) {
				message = true;
			}
		}
		return message;
	}

}
