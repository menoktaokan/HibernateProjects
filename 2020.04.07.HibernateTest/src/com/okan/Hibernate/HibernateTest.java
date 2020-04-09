package com.okan.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.okan.entity.Department;
import com.okan.entity.Jobs;

public class HibernateTest {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
				// .configure("hibernate-config.xml") //hibernate.cfg.xml olarak adlandırılırsak
				// kodda belirtmeye gerek kalmaz
				.addAnnotatedClass(Jobs.class).buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();

		Jobs jobs = new Jobs("TEST", "TEST MÜH", 3000, 5000);

		Jobs job1 = new Jobs("TEST");

		session.beginTransaction();
		session.save(jobs);
		session.getTransaction().commit();
		session.close();

	}
}
