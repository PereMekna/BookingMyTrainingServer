package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@Table(name="location")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer idlocation;

	private Integer idtrainee;

	private double lat;

	private double longi;

	private double radius;

	public Location() {
	}

	public Integer getIdlocation() {
		return this.idlocation;
	}

	public void setIdlocation(Integer idlocation) {
		this.idlocation = idlocation;
	}

	public Integer getIdtrainee() {
		return this.idtrainee;
	}

	public void setIdtrainee(Integer idtrainee) {
		this.idtrainee = idtrainee;
	}

	public double getLat() {
		return this.lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLongi() {
		return this.longi;
	}

	public void setLongi(double longi) {
		this.longi = longi;
	}

	public double getRadius() {
		return this.radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

}