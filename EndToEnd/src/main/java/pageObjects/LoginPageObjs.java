package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjs 

{
	
	public WebDriver driver;
	By username = By.xpath("//input[@id='user_email']");
	By password = By.xpath("//input[@type='password']");
	By login = By.xpath("//input[@name='commit']");
	
	
	
	
	
	public LoginPageObjs(WebDriver driver)   //THIS STEP IS MANDATORY
	{
		this.driver=driver;
	}
	
	
	
	
	
	public WebElement username() 
	{
		return driver.findElement(username);	
	}
	
	public WebElement password() 
	{
		return driver.findElement(password);
	}
	
	public WebElement login() 
	{
		return driver.findElement(login);
	}
	
	
	

}
