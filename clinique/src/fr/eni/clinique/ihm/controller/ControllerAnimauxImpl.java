package fr.eni.clinique.ihm.controller;

import java.util.List;
import java.util.Observable;

import fr.eni.clinique.bll.AnimalManager;
import fr.eni.clinique.bll.AnimalManagerSingleton;
import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bll.ClientsManager;
import fr.eni.clinique.bll.ClientsManagerSingleton;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;

public class ControllerAnimauxImpl extends Observable implements ControllerAnimaux {

	private AnimalManager mgerAnimal;
	private ClientsManager mgerClient;
	private List<Animaux> liste;
	private Animaux animal;

	ControllerAnimauxImpl() {
		mgerAnimal = AnimalManagerSingleton.getinstance(); // Instance AnimalImpl
		mgerClient = ClientsManagerSingleton.getinstance();
	}

	public Object[][] getList() {
		try {
			liste = mgerAnimal.getAll();
		} catch (BLLException e) {
			e.getMessage();
		}
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
		try {
			liste = mgerAnimal.animalByIdClient(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			System.out.println("Erreur ControllerAnimaux NumberFormatException - getListByClient");
		} catch (BLLException e) {
			e.getMessage();
		}
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

	public void addAnimal(String nom, String sexe, String couleur, String race, String espece, String codeClient,
			String antecedents, String tatouage) {
		animal = new Animaux(nom, sexe, couleur, race, espece, Integer.parseInt(codeClient), antecedents, tatouage,
				false);
		try {
			mgerAnimal.insert(animal);
		} catch (BLLException e) {
			e.getMessage();
		}

		setChanged();
		notifyObservers(animal);
	}

	public String[] getRace(String Espece) {
		String tab[] = null;
		try {
			tab = mgerAnimal.getRace(Espece);
		} catch (BLLException e) {
			e.getMessage();
		}
		return tab;
	}

	public String[] getEspece() {
		String tab[] = null;
		try {
			tab = mgerAnimal.getEspece();
		} catch (BLLException e) {
			e.getMessage();
		}
		return tab;
	}

	public Animaux getAnimalById(String id) {
		try {
			animal = mgerAnimal.animalById(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			System.out.println("Erreur ControllerAnimaux NumberFormatException - getAnimalById");
		} catch (BLLException e) {
			e.getMessage();
		}
		return animal;
	}

	public Animaux[] getAnimalByIdClient(Integer id) {
		List<Animaux> str = null;
		Integer longueurListe;
		try {
			str = mgerAnimal.animalByIdClient(id);
		} catch (BLLException e) {
			e.getMessage();
		}
		if (str.size() == 0) {
			longueurListe = str.size() + 1;
		} else {
			longueurListe = str.size();
		}
		Animaux[] tabAnimaux = new Animaux[longueurListe];
		for (Animaux animaux : str) {
			tabAnimaux[str.lastIndexOf(animaux)] = animaux;
		}
		return tabAnimaux;
	}

	public void removeAnimal(Integer codeanimal) {
		try {
			animal = mgerAnimal.animalById(codeanimal);
		} catch (BLLException e) {
			e.getMessage();
		}
		try {
			mgerAnimal.delete(animal);
		} catch (BLLException e) {
			e.getMessage();
		}

		setChanged();
		notifyObservers(animal);
	}

	public void updateAnimal(String codeAnimal, String nom, String sexe, String couleur, String race, String espece,
			String codeClient, String antecedent, String tatouage) {
		animal = new Animaux(Integer.parseInt(codeAnimal), nom, sexe, couleur, race, espece,
				Integer.parseInt(codeClient), tatouage, antecedent, false);
		try {
			mgerAnimal.update(animal);
		} catch (BLLException e) {
			e.getMessage();
		}

		setChanged();
		notifyObservers(animal);
	}

	public void addAnimalByNomClient(String nom, String sexe, String couleur, String race, String espece,
			String NomPrenomClient, String antecedents, String tatouage) {
		String[] PrenomNom = NomPrenomClient.split(" ");
		Clients client = null;
		try {
			client = mgerClient.getClientByNomPrenom(PrenomNom[0], PrenomNom[1]);
		} catch (BLLException e) {
			e.getMessage();
		}
		animal = new Animaux(nom, sexe, couleur, race, espece, client.getCodeClient(), antecedents, tatouage, false);
		try {
			mgerAnimal.insert(animal);
		} catch (BLLException e) {
			e.getMessage();
		}

		setChanged();
		notifyObservers(animal);
	}

	public Object[] getAnimalAndMaitre(String id) {
		Object tab[] = new Object[2];
		try {
			tab[1] = mgerAnimal.animalById(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			System.out.println("Erreur ControllerAnimaux NumberFormatException - getAnimalById");
		} catch (BLLException e) {
			e.getMessage();
		}
		try {
			tab[2] = mgerClient.getClientById(((Animaux) tab[1]).getCodeClient());
		} catch (BLLException e) {
			e.getMessage();
		}

		return tab;
	}

	public void addRace(String race, String espece) {
		try {
			mgerAnimal.insertRace(race, espece);
		} catch (BLLException e) {
			e.getMessage();
		}

		setChanged();
		notifyObservers(race);
		setChanged();
		notifyObservers(espece);
	}

}