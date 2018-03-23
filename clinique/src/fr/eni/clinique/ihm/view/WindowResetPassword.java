package fr.eni.clinique.ihm.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.eni.clinique.bo.User;
import fr.eni.clinique.ihm.controller.ControllerPersonnels;
import fr.eni.clinique.ihm.controller.ControllerPersonnelsSingleton;

public class WindowResetPassword {
	
	private JDialog ResetMdp = new JDialog();
	private JTextField textField;
	private ControllerPersonnels controllerPersonnels;
	
	public WindowResetPassword(User user) {
		
		controllerPersonnels = ControllerPersonnelsSingleton.getinstance();
		ResetMdp.setTitle("R\u00E9initialisation de mot de passe");
		ResetMdp.setSize(460, 200);
		ResetMdp.setResizable(false);
		ResetMdp.setLocationRelativeTo(null);
		JLabel bckground = new JLabel(new ImageIcon("ressource/backgroung.jpg"));
		ResetMdp.setContentPane(bckground);		
		
		GridBagLayout gridBagLayoutModalReset = new GridBagLayout();
		gridBagLayoutModalReset.columnWidths = new int[] { 25, 0, 35, 160, 68, 30, 0 };
		gridBagLayoutModalReset.rowHeights = new int[] { 25, 25, 0, 35, 0, 0, 0 };
		gridBagLayoutModalReset.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayoutModalReset.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		ResetMdp.getContentPane().setLayout(gridBagLayoutModalReset);

		JLabel lblMdp = new JLabel("Nouveau mot de passe");
		GridBagConstraints gbc_lblMdp = new GridBagConstraints();
		gbc_lblMdp.insets = new Insets(0, 0, 5, 5);
		gbc_lblMdp.gridx = 1;
		gbc_lblMdp.gridy = 2;
		ResetMdp.getContentPane().add(lblMdp, gbc_lblMdp);
		
				textField = new JTextField();
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.insets = new Insets(0, 0, 5, 5);
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.gridx = 3;
				gbc_textField.gridy = 2;
				ResetMdp.getContentPane().add(textField, gbc_textField);
				textField.setColumns(10);

		JButton btnValiderModalReset = new JButton("VALIDER");
		GridBagConstraints gbc_btnValiderModalReset = new GridBagConstraints();
		gbc_btnValiderModalReset.insets = new Insets(0, 0, 5, 5);
		gbc_btnValiderModalReset.gridx = 4;
		gbc_btnValiderModalReset.gridy = 4;
		ResetMdp.getContentPane().add(btnValiderModalReset, gbc_btnValiderModalReset);
		
		ResetMdp.setVisible(true);
		
		//Actions Listeners
		btnValiderModalReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controllerPersonnels.resetMotDePasse(user.getLogin(), textField.getText());
				ResetMdp.dispose();
			}
		});
		
	}
}
