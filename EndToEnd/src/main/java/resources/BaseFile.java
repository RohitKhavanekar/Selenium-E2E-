package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseFile   //THIS FILE IS BASE FILE ONLY CHANGE THE PARAMETRS IN THIS FILE 
{
	public WebDriver driver; 
	
	
	public WebDriver initlizeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browserName = System.getProperty("browser");// FOR JENKINS PARAMETRIZED WORKING
		//String browserName = prop.getProperty("browser");
		
		
		
		if(browserName.equalsIgnoreCase("Chrome"))//USE EQUALS OPERATOR CASE
		{
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe"); //Dynamic Paths
			//ChromeOptions options = new ChromeOptions();//FOR HEADLESS RUNNING OF CHROME  ----1
			//options.addArguments("--headless");//FOR HEADLESS RUNNING OF CHROME  ----2
			//System.setProperty("webdriver.chrome.driver", "D:\\Rohit_Folder\\MAXIMUS\\Selenium Driver NEVER DELETE\\ChromeDriver 83\\chromedriver.exe");
			//driver = new ChromeDriver(options);//FOR HEADLESS RUNNING OF CHROME  ----3
			driver = new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("chromeheadless")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe"); //Dynamic Paths
			ChromeOptions options = new ChromeOptions();//FOR HEADLESS RUNNING OF CHROME  ----1
			options.addArguments("--headless");//FOR HEADLESS RUNNING OF CHROME  ----2
			//System.setProperty("webdriver.chrome.driver", "D:\\Rohit_Folder\\MAXIMUS\\Selenium Driver NEVER DELETE\\ChromeDriver 83\\chromedriver.exe");
			driver = new ChromeDriver(options);//FOR HEADLESS RUNNING OF CHROME  ----3
			
		}
		
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");//Dynamic Paths
			//System.setProperty("webdriver.firefox.driver", "D:\\Rohit_Folder\\MAXIMUS\\SELENIUM\\GeckoDriver\\geckodriver");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFIle = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFIle));
		return destinationFIle;
	
	}

}