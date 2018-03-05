package fr.eni.clinique.dal;

import fr.eni.clinique.bo.User;

public class DAOFactory {
	
	public static UserDAO getUserDAO()  {
		UserDAO user=null;
		try {
			user =(UserDAO) Class.forName("fr.eni.clinique.dal.jdbc.ConnexionDAOJdbcImpl").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user; 
	}
}
