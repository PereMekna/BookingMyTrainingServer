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
@NamedQuery(name="Companyreview.findAll", query="SELECT c FROM CompanyReview c")
public class CompanyReview implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CompanyReviewPK id;

	@Temporal(TemporalType.DATE)
	private Date datereview;

	@Column(length=255)
	private String review;

	private double score;

	public CompanyReview() {
	}

	public CompanyReviewPK getId() {
		return this.id;
	}

	public void setId(CompanyReviewPK id) {
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

}
