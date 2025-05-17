package com.cjc.webshop.web.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cjc.webshop.web.pages.WebShopAddressPage;
import com.cjc.webshop.web.pages.WebShopAddtoCartPage;
import com.cjc.webshop.web.pages.WebShopLoginPage;
import com.cjc.webshop.web.pages.WebShopPaymentPage;
import com.cjc.webshop.web.pages.WebShopRegisterPage;


public class DemoWebShopTest
{

	WebDriver driver;
	static Logger log = Logger.getLogger(DemoWebShopTest.class.getName());

	@BeforeSuite
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Selenium\\136\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver= new ChromeDriver();
	}
	@BeforeTest
	public void enterUrl()
	{
		driver.get("https://demowebshop.tricentis.com/register");
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void beforeClass()
	{
		Set<Cookie>cookies= driver.manage().getCookies();
		log.info(cookies);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		log.info("DB connection");
	}
	
	@Test(dataProvider = "getDetails",priority = 1)
	public void getRegister(String fn1,String ln1,String ema1,String pas1,String cpas1)
	{
		WebShopRegisterPage ws= PageFactory.initElements(driver, WebShopRegisterPage.class);
		ws.getInfo(fn1,ln1,ema1,pas1,cpas1);
	}
	
	
	
	
	@Parameters({"emailid","password"})
	@Test(priority = 2)
	public void getLogin(String id1,String pass1)
	{
		WebShopLoginPage wlog=PageFactory.initElements(driver, WebShopLoginPage.class);
		wlog.getLoginInfo(id1,pass1);
	}
	
	
	@Test(priority = 3)
	public void getshopcart()
	{
		WebShopAddtoCartPage webcart= PageFactory.initElements(driver, WebShopAddtoCartPage.class);
		webcart.addto();
	}
	
	@Test(dataProvider = "payInfo",priority = 4)
	public void getShip(String cou1)
	{
		WebShopPaymentPage pay=PageFactory.initElements(driver, WebShopPaymentPage.class);
		pay.getPayment(cou1);
	}
	
	@Test(priority = 5)
	public void getbillAdd() throws IOException, InterruptedException
	{
		FileInputStream fis= new FileInputStream("C:\\Users\\Admin\\Desktop\\Selenium\\Excel jar\\WebshopProject.xlsx");
		XSSFWorkbook wd=new XSSFWorkbook(fis);
		XSSFSheet sh=wd.getSheet("Sheet1");
		
		XSSFRow ro=sh.getRow(1);
		XSSFCell cell=ro.getCell(4);
		String bi1=cell.getStringCellValue();
		XSSFCell cell1=ro.getCell(0);
		String ct1=cell1.getStringCellValue();
		XSSFCell cell2=ro.getCell(1);
		String addr1=cell2.getStringCellValue();
		XSSFCell cell3=ro.getCell(2);
		String zip1=cell3.getStringCellValue();
		XSSFCell cell4=ro.getCell(3);
		String ph1=cell4.getStringCellValue();
		
		WebShopAddressPage addpg=PageFactory.initElements(driver, WebShopAddressPage.class);
		addpg.billAddress(bi1,ct1,addr1,zip1,ph1);
		
		
	}
	
	@DataProvider
	public Object[][] getDetails()
	{
		return new Object[][] 
				{
			new Object[] {"Pranay","Jain","pranayjaio25@gmail.com","pranay@11","pranay@11"}
				};
	}
	

	@DataProvider
	public Object[][] payInfo()
	{
		return new Object[][]
				{
			new Object[] {"Belize"}
				};
	}
	
	
	
}
