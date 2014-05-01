package com.charan.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.charan.Business.OrderItem;
import com.charan.Business.UserAccount;

@Repository
public class OrderItemDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void persist(OrderItem orderItem){
		
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.merge(orderItem);
		tx.commit();
		session.close();
	}
	
	
	@Transactional
	public void update(OrderItem orderItem){
		Session session = sessionFactory.openSession();
		session.update(orderItem);
		session.close();
		
	}
	
	@Transactional
	public OrderItem findOrderItemById(int id){
		Session session = sessionFactory.openSession();
		OrderItem orderItem = (OrderItem) session.get(OrderItem.class, id);
		session.close();
		return orderItem;
	}
	@Transactional
	public List<OrderItem> findOrderItemByOrder(int id){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM OrderItem WHERE drugOrder_id = :orderid");
		query.setParameter("orderid", id);
		List<OrderItem> l = query.list();
		session.close();
		return l;
	}
}
