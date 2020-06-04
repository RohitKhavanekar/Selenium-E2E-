package SeleniumE2E;

import java.io.IOException;


import org.testng.annotations.Test;

import pageObjects.HomePageObjs;
import pageObjects.LoginPageObjs;
import resources.BaseFile;

@Test
public class HomePage extends BaseFile
{
	public void basePageNavigation() throws IOException
	{
		driver = initlizeDriver();
		driver.get("http://www.qaclickacademy.com/");
		
		HomePageObjs l = new HomePageObjs(driver);
		l.getsignin().click();
		LoginPageObjs lp = new LoginPageObjs(driver);
		lp.username().sendKeys("Rck");
		lp.password().sendKeys("12345");
		lp.login().click();
		
	}
}
