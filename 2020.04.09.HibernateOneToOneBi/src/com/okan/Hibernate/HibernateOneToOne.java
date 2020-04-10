package com.okan.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.okan.entity.Ogretmen;
import com.okan.entity.OgretmenDetay;

public class HibernateOneToOne {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml") //hibernate.cfg.xml olarak adlandırılırsak kodda belirtmeye gerek kalmaz
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		OgretmenDetay ogrDty = session.get(OgretmenDetay.class, 4);
		
		System.out.println(ogrDty);
		System.out.println(ogrDty.getOgretmen());
		
		session.delete(ogrDty);
		session.getTransaction().commit();
		session.close();
		/*
		session.beginTransaction();
		session.save(ogrDty);

		session.getTransaction().commit();
		session.close();
 	*/
	}
}
