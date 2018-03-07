package fr.eni.clinique.ihm.login;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

public class WindowGestionPersonnels {

	private JFrame frameGestionPersonnel;
	private JTable table;

	/**
	 * Create the application.
	 */
	public WindowGestionPersonnels() {
		frameGestionPersonnel = new JFrame();
		frameGestionPersonnel.setTitle("Gestion Personnel");
		frameGestionPersonnel.setBounds(100, 100, 450, 300);
		frameGestionPersonnel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGestionPersonnel.setVisible(true);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 34, 25, 112, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 41, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		frameGestionPersonnel.getContentPane().setLayout(gridBagLayout);
		
		JButton btnAjouter = new JButton("AJOUTER");
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 5);
		gbc_btnAjouter.gridx = 1;
		gbc_btnAjouter.gridy = 1;
		frameGestionPersonnel.getContentPane().add(btnAjouter, gbc_btnAjouter);
		
		JButton btnSupprimer = new JButton("SUPPRIMER");
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimer.gridx = 2;
		gbc_btnSupprimer.gridy = 1;
		frameGestionPersonnel.getContentPane().add(btnSupprimer, gbc_btnSupprimer);
		
		JButton btnReinitialiser = new JButton("REINITIALISER");
		GridBagConstraints gbc_btnReinitialiser = new GridBagConstraints();
		gbc_btnReinitialiser.insets = new Insets(0, 0, 5, 5);
		gbc_btnReinitialiser.gridx = 3;
		gbc_btnReinitialiser.gridy = 1;
		frameGestionPersonnel.getContentPane().add(btnReinitialiser, gbc_btnReinitialiser);
		String[] entetes = {"Nom", "Role", "Mot de passe"};
		Object[][] donnee = new ControllerPersonnels().getList();
		
		table = new JTable(donnee, entetes);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.gridheight = 5;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 2;
		frameGestionPersonnel.getContentPane().add(table, gbc_table);
		
		JLabel lblNewLabelGP = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabelGP = new GridBagConstraints();
		gbc_lblNewLabelGP.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabelGP.gridwidth = 3;
		gbc_lblNewLabelGP.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabelGP.gridx = 1;
		gbc_lblNewLabelGP.gridy = 7;
		frameGestionPersonnel.getContentPane().add(lblNewLabelGP, gbc_lblNewLabelGP);
	}

}
