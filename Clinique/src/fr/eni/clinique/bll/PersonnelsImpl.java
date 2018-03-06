package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.User;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;
import fr.eni.clinique.dal.UserDAO;

public class PersonnelsImpl implements Personnels{
	private UserDAO con = new DAOFactory().getUserDAO();
	private User user;
	private List<User> liste;
	
	@Override
	public void add(User p) {
		try {
			con.insert(p);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void archive(User p) {
		try {
			p.setHide(0);
			con.update(p);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void resetMotDePasse(User p) {
		try {
			con.update(p);
		} catch (DALException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User getUser(String nom) {
		try {
			user = con.selectByNom(nom);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAll() {
		try {
			liste = con.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
}
