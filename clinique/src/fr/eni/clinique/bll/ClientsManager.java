package fr.eni.clinique.bll;

import java.util.List;
import fr.eni.clinique.bo.Clients;

public interface ClientsManager {
	
	/**
	 * Appelle la DAL pour r�cup�rer tout les clients dans la base de donn�es
	 * @return List<Clients>
	 * @throws BLLException
	 */
	public List<Clients> getAll() throws BLLException;
	
	/**
	 * Appelle la DAL pour r�cup�rer tout les clients avec le meme nom ou pr�nom dans la base de donn�es
	 * @param String nom
	 * @return List<Clients>
	 * @throws BLLException
	 */
	public List<Clients> getClientByNom(String nom) throws BLLException;
	
	/**
	 * Appelle la DAL pour ajouter un client dans la base de donn�es
	 * @param Clients client
	 * @throws BLLException
	 */
	public void insert(Clients client) throws BLLException;
	
	/**
	 * Appelle la DAL pour modifier un client dans la base de donn�es
	 * @param Clients client
	 * @throws BLLException
	 */
	public void update (Clients client) throws BLLException;
	
	/**
	 * Appelle la DAL pour supprimer un client avec son id dans la base de donn�es
	 * @param Integer id
	 * @throws BLLException
	 */
	public void delete (Integer id) throws BLLException;
	
	/**
	 * Appelle la DAL pour r�cup�rer un client par son id dans la base de donn�es
	 * @param Integer id
	 * @return Clients
	 * @throws BLLException
	 */
	public Clients getClientById(Integer id) throws BLLException;
	
	/**
	 * Appelle la DAL pour r�cup�rer un client par son nom et prenom dans la base de donn�es
	 * @param String Prenom
	 * @param String Nom
	 * @return Clients
	 * @throws BLLException
	 */
	public Clients getClientByNomPrenom(String Prenom, String Nom) throws BLLException;
}
