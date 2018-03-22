package fr.eni.clinique.bll;

import java.util.Date;
import java.util.List;

import fr.eni.clinique.bo.RendezVous;

public interface AgendaManager {
	
	/**
	 * Appelle la DAL pour ajouter un rendez vous dans la base de données
	 * @param RendezVous pRdv
	 * @throws BLLException
	 */
	public void insert(RendezVous pRdv) throws BLLException;
	
	/**
	 * Appelle la DAL pour modifier un rendez vous dans la base de données
	 * @param RendezVous pRdv
	 * @throws BLLException
	 */
	public void update(RendezVous pRdv) throws BLLException;
	
	/**
	 * Appelle la DAL pour supprimer un rendez vous dans la base de données
	 * @param RendezVous pRdv
	 * @throws BLLException
	 */
	public void delete(RendezVous pRdv) throws BLLException;
	
	/**
	 * Appelle la DAL pour récupérer tout les rendez vous dans la base de données
	 * @return List<RendezVous>
	 * @throws BLLException
	 */
	public List<RendezVous> getAll() throws BLLException;
	
	/**
	 * Appelle la DAL pour récupérer tout les rendez vous pour un codeAnimal dans la base de données
	 * @param Integer id
	 * @return List<RendezVous>
	 * @throws BLLException
	 */
	public List<RendezVous> RdvByIdAnimal(Integer id) throws BLLException;
	
	/**
	 * Appelle la DAL pour récupérer tout les rendez vous pour un codeVeterinaire dans la base de données
	 * @param Integer id
	 * @return List<RendezVous>
	 * @throws BLLException
	 */
	public List<RendezVous> RdvByIdVet(Integer id) throws BLLException;
	
	/**
	 * Appelle la DAL pour récupérer tout les rendez vous d'un jour pour un veterinaire dans la base de données
	 * @param RendezVous prdv
	 * @return List<RendezVous>
	 * @throws BLLException
	 */
	public List<RendezVous> getRdvVetByDay(RendezVous prdv) throws BLLException;
	
	/**
	 * Appelle la DAL pour récupérer tout les rendez vous d'une heure pour un veterinaire dans la base de données
	 * @param Integer Codevet
	 * @param Date date
	 * @return RendezVous
	 * @throws BLLException
	 */
	public RendezVous getRdvByDateCodeVet(Integer Codevet, Date date) throws BLLException;
	
}
