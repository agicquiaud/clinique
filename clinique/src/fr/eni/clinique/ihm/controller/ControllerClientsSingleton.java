package fr.eni.clinique.ihm.controller;

public class ControllerClientsSingleton {
	private static ControllerClients instance;

	private ControllerClientsSingleton() {
	}

	public static ControllerClients  getinstance() {
		if (instance == null) {
			instance = new ControllerClientsImpl();
		}
		return instance;
	}
}
