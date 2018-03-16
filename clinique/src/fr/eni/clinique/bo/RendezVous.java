package fr.eni.clinique.bo;

import java.sql.Date;

public class RendezVous {

	private Integer codeVeto;
	private Date date;
	private Integer codeAnimal;

	public RendezVous(Integer pcodeVeto, Date pdate, Integer pcodeAnimal) {
		super();
		codeVeto = pcodeVeto;
		date = pdate;
		codeAnimal = pcodeAnimal;
	}
	
	public RendezVous(Integer pcodeVeto, Date pdate) {
		super();
		codeVeto = pcodeVeto;
		date = pdate;
	}

	public RendezVous() {
		super();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		date = date;
	}

	public Integer getCodeVeto() {
		return codeVeto;
	}

	public void setCodeVeto(Integer codeVeto) {
		codeVeto = codeVeto;
	}

	public Integer getCodeAnimal() {
		return codeAnimal;
	}

	public void setCodeAnimal(Integer codeAnimal) {
		codeAnimal = codeAnimal;
	}

	@Override
	public String toString() {
		return "RendezVous [date=" + date + ", CodeVeto=" + codeVeto + ", CodeAnimal=" + codeAnimal + "]";
	}

}
