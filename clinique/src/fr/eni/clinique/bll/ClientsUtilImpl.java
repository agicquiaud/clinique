package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.dal.ClientDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.User;

public class ClientsUtilImpl implements ClientsUtil {
	private ClientDAO con = new DAOFactory().getClientDAO();
	List<Clients> liste;
	Clients clients;
	
	@Override
	public List<Clients> getAll() {
		try {
			liste = con.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
		}
		for (Clients client : liste) {
			if(client.getArchive() == true){
				liste.remove(client);
			}
		}
		return liste;
	}

	@Override
	public List<Clients> getClientByNom(String nom) {
		try {
			liste = con.selectByNom(nom);
		} catch (DALException e) {
			e.printStackTrace();
		}
		for (Clients client : liste) {
			if(client.getArchive() == true){
				liste.remove(client);
			}
		}
		return liste;
	}

	@Override
	public void insert(Clients client) {
		try {
			con.insert(client);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Clients client) {
		try {
			con.update(client);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Integer id) {
		try {
			con.delete(id);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Clients getClientById(Integer id) {
		try {
			clients = con.selectById(id);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return clients;
	}

}
