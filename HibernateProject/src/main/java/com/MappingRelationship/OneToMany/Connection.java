package com.MappingRelationship.OneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Connection {

	public static void main(String[] args) {
		
		Laptop lp1 = new Laptop();
		lp1.setId(101);
		lp1.setBrand("HP");
		
		Laptop lp2 = new Laptop();
		lp2.setId(102);
		lp2.setBrand("Dell");
		
		Employee emp1 = new Employee();
		emp1.setId(1);
		emp1.setName("Akshay Kumar");
		
		emp1.getList().add(lp1);
		emp1.getList().add(lp2);
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Laptop.class); 
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(emp1);
		session.save(lp1);
		session.save(lp2);
		
		tx.commit();
	}
}
