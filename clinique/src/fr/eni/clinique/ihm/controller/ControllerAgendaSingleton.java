package fr.eni.clinique.ihm.controller;

public class ControllerAgendaSingleton {
	private static ControllerAgenda instance;

	private ControllerAgendaSingleton() {
	}

	public static ControllerAgenda getinstance() {
		if (instance == null) {
			instance = new ControllerAgendaImpl();
		}
		return instance;
	}
}
