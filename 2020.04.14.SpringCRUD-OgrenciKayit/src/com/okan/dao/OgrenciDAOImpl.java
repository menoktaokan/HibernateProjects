package com.okan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.okan.domain.Ogrenci;

@Repository //@Component gibi davranıyor ama daha üst özellikler de içeriyor
public class OgrenciDAOImpl implements OgrenciDAO {

	@Autowired // Bean canlandırmak için
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<Ogrenci> getOgrenciler() {

		Session session = sessionFactory.getCurrentSession();
		
//		session.beginTransaction();
		
		Query <Ogrenci> query = session.createQuery("from Ogrenci where durum=1", Ogrenci.class);
		List<Ogrenci> resultList=query.getResultList();
		
		
//		session.getTransaction().commit();
		
		return resultList;
	}
	@Transactional
	@Override
	public void saveOgrenci(Ogrenci ogr) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ogr);
		
	}
	@Transactional
	@Override
	public Ogrenci getOgrenci(int ogrId) {

		Session session = sessionFactory.getCurrentSession();
		Ogrenci ogr = session.get(Ogrenci.class, ogrId);

		return ogr;
	}
	@Transactional
	@Override
	public void deleteOgrenci(int ogrId) {
		Session session = sessionFactory.getCurrentSession();
		
		session.createQuery("update Ogrenci set durum=0 where id="+ogrId).executeUpdate();
		
	}

}
