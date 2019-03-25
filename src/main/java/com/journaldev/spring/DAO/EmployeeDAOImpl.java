package com.journaldev.spring.DAO;

import java.util.*;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.c2t.annotation.basic.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SessionFactory sf;
	
	@Override
	public Employee getDummyEmployee(Long id) {
		
		return	(Employee) sf.openSession().get(Employee.class, 3l);	 
	}

	@Override
	public Employee getEmployee(Long empId) {
		
		Session session=sf.openSession();
		Employee emp=(Employee) session.get(Employee.class, new Long (empId));
		return emp;
	}

	@Override
	public void setDummyEmployee() {
		
		Employee emp = new Employee();
		
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

	@Override
	public List<Employee> getListEmployee() {
		
		List<Employee> empList=new ArrayList<Employee>();
		Session session=sf.openSession();
		session.beginTransaction();
		Query q=session.createQuery("from Employee");
		empList=q.list();
		return empList;
		
	}

	@Override
	public void deleteEmployee(Long empId) {
		
	Session session=sf.openSession();
	session.beginTransaction();
	 Employee emp=(Employee) session.get(Employee.class, new Long (empId));
	 session.delete(emp);
	 session.getTransaction().commit();
	 session.close();
		
	}

}
