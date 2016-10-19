package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Table(name="company")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(insertable=false, unique=true, nullable=false)
	private Integer idcompany;

	private Integer employeenb;

	@Column(nullable=false, length=255)
	private String name;

	private Boolean socialmanagement;

	private Integer traineenb;

	private double traineeshipbonus;

	public Company() {
	}

	public Integer getIdcompany() {
		return this.idcompany;
	}

	public void setIdcompany(Integer idcompany) {
		this.idcompany = idcompany;
	}

	public Integer getEmployeenb() {
		return this.employeenb;
	}

	public void setEmployeenb(Integer employeenb) {
		this.employeenb = employeenb;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getSocialmanagement() {
		return this.socialmanagement;
	}

	public void setSocialmanagement(Boolean socialmanagement) {
		this.socialmanagement = socialmanagement;
	}

	public Integer getTraineenb() {
		return this.traineenb;
	}

	public void setTraineenb(Integer traineenb) {
		this.traineenb = traineenb;
	}

	public double getTraineeshipbonus() {
		return this.traineeshipbonus;
	}

	public void setTraineeshipbonus(double traineeshipbonus) {
		this.traineeshipbonus = traineeshipbonus;
	}

}