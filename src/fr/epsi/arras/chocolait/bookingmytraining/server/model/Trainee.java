package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the trainee database table.
 * 
 */
@Entity
@Table(name="trainee")
@NamedQuery(name="Trainee.findAll", query="SELECT t FROM Trainee t")
public class Trainee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRAINEE_IDTRAINEE_GENERATOR", sequenceName="TRAINEE_IDTRAINEE_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRAINEE_IDTRAINEE_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idtrainee;

	@Column(length=255)
	private String cv;

	@Column(length=255)
	private String mail;

	@Column(length=255)
	private String name;

	@Column(length=255)
	private String surname;

	//bi-directional many-to-one association to Companyreview
	@OneToMany(mappedBy="trainee")
	private List<Companyreview> companyreviews;

	//bi-directional many-to-one association to Internshipofferview
	@OneToMany(mappedBy="trainee")
	private List<Internshipofferview> internshipofferviews;

	//bi-directional many-to-one association to Internshipreview
	@OneToMany(mappedBy="trainee")
	private List<Internshipreview> internshipreviews;

	//bi-directional many-to-one association to Location
	@OneToMany(mappedBy="trainee")
	private List<Location> locations;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="trainee")
	private List<Match> matches;

	//bi-directional many-to-one association to Tagdistribution
	@OneToMany(mappedBy="trainee")
	private List<Tagdistribution> tagdistributions;

	//bi-directional many-to-one association to Userconnect
	@ManyToOne
	@JoinColumn(name="iduserconnect")
	private Userconnect userconnect;

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

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	public List<Companyreview> getCompanyreviews() {
		return this.companyreviews;
	}

	public void setCompanyreviews(List<Companyreview> companyreviews) {
		this.companyreviews = companyreviews;
	}

	public Companyreview addCompanyreview(Companyreview companyreview) {
		getCompanyreviews().add(companyreview);
		companyreview.setTrainee(this);

		return companyreview;
	}

	public Companyreview removeCompanyreview(Companyreview companyreview) {
		getCompanyreviews().remove(companyreview);
		companyreview.setTrainee(null);

		return companyreview;
	}

	public List<Internshipofferview> getInternshipofferviews() {
		return this.internshipofferviews;
	}

	public void setInternshipofferviews(List<Internshipofferview> internshipofferviews) {
		this.internshipofferviews = internshipofferviews;
	}

	public Internshipofferview addInternshipofferview(Internshipofferview internshipofferview) {
		getInternshipofferviews().add(internshipofferview);
		internshipofferview.setTrainee(this);

		return internshipofferview;
	}

	public Internshipofferview removeInternshipofferview(Internshipofferview internshipofferview) {
		getInternshipofferviews().remove(internshipofferview);
		internshipofferview.setTrainee(null);

		return internshipofferview;
	}

	public List<Internshipreview> getInternshipreviews() {
		return this.internshipreviews;
	}

	public void setInternshipreviews(List<Internshipreview> internshipreviews) {
		this.internshipreviews = internshipreviews;
	}

	public Internshipreview addInternshipreview(Internshipreview internshipreview) {
		getInternshipreviews().add(internshipreview);
		internshipreview.setTrainee(this);

		return internshipreview;
	}

	public Internshipreview removeInternshipreview(Internshipreview internshipreview) {
		getInternshipreviews().remove(internshipreview);
		internshipreview.setTrainee(null);

		return internshipreview;
	}

	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setTrainee(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setTrainee(null);

		return location;
	}

	public List<Match> getMatches() {
		return this.matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public Match addMatch(Match match) {
		getMatches().add(match);
		match.setTrainee(this);

		return match;
	}

	public Match removeMatch(Match match) {
		getMatches().remove(match);
		match.setTrainee(null);

		return match;
	}

	public List<Tagdistribution> getTagdistributions() {
		return this.tagdistributions;
	}

	public void setTagdistributions(List<Tagdistribution> tagdistributions) {
		this.tagdistributions = tagdistributions;
	}

	public Tagdistribution addTagdistribution(Tagdistribution tagdistribution) {
		getTagdistributions().add(tagdistribution);
		tagdistribution.setTrainee(this);

		return tagdistribution;
	}

	public Tagdistribution removeTagdistribution(Tagdistribution tagdistribution) {
		getTagdistributions().remove(tagdistribution);
		tagdistribution.setTrainee(null);

		return tagdistribution;
	}

	public Userconnect getUserconnect() {
		return this.userconnect;
	}

	public void setUserconnect(Userconnect userconnect) {
		this.userconnect = userconnect;
	}

}