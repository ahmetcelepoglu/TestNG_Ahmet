package com.neotech.lesson02;

import org.testng.annotations.Test;

public class PriorityDemo {

	@Test(priority = 0, groups = "smoke")
	public void firstTest() {
		System.out.println("first test");
	}

	@Test(priority = 1)
	public void secondTest() {
		System.out.println("second test");
	}

	@Test(priority = 2)
	public void thirdTest() {
		System.out.println("third test");
	}

	@Test(priority = 3)
	public void fourthTest() {
		System.out.println("fourth test");
	}
}
