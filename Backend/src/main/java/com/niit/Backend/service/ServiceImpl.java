package com.niit.Backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.dao.DAOimpl;
import com.niit.Backend.model.Employee;

@Service
@Repository("EmplService")
@Transactional
public class ServiceImpl {
	@Autowired
	private DAOimpl EmplDAO;

	@Override
	public List<Employee> getEmployeeList() {
	
		return EmplDAO.getEmployeeList();
	}

	@Override
	public Employee getEmployee(int eId) {
		
		return EmplDAO.getEmployee(eId);
	}

	@Override
	public boolean addEmployee(Employee emp) {
		EmplDAO.addEmployee(emp);
		
		return true;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		EmplDAO.updateEmployee(emp);
		
		return true;
	}

	@Override
	public boolean deleteEmployee(int eId) {
		EmplDAO.deleteEmployee(eId);
	
		return false;
	}

	@Override
	public Employee findbyId(int eId) {
		

		return EmplDAO.getEmployee(eId);
	}
}
