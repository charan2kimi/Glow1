package com.charan.Business;

import java.awt.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	String fName;
	String lName;
	String dob;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="location_id")
	@JsonManagedReference
    private Location location;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="person")
	@JsonManagedReference
	private java.util.List<UserAccount> userAccountList;
	
	
	
	public java.util.List<UserAccount> getUserAccountList() {
		return userAccountList;
	}
	public void setUserAccountList(java.util.List<UserAccount> userAccountList) {
		this.userAccountList = userAccountList;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
}
