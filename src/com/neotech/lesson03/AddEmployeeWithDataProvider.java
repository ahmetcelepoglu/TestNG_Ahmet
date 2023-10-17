package com.neotech.lesson03;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class AddEmployeeWithDataProvider extends CommonMethods{
/*
	Add 3 Employees with using DataProvider
	Open chrome browser and navigate to Orange HRM website
	Login with valid credentials
	Navigate to addEmployee tab
	Add 3 different employees using data Provider
*/	
	
	@Test
	public void addEmployee(String firstName, String lastName)
	{
		//test if you are getting the data correctly from the dataProvider
		
		System.out.println(firstName + "  " + lastName);
		
		
		//login
		
		//navigate to PIM
		
		//click on AddEmployee
		
		//send employee data
		
		
		//save employee
		
	}
	
	
	@DataProvider
	public Object[][] employeeData()
	{
		
		Object[][] data = {};
		
		return data;
	}
	
	
	
}
