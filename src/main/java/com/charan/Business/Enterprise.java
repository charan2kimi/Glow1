package com.charan.Business;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
public class Enterprise {

	
	public Enterprise() {
		employeeList=new ArrayList<Employee>();
		userList=new ArrayList<UserAccount>();
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String enterpriseName;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="enterprise")
	@JsonIgnore
	private java.util.List<UserAccount> userList;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="enterprise")
	@JsonIgnore
	private java.util.List<Employee> employeeList;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="manufacturer")
	@JsonIgnore
	private java.util.List<Drug> drugList;
	
	
	private String type;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="location_id")
	@JsonManagedReference
    private Location location;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="enterprise")
	@JsonIgnore
	private java.util.List<PackageHistory> historyList;
	
	private String status;
	
	
	
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public java.util.List<UserAccount> getUserList() {
		return userList;
	}

	public void setUserList(java.util.List<UserAccount> userList) {
		this.userList = userList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public java.util.List<Employee> getEmployeeList() {
		return employeeList;
	}
	
	

	public void setEmployeeList(java.util.List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public java.util.List<Drug> getDrugList() {
		return drugList;
	}

	public void setDrugList(java.util.List<Drug> drugList) {
		this.drugList = drugList;
	}

	public java.util.List<PackageHistory> getHistoryList() {
		return historyList;
	}

	public void setHistoryList(java.util.List<PackageHistory> historyList) {
		this.historyList = historyList;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	
	
	
}

