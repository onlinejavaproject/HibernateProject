package com.MappingRelationship.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {

	public static void main(String[] args) {
		
		Project pro1 = new Project();
		pro1.setId(11);
		pro1.setName("Airline Reservation");
		
		Project pro2 = new Project();
		pro2.setId(21);
		pro2.setName("Shopping Website");
		
		Employee employee1 = new Employee();
		employee1.setId(11);
		employee1.setName("Ram");
		
		Employee employee2 = new Employee();
		employee2.setId(21);
		employee2.setName("Shyam");
		
		employee1.getProject().add(pro1);
		employee2.getProject().add(pro1);
		employee1.getProject().add(pro2);
		
		pro1.getEmployee().add(employee1);
		pro2.getEmployee().add(employee1);
		pro1.getEmployee().add(employee2);
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Project.class); 
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		session.save(pro1);
		session.save(pro2);
		session.save(employee1);
		session.save(employee2);
		
		/*
		 * Eager fetching result 
		*/
		Employee emp = (Employee)session.get(Employee.class, 1);
		System.out.println(emp.getName());
		
		session.getTransaction().commit();
		session.close();
	}
}
