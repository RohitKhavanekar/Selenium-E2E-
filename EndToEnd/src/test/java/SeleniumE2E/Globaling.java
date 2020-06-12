package SeleniumE2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObjs;
import pageObjects.LoginPageObjs;
import resources.BaseFile;

public class Globaling extends BaseFile
{
	public WebDriver driver;
	HomePageObjs l;
	LoginPageObjs lp ;
	private static Logger Log = LogManager.getLogger(Globaling.class.getName());
	//String url = null;
	
	@BeforeTest
	public void initlization() throws IOException
	{
			driver = initlizeDriver();
			driver.get("http://www.qaclickacademy.com/");
			
	}
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		//driver = initlizeDriver();
		//driver.get(prop.getProperty("url"));     NOT WORKING
		//driver.get("www.qaclickacademy.com");
		
		
		l = new HomePageObjs(driver);
		l.signin().click();
		lp = new LoginPageObjs(driver);
		Assert.assertEquals(lp.prompt().getText(), "Log In to Rahul Shetty Academy123");
		System.out.println("Assertion Done!");
		Log.info("Assertion Done Using LOG4J");
	}
	
	@Test
	public void headder()
	{
		
		
		Assert.assertEquals(lp.headder().getText(), "Create an Account123");
		System.out.println("Create Account Assertion Done!");
		Log.info("Assertion Done Using LOG4J");
		
		
		
	}
		
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
