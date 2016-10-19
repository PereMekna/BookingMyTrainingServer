package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the internshipoffer database table.
 * 
 */
@Entity
@Table(name="internshipoffer")
@NamedQuery(name="Internshipoffer.findAll", query="SELECT i FROM InternshipOffer i")
public class InternshipOffer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INTERNSHIPOFFER_IDINTERNSHIPOFFER_GENERATOR", sequenceName="INTERNSHIPOFFER_IDINTERNSHIPOFFER_SEQ", initialValue=1000, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INTERNSHIPOFFER_IDINTERNSHIPOFFER_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idinternshipoffer;

	@Column(length=255)
	private String address;

	@Column(length=255)
	private String description;

	private Boolean finished;

	private Integer idemployee;

	@Column(nullable=false, length=255)
	private String jobtitle;

	private Integer level;

	@Column(length=255)
	private String mission;

	@Column(length=255)
	private String profile;

	@Temporal(TemporalType.DATE)
	private Date publication;

	private Integer traineenb;

	public InternshipOffer() {
	}

	public Integer getIdinternshipoffer() {
		return this.idinternshipoffer;
	}

	public void setIdinternshipoffer(Integer idinternshipoffer) {
		this.idinternshipoffer = idinternshipoffer;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getFinished() {
		return this.finished;
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
	}

	public Integer getIdemployee() {
		return this.idemployee;
	}

	public void setIdemployee(Integer idemployee) {
		this.idemployee = idemployee;
	}

	public String getJobtitle() {
		return this.jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getMission() {
		return this.mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
	}

	public String getProfile() {
		return this.profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public Date getPublication() {
		return this.publication;
	}

	public void setPublication(Date publication) {
		this.publication = publication;
	}

	public Integer getTraineenb() {
		return this.traineenb;
	}

	public void setTraineenb(Integer traineenb) {
		this.traineenb = traineenb;
	}

}
