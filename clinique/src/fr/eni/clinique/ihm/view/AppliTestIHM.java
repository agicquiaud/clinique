package fr.eni.clinique.ihm.view;

import javax.swing.SwingUtilities;

import fr.eni.clinique.bo.Clients;

public class AppliTestIHM {
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
<<<<<<< HEAD
				new WindowAgenda();
				
=======
				new WindowAddAnimal(new Clients());
				
>>>>>>> branch 'master' of https://github.com/agicquiaud/clinique.git
			}
		});
	}
}