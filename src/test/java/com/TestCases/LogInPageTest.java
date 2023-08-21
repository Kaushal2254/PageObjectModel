package com.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LogInPage;

public class LogInPageTest extends TestBase {
	LogInPage loginPage;

	public LogInPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LogInPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}

	@Test(priority = 2)
	public void loginToPage() throws IOException {
		loginPage.logInToSauce("standard_user", "standard_user");
		System.out.println("Loged in to sauce lab");
		takeScreenShot();
		System.out.println("ScreeShot took");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
