package fr.eni.clinique.bo;

public class Clients {
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
	private String Archive;
	
	public Clients(){}

	public Clients(String nom, String prenom, String adresse1, String adresse2, String codePostal, String ville,
			String numTel, String assurance, String email, String remarque, String archive) {
		super();
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

	public String getArchive() {
		return Archive;
	}

	public void setArchive(String archive) {
		Archive = archive;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Clients [Nom=");
		builder.append(Nom);
		builder.append(", Prenom=");
		builder.append(Prenom);
		builder.append(", adresse1=");
		builder.append(adresse1);
		builder.append(", adresse2=");
		builder.append(adresse2);
		builder.append(", CodePostal=");
		builder.append(CodePostal);
		builder.append(", Ville=");
		builder.append(Ville);
		builder.append(", NumTel=");
		builder.append(NumTel);
		builder.append(", Assurance=");
		builder.append(Assurance);
		builder.append(", Email=");
		builder.append(Email);
		builder.append(", Remarque=");
		builder.append(Remarque);
		builder.append(", Archive=");
		builder.append(Archive);
		builder.append("]");
		return builder.toString();
	};
	
	
}
