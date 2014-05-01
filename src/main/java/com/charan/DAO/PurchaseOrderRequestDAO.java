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
import com.charan.Business.UserAccount;

@Repository
public class PurchaseOrderRequestDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void persist(PurchaseOrderRequest purchaseOrderRequest){
		Session session = sessionFactory.openSession();
		session.save(purchaseOrderRequest);
		session.close();
	}
	
	
	
	public void update(PurchaseOrderRequest purchaseOrderRequest){
		
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.merge(purchaseOrderRequest);
		tx.commit();
		session.close();
		
	}
	
	@Transactional
	public PurchaseOrderRequest findPurchaseOrderRequestById(int id){
		Session session = sessionFactory.openSession();
		PurchaseOrderRequest purchaseOrderRequest = (PurchaseOrderRequest) session.get(PurchaseOrderRequest.class, id);
		session.close();
		return purchaseOrderRequest;
	}
	
}
