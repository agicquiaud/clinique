package fr.eni.clinique.ihm.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.ihm.controller.ControllerAnimaux;
import fr.eni.clinique.ihm.controller.ControllerAnimauxSingleton;
import fr.eni.clinique.ihm.controller.ControllerClients;
import fr.eni.clinique.ihm.controller.ControllerClientsSingleton;

public class WindowDossierMedicalAnimal {

	private JDialog frame = new JDialog();
	private ControllerClients controllerclient;
	private ControllerAnimaux controlleranimaux;

	public WindowDossierMedicalAnimal(String nomPrenom, Animaux animaux) {
		controlleranimaux = ControllerAnimauxSingleton.getinstance();
		controllerclient = ControllerClientsSingleton.getinstance();
		// List<String> liste = controller.getClientbyId(id);

		frame.setTitle("Dossier Medical");
		frame.setBounds(100, 100, 570, 300);
		frame.setVisible(true);

		GridBagLayout gridBagLayoutDossierAnimal = new GridBagLayout();
		gridBagLayoutDossierAnimal.columnWidths = new int[] { 0, 80, 0, 0, 75, 65, 0, 73, 33, 0 };
		gridBagLayoutDossierAnimal.rowHeights = new int[] { 0, 0, 30, 30, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayoutDossierAnimal.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayoutDossierAnimal.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayoutDossierAnimal);

		JButton btnValider = new JButton("VALIDER");
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.insets = new Insets(0, 0, 5, 5);
		gbc_btnValider.gridx = 6;
		gbc_btnValider.gridy = 1;
		frame.getContentPane().add(btnValider, gbc_btnValider);

		JButton btnAnnuler = new JButton("ANNULER");
		GridBagConstraints gbc_btnAnnuler = new GridBagConstraints();
		gbc_btnAnnuler.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnuler.gridx = 7;
		gbc_btnAnnuler.gridy = 1;
		frame.getContentPane().add(btnAnnuler, gbc_btnAnnuler);

		JLabel lblClients = new JLabel("Clients :");
		GridBagConstraints gbc_lblClients = new GridBagConstraints();
		gbc_lblClients.insets = new Insets(0, 0, 5, 5);
		gbc_lblClients.gridx = 1;
		gbc_lblClients.gridy = 2;
		frame.getContentPane().add(lblClients, gbc_lblClients);

		JLabel lblAntecedentsconsultations = new JLabel("Antécédents Consultations");
		GridBagConstraints gbc_lblAntecedentsconsultations = new GridBagConstraints();
		gbc_lblAntecedentsconsultations.gridwidth = 2;
		gbc_lblAntecedentsconsultations.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntecedentsconsultations.gridx = 4;
		gbc_lblAntecedentsconsultations.gridy = 2;
		frame.getContentPane().add(lblAntecedentsconsultations, gbc_lblAntecedentsconsultations);

		JLabel lblNomClient = new JLabel(nomPrenom);
		GridBagConstraints gbc_lblNomClient = new GridBagConstraints();
		gbc_lblNomClient.gridwidth = 2;
		gbc_lblNomClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomClient.gridx = 1;
		gbc_lblNomClient.gridy = 3;
		frame.getContentPane().add(lblNomClient, gbc_lblNomClient);

		JTextField textFieldNomClient = new JTextField(animaux.getAntecedents());
		GridBagConstraints gbc_textFieldNomClient = new GridBagConstraints();
		gbc_textFieldNomClient.gridheight = 6;
		gbc_textFieldNomClient.gridwidth = 4;
		gbc_textFieldNomClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNomClient.fill = GridBagConstraints.BOTH;
		gbc_textFieldNomClient.gridx = 4;
		gbc_textFieldNomClient.gridy = 3;
		frame.getContentPane().add(textFieldNomClient, gbc_textFieldNomClient);

		JLabel lblAnimal = new JLabel("Animal : ");
		GridBagConstraints gbc_lblAnimal = new GridBagConstraints();
		gbc_lblAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnimal.gridx = 1;
		gbc_lblAnimal.gridy = 4;
		frame.getContentPane().add(lblAnimal, gbc_lblAnimal);

		JLabel lblCodeanimal = new JLabel(animaux.getCodeAnimal().toString());
		GridBagConstraints gbc_lblCodeanimal = new GridBagConstraints();
		gbc_lblCodeanimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodeanimal.gridx = 2;
		gbc_lblCodeanimal.gridy = 4;
		frame.getContentPane().add(lblCodeanimal, gbc_lblCodeanimal);

		JLabel lblNom = new JLabel(animaux.getNom());
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 2;
		gbc_lblNom.gridy = 5;
		frame.getContentPane().add(lblNom, gbc_lblNom);

		JLabel lblRoguz = new JLabel(animaux.getCouleur());
		GridBagConstraints gbc_lblRoguz = new GridBagConstraints();
		gbc_lblRoguz.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoguz.gridx = 2;
		gbc_lblRoguz.gridy = 6;
		frame.getContentPane().add(lblRoguz, gbc_lblRoguz);

		JLabel lblGenre = new JLabel(animaux.getSexe());
		GridBagConstraints gbc_lblGenre = new GridBagConstraints();
		gbc_lblGenre.insets = new Insets(0, 0, 5, 5);
		gbc_lblGenre.gridx = 3;
		gbc_lblGenre.gridy = 6;
		frame.getContentPane().add(lblGenre, gbc_lblGenre);

		JLabel lblEspece = new JLabel(animaux.getEspece() + " " + animaux.getRace());
		GridBagConstraints gbc_lblEspece = new GridBagConstraints();
		gbc_lblEspece.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspece.gridx = 2;
		gbc_lblEspece.gridy = 7;
		frame.getContentPane().add(lblEspece, gbc_lblEspece);

		JLabel lblTatouage = new JLabel(animaux.getTatouage());
		GridBagConstraints gbc_lblTatouage = new GridBagConstraints();
		gbc_lblTatouage.insets = new Insets(0, 0, 5, 5);
		gbc_lblTatouage.gridx = 2;
		gbc_lblTatouage.gridy = 8;
		frame.getContentPane().add(lblTatouage, gbc_lblTatouage);

		// Action listener du btn Annuler de la JDialog
		btnAnnuler.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		btnValider.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String antecedent = textFieldNomClient.getText();
				controlleranimaux.updateClient(animaux.getCodeAnimal().toString(), animaux.getNom(), animaux.getSexe(), animaux.getCouleur(), animaux.getRace(), animaux.getEspece(), animaux.getCodeClient().toString(), antecedent, animaux.getTatouage());
				frame.dispose();
			}
		});
		
	}
}
