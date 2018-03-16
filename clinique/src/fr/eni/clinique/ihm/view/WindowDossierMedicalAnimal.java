package fr.eni.clinique.ihm.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.eni.clinique.ihm.controller.ControllerClients;

public class WindowDossierMedicalAnimal {

	private JDialog frame = new JDialog();
	private ControllerClients controller;
	private JTextField textFieldNomClient;

	public WindowDossierMedicalAnimal() {//String id
		controller = new ControllerClients();
//		List<String> liste = controller.getClientbyId(id);
		
		frame.setTitle("Dossier Medical");
		frame.setBounds(100, 100, 570, 300);
		frame.setVisible(true);

		GridBagLayout gridBagLayoutModalAddClient = new GridBagLayout();
		gridBagLayoutModalAddClient.columnWidths = new int[] { 0, 80, 0, 0, 75, 65, 0, 73, 33, 0 };
		gridBagLayoutModalAddClient.rowHeights = new int[] { 0, 0, 30, 30, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayoutModalAddClient.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayoutModalAddClient.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayoutModalAddClient);

		JButton btnValiderModalAddClient = new JButton("VALIDER");
		GridBagConstraints gbc_btnValiderModalAdd = new GridBagConstraints();
		gbc_btnValiderModalAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnValiderModalAdd.gridx = 6;
		gbc_btnValiderModalAdd.gridy = 1;
		frame.getContentPane().add(btnValiderModalAddClient, gbc_btnValiderModalAdd);

		JButton btnAnnulerModalCancelClient = new JButton("ANNULER");
		GridBagConstraints gbc_btnAnnulerModalCancelClient = new GridBagConstraints();
		gbc_btnAnnulerModalCancelClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnulerModalCancelClient.gridx = 7;
		gbc_btnAnnulerModalCancelClient.gridy = 1;
		frame.getContentPane().add(btnAnnulerModalCancelClient, gbc_btnAnnulerModalCancelClient);

		btnAnnulerModalCancelClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		JLabel lblClients = new JLabel("Clients :");
		GridBagConstraints gbc_lblClients = new GridBagConstraints();
		gbc_lblClients.insets = new Insets(0, 0, 5, 5);
		gbc_lblClients.gridx = 1;
		gbc_lblClients.gridy = 2;
		frame.getContentPane().add(lblClients, gbc_lblClients);

		JLabel lblAntcedentsconsultations = new JLabel("Ant\u00E9c\u00E9dents/Consultations");
		GridBagConstraints gbc_lblAntcedentsconsultations = new GridBagConstraints();
		gbc_lblAntcedentsconsultations.gridwidth = 2;
		gbc_lblAntcedentsconsultations.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntcedentsconsultations.gridx = 4;
		gbc_lblAntcedentsconsultations.gridy = 2;
		frame.getContentPane().add(lblAntcedentsconsultations, gbc_lblAntcedentsconsultations);

		JLabel lblNomClient = new JLabel("Nom Client");
		GridBagConstraints gbc_lblNomClient = new GridBagConstraints();
		gbc_lblNomClient.gridwidth = 2;
		gbc_lblNomClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomClient.gridx = 1;
		gbc_lblNomClient.gridy = 3;
		frame.getContentPane().add(lblNomClient, gbc_lblNomClient);

		textFieldNomClient = new JTextField();
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

		JLabel lblCodeanimal = new JLabel("codeanimal");
		GridBagConstraints gbc_lblCodeanimal = new GridBagConstraints();
		gbc_lblCodeanimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodeanimal.gridx = 2;
		gbc_lblCodeanimal.gridy = 4;
		frame.getContentPane().add(lblCodeanimal, gbc_lblCodeanimal);

		JLabel lblNom = new JLabel("Nom");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 2;
		gbc_lblNom.gridy = 5;
		frame.getContentPane().add(lblNom, gbc_lblNom);

		JLabel lblRoguz = new JLabel("Rouge");
		GridBagConstraints gbc_lblRoguz = new GridBagConstraints();
		gbc_lblRoguz.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoguz.gridx = 2;
		gbc_lblRoguz.gridy = 6;
		frame.getContentPane().add(lblRoguz, gbc_lblRoguz);
		
				JLabel lblGenre = new JLabel("Genre");
				GridBagConstraints gbc_lblGenre = new GridBagConstraints();
				gbc_lblGenre.insets = new Insets(0, 0, 5, 5);
				gbc_lblGenre.gridx = 3;
				gbc_lblGenre.gridy = 6;
				frame.getContentPane().add(lblGenre, gbc_lblGenre);

		JLabel lblEspece = new JLabel("Espece + race");
		GridBagConstraints gbc_lblEspece = new GridBagConstraints();
		gbc_lblEspece.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspece.gridx = 2;
		gbc_lblEspece.gridy = 7;
		frame.getContentPane().add(lblEspece, gbc_lblEspece);

		JLabel lblTatouage = new JLabel("tatouage");
		GridBagConstraints gbc_lblTatouage = new GridBagConstraints();
		gbc_lblTatouage.insets = new Insets(0, 0, 5, 5);
		gbc_lblTatouage.gridx = 2;
		gbc_lblTatouage.gridy = 8;
		frame.getContentPane().add(lblTatouage, gbc_lblTatouage);
	}

}
