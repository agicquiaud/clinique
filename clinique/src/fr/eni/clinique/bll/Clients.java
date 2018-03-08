package fr.eni.clinique.bll;

public interface Clients {
	public void getAll();
	public Clients getClient(String nom);
	public void insert(Clients client);
	public void update (Clients client);
	public void delete (Integer id);
}
