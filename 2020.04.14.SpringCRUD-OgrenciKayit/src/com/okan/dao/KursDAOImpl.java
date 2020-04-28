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
		
		List<Kurs> resultList = session.createQuery("from Kurs where durum=1", Kurs.class).getResultList();
		
		return resultList;
	}

	@Transactional
	@Override
	public void saveKurs(Kurs kurs) {
		
		Session session = sessionFactory.getCurrentSession();
		kurs.setAd(kurs.getAd().toUpperCase());
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
		session.createQuery("update Kurs set durum=0 where id="+kursId).executeUpdate();
	}

	@Transactional
	@Override
	public List<Kurs>  searchKurs(Kurs kursAra) {
		String kriter ="from Kurs where durum=1 ";
		if(kursAra.getId()!=null)
			kriter=kriter+"and id="+kursAra.getId()+" ";
		
		
		if(kursAra.getAd()!=null)
			kriter=kriter+"and ad like '%"+kursAra.getAd().toUpperCase()+"%' ";
		
		if(kursAra.getSaat()!=null)
			kriter+="and saat="+kursAra.getSaat();
		
		if(kursAra.getOgretmen().getId()!=null)
			kriter+="and ogretmen="+kursAra.getOgretmen().getId();
		
		System.out.println(kriter);
		Session session = sessionFactory.getCurrentSession();
		List<Kurs> resultList=session.createQuery(kriter, Kurs.class).getResultList();
		return resultList;
	}

}
