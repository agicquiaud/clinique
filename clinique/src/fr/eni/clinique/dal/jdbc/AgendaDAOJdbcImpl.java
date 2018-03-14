package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bo.RendezVous;
import fr.eni.clinique.dal.AgendaDAO;
import fr.eni.clinique.dal.DALException;

public class AgendaDAOJdbcImpl implements AgendaDAO{
	private static final String sqlSelectAll = "SELECT CodeVeto, DateRdv, CodeAnimal FROM Agendas";
	private static final String sqlUpdate = "UPDATE Agendas SET CodeVeto=?, DateRdv=?, CodeAnimal=? WHERE CodeAnimal=?";
	private static final String sqlInsert = "INSERT INTO Agendas (CodeVeto, DateRdv, CodeAnimal) VALUES (?, ?, ?)";
	private static final String sqlDelete = "DELETE FROM Agendas WHERE DateRdv=?";
	private static final String sqlSelectByDate = "SELECT CodeVeto, DateRdv, CodeAnimal FROM Agendas WHERE DateRdv=?";

	public List<RendezVous> selectAll() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<RendezVous> liste = new ArrayList<RendezVous>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(sqlSelectAll);
			RendezVous rdv = null;

			while (rs.next()) {
				
				rdv = new RendezVous();

				liste.add(rdv);
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

	public void update(RendezVous data) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlUpdate);
			rqt.setInt(1, data.getCodeVeto());
			rqt.setDate(4, new java.sql.Date(data.getDate().getTime()));
			rqt.setInt(3, data.getCodeAnimal());
			rqt.setDate(4, new java.sql.Date(data.getDate().getTime()));

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

	public void insert(RendezVous data) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			rqt.setInt(1, data.getCodeVeto());
			rqt.setDate(2, new java.sql.Date(data.getDate().getTime()));
			rqt.setInt(3, data.getCodeAnimal());

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

	public List<RendezVous> sqlSelectByDate(Date date) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<RendezVous> liste = new ArrayList<RendezVous>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectByDate);
			rqt.setDate(1, date);
			rs = rqt.executeQuery();
			RendezVous rdv = null;

			while (rs.next()) {
				rdv = new RendezVous();

				liste.add(rdv);
			}
		} catch (

		SQLException e) {
			throw new DALException("selectByDate failed - date = " + date, e);
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
}
