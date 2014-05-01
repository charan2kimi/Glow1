package com.charan.Business;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class DrugOrder {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	String tempColumn;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="drugOrder")
	@JsonIgnore
	private java.util.List<OrderItem> orderItems;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="drugOrder")
	@JsonIgnore
	private java.util.List<DrugPackage> packageList;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="drugOrder")
	@JsonBackReference
	private PurchaseOrderRequest purchaseOrderRequest;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="drugOrder")
	@JsonBackReference
	private ShippingRequest shippingRequest;

	public int getId() {
		return id;
	}

	public ShippingRequest getShippingRequest() {
		return shippingRequest;
	}

	
	
	public java.util.List<DrugPackage> getPackageList() {
		return packageList;
	}

	public void setPackageList(java.util.List<DrugPackage> packageList) {
		this.packageList = packageList;
	}

	public void setShippingRequest(ShippingRequest shippingRequest) {
		this.shippingRequest = shippingRequest;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(java.util.List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public PurchaseOrderRequest getPurchaseOrderRequest() {
		return purchaseOrderRequest;
	}

	public void setPurchaseOrderRequest(PurchaseOrderRequest purchaseOrderRequest) {
		this.purchaseOrderRequest = purchaseOrderRequest;
	}

	public String getTempColumn() {
		return tempColumn;
	}

	public void setTempColumn(String tempColumn) {
		this.tempColumn = tempColumn;
	}

	
}
