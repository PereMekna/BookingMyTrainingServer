package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the internshipoffer database table.
 * 
 */
@Entity
@Table(name="internshipoffer")
@NamedQuery(name="Internshipoffer.findAll", query="SELECT i FROM Internshipoffer i")
public class Internshipoffer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INTERNSHIPOFFER_IDINTERNSHIPOFFER_GENERATOR", sequenceName="INTERNSHIPOFFER_IDINTERNSHIPOFFER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INTERNSHIPOFFER_IDINTERNSHIPOFFER_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idinternshipoffer;

	@Column(length=255)
	private String address;

	@Column(length=255)
	private String description;

	private Boolean finished;

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

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="idemployee")
	private Employee employee;

	//bi-directional many-to-one association to Internshipofferview
	@OneToMany(mappedBy="internshipoffer")
	private List<Internshipofferview> internshipofferviews;

	//bi-directional many-to-one association to Internshipreview
	@OneToMany(mappedBy="internshipoffer")
	private List<Internshipreview> internshipreviews;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="internshipoffer")
	private List<Match> matches;

	//bi-directional many-to-one association to Tagdistribution
	@OneToMany(mappedBy="internshipoffer")
	private List<Tagdistribution> tagdistributions;

	public Internshipoffer() {
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

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Internshipofferview> getInternshipofferviews() {
		return this.internshipofferviews;
	}

	public void setInternshipofferviews(List<Internshipofferview> internshipofferviews) {
		this.internshipofferviews = internshipofferviews;
	}

	public Internshipofferview addInternshipofferview(Internshipofferview internshipofferview) {
		getInternshipofferviews().add(internshipofferview);
		internshipofferview.setInternshipoffer(this);

		return internshipofferview;
	}

	public Internshipofferview removeInternshipofferview(Internshipofferview internshipofferview) {
		getInternshipofferviews().remove(internshipofferview);
		internshipofferview.setInternshipoffer(null);

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
		internshipreview.setInternshipoffer(this);

		return internshipreview;
	}

	public Internshipreview removeInternshipreview(Internshipreview internshipreview) {
		getInternshipreviews().remove(internshipreview);
		internshipreview.setInternshipoffer(null);

		return internshipreview;
	}

	public List<Match> getMatches() {
		return this.matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public Match addMatch(Match match) {
		getMatches().add(match);
		match.setInternshipoffer(this);

		return match;
	}

	public Match removeMatch(Match match) {
		getMatches().remove(match);
		match.setInternshipoffer(null);

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
		tagdistribution.setInternshipoffer(this);

		return tagdistribution;
	}

	public Tagdistribution removeTagdistribution(Tagdistribution tagdistribution) {
		getTagdistributions().remove(tagdistribution);
		tagdistribution.setInternshipoffer(null);

		return tagdistribution;
	}

}