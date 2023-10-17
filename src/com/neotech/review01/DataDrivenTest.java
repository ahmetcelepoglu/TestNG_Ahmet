package com.neotech.review01;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.ExcelUtility;

public class DataDrivenTest {
	
	@BeforeMethod
	public void before() {
		System.out.println("Before the test!!!");
	}

	@Test(dataProvider = "data2")
	public void doSmth(String name, String company, String jobPosition) {

		System.out.println(name + " - " + company);
		System.out.println("She/He works as -> " + jobPosition);

	}

	@DataProvider(name = "data1")
	public Object[][] createData() {
		Object[][] data = { 
				{ "Olga", "Facebook", "Ceo" },
				{ "Ogulcan", "Google", "Lead Developer" },
				{ "Billur", "NeoTech", "Instuctor" },
				{ "Emre", "Gucci", "Designer" }
			};

		return data;
	}

	@DataProvider(name = "data2")
	public Object[][] createFromExcel() {
		String filePath = System.getProperty("user.dir") + "/testdata/Companies.xlsx";
		String sheet = "Experience";
		return ExcelUtility.excelIntoArray(filePath, sheet);
	}

}
