package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Animaux;

public interface Animal {
	public void insert(Animaux animal);
	public void update (Animaux animal);
	public void delete (Integer id);
	public List<Animaux> getAll();
	public Animaux animalById(Integer id);
	public List<Animaux> clientById(Integer id);
	public String[] bllRace(String espece);
}
