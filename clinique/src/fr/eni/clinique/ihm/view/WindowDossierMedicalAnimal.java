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

import fr.eni.clinique.ihm.controller.ControllerClients;

public class WindowDossierMedicalAnimal {

	private JDialog frame = new JDialog();
	private ControllerClients controller;
	private JTextField textFieldNomClient;
	private JTextField textFieldPrenomClient;
	private JTextField textFieldAdresse1Client;
	private JTextField textFieldAdresse2Client;
	private JTextField textFieldCodePostalClient;
	private JTextField textFieldVilleClient;
	private JTextField textFieldNumTelClient;
	private JTextField textFieldEmailClient;
	
	public WindowDossierMedicalAnimal() {
		controller = new ControllerClients();
		frame.setTitle("Ajouter un client");
		frame.setBounds(100, 100, 740, 300);
		frame.setVisible(true);

		GridBagLayout gridBagLayoutModalAddClient = new GridBagLayout();
		gridBagLayoutModalAddClient.columnWidths = new int[] { 0, 0, 0, 0, 140, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayoutModalAddClient.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayoutModalAddClient.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gridBagLayoutModalAddClient.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayoutModalAddClient);

		JLabel lblAddClient = new JLabel("Nouveau Client");
		GridBagConstraints gbc_lblAddClient = new GridBagConstraints();
		gbc_lblAddClient.gridwidth = 8;
		gbc_lblAddClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddClient.gridx = 2;
		gbc_lblAddClient.gridy = 2;
		frame.getContentPane().add(lblAddClient, gbc_lblAddClient);

		JLabel lblNomClient = new JLabel("Nom");
		GridBagConstraints gbc_lblNomClient = new GridBagConstraints();
		gbc_lblNomClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomClient.gridx = 2;
		gbc_lblNomClient.gridy = 3;
		frame.getContentPane().add(lblNomClient, gbc_lblNomClient);

		textFieldNomClient = new JTextField();
		GridBagConstraints gbc_textFieldNomClient = new GridBagConstraints();
		gbc_textFieldNomClient.gridwidth = 5;
		gbc_textFieldNomClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNomClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomClient.gridx = 4;
		gbc_textFieldNomClient.gridy = 3;
		frame.getContentPane().add(textFieldNomClient, gbc_textFieldNomClient);

		JLabel lblPrenomClient = new JLabel("Prenom");
		GridBagConstraints gbc_lblPrenomClient = new GridBagConstraints();
		gbc_lblPrenomClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenomClient.gridx = 2;
		gbc_lblPrenomClient.gridy = 4;
		frame.getContentPane().add(lblPrenomClient, gbc_lblPrenomClient);

		textFieldPrenomClient = new JTextField();
		GridBagConstraints gbc_textFieldPrenomClient = new GridBagConstraints();
		gbc_textFieldPrenomClient.gridwidth = 5;
		gbc_textFieldPrenomClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrenomClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrenomClient.gridx = 4;
		gbc_textFieldPrenomClient.gridy = 4;
		frame.getContentPane().add(textFieldPrenomClient, gbc_textFieldPrenomClient);

		JLabel lblAdresseClient = new JLabel("Adresse");
		GridBagConstraints gbc_lblAdresseClient = new GridBagConstraints();
		gbc_lblAdresseClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresseClient.gridx = 2;
		gbc_lblAdresseClient.gridy = 5;
		frame.getContentPane().add(lblAdresseClient, gbc_lblAdresseClient);

		textFieldAdresse1Client = new JTextField();
		GridBagConstraints gbc_textFieldAdresse1Client = new GridBagConstraints();
		gbc_textFieldAdresse1Client.gridwidth = 5;
		gbc_textFieldAdresse1Client.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse1Client.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse1Client.gridx = 4;
		gbc_textFieldAdresse1Client.gridy = 5;
		frame.getContentPane().add(textFieldAdresse1Client, gbc_textFieldAdresse1Client);

		textFieldAdresse2Client = new JTextField();
		GridBagConstraints gbc_textFieldAdresse2Client = new GridBagConstraints();
		gbc_textFieldAdresse2Client.gridwidth = 5;
		gbc_textFieldAdresse2Client.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse2Client.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse2Client.gridx = 4;
		gbc_textFieldAdresse2Client.gridy = 6;
		frame.getContentPane().add(textFieldAdresse2Client, gbc_textFieldAdresse2Client);

		JLabel lblCodePostalClient = new JLabel("Code Postal");
		GridBagConstraints gbc_lblCodePostalClient = new GridBagConstraints();
		gbc_lblCodePostalClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodePostalClient.gridx = 2;
		gbc_lblCodePostalClient.gridy = 7;
		frame.getContentPane().add(lblCodePostalClient, gbc_lblCodePostalClient);

		textFieldCodePostalClient = new JTextField();
		GridBagConstraints gbc_textFieldCodePostalClient = new GridBagConstraints();
		gbc_textFieldCodePostalClient.gridwidth = 5;
		gbc_textFieldCodePostalClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodePostalClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodePostalClient.gridx = 4;
		gbc_textFieldCodePostalClient.gridy = 7;
		frame.getContentPane().add(textFieldCodePostalClient, gbc_textFieldCodePostalClient);

		JLabel lblVilleClient = new JLabel("Ville");
		GridBagConstraints gbc_lblVilleClient = new GridBagConstraints();
		gbc_lblVilleClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblVilleClient.gridx = 2;
		gbc_lblVilleClient.gridy = 8;
		frame.getContentPane().add(lblVilleClient, gbc_lblVilleClient);

		textFieldVilleClient = new JTextField();
		GridBagConstraints gbc_textFieldVilleClient = new GridBagConstraints();
		gbc_textFieldVilleClient.gridwidth = 5;
		gbc_textFieldVilleClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldVilleClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVilleClient.gridx = 4;
		gbc_textFieldVilleClient.gridy = 8;
		frame.getContentPane().add(textFieldVilleClient, gbc_textFieldVilleClient);

		JLabel lblNumTelClient = new JLabel("Num. Tel");
		GridBagConstraints gbc_lblNumTelClient = new GridBagConstraints();
		gbc_lblNumTelClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumTelClient.gridx = 2;
		gbc_lblNumTelClient.gridy = 9;
		frame.getContentPane().add(lblNumTelClient, gbc_lblNumTelClient);

		textFieldNumTelClient = new JTextField();
		GridBagConstraints gbc_textFieldNumTelClient = new GridBagConstraints();
		gbc_textFieldNumTelClient.gridwidth = 5;
		gbc_textFieldNumTelClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNumTelClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNumTelClient.gridx = 4;
		gbc_textFieldNumTelClient.gridy = 9;
		frame.getContentPane().add(textFieldNumTelClient, gbc_textFieldNumTelClient);

		JLabel lblEmailClient = new JLabel("Email");
		GridBagConstraints gbc_lblEmailClient = new GridBagConstraints();
		gbc_lblEmailClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmailClient.gridx = 2;
		gbc_lblEmailClient.gridy = 10;
		frame.getContentPane().add(lblEmailClient, gbc_lblEmailClient);

		textFieldEmailClient = new JTextField();
		GridBagConstraints gbc_textFieldEmailClient = new GridBagConstraints();
		gbc_textFieldEmailClient.gridwidth = 5;
		gbc_textFieldEmailClient.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmailClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmailClient.gridx = 4;
		gbc_textFieldEmailClient.gridy = 10;
		frame.getContentPane().add(textFieldEmailClient, gbc_textFieldEmailClient);

		JButton btnValiderModalAddClient = new JButton("VALIDER");
		GridBagConstraints gbc_btnValiderModalAdd = new GridBagConstraints();
		gbc_btnValiderModalAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnValiderModalAdd.gridx = 8;
		gbc_btnValiderModalAdd.gridy = 11;
		frame.getContentPane().add(btnValiderModalAddClient, gbc_btnValiderModalAdd);

		JButton btnAnnulerModalCancelClient = new JButton("ANNULER");
		GridBagConstraints gbc_btnAnnulerModalCancelClient = new GridBagConstraints();
		gbc_btnAnnulerModalCancelClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnAnnulerModalCancelClient.gridx = 9;
		gbc_btnAnnulerModalCancelClient.gridy = 11;
		frame.getContentPane().add(btnAnnulerModalCancelClient, gbc_btnAnnulerModalCancelClient);

		btnValiderModalAddClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.addClient(textFieldNomClient.getText(), textFieldPrenomClient.getText(),
						textFieldAdresse1Client.getText(), textFieldAdresse2Client.getText(),
						textFieldCodePostalClient.getText(), textFieldVilleClient.getText(),
						textFieldNumTelClient.getText(), textFieldEmailClient.getText());
				frame.dispose();
			}
		});

		btnAnnulerModalCancelClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
	}
	
}
