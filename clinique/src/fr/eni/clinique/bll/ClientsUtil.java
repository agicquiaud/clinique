package fr.eni.clinique.bll;

import java.util.List;
import fr.eni.clinique.bo.Clients;

public interface ClientsUtil {
	public List<Clients> getAll();
	public List<Clients> getClientByNom(String nom);
	public void insert(Clients client);
	public void update (Clients client);
	public void delete (Integer id);
	public Clients getClientById(Integer id);
	public Clients getClientByNomPrenom(String Prenom, String Nom);
}
