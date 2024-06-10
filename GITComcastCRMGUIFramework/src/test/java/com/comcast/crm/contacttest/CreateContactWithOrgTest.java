package com.comcast.crm.contacttest;

import java.util.Random;

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
import com.comcast.crm.generic.objectrepositoryutility.OrganizationsListPopUpPage;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.generic.baseutility.BaseClass;

public class CreateContactWithOrgTest extends BaseClass {
	@Test
public  void createContactWithOrgTest() throws Throwable {


	// read test script data from excel file

	String lastName = eu.getDataFromExcel("contact", 7, 2).toString();
	String orgName = eu.getDataFromExcel("contact", 7, 3).toString() + ju.getRandomNumber();

	wu.waitForPageLoad(driver);

	driver.manage().window().maximize();
	// LoginPage lp = new LoginPage(driver);

	// lp.loginToapp(url,"admin", "admin");
	HomePage hp = new HomePage(driver);
	OrganizationPage op = new OrganizationPage(driver);
	CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
	OrganizationInformationPage oip = new OrganizationInformationPage(driver);

	// step 2: navigate to contact module

	hp.getOrgLink().click();
	op.getCreateNewOrgBtn().click();
	;

	cnop.createOrg(orgName);
	Thread.sleep(3000);
	hp.getContactLnk().click();
	// driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();

	// step 3: click on create contact

	ContactsPage cp = new ContactsPage(driver);
	cp.getCreateNewContBtn().click();
	// driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

	// step 4: enter all the details and create new organization

	CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
	cncp.getContactLastName().sendKeys(lastName);

	// driver.findElement(By.name("accountname")).sendKeys(orgName);
	// driver.findElement(By.xpath("//input[@class='crmbutton small
	// save']")).click();

	cncp.getAddOrgBtn().click();
	// driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

	// Thread.sleep(3000);

	// Switch to child window

	wu.switchToTabOnURL(driver, "module=Accounts");

	//
	Thread.sleep(3000);
	OrganizationsListPopUpPage olpp = new OrganizationsListPopUpPage(driver);
	olpp.getSearchtxt().sendKeys(orgName);
	// /* WebElement e =
	// */driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgName);
	// e.click();
	// e;
	// driver.findElement(By.name("search")).click();
	olpp.getSearchBtn().click();

	driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

	Thread.sleep(3000);
	// Switch to parent window

	wu.switchToTabOnURL(driver, "Contacts&action");

	driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();

	// verify last name
	String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
	if (actLastName.contains(lastName)) {
		System.out.println(lastName + " is created ==pass");

	} else {
		System.out.println(lastName + " is not created ==fail");

	}

	// verify org name

	String actOrgName1 = driver.findElement(By.id("mouseArea_Organization Name")).getText();
	if (actOrgName1.trim().equals(orgName)) {
		System.out.println(orgName + " information is created==PASS");
	} else {
		System.out.println(orgName + " information is not created==FAIL");

	}

	// driver.quit();

}
}

//JavaUtility  ju= new JavaUtility();
//WebDriverUtility wu = new WebDriverUtility();
//FileUtility fu = new FileUtility();
//ExcelUtility eu = new ExcelUtility();
//
//	WebDriver driver=null;
//	
//	
//	//read common data from properties file
//
//		
//		String browser = fu.getDataFromPropertiesFile("browser");
//		String url = fu.getDataFromPropertiesFile("url");
//		String username = fu.getDataFromPropertiesFile("un");
//		String password = fu.getDataFromPropertiesFile("pwd");
	
		//generate random number




//if (browser.equalsIgnoreCase("chrome")) {
//	driver=new ChromeDriver();
//}
//else if (browser.equalsIgnoreCase("edge")) {
//	driver=new EdgeDriver();
//}
//else if (browser.equalsIgnoreCase("firefox")) {
//	driver=new FirefoxDriver();
//}

//Random random=new Random();
//int randomInt = random.nextInt(1000);
//


//launching the browser


//
//creating organization

//step 1: login  to application
//driver.get(url);


//driver.get(url);
//driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
//driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
//driver.findElement(By.id("submitButton")).submit();
//

//
//String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
//if (actOrgName.contains(orgName)) {
//	System.out.println(orgName+" is created ==pass");
//
//} else {
//	System.out.println(orgName+" is not created ==fail");
//
//}




//step 5:navigate to contacts module
//driver.findElement(By.linkText("Contacts")).click();

//step 6: click on create contact
//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

//step 7: enter all the last name
//driver.findElement(By.name("lastname")).sendKeys(lastName);

