package fr.eni.clinique.ihm.view;

import javax.swing.SwingUtilities;

public class AppliTestIHM {
	
	public static void main(String[] args) {
		String ronan ="";
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				new WindowLogin();
			}
		});
	}
}