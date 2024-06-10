package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomepageVerificationTest {
@Test
public void homePageTest(Method mtd)
{
	System.out.println(mtd.getName()+" starts");
	String expectedPage ="Home page ";
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://localhost:8888");
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	
	// Hard assert 
	Assert.assertEquals(expectedPage, actTitle);
	driver.close();
	
}

@Test
public void verifyLogoHomePageTest(Method mtd)
{
	System.out.println(mtd.getName()+" starts");
	
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("http://localhost:8888");
	
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	 boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
	 // Hard assert 
	 Assert.assertEquals(true,status);
	 Assert.assertTrue(status);
	 driver.close();
	 
}
}
