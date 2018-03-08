package fr.eni.clinique.bll;

public interface LoginManager {
	public Boolean verifPassword(String nom, String mdp) throws BLLException;
}
