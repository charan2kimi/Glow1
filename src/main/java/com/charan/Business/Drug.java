package com.charan.Business;

import java.util.ArrayList;
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
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Drug {

	
	
	public Drug() {
		status="Licensed";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String name;
	private String compound;
	private int life;
	private String weight;
	private String dosage;
	private String status;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="drug")
	@JsonIgnore
	private List<OrderItem> orderItems;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="drug")
	@JsonIgnore
	private java.util.List<DrugPackage> packageList;
	
	@ManyToOne
	@JoinColumn(name="Enterprise_id")
	private Enterprise manufacturer;
	
	
	public Enterprise getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Enterprise manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompound() {
		return compound;
	}
	public void setCompound(String compound) {
		this.compound = compound;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public java.util.List<DrugPackage> getPackageList() {
		return packageList;
	}
	public void setPackageList(java.util.List<DrugPackage> packageList) {
		this.packageList = packageList;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	
}
