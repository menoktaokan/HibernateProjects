package com.okan.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.okan.entity.Kurs;
import com.okan.entity.Ogretmen;
import com.okan.entity.OgretmenDetay;

public class HibernateOneToMany {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml") //hibernate.cfg.xml olarak adlandırılırsak kodda belirtmeye gerek kalmaz
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.addAnnotatedClass(Kurs.class)
				.buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Ogretmen o= session.get(Ogretmen.class, 7);
		List<Kurs> kurslar = new ArrayList<Kurs>();
		kurslar= session.createQuery("from Kurs where ogretmen_id=7").list();
		kursOgretmenNull(kurslar);
		
		session.delete(o);
		session.getTransaction().commit();
		session.close();
		
	}

	private static void kursOgretmenNull(List<Kurs> kurslar) {
		for (Kurs kurs : kurslar) {
			kurs.setOgretmen(null);
		}
	}
}
