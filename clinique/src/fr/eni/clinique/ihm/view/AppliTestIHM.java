package fr.eni.clinique.ihm.view;

import java.util.regex.Pattern;

import javax.swing.SwingUtilities;

import fr.eni.clinique.ihm.regex.Validator;

public class AppliTestIHM {
	
	public static void main(String[] args) {
		Validator valid = new Validator();
		System.out.println(valid.patternTatouage("8 ARG 854"));
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new WindowClients();
			}
		});
	}
}