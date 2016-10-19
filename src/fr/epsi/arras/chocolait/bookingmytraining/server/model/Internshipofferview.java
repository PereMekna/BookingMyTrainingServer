package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the internshipofferview database table.
 * 
 */
@Entity
@Table(name="internshipofferview")
@NamedQuery(name="Internshipofferview.findAll", query="SELECT i FROM Internshipofferview i")
public class Internshipofferview implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InternshipofferviewPK id;

	@Temporal(TemporalType.DATE)
	private Date dateview;

	//bi-directional many-to-one association to Internshipoffer
	@ManyToOne
	@JoinColumn(name="idinternshipoffer", nullable=false, insertable=false, updatable=false)
	private Internshipoffer internshipoffer;

	//bi-directional many-to-one association to Trainee
	@ManyToOne
	@JoinColumn(name="idtrainee", nullable=false, insertable=false, updatable=false)
	private Trainee trainee;

	public Internshipofferview() {
	}

	public InternshipofferviewPK getId() {
		return this.id;
	}

	public void setId(InternshipofferviewPK id) {
		this.id = id;
	}

	public Date getDateview() {
		return this.dateview;
	}

	public void setDateview(Date dateview) {
		this.dateview = dateview;
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