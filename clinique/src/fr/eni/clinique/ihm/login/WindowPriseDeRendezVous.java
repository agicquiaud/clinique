package fr.eni.clinique.ihm.login;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import fr.eni.clinique.bo.Clients;

public class WindowPriseDeRendezVous extends JFrame{

	
	private JPanel contentPaneNorth = new JPanel();
	private JPanel contentPaneNorthWest = new JPanel();
	private JPanel contentPaneNorthCenter = new JPanel();
	private JPanel contentPaneNorthEst = new JPanel();
	private JPanel contentPaneCenter = new JPanel();
	private JPanel contentPaneSouth= new JPanel();
	private JPanel contentPaneSouthWest = new JPanel();
	private JPanel contentPaneSouthCenter = new JPanel();
	private JPanel contentPaneSouthEst = new JPanel();
	private Properties propierties = new Properties();
	private UtilDateModel model = new UtilDateModel();
	private JDatePanelImpl datePanel = new JDatePanelImpl(model, propierties);
	private JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	
 
	/**
	 * Create the frame.
	 */
	public WindowPriseDeRendezVous() {
		this.setTitle("Prise de rendez-vous");

	    this.setSize(730, 470);

	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    this.setLocationRelativeTo(null);
	    
	    propierties.put("text.today", "Today");
	    propierties.put("text.month", "Month");
	    propierties.put("text.year", "Year");
				
				contentPaneNorth.setLayout(new BoxLayout(contentPaneNorth, BoxLayout.LINE_AXIS));
				
				contentPaneNorthWest.setLayout(new BoxLayout(contentPaneNorthWest, BoxLayout.PAGE_AXIS));
				contentPaneNorthWest.add(new JLabel("Pour"));
				contentPaneNorthWest.add(new JLabel("Client"));
				contentPaneNorthWest.add(new JComboBox<String>());
				contentPaneNorthWest.add(new JLabel("Animal"));
				contentPaneNorthWest.add(new JComboBox<String>());
				
				contentPaneNorthCenter.setLayout(new BoxLayout(contentPaneNorthCenter, BoxLayout.PAGE_AXIS));
				contentPaneNorthCenter.add(new JLabel("Par"));
				contentPaneNorthCenter.add(new JComboBox<String>());
				
				contentPaneNorthEst.setLayout(new BoxLayout(contentPaneNorthEst, BoxLayout.PAGE_AXIS));
				contentPaneNorthEst.add(new JLabel("Quand"));
				contentPaneNorthEst.add(new JLabel("Date"));
				contentPaneNorthEst.add(datePicker);
				contentPaneNorthEst.add(new JLabel("Heure"));
				contentPaneNorthEst.add(new JButton());
				
				contentPaneNorth.add(contentPaneNorthWest);
				contentPaneNorth.add(contentPaneNorthCenter);
				contentPaneNorth.add(contentPaneNorthEst);
				
				
				contentPaneCenter.add(new JTable());
				
				contentPaneSouth.setLayout(new BoxLayout(contentPaneSouth, BoxLayout.LINE_AXIS));
				
				contentPaneSouthWest.setLayout(new BoxLayout(contentPaneSouthWest, BoxLayout.PAGE_AXIS));
				
				contentPaneSouthCenter.setLayout(new BoxLayout(contentPaneSouthCenter, BoxLayout.PAGE_AXIS));
				
				contentPaneSouthEst.setLayout(new BoxLayout(contentPaneSouthEst, BoxLayout.PAGE_AXIS));
				contentPaneSouthEst.add(new JButton("Supprimer"));
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
