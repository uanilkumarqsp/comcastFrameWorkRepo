import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class s {
public static void main(String[] args) {
	 String s ="sss";
	 StringBuilder sb=new StringBuilder(s);
	 
	 //StringBuffer ss = (StringBuffer)sb;
	 
	 WebDriver driver = new ChromeDriver();
	  getScreenShotAs(driver.findElement(By.className("  sss")));
	  TakesScreenshot s;
 }
}
