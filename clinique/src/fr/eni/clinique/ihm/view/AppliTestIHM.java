package fr.eni.clinique.ihm.view;

import javax.swing.SwingUtilities;

import fr.eni.clinique.ihm.regex.Validator;

public class AppliTestIHM {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new WindowPriseDeRendezVous();
			}
		});
	}
}