package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Animaux;

public interface AnimalManager {
	public void insert(Animaux animal) throws BLLException;
	public void update (Animaux animal) throws BLLException;
	public void delete (Animaux animal) throws BLLException;
	public List<Animaux> getAll() throws BLLException;
	public Animaux animalById(Integer id) throws BLLException;
	public List<Animaux> animalByIdClient(Integer id) throws BLLException;
	public String [] getRace (String espece) throws BLLException;
	public String [] getEspece () throws BLLException;
	public void insertRace(String race, String espece) throws BLLException;
}
