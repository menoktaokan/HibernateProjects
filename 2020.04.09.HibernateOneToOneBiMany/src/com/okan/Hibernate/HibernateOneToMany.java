package com.okan.Hibernate;

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
		
		Ogretmen ogr = session.get(Ogretmen.class, 19);
		
		System.out.println("öğretmen: "+ogr);
		//System.out.println("ilk hali: " +ogr.getKurslar());
		
		Kurs k = ogr.getKurslar().get(0);
		ogr.getKurslar().remove(0);
		session.remove(k);
		
		//System.out.println("son hali: "+ogr.getKurslar());
		
		Kurs k2= ogr.getKurslar().get(0);
//		ogr.getKurslar().get(1).setAd("WEB");
		k2.setAd("WEB232");
		
		session.save(k2);
		
		session.save(ogr);
		
		session.getTransaction().commit();
		session.close();
		
	}
}
