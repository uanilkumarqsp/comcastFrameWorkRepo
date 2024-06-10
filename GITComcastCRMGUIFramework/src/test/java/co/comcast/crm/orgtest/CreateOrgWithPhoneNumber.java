package co.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import com.comcast.crm.generic.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.generic.objectrepositoryutility.HomePage;
import com.comcast.crm.generic.objectrepositoryutility.LoginPage;
import com.comcast.crm.generic.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.generic.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.generic.baseutility.BaseClass;

public class CreateOrgWithPhoneNumber  extends BaseClass{
	@Test
	public void createOrgWithPhoneNumber() throws Throwable {

		// read test SCript data from excel file

		String orgName = eu.getDataFromExcel("org", 10, 2).toString() + ju.getRandomNumber();
		String phoneNumber = eu.getDataFromExcel("org", 10, 3).toString();

		// step 1 to login app
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.get(url);

		HomePage hp = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);

		// step2 navigate to organization module
		
		hp.getOrgLink().click();
        // driver.findElement(By.linkText("Organizations")).click();;

		// step 3 click on create organization Button
		
		op.getCreateNewOrgBtn().click();
         // driver.findElement(By.xpath("//img[@title='Create
		// Organization...']")).click();

		// step 5 enter al the details & create new organization

		cnop.createOrg(orgName);
		cnop.getPhoneNumEdt().sendKeys(phoneNumber);
		cnop.getSaveBtn();

		// verify header msg Expected result
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerinfo.contains(orgName)) {
			System.out.println(orgName + "is created ==pass");
		} else {
			System.out.println(orgName + "is  not created ==pass");
		}
		// verify header orgname info Expected result

		String actornum = driver.findElement(By.id("dtlview_Phone")).getText();
		if (actornum.equals(phoneNumber)) {
			System.out.println(phoneNumber + "is created ==pass");
		} else {
			System.out.println(phoneNumber + "is  not created ==pass");
		}

	}

}

//		JavaUtility  ju= new JavaUtility();
//		WebDriverUtility wu = new WebDriverUtility();
//		FileUtility fu = new FileUtility();
//		ExcelUtility eu = new ExcelUtility();
//		
//		
//		//generate random number
//		Random r = new Random();
//		int randomInt = r.nextInt(1000);
//		
//		
//		//read the data from properties file
//		String browser = fu.getDataFromPropertiesFile("browser");
//		String url = fu.getDataFromPropertiesFile("url");
//		String username = fu.getDataFromPropertiesFile("un");
//		String password = fu.getDataFromPropertiesFile("pwd");
//		
//		WebDriver driver=null ;
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
//LoginPage lp = new LoginPage(driver);
//lp.loginToapp(url,"admin", "admin");

//		driver.findElement(By.name("user_name")).sendKeys(username);
//		driver.findElement(By.name("user_password")).sendKeys(password);
//		driver.findElement(By.id("submitButton")).click();;
//		
// step 5 logout 
// hp.logout();
//driver.quit();

//driver .findElement(By.name("accountname")).sendKeys(orgName);
//driver .findElement(By.id("phone")).sendKeys(phoneNumber);
//driver .findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();