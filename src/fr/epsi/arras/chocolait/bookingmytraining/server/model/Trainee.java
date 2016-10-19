package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trainee database table.
 * 
 */
@Entity
@Table(name="trainee")
@NamedQuery(name="Trainee.findAll", query="SELECT t FROM Trainee t")
public class Trainee extends UserAbstract implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer idtrainee;

	@Column(length=255)
	private String cv;

	private Integer iduserconnect;

	@Column(length=255)
	private String name;

	@Column(length=255)
	private String surname;

	public Trainee() {
	}

	public Integer getIdtrainee() {
		return this.idtrainee;
	}

	public void setIdtrainee(Integer idtrainee) {
		this.idtrainee = idtrainee;
	}

	public String getCv() {
		return this.cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
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

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}