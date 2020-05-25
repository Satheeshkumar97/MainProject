package com.niit.Backend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.Backend.config.DBConfig;
import com.niit.Backend.model.Employee;
import com.niit.Backend.service.EmpService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=DBConfig.class)
public class EmpTest {


static EmpService EmplService;
	
	@BeforeClass
	public static void initialize() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		System.out.println("bean intialization");
		EmplService = (EmpService) context.getBean("EmplService");
		System.out.println("succefully bean initiated");
	}
	
	//@Ignore
	@Test
	public void addEmptest() {
		
		Employee emp = new Employee();
		System.out.println("inside test");
		emp.seteId(1);
		emp.setEname("SatheeshKumar");
		emp.setEmail("SK97@gmail.com");
		emp.setPhone("9566879330");
		EmplService.addEmployee(emp);
	}
	
	@Ignore
	@Test
	public void listEmployee()
	{
		List<Employee> listEmployee = EmplService.getEmployeeList();
		assertNotNull("problem in listing details:",EmplService.getEmployeeList());
		
		for(Employee emp:listEmployee)
		{
			System.out.println(emp.geteId()+":::"+emp.getEname()+":::"+emp.getEmail()+":::"+emp.getPhone());
		}
	}
	
	@Ignore
	@Test
	public void updateEmployee() {
		
		Employee emp = EmplService.getEmployee(9);
		emp.setEname("SK");
		assertTrue("problem in updating employee:",EmplService.updateEmployee(emp));
		
	}
	
	@Ignore
	@Test
	public void deleteEmployee()
	{
		
		int eId=101;
		System.out.println("In delete method");
		assertTrue("problem in deleting employee:",EmplService.deleteEmployee(eId));
		System.out.println("After delete");
		}
}
