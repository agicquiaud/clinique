package fr.eni.clinique.bo;

public class Clients {
	private Integer CodeClient;
	private String Nom;
	private String Prenom;
	private String adresse1;
	private String adresse2;
	private String CodePostal;
	private String Ville;
	private String NumTel;
	private String Assurance;
	private String Email;
	private String Remarque;
	private Boolean Archive;
	
	public Clients(Integer codeClient, String nom, String prenom, String adresse1, String adresse2, String codePostal,
			String ville, String numTel, String assurance, String email, String remarque, Boolean archive) {
		super();
		CodeClient = codeClient;
		Nom = nom;
		Prenom = prenom;
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		CodePostal = codePostal;
		Ville = ville;
		NumTel = numTel;
		Assurance = assurance;
		Email = email;
		Remarque = remarque;
		Archive = archive;
	}
	
	public Clients(Integer codeClient, String nom, String prenom, String adresse1, String codePostal,
			String ville, String numTel, String email, Boolean archive) {
		super();
		CodeClient = codeClient;
		Nom = nom;
		Prenom = prenom;
		this.adresse1 = adresse1;
		CodePostal = codePostal;
		Ville = ville;
		NumTel = numTel;
		Email = email;
		Archive = archive;
	}
	
	public Clients(String nom, String prenom, String adresse1, String codePostal, String ville, String numTel,
			String email, Boolean archive) {
		super();
		Nom = nom;
		Prenom = prenom;
		this.adresse1 = adresse1;
		CodePostal = codePostal;
		Ville = ville;
		NumTel = numTel;
		Email = email;
		Archive = archive;
	}

	public Clients(Integer codeClient, String nom, String prenom, String adresse1, String adresse2, String codePostal,
			String ville, String numTel, String email, Boolean archive) {
		super();
		CodeClient = codeClient;
		Nom = nom;
		Prenom = prenom;
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		CodePostal = codePostal;
		Ville = ville;
		NumTel = numTel;
		Email = email;
		Archive = archive;
	}

	public Clients(String nom, String prenom, String adresse1, String adresse2, String codePostal, String ville,
			String numTel, String email, Boolean archive) {
		super();
		Nom = nom;
		Prenom = prenom;
		this.adresse1 = adresse1;
		this.adresse2 = adresse2;
		CodePostal = codePostal;
		Ville = ville;
		NumTel = numTel;
		Email = email;
		Archive = archive;
	}

	public Integer getCodeClient() {
		return CodeClient;
	}

	public void setCodeClient(Integer codeClient) {
		CodeClient = codeClient;
	}

	public Clients(){}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getAdresse1() {
		return adresse1;
	}

	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}

	public String getAdresse2() {
		return adresse2;
	}

	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}

	public String getCodePostal() {
		return CodePostal;
	}

	public void setCodePostal(String codePostal) {
		CodePostal = codePostal;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getNumTel() {
		return NumTel;
	}

	public void setNumTel(String numTel) {
		NumTel = numTel;
	}

	public String getAssurance() {
		return Assurance;
	}

	public void setAssurance(String assurance) {
		Assurance = assurance;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getRemarque() {
		return Remarque;
	}

	public void setRemarque(String remarque) {
		Remarque = remarque;
	}

	public Boolean getArchive() {
		return Archive;
	}

	public void setArchive(Boolean archive) {
		Archive = archive;
	}

	@Override
	public String toString() {
		return "Clients [CodeClient=" + CodeClient + ", Nom=" + Nom + ", Prenom=" + Prenom + ", adresse1=" + adresse1
				+ ", adresse2=" + adresse2 + ", CodePostal=" + CodePostal + ", Ville=" + Ville + ", NumTel=" + NumTel
				+ ", Assurance=" + Assurance + ", Email=" + Email + ", Remarque=" + Remarque + ", Archive=" + Archive
				+ "]";
	}


	
	
}
