package fr.eni.clinique.dal;

public class DAOFactory {
	
	public UserDAO getUserDAO()  {
		UserDAO userDAO=null;
		try {
			userDAO=(UserDAO ) Class.forName("fr.eni.clinique.dal.jdbc.UserDAOJdbcImpl").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return userDAO; 
	}
	
	public ClientDAO getClientDAO()  {
		ClientDAO clientDAO=null;
		try {
			clientDAO=(ClientDAO ) Class.forName("fr.eni.clinique.dal.jdbc.ClientDAOJdbcImpl").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return clientDAO; 
	}
	
	public AnimalDAO getAnimalDAO()  {
		AnimalDAO animalDAO = null;
		try {
			animalDAO =(AnimalDAO ) Class.forName("fr.eni.clinique.dal.jdbc.AnimalDAOJdbcImpl").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return animalDAO; 
	}
	
	public AgendaDAO getAgendaDAO()  {
		AgendaDAO agendaDAO=null;
		try {
			agendaDAO=(AgendaDAO ) Class.forName("fr.eni.clinique.dal.jdbc.AgendaDAOJdbcImpl").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return agendaDAO; 
	}
}
