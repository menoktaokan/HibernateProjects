package com.okan.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.okan.domain.Departments;
import com.okan.domain.Employee;
import com.okan.domain.Jobs;
import com.okan.service.EmployeeService;
import com.okan.service.KullaniciServisi;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	KullaniciServisi kullaniciServisi;
	
	@GetMapping("/list")
	public String listEmployee(Model model) {
//		if(!kullaniciServisi.kullaniciVarMı())
//			return "redirect:/";
		List<Employee> employeeList = employeeService.listEmployees();
		model.addAttribute("employeeList", employeeList);
		model.addAttribute("employeeSearch", new Employee());
		return "employee-list";
	}
	
	@GetMapping("/employee-ekle")
	public String employeeEkle(Model model) {
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		return "employee-form";
	}
	
	@PostMapping("/employee-kaydet")
	public String employeeKaydet(@Valid @ModelAttribute("employee") Employee employee, BindingResult br, Model model) {
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		
		Jobs job=employeeService.getJob(employee.getJob().getJobId());
		if(employee.getSalary()<job.getMinSalary()) {
		br.rejectValue("salary", "error.emplooye", "Minimum maaştan("+job.getMinSalary()+") düşük olamaz!");
		}
		if(employee.getSalary()>job.getMaxSalary()) {
			br.rejectValue("salary", "error.emplooye", "Maximum maaştan("+job.getMaxSalary()+") yüksek olamaz!");
			}
		if(br.hasErrors())
			return "employee-form";
		employeeService.saveEmployee(employee);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("employee-update")
	public String employeeGuncelle(@RequestParam("employeId") int empId, Model model) {
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		
		Employee employee = employeeService.getEmployee(empId);
		model.addAttribute(employee);
		
		return "employee-form";
	}
	
	@GetMapping("employee-delete")
	public String employeeDelete(@RequestParam("employeId") int empId) {
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		employeeService.deleteEmployee(empId);
		
		return "redirect:/employee/list";
	}
	
	/*
	@ModelAttribute("employeeList")
	public List<Employee> getEmployees() {
		List<Employee> employee = employeeService.listEmployees();
		return employee;
	}
	*/
	
	@ModelAttribute("departments")
	public Map<Integer, String> getDepartments(){
		List<Departments> depts=employeeService.listDepartments();
		 Map<Integer, String> getDepartments = new HashMap<Integer, String>();
		 for (Departments departments : depts) {
			 getDepartments.put(departments.getDepartmentid(), departments.getDepartmantName());
		}
		return getDepartments;
	}
	
	@ModelAttribute("jobs")
	public List<String> getJobss(){
		List<Jobs> jobs=employeeService.listJobs();
		List<String> jobIds=new ArrayList<String>();
//		 Map<String, String> getJobs = new HashMap<String, String>();
		 for (Jobs job : jobs) {
			 jobIds.add(job.getJobId());
		}
		return jobIds;
	}
	
	@ModelAttribute("manager")
	public Map<Integer,Employee> listManager() {

		Map<Integer, Employee> manager= new HashMap<Integer, Employee>();
		
		List<Employee> managerList = employeeService.listEmployees();
		for (Employee employee : managerList) {
			manager.put(employee.getId(), employee);
		}

		return manager;
	}
	
	@PostMapping("/employee-ara")
	public String searchEmployee(Model model, @ModelAttribute("employeeSearch") Employee employee) {
		if(!kullaniciServisi.kullaniciVarMı())
			return "redirect:/";
		List<Employee> searchEmp=employeeService.searchEmployee(employee);
		model.addAttribute("employeeList", searchEmp);
		return "employee-list";
	}
}