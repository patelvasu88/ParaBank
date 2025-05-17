package com.cjc.jpetstore.web.test;

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

import com.cjc.jpetstore.web.pages.AddToCart;
import com.cjc.jpetstore.web.pages.LoginPage;
import com.cjc.jpetstore.web.pages.PaymentPage;
import com.cjc.jpetstore.web.pages.RegisterPage;

public class JpetStoreTest 
{

	WebDriver driver;
	static Logger log = Logger.getLogger(JpetStoreTest.class.getName());
	
	@BeforeSuite
	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Selenium\\136\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver= new ChromeDriver();
		log.info("driver loaded successfully");
	}
	@BeforeTest
	public void enterUrl()
	{
		driver.get("https://jpetstore.aspectran.com/account/newAccountForm");
		driver.manage().window().maximize();
	}
	
	@BeforeClass
	public void beforeClass()
	{
		Set<Cookie>cookies= driver.manage().getCookies();
		System.out.println(cookies);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("DB connection");
	}
	
	@Test(dataProvider = "getData",priority = 1)
	public void getInfo(String id1,String pass1,String repeat1,String first1,String last1,
			String ema1,String ph1,String ad1,String add1,String cti1,String stat1,String pincode1,String count1,
			String la1,String fave1)
	{
		RegisterPage rp=PageFactory.initElements(driver, RegisterPage.class);
		rp.getRegister(id1,pass1,repeat1,first1,last1,ema1,ph1,ad1,add1,cti1,stat1,pincode1,count1,la1,fave1);
	}
	
	@Test(priority = 2)
	@Parameters({"username","password"})
	public void loginData(String un1,String pw1)
	{
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		lp.logincheck(un1, pw1);
	}
	
	@Test(priority = 3)
	public void breedCheck() throws InterruptedException
	{
		AddToCart ad=PageFactory.initElements(driver, AddToCart.class);
		ad.selectBreed();
	}
	
	@Test(priority = 4)
	public void cardInfo() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\Desktop\\Selenium\\Excel jar\\Jpetstore.xlsx");
		XSSFWorkbook wd=new XSSFWorkbook(fis);
		XSSFSheet sh=wd.getSheet("Sheet1");
		XSSFRow ro=sh.getRow(1);
		XSSFCell cell=ro.getCell(0);
		String cd1=cell.getStringCellValue();
		XSSFCell cell1=ro.getCell(1);
		String no1=cell1.getStringCellValue();
		XSSFCell cell2=ro.getCell(2);
		String exp1=cell2.getStringCellValue();
		
		PaymentPage pp=PageFactory.initElements(driver, PaymentPage.class);
		pp.carDetails(cd1,no1,exp1);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] 
				{
			new Object[] {"neeraj32","neeraj@11","neeraj@11","Neeraj","Pandey","neerajpandey@gmail.com",
					"7895443322","Karve Nagar","SHivajiNagar","Pune","Maharastra","411051","India","french","CATS"}
				};
	}
	
}
