package com.okan.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.okan.entity.Kurs;
import com.okan.entity.Ogrenci;
import com.okan.entity.Ogretmen;
import com.okan.entity.OgretmenDetay;

public class HibernateManyToMany {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml") // hibernate.cfg.xml olarak
																							// adlandırılırsak kodda
																							// belirtmeye gerek kalmaz
				.addAnnotatedClass(Ogretmen.class).addAnnotatedClass(OgretmenDetay.class).addAnnotatedClass(Kurs.class)
				.addAnnotatedClass(Ogrenci.class).buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
//		Ogrenci ogrenci3 = new Ogrenci("deniz", "gürler", 113);
//		Ogrenci ogrenci4 = new Ogrenci("furkan", "kızıl", 114);
		
		Ogrenci ogrenci1 = session.get(Ogrenci.class, 5);
		Ogrenci ogrenci2 = session.get(Ogrenci.class, 6);
		Kurs kurs =session.get(Kurs.class, 22);
		
		ogrenci1.addKurs(kurs);
		ogrenci2.addKurs(kurs);
		
		session.save(ogrenci1);
		session.save(ogrenci2);
		
//		session.save(kurs);
		

		session.getTransaction().commit();
		session.close();
		
		//Not: save kurs yapınca ilişki tablosunu doldurmadı. Önce öğrenci oluşturdum, sonra kursu kaydettim, en son da öğrencileri kaydettim.

	}
}