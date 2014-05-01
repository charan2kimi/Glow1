package com.charan.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.charan.Business.Location;
import com.charan.Business.UserAccount;

@Repository
public class LocationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void persist(Location location){
		Session session = sessionFactory.openSession();
		session.save(location);
		session.close();
	}
}
