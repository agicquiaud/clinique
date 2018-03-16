package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.dal.ClientDAO;
import fr.eni.clinique.dal.DALException;

public class ClientDAOJdbcImpl implements ClientDAO {

	private static final String sqlSelectAll = "SELECT CodeClient, NomClient, PrenomClient, "
			+ "Adresse1, CodePostal, Ville, NumTel, Email, Archive FROM Clients";
	private static final String sqlUpdate = "UPDATE Clients SET NomClient=?, PrenomClient=?, "
			+ "Adresse1=?, Adresse2=?, CodePostal=?, Ville=?, NumTel=?, Assurance=?, Email=?, Remarque=?, Archive=? WHERE CodeClient=?";
	private static final String sqlInsert = "INSERT INTO Clients (NomClient, PrenomClient, "
			+ "Adresse1, Adresse2, CodePostal, Ville, NumTel, Email, Archive) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String sqlDelete = "DELETE FROM Clients WHERE CodeClient=?";
	private static final String sqlSelectByNom = "SELECT CodeClient, NomClient, PrenomClient, "
			+ "Adresse1, CodePostal, Ville, NumTel, Email, Archive FROM Clients WHERE NomClient LIKE ? OR PrenomClient LIKE ? ORDER BY NomClient ASC";
	private static final String sqlSelectById = "SELECT CodeClient, NomClient, PrenomClient, "
			+ "Adresse1, Adresse2, CodePostal, Ville, NumTel, Email, Archive FROM Clients WHERE CodeClient=?";
	private static final String sqlSelectByNomPrenom = "SELECT CodeClient, NomClient, PrenomClient, "
			+ "Adresse1, Adresse2, CodePostal, Ville, NumTel, Email, Archive FROM Clients WHERE NomClient=? AND PrenomClient=? ORDER BY NomClient ASC";

	public List<Clients> selectAll() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<Clients> liste = new ArrayList<Clients>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(sqlSelectAll);
			Clients client = null;

			while (rs.next()) {
				client = new Clients(rs.getInt("CodeClient"), rs.getString("NomClient"), rs.getString("PrenomClient"),
						rs.getString("Adresse1"), rs.getString("CodePostal"), rs.getString("Ville"),
						rs.getString("NumTel"), rs.getString("Email"), rs.getBoolean("Archive"));

				liste.add(client);
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

	public void update(Clients data) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlUpdate);
			rqt.setString(1, data.getNom());
			rqt.setString(2, data.getPrenom());
			rqt.setString(3, data.getAdresse1());
			rqt.setString(4, data.getAdresse2());
			rqt.setString(5, data.getCodePostal());
			rqt.setString(6, data.getVille());
			rqt.setString(7, data.getNumTel());
			rqt.setString(8, data.getAssurance());
			rqt.setString(9, data.getEmail());
			rqt.setString(10, data.getRemarque());
			rqt.setBoolean(11, data.getArchive());
			rqt.setInt(12, data.getCodeClient());

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

	public void insert(Clients data) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1, data.getNom());
			rqt.setString(2, data.getPrenom());
			rqt.setString(3, data.getAdresse1());
			rqt.setString(4, data.getAdresse2());
			rqt.setString(5, data.getCodePostal());
			rqt.setString(6, data.getVille());
			rqt.setString(7, data.getNumTel());
			rqt.setString(8, data.getEmail());
			rqt.setBoolean(9, data.getArchive());

			int nbRows = rqt.executeUpdate();
			if (nbRows == 1) {
				ResultSet rs = rqt.getGeneratedKeys();
				if (rs.next()) {
					data.setCodeClient(rs.getInt(1));
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

	public List<Clients> selectByNom(String nom) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<Clients> liste = new ArrayList<Clients>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectByNom);
			rqt.setString(1, "%" + nom + "%");
			rqt.setString(2, "%" + nom + "%");
			rs = rqt.executeQuery();
			Clients client = null;
			
			while (rs.next()) {
				client = new Clients(rs.getInt("CodeClient"), rs.getString("NomClient"), rs.getString("PrenomClient"),
						rs.getString("Adresse1"), rs.getString("CodePostal"), rs.getString("Ville"),
						rs.getString("NumTel"), rs.getString("Email"), rs.getBoolean("Archive"));

				liste.add(client);
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
		return liste;
	}

	public Clients selectById(Integer id) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Clients client = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectById);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			if (rs.next()) {
				client = new Clients(rs.getInt("CodeClient"), rs.getString("NomClient"), rs.getString("PrenomClient"),
						rs.getString("Adresse1"), rs.getString("Adresse2"), rs.getString("CodePostal"),
						rs.getString("Ville"), rs.getString("NumTel"), rs.getString("Email"), rs.getBoolean("Archive"));
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
		return client;
	}

	@Override
	public Clients selectByNomPrenom(String prenom, String nom) throws DALException{
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Clients client = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectByNomPrenom);
			rqt.setString(1, nom);
			rqt.setString(2, prenom);
			rs = rqt.executeQuery();
			if (rs.next()) {
				client = new Clients(rs.getInt("CodeClient"), rs.getString("NomClient"), rs.getString("PrenomClient"),
						rs.getString("Adresse1"), rs.getString("Adresse2"), rs.getString("CodePostal"),
						rs.getString("Ville"), rs.getString("NumTel"), rs.getString("Email"), rs.getBoolean("Archive"));
			}

		} catch (SQLException e) {
			throw new DALException("selectByNomPrenom failed - nomprenom = " + nom + " " +prenom, e);
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
		return client;
	}
}
