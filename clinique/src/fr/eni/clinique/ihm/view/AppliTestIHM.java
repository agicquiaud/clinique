package fr.eni.clinique.ihm.view;

import javax.swing.SwingUtilities;

public class AppliTestIHM {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
<<<<<<< HEAD
			public void run() {
				new WindowClients();

=======
			public void run() {
				new WindowPriseDeRendezVous2();
>>>>>>> branch 'master' of https://github.com/agicquiaud/clinique.git
			}
		});
	}
}