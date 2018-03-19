package fr.eni.clinique.dal;

import fr.eni.clinique.dal.jdbc.AgendaDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.AnimalDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.ClientDAOJdbcImpl;
import fr.eni.clinique.dal.jdbc.UserDAOJdbcImpl;

public class DAOFactory {

	public UserDAO getUserDAO() {
		UserDAO userDAO = new UserDAOJdbcImpl();
		return userDAO;
	}

	public ClientDAO getClientDAO() {
		ClientDAO clientDAO = new ClientDAOJdbcImpl();
		return clientDAO;
	}

	public AnimalDAO getAnimalDAO() {
		AnimalDAO animalDAO = new AnimalDAOJdbcImpl();
		return animalDAO;
	}

	public AgendaDAO getAgendaDAO() {
		AgendaDAO agendaDAO = new AgendaDAOJdbcImpl();
		return agendaDAO;
	}
}
