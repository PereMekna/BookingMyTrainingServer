package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the internshipreview database table.
 * 
 */
@Embeddable
public class InternshipReviewPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=true, updatable=false, unique=true, nullable=false)
	private Integer idtrainee;

	@Column(insertable=true, updatable=false, unique=true, nullable=false)
	private Integer idinternshipoffer;

	public InternshipReviewPK() {
	}
	public Integer getIdtrainee() {
		return this.idtrainee;
	}
	public void setIdtrainee(Integer idtrainee) {
		this.idtrainee = idtrainee;
	}
	public Integer getIdinternshipoffer() {
		return this.idinternshipoffer;
	}
	public void setIdinternshipoffer(Integer idinternshipoffer) {
		this.idinternshipoffer = idinternshipoffer;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InternshipReviewPK)) {
			return false;
		}
		InternshipReviewPK castOther = (InternshipReviewPK)other;
		return 
			this.idtrainee.equals(castOther.idtrainee)
			&& this.idinternshipoffer.equals(castOther.idinternshipoffer);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idtrainee.hashCode();
		hash = hash * prime + this.idinternshipoffer.hashCode();
		
		return hash;
	}
}