package com.okan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.okan.entity.Antrenor;
import com.okan.entity.Futbolcu;
import com.okan.entity.Takim;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml") // hibernate.cfg.xml olarak
																							// adlandırılırsak kodda
																							// belirtmeye gerek kalmaz
				.addAnnotatedClass(Futbolcu.class).addAnnotatedClass(Takim.class).addAnnotatedClass(Antrenor.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		try {
//			Antrenor a = new Antrenor("Şota Arvaletzi");
//			Takim t = new Takim("Değirmen Spor", a);
//			Futbolcu f = new Futbolcu("Hasan Şaş", null);
			
			session.beginTransaction();
			Futbolcu f= session.get(Futbolcu.class, 1);
			System.out.println(f);
//			session.save(a);
			session.getTransaction().commit();
		} finally {
			session.close();
		}

	}
}
