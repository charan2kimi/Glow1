package com.charan.Business;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
public class DrugPackage {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="drugPackage")
	@JsonManagedReference 
	private PackageHistory packageHistory;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="drugPackage")
	@JsonManagedReference 
	private Alert alert;
	
	private Date dateOfManufacuring;
	private Date dateOfExpiry;

	@ManyToOne
    @JoinColumn(name="drug_id")
	//@JsonBackReference
	private Drug drug;
	
	@ManyToOne
    @JoinColumn(name="UserAccount_id")
	@JsonBackReference
	private UserAccount owner;
	
	@ManyToOne
    @JoinColumn(name="drugOrder_id")
	private DrugOrder drugOrder;

	private String status;
	
	
	
	public DrugOrder getDrugOrder() {
		return drugOrder;
	}

	public void setDrugOrder(DrugOrder drugOrder) {
		this.drugOrder = drugOrder;
	}

	public PackageHistory getPackageHistory() {
		return packageHistory;
	}

	public void setPackageHistory(PackageHistory packageHistory) {
		this.packageHistory = packageHistory;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfManufacuring() {
		return dateOfManufacuring;
	}

	public void setDateOfManufacuring(Date dateOfManufacuring) {
		this.dateOfManufacuring = dateOfManufacuring;
	}

	public Date getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(Date dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public UserAccount getOwner() {
		return owner;
	}

	public void setOwner(UserAccount owner) {
		this.owner = owner;
	}

	public Alert getAlert() {
		return alert;
	}

	public void setAlert(Alert alert) {
		this.alert = alert;
	}
	
	
	
	
	
}
