package com.cjc.mercury.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingPage
{

	public WebDriver driver;

	public BookingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath = "//a[@href='reservation.php']")
	WebElement flight;
	@FindBy(name = "tripType")
	WebElement oneway;
	@FindBy(name = "passCount")
	WebElement noofpas;
	
	public void getFlightInfo(String pas)
	{
		flight.click();
		oneway.click();
		noofpas.sendKeys(pas);
	}
	
}
