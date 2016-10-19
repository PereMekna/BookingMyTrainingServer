package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the internshipreview database table.
 * 
 */
@Entity
@Table(name="internshipreview")
@NamedQuery(name="Internshipreview.findAll", query="SELECT i FROM Internshipreview i")
public class Internshipreview implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InternshipreviewPK id;

	private Boolean consulted;

	@Temporal(TemporalType.DATE)
	private Date datereview;

	@Column(length=255)
	private String review;

	private double score;

	//bi-directional many-to-one association to Internshipoffer
	@ManyToOne
	@JoinColumn(name="idinternshipoffer", nullable=false, insertable=false, updatable=false)
	private Internshipoffer internshipoffer;

	//bi-directional many-to-one association to Trainee
	@ManyToOne
	@JoinColumn(name="idtrainee", nullable=false, insertable=false, updatable=false)
	private Trainee trainee;

	public Internshipreview() {
	}

	public InternshipreviewPK getId() {
		return this.id;
	}

	public void setId(InternshipreviewPK id) {
		this.id = id;
	}

	public Boolean getConsulted() {
		return this.consulted;
	}

	public void setConsulted(Boolean consulted) {
		this.consulted = consulted;
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

	public Internshipoffer getInternshipoffer() {
		return this.internshipoffer;
	}

	public void setInternshipoffer(Internshipoffer internshipoffer) {
		this.internshipoffer = internshipoffer;
	}

	public Trainee getTrainee() {
		return this.trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

}