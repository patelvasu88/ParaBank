package com.cjc.webshop.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WebShopAddressPage
{

	WebDriver driver;

	public WebShopAddressPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	@FindBy(name = "BillingNewAddress.CountryId")
	WebElement bill;
	@FindBy(name = "BillingNewAddress.City")
	WebElement bcity;
	@FindBy(name = "BillingNewAddress.Address1")
	WebElement baddress;
	@FindBy(name = "BillingNewAddress.ZipPostalCode")
	WebElement pin;
	@FindBy(name = "BillingNewAddress.PhoneNumber")
	WebElement phone;
	@FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/input")
	WebElement cont;
	@FindBy(xpath = "//*[@id=\"shipping-buttons-container\"]/input")
	WebElement cont1;
	@FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/input")
	WebElement cont2;
	@FindBy(xpath = "//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement cont3;
	@FindBy(xpath = "//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement cont4;
	@FindBy(xpath = "//*[@id=\"confirm-order-buttons-container\"]/input")
	WebElement cont5;
	@FindBy(xpath = "//input[@value=\"Continue\"]")
	WebElement cont6;
	
	public void billAddress(String bi,String ct,String addr,String zip,String ph) throws InterruptedException
	{
		Select s=new Select(bill);
		s.selectByVisibleText(bi);
		bcity.sendKeys(ct);
		baddress.sendKeys(addr);
		pin.sendKeys(zip);
		phone.sendKeys(ph);
		cont.click();
		Thread.sleep(2000);
		cont1.click();
		Thread.sleep(2000);
		cont2.click();
		Thread.sleep(2000);
		cont3.click();
		Thread.sleep(2000);
		cont4.click();
		Thread.sleep(2000);
		cont5.click();
		Thread.sleep(2000);
		cont6.click();
	}
	
}
