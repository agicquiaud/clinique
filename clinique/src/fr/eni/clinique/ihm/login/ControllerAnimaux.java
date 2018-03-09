package fr.eni.clinique.ihm.login;

import java.util.List;

import fr.eni.clinique.bll.Animal;
import fr.eni.clinique.bll.AnimalSingleton;
import fr.eni.clinique.bo.Animaux;

public class ControllerAnimaux {

	private Animal bllclients;
	private List<Animaux> liste;
	private Animaux animal;

	public ControllerAnimaux() {
		bllclients = AnimalSingleton.getinstance();

	}


}
