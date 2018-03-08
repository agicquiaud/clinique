package fr.eni.clinique.dal;

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
	
	public ClientDAO getClientDAO()  {
		ClientDAO clientDAO=null;
		try {
			clientDAO=(ClientDAO ) Class.forName("fr.eni.clinique.dal.jdbc.ClientDAOJdbcImpl").newInstance();
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
		return clientDAO; 
	}
	
	public AnimalDAO getAnimalDAO()  {
		AnimalDAO animalDAO = null;
		try {
			animalDAO =(AnimalDAO ) Class.forName("fr.eni.clinique.dal.jdbc.ClientDAOJdbcImpl").newInstance();
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
		return animalDAO; 
	}
}
