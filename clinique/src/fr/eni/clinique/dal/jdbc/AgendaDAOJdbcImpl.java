package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

import fr.eni.clinique.bo.RendezVous;
import fr.eni.clinique.dal.AgendaDAO;
import fr.eni.clinique.dal.DALException;

public class AgendaDAOJdbcImpl implements AgendaDAO {
	private static final String sqlSelectAll = "SELECT CodeVeto, DateRdv, CodeAnimal FROM Agendas";
	private static final String sqlUpdate = "UPDATE Agendas SET CodeVeto=?, DateRdv=?, CodeAnimal=? WHERE CodeAnimal=?";
	private static final String sqlInsert = "INSERT INTO Agendas (CodeVeto, DateRdv, CodeAnimal) VALUES (?, ?, ?)";
	private static final String sqlDelete = "DELETE FROM Agendas WHERE DateRdv=?";
	private static final String sqlSelectByHour = "SELECT CodeVeto, DateRdv, CodeAnimal FROM Agendas WHERE DateRdv<=? AND DateRdv>=?";
	private static final String sqlSelectByDay = "SELECT CodeVeto, DateRdv, CodeAnimal FROM Agendas WHERE DateRdv<=? AND DateRdv>=?";
	private static final String sqlSelectByIdAnimal ="SELECT CodeVeto, CodeAnimal, DateRdv FROM Agendas WHERE CodeAnimal=?";
	private static final String sqlSelectByIdVet = "SELECT CodeVeto, CodeAnimal, DateRdv FROM Agendas WHERE CodeVeto=?";
	private static final String sqlSelectDayByVet = "SELECT CodeVeto, CodeAnimal, DateRdv FROM Agendas WHERE DateRdv<=? AND DateRdv>=? AND CodeVeto=?";
	
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

	public void delete(RendezVous prdv) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = JdbcTools.getConnection();
			// l'intégrité référentielle s'occupe d'invalider la suppression
			// si l'article est référencé dans une ligne de commande
			rqt = cnx.prepareStatement(sqlDelete);
			rqt.setInt(1, prdv.getCodeAnimal());
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Delete animal failed - id=" + prdv.getCodeAnimal(), e);
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
	public List<RendezVous> selectByHour(Date date) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Calendar cal = Calendar.getInstance();
		List<RendezVous> liste = new ArrayList<RendezVous>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectByHour);
			cal.setTime(new Date(date.getTime()));
			cal.add(Calendar.HOUR, 1);
			rqt.setDate(1, new java.sql.Date(date.getTime()));
			rqt.setDate(2, (java.sql.Date) cal.getTime());
			rs = rqt.executeQuery();
			RendezVous rdv = null;

			while (rs.next()) {
				rdv = new RendezVous();

				liste.add(rdv);
			}
		} catch (SQLException e) {
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

	@Override
	public List<RendezVous> selectByDay(Date date) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Calendar cal = Calendar.getInstance();
		List<RendezVous> liste = new ArrayList<RendezVous>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectByDay);
			cal.setTime(new Date(date.getTime()));
			cal.add(Calendar.DATE, 1);
			rqt.setDate(1, new java.sql.Date(date.getTime()));
			rqt.setDate(2, (java.sql.Date) cal.getTime());
			rs = rqt.executeQuery();
			RendezVous rdv = null;

			while (rs.next()) {
				rdv = new RendezVous();

				liste.add(rdv);
			}
		} catch (SQLException e) {
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

	@Override
	public List<RendezVous> selectByIdAnimal(Integer idAnimal) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Calendar cal = Calendar.getInstance();
		List<RendezVous> liste = new ArrayList<RendezVous>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectByIdAnimal);
			rqt.setInt(1, idAnimal);
			rs = rqt.executeQuery();
			RendezVous rdv = null;

			while (rs.next()) {
				rdv = new RendezVous(rs.getInt("CodeVeto"), rs.getDate("DateRdv"), rs.getInt("CodeAnimal"));

				liste.add(rdv);
			}
		} catch (SQLException e) {
			throw new DALException("selectByDate failed - date = ", e);
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

	@Override
	public List<RendezVous> selectByIdVet(Integer idVet) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Calendar cal = Calendar.getInstance();
		List<RendezVous> liste = new ArrayList<RendezVous>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectByIdVet);
			rqt.setInt(1, idVet);
			rs = rqt.executeQuery();
			RendezVous rdv = null;

			while (rs.next()) {
				rdv = new RendezVous(rs.getInt("CodeVeto"), rs.getDate("DateRdv"), rs.getInt("CodeAnimal"));

				liste.add(rdv);
			}
		} catch (SQLException e) {
			throw new DALException("selectByDate failed - date = ", e);
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

	@Override
	public List<RendezVous> selectDayByVet(Date date, Integer idVet) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Calendar cal = Calendar.getInstance();
		List<RendezVous> liste = new ArrayList<RendezVous>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectDayByVet);
			cal.setTime(new Date(date.getTime()));
			cal.add(Calendar.DATE, 1);
			rqt.setDate(1, new java.sql.Date(date.getTime()));
			rqt.setDate(2, (java.sql.Date) cal.getTime());
			rqt.setInt(3, idVet);
			rs = rqt.executeQuery();
			RendezVous rdv = null;

			while (rs.next()) {
				rdv = new RendezVous(rs.getInt("CodeVeto"), rs.getDate("DateRdv"), rs.getInt("CodeAnimal"));

				liste.add(rdv);
			}
		} catch (SQLException e) {
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
