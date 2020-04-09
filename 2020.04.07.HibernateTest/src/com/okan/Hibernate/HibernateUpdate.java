package com.okan.Hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.okan.entity.Department;
import com.okan.entity.Jobs;

public class HibernateUpdate {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml") // hibernate.cfg.xml olarak
																							// adlandırılırsak kodda
																							// belirtmeye gerek kalmaz
				.addAnnotatedClass(Department.class).buildSessionFactory();
		// create session
		
		/*Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		//Primary key olan id üzerinden yapabiliyoruz
		Department dept = session.get(Department.class, 20);
		
		dept.setDEPARTMENT_NAME("Marketing");
		
		session.getTransaction().commit();
		*/
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		
		//Primary key olan id üzerinden yapabiliyoruz
		session.createQuery("update Department set name='Marketing' where id=20").executeUpdate();
		
		session.getTransaction().commit();
	}
}
