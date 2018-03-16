package fr.eni.clinique.bll;

import java.util.List;

import fr.eni.clinique.bo.RendezVous;
import fr.eni.clinique.dal.AgendaDAO;
import fr.eni.clinique.dal.DALException;
import fr.eni.clinique.dal.DAOFactory;

public class AgendaManagerImpl implements AgendaManager{

	private AgendaDAO agendaDAO = new DAOFactory().getAgendaDAO();
	private List<RendezVous> liste;
	
	@Override
	public void insert(RendezVous pRdv) {
		try {
			agendaDAO.insert(pRdv);
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(RendezVous pRdv) {
		try {
			agendaDAO.update(pRdv);
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(RendezVous pRdv) {
		try {
			agendaDAO.delete(pRdv);
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<RendezVous> getAll() {
		try {
			liste = agendaDAO.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public List<RendezVous> RdvByIdAnimal(Integer id) {
		try {
			liste = agendaDAO.selectByIdAnimal(id);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public List<RendezVous> RdvByIdVet(Integer id) {
		try {
			liste = agendaDAO.selectByIdVet(id);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return liste;
	}

	@Override
	public List<RendezVous> getRdvVetByDay(RendezVous prdv) {
		try {
			liste = agendaDAO.selectDayByVet(prdv.getDate(), prdv.getCodeVeto());
		} catch (DALException e) {
			e.printStackTrace();
		}
		System.out.println(liste.toString());
		return liste;
	}
	
}
