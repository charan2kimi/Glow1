package com.charan.Business;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonBackReference;


@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="drug_id")
	private Drug drug;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="drugOrder_id")
	private DrugOrder drugOrder;
	
	private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public DrugOrder getOrder() {
		return drugOrder;
	}

	public void setOrder(DrugOrder drugOrder) {
		this.drugOrder = drugOrder;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
