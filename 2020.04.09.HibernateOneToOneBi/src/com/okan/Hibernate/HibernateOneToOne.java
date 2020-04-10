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
		
		OgretmenDetay ogrDty = new OgretmenDetay("java", "sinema", "yok8.com", "/menoktaokan");

		Ogretmen ogr = new Ogretmen(ogrDty, "Okan", "YILMAZ", "okan8@yilmaz.com");

		session.beginTransaction();
		session.save(ogr);

		session.getTransaction().commit();
		session.close();
 
	}
}
