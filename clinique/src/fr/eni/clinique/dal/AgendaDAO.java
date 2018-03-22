package fr.eni.clinique.dal;

import java.util.Date;
import java.util.List;

import fr.eni.clinique.bo.RendezVous;

public interface AgendaDAO {
	
	public List<RendezVous> selectAll() throws DALException;
	
	public void update(RendezVous data) throws DALException;
	
	public void insert(RendezVous data) throws DALException;
	
	public void delete(RendezVous data) throws DALException;
	
	public List<RendezVous> selectByHour(Date date) throws DALException;
	
	public List<RendezVous> selectByDay(Date date) throws DALException;
	
	public List<RendezVous> selectByIdAnimal(Integer id) throws DALException;
	
	public List<RendezVous> selectByIdVet(Integer id) throws DALException;
	
	public List<RendezVous> selectDayByVet (Date date, Integer id) throws DALException;

	public Integer selectCodeAnimalByRdv(Date date, Integer idVet) throws DALException;
	
}
