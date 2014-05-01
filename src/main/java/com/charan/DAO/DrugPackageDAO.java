/**
 * 
 */
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

/**
 * @author Charan
 *
 */
@Repository
public class DrugPackageDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void persist(DrugPackage drugPackage){
		Session session = sessionFactory.openSession();
		session.merge(drugPackage);
		session.close();
	}
	
	@Transactional
	public void update(DrugPackage drugPackage){
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.merge(drugPackage);
		tx.commit();
		session.close();
	}
	
	@Transactional
	public DrugPackage findDrugPackageById(int id){
		Session session = sessionFactory.openSession();
		DrugPackage drugPackage = (DrugPackage) session.get(DrugPackage.class, id);
		session.close();
		return drugPackage;
	}
	@Transactional
	public List<DrugPackage> findDrugPackageByOrder(int id){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM DrugPackage WHERE drugOrder_id = :orderid");
		query.setParameter("orderid", id);
		List<DrugPackage> l = query.list();
		session.close();
		return l;
	}
	@Transactional
	public List<DrugPackage> findDrugPackageByDrug(int id){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM DrugPackage WHERE drug_id = :orderid");
		query.setParameter("orderid", id);
		List<DrugPackage> l = query.list();
		session.close();
		return l;
	}
	@Transactional
	public List<DrugPackage> findDrugPackageByOwner(int id){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM DrugPackage WHERE UserAccount_id = :uid");
		query.setParameter("uid", id);
		List<DrugPackage> l = query.list();
		session.close();
		return l;
	}
	@Transactional
	public List<DrugPackage> findSuspectedDrugPackages(){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM DrugPackage WHERE status = :status");
		query.setParameter("status", "Suspected");
		List<DrugPackage> l = query.list();
		session.close();
		return l;
	}
	@Transactional
	public List<DrugPackage> findConfisticatedDrugPackages(){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM DrugPackage WHERE status = :status");
		query.setParameter("status", "Confisticated");
		List<DrugPackage> l = query.list();
		session.close();
		return l;
	}
	@Transactional
	public List<DrugPackage> findCoounterfeitDrugPackages(){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM DrugPackage WHERE status = :status");
		query.setParameter("status", "Counterfeit");
		List<DrugPackage> l = query.list();
		session.close();
		return l;
	}
	@Transactional
	public void removePackage(int id){
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String hql = "delete from DrugPackage WHERE id= :id";
		session.createQuery(hql).setInteger("id", id).executeUpdate();
		tx.commit();
		session.close();
		
	}
}
