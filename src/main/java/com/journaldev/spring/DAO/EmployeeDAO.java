package com.journaldev.spring.DAO;

import java.util.*;

import com.c2t.annotation.basic.Employee;

public interface EmployeeDAO {
		
public Employee getDummyEmployee(Long id);
public Employee getEmployee( Long empId);
public void setDummyEmployee();
public List<Employee> getListEmployee();
public void deleteEmployee(Long empId);

}
