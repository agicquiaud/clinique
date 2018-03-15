package fr.eni.clinique.ihm.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.ihm.controller.ControllerAnimaux;
import fr.eni.clinique.ihm.controller.ControllerClients;

public class WindowPriseDeRendezVous extends JFrame {

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
	private JDatePanelImpl datePanel = new JDatePanelImpl(model, properties);
	private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	private ImageIcon icon = new ImageIcon("//3-UC31-14/Partage_Stagiaires/RL_AG_LV/plus.png");
	private JComboBox<String> CBAnimal = new JComboBox<String>();
	private JComboBox<String> CBVet = new JComboBox<String>();
	private ControllerClients controllerClients = new ControllerClients();
	private ControllerAnimaux controlleranimal = new ControllerAnimaux();
	private List liste = new List();

	/**
	 * Create the frame.
	 */
	public WindowPriseDeRendezVous() {
		this.setTitle("Prise de rendez-vous");

		this.setSize(1000, 800);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLocationRelativeTo(null);

		properties.put("text.today", "Today");
		properties.put("text.month", "Month");
		properties.put("text.year", "Year");

		contentPaneNorth.setLayout(new BoxLayout(contentPaneNorth, BoxLayout.LINE_AXIS));
		contentPaneNorthWest.setBorder(new EmptyBorder(0, 2, 2, 3));
		contentPaneNorthWest.setLayout(new GridLayout(10, 0));
		contentPaneNorthWest.add(new JLabel("Pour"));
		contentPaneNorthWest.add(new JLabel("Client :"));
		contentPaneNorthWestClient.setLayout(new GridLayout(1, 2));
		Integer i = 1;
		Clients[] client  = new Clients[controllerClients.listeClient().length];
		client = controllerClients.listeClient();
		String[] tabNomClient = new String[controllerClients.listeClient().length +1];
		tabNomClient[0] = "";
		for (Clients cli : client) {
			tabNomClient[i] = cli.getNom() + " " + cli.getPrenom();
			i++;
		}
		
		//tabClient = controllerClients.getNomPrenomList();

		JComboBox<String> CBClient = new JComboBox<String>(tabNomClient);
		CBClient.setBorder(new EmptyBorder(0, 2, 0, 2));
		contentPaneNorthWestClient.add(CBClient);
		JLabel label1 = new JLabel(icon);
		label1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new WindowAddClient();
			}
		});
		label1.setBorder(new EmptyBorder(0, 2, 0, 2));
		label1.setSize(26, 26);
		contentPaneNorthWestClient.add(label1);
		contentPaneNorthWestClient.repaint();
		contentPaneNorthWest.add(contentPaneNorthWestClient);
		contentPaneNorthWest.add(new JLabel("Animal :"));
		contentPaneNorthWestAnimal.setLayout(new GridLayout(1, 2));
		
		//CBAnimal = controlleranimal.getListByClient("gicquiaud");
		contentPaneNorthWestAnimal.add(CBAnimal);
		JLabel label2 = new JLabel(icon);
		label2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (CBClient.getItemCount() == 1){
					new WindowAddAnimal();
				}else {
					new JDialog();
				}
			}
		});
		label2.setBorder(new EmptyBorder(0, 2, 0, 2));
		label2.setSize(26, 26);
		contentPaneNorthWestAnimal.add(label2);
		contentPaneNorthWest.add(contentPaneNorthWestAnimal);
		contentPaneNorthCenter.setBorder(new EmptyBorder(0, 3, 0, 3));
		contentPaneNorthCenter.setLayout(new GridLayout(10, 1));
		contentPaneNorthCenter.add(new JLabel("Par"));
		contentPaneNorthCenter.add(new JLabel("V�terinaire :"));
		contentPaneNorthCenter.add(CBVet);
		contentPaneNorthEst.setBorder(new EmptyBorder(0, 3, 0, 2));
		contentPaneNorthEst.setLayout(new GridLayout(10, 1));
		contentPaneNorthEst.add(new JLabel("Quand"));
		contentPaneNorthEst.add(new JLabel("Date :"));
		contentPaneNorthEst.add(datePicker);
		contentPaneNorthEst.add(new JLabel());
		contentPaneNorthEstSouth.setLayout(new GridLayout(1, 4));
		JLabel label = new JLabel("Heure :");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setHorizontalTextPosition(SwingConstants.RIGHT);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPaneNorthEstSouth.add(label);
		JSpinner heure = new JSpinner();
		heure.setModel(new SpinnerNumberModel(9, 9, 19, 1));
		contentPaneNorthEstSouth.add(heure);
		JLabel labelMin = new JLabel("Minute :");
		labelMin.setHorizontalAlignment(SwingConstants.CENTER);
		labelMin.setHorizontalTextPosition(SwingConstants.RIGHT);
		labelMin.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPaneNorthEstSouth.add(labelMin);
		JSpinner minute = new JSpinner();
		minute.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		contentPaneNorthEstSouth.add(minute);
		contentPaneNorthEst.add(contentPaneNorthEstSouth);

		contentPaneNorth.add(contentPaneNorthWest);
		contentPaneNorth.add(contentPaneNorthCenter);
		contentPaneNorth.add(contentPaneNorthEst);

		String[] entete = { "Heure", "Nom du client", "Animal", "Race" };
		Object[][] donnee = { { "10:45", "Bosapin", "Rex", "Labrador" } };

		JTable table = new JTable(donnee, entete);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setColumnHeaderView(table.getTableHeader());
		contentPaneCenter.setLayout(new BorderLayout());
		table.setAutoCreateRowSorter(true);
		contentPaneCenter.add(scrollPane);

		contentPaneSouth.setLayout(new BoxLayout(contentPaneSouth, BoxLayout.LINE_AXIS));

		contentPaneSouthWest.setLayout(new BoxLayout(contentPaneSouthWest, BoxLayout.PAGE_AXIS));
		contentPaneSouthWest.add(new JLabel());

		contentPaneSouthCenter.setLayout(new BoxLayout(contentPaneSouthCenter, BoxLayout.PAGE_AXIS));
		contentPaneSouthCenter.add(new JLabel());

		contentPaneSouthEst.setLayout(new BoxLayout(contentPaneSouthEst, BoxLayout.PAGE_AXIS));
		JButton button = new JButton("Supprimer");
		contentPaneSouthEst.add(button);
		contentPaneSouthEst.add(new JButton("Valider"));

		contentPaneSouth.add(contentPaneSouthWest);
		contentPaneSouth.add(contentPaneSouthCenter);
		contentPaneSouth.add(contentPaneSouthEst);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		this.getContentPane().add(contentPaneNorth);
		this.getContentPane().add(contentPaneCenter);
		this.getContentPane().add(contentPaneSouth);

		this.setVisible(true);

	}

}