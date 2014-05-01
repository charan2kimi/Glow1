package com.charan.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charan.Business.PackageHistory;
import com.charan.Business.PackageHistory;

@Repository
public class PackageHistoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void persist(PackageHistory packageHistory){
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.merge(packageHistory);
		tx.commit();
		session.close();
	}
	
	
	@Transactional
	public void update(PackageHistory packageHistory){
		Session session = sessionFactory.openSession();
		session.update(packageHistory);
		session.close();
		
	}
	@Transactional
	public void removeHistory(int id){
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql = "delete from PackageHistory WHERE id= :id";
		session.createQuery(hql).setInteger("id", id).executeUpdate();
		tx.commit();
		session.close();
		
	}
	
	@Transactional
	public PackageHistory findPackageHistoryById(int id){
		Session session = sessionFactory.openSession();
		PackageHistory packageHistory = (PackageHistory) session.get(PackageHistory.class, id);
		session.close();
		return packageHistory;
	}
}
