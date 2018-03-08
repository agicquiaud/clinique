package fr.eni.clinique.dal;

import fr.eni.clinique.dal.jdbc.UserDAOJdbcImpl;


public class DAOFactory {
	
	public UserDAO getUserDAO()  {
		UserDAO userDAO=null;
		try {
			userDAO=(UserDAO ) Class.forName("fr.eni.clinique.dal.jdbc.UserDAOJdbcImpl").newInstance();
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
		return userDAO; 
	}
}
