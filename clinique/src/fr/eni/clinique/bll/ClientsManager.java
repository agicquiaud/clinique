package fr.eni.clinique.bll;

import java.util.List;
import fr.eni.clinique.bo.Clients;

public interface ClientsManager {
	public List<Clients> getAll() throws BLLException;
	public List<Clients> getClientByNom(String nom) throws BLLException;
	public void insert(Clients client) throws BLLException;
	public void update (Clients client) throws BLLException;
	public void delete (Integer id) throws BLLException;
	public Clients getClientById(Integer id) throws BLLException;
	public Clients getClientByNomPrenom(String Prenom, String Nom) throws BLLException;
}
