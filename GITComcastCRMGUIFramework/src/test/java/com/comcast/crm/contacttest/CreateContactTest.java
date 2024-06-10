package com.comcast.crm.contacttest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.objectrepositoryutility.ContactsPage;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewContactsPage;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.LoginPage;
import com.comcast.crm.generic.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.generic.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.generic.baseutility.BaseClass;

public class CreateContactTest extends BaseClass {
@Test
public void createContactTest() throws Throwable {
	// WebDriver driver=null;

//		JavaUtility  ju= new JavaUtility();
//		WebDriverUtility wu = new WebDriverUtility();
//		FileUtility fu = new FileUtility();
//		ExcelUtility eu = new ExcelUtility();

	try {

		// read test script data from excel file

		String lastName = eu.getDataFromExcel("contact", 1, 2) + ju.getRandomNumber();

		// step 1: login to application

		// driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();

		HomePage hp = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);

		// step 2: navigate to contacts module

		hp.getContactLnk().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContBtn().click();

		// step 4: enter all the details and create new contact

		CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
		cncp.getContactLastName().sendKeys(lastName);
		// driver.findElement(By.name("lastname")).sendKeys(lastName);

		cncp.getContactSaveBtn().click();
		// driver.findElement(By.xpath("//input[@class='crmButton small
		// save']")).click();

		// step 5: verify header msg expected result

		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (headerInfo.contains(lastName)) {
			System.out.println(lastName + " is created ==pass");
		} else {
			System.out.println(lastName + " is not created ==fail");
		}

		// step 6: verify last name
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.contains(lastName)) {
			System.out.println(lastName + " is created ==pass");

		} else {
			System.out.println(lastName + " is not created ==fail");

		}
	}

	catch (Exception e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
	} finally {
		// driver.quit();
	}
}

}
/*create Object */

//read common data from properties file

//String browser = fu.getDataFromPropertiesFile("browser");
//String url = fu.getDataFromPropertiesFile("url");
//String username = fu.getDataFromPropertiesFile("un");
//String password = fu.getDataFromPropertiesFile("pwd");
//


//if (browser.equalsIgnoreCase("chrome")) {
//	driver=new ChromeDriver();
//}
//else if (browser.equalsIgnoreCase("edge")) {
//	driver=new EdgeDriver();
//}
//else if (browser.equalsIgnoreCase("firefox")) {
//	driver=new FirefoxDriver();
//}
//creating organization


//LoginPage lp = new LoginPage(driver);

		//lp.loginToapp(url,"admin", "admin");


//
//driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
//driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
//driver.findElement(By.id("submitButton")).submit();
//

//driver.findElement(By.linkText("Contacts")).click();

		//step 3: click on create contact
		//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		











