package com.journaldev.spring.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c2t.annotation.basic.Employee;
import com.journaldev.spring.DAO.EmployeeDAO;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDAO empDAO;
	
	public Employee getDummyEmployee(Long id)
	{
		return empDAO.getDummyEmployee(id);
	}
	
	public Employee getEmployee( Long empId)
	{
		return empDAO.getEmployee(empId);
	}
	
	public void setDummyEmployee()
	{
		empDAO.setDummyEmployee();
	}
	
	public List<Employee> getListEmployee()
	{
		return empDAO.getListEmployee();
	}
	
	public void deleteEmployee(Long empId)
	{
		empDAO.deleteEmployee(empId);
	}

}
