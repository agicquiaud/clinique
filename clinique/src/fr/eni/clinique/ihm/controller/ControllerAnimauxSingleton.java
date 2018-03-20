package fr.eni.clinique.ihm.controller;


public class ControllerAnimauxSingleton {
	private static ControllerAnimaux instance;

	private ControllerAnimauxSingleton() {
	}

	public static ControllerAnimaux getinstance() {
		if (instance == null) {
			instance = new ControllerAnimauxImpl();
		}
		return instance;
	}
}
