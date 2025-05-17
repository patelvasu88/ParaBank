package com.cjc.webshop.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebShopAddtoCartPage 
{

	WebDriver driver;

	public WebShopAddtoCartPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath = "//li[@class='inactive']/a[@href='/books']")
	WebElement books;
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input")
	WebElement atc;
	@FindBy(xpath = "//span[@class=\"cart-label\"]")
	WebElement shopcart;
	
	
	public void addto()
	{
		books.click();
		atc.click();
		shopcart.click();
	}
	
}
