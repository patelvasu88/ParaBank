package com.cjc.jpetstore.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage
{

	WebDriver driver;

	public PaymentPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	@FindBy(name = "cardType")
	WebElement card;
	@FindBy(name = "creditCard")
	WebElement cardno;
	@FindBy(name = "expiryDate")
	WebElement date;
	@FindBy(xpath = "//*[@id=\"CenterForm\"]/form/div/button[1]")
	WebElement cont;
	@FindBy(xpath = "//*[@id=\"CenterForm\"]/form/div/button[1]")
	WebElement confirm;
	
	public void carDetails(String cd,String no,String exp)
	{
		card.sendKeys(cd);
		cardno.clear();
		cardno.sendKeys(no);
		date.clear();
		date.sendKeys(exp);
		cont.click();
		confirm.click();
		
	}
	
}
