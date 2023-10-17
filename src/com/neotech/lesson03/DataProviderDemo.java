package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class DataProviderDemo extends CommonMethods{

	
	//instead of always creating methods that call setUp and tearDown
	//I can say that setUp is the BeforeMethod and tearDown is the AfterMethod
	
	
	/*
	 * @BeforeMethod public void openAndNavigate() throws InterruptedException {
	 * setUp(); }
	 * 
	 * @AfterMethod public void quitBrowser() { tearDown(); }
	 */
	
	
	@Test(dataProvider="userData")
	public void loginFunctionality(String username, String password)
	{
		sendText(driver.findElement(By.id("txtUsername")),
				username);
		sendText(driver.findElement(By.id("txtPassword")),
				password);
		
		wait(5);
		
		click(driver.findElement(By.xpath("//button[@type='submit']")));
		wait(2);
	}
	
	
	@DataProvider(name = "userData")
	public Object[][] getData()
	{
		// 1st test: Admin Admin123 --> {"Admin", "Admin123"}
		// 2nd test: Can	Can123	--> {"Can", "Can123"}
		// 3rd test: Fulin	Fulin123 -->{"Fulin", "Fulin123"}
		
		Object[][] credentials = {
				{"Admin", "Neotech@123"},
				{"Can", "Can123"},
				{"Fulin", "Fulin123"}
		};
		
		
		return credentials;
	}
	
	
	
	
	
}
