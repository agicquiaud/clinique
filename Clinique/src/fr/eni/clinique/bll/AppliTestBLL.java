package fr.eni.clinique.bll;

import fr.eni.clinique.bo.User;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.UserDAO;

public class AppliTestBLL {
	
	public static void main(String[] args) {
		// Instanciation du jeu d'essai
		UserDAO fact = DAOFactory.getUserDAO();
		
		User u1 = null;
		try {
			u1 = fact.selectById(12);
		} catch (DALException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		User u2 = null;
		try {
			u2 = fact.selectById(13);
		} catch (DALException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		User u3 = null;
		try {
			u3 = fact.selectById(14);
		} catch (DALException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		LoginMger mger;
		try {
			mger = LoginMger.getInstance();
		} catch (BLLException e1) {
			e1.printStackTrace();
			return;
		}

		// Verif mdp
		try {
			mger.verifPassword(u1.getLogin(), u1.getPassword());

			mger.verifPassword(u2.getLogin(), u2.getPassword());

			mger.verifPassword(u3.getLogin(), u3.getPassword());

		} catch (BLLException e) {
			e.printStackTrace();
		}
	}
}
