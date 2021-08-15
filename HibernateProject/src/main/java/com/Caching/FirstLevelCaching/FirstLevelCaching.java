package com.Caching.FirstLevelCaching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.MappingRelationship.OneToOne.Employee;
import com.MappingRelationship.OneToOne.Laptop;

public class FirstLevelCaching {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Laptop.class); 
		SessionFactory sf = con.buildSessionFactory();
		
		Session session1 = sf.openSession();
		session1.beginTransaction();
		
		Employee emp = (Employee)session1.get(Employee.class, 1);
		System.out.println(emp.getName());
		
		//if we fetch the same record again it will not hit database, fetch data from Cache
		Employee emp1 = (Employee)session1.get(Employee.class, 1);
		System.out.print(emp1.getName());
		
		session1.getTransaction().commit();
		session1.close();
	}
}
