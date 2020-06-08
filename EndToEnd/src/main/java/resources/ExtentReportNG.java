package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG 
{
	static ExtentReports extent;//Declare "ExtentReports extent" Globally so it can e be accessed outside also 


public static ExtentReports getReportObject() //***************************EXTENT REPORT CONFIGURAATION*****************************************
{
	String path = System.getProperty("user.dir")+"\\reports\\index.html"; //location of the project to create report
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);//EXTENTSPARTREPORTER object creation
	reporter.config().setReportName("Web Automation Results");////set report name
	reporter.config().setDocumentTitle("Test Result");//set document titel
	
	extent = new ExtentReports(); //Create ExtentReport object
	extent.attachReporter(reporter);//Attach report to this 
	extent.setSystemInfo("Tester", "Rohit");//Set Name & Value to hte report
	return extent;
	 
	
}


}
