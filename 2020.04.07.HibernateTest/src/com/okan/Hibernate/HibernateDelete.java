package com.okan.Hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.okan.entity.Department;
import com.okan.entity.Jobs;

public class HibernateDelete {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml") // hibernate.cfg.xml olarak
																							// adlandırılırsak kodda
																							// belirtmeye gerek kalmaz
				.addAnnotatedClass(Department.class).buildSessionFactory();
		// create session
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		//Primary key olan id üzerinden yapabiliyoruz
		Department dept = session.get(Department.class, 281);
		
		session.delete(dept); 
		
		session.getTransaction().commit();
		
		/*
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		
		//Primary key olan id üzerinden yapabiliyoruz
		session.createQuery("delete Department where id=301").executeUpdate();
		
		session.getTransaction().commit();
		*/
	}
}
