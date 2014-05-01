/**
 * 
 */
package com.charan.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charan.Business.Drug;
import com.charan.Business.Enterprise;

/**
 * @author Charan
 *
 */
@Repository
public class DrugDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void persist(Drug drug){
		Session session = sessionFactory.openSession();
		session.save(drug);
		session.close();
	}
	
	@Transactional
	public void update(Drug drug){
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(drug);
		tx.commit();
		session.close();
	}
	
	@Transactional
	public Drug findDrugById(int id){
		Session session = sessionFactory.openSession();
		Drug drug = (Drug) session.get(Drug.class, id);
		session.close();
		return drug;
	}

	@Transactional
	public List<Drug> findDrugByEnterprise(int id){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Drug WHERE Enterprise_id = :id");
		query.setParameter("id", id);
		List<Drug> drugList = query.list();
		List<Drug> drugList2=new ArrayList<Drug>();
		for(Drug d:drugList){
			if(d.getStatus().equals("Licensed")){
				drugList2.add(d);
			}
		}
		Hibernate.initialize(drugList2);
		session.close();
		return drugList;
	}
	@Transactional
	public List<Drug> findAllDrugs(){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Drug WHERE status LIKE :status");
		query.setParameter("status", "Licensed");
		List<Drug> drugList = query.list();
		
		
		session.close();
		return drugList;
	}

}
