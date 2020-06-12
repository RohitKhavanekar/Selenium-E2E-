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
	By prompt = By.xpath("//*[@class='content-box']/h1");
	By headder = By.cssSelector("div[class='box-footer'] a");
	
	
	
	
	
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
	
	public WebElement prompt() 
	{
		return driver.findElement(prompt);
		
	}
	public WebElement headder()
	{
		return driver.findElement(headder);
	}
	
	
	

}
