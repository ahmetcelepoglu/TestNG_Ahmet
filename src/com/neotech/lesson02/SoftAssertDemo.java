package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class SoftAssertDemo extends CommonMethods {
	@BeforeMethod
	public void openAndNavigate() throws InterruptedException {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	@Test
	public void logoAndLoginValidation() {
		WebElement logo = driver.findElement(By.xpath("//div[@class=\"orangehrm-logo\"]"));
		boolean isLogoDisplayed = logo.isDisplayed();
		isLogoDisplayed = false;

		// logo is displayed validation
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(isLogoDisplayed, "Logo is NOT displayed");

		// logging in validation
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));

		wait(2);
		String expected = "Jacqueline White";
		String actual = driver.findElement(By.id("account-name")).getText();
		softAssert.assertEquals(expected, actual, "Account name is NOT Jacqueline White");

		// This will collect all soft test assertions
		// and will decide whether the test passed or failed
		softAssert.assertAll();

		// If the test failed, execution will stop after assertAll()
		// Otherwise, it will keep executing the following line
		System.out.println("After assertAll code");
	}
}
