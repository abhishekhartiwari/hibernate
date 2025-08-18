package com.abhi.secondlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelCache {

	public static void main(String[] args) {

		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session1 = sf.openSession();
		Student student1 = session1.get(Student.class, 22);
		System.out.println(student1);
		session1.close();
		
		Session session2 = sf.openSession();
		Student student2 = session2.get(Student.class, 22);
		System.out.println(student2);
		session2.close();
		
		
		
		sf.close();

	}

}
