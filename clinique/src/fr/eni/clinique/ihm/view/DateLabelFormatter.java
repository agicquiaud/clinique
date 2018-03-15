package fr.eni.clinique.ihm.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JFormattedTextField.AbstractFormatter;

class DateLabelFormatter extends AbstractFormatter {

	private String datePattern = "dd/MM/yyyy";
	private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern, Locale.FRENCH);

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

