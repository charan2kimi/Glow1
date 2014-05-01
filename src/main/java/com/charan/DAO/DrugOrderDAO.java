package com.charan.DAO;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.charan.Business.DrugOrder;

@Repository
public class DrugOrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void persist(DrugOrder drugOrder){
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.merge(drugOrder);
		tx.commit();
		session.close();
	}
	
	
	@Transactional
	public void update(DrugOrder drugOrder){
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.merge(drugOrder);
		tx.commit();
		session.close();
		
	}
	
	@Transactional
	public DrugOrder findOrderById(int id){
		Session session = sessionFactory.openSession();
		DrugOrder drugOrder = (DrugOrder) session.get(DrugOrder.class, id);
		session.close();
		return drugOrder;
	}
}
