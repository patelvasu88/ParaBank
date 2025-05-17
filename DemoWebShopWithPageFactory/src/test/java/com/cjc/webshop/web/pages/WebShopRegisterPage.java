package com.cjc.webshop.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Factory;

public class WebShopRegisterPage
{

	WebDriver driver;

	public WebShopRegisterPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(id = "gender-male")
	WebElement gen;
	@FindBy(name = "FirstName")
	WebElement first;
	@FindBy(name = "LastName")
	WebElement last;
	@FindBy(name = "Email")
	WebElement em;
	@FindBy(name = "Password")
	WebElement ps;
	@FindBy(name = "ConfirmPassword")
	WebElement cps;
	@FindBy(name = "register-button")
	WebElement reg;
	@FindBy(xpath = "//a[@href='/logout']")
	WebElement out;
	
	public void getInfo(String fn,String ln,String ema,String pas,String cpas)
	{
		gen.click();
		first.sendKeys(fn);
		last.sendKeys(ln);
		em.sendKeys(ema);
		ps.sendKeys(pas);
		cps.sendKeys(cpas);
		reg.click();
		out.click();
	}
}
