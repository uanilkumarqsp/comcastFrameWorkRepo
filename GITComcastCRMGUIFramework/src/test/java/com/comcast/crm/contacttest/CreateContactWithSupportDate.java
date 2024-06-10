package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

public class CreateContactWithSupportDate  extends BaseClass{
@Test
	public  void createContactWithSupportDate() throws Throwable {

		try {

		//read test script data from excel file
		
		String lastName = eu.getDataFromExcel("contact", 4, 2).toString()+ju.getRandomNumber();

	
		
		
		

		
		//driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		HomePage hp = new HomePage(driver);
		OrganizationPage op =  new OrganizationPage(driver);
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
//		driver.findElement(By.id("submitButton")).submit();
		
		//step 2: navigate to contacts module
		 
		hp.getContactLnk().click();
		//driver.findElement(By.linkText("Contacts")).click();
		
		//step 3: click on create contact
		
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContBtn().click();
		
		//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//step 4: enter all the details and create new contact
		
		CreateNewContactsPage cncp = new CreateNewContactsPage(driver);
		cncp.getContactLastName().sendKeys(lastName);
		
		//driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		//select todays date
		String startDate =ju.getSystemDataYYYYDDMM();
		String endDate=ju.getRequiedDataYYYYDDMM(25);
		
		cncp.getSupportStartDate().clear();
		//driver.findElement(By.name("support_start_date")).clear();
		cncp.getSupportStartDate().sendKeys(startDate);
		
		//driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		cncp.getSupportEndDate().clear();
		//driver.findElement(By.name("support_end_date")).clear();
		cncp.getSupportEndDate().sendKeys(ju.getRequiedDataYYYYDDMM(25));
		//driver.findElement(By.name("support_end_date")).sendKeys(ju.getRequiedDataYYYYDDMM(25));
		
		//save the contact
		
		cncp.getContactSaveBtn().click();
		//driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		
		// step 5: verify header msg expected result
		
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if (headerInfo.contains(lastName)) {
			System.out.println(lastName+" is created ==pass");
		} else {
			System.out.println(lastName+" is not created ==fail");
		}
		
		//step 6: verify start date
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actStartDate.contains(startDate)) {
			System.out.println(startDate+" is verified ==pass");

		} else {
			System.out.println(startDate+" is not verified ==fail");

		}
		//step 6: verify end date 
		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actEndDate.contains(endDate)) {
			System.out.println(endDate+" is verified ==pass");

		} else {
			System.out.println(endDate+" is not verified ==fail");

		}
		}
		catch(Exception e ) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			//driver.quit();
		}
	}

}



//WebDriver driver=null;
//
//JavaUtility  ju= new JavaUtility();
//WebDriverUtility wu = new WebDriverUtility();
//FileUtility fu = new FileUtility();
//ExcelUtility eu = new ExcelUtility();
//


////read common data from properties file
//
//
//String browser = fu.getDataFromPropertiesFile("browser");
//String url = fu.getDataFromPropertiesFile("url");
//String username = fu.getDataFromPropertiesFile("un");
//String password = fu.getDataFromPropertiesFile("pwd");
//
//

//if (browser.equalsIgnoreCase("chrome")) {
//driver=new ChromeDriver();
//}
//else if (browser.equalsIgnoreCase("edge")) {
//driver=new EdgeDriver();
//}
//else if (browser.equalsIgnoreCase("firefox")) {
//driver=new FirefoxDriver();
//}


//  LoginPage lp = new LoginPage(driver);

//lp.loginToapp(url,"admin", "admin");

//		Date dateObj=new Date();
//		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
//		
//	/*	String startDate = sim.format(dateObj);*/
//		
//		Calendar cal=sim.getCalendar();
//		cal.add(Calendar.DAY_OF_MONTH,30);
//		//String endDate = sim.format(cal.getTime());
//		//System.out.println(endDate);