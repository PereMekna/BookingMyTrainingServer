package fr.epsi.arras.chocolait.bookingmytraining.server.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userconnect database table.
 * 
 */
@Entity
@Table(name="userconnect")
@NamedQuery(name="UserConnect.findAll", query="SELECT u FROM UserConnect u")
public class UserConnect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERCONNECT_IDUSERCONNECT_GENERATOR", sequenceName="USERCONNECT_IDUSERCONNECT_SEQ", initialValue=1000, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERCONNECT_IDUSERCONNECT_GENERATOR")
	@Column(unique=true, nullable=false)
	private Integer iduserconnect;

	@Column(length=255)
	private String apikey;

	@Column(length=255)
	private String hashpwd;

	@Column(length=255)
	private String mail;

	public UserConnect() {
	}

	public Integer getIduserconnect() {
		return this.iduserconnect;
	}

	public void setIduserconnect(Integer iduserconnect) {
		this.iduserconnect = iduserconnect;
	}

	public String getApikey() {
		return this.apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getHashpwd() {
		return this.hashpwd;
	}

	public void setHashpwd(String hashpwd) {
		this.hashpwd = hashpwd;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}