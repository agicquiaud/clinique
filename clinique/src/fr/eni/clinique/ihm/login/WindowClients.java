package fr.eni.clinique.ihm.login;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class WindowClients {

	private JFrame frame;
	private DefaultTableModel tableModel;
	private JTable table_1;
	private JTable table_2;
	private ControllerClients controller;
	private JTextField textField;
	private JDialog AddClient = new JDialog();
	private JDialog PopupDeleteClient = new JDialog();
	private JDialog EditClient = new JDialog();
	private JTextField textFieldNomClient;
	private JTextField textFieldPrenomClient;
	private JTextField textFieldAdresseClient;
	private JTextField textFieldCodePostalClient;
	private JTextField textFieldVilleClient;
	private JTextField textFieldNumTelClient;
	private JTextField textFieldEmailClient;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;

	public WindowClients() {
		controller = new ControllerClients();
//		frame = new JFrame();
//		frame.setTitle("Gestion Clients");
//		frame.setBounds(100, 100, 730, 470);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[] { 0, 146, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
//		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 232, 38, 0, 0 };
//		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
//				Double.MIN_VALUE };
//		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
//		frame.getContentPane().setLayout(gridBagLayout);
//
//		JPanel panel = new JPanel();
//		GridBagConstraints gbc_panel = new GridBagConstraints();
//		gbc_panel.insets = new Insets(0, 0, 5, 5);
//		gbc_panel.fill = GridBagConstraints.BOTH;
//		gbc_panel.gridx = 3;
//		gbc_panel.gridy = 0;
//		frame.getContentPane().add(panel, gbc_panel);
//
//		textField = new JTextField();
//		GridBagConstraints gbc_textField = new GridBagConstraints();
//		gbc_textField.insets = new Insets(0, 0, 5, 5);
//		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField.gridx = 1;
//		gbc_textField.gridy = 1;
//		frame.getContentPane().add(textField, gbc_textField);
//		textField.setColumns(10);
//
//		JButton btnSearchClient = new JButton("Rechercher");
//		GridBagConstraints gbc_btnSearchClient = new GridBagConstraints();
//		gbc_btnSearchClient.gridwidth = 2;
//		gbc_btnSearchClient.insets = new Insets(0, 0, 5, 5);
//		gbc_btnSearchClient.gridx = 2;
//		gbc_btnSearchClient.gridy = 1;
//		frame.getContentPane().add(btnSearchClient, gbc_btnSearchClient);
//
//		JButton btnAddClient = new JButton("Ajouter");
//		GridBagConstraints gbc_btnAddClient = new GridBagConstraints();
//		gbc_btnAddClient.insets = new Insets(0, 0, 5, 5);
//		gbc_btnAddClient.gridx = 4;
//		gbc_btnAddClient.gridy = 1;
//		frame.getContentPane().add(btnAddClient, gbc_btnAddClient);
//
//		JButton btnDeleteClient = new JButton("Supprimer");
//		GridBagConstraints gbc_btnDeleteClient = new GridBagConstraints();
//		gbc_btnDeleteClient.gridwidth = 2;
//		gbc_btnDeleteClient.insets = new Insets(0, 0, 5, 5);
//		gbc_btnDeleteClient.gridx = 5;
//		gbc_btnDeleteClient.gridy = 1;
//		frame.getContentPane().add(btnDeleteClient, gbc_btnDeleteClient);
//
//		JButton btnEditClient = new JButton("Editer");
//		GridBagConstraints gbc_btnEditClient = new GridBagConstraints();
//		gbc_btnEditClient.insets = new Insets(0, 0, 5, 5);
//		gbc_btnEditClient.gridx = 9;
//		gbc_btnEditClient.gridy = 1;
//		frame.getContentPane().add(btnEditClient, gbc_btnEditClient);
//
//		JScrollPane scrollPane = new JScrollPane();
//		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
//		gbc_scrollPane.fill = GridBagConstraints.BOTH;
//		gbc_scrollPane.gridwidth = 4;
//		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
//		gbc_scrollPane.gridx = 1;
//		gbc_scrollPane.gridy = 3;
//		frame.getContentPane().add(scrollPane, gbc_scrollPane);
//		String[] entetes1 = { "CodeClient", "Prenom", "Nom", "Code Postal", "Ville" };
//		Object[][] donnee1 = controller.getList();
//		table_1 = new JTable(donnee1, entetes1);
//		scrollPane.setViewportView(table_1);
//
//		JScrollPane scrollPane_1 = new JScrollPane();
//		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
//		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
//		gbc_scrollPane_1.gridwidth = 4;
//		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
//		gbc_scrollPane_1.gridx = 6;
//		gbc_scrollPane_1.gridy = 3;
//		frame.getContentPane().add(scrollPane_1, gbc_scrollPane_1);
//		String[] entetes2 = { "CodeAnimal", "Nom", "Sexe", "Couleur", "Race", "Espece" };
//		Object[][] donnee2 = controller.getList();
//		table_2 = new JTable(donnee2, entetes2);
//		scrollPane_1.setViewportView(table_2);
//
//		JPanel panel_1 = new JPanel();
//		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
//		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
//		gbc_panel_1.fill = GridBagConstraints.BOTH;
//		gbc_panel_1.gridx = 0;
//		gbc_panel_1.gridy = 4;
//		frame.getContentPane().add(panel_1, gbc_panel_1);
//
//		JButton btnAddAnimal = new JButton("Ajouter");
//		GridBagConstraints gbc_btnAddAnimal = new GridBagConstraints();
//		gbc_btnAddAnimal.insets = new Insets(0, 0, 5, 5);
//		gbc_btnAddAnimal.gridx = 7;
//		gbc_btnAddAnimal.gridy = 4;
//		frame.getContentPane().add(btnAddAnimal, gbc_btnAddAnimal);
//
//		JButton btnDeleteAnimal = new JButton("Supprimer");
//		GridBagConstraints gbc_btnDeleteAnimal = new GridBagConstraints();
//		gbc_btnDeleteAnimal.insets = new Insets(0, 0, 5, 5);
//		gbc_btnDeleteAnimal.gridx = 8;
//		gbc_btnDeleteAnimal.gridy = 4;
//		frame.getContentPane().add(btnDeleteAnimal, gbc_btnDeleteAnimal);
//
//		JButton btnEditAnimal = new JButton("Editer");
//		GridBagConstraints gbc_btnEditAnimal = new GridBagConstraints();
//		gbc_btnEditAnimal.insets = new Insets(0, 0, 5, 5);
//		gbc_btnEditAnimal.gridx = 9;
//		gbc_btnEditAnimal.gridy = 4;
//		frame.getContentPane().add(btnEditAnimal, gbc_btnEditAnimal);
//
//		// Modal Add Client
//		// --------------------------------------------------------------------------------------
//
//		GridBagLayout gridBagLayoutModalAddClient = new GridBagLayout();
//		gridBagLayoutModalAddClient.columnWidths = new int[] { 50, 0, 0, 0, 0, 140, 0, 0, 0, 0, 0, 100, 0 };
//		gridBagLayoutModalAddClient.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
//		gridBagLayoutModalAddClient.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0,
//				0.0, Double.MIN_VALUE };
//		gridBagLayoutModalAddClient.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
//				0.0, Double.MIN_VALUE };
//		AddClient.getContentPane().setLayout(gridBagLayoutModalAddClient);
//
//		JLabel lblAddClient = new JLabel("Nouveau Client");
//		GridBagConstraints gbc_lblAddClient = new GridBagConstraints();
//		gbc_lblAddClient.gridwidth = 8;
//		gbc_lblAddClient.insets = new Insets(0, 0, 5, 5);
//		gbc_lblAddClient.gridx = 3;
//		gbc_lblAddClient.gridy = 2;
//		AddClient.getContentPane().add(lblAddClient, gbc_lblAddClient);
//
//		JLabel lblNomClient = new JLabel("Nom");
//		GridBagConstraints gbc_lblNomClient = new GridBagConstraints();
//		gbc_lblNomClient.insets = new Insets(0, 0, 5, 5);
//		gbc_lblNomClient.gridx = 3;
//		gbc_lblNomClient.gridy = 3;
//		AddClient.getContentPane().add(lblNomClient, gbc_lblNomClient);
//
//		textFieldNomClient = new JTextField();
//		GridBagConstraints gbc_textFieldNomClient = new GridBagConstraints();
//		gbc_textFieldNomClient.gridwidth = 4;
//		gbc_textFieldNomClient.insets = new Insets(0, 0, 5, 5);
//		gbc_textFieldNomClient.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textFieldNomClient.gridx = 6;
//		gbc_textFieldNomClient.gridy = 3;
//		AddClient.getContentPane().add(textFieldNomClient, gbc_textFieldNomClient);
//
//		JLabel lblPrenomClient = new JLabel("Prenom");
//		GridBagConstraints gbc_lblPrenomClient = new GridBagConstraints();
//		gbc_lblPrenomClient.insets = new Insets(0, 0, 5, 5);
//		gbc_lblPrenomClient.gridx = 3;
//		gbc_lblPrenomClient.gridy = 4;
//		AddClient.getContentPane().add(lblPrenomClient, gbc_lblPrenomClient);
//
//		textFieldPrenomClient = new JTextField();
//		GridBagConstraints gbc_textFieldPrenomClient = new GridBagConstraints();
//		gbc_textFieldPrenomClient.gridwidth = 4;
//		gbc_textFieldPrenomClient.insets = new Insets(0, 0, 5, 5);
//		gbc_textFieldPrenomClient.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textFieldPrenomClient.gridx = 6;
//		gbc_textFieldPrenomClient.gridy = 4;
//		AddClient.getContentPane().add(textFieldPrenomClient, gbc_textFieldPrenomClient);
//
//		JLabel lblAdresseClient = new JLabel("Adresse");
//		GridBagConstraints gbc_lblAdresseClient = new GridBagConstraints();
//		gbc_lblAdresseClient.insets = new Insets(0, 0, 5, 5);
//		gbc_lblAdresseClient.gridx = 3;
//		gbc_lblAdresseClient.gridy = 5;
//		AddClient.getContentPane().add(lblAdresseClient, gbc_lblAdresseClient);
//
//		textFieldAdresseClient = new JTextField();
//		GridBagConstraints gbc_textFieldAdresseClient = new GridBagConstraints();
//		gbc_textFieldAdresseClient.gridwidth = 4;
//		gbc_textFieldAdresseClient.insets = new Insets(0, 0, 5, 5);
//		gbc_textFieldAdresseClient.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textFieldAdresseClient.gridx = 6;
//		gbc_textFieldAdresseClient.gridy = 5;
//		AddClient.getContentPane().add(textFieldAdresseClient, gbc_textFieldAdresseClient);
//
//		JLabel lblCodePostalClient = new JLabel("Code Postal");
//		GridBagConstraints gbc_lblCodePostalClient = new GridBagConstraints();
//		gbc_lblCodePostalClient.insets = new Insets(0, 0, 5, 5);
//		gbc_lblCodePostalClient.gridx = 3;
//		gbc_lblCodePostalClient.gridy = 6;
//		AddClient.getContentPane().add(lblCodePostalClient, gbc_lblCodePostalClient);
//
//		textFieldCodePostalClient = new JTextField();
//		GridBagConstraints gbc_textFieldCodePostalClient = new GridBagConstraints();
//		gbc_textFieldCodePostalClient.gridwidth = 4;
//		gbc_textFieldCodePostalClient.insets = new Insets(0, 0, 5, 5);
//		gbc_textFieldCodePostalClient.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textFieldCodePostalClient.gridx = 6;
//		gbc_textFieldCodePostalClient.gridy = 6;
//		AddClient.getContentPane().add(textFieldCodePostalClient, gbc_textFieldCodePostalClient);
//
//		JLabel lblVilleClient = new JLabel("Ville");
//		GridBagConstraints gbc_lblVilleClient = new GridBagConstraints();
//		gbc_lblVilleClient.insets = new Insets(0, 0, 5, 5);
//		gbc_lblVilleClient.gridx = 3;
//		gbc_lblVilleClient.gridy = 7;
//		AddClient.getContentPane().add(lblVilleClient, gbc_lblVilleClient);
//
//		textFieldVilleClient = new JTextField();
//		GridBagConstraints gbc_textFieldVilleClient = new GridBagConstraints();
//		gbc_textFieldVilleClient.gridwidth = 4;
//		gbc_textFieldVilleClient.insets = new Insets(0, 0, 5, 5);
//		gbc_textFieldVilleClient.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textFieldVilleClient.gridx = 6;
//		gbc_textFieldVilleClient.gridy = 7;
//		AddClient.getContentPane().add(textFieldVilleClient, gbc_textFieldVilleClient);
//
//		JLabel lblNumTelClient = new JLabel("Num. Tel");
//		GridBagConstraints gbc_lblNumTelClient = new GridBagConstraints();
//		gbc_lblNumTelClient.insets = new Insets(0, 0, 5, 5);
//		gbc_lblNumTelClient.gridx = 3;
//		gbc_lblNumTelClient.gridy = 8;
//		AddClient.getContentPane().add(lblNumTelClient, gbc_lblNumTelClient);
//
//		textFieldNumTelClient = new JTextField();
//		GridBagConstraints gbc_textFieldNumTelClient = new GridBagConstraints();
//		gbc_textFieldNumTelClient.gridwidth = 4;
//		gbc_textFieldNumTelClient.insets = new Insets(0, 0, 5, 5);
//		gbc_textFieldNumTelClient.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textFieldNumTelClient.gridx = 6;
//		gbc_textFieldNumTelClient.gridy = 8;
//		AddClient.getContentPane().add(textFieldNumTelClient, gbc_textFieldNumTelClient);
//
//		JLabel lblEmailClient = new JLabel("Email");
//		GridBagConstraints gbc_lblEmailClient = new GridBagConstraints();
//		gbc_lblEmailClient.insets = new Insets(0, 0, 5, 5);
//		gbc_lblEmailClient.gridx = 3;
//		gbc_lblEmailClient.gridy = 9;
//		AddClient.getContentPane().add(lblEmailClient, gbc_lblEmailClient);
//
//		textFieldEmailClient = new JTextField();
//		GridBagConstraints gbc_textFieldEmailClient = new GridBagConstraints();
//		gbc_textFieldEmailClient.gridwidth = 4;
//		gbc_textFieldEmailClient.insets = new Insets(0, 0, 5, 5);
//		gbc_textFieldEmailClient.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textFieldEmailClient.gridx = 6;
//		gbc_textFieldEmailClient.gridy = 9;
//		AddClient.getContentPane().add(textFieldEmailClient, gbc_textFieldEmailClient);
//
//		JButton btnValiderModalAddClient = new JButton("VALIDER");
//		GridBagConstraints gbc_btnValiderModalAdd = new GridBagConstraints();
//		gbc_btnValiderModalAdd.insets = new Insets(0, 0, 5, 5);
//		gbc_btnValiderModalAdd.gridx = 8;
//		gbc_btnValiderModalAdd.gridy = 10;
//		AddClient.getContentPane().add(btnValiderModalAddClient, gbc_btnValiderModalAdd);
//
//		btnValiderModalAddClient.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//
//			}
//		});
//
//		JButton btnAnnulerModalCancelClient = new JButton("ANNULER");
//		GridBagConstraints gbc_btnAnnulerModalCancelClient = new GridBagConstraints();
//		gbc_btnAnnulerModalCancelClient.insets = new Insets(0, 0, 5, 5);
//		gbc_btnAnnulerModalCancelClient.gridx = 9;
//		gbc_btnAnnulerModalCancelClient.gridy = 10;
//		AddClient.getContentPane().add(btnAnnulerModalCancelClient, gbc_btnAnnulerModalCancelClient);
//
//		// Popup Remove Client
//		// --------------------------------------------------------------------------------------
//
//		GridBagLayout gbl_PopupDeleteClient = new GridBagLayout();
//		gbl_PopupDeleteClient.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
//		gbl_PopupDeleteClient.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
//		gbl_PopupDeleteClient.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
//				Double.MIN_VALUE };
//		gbl_PopupDeleteClient.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
//		PopupDeleteClient.setLayout(gbl_PopupDeleteClient);
//
//		JLabel lbltesvousSurDe = new JLabel("Etes-vous sur de vouloir supprimer ce client ?");
//		GridBagConstraints gbc_lbltesvousSurDe = new GridBagConstraints();
//		gbc_lbltesvousSurDe.insets = new Insets(0, 0, 5, 5);
//		gbc_lbltesvousSurDe.gridx = 4;
//		gbc_lbltesvousSurDe.gridy = 2;
//		PopupDeleteClient.add(lbltesvousSurDe, gbc_lbltesvousSurDe);
//
//		JButton btnPopupDeleteClient = new JButton("Oui");
//		GridBagConstraints gbc_btnPopupDeleteClient = new GridBagConstraints();
//		gbc_btnPopupDeleteClient.insets = new Insets(0, 0, 0, 5);
//		gbc_btnPopupDeleteClient.gridx = 3;
//		gbc_btnPopupDeleteClient.gridy = 6;
//		PopupDeleteClient.add(btnPopupDeleteClient, gbc_btnPopupDeleteClient);
//
//		JButton btnPopupCancelDeleteClient = new JButton("Non");
//		GridBagConstraints gbc_btnPopupCancelDeleteClient = new GridBagConstraints();
//		gbc_btnPopupCancelDeleteClient.insets = new Insets(0, 0, 0, 5);
//		gbc_btnPopupCancelDeleteClient.gridx = 5;
//		gbc_btnPopupCancelDeleteClient.gridy = 6;
//		PopupDeleteClient.add(btnPopupCancelDeleteClient, gbc_btnPopupCancelDeleteClient);

		// Edit Client
		// --------------------------------------------------------------------------------------

		GridBagLayout gbl_EditClient = new GridBagLayout();
		gbl_EditClient.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_EditClient.rowHeights = new int[] { 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_EditClient.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_EditClient.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		EditClient.getContentPane().setLayout(gbl_EditClient);
								
								JLabel lblNom = new JLabel("Nom");
								GridBagConstraints gbc_lblNom = new GridBagConstraints();
								gbc_lblNom.insets = new Insets(0, 0, 5, 5);
								gbc_lblNom.gridx = 1;
								gbc_lblNom.gridy = 1;
								EditClient.getContentPane().add(lblNom, gbc_lblNom);
								
								textField_1 = new JTextField();
								GridBagConstraints gbc_textField_1 = new GridBagConstraints();
								gbc_textField_1.gridwidth = 4;
								gbc_textField_1.insets = new Insets(0, 0, 5, 5);
								gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
								gbc_textField_1.gridx = 2;
								gbc_textField_1.gridy = 1;
								EditClient.getContentPane().add(textField_1, gbc_textField_1);
								textField_1.setColumns(10);
								
								JLabel label_6 = new JLabel("Nom");
								GridBagConstraints gbc_label_6 = new GridBagConstraints();
								gbc_label_6.insets = new Insets(0, 0, 5, 5);
								gbc_label_6.gridx = 7;
								gbc_label_6.gridy = 1;
								EditClient.getContentPane().add(label_6, gbc_label_6);
								
								textField_9 = new JTextField();
								textField_9.setColumns(10);
								GridBagConstraints gbc_textField_9 = new GridBagConstraints();
								gbc_textField_9.gridwidth = 3;
								gbc_textField_9.insets = new Insets(0, 0, 5, 5);
								gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
								gbc_textField_9.gridx = 8;
								gbc_textField_9.gridy = 1;
								EditClient.getContentPane().add(textField_9, gbc_textField_9);
								
								JLabel lblPrenom = new JLabel("Prenom");
								GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
								gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
								gbc_lblPrenom.gridx = 1;
								gbc_lblPrenom.gridy = 2;
								EditClient.getContentPane().add(lblPrenom, gbc_lblPrenom);
								
								textField_2 = new JTextField();
								textField_2.setColumns(10);
								GridBagConstraints gbc_textField_2 = new GridBagConstraints();
								gbc_textField_2.gridwidth = 4;
								gbc_textField_2.insets = new Insets(0, 0, 5, 5);
								gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
								gbc_textField_2.gridx = 2;
								gbc_textField_2.gridy = 2;
								EditClient.getContentPane().add(textField_2, gbc_textField_2);
								
								JLabel label_7 = new JLabel("Nom");
								GridBagConstraints gbc_label_7 = new GridBagConstraints();
								gbc_label_7.insets = new Insets(0, 0, 5, 5);
								gbc_label_7.gridx = 7;
								gbc_label_7.gridy = 2;
								EditClient.getContentPane().add(label_7, gbc_label_7);
								
								textField_10 = new JTextField();
								textField_10.setColumns(10);
								GridBagConstraints gbc_textField_10 = new GridBagConstraints();
								gbc_textField_10.gridwidth = 3;
								gbc_textField_10.insets = new Insets(0, 0, 5, 5);
								gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
								gbc_textField_10.gridx = 8;
								gbc_textField_10.gridy = 2;
								EditClient.getContentPane().add(textField_10, gbc_textField_10);
								
								JLabel lblAdresse = new JLabel("Adresse");
								GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
								gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
								gbc_lblAdresse.gridx = 1;
								gbc_lblAdresse.gridy = 3;
								EditClient.getContentPane().add(lblAdresse, gbc_lblAdresse);
								
								textField_3 = new JTextField();
								textField_3.setColumns(10);
								GridBagConstraints gbc_textField_3 = new GridBagConstraints();
								gbc_textField_3.gridwidth = 4;
								gbc_textField_3.insets = new Insets(0, 0, 5, 5);
								gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
								gbc_textField_3.gridx = 2;
								gbc_textField_3.gridy = 3;
								EditClient.getContentPane().add(textField_3, gbc_textField_3);
								
								JLabel label_8 = new JLabel("Nom");
								GridBagConstraints gbc_label_8 = new GridBagConstraints();
								gbc_label_8.insets = new Insets(0, 0, 5, 5);
								gbc_label_8.gridx = 7;
								gbc_label_8.gridy = 3;
								EditClient.getContentPane().add(label_8, gbc_label_8);
								
								textField_11 = new JTextField();
								textField_11.setColumns(10);
								GridBagConstraints gbc_textField_11 = new GridBagConstraints();
								gbc_textField_11.gridwidth = 3;
								gbc_textField_11.insets = new Insets(0, 0, 5, 5);
								gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
								gbc_textField_11.gridx = 8;
								gbc_textField_11.gridy = 3;
								EditClient.getContentPane().add(textField_11, gbc_textField_11);
								
								JLabel label_1 = new JLabel("Nom");
								GridBagConstraints gbc_label_1 = new GridBagConstraints();
								gbc_label_1.insets = new Insets(0, 0, 5, 5);
								gbc_label_1.gridx = 1;
								gbc_label_1.gridy = 4;
								EditClient.getContentPane().add(label_1, gbc_label_1);
								
								textField_4 = new JTextField();
								textField_4.setColumns(10);
								GridBagConstraints gbc_textField_4 = new GridBagConstraints();
								gbc_textField_4.gridwidth = 4;
								gbc_textField_4.insets = new Insets(0, 0, 5, 5);
								gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
								gbc_textField_4.gridx = 2;
								gbc_textField_4.gridy = 4;
								EditClient.getContentPane().add(textField_4, gbc_textField_4);
								
								JLabel label_9 = new JLabel("Nom");
								GridBagConstraints gbc_label_9 = new GridBagConstraints();
								gbc_label_9.insets = new Insets(0, 0, 5, 5);
								gbc_label_9.gridx = 7;
								gbc_label_9.gridy = 4;
								EditClient.getContentPane().add(label_9, gbc_label_9);
								
								textField_12 = new JTextField();
								textField_12.setColumns(10);
								GridBagConstraints gbc_textField_12 = new GridBagConstraints();
								gbc_textField_12.gridwidth = 3;
								gbc_textField_12.insets = new Insets(0, 0, 5, 5);
								gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
								gbc_textField_12.gridx = 8;
								gbc_textField_12.gridy = 4;
								EditClient.getContentPane().add(textField_12, gbc_textField_12);
								
								JLabel label_2 = new JLabel("Nom");
								GridBagConstraints gbc_label_2 = new GridBagConstraints();
								gbc_label_2.insets = new Insets(0, 0, 5, 5);
								gbc_label_2.gridx = 1;
								gbc_label_2.gridy = 5;
								EditClient.getContentPane().add(label_2, gbc_label_2);
								
								textField_5 = new JTextField();
								textField_5.setColumns(10);
								GridBagConstraints gbc_textField_5 = new GridBagConstraints();
								gbc_textField_5.gridwidth = 4;
								gbc_textField_5.insets = new Insets(0, 0, 5, 5);
								gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
								gbc_textField_5.gridx = 2;
								gbc_textField_5.gridy = 5;
								EditClient.getContentPane().add(textField_5, gbc_textField_5);
								
								JLabel label_10 = new JLabel("Nom");
								GridBagConstraints gbc_label_10 = new GridBagConstraints();
								gbc_label_10.insets = new Insets(0, 0, 5, 5);
								gbc_label_10.gridx = 7;
								gbc_label_10.gridy = 5;
								EditClient.getContentPane().add(label_10, gbc_label_10);
								
								textField_13 = new JTextField();
								textField_13.setColumns(10);
								GridBagConstraints gbc_textField_13 = new GridBagConstraints();
								gbc_textField_13.gridwidth = 3;
								gbc_textField_13.insets = new Insets(0, 0, 5, 5);
								gbc_textField_13.fill = GridBagConstraints.HORIZONTAL;
								gbc_textField_13.gridx = 8;
								gbc_textField_13.gridy = 5;
								EditClient.getContentPane().add(textField_13, gbc_textField_13);
								
								JLabel label_3 = new JLabel("Nom");
								GridBagConstraints gbc_label_3 = new GridBagConstraints();
								gbc_label_3.insets = new Insets(0, 0, 5, 5);
								gbc_label_3.gridx = 1;
								gbc_label_3.gridy = 6;
								EditClient.getContentPane().add(label_3, gbc_label_3);
								
								textField_6 = new JTextField();
								textField_6.setColumns(10);
								GridBagConstraints gbc_textField_6 = new GridBagConstraints();
								gbc_textField_6.gridwidth = 4;
								gbc_textField_6.insets = new Insets(0, 0, 5, 5);
								gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
								gbc_textField_6.gridx = 2;
								gbc_textField_6.gridy = 6;
								EditClient.getContentPane().add(textField_6, gbc_textField_6);
								
								JLabel label_11 = new JLabel("Nom");
								GridBagConstraints gbc_label_11 = new GridBagConstraints();
								gbc_label_11.insets = new Insets(0, 0, 5, 5);
								gbc_label_11.gridx = 7;
								gbc_label_11.gridy = 6;
								EditClient.getContentPane().add(label_11, gbc_label_11);
								
								textField_14 = new JTextField();
								textField_14.setColumns(10);
								GridBagConstraints gbc_textField_14 = new GridBagConstraints();
								gbc_textField_14.gridwidth = 3;
								gbc_textField_14.insets = new Insets(0, 0, 5, 5);
								gbc_textField_14.fill = GridBagConstraints.HORIZONTAL;
								gbc_textField_14.gridx = 8;
								gbc_textField_14.gridy = 6;
								EditClient.getContentPane().add(textField_14, gbc_textField_14);
								
								JLabel label_4 = new JLabel("Nom");
								GridBagConstraints gbc_label_4 = new GridBagConstraints();
								gbc_label_4.insets = new Insets(0, 0, 5, 5);
								gbc_label_4.gridx = 1;
								gbc_label_4.gridy = 7;
								EditClient.getContentPane().add(label_4, gbc_label_4);
								
								textField_7 = new JTextField();
								textField_7.setColumns(10);
								GridBagConstraints gbc_textField_7 = new GridBagConstraints();
								gbc_textField_7.gridwidth = 4;
								gbc_textField_7.insets = new Insets(0, 0, 5, 5);
								gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
								gbc_textField_7.gridx = 2;
								gbc_textField_7.gridy = 7;
								EditClient.getContentPane().add(textField_7, gbc_textField_7);
								
								JLabel label_12 = new JLabel("Nom");
								GridBagConstraints gbc_label_12 = new GridBagConstraints();
								gbc_label_12.insets = new Insets(0, 0, 5, 5);
								gbc_label_12.gridx = 7;
								gbc_label_12.gridy = 7;
								EditClient.getContentPane().add(label_12, gbc_label_12);
								
								textField_15 = new JTextField();
								textField_15.setColumns(10);
								GridBagConstraints gbc_textField_15 = new GridBagConstraints();
								gbc_textField_15.gridwidth = 3;
								gbc_textField_15.insets = new Insets(0, 0, 5, 5);
								gbc_textField_15.fill = GridBagConstraints.HORIZONTAL;
								gbc_textField_15.gridx = 8;
								gbc_textField_15.gridy = 7;
								EditClient.getContentPane().add(textField_15, gbc_textField_15);
								
								JLabel label_5 = new JLabel("Nom");
								GridBagConstraints gbc_label_5 = new GridBagConstraints();
								gbc_label_5.insets = new Insets(0, 0, 5, 5);
								gbc_label_5.gridx = 1;
								gbc_label_5.gridy = 8;
								EditClient.getContentPane().add(label_5, gbc_label_5);
								
								textField_8 = new JTextField();
								textField_8.setColumns(10);
								GridBagConstraints gbc_textField_8 = new GridBagConstraints();
								gbc_textField_8.gridwidth = 4;
								gbc_textField_8.insets = new Insets(0, 0, 5, 5);
								gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
								gbc_textField_8.gridx = 2;
								gbc_textField_8.gridy = 8;
								EditClient.getContentPane().add(textField_8, gbc_textField_8);
								
								JLabel label_13 = new JLabel("Nom");
								GridBagConstraints gbc_label_13 = new GridBagConstraints();
								gbc_label_13.insets = new Insets(0, 0, 5, 5);
								gbc_label_13.gridx = 7;
								gbc_label_13.gridy = 8;
								EditClient.getContentPane().add(label_13, gbc_label_13);
																		
																		textField_16 = new JTextField();
																		textField_16.setColumns(10);
																		GridBagConstraints gbc_textField_16 = new GridBagConstraints();
																		gbc_textField_16.gridwidth = 3;
																		gbc_textField_16.insets = new Insets(0, 0, 5, 5);
																		gbc_textField_16.fill = GridBagConstraints.HORIZONTAL;
																		gbc_textField_16.gridx = 8;
																		gbc_textField_16.gridy = 8;
																		EditClient.getContentPane().add(textField_16, gbc_textField_16);
																
																		JButton btnEditClient = new JButton("Valider");
																		GridBagConstraints gbc_btnEditClient = new GridBagConstraints();
																		gbc_btnEditClient.insets = new Insets(0, 0, 5, 5);
																		gbc_btnEditClient.gridx = 10;
																		gbc_btnEditClient.gridy = 9;
																		EditClient.getContentPane().add(btnEditClient, gbc_btnEditClient);
																
																		JButton btnCancelEditClient = new JButton("Annuler");
																		GridBagConstraints gbc_btnCancelEditClient = new GridBagConstraints();
																		gbc_btnCancelEditClient.insets = new Insets(0, 0, 5, 0);
																		gbc_btnCancelEditClient.gridx = 11;
																		gbc_btnCancelEditClient.gridy = 9;
																		EditClient.getContentPane().add(btnCancelEditClient, gbc_btnCancelEditClient);

		////////////////////////////////////////////////////////////////////////////////////////

//		btnSearchClient.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				setUpTableData(controller.getClient(textField.getText()), entetes1);
//			}
//		});
//
//		btnAddClient.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				AddClient.setBounds(100, 100, 450, 300);
//				AddClient.setVisible(true);
//			}
//		});
//
//		btnValiderModalAddClient.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				controller.addClient(textFieldNomClient.getText(), textFieldPrenomClient.getText(),
//						textFieldAdresseClient.getText(), textFieldCodePostalClient.getText(),
//						textFieldVilleClient.getText(), textFieldNumTelClient.getText(),
//						textFieldEmailClient.getText());
//				setUpTableData(controller.getList(), entetes1);
//				AddClient.setVisible(false);
//			}
//		});
//
//		btnDeleteClient.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				PopupDeleteClient.setBounds(100, 100, 418, 136);
//				PopupDeleteClient.setVisible(true);
//			}
//		});
//
//		btnPopupDeleteClient.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				controller.removeClient((Integer) table_1.getValueAt(table_1.getSelectedRow(), 0));
//				setUpTableData(controller.getList(), entetes1);
//				PopupDeleteClient.setVisible(false);
//			}
//		});
//
//		btnPopupCancelDeleteClient.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				PopupDeleteClient.setVisible(false);
//			}
//		});
	}

	private void setUpTableData(Object[][] data, String[] entetes) {
		tableModel = new DefaultTableModel(data, entetes) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_1.setModel(tableModel);
		tableModel.fireTableDataChanged();
	}
}
