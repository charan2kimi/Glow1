package com.charan.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charan.Business.Employee;

@Repository
public class EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void persist(Employee emp){
		Session session = sessionFactory.openSession();
		
		session.save(emp);
		session.close();
	
	}

	@Transactional
	public Employee findEmployeeById(int id){
		Session session = sessionFactory.openSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		session.close();
		return employee;
	}
	
	@Transactional
	public List<Employee> findEmployeeByEnterprise(String enterprise){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Employee WHERE Enterprise_id = :enterprise");
		query.setParameter("enterprise", enterprise);
		List<Employee> l = query.list();
		session.close();
		return l;
	}
	
}
