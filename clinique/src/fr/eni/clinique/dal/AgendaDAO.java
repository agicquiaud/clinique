package fr.eni.clinique.dal;

import java.sql.Date;
import java.util.List;

import fr.eni.clinique.bo.RendezVous;

public interface AgendaDAO {
	
	public List<RendezVous> selectAll() throws DALException;
	
	public void update(RendezVous data) throws DALException;
	
	public void insert(RendezVous data) throws DALException;
	
	public void delete(int id) throws DALException;
	
	public List<RendezVous> sqlSelectByDate(Date date) throws DALException;
}
