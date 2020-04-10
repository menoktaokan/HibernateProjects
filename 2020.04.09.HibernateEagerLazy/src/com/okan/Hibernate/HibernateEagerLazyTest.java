package com.okan.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.okan.entity.Kurs;
import com.okan.entity.Ogretmen;
import com.okan.entity.OgretmenDetay;

public class HibernateEagerLazyTest {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml") //hibernate.cfg.xml olarak adlandırılırsak kodda belirtmeye gerek kalmaz
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.addAnnotatedClass(Kurs.class)
				.buildSessionFactory();
		// create session
		
		/*
		Ogretmen ogr = new Ogretmen(null, "Ömer", "Karakaş", "omer@karakaş.com");
		Ogretmen ogr2 = new Ogretmen(null, "Fethi", "Sen", "fethi@sen.com");
		
		OgretmenDetay odty= new OgretmenDetay("Java", "Sinema", "www.omer.com", "/omer");
		OgretmenDetay odty2= new OgretmenDetay("WEB", "Kitap", "www.fety.com", "/fety");
		ogr.setOgretmenDetay(odty);
		ogr2.setOgretmenDetay(odty2);
		
		
		ogr.add(new Kurs("Java Kursu", 600, ogr));
		ogr.add(new Kurs("DB Kursu", 300, null));
		ogr.add(new Kurs("WEB Kursu", 150, null));
		
		ogr2.add(new Kurs("Java2 Kursu", 600, ogr2));
		ogr2.add(new Kurs("WEB CONS. Kursu", 800, null));
		ogr2.add(new Kurs("Yzılımla Alakalı Bir Şey", 450, null));
		
		session.save(ogr);
		session.save(ogr2);
		*/
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		Ogretmen fethi = session.get(Ogretmen.class, 27);
		
		System.out.println(fethi);
		System.out.println(fethi.getKurslar());
		session.getTransaction().commit();
		session.close();
		
		
		
	}
}
