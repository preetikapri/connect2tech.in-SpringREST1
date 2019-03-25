package com.journaldev.spring.controller;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.c2t.annotation.basic.Employee;
import com.journaldev.spring.service.EmployeeService;

@Controller
public class EmployeeControl {
	
	@Autowired
	EmployeeService service;
	
	@RequestMapping(value = "/dummy/emp/get", method = RequestMethod.GET)
	public @ResponseBody Employee getDummyEmployee(Long id) {
		
		return service.getDummyEmployee(id);
	}
	
	
	@RequestMapping(value = "/dummy/emp/get/{id}", method = RequestMethod.GET)
	public @ResponseBody Employee getEmployeeById(@PathVariable("id") int empId)
	{
		return service.getEmployee(new Long (empId));
	}
	
	
	@RequestMapping(value = "/dummy/emp/set", method = RequestMethod.GET)
	public @ResponseBody void setDummyEmployee() {
		service.setDummyEmployee();
	}
	
	@RequestMapping(value = "/dummy/emp/getList", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getListEmployee() {
		
		return service.getListEmployee();
	}
	
	
	@RequestMapping(value = "/dummy/emp/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody void deleteEmployee(@PathVariable("id") int empId)
	{
		service.deleteEmployee(new Long(empId));
	}
	
	

}
