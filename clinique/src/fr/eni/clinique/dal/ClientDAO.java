package fr.eni.clinique.dal;

import java.util.List;

import fr.eni.clinique.bo.Clients;

public interface ClientDAO {
	
	//Sélectionner tous les Clients 
	public List<Clients> selectAll() throws DALException;
	
	//Modifier les attributs d'un client connu en BDD
	public void update(Clients data) throws DALException;
	
	//Insérer un nouveau client
	public void insert(Clients data) throws DALException;
	
	//Supprimer un client
	public void delete(int id) throws DALException;
	
	//Selectioner un client par son nom
	public List<Clients> selectByNom(String nom) throws DALException;
	
	//Selectioner un client par son id
	public Clients selectById(Integer id) throws DALException;
}
