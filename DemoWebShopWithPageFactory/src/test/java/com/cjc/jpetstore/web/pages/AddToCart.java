package com.cjc.jpetstore.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCart
{

	WebDriver driver;

	public AddToCart(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@id='SidebarContent']/a[2]")
	WebElement breed;
	@FindBy(xpath = "//a[@href='/products/K9-RT-01']")
	WebElement brid;
	@FindBy(xpath = "//a[@href='/cart/addItemToCart?itemId=EST-28']")
	WebElement cart;
	@FindBy(xpath = "//a[@href='/order/newOrderForm']")
	WebElement check;
	
	public void selectBreed() throws InterruptedException
	{
		Thread.sleep(2000);
		breed.click();
		brid.click();
		cart.click();
		check.click();
	}
	
	
}
