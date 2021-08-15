package com.MappingRelationship.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Connection {

	public static void main(String[] args) {
		
		Laptop lp = new Laptop();
		lp.setId(101);
		lp.setBrand("HP");
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Akshay Kumar");
		
		emp.setLp(lp);
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Laptop.class); 
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(emp);
		session.save(lp);
		
		tx.commit();
	}
}
