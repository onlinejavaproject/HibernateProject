package com.Get_vs_Load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.BasicNotations.Student;

public class FetchRecord {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class); 
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		session.beginTransaction();
		//Get
		Student stu = session.get(Student.class, 6);//it will hit the database whether it stu used or not
		
		//Load
		Student stu1 = session.load(Student.class, 8); //it will not hit database until stu1 not used
		System.out.print(stu1); //it will hit the database because we used object
		
		session.getTransaction().commit();
		session.close();
	}
}
