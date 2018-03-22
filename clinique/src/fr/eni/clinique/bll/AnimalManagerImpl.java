package fr.eni.clinique.bll;

import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.dal.AnimalDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;

class AnimalManagerImpl implements AnimalManager {
	private AnimalDAO con = new DAOFactory().getAnimalDAO();
	private List<Animaux> liste;

	@Override
	public void insert(Animaux animal) throws BLLException {
		if (animal.getSexe().equals("Masculin")) {
			animal.setSexe("M");
		} else if (animal.getSexe().equals("Féminin")) {
			animal.setSexe("F");
		} else if (animal.getSexe().equals("Hermaphrodite")) {
			animal.setSexe("H");
		}
		try {
			con.insert(animal);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Animaux insert - animal=" + animal, e);
		}
	}

	@Override
	public void update(Animaux animal) throws BLLException {

		if (animal.getSexe().equals("Masculin")) {

			animal.setSexe("M");
		} else if (animal.getSexe().equals("Féminin")) {
			animal.setSexe("F");
		} else if (animal.getSexe().equals("Hermaphrodite")) {
			animal.setSexe("H");
		}
		try {
			con.update(animal);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Animaux update - animal=" + animal, e);
		}

	}

	@Override
	public void delete(Animaux animal) throws BLLException {
		try {
			animal.setArchive(true);
			con.update(animal);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Animaux insert - animal=" + animal, e);
		}

	}

	@Override
	public List<Animaux> getAll() throws BLLException {
		List<Animaux> listereturn = new ArrayList<Animaux>();
		try {
			liste = con.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Animaux getAll - animal=", e);
		}
		for (Animaux animal : liste) {
			if (animal.getArchive() == false) {
				listereturn.add(animal);
			}
		}
		return listereturn;
	}

	@Override
	public Animaux animalById(Integer id) throws BLLException {
		Animaux anim = null;
		try {
			anim = con.selectById(id); // Con est un animalDAO
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Animaux animalById - id=" + id, e);
		}
		return anim;
	}

	@Override
	public List<Animaux> animalByIdClient(Integer id) throws BLLException {
		List<Animaux> listereturn = new ArrayList<Animaux>();
		try {
			liste = con.selectByIdClient(id);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Animaux animalByIdClient - id=" + id, e);
		}
		for (Animaux animal : liste) {
			if (animal.getArchive() == false) {
				listereturn.add(animal);
			}
		}
		return listereturn;
	}

	@Override
	public String[] getRace(String espece) throws BLLException {
		List<String> liste = new ArrayList<String>();
		try {
			liste = con.SelectRaceByEspece(espece);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Animaux getRace - espece=" + espece, e);
		}
		String tab[] = new String[liste.size()];
		for (int i = 0; i < liste.size(); i++) {
			tab[i] = liste.get(i);
		}
		return tab;
	}

	@Override
	public String[] getEspece() throws BLLException {
		List<String> liste = new ArrayList<String>();
		try {
			liste = con.SelectAllEspece();
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Animaux getEspece - ", e);
		}
		String tab[] = new String[liste.size()];
		for (int i = 0; i < liste.size(); i++) {
			tab[i] = liste.get(i);
		}
		return tab;
	}

	@Override
	public void insertRace(String race, String espece) throws BLLException {
		try {
			con.insertRace(race, espece);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Animaux insertRace - race=" + race + " espece=" + espece, e);
		}
	}

}
