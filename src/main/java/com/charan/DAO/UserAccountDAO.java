package com.charan.DAO;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charan.Business.Enterprise;
import com.charan.Business.UserAccount;
import com.charan.Business.UserAccount;

@Repository
public class UserAccountDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void persist(UserAccount userAccount){
		Session session = sessionFactory.openSession();
		session.save(userAccount);
		session.close();
	}
	
	
	@Transactional
	public void update(UserAccount userAccount){
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(userAccount);
		tx.commit();
		session.close();
	}
	
	@Transactional
	public UserAccount findUserAccountById(int id){
		Session session = sessionFactory.openSession();
		UserAccount userAccount = (UserAccount) session.get(UserAccount.class, id);
		session.close();
		return userAccount;
	}
	
	@Transactional
	public UserAccount findUserAccountByUsername(String userName){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM UserAccount WHERE username = :username");
		query.setParameter("username", userName);
		List<UserAccount> l = query.list();
		session.close();
		return l.get(0);
	}
	
	@Transactional
	public UserAccount findUserAccountByEnterprise(int id){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM UserAccount WHERE Enterprise_id = :enterpriseid");
		query.setParameter("enterpriseid", id);
		List<UserAccount> l = query.list();
		session.close();
		return l.get(0);
	}
}
