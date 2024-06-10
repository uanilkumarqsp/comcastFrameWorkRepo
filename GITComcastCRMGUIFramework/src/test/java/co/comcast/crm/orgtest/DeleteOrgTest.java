package co.comcast.crm.orgtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.LoginPage;
import com.comcast.crm.generic.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.generic.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.generic.baseutility.BaseClass;

public class DeleteOrgTest extends BaseClass {
@Test
		
public void deleteOrgTest() throws Throwable {

	// read test SCript data from excel file

	String orgName = eu.getDataFromExcel("org", 10, 2).toString() + ju.getRandomNumber();
	// step 1 to login app

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	HomePage hp = new HomePage(driver);
	OrganizationPage op = new OrganizationPage(driver);
	CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
	OrganizationInformationPage oip = new OrganizationInformationPage(driver);
	// step2 navigate to organization module
	hp.getOrgLink().click();
	// driver.findElement(By.linkText("Organizations")).click();;

	// step 3 click on create organization Button
	// driver.findElement(By.xpath("//img[@title='Create
	// Organization...']")).click();
	op.getCreateNewOrgBtn().click();
	// step 5 enter al the details & create new organization

	cnop.createOrg(orgName);
	// driver .findElement(By.name("accountname")).sendKeys(orgName);
	// driver .findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	// verify header msg Expected result

	// String headerinfo =driver
	// .findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	String actOrgName = oip.getHeaderMsg().getText();
	if (actOrgName.contains(orgName)) {
		System.out.println(orgName + "is created ==pass");
	} else {
		System.out.println(orgName + "is  not created ==pass");
	}
	// verify header orgname info Expected result

	String actorgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
	if (actorgname.equals(orgName)) {
		System.out.println(orgName + "is created ==pass");
	} else {
		System.out.println(orgName + "is  not created ==pass");
	}
	hp.getOrgLink().click();
	op.getSearchEdt().sendKeys(orgName);

	wu.select(op.getSearchDD(), "Organization Name");
	Thread.sleep(1000);

	op.getSearchBtn().click();

	WebElement delete = driver.findElement(By.xpath("//a[text() = '" + orgName + "']/../../td[8]/a[text() = 'del']"));
	delete.click();
	driver.switchTo().alert().accept();
	System.out.println(orgName + " deleted Successfully");

}

}

//		JavaUtility  ju= new JavaUtility();
//		WebDriverUtility wu = new WebDriverUtility();
//		FileUtility fu = new FileUtility();
//		ExcelUtility eu = new ExcelUtility();
//		
//		//read the data from properties file
//		String browser = fu.getDataFromPropertiesFile("browser");
//		String url = fu.getDataFromPropertiesFile("url");
//		String username = fu.getDataFromPropertiesFile("un");
//		String password = fu.getDataFromPropertiesFile("pwd");
//		
//		WebDriver driver=null ;
//		
//		if(browser.equals("chrome"))
//		{
//			 driver = new ChromeDriver();
//		}
//		else if(browser.equals("firefox"))
//		{
//			 driver = new FirefoxDriver();
//		}
//		else if(browser.equals("egde"))
//		{
//			 driver = new EdgeDriver();
//		}
//driver.get(url);

//		LoginPage lp = new LoginPage(driver);
//		
//		lp.loginToapp(url,"admin", "admin");
//	
//		driver.findElement(By.name("user_name")).sendKeys(username);
//		driver.findElement(By.name("user_password")).sendKeys(password);
//		driver.findElement(By.id("submitButton")).click();;
//	
// step 5 logout 

// hp.logout();

//driver.quit();