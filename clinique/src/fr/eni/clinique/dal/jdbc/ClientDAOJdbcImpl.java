package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.User;
import fr.eni.clinique.dal.DALException;

public class ClientDAOJdbcImpl {

	private static final String sqlSelectAll = "SELECT CodeClient, NomClient, PrenomClient, "
			+ "Adresse1, Adresse2, CodePostal, Ville, NumTel, Assurance, Email, Remarque, Archive FROM Clients";
	private static final String sqlUpdate = "UPDATE Clients SET NomClient=?, PrenomClient=?, Role=?, Archive=? WHERE CodePers=?";
	private static final String sqlInsert = "INSERT INTO Personnels (Nom, MotPasse, Role, Archive) VALUES (?, ?, ?, ?)";
	private static final String sqlDelete = "DELETE FROM Personnels WHERE CodePers=?";
	private static final String sqlSelectByNom = "SELECT CodeClient, NomClient, PrenomClient, "
			+ "Adresse1, Adresse2, CodePostal, Ville, NumTel, Assurance, Email, Remarque, Archive FROM Clients WHERE NomClient=?";

	public List<User> selectAll() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<User> liste = new ArrayList<User>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(sqlSelectAll);
			User user = null;

			while (rs.next()) {
				user = new User(rs.getInt("CodePers"), rs.getString("Nom"), rs.getString("MotPasse"),
						rs.getString("Role"), rs.getBoolean("Archive"));

				liste.add(user);
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

	public void update(User data) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlUpdate);
			rqt.setString(1, data.getLogin());
			rqt.setString(2, data.getPassword());
			rqt.setString(3, data.getType());
			rqt.setBoolean(4, data.getHide());
			rqt.setInt(5, data.getId());

			rqt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Update article failed - " + data, e);
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

	public void insert(User data) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1, data.getLogin());
			rqt.setString(2, data.getPassword());
			rqt.setString(3, data.getType());
			rqt.setBoolean(4, data.getHide());

			int nbRows = rqt.executeUpdate();
			if (nbRows == 1) {
				ResultSet rs = rqt.getGeneratedKeys();
				if (rs.next()) {
					data.setId(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new DALException("Insert article failed - " + data, e);
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
			throw new DALException("Delete article failed - id=" + id, e);
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

	public User selectByNom(String nom) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		User user = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectByNom);
			rqt.setString(1, nom);
			rs = rqt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("CodePers"), rs.getString("Nom"), rs.getString("MotPasse"),
						rs.getString("Role"), rs.getBoolean("Archive"));
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
		return user;
	}
}
