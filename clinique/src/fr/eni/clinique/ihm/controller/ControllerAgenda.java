package fr.eni.clinique.ihm.controller;

import java.util.List;

import fr.eni.clinique.bo.RendezVous;
import fr.eni.clinique.bo.User;

public interface ControllerAgenda {
	public void addRDV(RendezVous rdv);
	public void removeRDV(RendezVous rdv);
	public List<RendezVous> getRdv(User veto, String date, Integer heure, Integer minute);
	public Object[][] getTabAgenda(String NomVeto, String pdate);
	public RendezVous getRdvByCodeVetDate(RendezVous rdv);
	
}
