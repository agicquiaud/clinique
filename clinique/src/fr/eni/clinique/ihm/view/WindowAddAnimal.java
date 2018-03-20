package fr.eni.clinique.ihm.view;

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
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.ihm.controller.ControllerAnimaux;
import fr.eni.clinique.ihm.regex.Validator;

public class WindowAddAnimal {
	
	private JDialog AddAnimal = new JDialog();
	private ControllerAnimaux controlleranimal = new ControllerAnimaux();
	private JTextField textFieldNomAnimal;
	private JTextField textFieldCouleurAnimal;
	private JTextField textFieldTatouageAnimal;
	private JTextField textFieldAntecedentsAnimal;
	private ImageIcon icon = new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/plus.png");
	private ComboBoxModel<String> comboboxModel;

	public WindowAddAnimal(Clients client){
		
		AddAnimal.setTitle("Ajouter un animal");
		AddAnimal.setSize(620, 370);
		AddAnimal.setLocationRelativeTo(null);
		AddAnimal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		AddAnimal.setVisible(true);
		
		GridBagLayout gbl_AddAnimal = new GridBagLayout();
		gbl_AddAnimal.columnWidths = new int[] { 115, 210, 31, 38, 150, 63 };
		gbl_AddAnimal.rowHeights = new int[] { 71, 68, 35, 35, 35, 0, 0, 0 };
		gbl_AddAnimal.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_AddAnimal.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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

		JLabel lblNomPrenomClient = new JLabel(client.getNom() + " " + client.getPrenom());
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

		textFieldNomAnimal = new JTextField();
		GridBagConstraints gbc_textFieldNomAnimal = new GridBagConstraints();
		gbc_textFieldNomAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNomAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomAnimal.gridx = 1;
		gbc_textFieldNomAnimal.gridy = 2;
		AddAnimal.getContentPane().add(textFieldNomAnimal, gbc_textFieldNomAnimal);
		textFieldNomAnimal.setColumns(10);

		String[] tabGenre = {"Masculin", "Féminin", "Hermaphrodite"};
		JComboBox<String> comboBoxGenre = new JComboBox<String>(tabGenre);
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

		textFieldCouleurAnimal = new JTextField();
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
		
		JComboBox<String> espece = new JComboBox<String>(controlleranimal.getEspece());
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

		JComboBox<String> race = new JComboBox<String>(controlleranimal.getRace(espece.getSelectedItem().toString()));
		GridBagConstraints gbc_race = new GridBagConstraints();
		gbc_race.fill = GridBagConstraints.HORIZONTAL;
		race.setBackground(new Color(255, 255, 255));
		gbc_race.insets = new Insets(0, 0, 5, 5);
		gbc_race.gridx = 4;
		gbc_race.gridy = 4;
		AddAnimal.getContentPane().add(race, gbc_race);
		
		JButton buttonAddRace = new JButton(icon);
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

		textFieldTatouageAnimal = new JTextField();
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
		gbc_lblAntecedents.insets = new Insets(0, 0, 0, 5);
		gbc_lblAntecedents.gridx = 0;
		gbc_lblAntecedents.gridy = 6;
		AddAnimal.getContentPane().add(lblAntecedents, gbc_lblAntecedents);

		textFieldAntecedentsAnimal = new JTextField();
		textFieldAntecedentsAnimal.setColumns(10);
		GridBagConstraints gbc_textFieldAntecedentsAnimal = new GridBagConstraints();
		gbc_textFieldAntecedentsAnimal.insets = new Insets(0, 0, 0, 5);
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
		
		//Actions Listeners
		btnConfirmAddAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Validator validator = new Validator();
				if(!validator.patternNomPrenomAnimal(textFieldNomAnimal.getText())){
					lblErreur.setText("erreur pas de caractère spéciaux");
				} else {
					controlleranimal.addAnimal(textFieldNomAnimal.getText(), comboBoxGenre.getSelectedItem().toString()
							, textFieldCouleurAnimal.getText(), race.getSelectedItem().toString(), espece.getSelectedItem().toString()
							, client.getCodeClient().toString(), textFieldTatouageAnimal.getText(), textFieldAntecedentsAnimal.getText());
					AddAnimal.dispose();
				}
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
		
		btnCancelAddAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddAnimal.dispose();
			}
		});
		
		buttonAddRace.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WindowAddRace();
			}
		});
	}
}
