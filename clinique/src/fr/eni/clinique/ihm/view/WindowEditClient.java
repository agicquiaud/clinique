package fr.eni.clinique.ihm.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.ihm.controller.ControllerClients;

public class WindowEditClient extends WindowClients{
	
	private JDialog EditClient = new JDialog();	
	private JTextField textFieldNomClientEdit;
	private JTextField textFieldPrenomClientEdit;
	private JTextField textFieldAdresse1ClientEdit;
	private JTextField textFieldAdresse2ClientEdit;
	private JTextField textFieldVilleClientEdit;
	private JTextField textFieldCodePostalClientEdit;
	private JTextField textFieldNumTelClientEdit;
	private JTextField textFieldAssuranceClientEdit;
	private JTextField textFieldEmailClientEdit;
	private JTextField textFieldRemarqueClientEdit;
	private ControllerClients controllerclient;
	private String[] entetes = { "CodeClient", "Prenom", "Nom", "Code Postal", "Ville" };
	
	public WindowEditClient(Clients client){
		controllerclient = new ControllerClients();
		EditClient.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
		EditClient.setTitle("Gestion Client");
		EditClient.setSize(480, 330);
		EditClient.setLocationRelativeTo(null);
		EditClient.setVisible(true);
		
		GridBagLayout gbl_EditClient = new GridBagLayout();
		gbl_EditClient.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_EditClient.rowHeights = new int[] { 0, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_EditClient.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_EditClient.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		EditClient.getContentPane().setLayout(gbl_EditClient);

		JLabel lblEditerClient = new JLabel("Editer Client");
		GridBagConstraints gbc_lblEditerClient = new GridBagConstraints();
		gbc_lblEditerClient.gridwidth = 3;
		gbc_lblEditerClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditerClient.gridx = 7;
		gbc_lblEditerClient.gridy = 1;
		EditClient.getContentPane().add(lblEditerClient, gbc_lblEditerClient);

		JLabel lblCode = new JLabel("Code");
		GridBagConstraints gbc_lblCode = new GridBagConstraints();
		gbc_lblCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblCode.gridx = 2;
		gbc_lblCode.gridy = 2;
		EditClient.getContentPane().add(lblCode, gbc_lblCode);

		JLabel lblCodeClientEdit = new JLabel(client.getCodeClient().toString());
		GridBagConstraints gbc_lblCodeClientEdit = new GridBagConstraints();
//		gbc_lblCodeClientEdit.gridwidth = 5;
		gbc_lblCodeClientEdit.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodeClientEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCodeClientEdit.gridx = 3;
		gbc_lblCodeClientEdit.gridy = 2;
		EditClient.getContentPane().add(lblCodeClientEdit, gbc_lblCodeClientEdit);

		JLabel lblAssurance = new JLabel("Assurance");
		GridBagConstraints gbc_lblAssurance = new GridBagConstraints();
		gbc_lblAssurance.insets = new Insets(0, 0, 5, 5);
		gbc_lblAssurance.gridx = 9;
		gbc_lblAssurance.gridy = 2;
		EditClient.getContentPane().add(lblAssurance, gbc_lblAssurance);

		System.out.println(client.getAssurance());
		textFieldAssuranceClientEdit = new JTextField(client.getAssurance());
		textFieldAssuranceClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldAssuranceEdit = new GridBagConstraints();
		gbc_textFieldAssuranceEdit.gridwidth = 2;
		gbc_textFieldAssuranceEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAssuranceEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAssuranceEdit.gridx = 10;
		gbc_textFieldAssuranceEdit.gridy = 2;
		EditClient.getContentPane().add(textFieldAssuranceClientEdit, gbc_textFieldAssuranceEdit);

		JLabel lblNom = new JLabel("Nom");
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.insets = new Insets(0, 0, 5, 5);
		gbc_lblNom.gridx = 2;
		gbc_lblNom.gridy = 3;
		EditClient.getContentPane().add(lblNom, gbc_lblNom);

		textFieldNomClientEdit = new JTextField(client.getNom());
		textFieldNomClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldNomClientEdit = new GridBagConstraints();
		gbc_textFieldNomClientEdit.gridwidth = 5;
		gbc_textFieldNomClientEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNomClientEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomClientEdit.gridx = 3;
		gbc_textFieldNomClientEdit.gridy = 3;
		EditClient.getContentPane().add(textFieldNomClientEdit, gbc_textFieldNomClientEdit);

		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 9;
		gbc_lblEmail.gridy = 3;
		EditClient.getContentPane().add(lblEmail, gbc_lblEmail);

		textFieldEmailClientEdit = new JTextField(client.getEmail());
		textFieldEmailClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldEmailEdit = new GridBagConstraints();
		gbc_textFieldEmailEdit.gridwidth = 2;
		gbc_textFieldEmailEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmailEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmailEdit.gridx = 10;
		gbc_textFieldEmailEdit.gridy = 3;
		EditClient.getContentPane().add(textFieldEmailClientEdit, gbc_textFieldEmailEdit);

		JLabel lblPrenom = new JLabel("Prenom");
		GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
		gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrenom.gridx = 2;
		gbc_lblPrenom.gridy = 4;
		EditClient.getContentPane().add(lblPrenom, gbc_lblPrenom);

		textFieldPrenomClientEdit = new JTextField(client.getPrenom());
		textFieldPrenomClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldPrenomClientEdit = new GridBagConstraints();
		gbc_textFieldPrenomClientEdit.gridwidth = 5;
		gbc_textFieldPrenomClientEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrenomClientEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrenomClientEdit.gridx = 3;
		gbc_textFieldPrenomClientEdit.gridy = 4;
		EditClient.getContentPane().add(textFieldPrenomClientEdit, gbc_textFieldPrenomClientEdit);

		JLabel lblRemarque = new JLabel("Remarque");
		GridBagConstraints gbc_lblRemarque = new GridBagConstraints();
		gbc_lblRemarque.insets = new Insets(0, 0, 5, 5);
		gbc_lblRemarque.gridx = 9;
		gbc_lblRemarque.gridy = 4;
		EditClient.getContentPane().add(lblRemarque, gbc_lblRemarque);

		textFieldRemarqueClientEdit = new JTextField(client.getRemarque());
		textFieldRemarqueClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldRemarqueEdit = new GridBagConstraints();
		gbc_textFieldRemarqueEdit.gridheight = 3;
		gbc_textFieldRemarqueEdit.gridwidth = 2;
		gbc_textFieldRemarqueEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldRemarqueEdit.fill = GridBagConstraints.BOTH;
		gbc_textFieldRemarqueEdit.gridx = 10;
		gbc_textFieldRemarqueEdit.gridy = 4;
		EditClient.getContentPane().add(textFieldRemarqueClientEdit, gbc_textFieldRemarqueEdit);

		JLabel lblAdresse = new JLabel("Adresse");
		GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
		gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdresse.gridx = 2;
		gbc_lblAdresse.gridy = 5;
		EditClient.getContentPane().add(lblAdresse, gbc_lblAdresse);

		textFieldAdresse1ClientEdit = new JTextField(client.getAdresse1());
		textFieldAdresse1ClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldAdresse1ClientEdit = new GridBagConstraints();
		gbc_textFieldAdresse1ClientEdit.gridwidth = 5;
		gbc_textFieldAdresse1ClientEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse1ClientEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse1ClientEdit.gridx = 3;
		gbc_textFieldAdresse1ClientEdit.gridy = 5;
		EditClient.getContentPane().add(textFieldAdresse1ClientEdit, gbc_textFieldAdresse1ClientEdit);

		textFieldAdresse2ClientEdit = new JTextField(client.getAdresse2());
		textFieldAdresse2ClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldAdresse2ClientEdit = new GridBagConstraints();
		gbc_textFieldAdresse2ClientEdit.gridwidth = 5;
		gbc_textFieldAdresse2ClientEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAdresse2ClientEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAdresse2ClientEdit.gridx = 3;
		gbc_textFieldAdresse2ClientEdit.gridy = 6;
		EditClient.getContentPane().add(textFieldAdresse2ClientEdit, gbc_textFieldAdresse2ClientEdit);

		JLabel lblVille = new JLabel("Ville");
		GridBagConstraints gbc_lblVille = new GridBagConstraints();
		gbc_lblVille.insets = new Insets(0, 0, 5, 5);
		gbc_lblVille.gridx = 2;
		gbc_lblVille.gridy = 7;
		EditClient.getContentPane().add(lblVille, gbc_lblVille);

		textFieldVilleClientEdit = new JTextField(client.getVille());
		textFieldVilleClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldVilleClientEdit = new GridBagConstraints();
		gbc_textFieldVilleClientEdit.gridwidth = 5;
		gbc_textFieldVilleClientEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldVilleClientEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldVilleClientEdit.gridx = 3;
		gbc_textFieldVilleClientEdit.gridy = 7;
		EditClient.getContentPane().add(textFieldVilleClientEdit, gbc_textFieldVilleClientEdit);

		JLabel lblCodePostal = new JLabel("Code Postal");
		GridBagConstraints gbc_lblCodePostal = new GridBagConstraints();
		gbc_lblCodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodePostal.gridx = 2;
		gbc_lblCodePostal.gridy = 8;
		EditClient.getContentPane().add(lblCodePostal, gbc_lblCodePostal);

		textFieldCodePostalClientEdit = new JTextField(client.getCodePostal());
		textFieldCodePostalClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldCodePostalEdit = new GridBagConstraints();
		gbc_textFieldCodePostalEdit.gridwidth = 5;
		gbc_textFieldCodePostalEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCodePostalEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCodePostalEdit.gridx = 3;
		gbc_textFieldCodePostalEdit.gridy = 8;
		EditClient.getContentPane().add(textFieldCodePostalClientEdit, gbc_textFieldCodePostalEdit);

		JLabel lblNumTel = new JLabel("Num. Tel");
		GridBagConstraints gbc_lblNumTel = new GridBagConstraints();
		gbc_lblNumTel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumTel.gridx = 2;
		gbc_lblNumTel.gridy = 9;
		EditClient.getContentPane().add(lblNumTel, gbc_lblNumTel);

		textFieldNumTelClientEdit = new JTextField(client.getNumTel());
		textFieldNumTelClientEdit.setColumns(10);
		GridBagConstraints gbc_textFieldNumTelEdit = new GridBagConstraints();
		gbc_textFieldNumTelEdit.gridwidth = 5;
		gbc_textFieldNumTelEdit.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNumTelEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNumTelEdit.gridx = 3;
		gbc_textFieldNumTelEdit.gridy = 9;
		EditClient.getContentPane().add(textFieldNumTelClientEdit, gbc_textFieldNumTelEdit);

		JButton btnConfirmEditClient = new JButton("Valider");
		GridBagConstraints gbc_btnConfirmEditClient = new GridBagConstraints();
		gbc_btnConfirmEditClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnConfirmEditClient.gridx = 10;
		gbc_btnConfirmEditClient.gridy = 10;
		EditClient.getContentPane().add(btnConfirmEditClient, gbc_btnConfirmEditClient);

		JButton btnCancelEditClient = new JButton("Annuler");
		GridBagConstraints gbc_btnCancelEditClient = new GridBagConstraints();
		gbc_btnCancelEditClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelEditClient.gridx = 11;
		gbc_btnCancelEditClient.gridy = 10;
		EditClient.getContentPane().add(btnCancelEditClient, gbc_btnCancelEditClient);
		
		//Actions Listeners
		btnCancelEditClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditClient.dispose();
			}
		});

		btnConfirmEditClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controllerclient.updateClient(lblCodeClientEdit.getText(), textFieldNomClientEdit.getText(),
						textFieldPrenomClientEdit.getText(), textFieldAdresse1ClientEdit.getText(),
						textFieldAdresse2ClientEdit.getText(), textFieldCodePostalClientEdit.getText(),
						textFieldVilleClientEdit.getText(), textFieldNumTelClientEdit.getText(),
						textFieldAssuranceClientEdit.getText(), textFieldEmailClientEdit.getText(),
						textFieldRemarqueClientEdit.getText());
				setUpTableClient(controllerclient.getList(), entetes);
				EditClient.dispose();
			}
		});
		
	}
	
}
