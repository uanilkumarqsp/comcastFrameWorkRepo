package practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	ExtentReports report;
	@BeforeSuite
	public void configBS()
	{
		
		//spark report config 
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("crm test suite results");
		spark.config().setReportName("crm report");
		spark.config().setTheme(Theme.DARK);
		
		// env information & create Test
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}
	@AfterSuite
	public void configAS()
	{
		report.flush();
		
	}
	
@Test(priority = 1)
public void createContactTest()
{    
	
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://localhost:8888");
	
	
	TakesScreenshot edriver = (TakesScreenshot) driver;
	String filepath = edriver.getScreenshotAs(OutputType.BASE64);
	System.out.println(filepath);
	
	
	  ExtentTest test = report.createTest("createContactTest");
	  
	
	
	test.log(Status.INFO,"login to app");
	test.log(Status.INFO,"navigate to contactpage");
	test.log(Status.INFO,"create contact ");
	if("HDFC".equals("HDC"))
		test.log(Status.PASS,"contact is created ");
	else {
		test.log(Status.FAIL,"contact is not  created ");
		test.addScreenCaptureFromBase64String(filepath,"error file ");}
	
		driver.close();
}


}
