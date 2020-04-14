package com.okan.control;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.okan.entity.Kurs;
import com.okan.entity.Ogretmen;
import com.okan.entity.OgretmenDetay;

@Controller
public class OgretmenController {
	

	@RequestMapping("/")
	public String anasayfa(Model m) {
		Ogretmen ogr = new Ogretmen();
		Kurs k = new Kurs();
		m.addAttribute("ogr", ogr);
		m.addAttribute("kurs", k);

		System.out.println(ogr.toString());
		System.out.println(k.toString());
		return "anasayfa";
	}

	@RequestMapping("/ogretmenAra")
	public String ogretmenAra(Model m, @Valid @ModelAttribute("ogr") Ogretmen ogr, BindingResult br) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class).addAnnotatedClass(OgretmenDetay.class).addAnnotatedClass(Kurs.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		ogr = session.get(Ogretmen.class, ogr.getId());

		List<OgretmenDetay> od = session.createQuery("from OgretmenDetay where id= " + ogr.getOgretmenDetayId()).list();
		OgretmenDetay oDty = od.get(0);
		m.addAttribute("ogrDty", oDty);
		m.addAttribute("ogr", ogr);

		session.getTransaction().commit();
		session.close();
		return "ogretmen";
	}

	@RequestMapping("/ogretmenGunelle")
	public String updateOgretmen(Model model, @ModelAttribute("ogr") Ogretmen ogr) {
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Kurs.class)
				.addAnnotatedClass(Ogretmen.class).addAnnotatedClass(OgretmenDetay.class).buildSessionFactory();

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.createQuery("update Ogretmen set ad ='"+ogr.getAd()+"', soyad ='"+ogr.getSoyad()+"', eposta ='"+ogr.getEposta()+"'  where id ="+ogr.getId()).executeUpdate();
		
		
		session.getTransaction().commit();
		session.close();
		model.addAttribute("ogr",ogr);
	
		return "ogretmen";
	}

	@RequestMapping("/ogretmenDtyGunelle")
	public String ogretmenDtyGunelle(Model m, @Valid @ModelAttribute("ogrDty") OgretmenDetay ogrDty, BindingResult br) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class).addAnnotatedClass(OgretmenDetay.class).addAnnotatedClass(Kurs.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.createQuery("update Ogretmen set uzmanlik='" + ogrDty.getUzmanlik() + "', hobiler='"
				+ ogrDty.getHobiler() + "', webSite='" + ogrDty.getWebSite() + "', fbSayfasi='" + ogrDty.getFbSayfasi()
				+ "' where id=" + ogrDty.getId()).executeUpdate();

		Ogretmen ogr = session.get(Ogretmen.class, ogrDty.getOgretmen().getId());

		m.addAttribute("ogr", ogr);
		m.addAttribute("ogrDty", ogrDty);

		session.getTransaction().commit();
		session.close();
		return "ogretmen";
	}

	@RequestMapping("/kursAra")
	public String kursAra(Model m, @Valid @ModelAttribute("kurs") Kurs kurs, BindingResult br) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class).addAnnotatedClass(OgretmenDetay.class).addAnnotatedClass(Kurs.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		kurs = session.get(Kurs.class, kurs.getId());
//		Ogretmen o= session.get(Ogretmen.class, kurs.getOgretmen().getId());
		session.getTransaction().commit();
		session.close();
		System.out.println(kurs.toString());
		m.addAttribute("kurs", kurs);
		m.addAttribute("ogr", kurs.getOgretmen());
		System.out.println(kurs.getOgretmen().toString());
		return "kurs";
	}

	@RequestMapping("/kursGuncelle")
	public String kursGuncelle(Model m, @Valid @ModelAttribute("kurs") Kurs kurs, BindingResult br) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class).addAnnotatedClass(OgretmenDetay.class).addAnnotatedClass(Kurs.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		if (kurs.getAd() != null && kurs.getSaat() != null)
			session.createQuery(
					"update Kurs set ad='" + kurs.getAd() + "', saat=" + kurs.getSaat() + " where id=" + kurs.getId())
					.executeUpdate();

		m.addAttribute("kurs", kurs);

		session.getTransaction().commit();
		session.close();
		System.out.println(kurs.toString());
		return "kurs";
	}

	@RequestMapping("/anasayfa")
	public String anasayfa() {

		return "anasayfa";
	}

}
