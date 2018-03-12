package fr.eni.clinique.ihm.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class WindowClients {

	private JFrame frame;
	private DefaultTableModel tableModel;
	private ComboBoxModel<String> comboboxModel;
	private JTable table_1;
	private JTable table_2;
	private ControllerClients controller;
	private ControllerAnimaux controlleranimal;
	private JTextField textField;
	private JDialog AddClient = new JDialog();
	private JDialog PopupDeleteClient = new JDialog();
	private JDialog EditClient = new JDialog();
	private JDialog GestionAnimal = new JDialog();
	private JTextField textFieldNomClient;
	private JTextField textFieldPrenomClient;
	private JTextField textFieldAdresse1Client;
	private JTextField textFieldAdresse2Client;
	private JTextField textFieldCodePostalClient;
	private JTextField textFieldVilleClient;
	private JTextField textFieldNumTelClient;
	private JTextField textFieldEmailClient;
	private JTextField textFieldCodeClientEdit;
	private JTextField textFieldNomClientEdit;
	private JTextField textFieldPrenomClientEdit;
	private JTextField textFieldAdresse1ClientEdit;
	private JTextField textFieldAdresse2ClientEdit;
	private JTextField textFieldVilleClientEdit;
	private JTextField textFieldCodePostalClientEdit;
	private JTextField textFieldNumTelClientEdit;
	private JTextField textFieldAssuranceClientEdit;
	private JTextField textFieldEmailClientEdit;
	private JTextField textFieldRemarqueClientEdit;
	private JTextField textFieldCodeAnimal;
	private JTextField textFieldNomAnimal;
	private JTextField textFieldCouleurAnimal;
	private JTextField textFieldTatouageAnimal;

	public WindowClients() {
		controller = new ControllerClients();
		controlleranimal = new ControllerAnimaux();
		frame = new JFrame();
		frame.setTitle("Gestion Clients");
		frame.setBounds(100, 100, 730, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 146, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 232, 38, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnSearchClient = new JButton("Rechercher");
		GridBagConstraints gbc_btnSearchClient = new GridBagConstraints();
		gbc_btnSearchClient.gridwidth = 2;
		gbc_btnSearchClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearchClient.gridx = 2;
		gbc_btnSearchClient.gridy = 1;
		frame.getContentPane().add(btnSearchClient, gbc_btnSearchClient);

		JButton btnAddClient = new JButton("Ajouter");
		GridBagConstraints gbc_btnAddClient = new GridBagConstraints();
		gbc_btnAddClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddClient.gridx = 4;
		gbc_btnAddClient.gridy = 1;
		frame.getContentPane().add(btnAddClient, gbc_btnAddClient);

		JButton btnDeleteClient = new JButton("Supprimer");
		GridBagConstraints gbc_btnDeleteClient = new GridBagConstraints();
		gbc_btnDeleteClient.gridwidth = 2;
		gbc_btnDeleteClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteClient.gridx = 5;
		gbc_btnDeleteClient.gridy = 1;
		frame.getContentPane().add(btnDeleteClient, gbc_btnDeleteClient);

		JButton btnEditClient = new JButton("Editer");
		GridBagConstraints gbc_btnEditClient = new GridBagConstraints();
		gbc_btnEditClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditClient.gridx = 9;
		gbc_btnEditClient.gridy = 1;
		frame.getContentPane().add(btnEditClient, gbc_btnEditClient);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 4;
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

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		frame.getContentPane().add(panel_1, gbc_panel_1);

		JButton btnAddAnimal = new JButton("Ajouter");
		GridBagConstraints gbc_btnAddAnimal = new GridBagConstraints();
		gbc_btnAddAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddAnimal.gridx = 7;
		gbc_btnAddAnimal.gridy = 4;
		frame.getContentPane().add(btnAddAnimal, gbc_btnAddAnimal);

		JButton btnDeleteAnimal = new JButton("Supprimer");
		GridBagConstraints gbc_btnDeleteAnimal = new GridBagConstraints();
		gbc_btnDeleteAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteAnimal.gridx = 8;
		gbc_btnDeleteAnimal.gridy = 4;
		frame.getContentPane().add(btnDeleteAnimal, gbc_btnDeleteAnimal);

		JButton btnEditAnimal = new JButton("Editer");
		GridBagConstraints gbc_btnEditAnimal = new GridBagConstraints();
		gbc_btnEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditAnimal.gridx = 9;
		gbc_btnEditAnimal.gridy = 4;
		frame.getContentPane().add(btnEditAnimal, gbc_btnEditAnimal);

		// Modal Add Client
		// --------------------------------------------------------------------------------------

		GridBagLayout gridBagLayoutModalAddClient = new GridBagLayout();
		gridBagLayoutModalAddClient.columnWidths = new int[] { 0, 0, 0, 0, 140, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayoutModalAddClient.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayoutModalAddClient.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gridBagLayoutModalAddClient.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		AddClient.getContentPane().setLayout(gridBagLayoutModalAddClient);

		JLabel lblAddClient = new JLabel("Nouveau Client");
		GridBagConstraints gbc_lblAddClient = new GridBagConstraints();
		gbc_lblAddClient.gridwidth = 8;
		gbc_lblAddClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddClient.gridx = 2;
		gbc_lblAddClient.gridy = 2;
		AddClient.getContentPane().add(lblAddClient, gbc_lblAddClient);

		JLabel lblNomClient = new JLabel("Nom");
		GridBagConstraints gbc_lblNomClient = new GridBagConstraints();
		gbc_lblNomClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomClient.gridx = 2;
		gbc_lblNomClient.gridy = 3;
		AddClient.getContentPane().add(lblNomClient, gbc_lblNomClient);

		textFieldNomClient = new JTextField();
		GridBagConstraints gbc_textFieldNomClient = new GridBagConstraints();
		gbc_textFieldNomClient.gridwidth = 5;
		gbc_textFieldNomClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNomClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomClient.gridx = 4;
		gbc_textFieldNomClient.gridy = 3;
		AddClient.getContentPane().add(textFieldNomClient, gbc_textFieldNomClient);

		JLabel lblPrenomClient = new JLabel("Prenom");
		GridBagConstraints gbc_lblPrenomClient = new GridBagConstraints();
		gbc_lblPrenomClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenomClient.gridx = 2;
		gbc_lblPrenomClient.gridy = 4;
		AddClient.getContentPane().add(lblPrenomClient, gbc_lblPrenomClient);

		textFieldPrenomClient = new JTextField();
		GridBagConstraints gbc_textFieldPrenomClient = new GridBagConstraints();
		gbc_textFieldPrenomClient.gridwidth = 5;
		gbc_textFieldPrenomClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrenomClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrenomClient.gridx = 4;
		gbc_textFieldPrenomClient.gridy = 4;
		AddClient.getContentPane().add(textFieldPrenomClient, gbc_textFieldPrenomClient);

		JLabel lblAdresseClient = new JLabel("Adresse");
		GridBagConstraints gbc_lblAdresseClient = new GridBagConstraints();
		gbc_lblAdresseClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresseClient.gridx = 2;
		gbc_lblAdresseClient.gridy = 5;
		AddClient.getContentPane().add(lblAdresseClient, gbc_lblAdresseClient);

		textFieldAdresse1Client = new JTextField();
		GridBagConstraints gbc_textFieldAdresse1Client = new GridBagConstraints();
		gbc_textFieldAdresse1Client.gridwidth = 5;
		gbc_textFieldAdresse1Client.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse1Client.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse1Client.gridx = 4;
		gbc_textFieldAdresse1Client.gridy = 5;
		AddClient.getContentPane().add(textFieldAdresse1Client, gbc_textFieldAdresse1Client);

		textFieldAdresse2Client = new JTextField();
		GridBagConstraints gbc_textFieldAdresse2Client = new GridBagConstraints();
		gbc_textFieldAdresse2Client.gridwidth = 5;
		gbc_textFieldAdresse2Client.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse2Client.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse2Client.gridx = 4;
		gbc_textFieldAdresse2Client.gridy = 6;
		AddClient.getContentPane().add(textFieldAdresse2Client, gbc_textFieldAdresse2Client);

		JLabel lblCodePostalClient = new JLabel("Code Postal");
		GridBagConstraints gbc_lblCodePostalClient = new GridBagConstraints();
		gbc_lblCodePostalClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodePostalClient.gridx = 2;
		gbc_lblCodePostalClient.gridy = 7;
		AddClient.getContentPane().add(lblCodePostalClient, gbc_lblCodePostalClient);

		textFieldCodePostalClient = new JTextField();
		GridBagConstraints gbc_textFieldCodePostalClient = new GridBagConstraints();
		gbc_textFieldCodePostalClient.gridwidth = 5;
		gbc_textFieldCodePostalClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodePostalClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodePostalClient.gridx = 4;
		gbc_textFieldCodePostalClient.gridy = 7;
		AddClient.getContentPane().add(textFieldCodePostalClient, gbc_textFieldCodePostalClient);

		JLabel lblVilleClient = new JLabel("Ville");
		GridBagConstraints gbc_lblVilleClient = new GridBagConstraints();
		gbc_lblVilleClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblVilleClient.gridx = 2;
		gbc_lblVilleClient.gridy = 8;
		AddClient.getContentPane().add(lblVilleClient, gbc_lblVilleClient);

		textFieldVilleClient = new JTextField();
		GridBagConstraints gbc_textFieldVilleClient = new GridBagConstraints();
		gbc_textFieldVilleClient.gridwidth = 5;
		gbc_textFieldVilleClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldVilleClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVilleClient.gridx = 4;
		gbc_textFieldVilleClient.gridy = 8;
		AddClient.getContentPane().add(textFieldVilleClient, gbc_textFieldVilleClient);

		JLabel lblNumTelClient = new JLabel("Num. Tel");
		GridBagConstraints gbc_lblNumTelClient = new GridBagConstraints();
		gbc_lblNumTelClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumTelClient.gridx = 2;
		gbc_lblNumTelClient.gridy = 9;
		AddClient.getContentPane().add(lblNumTelClient, gbc_lblNumTelClient);

		textFieldNumTelClient = new JTextField();
		GridBagConstraints gbc_textFieldNumTelClient = new GridBagConstraints();
		gbc_textFieldNumTelClient.gridwidth = 5;
		gbc_textFieldNumTelClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNumTelClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNumTelClient.gridx = 4;
		gbc_textFieldNumTelClient.gridy = 9;
		AddClient.getContentPane().add(textFieldNumTelClient, gbc_textFieldNumTelClient);

		JLabel lblEmailClient = new JLabel("Email");
		GridBagConstraints gbc_lblEmailClient = new GridBagConstraints();
		gbc_lblEmailClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailClient.gridx = 2;
		gbc_lblEmailClient.gridy = 10;
		AddClient.getContentPane().add(lblEmailClient, gbc_lblEmailClient);

		textFieldEmailClient = new JTextField();
		GridBagConstraints gbc_textFieldEmailClient = new GridBagConstraints();
		gbc_textFieldEmailClient.gridwidth = 5;
		gbc_textFieldEmailClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmailClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmailClient.gridx = 4;
		gbc_textFieldEmailClient.gridy = 10;
		AddClient.getContentPane().add(textFieldEmailClient, gbc_textFieldEmailClient);

		JButton btnValiderModalAddClient = new JButton("VALIDER");
		GridBagConstraints gbc_btnValiderModalAdd = new GridBagConstraints();
		gbc_btnValiderModalAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnValiderModalAdd.gridx = 8;
		gbc_btnValiderModalAdd.gridy = 11;
		AddClient.getContentPane().add(btnValiderModalAddClient, gbc_btnValiderModalAdd);

		JButton btnAnnulerModalCancelClient = new JButton("ANNULER");
		GridBagConstraints gbc_btnAnnulerModalCancelClient = new GridBagConstraints();
		gbc_btnAnnulerModalCancelClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnulerModalCancelClient.gridx = 9;
		gbc_btnAnnulerModalCancelClient.gridy = 11;
		AddClient.getContentPane().add(btnAnnulerModalCancelClient, gbc_btnAnnulerModalCancelClient);

		// Popup Remove
		// --------------------------------------------------------------------------------------

		GridBagLayout gbl_PopupDeleteClient = new GridBagLayout();
		gbl_PopupDeleteClient.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_PopupDeleteClient.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_PopupDeleteClient.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_PopupDeleteClient.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		PopupDeleteClient.setLayout(gbl_PopupDeleteClient);

		JLabel lbltesvousSurDe = new JLabel("");
		GridBagConstraints gbc_lbltesvousSurDe = new GridBagConstraints();
		gbc_lbltesvousSurDe.insets = new Insets(0, 0, 5, 5);
		gbc_lbltesvousSurDe.gridx = 4;
		gbc_lbltesvousSurDe.gridy = 2;
		PopupDeleteClient.add(lbltesvousSurDe, gbc_lbltesvousSurDe);

		JButton btnPopupDelete = new JButton("Oui");
		GridBagConstraints gbc_btnPopupDelete = new GridBagConstraints();
		gbc_btnPopupDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnPopupDelete.gridx = 3;
		gbc_btnPopupDelete.gridy = 6;
		PopupDeleteClient.add(btnPopupDelete, gbc_btnPopupDelete);

		JButton btnPopupCancelDelete = new JButton("Non");
		GridBagConstraints gbc_btnPopupCancelDelete = new GridBagConstraints();
		gbc_btnPopupCancelDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnPopupCancelDelete.gridx = 5;
		gbc_btnPopupCancelDelete.gridy = 6;
		PopupDeleteClient.add(btnPopupCancelDelete, gbc_btnPopupCancelDelete);

		// Edit Client
		// --------------------------------------------------------------------------------------

		GridBagLayout gbl_EditClient = new GridBagLayout();
		gbl_EditClient.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_EditClient.rowHeights = new int[] { 0, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_EditClient.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_EditClient.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		EditClient.getContentPane().setLayout(gbl_EditClient);

		JLabel lblEditerClient = new JLabel("Editer Client");
		GridBagConstraints gbc_lblEditerClient = new GridBagConstraints();
		gbc_lblEditerClient.gridwidth = 3;
		gbc_lblEditerClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditerClient.gridx = 7;
		gbc_lblEditerClient.gridy = 1;
		EditClient.getContentPane().add(lblEditerClient, gbc_lblEditerClient);

		JLabel lblCode = new JLabel("Code");
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 2;
		gbc_lblCode.gridy = 2;
		EditClient.getContentPane().add(lblCode, gbc_lblCode);

		textFieldCodeClientEdit = new JTextField();
		GridBagConstraints gbc_textFieldCodeClientEdit = new GridBagConstraints();
		gbc_textFieldCodeClientEdit.gridwidth = 5;
		gbc_textFieldCodeClientEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodeClientEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodeClientEdit.gridx = 3;
		gbc_textFieldCodeClientEdit.gridy = 2;
		EditClient.getContentPane().add(textFieldCodeClientEdit, gbc_textFieldCodeClientEdit);
		textFieldCodeClientEdit.setColumns(10);

		JLabel lblAssurance = new JLabel("Assurance");
		GridBagConstraints gbc_lblAssurance = new GridBagConstraints();
		gbc_lblAssurance.insets = new Insets(0, 0, 5, 5);
		gbc_lblAssurance.gridx = 9;
		gbc_lblAssurance.gridy = 2;
		EditClient.getContentPane().add(lblAssurance, gbc_lblAssurance);

		textFieldAssuranceClientEdit = new JTextField();
		textFieldAssuranceClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldAssuranceEdit = new GridBagConstraints();
		gbc_textFieldAssuranceEdit.gridwidth = 2;
		gbc_textFieldAssuranceEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAssuranceEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAssuranceEdit.gridx = 10;
		gbc_textFieldAssuranceEdit.gridy = 2;
		EditClient.getContentPane().add(textFieldAssuranceClientEdit, gbc_textFieldAssuranceEdit);

		JLabel lblNom = new JLabel("Nom");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 2;
		gbc_lblNom.gridy = 3;
		EditClient.getContentPane().add(lblNom, gbc_lblNom);

		textFieldNomClientEdit = new JTextField();
		textFieldNomClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldNomClientEdit = new GridBagConstraints();
		gbc_textFieldNomClientEdit.gridwidth = 5;
		gbc_textFieldNomClientEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNomClientEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomClientEdit.gridx = 3;
		gbc_textFieldNomClientEdit.gridy = 3;
		EditClient.getContentPane().add(textFieldNomClientEdit, gbc_textFieldNomClientEdit);

		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 9;
		gbc_lblEmail.gridy = 3;
		EditClient.getContentPane().add(lblEmail, gbc_lblEmail);

		textFieldEmailClientEdit = new JTextField();
		textFieldEmailClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldEmailEdit = new GridBagConstraints();
		gbc_textFieldEmailEdit.gridwidth = 2;
		gbc_textFieldEmailEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmailEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmailEdit.gridx = 10;
		gbc_textFieldEmailEdit.gridy = 3;
		EditClient.getContentPane().add(textFieldEmailClientEdit, gbc_textFieldEmailEdit);

		JLabel lblPrenom = new JLabel("Prenom");
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenom.gridx = 2;
		gbc_lblPrenom.gridy = 4;
		EditClient.getContentPane().add(lblPrenom, gbc_lblPrenom);

		textFieldPrenomClientEdit = new JTextField();
		textFieldPrenomClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldPrenomClientEdit = new GridBagConstraints();
		gbc_textFieldPrenomClientEdit.gridwidth = 5;
		gbc_textFieldPrenomClientEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrenomClientEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrenomClientEdit.gridx = 3;
		gbc_textFieldPrenomClientEdit.gridy = 4;
		EditClient.getContentPane().add(textFieldPrenomClientEdit, gbc_textFieldPrenomClientEdit);

		JLabel lblRemarque = new JLabel("Remarque");
		GridBagConstraints gbc_lblRemarque = new GridBagConstraints();
		gbc_lblRemarque.insets = new Insets(0, 0, 5, 5);
		gbc_lblRemarque.gridx = 9;
		gbc_lblRemarque.gridy = 4;
		EditClient.getContentPane().add(lblRemarque, gbc_lblRemarque);

		textFieldRemarqueClientEdit = new JTextField();
		textFieldRemarqueClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldRemarqueEdit = new GridBagConstraints();
		gbc_textFieldRemarqueEdit.gridheight = 3;
		gbc_textFieldRemarqueEdit.gridwidth = 2;
		gbc_textFieldRemarqueEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldRemarqueEdit.fill = GridBagConstraints.BOTH;
		gbc_textFieldRemarqueEdit.gridx = 10;
		gbc_textFieldRemarqueEdit.gridy = 4;
		EditClient.getContentPane().add(textFieldRemarqueClientEdit, gbc_textFieldRemarqueEdit);

		JLabel lblAdresse = new JLabel("Adresse");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 2;
		gbc_lblAdresse.gridy = 5;
		EditClient.getContentPane().add(lblAdresse, gbc_lblAdresse);

		textFieldAdresse1ClientEdit = new JTextField();
		textFieldAdresse1ClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldAdresse1ClientEdit = new GridBagConstraints();
		gbc_textFieldAdresse1ClientEdit.gridwidth = 5;
		gbc_textFieldAdresse1ClientEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse1ClientEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse1ClientEdit.gridx = 3;
		gbc_textFieldAdresse1ClientEdit.gridy = 5;
		EditClient.getContentPane().add(textFieldAdresse1ClientEdit, gbc_textFieldAdresse1ClientEdit);

		textFieldAdresse2ClientEdit = new JTextField();
		textFieldAdresse2ClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldAdresse2ClientEdit = new GridBagConstraints();
		gbc_textFieldAdresse2ClientEdit.gridwidth = 5;
		gbc_textFieldAdresse2ClientEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse2ClientEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse2ClientEdit.gridx = 3;
		gbc_textFieldAdresse2ClientEdit.gridy = 6;
		EditClient.getContentPane().add(textFieldAdresse2ClientEdit, gbc_textFieldAdresse2ClientEdit);

		JLabel lblVille = new JLabel("Ville");
		GridBagConstraints gbc_lblVille = new GridBagConstraints();
		gbc_lblVille.insets = new Insets(0, 0, 5, 5);
		gbc_lblVille.gridx = 2;
		gbc_lblVille.gridy = 7;
		EditClient.getContentPane().add(lblVille, gbc_lblVille);

		textFieldVilleClientEdit = new JTextField();
		textFieldVilleClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldVilleClientEdit = new GridBagConstraints();
		gbc_textFieldVilleClientEdit.gridwidth = 5;
		gbc_textFieldVilleClientEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldVilleClientEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVilleClientEdit.gridx = 3;
		gbc_textFieldVilleClientEdit.gridy = 7;
		EditClient.getContentPane().add(textFieldVilleClientEdit, gbc_textFieldVilleClientEdit);

		JLabel lblCodePostal = new JLabel("Code Postal");
		GridBagConstraints gbc_lblCodePostal = new GridBagConstraints();
		gbc_lblCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodePostal.gridx = 2;
		gbc_lblCodePostal.gridy = 8;
		EditClient.getContentPane().add(lblCodePostal, gbc_lblCodePostal);

		textFieldCodePostalClientEdit = new JTextField();
		textFieldCodePostalClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldCodePostalEdit = new GridBagConstraints();
		gbc_textFieldCodePostalEdit.gridwidth = 5;
		gbc_textFieldCodePostalEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodePostalEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodePostalEdit.gridx = 3;
		gbc_textFieldCodePostalEdit.gridy = 8;
		EditClient.getContentPane().add(textFieldCodePostalClientEdit, gbc_textFieldCodePostalEdit);

		JLabel lblNumTel = new JLabel("Num. Tel");
		GridBagConstraints gbc_lblNumTel = new GridBagConstraints();
		gbc_lblNumTel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumTel.gridx = 2;
		gbc_lblNumTel.gridy = 9;
		EditClient.getContentPane().add(lblNumTel, gbc_lblNumTel);

		textFieldNumTelClientEdit = new JTextField();
		textFieldNumTelClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldNumTelEdit = new GridBagConstraints();
		gbc_textFieldNumTelEdit.gridwidth = 5;
		gbc_textFieldNumTelEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNumTelEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNumTelEdit.gridx = 3;
		gbc_textFieldNumTelEdit.gridy = 9;
		EditClient.getContentPane().add(textFieldNumTelClientEdit, gbc_textFieldNumTelEdit);

		JButton btnConfirmEditClient = new JButton("Valider");
		GridBagConstraints gbc_btnConfirmEditClient = new GridBagConstraints();
		gbc_btnConfirmEditClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirmEditClient.gridx = 10;
		gbc_btnConfirmEditClient.gridy = 10;
		EditClient.getContentPane().add(btnConfirmEditClient, gbc_btnConfirmEditClient);

		JButton btnCancelEditClient = new JButton("Annuler");
		GridBagConstraints gbc_btnCancelEditClient = new GridBagConstraints();
		gbc_btnCancelEditClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelEditClient.gridx = 11;
		gbc_btnCancelEditClient.gridy = 10;
		EditClient.getContentPane().add(btnCancelEditClient, gbc_btnCancelEditClient);

		// Add Animal
		// --------------------------------------------------------------------------------------

		GridBagLayout gbl_AddAnimal = new GridBagLayout();
		gbl_AddAnimal.columnWidths = new int[]{0, 84, 0, 67, 0, 0, 0, 0};
		gbl_AddAnimal.rowHeights = new int[]{10, 0, 35, 35, 35, 0, 0, 0, 0, 0};
		gbl_AddAnimal.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0};
		gbl_AddAnimal.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		GestionAnimal.getContentPane().setLayout(gbl_AddAnimal);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(null);
		desktopPane.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_desktopPane = new GridBagConstraints();
		gbc_desktopPane.gridwidth = 5;
		gbc_desktopPane.insets = new Insets(0, 0, 5, 0);
		gbc_desktopPane.fill = GridBagConstraints.BOTH;
		gbc_desktopPane.gridx = 0;
		gbc_desktopPane.gridy = 0;
		GestionAnimal.getContentPane().add(desktopPane, gbc_desktopPane);

		JButton btnConfirmAddAnimal = new JButton("");
		btnConfirmAddAnimal.setForeground(new Color(255, 255, 255));
		btnConfirmAddAnimal.setBackground(new Color(255, 255, 255));
		btnConfirmAddAnimal.setIcon(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/checked32.png"));
		btnConfirmAddAnimal.setBounds(329, 11, 58, 44);
		desktopPane.add(btnConfirmAddAnimal);

		JButton btnCancelAddAnimal = new JButton("");
		btnCancelAddAnimal.setForeground(new Color(255, 255, 255));
		btnCancelAddAnimal.setBackground(new Color(255, 255, 255));
		btnCancelAddAnimal.setIcon(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/cancel.png"));
		btnCancelAddAnimal.setBounds(423, 11, 58, 44);
		desktopPane.add(btnCancelAddAnimal);

		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(UIManager.getColor("Button.background"));
		desktopPane_1.setBorder(null);
		GridBagConstraints gbc_desktopPane_1 = new GridBagConstraints();
		gbc_desktopPane_1.gridheight = 2;
		gbc_desktopPane_1.gridwidth = 5;
		gbc_desktopPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_desktopPane_1.fill = GridBagConstraints.BOTH;
		gbc_desktopPane_1.gridx = 0;
		gbc_desktopPane_1.gridy = 1;
		GestionAnimal.getContentPane().add(desktopPane_1, gbc_desktopPane_1);

		JLabel lblClient = new JLabel("Client :");
		lblClient.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		lblClient.setBounds(22, 11, 46, 14);
		desktopPane_1.add(lblClient);

		JLabel lblNomPrenomClient = new JLabel("");
		lblNomPrenomClient.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		lblNomPrenomClient.setBounds(43, 32, 265, 14);
		desktopPane_1.add(lblNomPrenomClient);

		JLabel lblCodeAnimal = new JLabel("Code");
		lblCodeAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblCodeAnimal = new GridBagConstraints();
		gbc_lblCodeAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodeAnimal.gridx = 0;
		gbc_lblCodeAnimal.gridy = 3;
		GestionAnimal.getContentPane().add(lblCodeAnimal, gbc_lblCodeAnimal);

		textFieldCodeAnimal = new JTextField();
		GridBagConstraints gbc_textFieldCodeAnimal = new GridBagConstraints();
		gbc_textFieldCodeAnimal.gridwidth = 2;
		gbc_textFieldCodeAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodeAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodeAnimal.gridx = 1;
		gbc_textFieldCodeAnimal.gridy = 3;
		GestionAnimal.getContentPane().add(textFieldCodeAnimal, gbc_textFieldCodeAnimal);
		textFieldCodeAnimal.setColumns(10);

		JLabel lblNomAnimal = new JLabel("Nom");
		lblNomAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblNomAnimal = new GridBagConstraints();
		gbc_lblNomAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomAnimal.gridx = 0;
		gbc_lblNomAnimal.gridy = 4;
		GestionAnimal.getContentPane().add(lblNomAnimal, gbc_lblNomAnimal);

		textFieldNomAnimal = new JTextField();
		GridBagConstraints gbc_textFieldNomAnimal = new GridBagConstraints();
		gbc_textFieldNomAnimal.gridwidth = 2;
		gbc_textFieldNomAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNomAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomAnimal.gridx = 1;
		gbc_textFieldNomAnimal.gridy = 4;
		GestionAnimal.getContentPane().add(textFieldNomAnimal, gbc_textFieldNomAnimal);
		textFieldNomAnimal.setColumns(10);

		String[] Genre = { "Mâle", "Femelle", "Hermaphrodite" };
		JComboBox<String> comboBoxGenre = new JComboBox<String>(Genre);
		GridBagConstraints gbc_comboBoxGenre = new GridBagConstraints();
		comboBoxGenre.setBackground(new Color(255, 255, 255));
		gbc_comboBoxGenre.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxGenre.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxGenre.gridx = 3;
		gbc_comboBoxGenre.gridy = 4;
		GestionAnimal.getContentPane().add(comboBoxGenre, gbc_comboBoxGenre);

		JLabel lblCouleurAnimal = new JLabel("Couleur");
		lblCouleurAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblCouleurAnimal = new GridBagConstraints();
		gbc_lblCouleurAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCouleurAnimal.gridx = 0;
		gbc_lblCouleurAnimal.gridy = 5;
		GestionAnimal.getContentPane().add(lblCouleurAnimal, gbc_lblCouleurAnimal);

		textFieldCouleurAnimal = new JTextField();
		GridBagConstraints gbc_textFieldCouleurAnimal = new GridBagConstraints();
		gbc_textFieldCouleurAnimal.gridwidth = 2;
		gbc_textFieldCouleurAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCouleurAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCouleurAnimal.gridx = 1;
		gbc_textFieldCouleurAnimal.gridy = 5;
		GestionAnimal.getContentPane().add(textFieldCouleurAnimal, gbc_textFieldCouleurAnimal);
		textFieldCouleurAnimal.setColumns(10);

		JLabel lblEspeceAnimal = new JLabel("Espece");
		lblEspeceAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblEspeceAnimal = new GridBagConstraints();
		gbc_lblEspeceAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspeceAnimal.gridx = 0;
		gbc_lblEspeceAnimal.gridy = 6;
		GestionAnimal.getContentPane().add(lblEspeceAnimal, gbc_lblEspeceAnimal);

		String[] Espece = controlleranimal.getEspece();
		JComboBox<String> espece = new JComboBox<String>(Espece);
		GridBagConstraints gbc_espece = new GridBagConstraints();
		espece.setBackground(new Color(255, 255, 255));
		gbc_espece.insets = new Insets(0, 0, 5, 5);
		gbc_espece.fill = GridBagConstraints.HORIZONTAL;
		gbc_espece.gridwidth = 2;
		gbc_espece.gridx = 1;
		gbc_espece.gridy = 6;
		GestionAnimal.getContentPane().add(espece, gbc_espece);

		JLabel lblRaceAnimal = new JLabel("Race");
		lblRaceAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblRaceAnimal = new GridBagConstraints();
		gbc_lblRaceAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblRaceAnimal.anchor = GridBagConstraints.EAST;
		gbc_lblRaceAnimal.gridx = 2;
		gbc_lblRaceAnimal.gridy = 6;
		GestionAnimal.getContentPane().add(lblRaceAnimal, gbc_lblRaceAnimal);

		JComboBox<String> race = new JComboBox<String>();
		GridBagConstraints gbc_race = new GridBagConstraints();
		race.setBackground(new Color(255, 255, 255));
		gbc_race.insets = new Insets(0, 0, 5, 5);
		gbc_race.fill = GridBagConstraints.HORIZONTAL;
		gbc_race.gridwidth = 2;
		gbc_race.gridx = 3;
		gbc_race.gridy = 6;
		GestionAnimal.getContentPane().add(race, gbc_race);

		JLabel lblTatouageAnimal = new JLabel("Tatouage");
		lblTatouageAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblTatouageAnimal = new GridBagConstraints();
		gbc_lblTatouageAnimal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTatouageAnimal.gridx = 0;
		gbc_lblTatouageAnimal.gridy = 7;
		GestionAnimal.getContentPane().add(lblTatouageAnimal, gbc_lblTatouageAnimal);

		textFieldTatouageAnimal = new JTextField();
		GridBagConstraints gbc_textFieldTatouageAnimal = new GridBagConstraints();
		gbc_textFieldTatouageAnimal.gridwidth = 2;
		gbc_textFieldTatouageAnimal.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldTatouageAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTatouageAnimal.gridx = 1;
		gbc_textFieldTatouageAnimal.gridy = 7;
		GestionAnimal.getContentPane().add(textFieldTatouageAnimal, gbc_textFieldTatouageAnimal);
		textFieldTatouageAnimal.setColumns(10);

		//////////////////////////////////////////////////////////////////////////////

		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				setUpTableData2(controlleranimal.getListByClient(table_1.getValueAt(table_1.getSelectedRow(), 0).toString()), entetes2);
			}
		});
		
		btnSearchClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setUpTableData(controller.getClient(textField.getText()), entetes1);
			}
		});

		btnAddClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddClient.setBounds(100, 100, 450, 300);
				AddClient.setVisible(true);
			}
		});

		btnValiderModalAddClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addClient(textFieldNomClient.getText(), textFieldPrenomClient.getText(),
						textFieldAdresse1Client.getText(), textFieldAdresse2Client.getText(), textFieldCodePostalClient.getText(),
						textFieldVilleClient.getText(), textFieldNumTelClient.getText(),
						textFieldEmailClient.getText());
				table_1.setCellSelectionEnabled(false);
				setUpTableData(controller.getList(), entetes1);
				table_1.setCellSelectionEnabled(true);
				AddClient.setVisible(false);
			}
		});

		btnDeleteClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PopupDeleteClient.setBounds(100, 100, 418, 136);
				lbltesvousSurDe.setText("Etes-vous sur de vouloir supprimer ce client ?");
				PopupDeleteClient.setVisible(true);
			}
		});

		btnPopupDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(lbltesvousSurDe.getText().contains("client")){
					controller.removeClient(table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
				}else if (lbltesvousSurDe.getText().contains("animal")){
					controlleranimal.removeAnimal(table_2.getValueAt(table_2.getSelectedRow(), 0).toString());
				}
				setUpTableData(controller.getList(), entetes1);
				PopupDeleteClient.setVisible(false);
			}
		});

		btnPopupCancelDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PopupDeleteClient.setVisible(false);
			}
		});

		btnEditClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditClient.setBounds(100, 100, 480, 330);
				EditClient.setVisible(true);
			}
		});

		btnCancelEditClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditClient.setVisible(false);
			}
		});

		btnConfirmEditClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.updateClient(textFieldCodeClientEdit.getText(), textFieldNomClientEdit.getText(),
						textFieldPrenomClientEdit.getText(), textFieldAdresse1ClientEdit.getText(),
						textFieldAdresse2ClientEdit.getText(), textFieldCodePostalClientEdit.getText(),
						textFieldVilleClientEdit.getText(), textFieldNumTelClientEdit.getText(),
						textFieldAssuranceClientEdit.getText(), textFieldEmailClientEdit.getText(),
						textFieldRemarqueClientEdit.getText());
				setUpTableData(controller.getList(), entetes1);
				EditClient.setVisible(false);
			}
		});

		btnAddAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GestionAnimal.setBounds(100, 100, 540, 375);
				lblNomPrenomClient.setText(table_1.getValueAt(table_1.getSelectedRow(), 1) + " "
				 + (String) table_1.getValueAt(table_1.getSelectedRow(), 2));
				GestionAnimal.setVisible(true);
			}
		});

		btnEditAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GestionAnimal.setBounds(100, 100, 540, 375);
				GestionAnimal.setVisible(true);
			}
		});

		btnDeleteAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PopupDeleteClient.setBounds(100, 100, 418, 136);
				lbltesvousSurDe.setText("Etes-vous sur de vouloir supprimer cet animal ?");
				PopupDeleteClient.setVisible(true);
			}
		});

		btnCancelAddAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GestionAnimal.setVisible(false);
			}
		});

		btnConfirmAddAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controlleranimal.addAnimal(textFieldCodeAnimal.getText(), textFieldNomAnimal.getText(),
						comboBoxGenre.getSelectedItem().toString(), textFieldCouleurAnimal.getText(),
						race.getSelectedItem().toString(), espece.getSelectedItem().toString(),
						table_1.getValueAt(table_1.getSelectedRow(), 0).toString(), textFieldTatouageAnimal.getText());
				setUpTableData2(controlleranimal.getListByClient(table_1.getValueAt(table_1.getSelectedRow(), 0).toString()), entetes2);
				GestionAnimal.setVisible(false);
			}
		});

		espece.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboboxModel = new DefaultComboBoxModel<String>(
						controlleranimal.getRace(espece.getSelectedItem().toString()));
				race.setModel(comboboxModel);
			}
		});
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
	
	private void setUpTableData2(Object[][] data, String[] entetes) {
		tableModel = new DefaultTableModel(data, entetes) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_2.setModel(tableModel);
		tableModel.fireTableDataChanged();
	}
}
