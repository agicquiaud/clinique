package fr.eni.clinique.bo;

public class Animaux {
	private Integer CodeAnimal;
	private String Nom;
	private String Sexe;
	private String Couleur;
	private String Race;
	private String Espece;
	private Integer CodeClient;
	private String Tatouage;
	private String Antecedents;
	private Boolean Archive;
	
	public Animaux(){}

	public Animaux(Integer codeAnimal, String nom, String sexe, String couleur, String race, String espece,
			Integer codeClient, String tatouage, String antecedents, Boolean archive) {
		super();
		CodeAnimal = codeAnimal;
		Nom = nom;
		Sexe = sexe;
		Couleur = couleur;
		Race = race;
		Espece = espece;
		CodeClient = codeClient;
		Tatouage = tatouage;
		Antecedents = antecedents;
		Archive = archive;
	}

	public Animaux(String nom, String sexe, String couleur, String race, String espece,
			Integer codeClient, String tatouage, String antecedents, Boolean archive) {
		super();
		Nom = nom;
		Sexe = sexe;
		Couleur = couleur;
		Race = race;
		Espece = espece;
		CodeClient = codeClient;
		Tatouage = tatouage;
		Antecedents = antecedents;
		Archive = archive;
	}
	
	/**
	 * 
	 * @return Integer
	 */
	public Integer getCodeAnimal() {
		return CodeAnimal;
	}

	/**
	 * 
	 * @param Integer codeAnimal
	 */
	public void setCodeAnimal(Integer codeAnimal) {
		CodeAnimal = codeAnimal;
	}

	/**
	 * 
	 * @return String
	 */
	public String getNom() {
		return Nom;
	}

	/**
	 * 
	 * @param String nom
	 */
	public void setNom(String nom) {
		Nom = nom;
	}

	/**
	 * 
	 * @return String
	 */
	public String getSexe() {
		return Sexe;
	}

	/**
	 * 
	 * @param String sexe
	 */
	public void setSexe(String sexe) {
		Sexe = sexe;
	}

	/**
	 * 
	 * @return String 
	 */
	public String getCouleur() {
		return Couleur;
	}

	/**
	 * 
	 * @param String couleur
	 */
	public void setCouleur(String couleur) {
		Couleur = couleur;
	}

	/**
	 * 
	 * @return String 
	 */
	public String getRace() {
		return Race;
	}

	/**
	 * 
	 * @param String race
	 */
	public void setRace(String race) {
		Race = race;
	}

	/**
	 * 
	 * @return String
	 */
	public String getEspece() {
		return Espece;
	}

	/**
	 * 
	 * @param String espece
	 */
	public void setEspece(String espece) {
		Espece = espece;
	}

	/**
	 * 
	 * @return Integer
	 */
	public Integer getCodeClient() {
		return CodeClient;
	}

	/**
	 * 
	 * @param Integer codeClient
	 */
	public void setCodeClient(Integer codeClient) {
		CodeClient = codeClient;
	}

	/**
	 * 
	 * @return String
	 */
	public String getTatouage() {
		return Tatouage;
	}

	/**
	 * 
	 * @param String tatouage
	 */
	public void setTatouage(String tatouage) {
		Tatouage = tatouage;
	}

	/**
	 * 
	 * @return String
	 */
	public String getAntecedents() {
		return Antecedents;
	}

	/**
	 * 
	 * @param String antecedents
	 */
	public void setAntecedents(String antecedents) {
		Antecedents = antecedents;
	}

	/**
	 * 
	 * @return Boolean
	 */
	public Boolean getArchive() {
		return Archive;
	}

	/**
	 * 
	 * @param Boolean archive
	 */
	public void setArchive(Boolean archive) {
		Archive = archive;
	}

	@Override
	public String toString() {
		return "Animaux [CodeAnimal=" + CodeAnimal + ", Nom=" + Nom + ", Sexe=" + Sexe + ", Couleur=" + Couleur
				+ ", Race=" + Race + ", Espece=" + Espece + ", CodeClient=" + CodeClient + ", Tatouage=" + Tatouage
				+ ", Antecedents=" + Antecedents + ", Archive=" + Archive + "]";
	}


	
	
}
