package com.cjc.parabank.web.tests;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cjc.parabank.web.pages.LoginPage;
import com.cjc.parabank.web.pages.SignUpPage;
import com.cjc.parabank.web.utility.Common;

public class ParaBankTest
{

	static Logger log=Logger.getLogger(ParaBankTest.class);
	@BeforeSuite
	public void launchbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Selenium\\136\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		Common.driver=new ChromeDriver();
	}
	
	@BeforeTest
	public void enterUrl()
	{
		Common.driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=F72737800ECA16BF0D6C413EE14DD957");
		Common.driver.manage().window().maximize();
		log.info("browser is maximized");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		Set<Cookie>cookies=Common.driver.manage().getCookies();
		log.info(cookies);
	}
	
	
	@BeforeMethod
	public void beforeMethod()
	{
		log.info("Db Connection");
	}
	
	@Test(dataProvider = "getdata",priority = 1)
	public void getRegister(String fn1,String ln1,String add1,String ct1,String st1,String zip1,String ph1,
							String ssn1,String un1,String pw1,String cpw1) throws InterruptedException
	{
		SignUpPage sp=PageFactory.initElements(Common.driver, SignUpPage.class);
		sp.getPersonalDetails(fn1,ln1,add1,ct1,st1,zip1,ph1,ssn1,un1,pw1,cpw1);
	}
	
	@Test(priority = 2)
	@Parameters({"username","password"})
	public void getLogInfo(String un1,String ps1)
	{
		LoginPage lp=PageFactory.initElements(Common.driver, LoginPage.class);
		lp.logDetails(un1,ps1);
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		return new Object[][]
				{
			new Object[] {"Nilesh","Solanki","Karve Nagar","Pune","Maharastra","411051","79995432166","54365476",
							"nilesh11","nilesh@11","nilesh@11"}
				};
	}
	
}
