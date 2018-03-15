package fr.eni.clinique.ihm.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFormattedTextField.AbstractFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import fr.eni.clinique.ihm.controller.ControllerClients;
import fr.eni.clinique.ihm.graphic.RoundButton;

public class WindowAgenda {
	
	private JFrame frame;
	private JTable table;
	private ImageIcon foldericon = new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/folder-icon.png");
	private Properties properties = new Properties();
	private UtilDateModel model = new UtilDateModel();
	private JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
	private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	private ControllerClients controllerclients;
	
	public WindowAgenda(){		
		
		controllerclients = new ControllerClients();
		frame = new JFrame();
		frame.setTitle("Agenda");
		frame.setBounds(100, 100, 585, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		GridBagLayout gridBagLayoutModalAddClient = new GridBagLayout();
		gridBagLayoutModalAddClient.columnWidths = new int[] { 33, 74, 152, 30, 52, 82, 62, 61, 0, 0 };
		gridBagLayoutModalAddClient.rowHeights = new int[] { 35, 0, 21, 0, 251, 31, 0, 0, 0 };
		gridBagLayoutModalAddClient.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayoutModalAddClient.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayoutModalAddClient);
		
		JLabel lblVeterinaire = new JLabel("Veterinaire :");
		GridBagConstraints gbc_lblVeterinaire = new GridBagConstraints();
		gbc_lblVeterinaire.insets = new Insets(0, 0, 5, 5);
		gbc_lblVeterinaire.gridx = 1;
		gbc_lblVeterinaire.gridy = 1;
		frame.getContentPane().add(lblVeterinaire, gbc_lblVeterinaire);
		
		String [] tabClient = controllerclients.getNomPrenomList();
		JComboBox<String>comboBox = new JComboBox<String>(tabClient);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		frame.getContentPane().add(comboBox, gbc_comboBox);
		
		JLabel lblDate = new JLabel("Date : ");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 4;
		gbc_lblDate.gridy = 1;
		frame.getContentPane().add(lblDate, gbc_lblDate);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 7;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);
		
		String[] entete = { "Heure", "Nom", "Animal", "Race" };
		Object[][] donnee = { { "10:45", "Bosapin", "Rex", "Labrador" } };
		
		table = new JTable(donnee, entete);
		scrollPane.setViewportView(table);
		
		JButton btnDossierMedical = new JButton(foldericon);
		btnDossierMedical.setBounds(62, 344, 180, 29);
		btnDossierMedical.setForeground(null);
		btnDossierMedical.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		btnDossierMedical.setOpaque(false);
		btnDossierMedical.setFocusPainted(true);
		btnDossierMedical.setBackground(new Color(66, 210, 230));
		btnDossierMedical.setBorderPainted(false);
		GridBagConstraints gbc_btnDossierMedical = new GridBagConstraints();
		gbc_btnDossierMedical.insets = new Insets(0, 0, 5, 5);
		gbc_btnDossierMedical.gridx = 6;
		gbc_btnDossierMedical.gridy = 6;
		frame.getContentPane().add(btnDossierMedical, gbc_btnDossierMedical);
		
	}
	
}

