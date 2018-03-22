package fr.eni.clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fr.eni.clinique.bo.RendezVous;
import fr.eni.clinique.dal.AgendaDAO;
import fr.eni.clinique.dal.DALException;

public class AgendaDAOJdbcImpl implements AgendaDAO {
	private static final String sqlSelectAll = "SELECT CodeVeto, DateRdv, CodeAnimal FROM Agendas";
	private static final String sqlUpdate = "UPDATE Agendas SET CodeVeto=?, DateRdv=?, CodeAnimal=? WHERE CodeAnimal=?";
	private static final String sqlInsert = "INSERT INTO Agendas (CodeVeto, DateRdv, CodeAnimal) VALUES (?, ?, ?)";
	private static final String sqlDelete = "DELETE FROM Agendas WHERE CodeVeto=? AND DateRdv=?";
	private static final String sqlSelectByHour = "SELECT CodeVeto, DateRdv, CodeAnimal FROM Agendas WHERE DateRdv<=? AND DateRdv>=?";
	private static final String sqlSelectByDay = "SELECT CodeVeto, DateRdv, CodeAnimal FROM Agendas WHERE DateRdv<=? AND DateRdv>=?";
	private static final String sqlSelectByIdAnimal = "SELECT CodeVeto, CodeAnimal, DateRdv FROM Agendas WHERE CodeAnimal=?";
	private static final String sqlSelectByIdVet = "SELECT CodeVeto, CodeAnimal, DateRdv FROM Agendas WHERE CodeVeto=?";
	private static final String sqlSelectDayByVet = "SELECT CodeVeto, CodeAnimal, DateRdv FROM Agendas WHERE DateRdv BETWEEN ? AND ? AND CodeVeto=?";
	private static final String sqlSelectRdvByDateCodeVeto = "SELECT CodeVeto, DateRdv, CodeAnimal FROM Agendas WHERE CodeVeto=? AND DateRdv=?";

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
			throw new DALException("selectAll rdv failed - ", e);
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
			throw new DALException("Update rdv failed - " + data, e);
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
			rqt.setTimestamp(2, new java.sql.Timestamp(data.getDate().getTime()));
			rqt.setInt(3, data.getCodeAnimal());

			int nbRows = rqt.executeUpdate();
			if (nbRows == 1) {
				ResultSet rs = rqt.getGeneratedKeys();
				if (rs.next()) {
					data.setCodeAnimal(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new DALException("Insert rdv failed - " + data, e);
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

	public void delete(RendezVous data) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			System.out.println(data.toString() + " " + new java.sql.Timestamp(data.getDate().getTime()));
			// l'intégrité référentielle s'occupe d'invalider la suppression
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlDelete);
			rqt.setInt(1, data.getCodeVeto());
			rqt.setTimestamp(2, new java.sql.Timestamp(data.getDate().getTime()));
			// rqt.setInt(3, data.getCodeAnimal());
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Delete rdv failed - date=" + data.getDate().toString(), e);
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
			rqt.setTimestamp(1, new java.sql.Timestamp(date.getTime()));
			rqt.setTimestamp(2, new java.sql.Timestamp(cal.getTime().getTime()));
			rs = rqt.executeQuery();
			RendezVous rdv = null;

			while (rs.next()) {
				rdv = new RendezVous();

				liste.add(rdv);
			}
		} catch (SQLException e) {
			throw new DALException("selectByHour failed - date = " + date, e);
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
			throw new DALException("selectByDay failed - date = " + date, e);
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
			throw new DALException("selectByIdAnimal failed - IdAnimal = " + idAnimal, e);
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
			throw new DALException("selectByIdVet failed - idVet = " + idVet, e);
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
		cal.setTime(new Date(date.getTime()));
		cal.add(Calendar.DATE, 1);
		Date edate = new Date(cal.getTime().getTime());
		List<RendezVous> liste = new ArrayList<RendezVous>();
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectDayByVet);
			rqt.setDate(1, new java.sql.Date(date.getTime()));
			rqt.setDate(2, new java.sql.Date(edate.getTime()));
			rqt.setInt(3, idVet);
			rs = rqt.executeQuery();
			RendezVous rdv = null;

			while (rs.next()) {
				rdv = new RendezVous(rs.getInt("CodeVeto"), rs.getTimestamp("DateRdv"), rs.getInt("CodeAnimal"));
				liste.add(rdv);
			}
		} catch (SQLException e) {
			throw new DALException("selectDayByVet failed - date = " + date, e);
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
	public RendezVous selectRdvByDateCodeVeto(Date date, Integer idVet) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		RendezVous rdv = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(sqlSelectRdvByDateCodeVeto);
			rqt.setInt(1, idVet);
			rqt.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
			rs = rqt.executeQuery();
			while (rs.next()) {
				rdv = new RendezVous(rs.getInt("CodeVeto"), rs.getTimestamp("DateRdv"), rs.getInt("CodeAnimal"));
			}
		} catch (SQLException e) {
			throw new DALException("selectRdvByDateCodeVeto failed - date = " + date, e);
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
		return rdv;
	}
}
