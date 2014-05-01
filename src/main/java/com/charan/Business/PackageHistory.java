package com.charan.Business;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class PackageHistory {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="drugPackage_id")
	@JsonBackReference
	private DrugPackage drugPackage;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="enterprise_id")
	@JsonBackReference
	private Enterprise enterprise;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="packageHistory")
	@JsonIgnore
	private List<PackageTransaction> transactionList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DrugPackage getDrugPackage() {
		return drugPackage;
	}

	public void setDrugPackage(DrugPackage drugPackage) {
		this.drugPackage = drugPackage;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public List<PackageTransaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<PackageTransaction> transactionList) {
		this.transactionList = transactionList;
	}
	
	
}
