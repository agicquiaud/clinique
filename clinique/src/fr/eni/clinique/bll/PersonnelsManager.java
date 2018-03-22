package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.User;

public interface PersonnelsManager {
	
	/**
	 * Appelle la DAL pour ajouter un personnel dans la base de donn�es
	 * @param User p
	 * @throws BLLException
	 */
	public void add(User p) throws BLLException;
	
	/**
	 * Appelle la DAL pour archiver un personnel dans la base de donn�es
	 * @param User p
	 * @throws BLLException
	 */
	public void archive(User p) throws BLLException;
	
	/**
	 * Appelle la DAL pour modifier le mot de passe d'un personnel dans la base de donn�es
	 * @param User p
	 * @throws BLLException
	 */
	public void resetMotDePasse(User p) throws BLLException;
	
	/**
	 * Appelle la DAL pour r�cup�rer un personnel par son nom dans la base de donn�es
	 * @param String nom
	 * @return User
	 * @throws BLLException
	 */
	public User getUser(String nom) throws BLLException;
	
	/**
	 * Appelle la DAL pour r�cup�rer tout les personnels dans la base de donn�es
	 * @return List<User>
	 * @throws BLLException
	 */
	public List<User> getAll() throws BLLException;
	
	/**
	 * Appelle la DAL pour r�cup�rer tout les v�t�rinaires dans la base de donn�es
	 * @return List<User>
	 * @throws BLLException
	 */
	public List<User> getVeterinaires() throws BLLException;	
}
