package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.User;

public interface UserDAO {		
		//Sélectionner tous les articles 
		public List<User> selectAll() throws DALException;
		
		//Modifier les attributs d'un article connu en BD
		public void update(User data) throws DALException;
		
		//Insérer un nouvel article
		public void insert(User data) throws DALException;
		
		//Supprimer un article
		public void delete(int id) throws DALException;
		
		public User selectByNom(String nom) throws DALException;
}
