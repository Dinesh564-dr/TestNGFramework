package com.automation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.BrowserFactory;
import com.automation.utility.Configdataprovider;
import com.automation.utility.Exceldataprovider;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Baseclass {
	public WebDriver driver;
	public Exceldataprovider excel;
	public Configdataprovider provider;
	public ExtentReports extent;
	public ExtentTest logger;

	@BeforeSuite
	public void setupsuite() {
		excel = new Exceldataprovider();
		provider = new Configdataprovider();
		//System.getProperty("user.dir")+
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(new File("./Reports/FreeCRM.html"));
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.flush();
		
	}

	@BeforeClass
	public void setup() {
		driver = BrowserFactory.StartApplication(driver, provider.getBrowser(), provider.getStagingURL());
	}

	@AfterClass
	public void tearDown() {
		BrowserFactory.quit(driver);
	}
	@AfterMethod
	public void teardownmethod(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE) {
			Helper.capturescreenshots(driver);
		}
	}
}
