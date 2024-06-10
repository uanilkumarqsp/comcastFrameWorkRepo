package practice.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class SampleTestForScreenShot {
@Test
public void amazonTest() throws Throwable
{
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://amazon.com");
	
	
	
	//step -1 : create an object to eventFiring webDriver
	
	EventFiringWebDriver edriver = new EventFiringWebDriver(driver);
	
	//step 2 : use getScreenShotAs method to get file type of screenshot
	File screenshotAs = edriver.getScreenshotAs(OutputType.FILE);
	
	// Store Screen on local driver 
	FileUtils.copyFile(screenshotAs,new File(".\\ScreenShot.\\ss"+Math.random()+".png") );

driver.quit();
}
}
