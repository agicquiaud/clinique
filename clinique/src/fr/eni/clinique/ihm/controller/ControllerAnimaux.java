package fr.eni.clinique.ihm.controller;

import fr.eni.clinique.bo.Animaux;

public interface ControllerAnimaux {
	
	public Object[][] getList();
	public Object[][] getListByClient(String id);
	public void addAnimal(String nom, String sexe, String couleur, String race, String espece,
			String codeClient, String antecedents, String tatouage);
	public String[] getRace (String Espece);
	public String[] getEspece ();
	public Animaux getAnimalById(String id);
	public Animaux[] getAnimalByIdClient(Integer id);
	public void removeAnimal(Integer codeanimal);
	public void updateClient(String codeAnimal, String nom, String sexe, String couleur, String race, String espece,
			String codeClient, String antecedent, String tatouage);
	public void addAnimalByNomClient(String nom, String sexe, String couleur, String race, String espece,
			String NomPrenomClient, String antecedents, String tatouage);
	public Object[] getAnimalAndMaitre(String id);
	public void addRace(String race, String espece);
}
