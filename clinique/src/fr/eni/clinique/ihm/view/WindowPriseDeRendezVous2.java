package fr.eni.clinique.ihm.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.ihm.controller.ControllerClients;
import fr.eni.clinique.ihm.controller.ControllerClientsSingleton;

public class WindowPriseDeRendezVous2 {

	private JFrame frame = new JFrame();
	private Properties properties = new Properties();
	private UtilDateModel model = new UtilDateModel();
	private JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
	private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());;
	private ImageIcon icon = new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/plus.png");
	private ControllerClients controllerClients;
	private final JLabel lblPar = new JLabel("Pour");
	private final JLabel lblClient = new JLabel("Client : ");
	private final JComboBox<String>comboBox = new JComboBox<String>();
	private final JLabel lblAnimal = new JLabel("Animal : ");
	private final JComboBox<String>comboBox_1 = new JComboBox<String>();
	private final JButton btnAddClient = new JButton(icon);
	private final JButton btnAddAnimal = new JButton(icon);
	private final JLabel lblPar_1 = new JLabel("Par");
	private final JLabel lblVeterinaire = new JLabel("Veterinaire :");
	private final JComboBox<String>comboBox_2 = new JComboBox<String>();
	private final JLabel lblQuand = new JLabel("Quand");
	private final JLabel lblDate = new JLabel("Date : ");
	private final JLabel lblHeure = new JLabel("Heure : ");
	private final JLabel lblMinute = new JLabel("Minute :");
	private final JSpinner spinner = new JSpinner();
	private final JSpinner spinner_1 = new JSpinner();
	private final JTable table;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JButton btnSupprimer = new JButton("Supprimer");
	private final JButton btnValider = new JButton("Valider");

	/**
	 * Create the frame.
	 */
	public WindowPriseDeRendezVous2() {
		controllerClients = ControllerClientsSingleton.getinstance();
		frame.setTitle("Prise de rendez-vous");
		frame.setSize(850, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		properties.put("text.today", "Today");
		properties.put("text.month", "Month");
		properties.put("text.year", "Year");
		
		btnAddClient.setOpaque(false);
		btnAddClient.setBackground(new Color(66, 210, 230));
		btnAddClient.setBorderPainted(false);
		btnAddClient.setFocusPainted(false);
		
		btnAddAnimal.setOpaque(false);
		btnAddAnimal.setBackground(new Color(66, 210, 230));
		btnAddAnimal.setBorderPainted(false);
		btnAddAnimal.setFocusPainted(false);
		
		model.setValue(new Date());
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 60, 80, 62, 70, 32, 80, 70, 0, 91, 0, 97, 0, 0};
		gridBagLayout.rowHeights = new int[]{29, 0, 0, 0, 0, 0, 355, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		GridBagConstraints gbc_lblPar = new GridBagConstraints();
		gbc_lblPar.anchor = GridBagConstraints.WEST;
		gbc_lblPar.insets = new Insets(0, 0, 5, 5);
		gbc_lblPar.gridx = 1;
		gbc_lblPar.gridy = 0;
		frame.getContentPane().add(lblPar, gbc_lblPar);
		
		GridBagConstraints gbc_lblPar_1 = new GridBagConstraints();
		gbc_lblPar_1.anchor = GridBagConstraints.WEST;
		gbc_lblPar_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPar_1.gridx = 5;
		gbc_lblPar_1.gridy = 0;
		frame.getContentPane().add(lblPar_1, gbc_lblPar_1);
		
		GridBagConstraints gbc_lblQuand = new GridBagConstraints();
		gbc_lblQuand.anchor = GridBagConstraints.WEST;
		gbc_lblQuand.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuand.gridx = 8;
		gbc_lblQuand.gridy = 0;
		frame.getContentPane().add(lblQuand, gbc_lblQuand);
		
		GridBagConstraints gbc_lblClient = new GridBagConstraints();
		gbc_lblClient.anchor = GridBagConstraints.WEST;
		gbc_lblClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblClient.gridx = 1;
		gbc_lblClient.gridy = 1;
		frame.getContentPane().add(lblClient, gbc_lblClient);
		
		GridBagConstraints gbc_lblVeterinaire = new GridBagConstraints();
		gbc_lblVeterinaire.insets = new Insets(0, 0, 5, 5);
		gbc_lblVeterinaire.gridx = 5;
		gbc_lblVeterinaire.gridy = 1;
		frame.getContentPane().add(lblVeterinaire, gbc_lblVeterinaire);
		
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 8;
		gbc_lblDate.gridy = 1;
		frame.getContentPane().add(lblDate, gbc_lblDate);
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		frame.getContentPane().add(comboBox, gbc_comboBox);
		
		GridBagConstraints gbc_btnAddClient = new GridBagConstraints();
		gbc_btnAddClient.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddClient.gridx = 3;
		gbc_btnAddClient.gridy = 2;
		frame.getContentPane().add(btnAddClient, gbc_btnAddClient);
		
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.gridwidth = 2;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 5;
		gbc_comboBox_2.gridy = 2;
		frame.getContentPane().add(comboBox_2, gbc_comboBox_2);
		datePicker.setTextEditable(true);
		GridBagConstraints gbc_datePicker = new GridBagConstraints();
		gbc_datePicker.fill = GridBagConstraints.HORIZONTAL;
		gbc_datePicker.gridwidth = 4;
		gbc_datePicker.insets = new Insets(0, 0, 5, 5);
		gbc_datePicker.gridx = 8;
		gbc_datePicker.gridy = 2;
		frame.getContentPane().add(datePicker, gbc_datePicker);
		
		GridBagConstraints gbc_lblAnimal = new GridBagConstraints();
		gbc_lblAnimal.anchor = GridBagConstraints.WEST;
		gbc_lblAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnimal.gridx = 1;
		gbc_lblAnimal.gridy = 3;
		frame.getContentPane().add(lblAnimal, gbc_lblAnimal);
		
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 4;
		frame.getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		GridBagConstraints gbc_btnAddAnimal = new GridBagConstraints();
		gbc_btnAddAnimal.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddAnimal.gridx = 3;
		gbc_btnAddAnimal.gridy = 4;
		frame.getContentPane().add(btnAddAnimal, gbc_btnAddAnimal);
		
		GridBagConstraints gbc_lblHeure = new GridBagConstraints();
		gbc_lblHeure.insets = new Insets(0, 0, 5, 5);
		gbc_lblHeure.gridx = 8;
		gbc_lblHeure.gridy = 4;
		frame.getContentPane().add(lblHeure, gbc_lblHeure);
		
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 9;
		gbc_spinner.gridy = 4;
		frame.getContentPane().add(spinner, gbc_spinner);
		
		GridBagConstraints gbc_lblMinute = new GridBagConstraints();
		gbc_lblMinute.insets = new Insets(0, 0, 5, 5);
		gbc_lblMinute.gridx = 10;
		gbc_lblMinute.gridy = 4;
		frame.getContentPane().add(lblMinute, gbc_lblMinute);
		
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_1.gridx = 11;
		gbc_spinner_1.gridy = 4;
		frame.getContentPane().add(spinner_1, gbc_spinner_1);
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 10;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 6;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		String[] entete = { "Heure", "Nom du client", "Animal", "Race" };
		Object[][] donnee = { { "10:45", "Bosapin", "Rex", "Labrador" } };
		table = new JTable(donnee, entete);
		scrollPane.setViewportView(table);
		
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.anchor = GridBagConstraints.EAST;
		gbc_btnValider.gridwidth = 2;
		gbc_btnValider.insets = new Insets(0, 0, 0, 5);
		gbc_btnValider.gridx = 9;
		gbc_btnValider.gridy = 7;
		frame.getContentPane().add(btnValider, gbc_btnValider);
		
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.insets = new Insets(0, 0, 0, 5);
		gbc_btnSupprimer.gridx = 11;
		gbc_btnSupprimer.gridy = 7;
		frame.getContentPane().add(btnSupprimer, gbc_btnSupprimer);

		Integer i = 1;
		Clients[] client = new Clients[controllerClients.listeClient().length];
		client = controllerClients.listeClient();
		String[] tabNomClient = new String[controllerClients.listeClient().length + 1];
		tabNomClient[0] = "";
		for (Clients cli : client) {
			tabNomClient[i] = cli.getNom() + " " + cli.getPrenom();
			i++;
		}

		frame.setVisible(true);
	}
}
