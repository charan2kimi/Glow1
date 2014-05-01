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
public class PackageTransaction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="senderUA_id")
	@JsonBackReference
	private UserAccount sender;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="receiverUA_id")
	@JsonBackReference
	private UserAccount receiver;

	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="packageHistory_id")
	private PackageHistory packageHistory;

	public UserAccount getSender() {
		return sender;
	}

	public void setSender(UserAccount sender) {
		this.sender = sender;
	}

	public UserAccount getReceiver() {
		return receiver;
	}

	public void setReceiver(UserAccount receiver) {
		this.receiver = receiver;
	}

	public PackageHistory getPackageHistory() {
		return packageHistory;
	}

	public void setPackageHistory(PackageHistory packageHistory) {
		this.packageHistory = packageHistory;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
