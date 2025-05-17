package com.cjc.jpetstore.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Factory;

public class RegisterPage 
{

	WebDriver driver;

	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(name = "username")
	WebElement uid;
	@FindBy(name = "password")
	WebElement upass;
	@FindBy(name = "repeatedPassword")
	WebElement rpass;
	@FindBy(name = "firstName")
	WebElement fname;
	@FindBy(name = "lastName")
	WebElement lname;
	@FindBy(name = "email")
	WebElement em;
	@FindBy(name = "phone")
	WebElement pho;
	@FindBy(name = "address1")
	WebElement addr;
	@FindBy(name = "address2")
	WebElement addrs;
	@FindBy(name = "city")
	WebElement ct;
	@FindBy(name = "state")
	WebElement st;
	@FindBy(name = "zip")
	WebElement pin;
	@FindBy(name = "country")
	WebElement cou;
	@FindBy(name = "languagePreference")
	WebElement lang;
	@FindBy(name = "favouriteCategoryId")
	WebElement fa;
	@FindBy(name = "listOption")
	WebElement list;
	@FindBy(name = "bannerOption")
	WebElement banner;
	@FindBy(xpath = "//*[@id=\"CenterForm\"]/form/div/button")
	WebElement save;
	
	public void getRegister(String id,String pass,String repeat,String first,String last,
			String ema,String ph,String ad,String add,String cti,String stat,String pincode,String count,String la,
			String fave)
	{
		uid.sendKeys(id);
		upass.sendKeys(pass);
		rpass.sendKeys(repeat);
		fname.sendKeys(first);
		lname.sendKeys(last);
		em.sendKeys(ema);
		pho.sendKeys(ph);
		addrs.sendKeys(add);
		addr.sendKeys(ad);
		ct.sendKeys(cti);
		st.sendKeys(stat);
		pin.sendKeys(pincode);
		cou.sendKeys(count);
		Select s=new Select(lang);
		s.selectByValue(la);
		Select s1=new Select(fa);
		s1.selectByValue(fave);
		list.click();
		banner.click();
		save.click();
	}
	
}
