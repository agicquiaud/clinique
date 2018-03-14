package fr.eni.clinique.ihm.login;

import java.util.List;

import fr.eni.clinique.bll.Animal;
import fr.eni.clinique.bll.AnimalSingleton;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;

public class ControllerAnimaux {

	private Animal mgerAnimal;
	private List<Animaux> liste;
	private Animaux animal;

	public ControllerAnimaux() {
		mgerAnimal = AnimalSingleton.getinstance();
	}
	
	public Object[][] getList() {
		liste = mgerAnimal.getAll();
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
	
	public Object[][] getListByClient(String id) {
		liste = mgerAnimal.animalByIdClient(Integer.parseInt(id));
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
	
	public void addAnimal(String codeAnimal, String nom, String sexe, String couleur, String race, String espece,
			String codeClient, String tatouage) {
		animal = new Animaux(Integer.parseInt(codeAnimal), nom, sexe, couleur, race, espece, Integer.parseInt(codeClient), tatouage, false);
		System.out.println(animal.toString());
		mgerAnimal.insert(animal);
	}
	
	public String[] getRace (String Espece){
		String tab [] = mgerAnimal.getRace(Espece);
		return tab;
	}
	
	public String[] getEspece (){
		String tab [] = mgerAnimal.getEspece();
		return tab;
	}
	
	public void removeAnimal(String codeanimal) {
		animal = mgerAnimal.animalById(Integer.parseInt(codeanimal));
	}
	
	public void updateClient(String codeAnimal, String nom, String sexe, String couleur, String race, String espece,
			String codeClient, String tatouage) {
		animal = new Animaux(Integer.parseInt(codeAnimal), nom, sexe, couleur, race, espece, Integer.parseInt(codeClient), tatouage, false);
		mgerAnimal.update(animal);
	}
}




