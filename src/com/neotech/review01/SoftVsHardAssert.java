package com.neotech.review01;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftVsHardAssert {

	@Test(groups = "regression")
	public void testHardAssert() {

		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");

		String expectedText = "A";
		String actualText = "B";

		Assert.assertEquals(actualText, expectedText, "Some meaningful message");

		// After Hard Assert Fails, the Test Method stops executing...

		System.out.println("Step4");
	}

	@Test(groups = { "regression", "smoke", "sanity" })
	public void testSoftAssert() {

		System.out.println("Step1");

		SoftAssert soft = new SoftAssert();

		String expected = "A";
		String actual = "B";
		soft.assertEquals(actual, expected); // The first assertion failed

		System.out.println("Step2");

		soft.assertTrue(true); // The second assertion passed

		System.out.println("Step3");

		// This is collecting all the soft assertions
		// And deciding if the test passed or failed
		// If all assertions passed, the test passed
		soft.assertAll();

		System.out.println("Step4");

	}
}
