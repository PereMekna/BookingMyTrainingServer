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
@NamedQuery(name="Internshipreview.findAll", query="SELECT i FROM InternshipReview i")
public class InternshipReview implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InternshipReviewPK id;

	private Boolean consulted;

	@Temporal(TemporalType.DATE)
	private Date datereview;

	@Column(length=255)
	private String review;

	private double score;

	public InternshipReview() {
	}

	public InternshipReviewPK getId() {
		return this.id;
	}

	public void setId(InternshipReviewPK id) {
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

}