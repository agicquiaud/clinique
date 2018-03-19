package fr.eni.clinique.ihm.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.ihm.controller.ControllerAnimaux;
import fr.eni.clinique.ihm.controller.ControllerClients;

public class WindowClients {

	private JFrame frame;
	private DefaultTableModel tableModel;
	private ComboBoxModel<String> comboboxModel;
	private JTable table_1;
	private JTable table_2;
	private ControllerClients controller;
	private ControllerAnimaux controlleranimal;
	private JTextField textFieldSearch;
	private JDialog EditClient = new JDialog();
	private JDialog EditAnimal = new JDialog();
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
	private JTextField textFieldNomAnimalEditAnimal;
	private JTextField textFieldCouleurEditAnimal;
	private JTextField textFieldTatouageEditAnimal;
	private JTextField textFieldAntecedentsEditAnimal;

	public WindowClients() {
		controller = new ControllerClients();
		controlleranimal = new ControllerAnimaux();
		frame = new JFrame();
		frame.setTitle("Gestion Clients");
		frame.setBounds(100, 100, 890, 485);
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
		Object[][] donnee2 = new Object[0][0];
		table_2 = new JTable(donnee2, entetes2);
		scrollPane_1.setViewportView(table_2);

		JLabel lblError = new JLabel("");
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

		// Edit Animal
		// --------------------------------------------------------------------------------------

		EditAnimal.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		EditAnimal.setTitle("Gestion Animal");
		GridBagLayout gbl_EditAnimal = new GridBagLayout();
		gbl_EditAnimal.columnWidths = new int[] { 0, 84, 0, 67, 0, 0, 0 };
		gbl_EditAnimal.rowHeights = new int[] { 93, 64, 0, 35, 35, 0, 0, 0, 0, 0, 0 };
		gbl_EditAnimal.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0 };
		gbl_EditAnimal.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		EditAnimal.getContentPane().setLayout(gbl_EditAnimal);

		JDesktopPane desktopPaneEditAnimal = new JDesktopPane();
		desktopPaneEditAnimal.setBorder(null);
		desktopPaneEditAnimal.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_desktopPaneEditAnimal = new GridBagConstraints();
		gbc_desktopPaneEditAnimal.gridwidth = 7;
		gbc_desktopPaneEditAnimal.insets = new Insets(0, 0, 5, 0);
		gbc_desktopPaneEditAnimal.fill = GridBagConstraints.BOTH;
		gbc_desktopPaneEditAnimal.gridx = 0;
		gbc_desktopPaneEditAnimal.gridy = 0;
		EditAnimal.getContentPane().add(desktopPaneEditAnimal, gbc_desktopPaneEditAnimal);

		JButton btnValiderEditAnimal = new JButton();
		btnValiderEditAnimal.setForeground(new Color(255, 255, 255));
		btnValiderEditAnimal.setBackground(new Color(255, 255, 255));
		btnValiderEditAnimal.setIcon(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/checked32.png"));
		btnValiderEditAnimal.setBounds(320, 18, 58, 44);
		desktopPaneEditAnimal.add(btnValiderEditAnimal);

		JButton btnAnnulerEditAnimal = new JButton();
		btnAnnulerEditAnimal.setForeground(new Color(255, 255, 255));
		btnAnnulerEditAnimal.setBackground(new Color(255, 255, 255));
		btnAnnulerEditAnimal.setIcon(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/cancel.png"));
		btnAnnulerEditAnimal.setBounds(400, 18, 58, 44);
		desktopPaneEditAnimal.add(btnAnnulerEditAnimal);

		JDesktopPane desktopPaneEditAnimal_1 = new JDesktopPane();
		desktopPaneEditAnimal_1.setBackground(UIManager.getColor("Button.background"));
		desktopPaneEditAnimal_1.setBorder(null);
		GridBagConstraints gbc_desktopPaneEditAnimal_1 = new GridBagConstraints();
		gbc_desktopPaneEditAnimal_1.gridwidth = 7;
		gbc_desktopPaneEditAnimal_1.insets = new Insets(0, 0, 5, 0);
		gbc_desktopPaneEditAnimal_1.fill = GridBagConstraints.BOTH;
		gbc_desktopPaneEditAnimal_1.gridx = 0;
		gbc_desktopPaneEditAnimal_1.gridy = 1;
		EditAnimal.getContentPane().add(desktopPaneEditAnimal_1, gbc_desktopPaneEditAnimal_1);

		JLabel lblClientEditAnimal = new JLabel("Client :");
		lblClientEditAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		lblClientEditAnimal.setBounds(22, 11, 46, 14);
		desktopPaneEditAnimal_1.add(lblClientEditAnimal);

		JLabel lblNomClientEditAnimal = new JLabel();
		lblNomClientEditAnimal.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		lblNomClientEditAnimal.setBounds(43, 30, 265, 14);
		desktopPaneEditAnimal_1.add(lblNomClientEditAnimal);

		JLabel lblCodeEditAnimal = new JLabel("Code : ");
		lblCodeEditAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblCodeEditAnimal = new GridBagConstraints();
		gbc_lblCodeEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodeEditAnimal.gridx = 0;
		gbc_lblCodeEditAnimal.gridy = 2;
		EditAnimal.getContentPane().add(lblCodeEditAnimal, gbc_lblCodeEditAnimal);

		JLabel lblNCodeEditAnimal = new JLabel();
		lblNCodeEditAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblNCodeEditAnimal = new GridBagConstraints();
		gbc_lblNCodeEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblNCodeEditAnimal.gridx = 1;
		gbc_lblNCodeEditAnimal.gridy = 2;
		EditAnimal.getContentPane().add(lblNCodeEditAnimal, gbc_lblNCodeEditAnimal);

		JLabel lblNomAnimalEditAnimal = new JLabel("Nom");
		lblNomAnimalEditAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblNomAnimalEditAnimal = new GridBagConstraints();
		gbc_lblNomAnimalEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomAnimalEditAnimal.gridx = 0;
		gbc_lblNomAnimalEditAnimal.gridy = 3;
		EditAnimal.getContentPane().add(lblNomAnimalEditAnimal, gbc_lblNomAnimalEditAnimal);

		textFieldNomAnimalEditAnimal = new JTextField();
		GridBagConstraints gbc_textFieldNomAnimalEditAnimal = new GridBagConstraints();
		gbc_textFieldNomAnimalEditAnimal.gridwidth = 3;
		gbc_textFieldNomAnimalEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNomAnimalEditAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomAnimalEditAnimal.gridx = 1;
		gbc_textFieldNomAnimalEditAnimal.gridy = 3;
		EditAnimal.getContentPane().add(textFieldNomAnimalEditAnimal, gbc_textFieldNomAnimalEditAnimal);
		textFieldNomAnimalEditAnimal.setColumns(10);

		String[] Genre = {"Male", "Femelle", "Hermaphrodite"};
		JComboBox<String> comboboxgenreEditAnimal = new JComboBox<String>(Genre);
		GridBagConstraints gbc_comboboxgenreEditAnimal = new GridBagConstraints();
		comboboxgenreEditAnimal.setBackground(new Color(255, 255, 255));
		gbc_comboboxgenreEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_comboboxgenreEditAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboboxgenreEditAnimal.gridx = 5;
		gbc_comboboxgenreEditAnimal.gridy = 3;
		EditAnimal.getContentPane().add(comboboxgenreEditAnimal, gbc_comboboxgenreEditAnimal);

		JLabel lblCouleurEditAnimal = new JLabel("Couleur");
		lblCouleurEditAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblCouleurEditAnimal = new GridBagConstraints();
		gbc_lblCouleurEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCouleurEditAnimal.gridx = 0;
		gbc_lblCouleurEditAnimal.gridy = 4;
		EditAnimal.getContentPane().add(lblCouleurEditAnimal, gbc_lblCouleurEditAnimal);

		textFieldCouleurEditAnimal = new JTextField();
		GridBagConstraints gbc_textFieldCouleurEditAnimal = new GridBagConstraints();
		gbc_textFieldCouleurEditAnimal.gridwidth = 3;
		gbc_textFieldCouleurEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCouleurEditAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCouleurEditAnimal.gridx = 1;
		gbc_textFieldCouleurEditAnimal.gridy = 4;
		EditAnimal.getContentPane().add(textFieldCouleurEditAnimal, gbc_textFieldCouleurEditAnimal);
		textFieldCouleurEditAnimal.setColumns(10);

		JLabel lblEspeceEditAnimal = new JLabel("Espece");
		lblEspeceEditAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblEspeceEditAnimal = new GridBagConstraints();
		gbc_lblEspeceEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspeceEditAnimal.gridx = 0;
		gbc_lblEspeceEditAnimal.gridy = 5;
		EditAnimal.getContentPane().add(lblEspeceEditAnimal, gbc_lblEspeceEditAnimal);

		JComboBox<String> comboBoxEspeceEditAnimal = new JComboBox<String>(controlleranimal.getEspece());
		GridBagConstraints gbc_comboBoxEspeceEditAnimal = new GridBagConstraints();
		gbc_comboBoxEspeceEditAnimal.gridwidth = 2;
		comboBoxEspeceEditAnimal.setBackground(new Color(255, 255, 255));
		gbc_comboBoxEspeceEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxEspeceEditAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxEspeceEditAnimal.gridx = 1;
		gbc_comboBoxEspeceEditAnimal.gridy = 5;
		EditAnimal.getContentPane().add(comboBoxEspeceEditAnimal, gbc_comboBoxEspeceEditAnimal);

		JLabel lblRaceEditAnimal = new JLabel("Race");
		lblRaceEditAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblRaceEditAnimal = new GridBagConstraints();
		gbc_lblRaceEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblRaceEditAnimal.anchor = GridBagConstraints.EAST;
		gbc_lblRaceEditAnimal.gridx = 3;
		gbc_lblRaceEditAnimal.gridy = 5;
		EditAnimal.getContentPane().add(lblRaceEditAnimal, gbc_lblRaceEditAnimal);

		JComboBox<String> comboBoxRaceEditAnimal = new JComboBox<String>(
				controlleranimal.getRace(comboBoxEspeceEditAnimal.getSelectedItem().toString()));
		GridBagConstraints gbc_comboBoxRaceEditAnimal = new GridBagConstraints();
		gbc_comboBoxRaceEditAnimal.gridwidth = 2;
		comboBoxRaceEditAnimal.setBackground(new Color(255, 255, 255));
		gbc_comboBoxRaceEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxRaceEditAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxRaceEditAnimal.gridx = 4;
		gbc_comboBoxRaceEditAnimal.gridy = 5;
		EditAnimal.getContentPane().add(comboBoxRaceEditAnimal, gbc_comboBoxRaceEditAnimal);

		JLabel lblTatouageEditAnimal = new JLabel("Tatouage");
		lblTatouageEditAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblTatouageEditAnimal = new GridBagConstraints();
		gbc_lblTatouageEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTatouageEditAnimal.gridx = 0;
		gbc_lblTatouageEditAnimal.gridy = 6;
		EditAnimal.getContentPane().add(lblTatouageEditAnimal, gbc_lblTatouageEditAnimal);

		textFieldTatouageEditAnimal = new JTextField();
		GridBagConstraints gbc_textFieldTatouageEditAnimal = new GridBagConstraints();
		gbc_textFieldTatouageEditAnimal.gridwidth = 3;
		gbc_textFieldTatouageEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTatouageEditAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTatouageEditAnimal.gridx = 1;
		gbc_textFieldTatouageEditAnimal.gridy = 6;
		EditAnimal.getContentPane().add(textFieldTatouageEditAnimal, gbc_textFieldTatouageEditAnimal);
		textFieldTatouageEditAnimal.setColumns(10);

		JLabel lblAntecedentsEditAnimal = new JLabel("Antecedents");
		lblAntecedentsEditAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblAntecedentsEditAnimal = new GridBagConstraints();
		gbc_lblAntecedentsEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntecedentsEditAnimal.gridx = 0;
		gbc_lblAntecedentsEditAnimal.gridy = 7;
		EditAnimal.getContentPane().add(lblAntecedentsEditAnimal, gbc_lblAntecedentsEditAnimal);

		textFieldAntecedentsEditAnimal = new JTextField();
		textFieldAntecedentsEditAnimal.setColumns(10);
		GridBagConstraints gbc_textFieldAntecedentsEditAnimal = new GridBagConstraints();
		gbc_textFieldAntecedentsEditAnimal.gridheight = 2;
		gbc_textFieldAntecedentsEditAnimal.gridwidth = 3;
		gbc_textFieldAntecedentsEditAnimal.fill = GridBagConstraints.BOTH;
		gbc_textFieldAntecedentsEditAnimal.gridx = 1;
		gbc_textFieldAntecedentsEditAnimal.gridy = 7;
		EditAnimal.getContentPane().add(textFieldAntecedentsEditAnimal, gbc_textFieldAntecedentsEditAnimal);

		//////////////////////////////////////////////////////////////////////////////

		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					// fait une maj du tableau avec les nouvelles données
					setUpTableData2(controlleranimal
							.getListByClient(table_1.getValueAt(table_1.getSelectedRow(), 0).toString()), entetes2);
				} catch (Exception err) {
					setUpTableData2(null, entetes2);
				}
			}
		});

		// Boutons Gestion Client

		btnSearchClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblError.setText("");
				if (textFieldSearch.getText().equals("")) {
					setUpTableData(controller.getList(), entetes1);
				} else {
					setUpTableData(controller.getClient(textFieldSearch.getText()), entetes1);
				}
			}
		});

		btnAddClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblError.setText("");
				new WindowAddClient();
			}
		});

		btnDeleteClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					lblError.setText("");
					new WindowRemove(controller.getClientbyId(table_1.getValueAt(table_1.getSelectedRow(), 0).toString()));
				} catch (Exception err) {
					lblError.setText("Aucun client selectionné pour le supprimer");
				}

			}
		});

		btnEditClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					lblError.setText("");
					EditClient.setBounds(100, 100, 480, 330);
					Clients clients = controller.getClientbyId(table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
					
					textFieldCodeClientEdit.setText(clients.getCodeClient().toString());
					textFieldAssuranceClientEdit.setText(clients.getAssurance());
					textFieldNomClientEdit.setText(clients.getNom());
					textFieldEmailClientEdit.setText(clients.getEmail());
					textFieldPrenomClientEdit.setText(clients.getPrenom());
					textFieldRemarqueClientEdit.setText(clients.getRemarque());
					textFieldAdresse1ClientEdit.setText(clients.getAdresse1());
					textFieldAdresse2ClientEdit.setText(clients.getAdresse2());
					textFieldVilleClientEdit.setText(clients.getVille());
					textFieldCodePostalClientEdit.setText(clients.getCodePostal());
					textFieldNumTelClientEdit.setText(clients.getNumTel());

					EditClient.setVisible(true);
				} catch (Exception err) {
					lblError.setText("Aucun client selectionné pour le modifier");
				}
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

		// Boutons Gestion Animal
		
		comboBoxEspeceEditAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboboxModel = new DefaultComboBoxModel<String>(
						controlleranimal.getRace(comboBoxEspeceEditAnimal.getSelectedItem().toString()));
				comboBoxRaceEditAnimal.setModel(comboboxModel);
			}
		});

		btnAddAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					lblError.setText("");
					new WindowAddAnimal(new Clients());
				} catch (Exception err) {
					lblError.setText("Aucun client selectionné pour luil ajouter un animal");
				}
			}
		});

		btnEditAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(table_1.toString());
				System.out.println(table_1.getSelectedColumn());
				System.out.println(table_1.getSelectedRow());
				lblError.setText("");
				if (table_2.getSelectedRow() == -1 && table_2.getSelectedColumn() == -1) {
					lblError.setText("Aucun animal sélectionner !");
				} else {
					resetTextField(EditAnimal.getContentPane());

					lblNomClientEditAnimal.setText(table_1.getValueAt(table_1.getSelectedRow(), 1) + " "
							+ (String) table_1.getValueAt(table_1.getSelectedRow(), 2));
					lblNCodeEditAnimal.setText(table_2.getValueAt(table_2.getSelectedRow(), 0).toString());
					Animaux animal = controlleranimal.getAnimalById(table_2.getValueAt(table_2.getSelectedRow(), 0).toString());
					
					textFieldNomAnimalEditAnimal.setText(animal.getNom());
					textFieldCouleurEditAnimal.setText(animal.getCouleur());
					textFieldTatouageEditAnimal.setText(animal.getTatouage());
					textFieldAntecedentsEditAnimal.setText(animal.getAntecedents());
					comboboxgenreEditAnimal.setSelectedItem(animal.getSexe());
					comboBoxEspeceEditAnimal.setSelectedItem(animal.getEspece());
					comboBoxRaceEditAnimal.setSelectedItem(animal.getRace());
					EditAnimal.setBounds(100, 100, 500, 400);
					EditAnimal.setVisible(true);
				}

			}
		});

		btnDeleteAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					lblError.setText("");
					new WindowRemove(controlleranimal.getAnimalById(table_2.getValueAt(table_2.getSelectedRow(), 0).toString()));
				} catch (Exception err) {
					lblError.setText("Aucun animal selectionné pour le modifier");
				}
			}
		});

		// bouton checked Edit Animal Jdialogue Edit
		btnValiderEditAnimal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controlleranimal.updateClient(table_2.getValueAt(table_2.getSelectedRow(), 0).toString(),
						textFieldNomAnimalEditAnimal.getText(), comboboxgenreEditAnimal.getSelectedItem().toString(),
						textFieldCouleurEditAnimal.getText(), comboBoxRaceEditAnimal.getSelectedItem().toString(),
						comboBoxEspeceEditAnimal.getSelectedItem().toString(), lblNCodeEditAnimal.getText(),
						textFieldTatouageEditAnimal.getText(), textFieldAntecedentsEditAnimal.getText());
				setUpTableData2(
						controlleranimal.getListByClient(table_1.getValueAt(table_1.getSelectedRow(), 0).toString()),
						entetes2);
				EditAnimal.setVisible(false);
			}
		});

		btnAnnulerEditAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditAnimal.setVisible(false);
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
		tableModel = new DefaultTableModel(data, entetes) { // nouveau model
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table_2.setModel(tableModel);
		tableModel.fireTableDataChanged(); // maj tableau
	}

	private void resetTextField(Container frame) {
		JTextField temp = null;
		for (Component c : frame.getComponents()) {
			if (c instanceof JTextComponent) {
				temp = (JTextField) c;
				temp.setText("");
			}
		}
	}
}
