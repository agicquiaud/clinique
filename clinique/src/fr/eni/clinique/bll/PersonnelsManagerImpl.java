package fr.eni.clinique.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.User;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.UserDAO;

public class PersonnelsManagerImpl implements PersonnelsManager {
	private UserDAO con = new DAOFactory().getUserDAO();
	private User user;
	private List<User> liste;

	@Override
	public void add(User p) throws BLLException {
		try {
			con.insert(p);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Personnel add - user=" + p, e);
		}

	}

	@Override
	public void archive(User p) throws BLLException {
		try {
			p.setArchive(true);
			con.update(p);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Personnel archive - user=" + p, e);
		}

	}

	@Override
	public void resetMotDePasse(User p) throws BLLException {
		try {
			con.update(p);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Personnel resetMotDePasse - user=" + p, e);
		}
	}

	@Override
	public User getUser(String nom) throws BLLException {
		try {
			user = con.selectByNom(nom);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Personnel getUser - nom=" + nom, e);
		}
		return user;
	}

	@Override
	public List<User> getAll() throws BLLException {
		List<User> listereturn = new ArrayList<User>();
		try {
			liste = con.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Personnel getAll - ", e);
		}
		for (User user : liste) {
			if (user.getArchive() == false) {
				listereturn.add(user);
			}
		}
		return listereturn;
	}

	public List<User> getVeterinaires() throws BLLException {
		try {
			liste = con.selectByPoste("vet");
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Personnel getVeterinaires - ", e);
		}
		return liste;
	}

}
