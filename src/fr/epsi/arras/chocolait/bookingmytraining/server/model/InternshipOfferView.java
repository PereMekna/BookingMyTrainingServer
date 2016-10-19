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
@NamedQuery(name="Internshipofferview.findAll", query="SELECT i FROM InternshipOfferView i")
public class InternshipOfferView implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InternshipOfferViewPK id;

	@Temporal(TemporalType.DATE)
	@Column(insertable=false)
	private Date dateview;

	public InternshipOfferView() {
	}

	public InternshipOfferViewPK getId() {
		return this.id;
	}

	public void setId(InternshipOfferViewPK id) {
		this.id = id;
	}

	public Date getDateview() {
		return this.dateview;
	}

	public void setDateview(Date dateview) {
		this.dateview = dateview;
	}

}
