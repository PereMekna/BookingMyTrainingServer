package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the companyreview database table.
 * 
 */
@Embeddable
public class CompanyReviewPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=true, updatable=false, unique=true, nullable=false)
	private Integer idcompany;

	@Column(insertable=true, updatable=false, unique=true, nullable=false)
	private Integer idtrainee;

	public CompanyReviewPK() {
	}
	public Integer getIdcompany() {
		return this.idcompany;
	}
	public void setIdcompany(Integer idcompany) {
		this.idcompany = idcompany;
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
		if (!(other instanceof CompanyReviewPK)) {
			return false;
		}
		CompanyReviewPK castOther = (CompanyReviewPK)other;
		return 
			this.idcompany.equals(castOther.idcompany)
			&& this.idtrainee.equals(castOther.idtrainee);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idcompany.hashCode();
		hash = hash * prime + this.idtrainee.hashCode();
		
		return hash;
	}
}
