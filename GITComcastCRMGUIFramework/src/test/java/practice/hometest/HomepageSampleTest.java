package practice.hometest;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class HomepageSampleTest {
	SoftAssert assertobj = new SoftAssert();
@Test
public void homePageTest(Method mtd)
{
	Reporter.log(mtd.getName()+" starts",true);
	Reporter.log("step-1",true);
	Reporter.log("step-2",true);
	
	assertobj.assertEquals("Home", "Home");
	Reporter.log("step-3",true);
	assertobj.assertEquals("Home-crm", "Home-crm");
	Reporter.log("step-4",true);
	Reporter.log(mtd.getName()+" end ",true);
	assertobj.assertAll();
	// Hard assert 
	
	
}

@Test
public void verifyLogoHomePageTest(Method mtd)
{
	Reporter.log(mtd.getName()+" starts",true);
	Reporter.log("step-1",true);
	Reporter.log("step-2",true);
	assertobj.assertTrue(true);
	Reporter.log("step-3",true);
	Reporter.log("step-4",true);
	assertobj.assertAll();
	
}
}
