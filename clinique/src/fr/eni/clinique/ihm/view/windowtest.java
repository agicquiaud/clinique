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
import javax.swing.JDesktopPane;

import java.awt.Color;
import java.awt.Font;

public class windowtest {


	/**
	 * Create the application.
	 */
	public windowtest() {
		JFrame EditAnimal = new JFrame();
		
		EditAnimal.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		EditAnimal.setTitle("Gestion Animal");
		EditAnimal.setSize(620, 422);
		EditAnimal.setLocationRelativeTo(null);
		EditAnimal.setVisible(true);

		GridBagLayout gbl_EditAnimal = new GridBagLayout();
		gbl_EditAnimal.columnWidths = new int[] { 0, 84, 0, 67, 0, 0, 0 };
		gbl_EditAnimal.rowHeights = new int[] { 93, 64, 0, 35, 35, 0, 0, 0, 0, 21, 0, 0 };
		gbl_EditAnimal.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0 };
		gbl_EditAnimal.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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
		btnValiderEditAnimal.setIcon(new ImageIcon("ressource/checked32.png"));
		btnValiderEditAnimal.setBounds(320, 18, 58, 44);
		desktopPaneEditAnimal.add(btnValiderEditAnimal);

		JButton btnAnnulerEditAnimal = new JButton();
		btnAnnulerEditAnimal.setForeground(new Color(255, 255, 255));
		btnAnnulerEditAnimal.setBackground(new Color(255, 255, 255));
		btnAnnulerEditAnimal.setIcon(new ImageIcon("ressource/cancel.png"));
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

		JTextField textFieldNomAnimalEditAnimal = new JTextField();
		GridBagConstraints gbc_textFieldNomAnimalEditAnimal = new GridBagConstraints();
		gbc_textFieldNomAnimalEditAnimal.gridwidth = 3;
		gbc_textFieldNomAnimalEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNomAnimalEditAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomAnimalEditAnimal.gridx = 1;
		gbc_textFieldNomAnimalEditAnimal.gridy = 3;
		EditAnimal.getContentPane().add(textFieldNomAnimalEditAnimal, gbc_textFieldNomAnimalEditAnimal);
		textFieldNomAnimalEditAnimal.setColumns(10);

		String[] Genre = { "Masculin", "Féminin", "Hermaphrodite" };
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

		JTextField textFieldCouleurEditAnimal = new JTextField();
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

		JComboBox<String> comboBoxEspeceEditAnimal = new JComboBox<String>();
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

		JComboBox<String> comboBoxRaceEditAnimal = new JComboBox<String>();
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

		JTextField textFieldTatouageEditAnimal = new JTextField();
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

		JTextField textFieldAntecedentsEditAnimal = new JTextField();
		textFieldAntecedentsEditAnimal.setColumns(10);
		GridBagConstraints gbc_textFieldAntecedentsEditAnimal = new GridBagConstraints();
		gbc_textFieldAntecedentsEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAntecedentsEditAnimal.gridheight = 2;
		gbc_textFieldAntecedentsEditAnimal.gridwidth = 3;
		gbc_textFieldAntecedentsEditAnimal.fill = GridBagConstraints.BOTH;
		gbc_textFieldAntecedentsEditAnimal.gridx = 1;
		gbc_textFieldAntecedentsEditAnimal.gridy = 7;
		EditAnimal.getContentPane().add(textFieldAntecedentsEditAnimal, gbc_textFieldAntecedentsEditAnimal);
		
		JLabel lblErreur  = new JLabel("error");
		GridBagConstraints gbc_lblErreur= new GridBagConstraints();
		gbc_lblErreur.insets = new Insets(0, 0, 5, 5);
		gbc_lblErreur.gridx = 0;
		gbc_lblErreur.gridy = 9;
		EditAnimal.getContentPane().add(lblErreur, gbc_lblErreur);


		
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
