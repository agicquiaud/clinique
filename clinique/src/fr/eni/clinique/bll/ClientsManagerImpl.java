package fr.eni.clinique.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.ClientDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;

public class ClientsManagerImpl implements ClientsManager {
	private ClientDAO con = new DAOFactory().getClientDAO();
	List<Clients> liste;
	Clients clients;

	@Override
	public List<Clients> getAll() throws BLLException {
		List<Clients> listereturn = new ArrayList<Clients>();
		try {
			liste = con.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Clients getAll - ", e);
		}
		for (Clients client : liste) {
			if (client.getArchive() == false) {
				listereturn.add(client);
			}
		}
		return listereturn;
	}

	@Override
	public List<Clients> getClientByNom(String nom) throws BLLException {
		List<Clients> listereturn = new ArrayList<Clients>();
		try {
			liste = con.selectByNom(nom);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Clients getClientByNom - nom=" + nom, e);
		}
		for (Clients client : liste) {
			if (client.getArchive() == false) {
				listereturn.add(client);
			}
		}
		return listereturn;
	}

	@Override
	public void insert(Clients client) throws BLLException {
		try {
			con.insert(client);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Clients insert - client=" + client, e);
		}

	}

	@Override
	public void update(Clients client) throws BLLException {
		try {
			con.update(client);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Clients update - client=" + client, e);
		}

	}

	@Override
	public void delete(Integer id) throws BLLException {
		try {
			con.delete(id);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Clients delete - id=" + id, e);
		}

	}

	@Override
	public Clients getClientById(Integer id) throws BLLException {
		try {
			clients = con.selectById(id);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Clients getClientById - id=" + id, e);
		}
		return clients;
	}

	@Override
	public Clients getClientByNomPrenom(String Prenom, String Nom) throws BLLException {
		try {
			clients = con.selectByNomPrenom(Prenom, Nom);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Clients getClientByNomPrenom - nom=" + Nom + " prenom=" + Prenom, e);
		}
		return clients;
	}

}
