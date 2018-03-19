package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Animaux;

public interface AnimalManager {
	public void insert(Animaux animal);
	public void update (Animaux animal);
	public void delete (Animaux animal);
	public List<Animaux> getAll();
	public Animaux animalById(Integer id);
	public List<Animaux> animalByIdClient(Integer id);
	public String [] getRace (String espece);
	public String [] getEspece ();
	public void insertRace(String race, String espece);
}
