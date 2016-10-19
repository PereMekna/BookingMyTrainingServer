package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the employeecompany database table.
 * 
 */
@Embeddable
public class EmployeeCompanyPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=true, updatable=false, unique=true, nullable=false)
	private Integer idemployee;

	@Column(insertable=true, updatable=false, unique=true, nullable=false)
	private Integer idcompany;

	public EmployeeCompanyPK() {
	}
	public Integer getIdemployee() {
		return this.idemployee;
	}
	public void setIdemployee(Integer idemployee) {
		this.idemployee = idemployee;
	}
	public Integer getIdcompany() {
		return this.idcompany;
	}
	public void setIdcompany(Integer idcompany) {
		this.idcompany = idcompany;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EmployeeCompanyPK)) {
			return false;
		}
		EmployeeCompanyPK castOther = (EmployeeCompanyPK)other;
		return 
			this.idemployee.equals(castOther.idemployee)
			&& this.idcompany.equals(castOther.idcompany);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idemployee.hashCode();
		hash = hash * prime + this.idcompany.hashCode();
		
		return hash;
	}
}