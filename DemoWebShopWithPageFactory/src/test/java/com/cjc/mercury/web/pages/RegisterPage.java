package com.cjc.mercury.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage
{

	WebDriver driver;

	public RegisterPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	 
	@FindBy(name = "firstName")
	WebElement fn;
	@FindBy(name = "lastName")
	WebElement ln;
	@FindBy(name = "phone")
	WebElement ph;
	@FindBy(name = "userName")
	WebElement usern;
	@FindBy(name = "address1")
	WebElement addr;
	@FindBy(name = "city")
	WebElement place;
	@FindBy(name = "state")
	WebElement sta;
	@FindBy(name = "postalCode")
	WebElement post;
	@FindBy(name = "country")
	WebElement count;
	@FindBy(name = "email")
	WebElement ema;
	@FindBy(name = "password")
	WebElement pass;
	@FindBy(name = "confirmPassword")
	WebElement cpass;
	@FindBy(name = "submit")
	WebElement sub;
	
	
	public void registerInfo(String first,String last,String pho,String un,String ad,String ct,
			String st,String pin,String cou,String em,String pw,String cpw)
	{
		fn.sendKeys(first);
		ln.sendKeys(last);
		ph.sendKeys(pho);
		usern.sendKeys(un);
		addr.sendKeys(ad);
		place.sendKeys(ct);
		sta.sendKeys(st);
		post.sendKeys(pin);
		Select s=new Select(count);
		s.selectByValue(cou);
		ema.sendKeys(em);
		pass.sendKeys(pw);
		cpass.sendKeys(cpw);
		sub.click();
	}
	
}
