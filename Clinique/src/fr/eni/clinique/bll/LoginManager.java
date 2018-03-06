package fr.eni.clinique.bll;

public interface LoginManager {
	public String verifPassword(String nom, String password) throws BLLException;
}
