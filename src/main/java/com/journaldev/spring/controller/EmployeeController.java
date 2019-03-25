package com.journaldev.spring.controller;


import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.c2t.annotation.basic.Employee;


//import com.journaldev.spring.model.Employee;

@Controller
public class EmployeeController {
	@Autowired
	SessionFactory sf;

Map<Integer, Employee> empData = new HashMap<Integer, Employee>();
	
	@RequestMapping(value = "/dummy/get", method = RequestMethod.GET)
	public @ResponseBody Employee getDummyEmployee(Long id) {
		
		return	(Employee) sf.openSession().get(Employee.class, 3l);	 
	}
	
	
	@RequestMapping(value = "/dummy/get/{id}", method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId)
	{
		Session session=sf.openSession();
		Employee emp=(Employee) session.get(Employee.class, new Long (empId));
		return emp;
	}
	
	
	@RequestMapping(value = "/dummy/set", method = RequestMethod.GET)
	public @ResponseBody void setDummyEmployee() {
		//logger.info("Start getDummyEmployee");
		Employee emp = new Employee();
		//emp.setId(9999);
		//emp.setName("Dummy");
		//emp.setCreatedDate(new Date());
		//empData.put(9999, emp);
		
		Session session=sf.openSession();
		session.beginTransaction();
		emp.setId(100l);
		
		emp.setFirstname("sneha");
		emp.setLastname("dddd");
		emp.setCellphone("11111");
		emp.setBirthDate(new java.sql.Date(1996, 11, 07));
		
		
		session.save(emp);
		session.getTransaction().commit();
		session.close();
		
	}
	
	@RequestMapping(value = "/dummy/getList", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getListEmployee() {
		
		List<Employee> empList=new ArrayList<Employee>();
		Session session=sf.openSession();
		session.beginTransaction();
		Query q=session.createQuery("from Employee");
		empList=q.list();
		return empList;
	}
	
	
	@RequestMapping(value = "/dummy/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody void deleteEmployee(@PathVariable("id") int empId)
	{
		Session session=sf.openSession();
		session.beginTransaction();
	 Employee emp=(Employee) session.get(Employee.class, new Long (empId));
	 session.delete(emp);
	 session.getTransaction().commit();
	 session.close();
	}
	
	
}
