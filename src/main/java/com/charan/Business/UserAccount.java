package com.charan.Business;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ManyToAny;
import org.springframework.web.bind.annotation.Mapping;



@Entity
public class UserAccount {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	String username;
	String password;
	
	@ManyToOne
	@JoinColumn(name="Person_id")
	@JsonBackReference
	private Person person;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="owner")
	@JsonManagedReference
	private java.util.List<DrugPackage> inventoryList;
	
	@ManyToOne
	@JoinColumn(name="Enterprise_id")
	@JsonBackReference
	private Enterprise enterprise;
	
	
	private String role;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="receiver")
	@JsonManagedReference
	private List<WorkRequest> workQueue;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="sender")
	
	@JsonManagedReference
	private List<WorkRequest> sentWorkQueue;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="sender")
	@JsonManagedReference
	private List<PackageTransaction> sentTransactionList;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="receiver")
	@JsonManagedReference
	private List<PackageTransaction> receivedTransactionList;
	
	
	
	/*
	 * public static enum RoleName {     
	 
        Pharmacist {
            @Override
            public String toString() {
                return "Pharmacist";
            }
        },
        Admin {
            @Override
            public String toString() {
                return "Admin";
            }
        },
        Distributor {
            @Override
            public String toString() {
                return "Distributor";
            }
        },
        Manufacturer {
            @Override
            public String toString() {
                return "Manufacturer";
            }
        },
        LogisticsProvider {
            @Override
            public String toString() {
                return "Logistics Provider";
            }
        },
        Patient {
            @Override
            public String toString() {
                return "Patient";
            }
        },
        }
	
	*/
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Enterprise getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	public java.util.List<DrugPackage> getInventoryList() {
		return inventoryList;
	}
	public void setInventoryList(java.util.List<DrugPackage> inventoryList) {
		this.inventoryList = inventoryList;
	}
	public List<WorkRequest> getWorkQueue() {
		return workQueue;
	}
	public void setWorkQueue(List<WorkRequest> workQueue) {
		this.workQueue = workQueue;
	}
	public List<WorkRequest> getSentWorkQueue() {
		return sentWorkQueue;
	}
	public void setSentWorkQueue(List<WorkRequest> sentWorkQueue) {
		this.sentWorkQueue = sentWorkQueue;
	}
	public List<PackageTransaction> getSentTransactionList() {
		return sentTransactionList;
	}
	public void setSentTransactionList(List<PackageTransaction> sentTransactionList) {
		this.sentTransactionList = sentTransactionList;
	}
	public List<PackageTransaction> getReceivedTransactionList() {
		return receivedTransactionList;
	}
	public void setReceivedTransactionList(
			List<PackageTransaction> receivedTransactionList) {
		this.receivedTransactionList = receivedTransactionList;
	}
	
	public String toString(){
		return username;
	}
}
