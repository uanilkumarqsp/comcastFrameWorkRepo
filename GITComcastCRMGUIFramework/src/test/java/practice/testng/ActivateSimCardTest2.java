package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.generic.baseutility.BaseClass;
//@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)
public class ActivateSimCardTest2{

	@Test(retryAnalyzer = com.comcast.crm.generic.listenerutility.RetryListenerImp.class)
	public void createInvoiceTest()
	{
		System.out.println("execute createInvoiceTest");
		//String acttitle = driver.getTitle();
		//Assert.assertEquals("", "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
	
}
