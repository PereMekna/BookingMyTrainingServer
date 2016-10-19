package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tagdistribution database table.
 * 
 */
@Entity
@Table(name="tagdistribution")
@NamedQuery(name="Tagdistribution.findAll", query="SELECT t FROM TagDistribution t")
public class TagDistribution implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TagDistributionPK id;

	public TagDistribution() {
	}

	public TagDistributionPK getId() {
		return this.id;
	}

	public void setId(TagDistributionPK id) {
		this.id = id;
	}

}
