package com.cjc.parabank.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage
{

	WebDriver driver;

	public SignUpPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(name = "customer.firstName")
	WebElement first;
	@FindBy(name = "customer.lastName")
	WebElement last;
	@FindBy(name = "customer.address.street")
	WebElement adr;
	@FindBy(name = "customer.address.city")
	WebElement cit;
	@FindBy(name = "customer.address.state")
	WebElement sta;
	@FindBy(name = "customer.address.zipCode")
	WebElement pin;
	@FindBy(name = "customer.phoneNumber")
	WebElement pho;
	@FindBy(name = "customer.ssn")
	WebElement ss;
	@FindBy(name = "customer.username")
	WebElement usern;
	@FindBy(name = "customer.password")
	WebElement pass;
	@FindBy(name = "repeatedPassword")
	WebElement cpass;
	@FindBy(xpath = "//input[@value='Register']")
	WebElement reg;
	@FindBy(xpath = "//a[@href='logout.htm']")
	WebElement out;
	
	public void getPersonalDetails(String fn,String ln,String add,String ct,String st,String zip,String ph,
									String ssn,String un,String pw,String cpw) throws InterruptedException
	{
		first.sendKeys(fn);
		last.sendKeys(ln);
		adr.sendKeys(add);
		cit.sendKeys(ct);
		pin.sendKeys(zip);
		sta.sendKeys(st);
		pho.sendKeys(ph);
		ss.sendKeys(ssn);
		usern.sendKeys(un);
		pass.sendKeys(pw);
		cpass.sendKeys(cpw);
		reg.click();
		Thread.sleep(2000);
		out.click();
	}

	
}
