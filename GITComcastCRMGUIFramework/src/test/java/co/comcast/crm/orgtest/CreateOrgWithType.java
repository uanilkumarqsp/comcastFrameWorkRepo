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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
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

public class CreateOrgWithType extends BaseClass {
	@Test
	public void createOrgWithType() throws Throwable {

		// read test SCript data from excel file

		String orgName = eu.getDataFromExcel("org", 4, 2).toString() + ju.getRandomNumber();
		String industry = eu.getDataFromExcel("org", 4, 3).toString();
		String type = eu.getDataFromExcel("org", 4, 4).toString();

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
		op.getCreateNewOrgBtn().click();
		// driver.findElement(By.xpath("//img[@title='Create
		// Organization...']")).click();

		cnop.createOrg(orgName, industry, type);

		// verify industry and type informATION
		String actIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndustry.contains(industry)) {
			System.out.println(industry + "is created ==pass");
		} else {
			System.out.println(industry + "is  not created ==pass");
		}
		// verify header orgname info Expected result

		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actType.equals(type)) {
			System.out.println(type + "is created ==pass");
		} else {
			System.out.println(type + "is  not created ==pass");
		}

	}

}

//		JavaUtility  ju= new JavaUtility();
//		WebDriverUtility wu = new WebDriverUtility();
//		FileUtility fu = new FileUtility();
//		ExcelUtility eu = new ExcelUtility();
//		 
//		fu.getDataFromPropertiesFile("browser");
//		fu.getDataFromPropertiesFile("url");
//		fu.getDataFromPropertiesFile("un");
//		fu.getDataFromPropertiesFile("pwd");
//		
//		Properties pobj = new Properties();
//		FileInputStream fis = new FileInputStream("./configAppData/logindata.properties");
//		pobj.load(fis);
//		
//		//generate random number
//		Random r = new Random();
//		int randomInt = r.nextInt(1000);
//		
//		
//		//read the data from properties file
//		
//		
//		String Browser = fu.getDataFromPropertiesFile("browser");
//		String  URL= fu.getDataFromPropertiesFile("url");
//		String UN = fu.getDataFromPropertiesFile("un");
//		String PWD = fu.getDataFromPropertiesFile("pwd");
//		
//		WebDriver driver=null ;
//		if(Browser.equals("chrome"))
//		{
//			 driver = new ChromeDriver();
//		}
//		else if(Browser.equals("firefox"))
//		{
//			 driver = new FirefoxDriver();
//		}
//		else if(Browser.equals("egde"))
//		{
//			 driver = new EdgeDriver();
//		}
//		
//driver.get(URL);
//LoginPage lp = new LoginPage(driver);

//lp.loginToapp(URL,"admin", "admin");

//		driver.findElement(By.name("user_name")).sendKeys(UN);
//		driver.findElement(By.name("user_password")).sendKeys(PWD);
//		driver.findElement(By.id("submitButton")).click();;
// step 5 enter al the details & create new organization

//  cnop.createOrg(orgName, industry);
//driver .findElement(By.name("accountname")).sendKeys(orgName);
// WebElement wdsele =driver .findElement(By.name("industry"));
// Select sell = new Select(wdsele);
//
//sell.selectByVisibleText(industry);

//				 WebElement wdsele1 =driver .findElement(By.name("accounttype"));
//				 Select sell2 = new Select(wdsele1);
//				 sell2.selectByVisibleText(type);

//driver .findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
// step 5 logout 

//driver.quit();