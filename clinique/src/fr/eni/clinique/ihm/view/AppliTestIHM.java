package fr.eni.clinique.ihm.view;

import java.util.regex.Pattern;

import javax.swing.SwingUtilities;

import fr.eni.clinique.ihm.regex.Validator;

public class AppliTestIHM {
	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new WindowClients();
			}
		});
	}
}