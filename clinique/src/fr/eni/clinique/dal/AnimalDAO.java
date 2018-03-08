package fr.eni.clinique.dal;

import java.util.List;
import fr.eni.clinique.bo.Animaux;

public interface AnimalDAO {
	//Sélectionner tous les animaux 
		public List<Animaux> selectAll() throws DALException;
		
		//Modifier les attributs d'un animal connu en BDD
		public void update(Animaux data) throws DALException;
		
		//Insérer un nouveau animal
		public void insert(Animaux data) throws DALException;
		
		//Supprimer un animal
		public void delete(int id) throws DALException;
		
		// Selectionne tous les animaux du client
		public List<Animaux> selectByIdClient(Integer id) throws DALException;
}
