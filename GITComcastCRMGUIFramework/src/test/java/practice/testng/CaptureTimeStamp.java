package practice.testng;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.openxmlformats.schemas.spreadsheetml.x2006.main.STSourceType;

public class CaptureTimeStamp {
public static void main(String[] args) {
	String time = new Date().toString().replace(" ","_").replace(":","_");
	System.out.println(time); 
	String string = LocalTime.now().toString();
	String string1 = LocalDateTime.now().toString();
	System.out.println(string);
	System.out.println(string1);
	
}
}
