package com.neotech.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class LoginTest extends CommonMethods {

	@Test
	public void validLogin() {

		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();

		// send username
		sendText(login.username, ConfigsReader.getProperty("username"));
		wait(1);

		// send password
		sendText(login.password, ConfigsReader.getProperty("password"));
		wait(1);

		// click on login
		click(login.loginButton);
		// Or use jsClick or Action.click
		wait(1);

		// Verify account name
		String expected = "Jacqueline White";
		String actual = dashboard.accountName.getText();

		// Assertion
		Assert.assertEquals(actual, expected, "The account does NOT match!!!");
	}
}
