package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee extends UserAbstract implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMPLOYEE_IDEMPLOYEE_GENERATOR", sequenceName="EMPLOYEE_IDEMPLOYEE_SEQ", initialValue=1000, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEE_IDEMPLOYEE_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idemployee;

	private Integer iduserconnect;

	@Column(length=255)
	private String name;

	@Column(length=255)
	private String status;

	@Column(length=255)
	private String surname;

	public Employee() {
	}

	public Integer getIdemployee() {
		return this.idemployee;
	}

	public void setIdemployee(Integer idemployee) {
		this.idemployee = idemployee;
	}

	public Integer getIduserconnect() {
		return this.iduserconnect;
	}

	public void setIduserconnect(Integer iduserconnect) {
		this.iduserconnect = iduserconnect;
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

}