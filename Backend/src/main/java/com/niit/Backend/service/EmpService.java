package com.niit.Backend.service;

import java.util.List;

import com.niit.Backend.model.Employee;

public interface EmpService {
	public List<Employee> getEmployeeList();
	public Employee getEmployee(int eId);
	public boolean addEmployee(Employee emp);
	public boolean updateEmployee(Employee emp);
	public boolean deleteEmployee(int eId);
	public Employee findbyId (int eId);
}
