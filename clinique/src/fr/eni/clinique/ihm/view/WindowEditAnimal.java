package fr.eni.clinique.ihm.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.ihm.controller.ControllerAnimaux;
import fr.eni.clinique.ihm.controller.ControllerClients;

public class WindowEditAnimal extends WindowClients {

	private JDialog EditAnimal = new JDialog();
	private JTextField textFieldNomAnimalEditAnimal;
	private JTextField textFieldCouleurEditAnimal;
	private JTextField textFieldTatouageEditAnimal;
	private JTextField textFieldAntecedentsEditAnimal;
	private ControllerAnimaux controlleranimal;
	private ControllerClients controllerclient;
	private DefaultComboBoxModel<String> comboboxModel;
	private String[] entetes = { "CodeAnimal", "Nom", "Sexe", "Couleur", "Race", "Espece" };

	public WindowEditAnimal(Animaux animal) {
		controlleranimal = new ControllerAnimaux();
		controllerclient = new ControllerClients();
		EditAnimal.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		EditAnimal.setTitle("Gestion Animal");
		EditAnimal.setSize(500, 400);
		EditAnimal.setLocationRelativeTo(null);
		EditAnimal.setVisible(true);

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

		Clients cli = controllerclient.getClientbyId(animal.getCodeClient().toString());
		JLabel lblNomClientEditAnimal = new JLabel(cli.getNom() + " " + cli.getPrenom());
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

		JLabel lblNCodeEditAnimal = new JLabel(animal.getCodeAnimal().toString());
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

		textFieldNomAnimalEditAnimal = new JTextField(animal.getNom());
		GridBagConstraints gbc_textFieldNomAnimalEditAnimal = new GridBagConstraints();
		gbc_textFieldNomAnimalEditAnimal.gridwidth = 3;
		gbc_textFieldNomAnimalEditAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNomAnimalEditAnimal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomAnimalEditAnimal.gridx = 1;
		gbc_textFieldNomAnimalEditAnimal.gridy = 3;
		EditAnimal.getContentPane().add(textFieldNomAnimalEditAnimal, gbc_textFieldNomAnimalEditAnimal);
		textFieldNomAnimalEditAnimal.setColumns(10);

		String[] Genre = { "Male", "Femelle", "Hermaphrodite" };
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

		textFieldCouleurEditAnimal = new JTextField(animal.getCouleur());
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

		textFieldTatouageEditAnimal = new JTextField(animal.getTatouage());
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

		textFieldAntecedentsEditAnimal = new JTextField(animal.getAntecedents());
		textFieldAntecedentsEditAnimal.setColumns(10);
		GridBagConstraints gbc_textFieldAntecedentsEditAnimal = new GridBagConstraints();
		gbc_textFieldAntecedentsEditAnimal.gridheight = 2;
		gbc_textFieldAntecedentsEditAnimal.gridwidth = 3;
		gbc_textFieldAntecedentsEditAnimal.fill = GridBagConstraints.BOTH;
		gbc_textFieldAntecedentsEditAnimal.gridx = 1;
		gbc_textFieldAntecedentsEditAnimal.gridy = 7;
		EditAnimal.getContentPane().add(textFieldAntecedentsEditAnimal, gbc_textFieldAntecedentsEditAnimal);

		// Actions Listeners
		comboBoxEspeceEditAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboboxModel = new DefaultComboBoxModel<String>(
						controlleranimal.getRace(comboBoxEspeceEditAnimal.getSelectedItem().toString()));
				comboBoxRaceEditAnimal.setModel(comboboxModel);
			}
		});

		// bouton checked Edit Animal Jdialogue Edit
		btnValiderEditAnimal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controlleranimal.updateClient(animal.getCodeAnimal().toString(), textFieldNomAnimalEditAnimal.getText(),
						comboboxgenreEditAnimal.getSelectedItem().toString(), textFieldCouleurEditAnimal.getText(),
						comboBoxRaceEditAnimal.getSelectedItem().toString(),
						comboBoxEspeceEditAnimal.getSelectedItem().toString(), lblNCodeEditAnimal.getText(),
						textFieldTatouageEditAnimal.getText(), textFieldAntecedentsEditAnimal.getText());
				// setUpTableData2(
				// controlleranimal.getListByClient(table_1.getValueAt(table_1.getSelectedRow(),
				// 0).toString()),
				// entetes2);
				setUpTableAnimal(controlleranimal.getListByClient(animal.getCodeClient().toString()), entetes);
				EditAnimal.dispose();
			}
		});

		btnAnnulerEditAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditAnimal.dispose();
			}
		});
	}

}
