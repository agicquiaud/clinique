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

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.RendezVous;
import fr.eni.clinique.bo.User;
import fr.eni.clinique.ihm.controller.ControllerAgenda;
import fr.eni.clinique.ihm.controller.ControllerAgendaSingleton;
import fr.eni.clinique.ihm.controller.ControllerAnimaux;
import fr.eni.clinique.ihm.controller.ControllerAnimauxSingleton;
import fr.eni.clinique.ihm.controller.ControllerClients;
import fr.eni.clinique.ihm.controller.ControllerClientsSingleton;
import fr.eni.clinique.ihm.controller.ControllerPersonnels;
import fr.eni.clinique.ihm.controller.ControllerPersonnelsSingleton;

public class WindowRemove {

	private ControllerAgenda controllerAgenda;
	private ControllerAnimaux controllerAnimal;
	private ControllerClients controllerClient;
	private ControllerPersonnels controllerPersonnels;
	private JDialog PopupDelete = new JDialog();

	WindowRemove(Object obj) {
		controllerAgenda = ControllerAgendaSingleton.getinstance();
		controllerAnimal = ControllerAnimauxSingleton.getinstance();
		controllerClient = ControllerClientsSingleton.getinstance();
		controllerPersonnels = ControllerPersonnelsSingleton.getinstance();
		PopupDelete.setTitle("Suppression");
		PopupDelete.setSize(315, 150);
		PopupDelete.setResizable(false);
		PopupDelete.setLocationRelativeTo(null);
		PopupDelete.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		JLabel bckground = new JLabel(new ImageIcon("ressource/backgroung.jpg"));
		PopupDelete.setContentPane(bckground);

		GridBagLayout gbl_PopupDeleteClient = new GridBagLayout();
		gbl_PopupDeleteClient.columnWidths = new int[] { 35, 110, 100, 35, 0 };
		gbl_PopupDeleteClient.rowHeights = new int[] { 35, 0, 25, 0, 0, 0 };
		gbl_PopupDeleteClient.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_PopupDeleteClient.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		PopupDelete.getContentPane().setLayout(gbl_PopupDeleteClient);

		JLabel lbltesvousSurDe = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridwidth = 2;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		PopupDelete.getContentPane().add(lbltesvousSurDe, gbc_label);

		if (obj instanceof Clients) {
			lbltesvousSurDe.setText("Etes-vous sur de vouloir archiver ce client ?");
		} else if (obj instanceof Animaux) {
			lbltesvousSurDe.setText("Etes-vous sur de vouloir archiver cet animal ?");
		} else if (obj instanceof User) {
			lbltesvousSurDe.setText("Etes-vous sur de vouloir archiver ce personnel ?");
		} else if (obj instanceof RendezVous) {
			lbltesvousSurDe.setText("Etes-vous sur de vouloir supprimer ce rendez-vous ?");
		}

		JButton btnPopupDelete = new JButton("Oui");
		GridBagConstraints gbc_btnPopupDelete = new GridBagConstraints();
		gbc_btnPopupDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnPopupDelete.gridx = 1;
		gbc_btnPopupDelete.gridy = 3;
		PopupDelete.getContentPane().add(btnPopupDelete, gbc_btnPopupDelete);

		JButton btnPopupCancelDelete = new JButton("Non");
		GridBagConstraints gbc_btnPopupCancelDelete = new GridBagConstraints();
		gbc_btnPopupCancelDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnPopupCancelDelete.gridx = 2;
		gbc_btnPopupCancelDelete.gridy = 3;
		PopupDelete.getContentPane().add(btnPopupCancelDelete, gbc_btnPopupCancelDelete);
		btnPopupCancelDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PopupDelete.dispose();
			}
		});

		// Actions Listeners
		btnPopupDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (obj instanceof Clients) {
					controllerClient.removeClient(((Clients) obj).getCodeClient());
				} else if (obj instanceof Animaux) {
					controllerAnimal.removeAnimal(((Animaux) obj).getCodeAnimal());
				} else if (obj instanceof User) {
					controllerPersonnels.ArchivePersonnel(((User) obj).getLogin());
				} else if (obj instanceof RendezVous) {
					controllerAgenda.removeRDV((RendezVous) obj);
				}
				PopupDelete.dispose();
			}
		});

		PopupDelete.setVisible(true);
	}
}
