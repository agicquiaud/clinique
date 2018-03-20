package fr.eni.clinique.ihm.view;


import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class windowtest {

	private JFrame frmGestionAnimal;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnValider;
	private JTextField textField_5;
	private JTable table;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JDialog PopupDeleteAnimal = new JDialog();

	/**
	 * Create the application.
	 */
	public windowtest() {
		JFrame AddAnimal = new JFrame();
		
		AddAnimal.setTitle("Dossier Medical");
		AddAnimal.setBounds(100, 100, 570, 300);
		AddAnimal.setVisible(true);

		AddAnimal.setTitle("Ajouter un animal");
		AddAnimal.setSize(620, 370);
		AddAnimal.setLocationRelativeTo(null);
		AddAnimal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		AddAnimal.setVisible(true);
		
		GridBagLayout gbl_AddAnimal = new GridBagLayout();
		gbl_AddAnimal.columnWidths = new int[] { 115, 210, 31, 38, 150, 63 };
		gbl_AddAnimal.rowHeights = new int[] { 71, 68, 35, 35, 35, 0, 0, 31, 0 };
		gbl_AddAnimal.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_AddAnimal.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		AddAnimal.getContentPane().setLayout(gbl_AddAnimal);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(null);
		desktopPane.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_desktopPane = new GridBagConstraints();
		gbc_desktopPane.gridwidth = 6;
		gbc_desktopPane.insets = new Insets(0, 0, 5, 0);
		gbc_desktopPane.fill = GridBagConstraints.BOTH;
		gbc_desktopPane.gridx = 0;
		gbc_desktopPane.gridy = 0;
		AddAnimal.getContentPane().add(desktopPane, gbc_desktopPane);

		JButton btnConfirmAddAnimal = new JButton();
		btnConfirmAddAnimal.setForeground(new Color(255, 255, 255));
		btnConfirmAddAnimal.setBackground(new Color(255, 255, 255));
		btnConfirmAddAnimal.setIcon(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/checked32.png"));
		btnConfirmAddAnimal.setBounds(420, 11, 58, 44);
		desktopPane.add(btnConfirmAddAnimal);

		JButton btnCancelAddAnimal = new JButton();
		btnCancelAddAnimal.setForeground(new Color(255, 255, 255));
		btnCancelAddAnimal.setBackground(new Color(255, 255, 255));
		btnCancelAddAnimal.setIcon(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/cancel.png"));
		btnCancelAddAnimal.setBounds(500, 11, 58, 44);
		desktopPane.add(btnCancelAddAnimal);

		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBackground(UIManager.getColor("Button.background"));
		desktopPane_1.setBorder(null);
		GridBagConstraints gbc_desktopPane_1 = new GridBagConstraints();
		gbc_desktopPane_1.gridwidth = 6;
		gbc_desktopPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_desktopPane_1.fill = GridBagConstraints.BOTH;
		gbc_desktopPane_1.gridx = 0;
		gbc_desktopPane_1.gridy = 1;
		AddAnimal.getContentPane().add(desktopPane_1, gbc_desktopPane_1);

		JLabel lblClient = new JLabel("Client :");
		lblClient.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
		lblClient.setBounds(22, 11, 46, 14);
		desktopPane_1.add(lblClient);

		JLabel lblNomPrenomClient = new JLabel();
		lblNomPrenomClient.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		lblNomPrenomClient.setBounds(43, 36, 265, 14);
		desktopPane_1.add(lblNomPrenomClient);

		JLabel lblNomAnimal = new JLabel("Nom");
		lblNomAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblNomAnimal = new GridBagConstraints();
		gbc_lblNomAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomAnimal.gridx = 0;
		gbc_lblNomAnimal.gridy = 2;
		AddAnimal.getContentPane().add(lblNomAnimal, gbc_lblNomAnimal);

		JTextField textFieldNomAnimal = new JTextField();
		GridBagConstraints gbc_textFieldNomAnimal = new GridBagConstraints();
		gbc_textFieldNomAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNomAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomAnimal.gridx = 1;
		gbc_textFieldNomAnimal.gridy = 2;
		AddAnimal.getContentPane().add(textFieldNomAnimal, gbc_textFieldNomAnimal);
		textFieldNomAnimal.setColumns(10);

		JComboBox<String> comboBoxGenre = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxGenre = new GridBagConstraints();
		gbc_comboBoxGenre.fill = GridBagConstraints.HORIZONTAL;
		comboBoxGenre.setBackground(new Color(255, 255, 255));
		gbc_comboBoxGenre.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxGenre.gridx = 4;
		gbc_comboBoxGenre.gridy = 2;
		AddAnimal.getContentPane().add(comboBoxGenre, gbc_comboBoxGenre);

		JLabel lblCouleurAnimal = new JLabel("Couleur");
		lblCouleurAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblCouleurAnimal = new GridBagConstraints();
		gbc_lblCouleurAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCouleurAnimal.gridx = 0;
		gbc_lblCouleurAnimal.gridy = 3;
		AddAnimal.getContentPane().add(lblCouleurAnimal, gbc_lblCouleurAnimal);

		JTextField textFieldCouleurAnimal = new JTextField();
		GridBagConstraints gbc_textFieldCouleurAnimal = new GridBagConstraints();
		gbc_textFieldCouleurAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCouleurAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCouleurAnimal.gridx = 1;
		gbc_textFieldCouleurAnimal.gridy = 3;
		AddAnimal.getContentPane().add(textFieldCouleurAnimal, gbc_textFieldCouleurAnimal);
		textFieldCouleurAnimal.setColumns(10);

		JLabel lblEspeceAnimal = new JLabel("Espece");
		lblEspeceAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblEspeceAnimal = new GridBagConstraints();
		gbc_lblEspeceAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspeceAnimal.gridx = 0;
		gbc_lblEspeceAnimal.gridy = 4;
		AddAnimal.getContentPane().add(lblEspeceAnimal, gbc_lblEspeceAnimal);
		
		JComboBox<String> espece = new JComboBox<String>();
		GridBagConstraints gbc_espece = new GridBagConstraints();
		espece.setBackground(new Color(255, 255, 255));
		gbc_espece.insets = new Insets(0, 0, 5, 5);
		gbc_espece.fill = GridBagConstraints.HORIZONTAL;
		gbc_espece.gridx = 1;
		gbc_espece.gridy = 4;
		AddAnimal.getContentPane().add(espece, gbc_espece);

		JLabel lblRaceAnimal = new JLabel("Race");
		lblRaceAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblRaceAnimal = new GridBagConstraints();
		gbc_lblRaceAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblRaceAnimal.anchor = GridBagConstraints.EAST;
		gbc_lblRaceAnimal.gridx = 3;
		gbc_lblRaceAnimal.gridy = 4;
		AddAnimal.getContentPane().add(lblRaceAnimal, gbc_lblRaceAnimal);

		JComboBox<String> race = new JComboBox<String>();
		GridBagConstraints gbc_race = new GridBagConstraints();
		gbc_race.fill = GridBagConstraints.HORIZONTAL;
		race.setBackground(new Color(255, 255, 255));
		gbc_race.insets = new Insets(0, 0, 5, 5);
		gbc_race.gridx = 4;
		gbc_race.gridy = 4;
		AddAnimal.getContentPane().add(race, gbc_race);
		
		JButton buttonAddRace = new JButton();
		buttonAddRace.setOpaque(false);
		buttonAddRace.setBackground(new Color(66, 210, 230));
		buttonAddRace.setBorderPainted(false);
		buttonAddRace.setFocusPainted(false);
		GridBagConstraints gbc_buttonAddRace = new GridBagConstraints();
		gbc_buttonAddRace.anchor = GridBagConstraints.WEST;
		gbc_buttonAddRace.insets = new Insets(0, 0, 5, 0);
		gbc_buttonAddRace.gridx = 5;
		gbc_buttonAddRace.gridy = 4;
		AddAnimal.getContentPane().add(buttonAddRace, gbc_buttonAddRace);

		JLabel lblTatouageAnimal = new JLabel("Tatouage");
		lblTatouageAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblTatouageAnimal = new GridBagConstraints();
		gbc_lblTatouageAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblTatouageAnimal.gridx = 0;
		gbc_lblTatouageAnimal.gridy = 5;
		AddAnimal.getContentPane().add(lblTatouageAnimal, gbc_lblTatouageAnimal);

		JTextField textFieldTatouageAnimal = new JTextField();
		GridBagConstraints gbc_textFieldTatouageAnimal = new GridBagConstraints();
		gbc_textFieldTatouageAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTatouageAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTatouageAnimal.gridx = 1;
		gbc_textFieldTatouageAnimal.gridy = 5;
		AddAnimal.getContentPane().add(textFieldTatouageAnimal, gbc_textFieldTatouageAnimal);
		textFieldTatouageAnimal.setColumns(10);

		JLabel lblAntecedents = new JLabel("Antecedents");
		lblAntecedents.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblAntecedents = new GridBagConstraints();
		gbc_lblAntecedents.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntecedents.gridx = 0;
		gbc_lblAntecedents.gridy = 6;
		AddAnimal.getContentPane().add(lblAntecedents, gbc_lblAntecedents);

		JTextField textFieldAntecedentsAnimal = new JTextField();
		textFieldAntecedentsAnimal.setColumns(10);
		GridBagConstraints gbc_textFieldAntecedentsAnimal = new GridBagConstraints();
		gbc_textFieldAntecedentsAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAntecedentsAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAntecedentsAnimal.gridx = 1;
		gbc_textFieldAntecedentsAnimal.gridy = 6;
		AddAnimal.getContentPane().add(textFieldAntecedentsAnimal, gbc_textFieldAntecedentsAnimal);
		
		JLabel lblErreur = new JLabel("erreur");
		GridBagConstraints gbc_lblErreur = new GridBagConstraints();
		gbc_lblErreur.insets = new Insets(0, 0, 0, 5);
		gbc_lblErreur.gridx = 1;
		gbc_lblErreur.gridy = 7;
		AddAnimal.getContentPane().add(lblErreur, gbc_lblErreur);

		
//-----------------------------------------------------------------------------------------------		
//		GridBagLayout gbl_PopupDeleteAnimal = new GridBagLayout();
//		GridBagConstraints gbc_btnPopupCancelDelete = new GridBagConstraints();
//		gbl_PopupDeleteAnimal.columnWidths = new int[] { 44, 201, 39, 0 };
//		gbl_PopupDeleteAnimal.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
//		gbl_PopupDeleteAnimal.columnWeights = new double[] { 0.0, 1.0, 0.0,
//				Double.MIN_VALUE };
//		gbl_PopupDeleteAnimal.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
//		PopupDeleteAnimal.getContentPane().setLayout(gbl_PopupDeleteAnimal);
//		gbc_btnPopupCancelDelete.insets = new Insets(0, 0, 0, 5);
//		gbc_btnPopupCancelDelete.gridx = 5;
//		gbc_btnPopupCancelDelete.gridy = 6;
//				
//						JLabel lblSupprAnimal = new JLabel("Etes-vous sur de vouloir supprimer cette animal ?");
//						lblSupprAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
//						GridBagConstraints gbc_lblSupprAnimal = new GridBagConstraints();
//						gbc_lblSupprAnimal.insets = new Insets(0, 0, 5, 5);
//						gbc_lblSupprAnimal.gridx = 1;
//						gbc_lblSupprAnimal.gridy = 1;
//						PopupDeleteAnimal.getContentPane().add(lblSupprAnimal, gbc_lblSupprAnimal);
//				
//				JDesktopPane desktopPane = new JDesktopPane();
//				desktopPane.setBackground(SystemColor.control);
//				GridBagConstraints gbc_desktopPane = new GridBagConstraints();
//				gbc_desktopPane.gridheight = 3;
//				gbc_desktopPane.insets = new Insets(0, 0, 0, 5);
//				gbc_desktopPane.fill = GridBagConstraints.BOTH;
//				gbc_desktopPane.gridx = 1;
//				gbc_desktopPane.gridy = 2;
//				PopupDeleteAnimal.getContentPane().add(desktopPane, gbc_desktopPane);
//				
//						JButton btnPopupDeleteAnimal = new JButton("Oui");
//						btnPopupDeleteAnimal.setBounds(88, 28, 49, 22);
//						desktopPane.add(btnPopupDeleteAnimal);
//				
//				JButton btnPopupCancelDeleteAnimal = new JButton("Non");
//				btnPopupCancelDeleteAnimal.setBounds(147, 28, 51, 22);
//				desktopPane.add(btnPopupCancelDeleteAnimal);
		
//		------------------------------------------------------------------------------Gestion du personnel
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
//		frame.getContentPane().setLayout(gridBagLayout);
//		
//		JDesktopPane desktopPane = new JDesktopPane();
//		desktopPane.setBackground(Color.WHITE);
//		GridBagConstraints gbc_desktopPane = new GridBagConstraints();
//		gbc_desktopPane.fill = GridBagConstraints.BOTH;
//		gbc_desktopPane.gridx = 0;
//		gbc_desktopPane.gridy = 0;
//		frame.getContentPane().add(desktopPane, gbc_desktopPane);
//		
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon("Y:\\RL_AG_LV\\logo.jpg"));
//		lblNewLabel.setBounds(117, 11, 90, 96);
//		desktopPane.add(lblNewLabel);
//		
//		JPanel panel = new JPanel();
//		panel.setBackground(new Color(94, 141, 229));
//		panel.setBounds(0, 122, 332, 39);
//		desktopPane.add(panel);
//		
//		JLabel lblGestionRendezvous = new JLabel("Gestion du Personnel");
//		panel.add(lblGestionRendezvous);
//		lblGestionRendezvous.setBackground(Color.CYAN);
//		lblGestionRendezvous.setForeground(Color.WHITE);
//		lblGestionRendezvous.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(new Color(109, 159, 254));
//		panel_1.setBounds(0, 0, 332, 123);
//		desktopPane.add(panel_1);
//		
//		JPanel panel_2 = new JPanel();
//		panel_2.setBackground(new Color(94, 141, 229));
//		panel_2.setBounds(0, 400, 332, 63);
//		desktopPane.add(panel_2);
//		
//		JButton btnNewButton_2 = new JButton("");
//		panel_2.add(btnNewButton_2);
//		btnNewButton_2.setMaximumSize(new Dimension(30, 30));
//		btnNewButton_2.setBackground(new Color(240, 240, 240));
//		btnNewButton_2.setIcon(new ImageIcon("Y:\\RL_AG_LV\\cancel.png"));
//		
//		JButton btnNewButton = new JButton("");
//		btnNewButton.setIcon(new ImageIcon("Y:\\RL_AG_LV\\ico_gp.jpg"));
//		btnNewButton.setBounds(92, 193, 140, 139);
//		desktopPane.add(btnNewButton);
//		
//		JLabel lblPriseDeRendezvous = new JLabel("Geston du Personnel");
//		lblPriseDeRendezvous.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
//		lblPriseDeRendezvous.setBounds(92, 342, 150, 20);
//		desktopPane.add(lblPriseDeRendezvous);
//		
//		Accueil Agenda------------------------------------------------------------------------
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
//		frame.getContentPane().setLayout(gridBagLayout);
//		
//		JDesktopPane desktopPane = new JDesktopPane();
//		desktopPane.setBackground(new Color(245,244,239));
//		GridBagConstraints gbc_desktopPane = new GridBagConstraints();
//		gbc_desktopPane.fill = GridBagConstraints.BOTH;
//		gbc_desktopPane.gridx = 0;
//		gbc_desktopPane.gridy = 0;
//		frame.getContentPane().add(desktopPane, gbc_desktopPane);
//		
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon("Y:\\RL_AG_LV\\logo.jpg"));
//		lblNewLabel.setBounds(117, 11, 90, 96);
//		desktopPane.add(lblNewLabel);
//		
//		JPanel panel = new JPanel();
//		panel.setBackground(new Color(94, 141, 229));
//		panel.setBounds(0, 122, 332, 39);
//		desktopPane.add(panel);
//		
//		JLabel lblGestionRendezvous = new JLabel("AGENDA");
//		panel.add(lblGestionRendezvous);
//		lblGestionRendezvous.setBackground(Color.CYAN);
//		lblGestionRendezvous.setForeground(Color.WHITE);
//		lblGestionRendezvous.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(new Color(109, 159, 254));
//		panel_1.setBounds(0, 0, 332, 123);
//		desktopPane.add(panel_1);
//		
//		JPanel panel_2 = new JPanel();
//		panel_2.setBackground(new Color(94, 141, 229));
//		panel_2.setBounds(0, 400, 332, 63);
//		desktopPane.add(panel_2);
//		
//		JButton btnNewButton_2 = new JButton("");
//		panel_2.add(btnNewButton_2);
//		btnNewButton_2.setMaximumSize(new Dimension(30, 30));
//		btnNewButton_2.setBackground(new Color(240, 240, 240));
//		btnNewButton_2.setIcon(new ImageIcon("Y:\\RL_AG_LV\\cancel.png"));
//		
//		JButton btnNewButton = new JButton("");
//		btnNewButton.setIcon(new ImageIcon("Y:\\RL_AG_LV\\Icons-agenda.jpg"));
//		btnNewButton.setBounds(92, 193, 140, 139);
//		desktopPane.add(btnNewButton);
//		
//		JLabel lblPriseDeRendezvous = new JLabel("Planning");
//		lblPriseDeRendezvous.setFont(new Font("Malgun Gothic", Font.BOLD, 14));
//		lblPriseDeRendezvous.setBounds(134, 342, 73, 20);
//		desktopPane.add(lblPriseDeRendezvous);
		
//		accueil gestion client---------------------------------------------------------------------------
//		frame = new JFrame();
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
//		frame.getContentPane().setLayout(gridBagLayout);
//		
//		JDesktopPane desktopPane = new JDesktopPane();
//		desktopPane.setBackground(Color.LIGHT_GRAY);
//		GridBagConstraints gbc_desktopPane = new GridBagConstraints();
//		gbc_desktopPane.fill = GridBagConstraints.BOTH;
//		gbc_desktopPane.gridx = 0;
//		gbc_desktopPane.gridy = 0;
//		frame.getContentPane().add(desktopPane, gbc_desktopPane);
//		
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setIcon(new ImageIcon("Y:\\RL_AG_LV\\logo.jpg"));
//		lblNewLabel.setBounds(117, 11, 90, 96);
//		desktopPane.add(lblNewLabel);
//		
//		JPanel panel = new JPanel();
//		panel.setBackground(new Color(65, 105, 225));
//		panel.setBounds(0, 122, 332, 39);
//		desktopPane.add(panel);
//		
//		JLabel lblGestionRendezvous = new JLabel("GESTION RENDEZ-VOUS");
//		panel.add(lblGestionRendezvous);
//		lblGestionRendezvous.setBackground(Color.CYAN);
//		lblGestionRendezvous.setForeground(Color.WHITE);
//		lblGestionRendezvous.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBackground(SystemColor.textHighlight);
//		panel_1.setBounds(0, 0, 332, 123);
//		desktopPane.add(panel_1);
//		
//		JPanel panel_2 = new JPanel();
//		panel_2.setBackground(SystemColor.textHighlight);
//		panel_2.setBounds(0, 400, 332, 63);
//		desktopPane.add(panel_2);
//		
//		JButton btnNewButton_2 = new JButton("");
//		panel_2.add(btnNewButton_2);
//		btnNewButton_2.setMaximumSize(new Dimension(30, 30));
//		btnNewButton_2.setBackground(new Color(240, 240, 240));
//		btnNewButton_2.setIcon(new ImageIcon("Y:\\RL_AG_LV\\cancel.png"));
//		
//		JButton btnNewButton = new JButton("");
//		btnNewButton.setIcon(new ImageIcon("Y:\\RL_AG_LV\\flat-calendar-redi.jpg"));
//		btnNewButton.setBounds(31, 202, 117, 123);
//		desktopPane.add(btnNewButton);
//		
//		JButton btnNewButton_1 = new JButton("");
//		btnNewButton_1.setIcon(new ImageIcon("Y:\\RL_AG_LV\\Client.jpg"));
//		btnNewButton_1.setBounds(185, 202, 117, 123);
//		desktopPane.add(btnNewButton_1);
//		
//		JLabel lblPriseDeRendezvous = new JLabel("Prise Rendez-vous");
//		lblPriseDeRendezvous.setFont(new Font("Malgun Gothic", Font.BOLD, 13));
//		lblPriseDeRendezvous.setBounds(31, 336, 127, 20);
//		desktopPane.add(lblPriseDeRendezvous);
//		
//		JLabel lblNewLabel_1 = new JLabel("Gestion Clients");
//		lblNewLabel_1.setFont(new Font("Malgun Gothic", Font.BOLD, 13));
//		lblNewLabel_1.setBounds(195, 339, 117, 14);
//		desktopPane.add(lblNewLabel_1);
		
		
		
//      Window Login------------------------------------------------------------------------------------
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
//		frame.getContentPane().setLayout(gridBagLayout);
//		
//		JDesktopPane desktopPane = new JDesktopPane();
//		desktopPane.setBackground(Color.WHITE);
//		GridBagConstraints gbc_desktopPane = new GridBagConstraints();
//		gbc_desktopPane.gridheight = 2;
//		gbc_desktopPane.fill = GridBagConstraints.BOTH;
//		gbc_desktopPane.gridx = 0;
//		gbc_desktopPane.gridy = 0;
//		frame.getContentPane().add(desktopPane, gbc_desktopPane);
//		
//		JLabel lblNewLabel = new JLabel("");
//		lblNewLabel.setBackground(new Color(240, 240, 240));
//		lblNewLabel.setIcon(new ImageIcon("Y:\\RL_AG_LV\\logo-redi-login.png"));
//		lblNewLabel.setBounds(84, 23, 141, 142);
//		desktopPane.add(lblNewLabel);
//		
//		JLabel lblTre = new JLabel("");
//		lblTre.setIcon(new ImageIcon("Y:\\RL_AG_LV\\verrou.png"));
//		lblTre.setBounds(77, 263, 24, 33);
//		desktopPane.add(lblTre);
//		
//		JLabel lblNewLabel_1 = new JLabel("");
//		lblNewLabel_1.setIcon(new ImageIcon("Y:\\RL_AG_LV\\human-login.png"));
//		lblNewLabel_1.setBounds(77, 214, 24, 33);
//		desktopPane.add(lblNewLabel_1);
//		
//		textField_13 = new JTextField();
//		textField_13.setToolTipText("");
//		textField_13.setForeground(Color.DARK_GRAY);
//		textField_13.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
//		textField_13.setBounds(67, 203, 171, 49);
//		desktopPane.add(textField_13);
//		textField_13.setColumns(10);
//		
//		textField_14 = new JTextField();
//		textField_14.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
//		textField_14.setBounds(67, 252, 171, 49);
//		desktopPane.add(textField_14);
//		textField_14.setColumns(10);
//		
//		JButton btnNewButton = new JButton("Connexion");
//		btnNewButton.setIcon(new ImageIcon("Y:\\RL_AG_LV\\fond-bouton-connexion.jpg"));
//		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
//		btnNewButton.setForeground(new Color(255, 0, 255));
//		btnNewButton.setBackground(new Color(0, 204, 204));
//		btnNewButton.setBounds(90, 344, 100, 23);
//		desktopPane.add(btnNewButton);
//		
//		JLabel lblNewLabel_2 = new JLabel("");
//		lblNewLabel_2.setBounds(129, 398, 46, 14);
//		desktopPane.add(lblNewLabel_2);
		
//		--------------------------------------------------------------------------------------------
		
//		frmGestionAnimal = new JFrame();
//		frmGestionAnimal.setForeground(new Color(240, 255, 255));
//		frmGestionAnimal.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
//		frmGestionAnimal.setTitle("                    Gestion Animal");
//		frmGestionAnimal.getContentPane().setBackground(new Color(255, 255, 255));
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0, 84, 67, 0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{10, 0, 0, 35, 35, 35, 0, 50, 0};
//		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
//		frmGestionAnimal.getContentPane().setLayout(gridBagLayout);
//		frmGestionAnimal.setVisible(true);
//		
//		JDesktopPane desktopPane = new JDesktopPane();
//		desktopPane.setBorder(null);
//		desktopPane.setBackground(new Color(255, 255, 255));
//		GridBagConstraints gbc_desktopPane = new GridBagConstraints();
//		gbc_desktopPane.gridwidth = 5;
//		gbc_desktopPane.insets = new Insets(0, 0, 5, 0);
//		gbc_desktopPane.fill = GridBagConstraints.BOTH;
//		gbc_desktopPane.gridx = 0;
//		gbc_desktopPane.gridy = 0;
//		frmGestionAnimal.getContentPane().add(desktopPane, gbc_desktopPane);
//		
//		JButton btnAnnuler = new JButton("");
//		btnAnnuler.setForeground(new Color(255, 255, 255));
//		btnAnnuler.setBackground(new Color(255, 255, 255));
//		btnAnnuler.setIcon(new ImageIcon("Y:\\RL_AG_LV\\checked32.png"));
//		btnAnnuler.setBounds(329, 11, 58, 44);
//		desktopPane.add(btnAnnuler);
//		
//		JButton btnValider_1 = new JButton("");
//		btnValider_1.setIcon(new ImageIcon("Y:\\RL_AG_LV\\cancel.png"));
//		btnValider_1.setBounds(423, 11, 58, 44);
//		desktopPane.add(btnValider_1);
//		
//		JDesktopPane desktopPane_1 = new JDesktopPane();
//		desktopPane_1.setBackground(UIManager.getColor("Button.background"));
//		desktopPane_1.setBorder(null);
//		GridBagConstraints gbc_desktopPane_1 = new GridBagConstraints();
//		gbc_desktopPane_1.gridheight = 2;
//		gbc_desktopPane_1.gridwidth = 5;
//		gbc_desktopPane_1.insets = new Insets(0, 0, 5, 0);
//		gbc_desktopPane_1.fill = GridBagConstraints.BOTH;
//		gbc_desktopPane_1.gridx = 0;
//		gbc_desktopPane_1.gridy = 1;
//		frmGestionAnimal.getContentPane().add(desktopPane_1, gbc_desktopPane_1);
//		
//		JLabel lblClient = new JLabel("Client :");
//		lblClient.setFont(new Font("Malgun Gothic", Font.BOLD, 12));
//		lblClient.setBounds(22, 11, 46, 14);
//		desktopPane_1.add(lblClient);
//		
//		JLabel lblNewLabel_3 = new JLabel("Albert Kader");
//		lblNewLabel_3.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
//		lblNewLabel_3.setBounds(43, 32, 265, 14);
//		desktopPane_1.add(lblNewLabel_3);
//		
//		JLabel lblNewLabel = new JLabel("Code");
//		lblNewLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
//		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
//		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
//		gbc_lblNewLabel.gridx = 0;
//		gbc_lblNewLabel.gridy = 3;
//		frmGestionAnimal.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
//		
//		textField_9 = new JTextField();
//		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
//		gbc_textField_9.gridwidth = 2;
//		gbc_textField_9.insets = new Insets(0, 0, 5, 5);
//		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField_9.gridx = 1;
//		gbc_textField_9.gridy = 3;
//		frmGestionAnimal.getContentPane().add(textField_9, gbc_textField_9);
//		textField_9.setColumns(10);
//		
//		JLabel lblNom = new JLabel("Nom");
//		lblNom.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
//		GridBagConstraints gbc_lblNom = new GridBagConstraints();
//		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
//		gbc_lblNom.gridx = 0;
//		gbc_lblNom.gridy = 4;
//		frmGestionAnimal.getContentPane().add(lblNom, gbc_lblNom);
//		
//		textField_10 = new JTextField();
//		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
//		gbc_textField_10.gridwidth = 2;
//		gbc_textField_10.insets = new Insets(0, 0, 5, 5);
//		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField_10.gridx = 1;
//		gbc_textField_10.gridy = 4;
//		frmGestionAnimal.getContentPane().add(textField_10, gbc_textField_10);
//		textField_10.setColumns(10);
//		
//		JComboBox comboBox_2 = new JComboBox();
//		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
//		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
//		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
//		gbc_comboBox_2.gridx = 3;
//		gbc_comboBox_2.gridy = 4;
//		frmGestionAnimal.getContentPane().add(comboBox_2, gbc_comboBox_2);
//		
//		JLabel lblCouleur = new JLabel("Couleur");
//		lblCouleur.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
//		GridBagConstraints gbc_lblCouleur = new GridBagConstraints();
//		gbc_lblCouleur.insets = new Insets(0, 0, 5, 5);
//		gbc_lblCouleur.gridx = 0;
//		gbc_lblCouleur.gridy = 5;
//		frmGestionAnimal.getContentPane().add(lblCouleur, gbc_lblCouleur);
//		
//		textField_11 = new JTextField();
//		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
//		gbc_textField_11.gridwidth = 2;
//		gbc_textField_11.insets = new Insets(0, 0, 5, 5);
//		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField_11.gridx = 1;
//		gbc_textField_11.gridy = 5;
//		frmGestionAnimal.getContentPane().add(textField_11, gbc_textField_11);
//		textField_11.setColumns(10);
//		
//		JLabel lblNewLabel_1 = new JLabel("Esp\u00E8ce");
//		lblNewLabel_1.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
//		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
//		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
//		gbc_lblNewLabel_1.gridx = 0;
//		gbc_lblNewLabel_1.gridy = 6;
//		frmGestionAnimal.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
//		
//		JComboBox comboBox = new JComboBox();
//		GridBagConstraints gbc_comboBox = new GridBagConstraints();
//		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
//		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
//		gbc_comboBox.gridx = 1;
//		gbc_comboBox.gridy = 6;
//		
//		frmGestionAnimal.getContentPane().add(comboBox, gbc_comboBox);
//		
//		JLabel lblNewLabel_2 = new JLabel("Race");
//		lblNewLabel_2.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
//		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
//		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
//		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
//		gbc_lblNewLabel_2.gridx = 2;
//		gbc_lblNewLabel_2.gridy = 6;
//		frmGestionAnimal.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
//		
//		JComboBox comboBox_1 = new JComboBox();
//		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
//		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
//		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
//		gbc_comboBox_1.gridx = 3;
//		gbc_comboBox_1.gridy = 6;
//		frmGestionAnimal.getContentPane().add(comboBox_1, gbc_comboBox_1);
//		
//		JLabel lblTatouage = new JLabel("Tatouage");
//		lblTatouage.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
//		GridBagConstraints gbc_lblTatouage = new GridBagConstraints();
//		gbc_lblTatouage.insets = new Insets(0, 0, 0, 5);
//		gbc_lblTatouage.gridx = 0;
//		gbc_lblTatouage.gridy = 7;
//		frmGestionAnimal.getContentPane().add(lblTatouage, gbc_lblTatouage);
//		
//		textField_12 = new JTextField();
//		GridBagConstraints gbc_textField_12 = new GridBagConstraints();
//		gbc_textField_12.gridwidth = 2;
//		gbc_textField_12.insets = new Insets(0, 0, 0, 5);
//		gbc_textField_12.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField_12.gridx = 1;
//		gbc_textField_12.gridy = 7;
//		frmGestionAnimal.getContentPane().add(textField_12, gbc_textField_12);
//		textField_12.setColumns(10);
		
		
		
		
//panneau client -----------------------------------------------------------------------------------------------		
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0, 0, 146, 0, 0, 0, 0, 0, 0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0, 50, 38, 38, 38, 38, 38, 38, 38, 0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
//		JButton btnNewButton = new JButton("Rechercher");
//		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
//		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
//		gbc_btnNewButton.gridx = 1;
//		gbc_btnNewButton.gridy = 1;
//		frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
//		
//		JButton btnNewButton_4 = new JButton("Annuler");
//		btnNewButton_4.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		
//		JButton btnNewButton_1 = new JButton("Ajouter");
//		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
//		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
//		gbc_btnNewButton_1.gridx = 3;
//		gbc_btnNewButton_1.gridy = 1;
//		frame.getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
//		
//		JButton btnNewButton_2 = new JButton("Supprimer");
//		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
//		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
//		gbc_btnNewButton_2.gridx = 4;
//		gbc_btnNewButton_2.gridy = 1;
//		frame.getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);
//		
//		JButton btnNewButton_3 = new JButton("Valider");
//		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
//		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
//		gbc_btnNewButton_3.gridx = 6;
//		gbc_btnNewButton_3.gridy = 1;
//		frame.getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);
//		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
//		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
//		gbc_btnNewButton_4.gridx = 7;
//		gbc_btnNewButton_4.gridy = 1;
//		frame.getContentPane().add(btnNewButton_4, gbc_btnNewButton_4);
//		
//		table_2 = new JTable();
//		GridBagConstraints gbc_table_2 = new GridBagConstraints();
//		gbc_table_2.gridwidth = 2;
//		gbc_table_2.gridheight = 6;
//		gbc_table_2.insets = new Insets(0, 0, 5, 5);
//		gbc_table_2.fill = GridBagConstraints.BOTH;
//		gbc_table_2.gridx = 1;
//		gbc_table_2.gridy = 3;
//		frame.getContentPane().add(table_2, gbc_table_2);
//		
//		table_1 = new JTable();
//		GridBagConstraints gbc_table_1 = new GridBagConstraints();
//		gbc_table_1.gridwidth = 4;
//		gbc_table_1.gridheight = 6;
//		gbc_table_1.insets = new Insets(0, 0, 5, 5);
//		gbc_table_1.fill = GridBagConstraints.BOTH;
//		gbc_table_1.gridx = 4;
//		gbc_table_1.gridy = 3;
//		frame.getContentPane().add(table_1, gbc_table_1);
//		
//		JPanel panel_1 = new JPanel();
//		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
//		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
//		gbc_panel_1.fill = GridBagConstraints.BOTH;
//		gbc_panel_1.gridx = 0;
//		gbc_panel_1.gridy = 4;
//		frame.getContentPane().add(panel_1, gbc_panel_1);
//		
//		JPanel panel_2 = new JPanel();
//		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
//		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
//		gbc_panel_2.fill = GridBagConstraints.BOTH;
//		gbc_panel_2.gridx = 8;
//		gbc_panel_2.gridy = 5;
//		frame.getContentPane().add(panel_2, gbc_panel_2);
//		
//		JButton btnAjouter = new JButton("Ajouter");
//		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
//		gbc_btnAjouter.insets = new Insets(0, 0, 5, 5);
//		gbc_btnAjouter.gridx = 5;
//		gbc_btnAjouter.gridy = 9;
//		frame.getContentPane().add(btnAjouter, gbc_btnAjouter);
//		
//		JButton btnNewButton_5 = new JButton("Supprimer");
//		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
//		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
//		gbc_btnNewButton_5.gridx = 6;
//		gbc_btnNewButton_5.gridy = 9;
//		frame.getContentPane().add(btnNewButton_5, gbc_btnNewButton_5);
//		
//		JButton btnNewButton_6 = new JButton("Editer");
//		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
//		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
//		gbc_btnNewButton_6.gridx = 7;
//		gbc_btnNewButton_6.gridy = 9;
//		frame.getContentPane().add(btnNewButton_6, gbc_btnNewButton_6);
		
//		----------------------------------------------------------------------------------------------------------
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{50, 0, 0, 140, 100, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
//		frame.getContentPane().setLayout(gridBagLayout);
//		
//		JLabel lblAjouterUnePersonne = new JLabel("AJOUTER UNE PERSONNE");
//		GridBagConstraints gbc_lblAjouterUnePersonne = new GridBagConstraints();
//		gbc_lblAjouterUnePersonne.insets = new Insets(0, 0, 5, 5);
//		gbc_lblAjouterUnePersonne.gridx = 3;
//		gbc_lblAjouterUnePersonne.gridy = 1;
//		frame.getContentPane().add(lblAjouterUnePersonne, gbc_lblAjouterUnePersonne);
//		
//		JLabel lblPrenom = new JLabel("Prenom");
//		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
//		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
//		gbc_lblPrenom.gridx = 1;
//		gbc_lblPrenom.gridy = 3;
//		frame.getContentPane().add(lblPrenom, gbc_lblPrenom);
//		
//		textField_6 = new JTextField();
//		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
//		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
//		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField_6.gridx = 3;
//		gbc_textField_6.gridy = 3;
//		frame.getContentPane().add(textField_6, gbc_textField_6);
//		textField_6.setColumns(10);
//		
//		JLabel lblNom = new JLabel("Nom");
//		GridBagConstraints gbc_lblNom = new GridBagConstraints();
//		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
//		gbc_lblNom.gridx = 1;
//		gbc_lblNom.gridy = 5;
//		frame.getContentPane().add(lblNom, gbc_lblNom);
//		
//		textField_7 = new JTextField();
//		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
//		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
//		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField_7.gridx = 3;
//		gbc_textField_7.gridy = 5;
//		frame.getContentPane().add(textField_7, gbc_textField_7);
//		textField_7.setColumns(10);
//		
//		JLabel lblMotDePasse = new JLabel("Mot de passe");
//		GridBagConstraints gbc_lblMotDePasse = new GridBagConstraints();
//		gbc_lblMotDePasse.insets = new Insets(0, 0, 5, 5);
//		gbc_lblMotDePasse.gridx = 1;
//		gbc_lblMotDePasse.gridy = 7;
//		frame.getContentPane().add(lblMotDePasse, gbc_lblMotDePasse);
//		
//		textField_8 = new JTextField();
//		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
//		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
//		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField_8.gridx = 3;
//		gbc_textField_8.gridy = 7;
//		frame.getContentPane().add(textField_8, gbc_textField_8);
//		textField_8.setColumns(10);
//		
//		JButton btnValider_1 = new JButton("VALIDER");
//		GridBagConstraints gbc_btnValider_1 = new GridBagConstraints();
//		gbc_btnValider_1.gridx = 4;
//		gbc_btnValider_1.gridy = 8;
//		frame.getContentPane().add(btnValider_1, gbc_btnValider_1);
//		frame.setBounds(100, 100, 450, 407);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.columnWidths = new int[]{0, 126, 126, 126, 0, 0};
//		gridBagLayout.rowHeights = new int[]{1, 20, 25, 0, 52, 0, 25, 0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
//		frame.getContentPane().setLayout(gridBagLayout);
		
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
//		JPanel panel_5 = new JPanel();
//		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
//		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
//		gbc_panel_5.fill = GridBagConstraints.BOTH;
//		gbc_panel_5.gridx = 0;
//		gbc_panel_5.gridy = 1;
//		frame.getContentPane().add(panel_5, gbc_panel_5);
//		
//		JPanel panel = new JPanel();
//		GridBagConstraints gbc_panel = new GridBagConstraints();
//		gbc_panel.insets = new Insets(0, 0, 5, 5);
//		gbc_panel.fill = GridBagConstraints.BOTH;
//		gbc_panel.gridx = 1;
//		gbc_panel.gridy = 1;
//		frame.getContentPane().add(panel, gbc_panel);
//		
//		JButton btnNewButton = new JButton("AJOUTER");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		panel.add(btnNewButton);
//		
//		JPanel panel_1 = new JPanel();
//		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
//		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
//		gbc_panel_1.fill = GridBagConstraints.BOTH;
//		gbc_panel_1.gridx = 2;
//		gbc_panel_1.gridy = 1;
//		frame.getContentPane().add(panel_1, gbc_panel_1);
//		
//		JButton btnNewButton_1 = new JButton("SUPPRIMER");
//		panel_1.add(btnNewButton_1);
//		
//		JPanel panel_2 = new JPanel();
//		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
//		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
//		gbc_panel_2.fill = GridBagConstraints.BOTH;
//		gbc_panel_2.gridx = 3;
//		gbc_panel_2.gridy = 1;
//		frame.getContentPane().add(panel_2, gbc_panel_2);
//		
//		JButton btnNewButton_2 = new JButton("REINITIALISER");
//		panel_2.add(btnNewButton_2);
//		
//		JPanel panel_4 = new JPanel();
//		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
//		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
//		gbc_panel_4.fill = GridBagConstraints.BOTH;
//		gbc_panel_4.gridx = 4;
//		gbc_panel_4.gridy = 1;
//		frame.getContentPane().add(panel_4, gbc_panel_4);
//		String[] entetes = {"Nom", "Role", "Mot de passe"};
//		Object[][] donnee = new ControllerPersonnels().getList();
//		
//		table = new JTable(donnee, entetes);
//		GridBagConstraints gbc_table = new GridBagConstraints();
//		gbc_table.gridwidth = 3;
//		gbc_table.gridheight = 6;
//		gbc_table.insets = new Insets(0, 0, 5, 5);
//		gbc_table.fill = GridBagConstraints.BOTH;
//		gbc_table.gridx = 1;
//		gbc_table.gridy = 2;
//		frame.getContentPane().add(table, gbc_table);
		

		

	}
}
