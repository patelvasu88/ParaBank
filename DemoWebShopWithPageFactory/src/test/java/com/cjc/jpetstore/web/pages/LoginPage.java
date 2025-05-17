package com.cjc.jpetstore.web.pages;

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
	WebElement usern;
	@FindBy(name = "password")
	WebElement passw;
	@FindBy(xpath = "//*[@id=\"Signon\"]/form/div/div/button")
	WebElement in;
	
	public void logincheck(String un,String pw)
	{
		usern.clear();
		usern.sendKeys(un);
		passw.clear();
		passw.sendKeys(pw);
		in.click();
	}
	
}
