package com.okan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.okan.domain.Kurs;

@Repository
public class KursDAOImpl implements KursDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<Kurs> getKurslar() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Kurs> query = session.createQuery("from Kurs", Kurs.class);
		List<Kurs> resultList = query.getResultList();
		
		return resultList;
	}

	@Transactional
	@Override
	public void saveKurs(Kurs kurs) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(kurs);
	}

	@Transactional
	@Override
	public Kurs getKurs(int kursId) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Kurs.class, kursId);
	}

	@Transactional
	@Override
	public void deleteKurs(int kursId) {
		Session session = sessionFactory.getCurrentSession();
		Kurs kurs =session.get(Kurs.class, kursId);
		session.delete(kurs);
	}

}
