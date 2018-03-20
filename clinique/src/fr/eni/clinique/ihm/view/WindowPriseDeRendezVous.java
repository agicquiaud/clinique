package fr.eni.clinique.ihm.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.User;
import fr.eni.clinique.ihm.controller.ControllerAgenda;
import fr.eni.clinique.ihm.controller.ControllerAnimaux;
import fr.eni.clinique.ihm.controller.ControllerClients;
import fr.eni.clinique.ihm.controller.ControllerPersonnels;

public class WindowPriseDeRendezVous extends JFrame {

	private static final long serialVersionUID = 2363352550943035894L;
	private JPanel contentPaneNorth = new JPanel();
	private JPanel contentPaneNorthWest = new JPanel();
	private JPanel contentPaneNorthWestClient = new JPanel();
	private JPanel contentPaneNorthWestAnimal = new JPanel();
	private JPanel contentPaneNorthCenter = new JPanel();
	private JPanel contentPaneNorthEst = new JPanel();
	private JPanel contentPaneNorthEstSouth = new JPanel();
	private JPanel contentPaneCenter = new JPanel();
	private JPanel contentPaneSouth = new JPanel();
	private JPanel contentPaneSouthWest = new JPanel();
	private JPanel contentPaneSouthCenter = new JPanel();
	private JPanel contentPaneSouthEst = new JPanel();
	private Properties properties = new Properties();
	private UtilDateModel model = new UtilDateModel();
	private JDatePanelImpl datePanel;
	private DateLabelFormatter formatDate;
	private JDatePickerImpl datePicker;
	private ImageIcon icon = new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/plus.png");
	private ControllerAnimaux controllerAnimal = new ControllerAnimaux();
	private ControllerClients controllerClients = new ControllerClients();
	private final JButton btnAddClient = new JButton(icon);
	private final JButton btnAddAnimal = new JButton(icon);
	private ControllerAgenda CA = new ControllerAgenda();
	private DefaultTableModel tableModel;
	private JTable table;
	private SimpleDateFormat sdf;
	private JComboBox<User> CBVet;

	/**
	 * Create the frame.
	 */
	public WindowPriseDeRendezVous(){
		this.setTitle("Prise de rendez-vous");
		this.setSize(1000, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		properties.put("text.today", "Today");
		properties.put("text.month", "Month");
		properties.put("text.year", "Year");
		model.setValue(new Date());
		datePanel = new JDatePanelImpl(model, properties);
		formatDate = new DateLabelFormatter();
		datePicker = new JDatePickerImpl(datePanel, formatDate);
		
		contentPaneNorth.setLayout(new BoxLayout(contentPaneNorth, BoxLayout.LINE_AXIS));
		contentPaneNorthWest.setBorder(new EmptyBorder(0, 2, 2, 3));
		contentPaneNorthWest.setLayout(new GridLayout(10, 0));
		contentPaneNorthWest.add(new JLabel("Pour"));
		contentPaneNorthWest.add(new JLabel("Client :"));
		contentPaneNorthWestClient.setLayout(new GridLayout(1, 2));
		Clients[] client = new Clients[controllerClients.listeClient().length];
		client = controllerClients.listeClient();

		JComboBox<Clients> CBClient = new JComboBox<Clients>(client);
		CBClient.setRenderer(new ListCellRenderer<Clients>() {
			@Override
			public Component getListCellRendererComponent(JList<? extends Clients> list, Clients value, int index,
					boolean isSelected, boolean cellHasFocus) {
				DefaultListCellRenderer renderer = new DefaultListCellRenderer();
				renderer.setText(value.getNom() + " " + value.getPrenom());
				return renderer;
			}
		});
		CBClient.setBorder(new EmptyBorder(0, 2, 0, 2));
		contentPaneNorthWestClient.add(CBClient);
		contentPaneNorthWestClient.repaint();
		contentPaneNorthWest.add(contentPaneNorthWestClient);
		contentPaneNorthWestClient.add(btnAddClient);
		contentPaneNorthWest.add(new JLabel("Animal :"));
		contentPaneNorthWestAnimal.setLayout(new GridLayout(1, 2));

		btnAddClient.setOpaque(false);
		btnAddClient.setBackground(new Color(66, 210, 230));
		btnAddClient.setBorderPainted(false);
		btnAddClient.setFocusPainted(false);
		btnAddClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WindowAddClient();
			}
		});

		btnAddAnimal.setOpaque(false);
		btnAddAnimal.setBackground(new Color(66, 210, 230));
		btnAddAnimal.setBorderPainted(false);
		btnAddAnimal.setFocusPainted(false);
		btnAddAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!CBClient.getSelectedItem().toString().equals("")) {
					new WindowAddAnimal((Clients) CBClient.getSelectedItem());
				}
			}
		});
		Animaux[] tabAnimal = null;
		tabAnimal = controllerAnimal.getAnimalByIdClient(((Clients)CBClient.getSelectedItem()).getCodeClient());
		if (tabAnimal[0] == null){
			tabAnimal[0] =  new Animaux();
		}
		JComboBox<Animaux> CBAnimal = new JComboBox<Animaux>(tabAnimal);
		CBAnimal.setRenderer(new ListCellRenderer<Animaux>() {
			@Override
			public Component getListCellRendererComponent(JList<? extends Animaux> list, Animaux value, int index,
					boolean isSelected, boolean cellHasFocus) {
				DefaultListCellRenderer renderer = new DefaultListCellRenderer();
				renderer.setText(value.getNom());
				return renderer;
			}
		});
		CBClient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CBAnimal.removeAllItems();
				Animaux[] tabAnimaux2 = null;
				tabAnimaux2 = controllerAnimal.getAnimalByIdClient(((Clients)CBClient.getSelectedItem()).getCodeClient());
				if(tabAnimaux2[0] == null){
					tabAnimaux2[0] = new Animaux();
				}
				for (Animaux animaux : tabAnimaux2) {
					CBAnimal.addItem(animaux);
				}
				CBAnimal.repaint();
			}
		});
		
		contentPaneNorthWestAnimal.add(CBAnimal);
		contentPaneNorthWest.add(contentPaneNorthWestAnimal);
		contentPaneNorthWestAnimal.add(btnAddAnimal);
		contentPaneNorthCenter.setBorder(new EmptyBorder(0, 3, 0, 3));
		contentPaneNorthCenter.setLayout(new GridLayout(10, 1));
		contentPaneNorthCenter.add(new JLabel("Par"));
		contentPaneNorthCenter.add(new JLabel("Véterinaire :"));
		ControllerPersonnels cp = new ControllerPersonnels();
		User[] listeVeto= cp.getVeterinaire();
		CBVet = new JComboBox<User>(listeVeto);
		CBVet.setRenderer(new ListCellRenderer<User>() {
			@Override
			public Component getListCellRendererComponent(JList<? extends User> list, User value, int index,
					boolean isSelected, boolean cellHasFocus) {
				DefaultListCellRenderer renderer = new DefaultListCellRenderer();
				renderer.setText(value.getLogin() + " " + value.getPassword());
				return renderer;
			}
		});
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.format(model.getValue());
		String[] entete = { "Heure", "Nom du client", "Animal", "Race" };
		Object[][] donnee = CA.getTabAgenda(CBVet.getSelectedItem().toString(), sdf.format(model.getValue()));
		CBVet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setUpTableData(CA.getTabAgenda(CBVet.getSelectedItem().toString(), sdf.format(model.getValue())), entete);
				
			}
		});
		
		contentPaneNorthCenter.add(CBVet);
		contentPaneNorthEst.setBorder(new EmptyBorder(0, 3, 0, 2));
		contentPaneNorthEst.setLayout(new GridLayout(10, 1));
		contentPaneNorthEst.add(new JLabel("Quand"));
		contentPaneNorthEst.add(new JLabel("Date :"));
		datePicker.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setUpTableData(CA.getTabAgenda(CBVet.getSelectedItem().toString(), sdf.format(datePicker.getModel().getValue())), entete);
				
			}
		});
		contentPaneNorthEst.add(datePicker);
		contentPaneNorthEst.add(new JLabel());
		contentPaneNorthEstSouth.setLayout(new GridLayout(1, 4));
		JLabel label = new JLabel("Heure :");
		contentPaneNorthEstSouth.add(label);
		JSpinner heure = new JSpinner();
		heure.setModel(new SpinnerNumberModel(9, 9, 19, 1));
		contentPaneNorthEstSouth.add(heure);
		JLabel labelMin = new JLabel("Minute :");
		contentPaneNorthEstSouth.add(labelMin);
		JSpinner minute = new JSpinner();
		minute.setModel(new SpinnerNumberModel(00, 0, 45, 15));
		contentPaneNorthEstSouth.add(minute);
		contentPaneNorthEst.add(contentPaneNorthEstSouth);
		contentPaneNorth.add(contentPaneNorthWest);
		contentPaneNorth.add(contentPaneNorthCenter);
		contentPaneNorth.add(contentPaneNorthEst);		
		
		table = new JTable(donnee, entete);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setColumnHeaderView(table.getTableHeader());
		contentPaneCenter.setLayout(new BorderLayout());
		table.setAutoCreateRowSorter(true);
		contentPaneCenter.add(scrollPane);
		table.getSelectedColumn();
		table.getSelectedRow();

		contentPaneSouth.setLayout(new BoxLayout(contentPaneSouth, BoxLayout.LINE_AXIS));

		contentPaneSouthWest.setLayout(new BoxLayout(contentPaneSouthWest, BoxLayout.PAGE_AXIS));
		contentPaneSouthWest.add(new JLabel());

		contentPaneSouthCenter.setLayout(new BoxLayout(contentPaneSouthCenter, BoxLayout.PAGE_AXIS));
		contentPaneSouthCenter.add(new JLabel());

		contentPaneSouthEst.setLayout(new BoxLayout(contentPaneSouthEst, BoxLayout.PAGE_AXIS));
		JButton button = new JButton("Supprimer");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(table.getSelectedColumn()> -1 && table.getSelectedRow()>-1){
						CA.removeRDV((User) CBVet.getSelectedItem(),formatDate.valueToString(datePicker) , Integer.parseInt(heure.toString())
								, Integer.parseInt(minute.toString()), (Animaux) CBAnimal.getSelectedItem());
						setUpTableData(CA.getTabAgenda(CBVet.getSelectedItem().toString(), formatDate.valueToString(datePicker)), entete);
					}else
						System.out.println("Aucune ligne sélectionner");
					
				} catch (NumberFormatException | ParseException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		contentPaneSouthEst.add(button);
		JButton valider = new JButton("Valider");
		valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					CA.addRDV((User) CBVet.getSelectedItem(), formatDate.valueToString(datePicker), Integer.parseInt(heure.toString())
							, Integer.parseInt(minute.toString()), (Animaux) CBAnimal.getSelectedItem());
					setUpTableData(CA.getTabAgenda(CBVet.getSelectedItem().toString(), formatDate.valueToString(datePicker)), entete);
					
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
			}});
		contentPaneSouthEst.add(valider);

		contentPaneSouth.add(contentPaneSouthWest);
		contentPaneSouth.add(contentPaneSouthCenter);
		contentPaneSouth.add(contentPaneSouthEst);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		this.getContentPane().add(contentPaneNorth);
		this.getContentPane().add(contentPaneCenter);
		this.getContentPane().add(contentPaneSouth);

		this.setVisible(true);

	}
	private void setUpTableData(Object[][] data, String[] entetes) {
		tableModel = new DefaultTableModel(data, entetes) { // nouveau model
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(tableModel);
		tableModel.fireTableDataChanged(); // maj tableau
	}

}
