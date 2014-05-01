package com.charan.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.charan.Business.PurchaseOrderRequest;
import com.charan.Business.ShippingRequest;
import com.charan.Business.UserAccount;

@Repository
public class ShippingRequestDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void persist(ShippingRequest shippingRequest){
		Session session = sessionFactory.openSession();
		session.save(shippingRequest);
		session.close();
	}
	
	
	
	public void update(ShippingRequest shippingRequest){
		
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.merge(shippingRequest);
		tx.commit();
		session.close();
		
	}
	
	@Transactional
	public ShippingRequest findShippingRequestById(int id){
		Session session = sessionFactory.openSession();
		ShippingRequest shippingRequest = (ShippingRequest) session.get(ShippingRequest.class, id);
		session.close();
		return shippingRequest;
	}
	
}
