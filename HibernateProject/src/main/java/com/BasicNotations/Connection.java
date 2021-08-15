package com.BasicNotations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Connection {
	
	public static void main(String[] args) {
        
		Embeddable_Notation_Use obj = new Embeddable_Notation_Use();
		
		obj.setfName("Alok");
		obj.setlName("Kumar");
		obj.setmName("Prajapati");
		
		Student std = new Student();
		std.setId(2);
		std.setName(obj);
		std.setAddress("UP");
		std.setCourse("MCA");
		
		Student std1 = null;
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class); 
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		/*
		 * insert data into database
		 */
		session.save(std);
		
		
		/*
		 * fetching data
		 */
		std1 = (Student)session.get(Student.class, 1);
		
		tx.commit();
		
		System.out.println(std1);
    }
}
