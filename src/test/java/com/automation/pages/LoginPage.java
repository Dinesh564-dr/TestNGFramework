package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	@FindBy(name="email") 
	WebElement uname;
	
	@FindBy(name="password") 
	WebElement pass;
	
	@FindBy(xpath="//div[@id='ui']//div//div//form//div//div[contains(text(),'Login')]") 
	WebElement loginbtn;
	
	public void login(String mail,String password) throws InterruptedException {
		
		uname.sendKeys(mail);
		pass.sendKeys(password);
		loginbtn.click();
		Thread.sleep(10000);
	}
	
}
