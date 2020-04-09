package com.okan.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.okan.entity.Ogretmen;
import com.okan.entity.OgretmenDetay;

public class HibernateOneToOneDelete {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml") //hibernate.cfg.xml olarak adlandırılırsak kodda belirtmeye gerek kalmaz
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		

		session.beginTransaction();
		Ogretmen ogr = session.get(Ogretmen.class, 6);
		session.delete(ogr);

		session.getTransaction().commit();
		session.close();
 
	}
}
