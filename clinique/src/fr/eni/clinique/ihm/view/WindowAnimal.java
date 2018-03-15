package fr.eni.clinique.ihm.view;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import fr.eni.clinique.ihm.controller.ControllerAnimaux;
import fr.eni.clinique.ihm.controller.ControllerClients;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowAnimal {

	private JFrame EditAnimal;
	private JFrame AddAnimal;
	private JFrame frame;
	private JTable table_1;
	private JTable table_2;
	private JTextField textFieldNomAnimal;
	private JTextField textFieldCouleurAnimal;
	private JTextField textFieldTatouageAnimal;
	private ControllerAnimaux controlleranimal;
	private ControllerClients controller;
	private JTextField textFieldAntecedentsAnimal;
	private JTextField textFieldNomAnimalEditAnimal;
	private JTextField textFieldCouleurEditAnimal;
	private JTextField textFieldTatouageEditAnimal;
	private JTextField textFieldAntecedentsEditAnimal;
	private JTextField textFieldSearch;

	public WindowAnimal() {
		controller = new ControllerClients();
		controlleranimal = new ControllerAnimaux();
		frame = new JFrame();
		frame.setTitle("Gestion Clients");
		frame.setBounds(100, 100, 800, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 23, 66, 135, 0, 0, 53, 70, 83, 104, 69, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 20, 0, 0, 232, 38, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JLabel lblClient = new JLabel("Client :");
		GridBagConstraints gbc_lblClient = new GridBagConstraints();
		gbc_lblClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblClient.gridx = 1;
		gbc_lblClient.gridy = 1;
		frame.getContentPane().add(lblClient, gbc_lblClient);

		textFieldSearch = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		frame.getContentPane().add(textFieldSearch, gbc_textField);
		textFieldSearch.setColumns(10);

		JButton btnSearchClient = new JButton("Rechercher");
		GridBagConstraints gbc_btnSearchClient = new GridBagConstraints();
		gbc_btnSearchClient.gridwidth = 2;
		gbc_btnSearchClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearchClient.gridx = 3;
		gbc_btnSearchClient.gridy = 1;
		frame.getContentPane().add(btnSearchClient, gbc_btnSearchClient);

		JButton btnAddClient = new JButton("Ajouter");
		GridBagConstraints gbc_btnAddClient = new GridBagConstraints();
		gbc_btnAddClient.fill = GridBagConstraints.VERTICAL;
		gbc_btnAddClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddClient.gridx = 5;
		gbc_btnAddClient.gridy = 1;
		frame.getContentPane().add(btnAddClient, gbc_btnAddClient);

		JButton btnDeleteClient = new JButton("Supprimer");
		GridBagConstraints gbc_btnDeleteClient = new GridBagConstraints();
		gbc_btnDeleteClient.anchor = GridBagConstraints.WEST;
		gbc_btnDeleteClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteClient.gridx = 6;
		gbc_btnDeleteClient.gridy = 1;
		frame.getContentPane().add(btnDeleteClient, gbc_btnDeleteClient);
		
				JButton btnEditClient = new JButton("Editer");
				GridBagConstraints gbc_btnEditClient = new GridBagConstraints();
				gbc_btnEditClient.gridwidth = 2;
				gbc_btnEditClient.insets = new Insets(0, 0, 5, 5);
				gbc_btnEditClient.gridx = 8;
				gbc_btnEditClient.gridy = 1;
				frame.getContentPane().add(btnEditClient, gbc_btnEditClient);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		String[] entetes1 = { "CodeClient", "Prenom", "Nom", "Code Postal", "Ville" };
		Object[][] donnee1 = controller.getList();
		table_1 = new JTable(donnee1, entetes1);
		scrollPane.setViewportView(table_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridwidth = 4;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.gridx = 6;
		gbc_scrollPane_1.gridy = 3;
		frame.getContentPane().add(scrollPane_1, gbc_scrollPane_1);
		String[] entetes2 = { "CodeAnimal", "Nom", "Sexe", "Couleur", "Race", "Espece" };
		Object[][] donnee2 = controlleranimal.getList();
		table_2 = new JTable(donnee2, entetes2);
		scrollPane_1.setViewportView(table_2);
		
		JLabel lblError = new JLabel("Erreur, veuillez selectionner un client pour le supprimer");
		lblError.setForeground(Color.RED);
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridwidth = 2;
		gbc_lblError.insets = new Insets(0, 0, 0, 5);
		gbc_lblError.gridx = 1;
		gbc_lblError.gridy = 4;
		frame.getContentPane().add(lblError, gbc_lblError);

		JLabel lblAnimaux = new JLabel("Animal : ");
		GridBagConstraints gbc_lblAnimaux = new GridBagConstraints();
		gbc_lblAnimaux.insets = new Insets(0, 0, 0, 5);
		gbc_lblAnimaux.gridx = 5;
		gbc_lblAnimaux.gridy = 4;
		frame.getContentPane().add(lblAnimaux, gbc_lblAnimaux);

		JButton btnAddAnimal = new JButton("Ajouter");
		btnAddAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnAddAnimal = new GridBagConstraints();
		gbc_btnAddAnimal.insets = new Insets(0, 0, 0, 5);
		gbc_btnAddAnimal.gridx = 6;
		gbc_btnAddAnimal.gridy = 4;
		frame.getContentPane().add(btnAddAnimal, gbc_btnAddAnimal);

		JButton btnDeleteAnimal = new JButton("Supprimer");
		GridBagConstraints gbc_btnDeleteAnimal = new GridBagConstraints();
		gbc_btnDeleteAnimal.insets = new Insets(0, 0, 0, 5);
		gbc_btnDeleteAnimal.gridx = 7;
		gbc_btnDeleteAnimal.gridy = 4;
		frame.getContentPane().add(btnDeleteAnimal, gbc_btnDeleteAnimal);

		JButton btnEditAnimal = new JButton("Editer");
		GridBagConstraints gbc_btnEditAnimal = new GridBagConstraints();
		gbc_btnEditAnimal.gridwidth = 2;
		gbc_btnEditAnimal.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditAnimal.gridx = 8;
		gbc_btnEditAnimal.gridy = 4;
		frame.getContentPane().add(btnEditAnimal, gbc_btnEditAnimal);

	}
}
