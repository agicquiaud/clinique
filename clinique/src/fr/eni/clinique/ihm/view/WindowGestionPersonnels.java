package fr.eni.clinique.ihm.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import fr.eni.clinique.ihm.controller.ControllerPersonnels;
import fr.eni.clinique.ihm.controller.ControllerPersonnelsSingleton;

public class WindowGestionPersonnels implements Observer {

	private JFrame frameGestionPersonnel;
	private JTable table;
	private ControllerPersonnels controllerPersonnels;
	private DefaultTableModel tableModel;
	private final String[] ENTETES = { "Nom", "Mot de passe", "Role" };

	public WindowGestionPersonnels() {

		controllerPersonnels = ControllerPersonnelsSingleton.getinstance();
		((Observable) controllerPersonnels).addObserver(this);
		frameGestionPersonnel = new JFrame();
		frameGestionPersonnel.setTitle("Gestion Personnel");
		frameGestionPersonnel.setSize(555, 370);
		frameGestionPersonnel.setResizable(false);
		frameGestionPersonnel.setLocationRelativeTo(null);
		frameGestionPersonnel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel bckground = new JLabel(new ImageIcon("ressource/backgroung.jpg"));
		frameGestionPersonnel.setContentPane(bckground);

		JMenuBar menuBar = new JMenuBar();
		frameGestionPersonnel.setJMenuBar(menuBar);

		JMenu mnConnexion = new JMenu("Menu");
		menuBar.add(mnConnexion);

		JMenuItem mntmDeconnexion = new JMenuItem("Deconnexion");
		mnConnexion.add(mntmDeconnexion);

		JMenuItem mntmRetour = new JMenuItem("Retour");
		mnConnexion.add(mntmRetour);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 25, 25, 78, 112, 75, 146, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 24, 21, 207, 0, 24 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		frameGestionPersonnel.getContentPane().setLayout(gridBagLayout);

		JButton btnAjouter = new JButton("AJOUTER");
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 5);
		gbc_btnAjouter.gridx = 1;
		gbc_btnAjouter.gridy = 1;
		frameGestionPersonnel.getContentPane().add(btnAjouter, gbc_btnAjouter);

		JButton btnSupprimer = new JButton("SUPPRIMER");
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimer.gridx = 3;
		gbc_btnSupprimer.gridy = 1;
		frameGestionPersonnel.getContentPane().add(btnSupprimer, gbc_btnSupprimer);

		JButton btnReinitialiser = new JButton("REINITIALISER");
		GridBagConstraints gbc_btnReinitialiser = new GridBagConstraints();
		gbc_btnReinitialiser.insets = new Insets(0, 0, 5, 5);
		gbc_btnReinitialiser.gridx = 5;
		gbc_btnReinitialiser.gridy = 1;
		frameGestionPersonnel.getContentPane().add(btnReinitialiser, gbc_btnReinitialiser);

		Object[][] donnee = controllerPersonnels.getList();
		table = new JTable();
		tableModel = new DefaultTableModel(donnee, ENTETES) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(tableModel);

		JScrollPane scrollPane = new JScrollPane(table);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		frameGestionPersonnel.getContentPane().add(scrollPane, gbc_scrollPane);

		JLabel lblError = new JLabel("");
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridwidth = 2;
		gbc_lblError.insets = new Insets(0, 0, 5, 5);
		gbc_lblError.gridx = 1;
		gbc_lblError.gridy = 4;
		frameGestionPersonnel.getContentPane().add(lblError, gbc_lblError);

		JLabel lblNewLabelGP = new JLabel("");
		GridBagConstraints gbc_lblNewLabelGP = new GridBagConstraints();
		gbc_lblNewLabelGP.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabelGP.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabelGP.gridwidth = 5;
		gbc_lblNewLabelGP.gridx = 1;
		gbc_lblNewLabelGP.gridy = 5;
		frameGestionPersonnel.getContentPane().add(lblNewLabelGP, gbc_lblNewLabelGP);

		frameGestionPersonnel.setVisible(true);

		// Actions Listeners
		mntmDeconnexion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameGestionPersonnel.dispose();
				new WindowLogin();
			}
		});

		mntmRetour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameGestionPersonnel.dispose();
				new WindowAccueilAdmin();
			}
		});

		btnAjouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblError.setText("");
				new WindowAddPersonnel();
			}
		});

		btnReinitialiser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					lblError.setText("");
					new WindowResetPassword(
							controllerPersonnels.getUserByNom(table.getValueAt(table.getSelectedRow(), 0).toString()));
				} catch (Exception err) {
					lblError.setText("Aucun personnel sélectionné");
				}
			}
		});

		btnSupprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					lblError.setText("");
					new WindowRemove(
							controllerPersonnels.getUserByNom(table.getValueAt(table.getSelectedRow(), 0).toString()));
				} catch (Exception err) {
					lblError.setText("Aucun personnel sélectionné");
				}
			}
		});
	}

	private void setUpTableData(Object[][] data, String[] entetes) {
		tableModel = new DefaultTableModel(data, entetes) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(tableModel);
		tableModel.fireTableDataChanged();
	}

	@Override
	public void update(Observable o, Object arg) {
		setUpTableData(controllerPersonnels.getList(), ENTETES);
	}

}
