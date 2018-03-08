package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.jdbc.ClientDAOJdbcImpl;
import fr.eni.clinique.bo.Clients;

public class ClientsUtilImpl implements fr.eni.clinique.bll.ClientsUtil {
	private ClientDAOJdbcImpl con = new ClientDAOJdbcImpl();
	
	@Override
	public List<Clients> getAll() {
		List<Clients> liste = null;
		try {
			liste = con.selectAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public Clients getClient(String nom) {
		Clients cl = new Clients();
		try {
			cl = con.selectByNom(nom);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cl;
	}

	@Override
	public void insert(Clients client) {
		try {
			con.insert(client);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Clients client) {
		try {
			con.update(client);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Integer id) {
		try {
			con.delete(id);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
