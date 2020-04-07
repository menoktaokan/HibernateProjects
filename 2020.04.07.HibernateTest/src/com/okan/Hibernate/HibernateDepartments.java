package com.okan.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.okan.entity.Departments;
import com.okan.entity.Jobs;

public class HibernateDepartments {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml") //hibernate.cfg.xml olarak adlandırılırsak kodda belirtmeye gerek kalmaz
				.addAnnotatedClass(Departments.class).buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();

		Departments dept1 = new Departments("Okan", 100, 1000);

		session.beginTransaction();
		session.save(dept1);
		session.getTransaction().commit();
		session.close();

	}
}
