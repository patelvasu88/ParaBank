package com.cjc.webshop.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WebShopPaymentPage 
{

	WebDriver driver;

	public WebShopPaymentPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	@FindBy(name = "CountryId")
	WebElement count;
	@FindBy(xpath = "//*[@id=\"termsofservice\"]")
	WebElement tick;
	@FindBy(name = "checkout")
	WebElement check;
	
	public void getPayment(String cou)
	{
		Select s=new Select(count);
		s.selectByVisibleText(cou);
		tick.click();
		check.click();
	}
	
}
