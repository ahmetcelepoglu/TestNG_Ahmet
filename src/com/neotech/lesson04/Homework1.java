package com.neotech.lesson04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.ExcelUtility;

public class Homework1 extends CommonMethods {
//	Open chrome browser
//	Go to "https://hrm.neotechacademy.com/"
//	Login to the application
//	Add 3 different Employees and Create Login Details by providing:
//	First Name
//	Last Name
//	Username
//	Password
//	Verify Employee has been added successfully and take screenshot (you must have 3 different screenshots)
//	Close the browser
//	Specify a group for this test case, add it into specific suite and execute from the xml file.

	@Test(dataProvider = "excelData")
	public void test(String firstName, String lastName, String userName, String password) {
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));

		click(driver.findElement(By.xpath("//button[@type='submit']")));

		// Click the PIM link
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		// Click the Add Employee Link
		driver.findElement(By.linkText("Add Employee")).click();
		wait(1);

		// Enter the new employee data
		sendText(driver.findElement(By.id("first-name-box")), firstName);
		sendText(driver.findElement(By.id("last-name-box")), lastName);

		// Get the employeeId for verification
		String empId = driver.findElement(By.id("employeeId")).getAttribute("value");

		WebElement ddLocation = driver.findElement(By.id("location"));
		Select sel = new Select(ddLocation);
		sel.selectByVisibleText("Australian Regional HQ");

		// Click on the credential toggle, turn it on
		click(driver.findElement(By.xpath("//div[@class='custom-control custom-switch']")));
		wait(1);

		// Fill in username, password, and confirm password boxes
		sendText(driver.findElement(By.id("username")), userName);
		sendText(driver.findElement(By.id("password")), password);
		sendText(driver.findElement(By.id("confirmPassword")), password);
		wait(1);

		// Click the save button
		click(driver.findElement(By.id("modal-save-button")));

		// Verify the employee form is visible
		waitForVisibility(driver.findElement(By.id("pimPersonalDetailsForm")));

		// Verify the new employee using employeeId
		String actualId = driver.findElement(By.id("employeeId")).getAttribute("value");
		Assert.assertEquals(actualId, empId, "Employee ID's do not match!");

		// Take screenshot: 1st way
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		// this is the screenshot, but it is not saved anywhere
//		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
//		try {
//			String fileName = firstName + "_" + lastName;
//			Files.copy(sourceFile, new File("screenshots/" + fileName + ".png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println("Unable to save the screenshot!!!");
//		}

		// 2nd way
		String fileName = firstName + "_" + lastName;
		takeScreenshot(fileName);
	}

	@DataProvider(name = "getData")
	public Object[][] createData() {
		Object[][] data = { { "Jeff", "Bezos", "Jess2023112", "Bezos@23" },
				{ "Bill", "Gates", "Bill2023122", "Gates@23" }, { "Elon", "Musk", "Elon2023332", "Musk@23!" } };

		return data;
	}

	@DataProvider(name = "excelData")
	public Object[][] getExcelData() {
		String filePath = System.getProperty("user.dir") + "/testdata/Excel.xlsx";
		String sheetName = "Employee";
		return ExcelUtility.excelIntoArray(filePath, sheetName);
	}
}
