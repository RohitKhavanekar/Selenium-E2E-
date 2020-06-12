package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjs 
{
	public WebDriver driver;
	private By signin = By.cssSelector("a[href*='sign_in']"); //CREATE ELEMENTS SELECTORS HEAR 
	private By username = By.xpath("//input[@id='user_email']");
	
	
	
	

	
	
	public HomePageObjs(WebDriver driver)    //THIS IS MANDATORY      Creating a driver for objects
	{
			this.driver = driver;            //THIS IS MANDATORY
	}

	
	
	
	
	
	public WebElement signin()   //Create constructor for every singel element
	{
		return driver.findElement(signin);
	}
	
	
	
	
	
	

}
