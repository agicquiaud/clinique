package fr.eni.clinique.ihm.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	private static final String PATTERN_MAIL = "^[A-Za-z0-9+_.-]+@(.+)$";
	private static final String PATTERN_CP = "[0-9]";
	private static final String PATTERN_TATOUAGE = "[0-9A-Z]";
	
	public static boolean patternMail(String mail) {
		boolean result = Pattern.matches( PATTERN_MAIL, mail);
		return result;
	}
	
	public static boolean patternCP(String codePostal) {
		boolean result = Pattern.matches( PATTERN_CP, codePostal);
		return result;
	}
	
	public static boolean patternTatouage(String codePostal) {
		boolean result = Pattern.matches( PATTERN_TATOUAGE, codePostal);
		return result;
	}
	
	

}

