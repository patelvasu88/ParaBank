package com.cjc.mercury.web.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import com.cjc.mercury.web.pages.BookingPage;
import com.cjc.mercury.web.pages.LoginPage;
import com.cjc.mercury.web.pages.RegisterPage;
import com.cjc.mercury.web.utility.Common;

public class MercuryTest
{

	static Logger log= Logger.getLogger(MercuryTest.class.getName());
	
	@BeforeSuite
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Selenium\\136\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		Common.driver= new ChromeDriver();
		log.info("driver loaded successfully");
	}
	@BeforeTest
	public void enterUrl()
	{
		Common.driver.get("https://demo.guru99.com/test/newtours/register.php");
		Common.driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void beforeClass()
	{
		Set<Cookie>cookies= Common.driver.manage().getCookies();
		log.info(cookies);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		log.info("DB connection");
	}
	
	@Test(dataProvider = "getregdData",priority = 1)
	public void getRegister(String first1,String last1,String pho1,String un1,String ad1,String ct1,String st1,
			String pin1,String cou1,String em1,String pw1,String cpw1)
	{
		RegisterPage rp=PageFactory.initElements(Common.driver, RegisterPage.class);
		rp.registerInfo(first1,last1,pho1,un1,ad1,ct1,st1,pin1,cou1,em1,pw1,cpw1);
	}
	
	@Test(priority = 2)
	@Parameters({"username","password"})
	public void getLogin(String un1,String ps1)
	{
		LoginPage lp=PageFactory.initElements(Common.driver, LoginPage.class);
		lp.loginInfo(un1,ps1);
	}
	
	@Test(priority = 3)
	public void getFlightDetails() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Desktop\\Selenium\\Excel jar\\Mercury11.xlsx");
		XSSFWorkbook wd=new XSSFWorkbook(fis);
		XSSFSheet sh= wd.getSheet("Sheet1");
		XSSFRow ro= sh.getRow(1);
		XSSFCell cell=ro.getCell(0);
		String pas1=cell.getStringCellValue();
		
		BookingPage bp=PageFactory.initElements(Common.driver, BookingPage.class);
		bp.getFlightInfo(pas1);
	}
	
	
	
	@DataProvider
	public Object[][] getregdData()
	{
		return new Object[][]
				{
			new Object[] {"Manish","Gadwal","8348336622","maishgadwal4@gmail.com","Karve Nagar","Pune","Maharastra",
					"411051","INDIA","manish11","manish@11","manish@11"}
				};
	}
	
}
