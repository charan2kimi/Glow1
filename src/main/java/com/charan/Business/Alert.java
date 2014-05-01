package com.charan.Business;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
public class Alert {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="package_id")
	@JsonBackReference
	private DrugPackage drugPackage;

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
	
	
	
}
