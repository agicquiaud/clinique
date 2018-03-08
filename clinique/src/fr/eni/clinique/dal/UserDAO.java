package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.User;

public interface UserDAO {		
	//Sélectionner tous les personnels 
	public List<User> selectAll() throws DALException;
	
	//Modifier les attributs d'un personnel connu en BDD
	public void update(User data) throws DALException;
	
	//Insérer un nouveau personnel
	public void insert(User data) throws DALException;
	
	//Supprimer un personnel
	public void delete(int id) throws DALException;
	
	//Selectioner un personnel par son nom
	public User selectByNom(String nom) throws DALException;
		
	//Selectionner du personnels par leur role
	public List<User> selectByPoste(String role) throws DALException;
}
