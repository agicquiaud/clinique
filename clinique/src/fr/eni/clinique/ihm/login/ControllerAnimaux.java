package fr.eni.clinique.ihm.login;

import java.util.List;

import javax.swing.SwingUtilities;

import fr.eni.clinique.bll.Animal;
import fr.eni.clinique.bll.AnimalSingleton;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;

public class ControllerAnimaux {

	private Animal bllclients;
	private List<Animaux> liste;
	private Animaux animal;

	public ControllerAnimaux() {
		bllclients = AnimalSingleton.getinstance();
	}
	
	public Object[][] getList() {
		liste = bllclients.getAll();
		Object[][] tab = new Object[liste.size()][6];
		for (int i = 0; i < liste.size(); i++) {
			tab[i][0] = liste.get(i).getCodeAnimal();
			tab[i][1] = liste.get(i).getNom();
			tab[i][2] = liste.get(i).getSexe();
			tab[i][3] = liste.get(i).getCouleur();
			tab[i][4] = liste.get(i).getRace();
			tab[i][5] = liste.get(i).getEspece();
	
		}
		return tab;
	}
	
	public void addAnimal(Integer codeAnimal, String nom, String sexe, String couleur, String race, String espece,
			Integer codeClient, String tatouage, String antecedents) {
		animal = new Animaux();
		bllclients.insert(animal);
	}
	
	public String[] getRace (String Espece){
		
		String tab [] = bllclients.bllRace(Espece);
		
		return tab;
	}


}




