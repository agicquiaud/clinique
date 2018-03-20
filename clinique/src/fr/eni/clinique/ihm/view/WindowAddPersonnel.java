package fr.eni.clinique.ihm.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.eni.clinique.bo.User;
import fr.eni.clinique.ihm.controller.ControllerPersonnels;
import fr.eni.clinique.ihm.controller.ControllerPersonnelsSingleton;

public class WindowAddPersonnel {

	private JDialog AjoutPersonnel = new JDialog();
	private ControllerPersonnels controllerPersonnels;

	public WindowAddPersonnel() {
		controllerPersonnels = ControllerPersonnelsSingleton.getinstance();
		AjoutPersonnel.setTitle("Ajout d'un personnel");
		AjoutPersonnel.setSize(460, 280);
		AjoutPersonnel.setLocationRelativeTo(null);
		AjoutPersonnel.setVisible(true);

		GridBagLayout gridBagLayoutModalAdd = new GridBagLayout();
		gridBagLayoutModalAdd.columnWidths = new int[] { 60, 0, 0, 109, 51, 69, 0 };
		gridBagLayoutModalAdd.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayoutModalAdd.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayoutModalAdd.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		AjoutPersonnel.getContentPane().setLayout(gridBagLayoutModalAdd);

		JLabel lblPrenom = new JLabel("Nom");
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenom.gridx = 1;
		gbc_lblPrenom.gridy = 0;
		AjoutPersonnel.getContentPane().add(lblPrenom, gbc_lblPrenom);

		JTextField textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.gridwidth = 2;
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 3;
		gbc_textField_6.gridy = 0;
		AjoutPersonnel.getContentPane().add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);

		JLabel lblMotDePasse = new JLabel("Mot de passe");
		GridBagConstraints gbc_lblMotDePasse = new GridBagConstraints();
		gbc_lblMotDePasse.insets = new Insets(0, 0, 5, 5);
		gbc_lblMotDePasse.gridx = 1;
		gbc_lblMotDePasse.gridy = 2;
		AjoutPersonnel.getContentPane().add(lblMotDePasse, gbc_lblMotDePasse);

		JTextField textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.gridwidth = 2;
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 3;
		gbc_textField_7.gridy = 2;
		AjoutPersonnel.getContentPane().add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);

		JLabel lblNom = new JLabel("Type");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 1;
		gbc_lblNom.gridy = 4;
		AjoutPersonnel.getContentPane().add(lblNom, gbc_lblNom);

		String[] role = { "adm", "vet", "sec" };
		JComboBox<String> comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 4;
		AjoutPersonnel.getContentPane().add(comboBox, gbc_comboBox);

		JButton btnValiderModalAjout = new JButton("VALIDER");
		GridBagConstraints gbc_btnValider_1 = new GridBagConstraints();
		gbc_btnValider_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnValider_1.gridx = 4;
		gbc_btnValider_1.gridy = 6;
		AjoutPersonnel.getContentPane().add(btnValiderModalAjout, gbc_btnValider_1);

		JButton btnAnnuler = new JButton("ANNULER");
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.gridx = 5;
		gbc_btnAnnuler.gridy = 6;
		AjoutPersonnel.getContentPane().add(btnAnnuler, gbc_btnAnnuler);

		btnValiderModalAjout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controllerPersonnels.addPersonnel(new User(textField_6.getText(), textField_7.getText(),
						(String) comboBox.getSelectedItem(), false));
				AjoutPersonnel.dispose();
			}
		});
	}
	
}
