package fr.eni.clinique.ihm.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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

public class WindowPriseDeRendezVous implements Observer{

	private JFrame frame = new JFrame();
	private Calendar cal = Calendar.getInstance();
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
	private ControllerAnimaux controllerAnimal;
	private ControllerClients controllerClients;
	private final JButton btnAddClient = new JButton(icon);
	private final JButton btnAddAnimal = new JButton(icon);
	private ControllerAgenda CA;
	private ControllerPersonnels cp;
	private DefaultTableModel tableModel;
	private JTable table;
	private SimpleDateFormat sdf;
	private JComboBox<Animaux> CBAnimal;
	private DefaultComboBoxModel<Animaux> comboboxModelAnimal;
	private JComboBox<Clients> CBClient;
	private DefaultComboBoxModel<Clients> comboboxModelClient;
	private JComboBox<User> CBVet;
	private JLabel err = new JLabel();
	private final String[] ENTETES = { "Heure", "Nom du client", "Animal", "Race" };

	public WindowPriseDeRendezVous() {
		CA = ControllerAgendaSingleton.getinstance();
		((Observable) CA).addObserver(this);
		cp = ControllerPersonnelsSingleton.getinstance();
		controllerAnimal = ControllerAnimauxSingleton.getinstance();
		((Observable) controllerAnimal).addObserver(this);
		controllerClients = ControllerClientsSingleton.getinstance();
		((Observable) controllerClients).addObserver(this);
		frame.setTitle("Prise de rendez-vous");
		frame.setSize(1000, 800);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel bckground = new JLabel(new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/backgroung.jpg"));
		frame.setContentPane(bckground);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnConnexion = new JMenu("Menu");
		menuBar.add(mnConnexion);

		JMenuItem mntmDeconnexion = new JMenuItem("Deconnexion");
		mnConnexion.add(mntmDeconnexion);

		JMenuItem mntmRetour = new JMenuItem("Retour");
		mnConnexion.add(mntmRetour);

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

		CBClient = new JComboBox<Clients>(client);
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

		btnAddAnimal.setOpaque(false);
		btnAddAnimal.setBackground(new Color(66, 210, 230));
		btnAddAnimal.setBorderPainted(false);
		btnAddAnimal.setFocusPainted(false);
		Animaux[] tabAnimal = null;
		tabAnimal = controllerAnimal.getAnimalByIdClient(((Clients) CBClient.getSelectedItem()).getCodeClient());
		if (tabAnimal[0] == null) {
			tabAnimal[0] = new Animaux();
		}
		CBAnimal = new JComboBox<Animaux>(tabAnimal);
		CBAnimal.setRenderer(new ListCellRenderer<Animaux>() {
			@Override
			public Component getListCellRendererComponent(JList<? extends Animaux> list, Animaux value, int index,
					boolean isSelected, boolean cellHasFocus) {
				DefaultListCellRenderer renderer = new DefaultListCellRenderer();
				renderer.setText(value.getNom());
				return renderer;
			}
		});
		contentPaneNorthWestAnimal.add(CBAnimal);
		contentPaneNorthWest.add(contentPaneNorthWestAnimal);
		contentPaneNorthWestAnimal.add(btnAddAnimal);
		contentPaneNorthCenter.setBorder(new EmptyBorder(0, 3, 0, 3));
		contentPaneNorthCenter.setLayout(new GridLayout(10, 1));
		contentPaneNorthCenter.add(new JLabel("Par"));
		contentPaneNorthCenter.add(new JLabel("Véterinaire :"));
		User[] listeVeto = cp.getVeterinaire();
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
		Object[][] donnee = CA.getTabAgenda(((User) CBVet.getSelectedItem()).getLogin(), sdf.format(model.getValue()));
		contentPaneNorthCenter.add(CBVet);
		contentPaneNorthEst.setBorder(new EmptyBorder(0, 3, 0, 2));
		contentPaneNorthEst.setLayout(new GridLayout(10, 1));
		contentPaneNorthEst.add(new JLabel("Quand"));
		contentPaneNorthEst.add(new JLabel("Date :"));
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

		table = new JTable();
		tableModel = new DefaultTableModel(donnee, ENTETES) { // nouveau model
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(tableModel);
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
		contentPaneSouthEst.add(button);
		JButton valider = new JButton("Valider");
		contentPaneSouthEst.add(valider);
		contentPaneSouth.add(contentPaneSouthWest);
		contentPaneSouth.add(contentPaneSouthCenter);
		contentPaneSouth.add(contentPaneSouthEst);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(contentPaneNorth);
		frame.getContentPane().add(contentPaneCenter);
		frame.getContentPane().add(contentPaneSouth);

		frame.setVisible(true);
		
		//Actions Listeners
		CBVet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setUpTableData(
						CA.getTabAgenda(((User) CBVet.getSelectedItem()).getLogin(), sdf.format(model.getValue())),
						ENTETES);
			}
		});
		
		datePicker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setUpTableData(CA.getTabAgenda(((User) CBVet.getSelectedItem()).getLogin(),
						sdf.format(datePicker.getModel().getValue())), ENTETES);

			}
		});		
		//
		btnAddAnimal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!CBClient.getSelectedItem().toString().equals("")) {
					new WindowAddAnimal((Clients) CBClient.getSelectedItem());
				}
			}
		});
		CBClient.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CBAnimal.removeAllItems();
				Animaux[] tabAnimaux2 = null;
				tabAnimaux2 = controllerAnimal
						.getAnimalByIdClient(((Clients) CBClient.getSelectedItem()).getCodeClient());
				if (tabAnimaux2[0] == null) {
					tabAnimaux2[0] = new Animaux();
				}
				for (Animaux animaux : tabAnimaux2) {
					CBAnimal.addItem(animaux);
				}
				CBAnimal.repaint();
			}
		});
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedColumn() > -1 && table.getSelectedRow() > -1) {
					// Conversion date
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
					// Remove client
					new WindowRemove(new RendezVous(((User) CBVet.getSelectedItem()).getId(), cal.getTime(),
							null));
				} else
					err.setText("Aucune ligne sélectionnée");
					System.out.println("Aucune ligne sélectionnée");
			}
		});
		
		valider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Conversion date
				String[] str = sdf.format(datePicker.getModel().getValue()).split("/");
				cal.set(Integer.parseInt(str[2]), Integer.parseInt(str[1]) - 1, Integer.parseInt(str[0]),
						Integer.parseInt(heure.getModel().getValue().toString()),
						Integer.parseInt(minute.getModel().getValue().toString()), 00);
				//Add Client
				CA.addRDV(new RendezVous(((User) CBVet.getSelectedItem()).getId(), cal.getTime(),
						((Animaux) CBAnimal.getSelectedItem()).getCodeAnimal()));
			}
		});
		btnAddClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new WindowAddClient();
			}
		});
		
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
				new WindowAccueilSecretaire();
			}
		});

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

	@Override
	public void update(Observable o, Object arg) {
		if(arg instanceof RendezVous){
			setUpTableData(CA.getTabAgenda(((User) CBVet.getSelectedItem()).getLogin(),
					sdf.format(datePicker.getModel().getValue())), ENTETES);
		}else if(arg instanceof Clients){
			comboboxModelClient = new DefaultComboBoxModel<Clients>(
					controllerClients.listeClient());
			CBClient.setModel(comboboxModelClient);
		}else if(arg instanceof Animaux){
			CBAnimal.removeAllItems();
			Animaux[] tabAnimaux2 = null;
			tabAnimaux2 = controllerAnimal
					.getAnimalByIdClient(((Clients) CBClient.getSelectedItem()).getCodeClient());
			if (tabAnimaux2[0] == null) {
				tabAnimaux2[0] = new Animaux();
			}
			for (Animaux animaux : tabAnimaux2) {
				CBAnimal.addItem(animaux);
			}
			CBAnimal.repaint();
		}
	}

}
