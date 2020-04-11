package com.okan.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.okan.entity.Antrenor;
import com.okan.entity.Futbolcular;
import com.okan.entity.Takim;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml") // hibernate.cfg.xml olarak
																							// adlandırılırsak kodda
																							// belirtmeye gerek kalmaz
				.addAnnotatedClass(Futbolcular.class)
				.addAnnotatedClass(Takim.class)
				.addAnnotatedClass(Antrenor.class)
				.buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		try {
			session.beginTransaction();
			Takim t = session.get(Takim.class, 4);
			Antrenor a = session.get(Antrenor.class, 6);
			
			a.setTakim(t);
//			Futbolcular f = new Futbolcular("Hasan Şaş", null);
			
			
//			Antrenor a2 =session.get(Antrenor.class, 1);
//			System.out.println(a);
//			
//			Takim t2 = session.get(Takim.class, 1);
//			System.out.println(t);
//			
//			Futbolcular f2=session.get(Futbolcular.class, 1);
//			System.out.println(f);
			
//			t.add(f);
			session.save(t);
			
			session.getTransaction().commit();
		} finally {
			session.close();
		}

	}
}
