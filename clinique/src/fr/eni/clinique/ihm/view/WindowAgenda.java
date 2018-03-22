package fr.eni.clinique.ihm.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.RendezVous;
import fr.eni.clinique.ihm.controller.ControllerAgenda;
import fr.eni.clinique.ihm.controller.ControllerAgendaSingleton;
import fr.eni.clinique.ihm.controller.ControllerAnimaux;
import fr.eni.clinique.ihm.controller.ControllerAnimauxSingleton;
import fr.eni.clinique.ihm.controller.ControllerPersonnels;
import fr.eni.clinique.ihm.controller.ControllerPersonnelsSingleton;

public class WindowAgenda {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel tableModel;
	private ImageIcon foldericon = new ImageIcon("ressource/folder-icon.png");
	private Properties properties = new Properties();
	private UtilDateModel model = new UtilDateModel();
	private JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
	private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	private Calendar cal = Calendar.getInstance();
	private ControllerPersonnels controllerpersonnels;
	private ControllerAgenda controlleragenda;
	private ControllerAnimaux controlleranimaux;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public WindowAgenda(String nom) {
		controlleragenda = ControllerAgendaSingleton.getinstance();
		controlleranimaux = ControllerAnimauxSingleton.getinstance();
		controllerpersonnels = ControllerPersonnelsSingleton.getinstance();
		frame = new JFrame();
		frame.setTitle("Agenda");
		frame.setSize(585, 470);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel bckground = new JLabel(new ImageIcon("ressource/backgroung.jpg"));
		frame.setContentPane(bckground);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnConnexion = new JMenu("Menu");
		menuBar.add(mnConnexion);

		JMenuItem mntmDeconnexion = new JMenuItem("Deconnexion");
		mnConnexion.add(mntmDeconnexion);

		JMenuItem mntmRetour = new JMenuItem("Retour");
		mnConnexion.add(mntmRetour);

		GridBagLayout gridBagLayoutModalAddClient = new GridBagLayout();
		gridBagLayoutModalAddClient.columnWidths = new int[] { 33, 74, 152, 30, 52, 82, 62, 61, 0, 0 };
		gridBagLayoutModalAddClient.rowHeights = new int[] { 35, 0, 21, 0, 251, 31, 0, 0, 0 };
		gridBagLayoutModalAddClient.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayoutModalAddClient.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayoutModalAddClient);

		JLabel lblVeterinaire = new JLabel("Veterinaire :");
		GridBagConstraints gbc_lblVeterinaire = new GridBagConstraints();
		gbc_lblVeterinaire.insets = new Insets(0, 0, 5, 5);
		gbc_lblVeterinaire.gridx = 1;
		gbc_lblVeterinaire.gridy = 1;
		frame.getContentPane().add(lblVeterinaire, gbc_lblVeterinaire);

		String[] tabVet = controllerpersonnels.getNomVeterinaires();
		JComboBox<String> comboBoxVet = new JComboBox<String>(tabVet);
		comboBoxVet.setSelectedItem(nom);
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

		// initialisation de la date d'aujourd'hui
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
		Object[][] donnee = controlleragenda.getTabAgenda(comboBoxVet.getSelectedItem().toString(),
				datePicker.getJFormattedTextField().getText());
		table = new JTable();
		tableModel = new DefaultTableModel(donnee, entete) { // nouveau model
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(tableModel);
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

		JLabel error = new JLabel("");
		GridBagConstraints gbc_error = new GridBagConstraints();
		gbc_error.insets = new Insets(0, 0, 5, 5);
		gbc_error.gridx = 2;
		gbc_error.gridy = 6;
		frame.getContentPane().add(error, gbc_error);

		frame.setVisible(true);

		// Action Listener DatePicker for refresh JTable
		datePicker.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				error.setText("");
				setUpTableData(controlleragenda.getTabAgenda(comboBoxVet.getSelectedItem().toString(),
						datePicker.getJFormattedTextField().getText()), entete);
			}
		});
		// Action Listener combobox actualisation du tableau
		comboBoxVet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				error.setText("");
				setUpTableData(controlleragenda.getTabAgenda(comboBoxVet.getSelectedItem().toString(),
						datePicker.getJFormattedTextField().getText()), entete);
			}
		});

		// Action Listener buttonDossierMedical for the Popup
		btnDossierMedical.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					error.setText("");
					String[] str = sdf.format(datePicker.getModel().getValue()).split("/");
					String[] strhm = table.getValueAt(table.getSelectedRow(), 0).toString().split(":");
					System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
					cal.set(Integer.parseInt(str[2]), Integer.parseInt(str[1]) - 1, Integer.parseInt(str[0]),
							Integer.parseInt(strhm[0]), Integer.parseInt(strhm[1]), 00);
					SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String strDate = sm.format(cal.getTime());
					try {
						cal.setTime(sm.parse(strDate));
					} catch (ParseException err) {
					}
					Animaux animaux = controlleranimaux
							.getAnimalById(controlleragenda.getRdvByCodeVetDate(new RendezVous(
									controllerpersonnels.getUserByNom(comboBoxVet.getSelectedItem().toString()).getId(),
									cal.getTime())).getCodeAnimal().toString());
					new WindowDossierMedicalAnimal(table.getModel().getValueAt(table.getSelectedRow(), 1).toString(),
							controlleranimaux.getAnimalById(animaux.getCodeAnimal().toString()));
				} catch (Exception err) {
					error.setText("Aucun rendez-vous sélectionné");
				}
			}
		});
		// Action listener deconnexion
		mntmDeconnexion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new WindowLogin();
			}
		});

		mntmRetour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new WindowAccueilVeterinaire(nom);
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
