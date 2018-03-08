package fr.eni.clinique.bll;

import java.util.List;

public interface ClientsUtil {
	public List<fr.eni.clinique.bo.Clients> getAll();
	public fr.eni.clinique.bo.Clients getClient(String nom);
	public void insert(fr.eni.clinique.bo.Clients client);
	public void update (fr.eni.clinique.bo.Clients client);
	public void delete (Integer id);
}
