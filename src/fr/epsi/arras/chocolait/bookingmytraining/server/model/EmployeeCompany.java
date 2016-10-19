package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the employeecompany database table.
 * 
 */
@Entity
@Table(name="employeecompany")
@NamedQuery(name="Employeecompany.findAll", query="SELECT e FROM EmployeeCompany e")
public class EmployeeCompany implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EmployeeCompanyPK id;

	public EmployeeCompany() {
	}

	public EmployeeCompanyPK getId() {
		return this.id;
	}

	public void setId(EmployeeCompanyPK id) {
		this.id = id;
	}

}