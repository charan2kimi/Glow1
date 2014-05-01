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

import com.charan.Business.PurchaseOrderRequest;
import com.charan.Business.WorkRequest;;

/**
 * @author Charan
 *
 */
@Repository
public class WorkRequestDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void persist(WorkRequest workRequest){
		Session session = sessionFactory.openSession();
		session.save(workRequest);
		session.close();
	}
	
	@Transactional
	public void update(WorkRequest workRequest){
		Session session = sessionFactory.openSession();
		session.update(workRequest);
		session.close();
	}
	
	@Transactional
	public WorkRequest findWorkRequestById(int id){
		Session session = sessionFactory.openSession();
		WorkRequest workRequest = (WorkRequest) session.get(WorkRequest.class, id);
		session.close();
		return workRequest;
	}

	@Transactional
	public List<WorkRequest> findWorkRequestByReceiver(int id){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM WorkRequest WHERE Receiver_id = :userid");
		query.setParameter("userid", id);
		List<WorkRequest> l = query.list();
		session.close();
		return l;
	}
	
}
