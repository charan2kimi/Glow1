package com.charan.Business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class WorkRequest {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String message;
	private String status;
	
	private String dateRequested;
	private String dateResolved;
	
	@ManyToOne
	@JoinColumn(name="Sender_id")
	@JsonBackReference
	private UserAccount sender;
	
	@ManyToOne
	@JoinColumn(name="Receiver_id")
	@JsonBackReference
	private UserAccount receiver;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDateRequested() {
		return dateRequested;
	}

	public void setDateRequested(String dateRequested) {
		this.dateRequested = dateRequested;
	}

	public String getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(String dateResolved) {
		this.dateResolved = dateResolved;
	}

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
	
	
}
