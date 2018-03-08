package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Animaux;

public interface Animal {
	public void insert(Animaux animal);
	public void update (Animaux animal);
	public void delete (Animaux animal);
	public List<Animaux> getAll();
	public Animaux animalById(Integer id);
}
