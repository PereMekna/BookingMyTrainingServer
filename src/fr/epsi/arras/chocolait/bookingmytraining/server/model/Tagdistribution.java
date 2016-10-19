package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tagdistribution database table.
 * 
 */
@Entity
@Table(name="tagdistribution")
@NamedQuery(name="Tagdistribution.findAll", query="SELECT t FROM Tagdistribution t")
public class Tagdistribution implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TagdistributionPK id;

	//bi-directional many-to-one association to Internshipoffer
	@ManyToOne
	@JoinColumn(name="idinternshipoffer", nullable=false, insertable=false, updatable=false)
	private Internshipoffer internshipoffer;

	//bi-directional many-to-one association to Tag
	@ManyToOne
	@JoinColumn(name="idtag", nullable=false, insertable=false, updatable=false)
	private Tag tag;

	//bi-directional many-to-one association to Trainee
	@ManyToOne
	@JoinColumn(name="idtrainee", nullable=false, insertable=false, updatable=false)
	private Trainee trainee;

	public Tagdistribution() {
	}

	public TagdistributionPK getId() {
		return this.id;
	}

	public void setId(TagdistributionPK id) {
		this.id = id;
	}

	public Internshipoffer getInternshipoffer() {
		return this.internshipoffer;
	}

	public void setInternshipoffer(Internshipoffer internshipoffer) {
		this.internshipoffer = internshipoffer;
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Trainee getTrainee() {
		return this.trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

}