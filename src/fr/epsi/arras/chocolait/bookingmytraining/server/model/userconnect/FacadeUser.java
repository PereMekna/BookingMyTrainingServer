package fr.epsi.arras.chocolait.bookingmytraining.server.model.userconnect;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.epsi.arras.chocolait.bookingmytraining.server.model.Employee;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.InternshipOffer;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.Trainee;
import fr.epsi.arras.chocolait.bookingmytraining.server.model.UserConnect;

public class FacadeUser {
	private EntityManager entityManager = Persistence.createEntityManagerFactory("BookingMyTraining")
			.createEntityManager();
	
	private static FacadeUser INSTANCE = new FacadeUser();
	
	private FacadeUser() {
	}
	
	public static FacadeUser getInstance() {
		return INSTANCE;
	}
	
	public Boolean isUserExisting(String mail, String password) {
		UserConnect userConnect;
		Query query = entityManager
				.createQuery("select u from UserConnect u WHERE u.mail='" + mail + "' AND u.hashpwd='" + password + "'");
		try {
			userConnect = (UserConnect) query.getSingleResult();
			if (userConnect != null) {
				return true;
			}
		} catch (final NoResultException e) {
			return false;
		}
		return false;
	}
	
	public void signUpUserConnect(UserConnect userConnect) {
		EntityTransaction transac = entityManager.getTransaction();
		transac.begin();
		entityManager.persist(userConnect);
		transac.commit();
	}
	
	public void signUpTrainee(Trainee trainee) {
		EntityTransaction transac = entityManager.getTransaction();
		transac.begin();
		entityManager.persist(trainee);
		transac.commit();
	}
	
	public void signUpEmployee(Employee employee) {
		EntityTransaction transac = entityManager.getTransaction();
		transac.begin();
		entityManager.persist(employee);
		transac.commit();
	}
	
	public Trainee getTraineeById(Integer idTrainee) {
		Trainee trainee;
		Query query = entityManager.createQuery("select t from Trainee t WHERE idTrainee=" + idTrainee);
		try {
			trainee = (Trainee) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		return trainee;
	}
	
	public List<Trainee> getAllTrainees() {
		Query query = entityManager.createQuery("select t from Trainee t");
		List<Trainee> listTrainees;
		try {
			listTrainees = query.getResultList();
		} catch (final NoResultException e) {
			return null;
		}
		return listTrainees;
	}
}
