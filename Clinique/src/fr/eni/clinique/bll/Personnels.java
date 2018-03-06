package fr.eni.clinique.bll;

import fr.eni.clinique.bo.User;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.jdbc.ConnexionDAOJdbcImpl;

public class Personnels implements IPersonnels{
	ConnexionDAOJdbcImpl con = new ConnexionDAOJdbcImpl();
	
	@Override
	public void add(User p) {
		try {
			con.insert(p);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void archive(User p) {
		try {
			con.delete(p.getId());
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(User p) {
		try {
			con.update(p);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void read(User p) {
		try {
			con.selectById(p.getId());
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
