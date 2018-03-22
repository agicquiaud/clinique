package fr.eni.clinique.bll;

import java.util.Date;
import java.util.List;

import fr.eni.clinique.bo.RendezVous;

public interface AgendaManager {
	
	public void insert(RendezVous pRdv) throws BLLException;
	public void update(RendezVous pRdv) throws BLLException;
	public void delete(RendezVous pRdv) throws BLLException;
	public List<RendezVous> getAll() throws BLLException;
	public List<RendezVous> RdvByIdAnimal(Integer id) throws BLLException;
	public List<RendezVous> RdvByIdVet(Integer id) throws BLLException;
	public List<RendezVous> getRdvVetByDay(RendezVous prdv) throws BLLException;
	public RendezVous getRdvByDateCodeVet(Integer Codevet, Date date) throws BLLException;
	
}
