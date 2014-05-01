package com.charan.Business;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class PurchaseOrderRequest extends WorkRequest{

	
	
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="drugOrder_id")
	@JsonManagedReference
    private DrugOrder drugOrder;

	

	public DrugOrder getOrder() {
		return drugOrder;
	}

	public void setOrder(DrugOrder drugOrder) {
		this.drugOrder = drugOrder;
	}
	
	
}
