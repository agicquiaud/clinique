package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.dal.AnimalDAO;
import fr.eni.clinique.dal.DALException;

public class AnimalDAOJdbcImpl implements AnimalDAO {

	private static final String sqlSelectAll = "SELECT CodeAnimal, NomAnimal, Sexe, "
			+ "Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux";
	private static final String sqlUpdate = "UPDATE Animaux SET NomAnimal=?, Sexe=?, "
			+ "Couleur=?, Tatouage=?, Antecedents=?, Archive=? WHERE CodeAnimal=?";
	private static final String sqlInsert = "INSERT INTO Animaux (NomAnimal, Sexe, "
			+ "Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String sqlDelete = "DELETE FROM Animaux WHERE CodeAnimal=?";
	private static final String sqlSelectByIdClient = "SELECT CodeAnimal, NomAnimal, Sexe, "
			+ "Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux WHERE CodeClient=?";
	private static final String sqlSelectById = "SELECT CodeAnimal, NomAnimal, Sexe, "
			+ "Couleur, Race, Espece, CodeClient, Tatouage, Antecedents, Archive FROM Animaux WHERE CodeAnimal=?";
	private static final String sqlSelectAllEspece = "SELECT DISTINCT Espece FROM Races";
	private static final String sqlSelectRaceByEspece = "SELECT Race FROM Races WHERE Espece=?";

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
				animal = new Animaux(rs.getInt("CodeAnimal"), rs.getString("NomAnimal"), rs.getString("Sexe"),
						rs.getString("Couleur"), rs.getString("Race"), rs.getString("Espece"), rs.getInt("CodeClient"),
						rs.getString("Tatouage"), rs.getString("Antecedents"), rs.getBoolean("Archive"));

				liste.add(animal);
			}
		} catch (SQLException e) {
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
			rqt.setString(2, data.getSexe());
			rqt.setString(3, data.getCouleur());
			rqt.setString(4, data.getTatouage());
			rqt.setString(5, data.getAntecedents());
			rqt.setBoolean(6, data.getArchive());
			rqt.setInt(7, data.getCodeAnimal());

			rqt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Update animal failed - " + data, e);
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
			rqt.setString(1, data.getNom());
			rqt.setString(2, data.getSexe());
			rqt.setString(3, data.getCouleur());
			rqt.setString(4, data.getRace());
			rqt.setString(5, data.getEspece());
			rqt.setInt(6, data.getCodeClient());
			rqt.setString(7, data.getTatouage());
			rqt.setString(8, data.getAntecedents());
			rqt.setBoolean(9, data.getArchive());

			int nbRows = rqt.executeUpdate();
			if (nbRows == 1) {
				ResultSet rs = rqt.getGeneratedKeys();
				if (rs.next()) {
					data.setCodeAnimal(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new DALException("Insert animal failed - " + data, e);
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
			throw new DALException("Delete animal failed - id=" + id, e);
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

	@Override
	public List<Animaux> selectByIdClient(Integer id) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<Animaux> liste = new ArrayList<Animaux>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectByIdClient);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			Animaux animal = null;

			while (rs.next()) {
				animal = new Animaux(rs.getInt("CodeAnimal"), rs.getString("NomAnimal"), rs.getString("Sexe"),
						rs.getString("Couleur"), rs.getString("Race"), rs.getString("Espece"), rs.getInt("CodeClient"),
						rs.getString("Tatouage"), rs.getString("Antecedents"), rs.getBoolean("Archive"));

				liste.add(animal);
			}
		} catch (

		SQLException e) {
			throw new DALException("selectByIdClient failed - id = " + id, e);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return liste;
	}

	public Animaux selectById(Integer id) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Animaux animal = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectById);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			if (rs.next()) {
				animal = new Animaux(rs.getInt("CodeAnimal"), rs.getString("NomAnimal"), rs.getString("Sexe"),
						rs.getString("Couleur"), rs.getString("Race"), rs.getString("Espece"), rs.getInt("CodeClient"),
						rs.getString("Tatouage"), rs.getString("Antecedents"), rs.getBoolean("Archive"));
			}

		} catch (SQLException e) {
			throw new DALException("selectById failed - Id = " + id, e);
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

	public List<String> SelectAllEspece() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<String> liste = new ArrayList<String>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(sqlSelectAllEspece);
			String str = null;

			while (rs.next()) {
				str = rs.getString("Espece");
				liste.add(str);
			}
		} catch (SQLException e) {
			throw new DALException("selectAllEspece failed - ", e);
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

	public List<String> SelectRaceByEspece(String espece) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<String> liste = new ArrayList<String>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectRaceByEspece);
			rqt.setString(1, espece);
			rs = rqt.executeQuery();
			String str = null;

			while (rs.next()) {
				str = rs.getString("Race");
				liste.add(str);
			}
		} catch (

		SQLException e) {
			throw new DALException("selectRaceByEspece failed - espece = " + espece, e);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return liste;
	}

}
