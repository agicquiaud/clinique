package fr.eni.clinique.ihm.controller;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bll.AnimalManager;
import fr.eni.clinique.bll.AnimalManagerSingleton;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bll.ClientsManagerSingleton;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;

public class ControllerAnimaux {

	private AnimalManager mgerAnimal;
	private ClientsManager mgerClient;
	private List<Animaux> liste;
	private Animaux animal;

	public ControllerAnimaux() {
		mgerAnimal = AnimalManagerSingleton.getinstance(); //Instance AnimalImpl
		mgerClient = ClientsManagerSingleton.getinstance();
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
	
	public void addAnimal(String nom, String sexe, String couleur, String race, String espece,
			String codeClient, String tatouage) {
		animal = new Animaux(nom, sexe, couleur, race, espece, Integer.parseInt(codeClient), tatouage, false);
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
	
	public List<String> getAnimalById(String id){
		
		List<String> list = new ArrayList<String>();
		
		animal = mgerAnimal.animalById(Integer.parseInt(id));
		
		list.add(animal.getNom());
		list.add(animal.getCouleur());
		list.add(animal.getTatouage());
		list.add(animal.getAntecedents());
		list.add(animal.getSexe());
		list.add(animal.getEspece());
		list.add(animal.getRace());
		
		
		return list;
	}
	
	public Animaux[] getAnimalByIdClient(Integer id){
		List<Animaux> str;
		str = mgerAnimal.animalByIdClient(id);
		System.out.println(str.size());
		Animaux[] tabAnimaux = new Animaux[str.size()];
		System.out.println(tabAnimaux.length );
		for (Animaux animaux : str) {
			System.out.println(str.lastIndexOf(animaux)+1);
			tabAnimaux[str.lastIndexOf(animaux)] = animaux;
		}
		System.out.println(tabAnimaux[0]);
		return tabAnimaux;
	}
	
	public void removeAnimal(String codeanimal) {
		animal = mgerAnimal.animalById(Integer.parseInt(codeanimal));
		mgerAnimal.delete(animal);
	}
	
	public void updateClient(String codeAnimal, String nom, String sexe, String couleur, String race, String espece,
			String codeClient, String antecedent, String tatouage) {
		animal = new Animaux(Integer.parseInt(codeAnimal), nom, sexe, couleur, race, espece, Integer.parseInt(codeClient), tatouage, antecedent, false);
		mgerAnimal.update(animal);
	}

	public void addAnimalByNomClient(String nom, String sexe, String couleur, String race, String espece,
			String NomPrenomClient, String tatouage) {
		String [] PrenomNom = NomPrenomClient.split(" ");
		Clients client = mgerClient.getClientByNomPrenom(PrenomNom[0], PrenomNom[1]);
		animal = new Animaux(nom, sexe, couleur, race, espece, client.getCodeClient(), tatouage, false);
		System.out.println(animal.toString());
		mgerAnimal.insert(animal);
	
	}
	
	public Object[] getAnimalAndMaitre(String id){
		Object tab [] = new Object[2];
		tab[1] = mgerAnimal.animalById(Integer.parseInt(id));
		tab[2] = mgerClient.getClientById(((Animaux) tab[1]).getCodeClient());
				
		return tab;
	}
	
	
}




