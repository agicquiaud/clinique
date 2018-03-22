package fr.eni.clinique.bll;

public interface LoginManager {
	/**
	 * V�rifie le mot de passe d'un personnel dans la base de donn�es par son nom et mot de passe
	 * @param String nom
	 * @param String mdp
	 * @return Boolean 
	 * @throws BLLException
	 */
	public Boolean verifPassword(String nom, String mdp) throws BLLException;
}
