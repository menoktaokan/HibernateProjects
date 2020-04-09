package com.okan.Hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.okan.entity.Department;
import com.okan.entity.Jobs;

public class HibernateQuery {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml") // hibernate.cfg.xml olarak
																							// adlandırılırsak kodda
																							// belirtmeye gerek kalmaz
				.addAnnotatedClass(Department.class).buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		// HQL: Hibernate Query Language
		// Buradaki isimlendirme tablo ve kolon adına göre değil, class ce değişken
		// adına göre yapılacak
		List<Department> depts = session.createQuery("from Departments where LOCATION_ID = 1700").getResultList();

		for (Department departments : depts) {
			System.out.println(departments.getName());
		}
		session.getTransaction().commit();
	}
}
