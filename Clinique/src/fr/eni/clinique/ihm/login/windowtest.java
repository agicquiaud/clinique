package fr.eni.clinique.ihm.login;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class windowtest {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnValider;
	private JTextField textField_5;
	private JTable table;
	private ControllerPersonnels controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowtest window = new windowtest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public windowtest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 126, 126, 126, 0, 0};
		gridBagLayout.rowHeights = new int[]{1, 20, 25, 0, 52, 0, 25, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
//		JLabel lblNewLabel = new JLabel("Panneau Supprimer Personnel");
//		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
//		gbc_lblNewLabel.gridwidth = 2;
//		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
//		gbc_lblNewLabel.gridx = 1;
//		gbc_lblNewLabel.gridy = 1;
//		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
//		
//		JLabel lblNom = new JLabel("Nom");
//		GridBagConstraints gbc_lblNom = new GridBagConstraints();
//		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
//		gbc_lblNom.gridx = 1;
//		gbc_lblNom.gridy = 2;
//		frame.getContentPane().add(lblNom, gbc_lblNom);
//		
//		textField_5 = new JTextField();
//		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
//		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
//		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField_5.gridx = 2;
//		gbc_textField_5.gridy = 2;
//		frame.getContentPane().add(textField_5, gbc_textField_5);
//		textField_5.setColumns(10);
//		
//		JButton btnSupprimer = new JButton("SUPPRIMER");
//		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
//		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 5);
//		gbc_btnSupprimer.gridx = 2;
//		gbc_btnSupprimer.gridy = 4;
//		frame.getContentPane().add(btnSupprimer, gbc_btnSupprimer);
		
//		PANEL Ajout personnel--------------------------------------------------------------------------------------
//		JLabel lblPanneauAjoutPersonnel = new JLabel("             Panneau Ajout Personnel");
//		GridBagConstraints gbc_lblPanneauAjoutPersonnel = new GridBagConstraints();
//		gbc_lblPanneauAjoutPersonnel.anchor = GridBagConstraints.WEST;
//		gbc_lblPanneauAjoutPersonnel.gridwidth = 2;
//		gbc_lblPanneauAjoutPersonnel.insets = new Insets(0, 0, 5, 5);
//		gbc_lblPanneauAjoutPersonnel.gridx = 1;
//		gbc_lblPanneauAjoutPersonnel.gridy = 1;
//		frame.getContentPane().add(lblPanneauAjoutPersonnel, gbc_lblPanneauAjoutPersonnel);
//		
//		JLabel lblNewLabel = new JLabel("Nom");
//		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
//		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
//		gbc_lblNewLabel.gridx = 1;
//		gbc_lblNewLabel.gridy = 2;
//		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
//		
//		textField_2 = new JTextField();
//		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
//		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
//		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField_2.gridx = 2;
//		gbc_textField_2.gridy = 2;
//		frame.getContentPane().add(textField_2, gbc_textField_2);
//		textField_2.setColumns(10);
//		
//		JLabel lblType = new JLabel("Type");
//		GridBagConstraints gbc_lblType = new GridBagConstraints();
//		gbc_lblType.insets = new Insets(0, 0, 5, 5);
//		gbc_lblType.gridx = 1;
//		gbc_lblType.gridy = 3;
//		frame.getContentPane().add(lblType, gbc_lblType);
//		
//		textField_3 = new JTextField();
//		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
//		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
//		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField_3.gridx = 2;
//		gbc_textField_3.gridy = 3;
//		frame.getContentPane().add(textField_3, gbc_textField_3);
//		textField_3.setColumns(10);
//		
//		JLabel lblPassword = new JLabel("Password");
//		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
//		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
//		gbc_lblPassword.gridx = 1;
//		gbc_lblPassword.gridy = 4;
//		frame.getContentPane().add(lblPassword, gbc_lblPassword);
//		
//		textField_4 = new JTextField();
//		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
//		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
//		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField_4.gridx = 2;
//		gbc_textField_4.gridy = 4;
//		frame.getContentPane().add(textField_4, gbc_textField_4);
//		textField_4.setColumns(10);
//		
//		btnValider = new JButton("Valider");
//		GridBagConstraints gbc_btnValider = new GridBagConstraints();
//		gbc_btnValider.insets = new Insets(0, 0, 5, 5);
//		gbc_btnValider.gridx = 3;
//		gbc_btnValider.gridy = 5;
//		frame.getContentPane().add(btnValider, gbc_btnValider);
		
//		PANEL PRINCIPAL--------------------------------------------------------------------------------------
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		frame.getContentPane().add(panel_5, gbc_panel_5);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		frame.getContentPane().add(panel, gbc_panel);
		
		JButton btnNewButton = new JButton("AJOUTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 1;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		
		JButton btnNewButton_1 = new JButton("SUPPRIMER");
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 3;
		gbc_panel_2.gridy = 1;
		frame.getContentPane().add(panel_2, gbc_panel_2);
		
		JButton btnNewButton_2 = new JButton("REINITIALISER");
		panel_2.add(btnNewButton_2);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 4;
		gbc_panel_4.gridy = 1;
		frame.getContentPane().add(panel_4, gbc_panel_4);
		String[] entetes = {"Nom", "Role", "Mot de passe"};
		Object[][] donnee = new ControllerPersonnels().getList();
		
		table = new JTable(donnee, entetes);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 3;
		gbc_table.gridheight = 6;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 2;
		frame.getContentPane().add(table, gbc_table);

	}

}
