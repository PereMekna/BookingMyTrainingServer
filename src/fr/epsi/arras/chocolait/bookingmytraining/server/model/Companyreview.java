package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the companyreview database table.
 * 
 */
@Entity
@Table(name="companyreview")
@NamedQuery(name="Companyreview.findAll", query="SELECT c FROM Companyreview c")
public class Companyreview implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompanyreviewPK id;

	@Temporal(TemporalType.DATE)
	private Date datereview;

	@Column(length=255)
	private String review;

	private double score;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="idcompany", nullable=false, insertable=false, updatable=false)
	private Company company;

	//bi-directional many-to-one association to Trainee
	@ManyToOne
	@JoinColumn(name="idtrainee", nullable=false, insertable=false, updatable=false)
	private Trainee trainee;

	public Companyreview() {
	}

	public CompanyreviewPK getId() {
		return this.id;
	}

	public void setId(CompanyreviewPK id) {
		this.id = id;
	}

	public Date getDatereview() {
		return this.datereview;
	}

	public void setDatereview(Date datereview) {
		this.datereview = datereview;
	}

	public String getReview() {
		return this.review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public double getScore() {
		return this.score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Trainee getTrainee() {
		return this.trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

}