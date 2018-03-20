package fr.eni.clinique.ihm.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import fr.eni.clinique.ihm.controller.ControllerAnimaux;
import fr.eni.clinique.ihm.controller.ControllerAnimauxImpl;
import fr.eni.clinique.ihm.controller.ControllerAnimauxSingleton;

public class WindowAddRace {

	private JDialog AddRace = new JDialog();
	private ControllerAnimaux controlleranimal;
	private JTextField textFieldRace;
	private JTextField textFieldEspece;

	public WindowAddRace() {
		controlleranimal = ControllerAnimauxSingleton.getinstance();
		AddRace.setTitle("Ajouter une race");
		AddRace.setSize(500, 260);
		AddRace.setLocationRelativeTo(null);
		AddRace.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		AddRace.setVisible(true);

		GridBagLayout gbl_AddRace = new GridBagLayout();
		gbl_AddRace.columnWidths = new int[] { 40, 60, 144, 25, 0, 146, 31 };
		gbl_AddRace.rowHeights = new int[] { 60, 40, 35, 30, 0, 0, 0 };
		gbl_AddRace.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_AddRace.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		AddRace.getContentPane().setLayout(gbl_AddRace);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(null);
		desktopPane.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_desktopPane = new GridBagConstraints();
		gbc_desktopPane.gridwidth = 7;
		gbc_desktopPane.insets = new Insets(0, 0, 5, 0);
		gbc_desktopPane.fill = GridBagConstraints.BOTH;
		gbc_desktopPane.gridx = 0;
		gbc_desktopPane.gridy = 0;
		AddRace.getContentPane().add(desktopPane, gbc_desktopPane);

		JButton btnConfirmAddRace = new JButton();
		btnConfirmAddRace.setForeground(new Color(255, 255, 255));
		btnConfirmAddRace.setBackground(new Color(255, 255, 255));
		btnConfirmAddRace.setIcon(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/checked32.png"));
		btnConfirmAddRace.setBounds(320, 5, 58, 44);
		desktopPane.add(btnConfirmAddRace);

		JButton btnCancelAddRace = new JButton();
		btnCancelAddRace.setForeground(new Color(255, 255, 255));
		btnCancelAddRace.setBackground(new Color(255, 255, 255));
		btnCancelAddRace.setIcon(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/cancel.png"));
		btnCancelAddRace.setBounds(390, 5, 58, 44);
		desktopPane.add(btnCancelAddRace);

		JLabel lblRaceAnimal = new JLabel("Espece :");
		lblRaceAnimal.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblRaceAnimal = new GridBagConstraints();
		gbc_lblRaceAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblRaceAnimal.gridx = 1;
		gbc_lblRaceAnimal.gridy = 2;
		AddRace.getContentPane().add(lblRaceAnimal, gbc_lblRaceAnimal);

		JComboBox<String> comboBoxEspece = new JComboBox<String>(controlleranimal.getEspece());
		GridBagConstraints gbc_comboBoxEspece = new GridBagConstraints();
		gbc_comboBoxEspece.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxEspece.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxEspece.gridx = 2;
		gbc_comboBoxEspece.gridy = 2;
		AddRace.getContentPane().add(comboBoxEspece, gbc_comboBoxEspece);

		JLabel lblEspece = new JLabel("Race :");
		lblEspece.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblEspece = new GridBagConstraints();
		gbc_lblEspece.anchor = GridBagConstraints.EAST;
		gbc_lblEspece.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspece.gridx = 4;
		gbc_lblEspece.gridy = 2;
		AddRace.getContentPane().add(lblEspece, gbc_lblEspece);

		textFieldRace = new JTextField();
		textFieldRace.setColumns(10);
		GridBagConstraints gbc_textFieldRace = new GridBagConstraints();
		gbc_textFieldRace.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldRace.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRace.gridx = 5;
		gbc_textFieldRace.gridy = 2;
		AddRace.getContentPane().add(textFieldRace, gbc_textFieldRace);

		JLabel lblOu = new JLabel("Ou");
		lblOu.setFont(new Font("Malgun Gothic", Font.BOLD, 11));
		GridBagConstraints gbc_lblOu = new GridBagConstraints();
		gbc_lblOu.insets = new Insets(0, 0, 5, 5);
		gbc_lblOu.gridx = 1;
		gbc_lblOu.gridy = 3;
		AddRace.getContentPane().add(lblOu, gbc_lblOu);

		textFieldEspece = new JTextField();
		GridBagConstraints gbc_textFieldEspece = new GridBagConstraints();
		gbc_textFieldEspece.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEspece.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEspece.gridx = 2;
		gbc_textFieldEspece.gridy = 3;
		AddRace.getContentPane().add(textFieldEspece, gbc_textFieldEspece);
		textFieldEspece.setColumns(10);

		// Actions Listeners
		btnCancelAddRace.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddRace.dispose();
			}
		});

		btnConfirmAddRace.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String streturn = null;
				if(!textFieldEspece.getText().equals("")){
					streturn = textFieldEspece.getText();
				}else {
					streturn = comboBoxEspece.getSelectedItem().toString();
				}
				controlleranimal.addRace(textFieldRace.getText(), streturn);
				AddRace.dispose();
			}
		});
	}
}
