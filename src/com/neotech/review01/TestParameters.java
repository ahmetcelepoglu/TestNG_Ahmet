package com.neotech.review01;

import org.testng.annotations.*;

public class TestParameters {

	@Test(priority = 5, groups = "regression")
	public void MethodA() {
		System.out.println("-> Running Test Method A");
	}

	@Test(priority = 1, enabled = false)
	public void MethodB() {
		System.out.println("-> Running Test Method B");
	}
}
