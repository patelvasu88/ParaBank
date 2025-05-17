package com.cjc.mercury.web.pages;

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
	
	@FindBy(xpath = "//a[@href='login.php']")
	WebElement signin;
	@FindBy(name = "userName")
	WebElement uname;
	@FindBy(name = "password")
	WebElement passw;
	@FindBy(name = "submit")
	WebElement sub;
	
	public void loginInfo(String un,String ps)
	{
		signin.click();
		uname.sendKeys(un);
		passw.sendKeys(ps);
		sub.click();
	}
	
}
