package com.niit.Backend.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Backend.model.Employee;

@Repository("EmplDAO")
@Transactional
public class DAOimpl implements EmpDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Employee> getEmployeeList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public Employee getEmployee(int eId) {
		// TODO Auto-generated method stub
		return (Employee)sessionFactory.getCurrentSession().createQuery("from Employee where eId=");
	}

	@Override
	public boolean addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().save(emp);
			return true;	
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().update(emp);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	@Override
	public Employee findById(int eId) {
		// TODO Auto-generated method stub
		//return null;
		System.out.println(eId);
		return(Employee)sessionFactory.getCurrentSession().createQuery("from Employee where eId="+eId).uniqueResult();
		
	}

	@Override
	public boolean deleteEmployee(int eId) {
		// TODO Auto-generated method stub
		try
		{
			System.out.println("inside dao deleteEmployee");
			sessionFactory.getCurrentSession().delete(findById(eId));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

}
