package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class AssertDemo extends CommonMethods {

	@BeforeMethod
	public void openAndNavigate() throws InterruptedException {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	@Test(enabled = false)
	public void titleValidation() throws Exception {
		String expectedTitle = "OrangeHMR";
		String actualTitle = driver.getTitle();

		// Assert.assertEquals(expectedTitle, actualTitle);

		Assert.assertEquals(expectedTitle, actualTitle, "Title does NOT match! Error code:5001");

		System.out.println("Continue after assertion...");
	}

	@Test
	public void logoValidation() {
		WebElement logo = driver.findElement(By.xpath("//div[@class=\"orangehrm-logo\"]"));

		// Assert.assertEquals(logo.isDisplayed(), true);
		// Assert.assertEquals(logo.isDisplayed(), true, "Logo is NOT displayed!");

		Assert.assertTrue(logo.isDisplayed());
	}
}
