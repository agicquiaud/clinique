package fr.eni.clinique.ihm.login;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import fr.eni.clinique.bo.User;

public class WindowGestionPersonnels {

	private JFrame frameGestionPersonnel;
	private JTable table;
	private JDialog AjoutPersonnel = new JDialog();
	private JDialog ResetMdp = new JDialog();
	private ControllerPersonnels controller;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public WindowGestionPersonnels() {
		controller = new ControllerPersonnels();
		frameGestionPersonnel = new JFrame();
		frameGestionPersonnel.setTitle("Gestion Personnel");
		frameGestionPersonnel.setBounds(100, 100, 450, 300);
		frameGestionPersonnel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGestionPersonnel.setVisible(true);
		JLabel label = new JLabel(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/backgroung.jpg"));
		frameGestionPersonnel.setContentPane(label);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 25, 112, 146, 0 };
		gridBagLayout.rowHeights = new int[] { 80, 20, 21, 101, 24 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frameGestionPersonnel.getContentPane().setLayout(gridBagLayout);

		JButton btnAjouter = new JButton("AJOUTER");
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 5);
		gbc_btnAjouter.gridx = 0;
		gbc_btnAjouter.gridy = 0;
		frameGestionPersonnel.getContentPane().add(btnAjouter, gbc_btnAjouter);

		JButton btnSupprimer = new JButton("SUPPRIMER");
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimer.gridx = 1;
		gbc_btnSupprimer.gridy = 0;
		frameGestionPersonnel.getContentPane().add(btnSupprimer, gbc_btnSupprimer);

		JButton btnReinitialiser = new JButton("REINITIALISER");
		GridBagConstraints gbc_btnReinitialiser = new GridBagConstraints();
		gbc_btnReinitialiser.insets = new Insets(0, 0, 5, 0);
		gbc_btnReinitialiser.gridx = 2;
		gbc_btnReinitialiser.gridy = 0;
		frameGestionPersonnel.getContentPane().add(btnReinitialiser, gbc_btnReinitialiser);
		
				JLabel lblerror = new JLabel("");
				GridBagConstraints gbc_lblerror = new GridBagConstraints();
				gbc_lblerror.insets = new Insets(0, 0, 5, 5);
				gbc_lblerror.gridx = 0;
				gbc_lblerror.gridy = 1;
				frameGestionPersonnel.getContentPane().add(lblerror, gbc_lblerror);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		frameGestionPersonnel.getContentPane().add(scrollPane, gbc_scrollPane);

		String[] entetes = { "Nom", "Mot de passe", "Role" };
		Object[][] donnee = controller.getList();
		table = new JTable(donnee, entetes);
		DefaultTableModel tableModel = new DefaultTableModel(donnee, entetes) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		JLabel lblNewLabelGP = new JLabel("");
		GridBagConstraints gbc_lblNewLabelGP = new GridBagConstraints();
		gbc_lblNewLabelGP.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabelGP.gridwidth = 3;
		gbc_lblNewLabelGP.gridx = 0;
		gbc_lblNewLabelGP.gridy = 4;
		frameGestionPersonnel.getContentPane().add(lblNewLabelGP, gbc_lblNewLabelGP);

		// Modal Add Personnel
		// --------------------------------------------------------------------------------------

		GridBagLayout gridBagLayoutModalAdd = new GridBagLayout();
		gridBagLayoutModalAdd.columnWidths = new int[] { 50, 0, 0, 140, 0, 100, 0 };
		gridBagLayoutModalAdd.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayoutModalAdd.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayoutModalAdd.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		AjoutPersonnel.getContentPane().setLayout(gridBagLayoutModalAdd);

		JLabel lblAjouterUnePersonne = new JLabel("AJOUTER UNE PERSONNE");
		GridBagConstraints gbc_lblAjouterUnePersonne = new GridBagConstraints();
		gbc_lblAjouterUnePersonne.gridwidth = 2;
		gbc_lblAjouterUnePersonne.insets = new Insets(0, 0, 5, 5);
		gbc_lblAjouterUnePersonne.gridx = 2;
		gbc_lblAjouterUnePersonne.gridy = 1;
		AjoutPersonnel.getContentPane().add(lblAjouterUnePersonne, gbc_lblAjouterUnePersonne);

		JLabel lblPrenom = new JLabel("Nom");
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenom.gridx = 1;
		gbc_lblPrenom.gridy = 3;
		AjoutPersonnel.getContentPane().add(lblPrenom, gbc_lblPrenom);

		JTextField textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 3;
		gbc_textField_6.gridy = 3;
		AjoutPersonnel.getContentPane().add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);

		JLabel lblMotDePasse = new JLabel("Mot de passe");
		GridBagConstraints gbc_lblMotDePasse = new GridBagConstraints();
		gbc_lblMotDePasse.insets = new Insets(0, 0, 5, 5);
		gbc_lblMotDePasse.gridx = 1;
		gbc_lblMotDePasse.gridy = 5;
		AjoutPersonnel.getContentPane().add(lblMotDePasse, gbc_lblMotDePasse);

		JTextField textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 3;
		gbc_textField_7.gridy = 5;
		AjoutPersonnel.getContentPane().add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);

		JLabel lblNom = new JLabel("Type");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 7;
		AjoutPersonnel.getContentPane().add(lblNom, gbc_lblNom);

		String[] role = { "", "adm", "vet", "sec" };
		JComboBox comboBox = new JComboBox(role);
		comboBox.setSelectedIndex(0);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 7;
		AjoutPersonnel.getContentPane().add(comboBox, gbc_comboBox);

		JButton btnValiderModalAjout = new JButton("VALIDER");
		GridBagConstraints gbc_btnValider_1 = new GridBagConstraints();
		gbc_btnValider_1.gridx = 5;
		gbc_btnValider_1.gridy = 8;
		AjoutPersonnel.getContentPane().add(btnValiderModalAjout, gbc_btnValider_1);

		// Modal Reinitialiser Personnel
		// --------------------------------------------------------------------------------------

		GridBagLayout gridBagLayoutModalReset = new GridBagLayout();
		gridBagLayoutModalReset.columnWidths = new int[] { 50, 0, 0, 0, 0, 0, 140, 0, 0, 0, 0, 100, 0 };
		gridBagLayoutModalReset.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayoutModalReset.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gridBagLayoutModalReset.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		ResetMdp.getContentPane().setLayout(gridBagLayoutModalReset);

		JLabel lblResetMdp = new JLabel("REINITIALISER LE MOT DE PASSE");
		GridBagConstraints gbc_lblResetMdp = new GridBagConstraints();
		gbc_lblResetMdp.gridwidth = 12;
		gbc_lblResetMdp.insets = new Insets(0, 0, 5, 0);
		gbc_lblResetMdp.gridx = 0;
		gbc_lblResetMdp.gridy = 1;
		ResetMdp.getContentPane().add(lblResetMdp, gbc_lblResetMdp);

		JLabel lblMdp = new JLabel("Nouveau mot de passe");
		GridBagConstraints gbc_lblMdp = new GridBagConstraints();
		gbc_lblMdp.insets = new Insets(0, 0, 5, 5);
		gbc_lblMdp.gridx = 2;
		gbc_lblMdp.gridy = 4;
		ResetMdp.getContentPane().add(lblMdp, gbc_lblMdp);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 7;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 4;
		ResetMdp.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnValiderModalReset = new JButton("VALIDER");
		GridBagConstraints gbc_btnValiderModalReset = new GridBagConstraints();
		gbc_btnValiderModalReset.insets = new Insets(0, 0, 5, 5);
		gbc_btnValiderModalReset.gridx = 10;
		gbc_btnValiderModalReset.gridy = 7;
		ResetMdp.getContentPane().add(btnValiderModalReset, gbc_btnValiderModalReset);

		/////////////////////////////////////////////////////////////////////////////////////////

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				lblNewLabelGP.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
			}
		});
		
		tableModel.addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
 
			}
		});
		
		btnAjouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (controller.verifDroit()) {
					AjoutPersonnel.setBounds(100, 100, 450, 300);
					AjoutPersonnel.setVisible(true);
				} else {
					lblerror.setText("Droit insuffisant");
				}

			}
		});

		btnValiderModalAjout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addPersonnel(new User(textField_6.getText(), textField_7.getText(),
					(String) comboBox.getSelectedItem(), false));
				
				AjoutPersonnel.setVisible(false);
			}
		});

		btnReinitialiser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (controller.verifDroit()) {
					ResetMdp.setBounds(100, 100, 450, 300);
					ResetMdp.setVisible(true);
				} else {
					lblerror.setText("Droit insuffisant");
				}
			}
		});

		btnValiderModalReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.resetMotDePasse(lblNewLabelGP.getText(), textField.getText());
				ResetMdp.setVisible(false);
			}
		});
		
		btnSupprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (controller.verifDroit()) {
					controller.ArchivePersonnel(lblNewLabelGP.getText());
				} else {
					lblerror.setText("Droit insuffisant");
				}
			}
		});
	}
	
	public void setUpTableData(){
		String[] entetes = { "Nom", "Mot de passe", "Role" };
		DefaultTableModel tableModel = new DefaultTableModel(controller.getList(), entetes);
		table.setModel(tableModel);
	}

}
