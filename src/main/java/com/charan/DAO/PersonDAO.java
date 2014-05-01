package com.charan.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charan.Business.Enterprise;
import com.charan.Business.Person;;

@Repository
public class PersonDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void persist(Person person){
		Session session = sessionFactory.openSession();
		
		session.save(person);
		session.close();
	}
	
	@Transactional
	public Person findPersonById(int id){
		Session session = sessionFactory.openSession();
		Person person = (Person) session.get(Person.class, id);
		session.close();
		return person;
	}

}
