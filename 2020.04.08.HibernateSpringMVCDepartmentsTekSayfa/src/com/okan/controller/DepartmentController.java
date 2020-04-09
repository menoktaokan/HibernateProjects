package com.okan.controller;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.okan.entity.Department;

@Controller
public class DepartmentController {

	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Department.class).buildSessionFactory();
	Session session = sessionFactory.getCurrentSession();
//	static int id;

	@RequestMapping("/")
	public String mainPage(Model model) {
//		id=Integer.parseInt(req.getParameter("id"));
//		session.beginTransaction();
//		Department depts = (Department) session.createQuery("from Department where id = "+id);
//		
		model.addAttribute("dept", new Department());

		return "main-page";
	}

	@RequestMapping("/search")
	public String sayfa2(Model model, @Valid @ModelAttribute("dept") Department dept, BindingResult br) {
		System.out.println(br);
		System.out.println(dept.toString());
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Department.class).buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

//	        session.createQuery("from Departments where locationid="+dept.getId()).getResultList();
		dept = session.get(Department.class, dept.getId());
//		id=dept.getId();
		session.getTransaction().commit();
		session.close();

		model.addAttribute("dept", dept);
		if (br.hasErrors())
			return "main-page";
		return "main-page";
	}

	@RequestMapping("/update")
	public String sayfa3(Model model, @Valid @ModelAttribute("dept") Department dept, BindingResult br) {
		System.out.println(br);
		System.out.println(dept.toString());
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		if (dept.getId() != null && dept.getName() != null && dept.getManagerId() != null
				&& dept.getLocationId() != null && dept.getId() > 0 && dept.getManagerId() > 0
				&& dept.getLocationId() > 0)
			session.createQuery("update Department set name='" + dept.getName() + "', managerId=" + dept.getManagerId()
					+ ", locationId=" + dept.getLocationId() + " where id=" + dept.getId()).executeUpdate();

		session.getTransaction().commit();

		model.addAttribute("dept", dept);

		if (br.hasErrors())
			return "main-page";
		return "main-page";
	}

}
