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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import fr.eni.clinique.bo.User;
import fr.eni.clinique.ihm.controller.ControllerPersonnels;
import fr.eni.clinique.ihm.controller.ControllerPersonnelsSingleton;

public class WindowGestionPersonnels implements Observer{

	private JFrame frameGestionPersonnel;
	private JTable table;
	private ControllerPersonnels controllerPersonnels;
	private DefaultTableModel tableModel;
	private final String[] ENTETES = { "Nom", "Mot de passe", "Role" };

	/**
	 * Create the application.
	 */
	public WindowGestionPersonnels() {
		
		controllerPersonnels = ControllerPersonnelsSingleton.getinstance();
		((Observable) controllerPersonnels).addObserver(this);
		frameGestionPersonnel = new JFrame();
		frameGestionPersonnel.setTitle("Gestion Personnel");
		frameGestionPersonnel.setBounds(100, 100, 450, 300);
		frameGestionPersonnel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGestionPersonnel.setVisible(true);
		JLabel label = new JLabel(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/backgroung.jpg"));
		frameGestionPersonnel.setContentPane(label);
		
		JMenuBar menuBar = new JMenuBar();
		frameGestionPersonnel.setJMenuBar(menuBar);
		
		JMenu mnConnexion = new JMenu("Connexion");
		menuBar.add(mnConnexion);
		
		JMenuItem mntmDeconnexion = new JMenuItem("Deconnexion");
		mnConnexion.add(mntmDeconnexion);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 25, 112, 146, 0 };
		gridBagLayout.rowHeights = new int[] { 80, 20, 21, 101, 24 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frameGestionPersonnel.getContentPane().setLayout(gridBagLayout);

		JButton btnAjouter = new JButton("AJOUTER");
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 5);
		gbc_btnAjouter.gridx = 0;
		gbc_btnAjouter.gridy = 0;
		frameGestionPersonnel.getContentPane().add(btnAjouter, gbc_btnAjouter);

		JButton btnSupprimer = new JButton("SUPPRIMER");
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimer.gridx = 1;
		gbc_btnSupprimer.gridy = 0;
		frameGestionPersonnel.getContentPane().add(btnSupprimer, gbc_btnSupprimer);

		JButton btnReinitialiser = new JButton("REINITIALISER");
		GridBagConstraints gbc_btnReinitialiser = new GridBagConstraints();
		gbc_btnReinitialiser.insets = new Insets(0, 0, 5, 0);
		gbc_btnReinitialiser.gridx = 2;
		gbc_btnReinitialiser.gridy = 0;
		frameGestionPersonnel.getContentPane().add(btnReinitialiser, gbc_btnReinitialiser);

		JLabel lblerror = new JLabel("");
		GridBagConstraints gbc_lblerror = new GridBagConstraints();
		gbc_lblerror.insets = new Insets(0, 0, 5, 5);
		gbc_lblerror.gridx = 0;
		gbc_lblerror.gridy = 1;
		frameGestionPersonnel.getContentPane().add(lblerror, gbc_lblerror);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		frameGestionPersonnel.getContentPane().add(scrollPane, gbc_scrollPane);

		Object[][] donnee = controllerPersonnels.getList();
		table = new JTable();
		tableModel = new DefaultTableModel(donnee, ENTETES) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabelGP = new JLabel("");
		GridBagConstraints gbc_lblNewLabelGP = new GridBagConstraints();
		gbc_lblNewLabelGP.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabelGP.gridwidth = 3;
		gbc_lblNewLabelGP.gridx = 0;
		gbc_lblNewLabelGP.gridy = 4;
		frameGestionPersonnel.getContentPane().add(lblNewLabelGP, gbc_lblNewLabelGP);

		//Actions Listeners
		mntmDeconnexion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameGestionPersonnel.dispose();
				new WindowLogin();
			}
		});
		
		btnAjouter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WindowAddPersonnel();
			}
		});

		btnReinitialiser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WindowResetPassword(controllerPersonnels.getUserByNom(table.getValueAt(table.getSelectedRow(), 0).toString()));	
			}
		});

		btnSupprimer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					new WindowRemove(controllerPersonnels.getUserByNom(table.getValueAt(table.getSelectedRow(), 0).toString()));
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
