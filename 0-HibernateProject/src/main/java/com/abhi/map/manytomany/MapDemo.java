package com.abhi.map.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		
		emp1.setEid(11);
		emp1.setName("Ram");
		
		emp2.setEid(22);
		emp2.setName("Shyam");
		
		Project p1 = new Project();
		Project p2 = new Project();
		
		p1.setPid(101);
		p1.setProjectName("Library Management");
		
		p2.setPid(112);
		p2.setProjectName("Chatbot");
		
		List<Employee> empList = new ArrayList<>();
		List<Project> proList = new ArrayList<>();
		
		empList.add(emp1);
		empList.add(emp2);
		
		proList.add(p1);
		proList.add(p2);
		
		emp1.setProjects(proList);
		p2.setEmployees(empList);
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(emp1);
		session.save(emp2);
		session.save(p1);
		session.save(p2);
		transaction.commit();
		sf.close();
		session.close();
		
	}
}
