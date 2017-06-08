package com.cognizant.controller;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.entity.Employee;
import com.cognizant.entity.Increment;
import com.cognizant.exception.ApplicationException;
import com.cognizant.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	private List<Employee> employees;
	
	@RequestMapping(value="/employee", method=RequestMethod.GET)
//	public String getEmployee(@ModelAttribute("employee") Employee employee){
		public String getEmployee(Model model){
		
		model.addAttribute("employee", new Employee());

		return "employee";
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String saveOrUpdateEmployee(
		@ModelAttribute("employee") @Valid Employee employee,
		BindingResult result, 
		Model model) {
		
		System.out.println(employee);
		employees = new ArrayList<Employee>();	
		employees.add(employee);
		
//		EmployeeValidator validator = new EmployeeValidator();
		
//		 Set<ConstraintViolation<Object>> constraintViolations = validator.validate(employee, result);
		 
		        

		
//		new EmployeeValidator().validate(employee, result);
		try {
			service.addEmployees(employees);
		} 
		catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
			Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
			while(iterator.hasNext()){
				ConstraintViolation<?> next = iterator.next();
				System.out.println("Validation message: "+next.getMessage());
				System.out.println("Invalid field: "+next.getPropertyPath());
				System.out.println("Validation class/bean: "+next.getRootBean());
//				 result.reject(next.getPropertyPath(), next.getMessage());
				result.rejectValue(next.getPropertyPath().toString(), "", next.getMessage());
//				result.rejectValue(arg0, arg1, arg2);
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("m1", employee.getName());

		if (result.hasErrors()) {
			return "employee";
		} 
		
		return "member";

	}
	
	
	@RequestMapping(value="/employees",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  List<Employee> getEmployees(@RequestParam("name") String name){
		
		Employee emp1 = new Employee(name, 34344.44);
		Employee emp2 = new Employee("Priya", 35455.00);
		employees = new ArrayList<Employee>();
		employees.add(emp1);
		employees.add(emp2);
		return employees;
	}
	

	
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addMember(@RequestParam("name") String name, Model model){
		employees = new ArrayList<Employee>();	
		Employee emp = new Employee(name, 3434.2);
		employees.add(emp);
		try {
			service.addEmployees(employees);
			model.addAttribute("m1", name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "member";
	}
	
	
//	http://localhost:8080/BaseCodeSlice_BankManagementSystem/mvc/increment?id=4
		@RequestMapping(value="/increment", method=RequestMethod.GET)
	public String salaryIncrement(@RequestParam("id") int id, Model model) throws Exception{
		
		try {
			Employee emp = service.incrementSalary(id, 5555.55);
			model.addAttribute("emp", emp); 
		} catch (NullPointerException e) {
			throw new ApplicationException("Employee with id "+id+" is not found in our database", e);
		} catch (Exception e) {
			throw new ApplicationException(e);
		}
//		employees = new ArrayList<>();	
//		Employee emp = new Employee(name, 3434.2);
//		employees.add(emp);
//		try {
//			service.addEmployees(employees);
//			model.addAttribute("m1", name);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return "salaryInc";
	}
	
		
//		http://localhost:8080/BaseCodeSlice_MyAssessmentApplication/mvc/incrementList?id=2
		@ResponseBody
		@RequestMapping(value="/incrementList", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Increment> incrementList(@RequestParam("id") int id) throws Exception{
			
			List<Increment> incrementList = null;
			try {
//				incrementList = service.incrementList(id);
				
				incrementList = new ArrayList<Increment>();
				incrementList.add(new Increment(new Employee(101, "Carl", 123.12), 11.01));
				incrementList.add(new Increment(new Employee(102, "Mark", 123.12), 15.01));
			} catch (NullPointerException e) {
				throw new ApplicationException("Employee with id "+id+" is not found in our database", e);
			} catch (Exception e) {
				throw new ApplicationException(e);
			}

			return incrementList;
		}
	

}
