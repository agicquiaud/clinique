package fr.eni.clinique.bll;

import java.util.Date;
import java.util.List;

import fr.eni.clinique.bo.RendezVous;
import fr.eni.clinique.dal.AgendaDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;

public class AgendaManagerImpl implements AgendaManager {

	private AgendaDAO agendaDAO = new DAOFactory().getAgendaDAO();
	private List<RendezVous> liste;
	private RendezVous rdv;

	@Override
	public void insert(RendezVous pRdv) throws BLLException {
		try {
			agendaDAO.insert(pRdv);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Agenda insert - rdv=" + pRdv, e);
		}

	}

	@Override
	public void update(RendezVous pRdv) throws BLLException {
		try {
			agendaDAO.update(pRdv);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Agenda update - rdv=" + pRdv, e);
		}

	}

	@Override
	public void delete(RendezVous pRdv) throws BLLException {
		try {
			agendaDAO.delete(pRdv);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Agenda delete - rdv=" + pRdv, e);
		}

	}

	@Override
	public List<RendezVous> getAll() throws BLLException {
		try {
			liste = agendaDAO.selectAll();
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Agenda getAll - " + e);
		}
		return liste;
	}

	@Override
	public List<RendezVous> RdvByIdAnimal(Integer id) throws BLLException {
		try {
			liste = agendaDAO.selectByIdAnimal(id);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Agenda RdvByIdAnimal - id=" + id, e);
		}
		return liste;
	}

	@Override
	public List<RendezVous> RdvByIdVet(Integer id) throws BLLException {
		try {
			liste = agendaDAO.selectByIdVet(id);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Agenda RdvByIdVet - id=" + id, e);
		}
		return liste;
	}

	@Override
	public List<RendezVous> getRdvVetByDay(RendezVous prdv) throws BLLException {
		try {
			liste = agendaDAO.selectDayByVet(prdv.getDate(), prdv.getCodeVeto());
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Agenda getRdvVetByDay - rdv=" + prdv, e);
		}
		return liste;
	}

	@Override
	public RendezVous getRdvByDateCodeVet(Integer codeVet, Date date) throws BLLException {
		try {
			rdv = agendaDAO.selectRdvByDateCodeVeto(date, codeVet);
		} catch (DALException e) {
			throw new BLLException("Erreur BLL Agenda getRdvByDateCodeVet - date=" + date + " codeVet=" + codeVet, e);
		}
		return rdv;
	}

}
