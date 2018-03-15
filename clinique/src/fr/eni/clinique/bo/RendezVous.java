package fr.eni.clinique.bo;

import java.util.Date;

public class RendezVous {

	private Integer CodeVeto;
	private Date Date;
	private Integer CodeAnimal;

	public RendezVous(Integer codeVeto, Date date, Integer codeAnimal) {
		super();
		CodeVeto = codeVeto;
		Date = date;
		CodeAnimal = codeAnimal;
	}

	public RendezVous() {
		super();
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public Integer getCodeVeto() {
		return CodeVeto;
	}

	public void setCodeVeto(Integer codeVeto) {
		CodeVeto = codeVeto;
	}

	public Integer getCodeAnimal() {
		return CodeAnimal;
	}

	public void setCodeAnimal(Integer codeAnimal) {
		CodeAnimal = codeAnimal;
	}

	@Override
	public String toString() {
		return "RendezVous [date=" + Date + ", CodeVeto=" + CodeVeto + ", CodeAnimal=" + CodeAnimal + "]";
	}

}
