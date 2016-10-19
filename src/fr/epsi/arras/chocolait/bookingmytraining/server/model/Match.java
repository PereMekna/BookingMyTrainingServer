package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the match database table.
 * 
 */
@Entity
@Table(name="match")
@NamedQuery(name="Match.findAll", query="SELECT m FROM Match m")
public class Match implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MatchPK id;

	private Boolean chosen;

	private Boolean employeeok;

	@Temporal(TemporalType.DATE)
	private Date matchdate;

	private Boolean traineeshipok;

	//bi-directional many-to-one association to Internshipoffer
	@ManyToOne
	@JoinColumn(name="idinternshipoffer", nullable=false, insertable=false, updatable=false)
	private Internshipoffer internshipoffer;

	//bi-directional many-to-one association to Trainee
	@ManyToOne
	@JoinColumn(name="idtrainee", nullable=false, insertable=false, updatable=false)
	private Trainee trainee;

	public Match() {
	}

	public MatchPK getId() {
		return this.id;
	}

	public void setId(MatchPK id) {
		this.id = id;
	}

	public Boolean getChosen() {
		return this.chosen;
	}

	public void setChosen(Boolean chosen) {
		this.chosen = chosen;
	}

	public Boolean getEmployeeok() {
		return this.employeeok;
	}

	public void setEmployeeok(Boolean employeeok) {
		this.employeeok = employeeok;
	}

	public Date getMatchdate() {
		return this.matchdate;
	}

	public void setMatchdate(Date matchdate) {
		this.matchdate = matchdate;
	}

	public Boolean getTraineeshipok() {
		return this.traineeshipok;
	}

	public void setTraineeshipok(Boolean traineeshipok) {
		this.traineeshipok = traineeshipok;
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