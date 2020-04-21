package com.okan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.okan.domain.Departments;
import com.okan.domain.Employee;
import com.okan.domain.Jobs;
import com.okan.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listEmployee(Model model) {
		
		return "employee-list";
	}
	
	@GetMapping("/employee-ekle")
	public String employeeEkle(Model model) {
		Employee employee = new Employee();
		System.out.println(employee);
		model.addAttribute("employee", employee);
		return "employee-form";
	}
	
	@PostMapping("/employee-kaydet")
	public String employeeKaydet(@ModelAttribute("employee") Employee employee) {
		System.out.println("\n\n\n");
		System.out.println(employee);
		System.out.println("\n\n\n");
		return "redirect:/employee/list";
	}
	
	@GetMapping("/employee-delete")
	public String epmloyeeSil(@RequestParam("employeId") int empId) {
		
	
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("employee-update")
	public String employeeGuncelle(@RequestParam("employeId") int empId, Model model) {
		Employee employee = employeeService.getEmployee(empId);
		System.out.println(employee);
		model.addAttribute(employee);
		return "employee-form";
	}
	
	@ModelAttribute("employeeList")
	public List<Employee> getEmployees() {
		List<Employee> employee = employeeService.listEmployees();
		return employee;
	}
	
	@ModelAttribute("department")
	public Map<Integer, String> getDepartments(){
		List<Departments> depts=employeeService.listDepartments();
		 Map<Integer, String> getDepartments = new HashMap<Integer, String>();
		 for (Departments departments : depts) {
			 getDepartments.put(departments.getDepartmentid(), departments.getDepartmantName());
		}
		return getDepartments;
	}
	
	@ModelAttribute("job")
	public Map<String,String> getJobss(){
		List<Jobs> jobs=employeeService.listJobs();
		
		 Map<String, String> getJobs = new HashMap<String, String>();
		 for (Jobs job : jobs) {
			 getJobs.put(job.getJobId(), job.getJobId());
		}
		return getJobs;
	}
	
	@ModelAttribute("manager")
	public Map<Integer,String> listManager() {

		Map<Integer, String> manager= new HashMap<Integer, String>();
		
		List<Employee> managerList = employeeService.listEmployees();
		for (Employee employee : managerList) {
			manager.put(employee.getId(), employee.getName());
		}

		return manager;
	}
	
}