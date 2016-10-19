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

}