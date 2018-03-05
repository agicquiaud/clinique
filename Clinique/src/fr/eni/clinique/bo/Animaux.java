package fr.eni.clinique.bo;

public class Animaux {
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

	public Animaux(String nom, String sexe, String couleur, String race, String espece, Integer codeClient,
			String tatouage, String antecedents, Boolean archive) {
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

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getSexe() {
		return Sexe;
	}

	public void setSexe(String sexe) {
		Sexe = sexe;
	}

	public String getCouleur() {
		return Couleur;
	}

	public void setCouleur(String couleur) {
		Couleur = couleur;
	}

	public String getRace() {
		return Race;
	}

	public void setRace(String race) {
		Race = race;
	}

	public String getEspece() {
		return Espece;
	}

	public void setEspece(String espece) {
		Espece = espece;
	}

	public Integer getCodeClient() {
		return CodeClient;
	}

	public void setCodeClient(Integer codeClient) {
		CodeClient = codeClient;
	}

	public String getTatouage() {
		return Tatouage;
	}

	public void setTatouage(String tatouage) {
		Tatouage = tatouage;
	}

	public String getAntecedents() {
		return Antecedents;
	}

	public void setAntecedents(String antecedents) {
		Antecedents = antecedents;
	}

	public Boolean getArchive() {
		return Archive;
	}

	public void setArchive(Boolean archive) {
		Archive = archive;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Animaux [Nom=");
		builder.append(Nom);
		builder.append(", Sexe=");
		builder.append(Sexe);
		builder.append(", Couleur=");
		builder.append(Couleur);
		builder.append(", Race=");
		builder.append(Race);
		builder.append(", Espece=");
		builder.append(Espece);
		builder.append(", CodeClient=");
		builder.append(CodeClient);
		builder.append(", Tatouage=");
		builder.append(Tatouage);
		builder.append(", Antecedents=");
		builder.append(Antecedents);
		builder.append(", Archive=");
		builder.append(Archive);
		builder.append("]");
		return builder.toString();
	}
	
	
}
