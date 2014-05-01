package com.charan.Business;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;



@Entity
@PrimaryKeyJoinColumn(name="id")
public class Patient extends Person {
	
	
	
}