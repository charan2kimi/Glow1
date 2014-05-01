package com.charan.Business;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.codehaus.jackson.annotate.JsonBackReference;


@Entity
@PrimaryKeyJoinColumn(name="id")
public class Employee extends Person {

	
	@ManyToOne
	@JoinColumn(name="Enterprise_id")
	@JsonBackReference
	private Enterprise enterprise;

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}
	
	
}
