package fr.eni.clinique.bll;

public interface LoginManager {
	public String verifPassword(String password, String nom) throws BLLException;
}
