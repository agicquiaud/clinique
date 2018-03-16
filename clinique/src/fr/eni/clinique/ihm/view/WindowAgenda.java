package fr.eni.clinique.ihm.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import fr.eni.clinique.ihm.controller.ControllerAgenda;
import fr.eni.clinique.ihm.controller.ControllerPersonnels;
import fr.eni.clinique.ihm.graphic.ImagePanel;

public class WindowAgenda {
	
	private JFrame frame;
	private ImagePanel imgBack = new ImagePanel(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/login-color.jpg").getImage());
	private JTable table;
	private DefaultTableModel tableModel;
	private ImageIcon foldericon = new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/folder-icon.png");
	private Properties properties = new Properties();
	private UtilDateModel model = new UtilDateModel();
	private JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
	private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());;
	private ControllerPersonnels controllerpersonnels;
	private ControllerAgenda controlleragenda;
	
	public WindowAgenda(){		
		
		controllerpersonnels = new ControllerPersonnels();
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
		
		String [] tabVet = controllerpersonnels.getNomVeterinaires();
		JComboBox<String>comboBoxVet = new JComboBox<String>(tabVet);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		frame.getContentPane().add(comboBoxVet, gbc_comboBox);
		
		JLabel lblDate = new JLabel("Date : ");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 4;
		gbc_lblDate.gridy = 1;
		frame.getContentPane().add(lblDate, gbc_lblDate);
		
		//initialisation de la date d'aujourd'hui
		model.setValue(new Date());
		datePicker.setTextEditable(true);
		GridBagConstraints gbc_DatePicker = new GridBagConstraints();
		gbc_DatePicker.gridwidth = 2;
		gbc_DatePicker.fill = GridBagConstraints.HORIZONTAL;
		gbc_DatePicker.insets = new Insets(0, 0, 5, 5);
		gbc_DatePicker.gridx = 5;
		gbc_DatePicker.gridy = 1;
		frame.getContentPane().add(datePicker, gbc_DatePicker);
		
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
		System.out.println(comboBoxVet.getSelectedItem().toString());
		System.out.println(datePicker.getJFormattedTextField().getText());
		System.out.println(controlleragenda.getTabAgenda(comboBoxVet.getSelectedItem().toString(), datePicker.getJFormattedTextField().getText()));
		Object[][] donnee = {{ "Heure", "Nom", "Animal", "Race" }};
		table = new JTable(donnee, entete);
		scrollPane.setViewportView(table);
		
		JButton btnDossierMedical = new JButton(foldericon);
		btnDossierMedical.setBounds(62, 344, 90, 29);
		btnDossierMedical.setForeground(null);
		btnDossierMedical.setFont(new Font("Malgun Gothic", Font.BOLD, 15));
		btnDossierMedical.setOpaque(false);
		btnDossierMedical.setFocusPainted(false);
		btnDossierMedical.setBackground(new Color(66, 210, 230));
		btnDossierMedical.setBorderPainted(false);
		GridBagConstraints gbc_btnDossierMedical = new GridBagConstraints();
		gbc_btnDossierMedical.insets = new Insets(0, 0, 5, 5);
		gbc_btnDossierMedical.gridx = 6;
		gbc_btnDossierMedical.gridy = 6;
		frame.getContentPane().add(btnDossierMedical, gbc_btnDossierMedical);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnConnexion = new JMenu("Connexion");
		menuBar.add(mnConnexion);
		
		JMenuItem mntmDeconnexion = new JMenuItem("Deconnexion");
		mnConnexion.add(mntmDeconnexion);
		
		//Action Listener DatePicker for refresh JTable
		datePicker.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		//Action Listener buttonDossierMedical for the Popup
		btnDossierMedical.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WindowDossierMedicalAnimal();
			}
		});
		
		mntmDeconnexion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new WindowLogin();
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
	
}

