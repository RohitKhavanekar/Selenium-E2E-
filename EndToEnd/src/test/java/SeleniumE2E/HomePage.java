package SeleniumE2E;



import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.HomePageObjs;
import pageObjects.LoginPageObjs;
import resources.BaseFile;


public class HomePage extends BaseFile
{
	public WebDriver driver;
	private static Logger Log = LogManager.getLogger(HomePage.class.getName());
	@BeforeTest
	public void initlization() throws IOException
	{
		driver = initlizeDriver();
		Log.info("Driver is Inatlized");
		
	}
	
	
	@Test(dataProvider = "getdata")
	
	public void basePageNavigation(String username,String password,String cmnt) throws IOException
	{
		
		driver.get("http://www.qaclickacademy.com/");
		HomePageObjs l = new HomePageObjs(driver);
		l.getsignin().click();
		LoginPageObjs lp = new LoginPageObjs(driver);
		
		//Assertions added in two ways
		//Assert.assertEquals(lp.prompt().getText(), "Log In to Rahul Shetty Academy");    
		//Assert.assertTrue(lp.prompt().isDisplayed());
		
		lp.username().sendKeys(username);
		lp.password().sendKeys(password);
		System.out.println(cmnt);
		Log.info(cmnt);
		lp.login().click();
		Log.info("Submited");
		
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

	
	
	
	
	
@DataProvider
public Object[][] getdata()
{
	//ROW stands for sets of data 
	//column stand for values per set of data
	Object[][] data = new Object[2][3];
	//Row 1
	data[0][0] = "resticteduser@gmail.com";
	data[0][1] = "123";
	data[0][2] = "Restricted User";
	//Row 2
	data[1][0] = "nonrestricteduser@gmail.com";
	data[1][1] = "456";
	data[1][2] = "Non Restriced User"; 
	
	return data;
	
}



	
	
}
