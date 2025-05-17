package com.cjc.webshop.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebShopLoginPage 
{

	WebDriver driver;

	public WebShopLoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath = "//a[@href='/login']")
	WebElement in;
	@FindBy(name = "Email")
	WebElement emid;
	@FindBy(name = "Password")
	WebElement pw;
	@FindBy(id = "RememberMe")
	WebElement rem;
	@FindBy(xpath = "//form[@action='/login']/div[5]/input")
	WebElement login;
	
	public void getLoginInfo(String id,String pass)
	{
		in.click();
		emid.sendKeys(id);
		pw.sendKeys(pass);
		rem.click(); 
		login.click();
	}
}
