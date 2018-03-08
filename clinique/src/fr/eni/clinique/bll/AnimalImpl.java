package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.dal.AnimalDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;

class AnimalImpl implements Animal{
	private AnimalDAO con = new DAOFactory().getAnimalDAO();
	@Override
	public void insert(Animaux animal) {
		try {
			con.insert(animal);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Animaux animal) {
		try {
			con.update(animal);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Integer id) {
		try {
			con.delete(id);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Animaux> getAll() {
		List<Animaux> liste = null;
		try {
			liste = con.selectAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public Animaux animalById(Integer id) {
		Animaux anim = null;
		try {
			anim = con.selectById(id);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return anim;
	}

	@Override
	public List<Animaux> clientById(Integer id) {
		List<Animaux> liste = null;
		try {
			liste = con.selectByIdClient(id);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

}
