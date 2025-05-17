package com.cjc.parabank.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{

	WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	@FindBy(name = "username")
	WebElement uname;
	@FindBy(name = "password")
	WebElement pword;
	@FindBy(xpath = "//input[@value='Log In']")
	WebElement login;
	
	public void logDetails(String un,String ps)
	{
		uname.sendKeys(un);
		pword.sendKeys(ps);
		login.click();
	}
	
}
