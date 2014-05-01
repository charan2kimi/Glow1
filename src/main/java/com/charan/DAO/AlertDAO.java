package com.charan.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.charan.Business.Alert;

@Repository
public class AlertDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void persist(Alert alert){
		Session session = sessionFactory.openSession();
		session.save(alert);
		session.close();
	}
	
	
	@Transactional
	public void update(Alert alert){
		Session session = sessionFactory.openSession();
		session.update(alert);
		session.close();
	}
	
	@Transactional
	public Alert findAlertById(int id){
		Session session = sessionFactory.openSession();
		Alert alert = (Alert) session.get(Alert.class, id);
		session.close();
		return alert;
	}
}
