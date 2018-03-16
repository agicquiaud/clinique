package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.RendezVous;

public interface AgendaManager {
	
	public void insert(RendezVous pRdv);
	public void update(RendezVous pRdv);
	public void delete(RendezVous pRdv);
	public List<RendezVous> getAll();
	public List<RendezVous> RdvByIdAnimal(Integer id);
	public List<RendezVous> RdvByIdVet(Integer id);
	public List<RendezVous> getRdvVetByDay(RendezVous prdv);
	
}
