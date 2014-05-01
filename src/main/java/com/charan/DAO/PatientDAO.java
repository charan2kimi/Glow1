package com.charan.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charan.Business.Patient;


@Repository
public class PatientDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void persist(Patient person){
		Session session = sessionFactory.openSession();
		
		session.save(person);
		session.close();
	}

}
