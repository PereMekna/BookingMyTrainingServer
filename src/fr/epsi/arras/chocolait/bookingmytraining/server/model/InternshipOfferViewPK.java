package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the internshipofferview database table.
 * 
 */
@Embeddable
public class InternshipOfferViewPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(updatable=true, unique=true, nullable=false)
	private Integer idinternshipoffer;

	@Column(updatable=true, unique=true, nullable=false)
	private Integer idtrainee;

	public InternshipOfferViewPK() {
	}
	public Integer getIdinternshipoffer() {
		return this.idinternshipoffer;
	}
	public void setIdinternshipoffer(Integer idinternshipoffer) {
		this.idinternshipoffer = idinternshipoffer;
	}
	public Integer getIdtrainee() {
		return this.idtrainee;
	}
	public void setIdtrainee(Integer idtrainee) {
		this.idtrainee = idtrainee;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InternshipOfferViewPK)) {
			return false;
		}
		InternshipOfferViewPK castOther = (InternshipOfferViewPK)other;
		return 
			this.idinternshipoffer.equals(castOther.idinternshipoffer)
			&& this.idtrainee.equals(castOther.idtrainee);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idinternshipoffer.hashCode();
		hash = hash * prime + this.idtrainee.hashCode();
		
		return hash;
	}
}
