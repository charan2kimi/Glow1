/**
 * 
 */
package com.charan.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charan.Business.Enterprise;
import com.charan.Business.UserAccount;

/**
 * @author Charan
 *
 */
@Repository
public class EnterpriseDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void persist(Enterprise enterprise){
		Session session = sessionFactory.openSession();
		session.save(enterprise);
		session.close();
	}
	
	@Transactional
	public void update(Enterprise enterprise){
		Session session = sessionFactory.openSession();
		session.update(enterprise);
		session.close();
	}
	
	@Transactional
	public Enterprise findEnterpriseById(int id){
		Session session = sessionFactory.openSession();
		Enterprise enterprise = (Enterprise) session.get(Enterprise.class, id);
		session.close();
		return enterprise;
	}

	@Transactional
	public List<Enterprise> findEnterpriseListByType(String type){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Enterprise WHERE type = :type");
		query.setParameter("type", type);
		List<Enterprise> enterpriseList = query.list();
		session.close();
		return enterpriseList;
	}

}
