package fr.eni.clinique.ihm.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	private static final String PATTERN_MAIL = "^[A-Za-z0-9+_.-]+@(.+)$";
	private static final String PATTERN_CP = "[0-9]{5}";
	private static final String PATTERN_TATOUAGE = "[2]{0,1}[A-Z]{3}[0-9]{3}";
	private static final String PATTERN_NOMPRENOM_ANIMAL = "[a-zA-Z0-9]{1,30}";

	
	public Validator(){
		
	}
	
	public boolean patternMail(String mail) {
		boolean result = Pattern.matches( PATTERN_MAIL, mail);
		return result;
	}
	
	public boolean patternCP(String codePostal) {
		boolean result = Pattern.matches( PATTERN_CP, codePostal);
		return result;
	}
	
	public boolean patternTatouage(String tatouage) {
		boolean result = Pattern.matches( PATTERN_TATOUAGE, tatouage);
		return result;
	}
	
	public boolean patternNomPrenomAnimal(String nomPrenomAnimal) {
		boolean result = Pattern.matches( PATTERN_NOMPRENOM_ANIMAL, nomPrenomAnimal);
		return result;
	}
	
	

}

