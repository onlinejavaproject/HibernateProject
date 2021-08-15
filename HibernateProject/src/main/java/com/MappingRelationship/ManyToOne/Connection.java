package com.MappingRelationship.ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Connection {

	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Akshay Kumar");
		
		Laptop lp1 = new Laptop();
		lp1.setId(101);
		lp1.setBrand("HP");
		
		Laptop lp2 = new Laptop();
		lp2.setId(102);
		lp2.setBrand("Dell");
		
		lp1.setEmployee(emp);
		lp2.setEmployee(emp);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Laptop.class); 
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(emp);
		session.save(lp1);
		session.save(lp2);
		
		tx.commit();
	}
}
