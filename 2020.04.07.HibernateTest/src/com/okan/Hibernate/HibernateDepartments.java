package com.okan.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.okan.entity.Department;
import com.okan.entity.Jobs;

public class HibernateDepartments {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml") //hibernate.cfg.xml olarak adlandırılırsak kodda belirtmeye gerek kalmaz
				.addAnnotatedClass(Department.class).buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();

		Department dept1 = new Department("Okan3", 100, 1000);

		session.beginTransaction();
		session.save(dept1);

		session.getTransaction().commit();
		session.close();
 
	}
}
