package fr.epsi.arras.chocolait.bookingmytraining.server.model.internshipoffer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.epsi.arras.chocolait.bookingmytraining.server.model.Employee;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.InternshipOffer;

public class FacadeInternshipOffer {
	private EntityManager entityManager = Persistence.createEntityManagerFactory("BookingMyTraining")
			.createEntityManager();
	
	private static FacadeInternshipOffer INSTANCE = new FacadeInternshipOffer();
	
	private FacadeInternshipOffer() {
		// TODO Auto-generated constructor stub
	}
	
	public static FacadeInternshipOffer getInstance() {
		return INSTANCE;
	}
	
	public List<InternshipOffer> getAllOffers() {
		Query query = entityManager.createQuery("select io from InternshipOffer io");
		List<InternshipOffer> listInternshipOffers;
		try {
			listInternshipOffers = query.getResultList();
		} catch (final NoResultException e) {
			return null;
		}
		return listInternshipOffers;
	}
	
	public InternshipOffer getOfferById(Integer idInternshipOffer) {
		InternshipOffer internshipOffer;
		Query query = entityManager.createQuery("select io from InternshipOffer io WHERE idInternshipOffer=" + idInternshipOffer);
		try {
			internshipOffer = (InternshipOffer) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return internshipOffer;
	}
	
	public void createOffer(InternshipOffer internshipOffer) {
		EntityTransaction transac = entityManager.getTransaction();
		transac.begin();
		entityManager.persist(internshipOffer);
		transac.commit();
	}
}
