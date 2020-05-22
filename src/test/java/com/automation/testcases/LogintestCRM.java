package com.automation.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.Baseclass;
import com.automation.pages.LoginPage;

public class LogintestCRM extends Baseclass {

	@Test
	public void loginApp() throws InterruptedException {

		logger = extent.createTest("Login to CRm");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		logger.info("starting application");
		login.login(excel.getStringdata("Data", 0, 0), excel.getStringdata("Data", 0, 1));
		logger.pass("login passed");

	}

}
