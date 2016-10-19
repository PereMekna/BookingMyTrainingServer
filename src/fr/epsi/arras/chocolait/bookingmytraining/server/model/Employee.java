package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMPLOYEE_IDEMPLOYEE_GENERATOR", sequenceName="EMPLOYEE_IDEMPLOYEE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEE_IDEMPLOYEE_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idemployee;

	@Column(length=25)
	private String mail;

	@Column(length=255)
	private String name;

	@Column(length=255)
	private String status;

	@Column(length=255)
	private String surname;

	//bi-directional many-to-one association to Userconnect
	@ManyToOne
	@JoinColumn(name="iduserconnect")
	private Userconnect userconnect;

	//bi-directional many-to-many association to Company
	@ManyToMany
	@JoinTable(
		name="employeecompany"
		, joinColumns={
			@JoinColumn(name="idemployee", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="idcompany", nullable=false)
			}
		)
	private List<Company> companies;

	//bi-directional many-to-one association to Internshipoffer
	@OneToMany(mappedBy="employee")
	private List<Internshipoffer> internshipoffers;

	public Employee() {
	}

	public Integer getIdemployee() {
		return this.idemployee;
	}

	public void setIdemployee(Integer idemployee) {
		this.idemployee = idemployee;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Userconnect getUserconnect() {
		return this.userconnect;
	}

	public void setUserconnect(Userconnect userconnect) {
		this.userconnect = userconnect;
	}

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public List<Internshipoffer> getInternshipoffers() {
		return this.internshipoffers;
	}

	public void setInternshipoffers(List<Internshipoffer> internshipoffers) {
		this.internshipoffers = internshipoffers;
	}

	public Internshipoffer addInternshipoffer(Internshipoffer internshipoffer) {
		getInternshipoffers().add(internshipoffer);
		internshipoffer.setEmployee(this);

		return internshipoffer;
	}

	public Internshipoffer removeInternshipoffer(Internshipoffer internshipoffer) {
		getInternshipoffers().remove(internshipoffer);
		internshipoffer.setEmployee(null);

		return internshipoffer;
	}

}