package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the userconnect database table.
 * 
 */
@Entity
@Table(name="userconnect")
@NamedQuery(name="Userconnect.findAll", query="SELECT u FROM Userconnect u")
public class Userconnect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERCONNECT_IDUSERCONNECT_GENERATOR", sequenceName="USERCONNECT_IDUSERCONNECT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERCONNECT_IDUSERCONNECT_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer iduserconnect;

	@Column(length=255)
	private String apikey;

	@Column(length=255)
	private String hashpwd;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="userconnect")
	private List<Employee> employees;

	//bi-directional many-to-one association to Trainee
	@OneToMany(mappedBy="userconnect")
	private List<Trainee> trainees;

	public Userconnect() {
	}

	public Integer getIduserconnect() {
		return this.iduserconnect;
	}

	public void setIduserconnect(Integer iduserconnect) {
		this.iduserconnect = iduserconnect;
	}

	public String getApikey() {
		return this.apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getHashpwd() {
		return this.hashpwd;
	}

	public void setHashpwd(String hashpwd) {
		this.hashpwd = hashpwd;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setUserconnect(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setUserconnect(null);

		return employee;
	}

	public List<Trainee> getTrainees() {
		return this.trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}

	public Trainee addTrainee(Trainee trainee) {
		getTrainees().add(trainee);
		trainee.setUserconnect(this);

		return trainee;
	}

	public Trainee removeTrainee(Trainee trainee) {
		getTrainees().remove(trainee);
		trainee.setUserconnect(null);

		return trainee;
	}

}