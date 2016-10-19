package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tag database table.
 * 
 */
@Entity
@Table(name="tag")
@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TAG_IDTAG_GENERATOR", sequenceName="TAG_IDTAG_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TAG_IDTAG_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer idtag;

	@Column(length=255)
	private String content;

	//bi-directional many-to-one association to Tagdistribution
	@OneToMany(mappedBy="tag")
	private List<Tagdistribution> tagdistributions;

	public Tag() {
	}

	public Integer getIdtag() {
		return this.idtag;
	}

	public void setIdtag(Integer idtag) {
		this.idtag = idtag;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Tagdistribution> getTagdistributions() {
		return this.tagdistributions;
	}

	public void setTagdistributions(List<Tagdistribution> tagdistributions) {
		this.tagdistributions = tagdistributions;
	}

	public Tagdistribution addTagdistribution(Tagdistribution tagdistribution) {
		getTagdistributions().add(tagdistribution);
		tagdistribution.setTag(this);

		return tagdistribution;
	}

	public Tagdistribution removeTagdistribution(Tagdistribution tagdistribution) {
		getTagdistributions().remove(tagdistribution);
		tagdistribution.setTag(null);

		return tagdistribution;
	}

}