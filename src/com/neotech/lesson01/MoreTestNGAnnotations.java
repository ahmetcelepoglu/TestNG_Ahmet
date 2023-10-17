package com.neotech.lesson01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MoreTestNGAnnotations {

	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before Test");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test");
	}
	
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
	}
	
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("AfterMethod");
	}
	
	@Test
	public void test1()
	{
		System.out.println("Test case 1 running....");
	}
	
	@Test
	public void test2()
	{
		System.out.println("Test case 2 running....");
	}
	
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before Method");
	}
	
	
	//Break until: 2:20
}
