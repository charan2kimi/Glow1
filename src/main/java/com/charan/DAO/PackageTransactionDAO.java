package com.charan.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charan.Business.DrugPackage;
import com.charan.Business.PackageTransaction;
import com.charan.Business.PackageTransaction;

@Repository
public class PackageTransactionDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void persist(PackageTransaction packageTransaction){
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.merge(packageTransaction);
		tx.commit();
		session.close();
	}
	
	
	@Transactional
	public void update(PackageTransaction packageTransaction){
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(packageTransaction);
		tx.commit();
		session.close();
	}
	
	@Transactional
	public PackageTransaction findPackageTransactionById(int id){
		Session session = sessionFactory.openSession();
		PackageTransaction packageTransaction = (PackageTransaction) session.get(PackageTransaction.class, id);
		session.close();
		return packageTransaction;
	}

	@Transactional
	public void removeTransaction(int id){
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql = "delete from PackageTransaction WHERE id= :id";
		session.createQuery(hql).setInteger("id", id).executeUpdate();
		tx.commit();
		session.close();
		
	}
	
	@Transactional
	public List<PackageTransaction> findPackageTransactionByPackageHistory(int id){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM PackageTransaction WHERE packageHistory_id = :id");
		query.setParameter("id", id);
		List<PackageTransaction> l = query.list();
		session.close();
		return l;
	}
}
