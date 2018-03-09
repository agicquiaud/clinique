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
	private JTextField textFieldNomClient;
	private JTextField textFieldPrenomClient;
	private JTextField textFieldAdresseClient;
	private JTextField textFieldCodePostalClient;
	private JTextField textFieldVilleClient;
	private JTextField textFieldNumTelClient;
	private JTextField textFieldEmailClient;

	public WindowClients() {
		controller = new ControllerClients();
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
		Object[][] donnee2 = controller.getList();
		table_2 = new JTable(donnee2, entetes2);
		scrollPane_1.setViewportView(table_2);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		frame.getContentPane().add(panel_1, gbc_panel_1);

		JButton btnAjouter = new JButton("Ajouter");
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 5);
		gbc_btnAjouter.gridx = 7;
		gbc_btnAjouter.gridy = 4;
		frame.getContentPane().add(btnAjouter, gbc_btnAjouter);

		JButton btnNewButton_5 = new JButton("Supprimer");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 8;
		gbc_btnNewButton_5.gridy = 4;
		frame.getContentPane().add(btnNewButton_5, gbc_btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Editer");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 9;
		gbc_btnNewButton_6.gridy = 4;
		frame.getContentPane().add(btnNewButton_6, gbc_btnNewButton_6);

		JButton btnNewButton_4 = new JButton("Annuler");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JButton btnNewButton_3 = new JButton("Valider");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 8;
		gbc_btnNewButton_3.gridy = 1;
		frame.getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 9;
		gbc_btnNewButton_4.gridy = 1;
		frame.getContentPane().add(btnNewButton_4, gbc_btnNewButton_4);

		// Modal Add Client
		// --------------------------------------------------------------------------------------

		GridBagLayout gridBagLayoutModalReset = new GridBagLayout();
		gridBagLayoutModalReset.columnWidths = new int[] { 50, 0, 0, 0, 0, 140, 0, 0, 0, 0, 0, 100, 0 };
		gridBagLayoutModalReset.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayoutModalReset.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gridBagLayoutModalReset.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		AddClient.getContentPane().setLayout(gridBagLayoutModalReset);

		JLabel lblAddClient = new JLabel("Nouveau Client");
		GridBagConstraints gbc_lblAddClient = new GridBagConstraints();
		gbc_lblAddClient.gridwidth = 8;
		gbc_lblAddClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddClient.gridx = 3;
		gbc_lblAddClient.gridy = 2;
		AddClient.getContentPane().add(lblAddClient, gbc_lblAddClient);

		JLabel lblNomClient = new JLabel("Nom");
		GridBagConstraints gbc_lblNomClient = new GridBagConstraints();
		gbc_lblNomClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomClient.gridx = 3;
		gbc_lblNomClient.gridy = 3;
		AddClient.getContentPane().add(lblNomClient, gbc_lblNomClient);

		textFieldNomClient = new JTextField();
		GridBagConstraints gbc_textFieldNomClient = new GridBagConstraints();
		gbc_textFieldNomClient.gridwidth = 4;
		gbc_textFieldNomClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNomClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomClient.gridx = 6;
		gbc_textFieldNomClient.gridy = 3;
		AddClient.getContentPane().add(textFieldNomClient, gbc_textFieldNomClient);

		JLabel lblPrenomClient = new JLabel("Prenom");
		GridBagConstraints gbc_lblPrenomClient = new GridBagConstraints();
		gbc_lblPrenomClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenomClient.gridx = 3;
		gbc_lblPrenomClient.gridy = 4;
		AddClient.getContentPane().add(lblPrenomClient, gbc_lblPrenomClient);

		textFieldPrenomClient = new JTextField();
		GridBagConstraints gbc_textFieldPrenomClient = new GridBagConstraints();
		gbc_textFieldPrenomClient.gridwidth = 4;
		gbc_textFieldPrenomClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrenomClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrenomClient.gridx = 6;
		gbc_textFieldPrenomClient.gridy = 4;
		AddClient.getContentPane().add(textFieldPrenomClient, gbc_textFieldPrenomClient);

		JLabel lblAdresseClient = new JLabel("Adresse");
		GridBagConstraints gbc_lblAdresseClient = new GridBagConstraints();
		gbc_lblAdresseClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresseClient.gridx = 3;
		gbc_lblAdresseClient.gridy = 5;
		AddClient.getContentPane().add(lblAdresseClient, gbc_lblAdresseClient);

		textFieldAdresseClient = new JTextField();
		GridBagConstraints gbc_textFieldAdresseClient = new GridBagConstraints();
		gbc_textFieldAdresseClient.gridwidth = 4;
		gbc_textFieldAdresseClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresseClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresseClient.gridx = 6;
		gbc_textFieldAdresseClient.gridy = 5;
		AddClient.getContentPane().add(textFieldAdresseClient, gbc_textFieldAdresseClient);

		JLabel lblCodePostalClient = new JLabel("Code Postal");
		GridBagConstraints gbc_lblCodePostalClient = new GridBagConstraints();
		gbc_lblCodePostalClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodePostalClient.gridx = 3;
		gbc_lblCodePostalClient.gridy = 6;
		AddClient.getContentPane().add(lblCodePostalClient, gbc_lblCodePostalClient);

		textFieldCodePostalClient = new JTextField();
		GridBagConstraints gbc_textFieldCodePostalClient = new GridBagConstraints();
		gbc_textFieldCodePostalClient.gridwidth = 4;
		gbc_textFieldCodePostalClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodePostalClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodePostalClient.gridx = 6;
		gbc_textFieldCodePostalClient.gridy = 6;
		AddClient.getContentPane().add(textFieldCodePostalClient, gbc_textFieldCodePostalClient);

		JLabel lblVilleClient = new JLabel("Ville");
		GridBagConstraints gbc_lblVilleClient = new GridBagConstraints();
		gbc_lblVilleClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblVilleClient.gridx = 3;
		gbc_lblVilleClient.gridy = 7;
		AddClient.getContentPane().add(lblVilleClient, gbc_lblVilleClient);

		textFieldVilleClient = new JTextField();
		GridBagConstraints gbc_textFieldVilleClient = new GridBagConstraints();
		gbc_textFieldVilleClient.gridwidth = 4;
		gbc_textFieldVilleClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldVilleClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVilleClient.gridx = 6;
		gbc_textFieldVilleClient.gridy = 7;
		AddClient.getContentPane().add(textFieldVilleClient, gbc_textFieldVilleClient);

		JLabel lblNumTelClient = new JLabel("Num. Tel");
		GridBagConstraints gbc_lblNumTelClient = new GridBagConstraints();
		gbc_lblNumTelClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumTelClient.gridx = 3;
		gbc_lblNumTelClient.gridy = 8;
		AddClient.getContentPane().add(lblNumTelClient, gbc_lblNumTelClient);

		textFieldNumTelClient = new JTextField();
		GridBagConstraints gbc_textFieldNumTelClient = new GridBagConstraints();
		gbc_textFieldNumTelClient.gridwidth = 4;
		gbc_textFieldNumTelClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNumTelClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNumTelClient.gridx = 6;
		gbc_textFieldNumTelClient.gridy = 8;
		AddClient.getContentPane().add(textFieldNumTelClient, gbc_textFieldNumTelClient);

		JLabel lblEmailClient = new JLabel("Email");
		GridBagConstraints gbc_lblEmailClient = new GridBagConstraints();
		gbc_lblEmailClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailClient.gridx = 3;
		gbc_lblEmailClient.gridy = 9;
		AddClient.getContentPane().add(lblEmailClient, gbc_lblEmailClient);

		textFieldEmailClient = new JTextField();
		GridBagConstraints gbc_textFieldEmailClient = new GridBagConstraints();
		gbc_textFieldEmailClient.gridwidth = 4;
		gbc_textFieldEmailClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmailClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmailClient.gridx = 6;
		gbc_textFieldEmailClient.gridy = 9;
		AddClient.getContentPane().add(textFieldEmailClient, gbc_textFieldEmailClient);

		JButton btnValiderModalAddClient = new JButton("VALIDER");
		GridBagConstraints gbc_btnValiderModalAdd = new GridBagConstraints();
		gbc_btnValiderModalAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnValiderModalAdd.gridx = 8;
		gbc_btnValiderModalAdd.gridy = 10;
		AddClient.getContentPane().add(btnValiderModalAddClient, gbc_btnValiderModalAdd);

		btnValiderModalAddClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		JButton btnAnnulerModalCancelClient = new JButton("ANNULER");
		GridBagConstraints gbc_btnAnnulerModalCancelClient = new GridBagConstraints();
		gbc_btnAnnulerModalCancelClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnulerModalCancelClient.gridx = 9;
		gbc_btnAnnulerModalCancelClient.gridy = 10;
		AddClient.getContentPane().add(btnAnnulerModalCancelClient, gbc_btnAnnulerModalCancelClient);

		/////////////////////////////////////////////////////////////////////////////////////////

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
				controller.addClient(textFieldNomClient.getText(), textFieldPrenomClient.getText(), textFieldAdresseClient.getText(), textFieldCodePostalClient.getText(), textFieldVilleClient.getText(), textFieldNumTelClient.getText(), textFieldEmailClient.getText());
				setUpTableData(controller.getList(), entetes1);
				AddClient.setVisible(false);
			}
		});

		btnDeleteClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.removeClient((Integer) table_1.getValueAt(table_1.getSelectedRow(), 0));
			}
		});
	}
	
	private void setUpTableData(Object[][] data, String[] entetes){
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
