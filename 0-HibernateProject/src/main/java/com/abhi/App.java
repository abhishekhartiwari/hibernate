package com.abhi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// SessionFactory factory = new
		// Configuration().configure().buildSessionFactory();
		// OR
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student st = new Student();
		st.setId(102);
		st.setName("Mayank");
		st.setCity("Panji");
		System.out.println(st);

		Address ad = new Address();
		try (FileInputStream fis = new FileInputStream("src/main/java/Passport.jpg")) {
			byte[] data = new byte[fis.available()];
			fis.read(data);

		
			ad.setStreet("Pan");
			ad.setCity("Mumbai");
			ad.setDate(new Date());
			ad.setTemp(10.0);
			ad.setImage(data);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Session currentSession = factory.openSession();
		Transaction tx = currentSession.beginTransaction();
		currentSession.save(st);
		currentSession.save(ad);
		tx.commit();

		currentSession.close();

	}
}
