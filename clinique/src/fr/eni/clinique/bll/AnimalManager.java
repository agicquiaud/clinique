package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Animaux;

public interface AnimalManager {
	
	
	/**
	 * Appelle la DAL pour ajouter un animal dans la base de donn�es
	 * @param Animaux animal
	 * @throws BLLException
	 */
	public void insert(Animaux animal) throws BLLException;
	
	/**
	 * Appelle la DAL pour modifier un animal dans la base de donn�es
	 * @param Animaux animal
	 * @throws BLLException
	 */
	public void update (Animaux animal) throws BLLException;
	
	/**
	 * Appelle la DAL pour supprimer un animal dans la base de donn�es
	 * @param Animaux animal
	 * @throws BLLException
	 */
	public void delete (Animaux animal) throws BLLException;
	
	/**
	 * Appelle la DAL pour r�cup�rer tout les animaux dans la base de donn�es
	 * @return List<Animaux>
	 * @throws BLLException
	 */
	public List<Animaux> getAll() throws BLLException;
	
	/**
	 * Appelle la DAL pour r�cup�rer un animal par son id dans la base de donn�es
	 * @param Integer id
	 * @return Animaux 
	 * @throws BLLException
	 */
	public Animaux animalById(Integer id) throws BLLException;
	
	/**
	 * Appelle la DAL pour r�cup�rer les animaux d'un client par son id dans la base de donn�es
	 * @param Integer id
	 * @return List<Animaux>
	 * @throws BLLException
	 */
	public List<Animaux> animalByIdClient(Integer id) throws BLLException;
	
	/**
	 * Appelle la DAL pour r�cup�rer les races associ�es � une espece dans la base de donn�es
	 * @param String espece
	 * @return String[]
	 * @throws BLLException
	 */
	public String [] getRace (String espece) throws BLLException;
	
	/**
	 * Appelle la DAL pour r�cup�rer toutes les especes dans la base de donn�es
	 * @return String []
	 * @throws BLLException
	 */
	public String [] getEspece () throws BLLException;
	
	/**
	 * Appelle la DAL pour ajouter une race et/ou une espece dans la base de donn�es
	 * @param String race
	 * @param String espece
	 * @throws BLLException
	 */
	public void insertRace(String race, String espece) throws BLLException;
}
