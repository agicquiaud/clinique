package fr.eni.clinique.ihm.login;

import java.awt.Component;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import fr.eni.clinique.bo.Clients;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class WindowPriseDeRendezVous extends JFrame{

	
	private JPanel contentPaneNorth = new JPanel();
	private JPanel contentPaneNorthWest = new JPanel();
	private JPanel contentPaneNorthWestClient = new JPanel();
	private JPanel contentPaneNorthWestAnimal = new JPanel();
	private JPanel contentPaneNorthCenter = new JPanel();
	private JPanel contentPaneNorthEst = new JPanel();
	private JPanel contentPaneNorthEstSouth = new JPanel();
	private JPanel contentPaneCenter = new JPanel();
	private JPanel contentPaneSouth= new JPanel();
	private JPanel contentPaneSouthWest = new JPanel();
	private JPanel contentPaneSouthCenter = new JPanel();
	private JPanel contentPaneSouthEst = new JPanel();
	private Properties propierties = new Properties();
	private UtilDateModel model = new UtilDateModel();
	private JDatePanelImpl datePanel = new JDatePanelImpl(model, propierties);
	private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	
	private JComboBox<String> CBClient = new JComboBox<String>();
	private JComboBox<String> CBAnimal = new JComboBox<String>();
	private JComboBox<String> CBVet = new JComboBox<String>();
	
 
	/**
	 * Create the frame.
	 */
	public WindowPriseDeRendezVous() {
		this.setTitle("Prise de rendez-vous");

	    this.setSize(1000, 800);

	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    this.setLocationRelativeTo(null);
	    
	    propierties.put("text.today", "Today");
	    propierties.put("text.month", "Month");
	    propierties.put("text.year", "Year");
				
				contentPaneNorth.setLayout(new BoxLayout(contentPaneNorth, BoxLayout.LINE_AXIS));
				contentPaneNorthWest.setBorder(new EmptyBorder(0, 2, 2, 3));
				contentPaneNorthWest.setLayout(new GridLayout(10, 0));
				contentPaneNorthWest.add(new JLabel("Pour"));
				contentPaneNorthWest.add(new JLabel("Client :"));
				contentPaneNorthWestClient.setLayout(new GridLayout(1, 2));
				CBClient.setBorder(new EmptyBorder(0, 2, 0, 2));
				contentPaneNorthWestClient.add(CBClient);
				JButton button_1 = new JButton();
				button_1.setBorder(new EmptyBorder(0, 2, 0, 2));
				contentPaneNorthWestClient.add(button_1);
				contentPaneNorthWest.add(contentPaneNorthWestClient);
				contentPaneNorthWest.add(new JLabel("Animal :"));
				contentPaneNorthWestAnimal.setLayout(new GridLayout(1, 2));
				contentPaneNorthWestAnimal.add(CBAnimal);
				JButton button_2 = new JButton();
				button_2.setBorder(new EmptyBorder(0, 2, 0, 2));
				contentPaneNorthWestAnimal.add(button_2);
				contentPaneNorthWest.add(contentPaneNorthWestAnimal);
				contentPaneNorthCenter.setBorder(new EmptyBorder(0, 3, 0, 3));
				contentPaneNorthCenter.setLayout(new GridLayout(10, 1));
				contentPaneNorthCenter.add(new JLabel("Par"));
				contentPaneNorthCenter.add(new JLabel("Véterinaire :"));
				contentPaneNorthCenter.add(CBVet);
				contentPaneNorthEst.setBorder(new EmptyBorder(0, 3, 0, 2));
				contentPaneNorthEst.setLayout(new GridLayout(10, 1));
				contentPaneNorthEst.add(new JLabel("Quand"));
				contentPaneNorthEst.add(new JLabel("Date :"));
				contentPaneNorthEst.add(datePicker);
				contentPaneNorthEst.add(new JLabel());
				contentPaneNorthEstSouth.setLayout(new GridLayout(1,4));
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
				
				String[] entete = {"Heure", "Nom du client", "Animal" ,"Race"};
				Object[][] donnee = {{"bonjour", "en revoir", "3", "4"}};
				JTable table = new JTable(donnee, entete);
				contentPaneCenter.add(table);
				
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

class DateLabelFormatter extends AbstractFormatter {

	private String datePattern = "yyyy-MM-dd";
	private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern, Locale.ENGLISH);

	public Object stringToValue(String text) throws ParseException {

		return dateFormatter.parseObject(text);

	}

	public String valueToString(Object value) throws ParseException {

		if (value != null) {

			Calendar cal = (Calendar) value;
			return dateFormatter.format(cal.getTime());

		}

		return "";

	}

}
