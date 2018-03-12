package fr.eni.clinique.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.User;
import fr.eni.clinique.dal.AnimalDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;

class AnimalImpl implements Animal {
	private AnimalDAO con = new DAOFactory().getAnimalDAO();
	private List<Animaux> liste;

	@Override
	public void insert(Animaux animal) {
		if(animal.getSexe().equals("Mâle")){
			animal.setSexe("M");
		}else if(animal.getSexe().equals("Femelle")){
			animal.setSexe("F");
		}else if(animal.getSexe().equals("Hermaphrodite")){
			animal.setSexe("H");
		}
		try {
			con.insert(animal);
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Animaux animal) {
		if(animal.getSexe().equals("Mâle")){
			animal.setSexe("M");
		}else if(animal.getSexe().equals("Femelle")){
			animal.setSexe("F");
		}else if(animal.getSexe().equals("Hermaphrodite")){
			animal.setSexe("H");
		}
		try {
			con.update(animal);
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Animaux animal) {
		try {
			animal.setArchive(true);
			con.update(animal);
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Animaux> getAll() {
		List<Animaux> listereturn = new ArrayList<Animaux>();
		try {
			liste = con.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
		}
		for (Animaux animal : liste) {
			if(animal.getArchive() == false){
				listereturn.add(animal);
			}
		}
		return listereturn;
	}

	@Override
	public Animaux animalById(Integer id) {
		Animaux anim = null;
		try {
			anim = con.selectById(id);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return anim;
	}

	@Override
	public List<Animaux> animalByIdClient(Integer id) {
		List<Animaux> listereturn = new ArrayList<Animaux>();
		try {
			liste = con.selectByIdClient(id);
		} catch (DALException e) {
			e.printStackTrace();
		}
		for (Animaux animal : liste) {
			if(animal.getArchive() == false){
				listereturn.add(animal);
			}
		}
		return liste;
	}

	@Override
	public String[] getRace(String espece) {
		List<String> liste = new ArrayList<String>();
		try {
			liste = con.SelectRaceByEspece(espece);
		} catch (DALException e) {
			e.printStackTrace();
		}
		String tab[] = new String[liste.size()];
		for (int i = 0; i < liste.size(); i++) {
			tab[i] = liste.get(i);
		}
		return tab;
	}

	@Override
	public String[] getEspece() {
		List<String> liste = new ArrayList<String>();
		try {
			liste = con.SelectAllEspece();
		} catch (DALException e) {
			e.printStackTrace();
		}
		String tab[] = new String[liste.size()];
		for (int i = 0; i < liste.size(); i++) {
			tab[i] = liste.get(i);
		}
		return tab;
	}

}
