package com.neotech.review01;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupsDemo {

	@Test(groups = "smoke")
	public void smokeTest() {
		System.out.println("-> Smoke");
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeSmokeTest() {
		System.out.println("Just before smoke");
	}

}
