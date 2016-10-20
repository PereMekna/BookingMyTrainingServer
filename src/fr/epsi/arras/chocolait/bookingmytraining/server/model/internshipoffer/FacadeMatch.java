package fr.epsi.arras.chocolait.bookingmytraining.server.model.internshipoffer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.epsi.arras.chocolait.bookingmytraining.server.model.InternshipOffer;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.Match;

public class FacadeMatch {
	private EntityManager entityManager = Persistence.createEntityManagerFactory("BookingMyTraining")
			.createEntityManager();

	private static FacadeMatch INSTANCE = new FacadeMatch();

	private FacadeMatch() {
		// TODO Auto-generated constructor stub
	}

	public static FacadeMatch getInstance() {
		return INSTANCE;
	}

	public List<Match> getAllMatches() {
		Query query = entityManager.createQuery("select m from Match m");
		List<Match> listMatches;
		try {
			listMatches = query.getResultList();
		} catch (final NoResultException e) {
			return null;
		}
		return listMatches;
	}

	public void createMatch(Match match) {
		EntityTransaction transac = entityManager.getTransaction();
		transac.begin();
		entityManager.persist(match);
		transac.commit();
	}

	public Match updateMatch(Match match) {
		EntityTransaction transac = entityManager.getTransaction();
		transac.begin();
		Match matchToUpdate = entityManager.find(Match.class, match.getId());
		if (match.getEmployeeok() != null) {
			if (match.getEmployeeok()) {
				matchToUpdate.setEmployeeok(match.getEmployeeok());
			}
		}
		if (match.getTraineeshipok() != null) {
			if (match.getTraineeshipok()) {
				matchToUpdate.setTraineeshipok(match.getTraineeshipok());
			}
		}
		entityManager.flush();
		transac.commit();
		return matchToUpdate;
	}

	public Boolean isMatchExisting(Match match) {
		if (entityManager.find(Match.class, match.getId()) != null) {
			return true;
		}
		return false;
	}

}
