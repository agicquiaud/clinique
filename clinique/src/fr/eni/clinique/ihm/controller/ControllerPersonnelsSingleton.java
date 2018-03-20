package fr.eni.clinique.ihm.controller;

public class ControllerPersonnelsSingleton {
	private static ControllerPersonnels instance;

	private ControllerPersonnelsSingleton() {
	}

	public static ControllerPersonnels getinstance() {
		if (instance == null) {
			instance = new ControllerPersonnelsImpl();
		}
		return instance;
	}
}
