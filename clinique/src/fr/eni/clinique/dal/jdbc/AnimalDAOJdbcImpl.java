package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.DALException;

public class AnimalDAOJdbcImpl {
	
	private static final String sqlSelectAll = "SELECT CodeAnimal, NomAnimal, Sexe, "
			+ "Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux";
	private static final String sqlUpdate = "UPDATE Animaux SET CodeAnimal=?, NomAnimal=?, Sexe=?, "
			+ "Couleur=?, Race=?, Espece=?, CodeClient=?, Tatouage=?, Antecedents=?, Archive=? WHERE CodeAnimal=?";
	private static final String sqlInsert = "INSERT INTO Clients (CodeAnimal, NomAnimal, Sexe, "
			+ "Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String sqlDelete = "DELETE FROM Animaux WHERE CodeAnimal=?";
	
	public List<Animaux> selectAll() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<Animaux> liste = new ArrayList<Animaux>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(sqlSelectAll);
			Animaux animal = null;

			while (rs.next()) {
				animal = new Clients(rs.getInt("CodePers"), rs.getString("NomClient"), rs.getString("PrenomClient"),
						rs.getString("Adresse1"), rs.getString("CodePostal"), rs.getString("Ville"),
						rs.getString("NumTel"), rs.getString("Email"), rs.getBoolean("Archive"));

				liste.add(animal);
			}
		} catch (

		SQLException e) {
			throw new DALException("selectAll failed - ", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return liste;

	}

	public void update(Animaux data) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlUpdate);
			rqt.setString(1, data.getNom());
			rqt.setString(2, data.getPrenom());
			rqt.setString(3, data.getAdresse1());
			rqt.setString(4, data.getCodePostal());
			rqt.setString(5, data.getVille());
			rqt.setString(6, data.getNumTel());
			rqt.setString(7, data.getEmail());
			rqt.setBoolean(8, data.getArchive());
			rqt.setInt(9, data.getCodeClient());

			rqt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Update client failed - " + data, e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insert(Animaux data) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(2, data.getNom());
			rqt.setString(3, data.getPrenom());
			rqt.setString(4, data.getAdresse1());
			rqt.setString(5, data.getCodePostal());
			rqt.setString(6, data.getVille());
			rqt.setString(7, data.getNumTel());
			rqt.setString(8, data.getEmail());
			rqt.setBoolean(9, data.getArchive());

			int nbRows = rqt.executeUpdate();
			if (nbRows == 1) {
				ResultSet rs = rqt.getGeneratedKeys();
				if (rs.next()) {
					data.setCodeAnimal(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new DALException("Insert client failed - " + data, e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed - ", e);
			}

		}
	}

	public void delete(int id) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			// l'intégrité référentielle s'occupe d'invalider la suppression
			// si l'article est référencé dans une ligne de commande
			rqt = cnx.prepareStatement(sqlDelete);
			rqt.setInt(1, id);
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Delete client failed - id=" + id, e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				throw new DALException("close failed ", e);
			}

		}
	}

	public Animaux selectByNom(String nom) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Animaux animal = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectByNom);
			rqt.setString(1, nom);
			rs = rqt.executeQuery();
			if (rs.next()) {
				animal = new Clients(rs.getInt("CodePers"), rs.getString("NomClient"), rs.getString("PrenomClient"),
						rs.getString("Adresse1"), rs.getString("CodePostal"), rs.getString("Ville"),
						rs.getString("NumTel"), rs.getString("Email"), rs.getBoolean("Archive"));
			}

		} catch (SQLException e) {
			throw new DALException("selectByNom failed - Nom = " + nom, e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return animal;
	}
}
