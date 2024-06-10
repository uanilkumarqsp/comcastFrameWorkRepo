

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.mysql.cj.jdbc.Driver;

public class NonSelectExecution {
	public static void main(String[] args) throws Throwable {
		 Connection con= null;
		 DataBaseUtility dbu = new DataBaseUtility();
		 
		try {
			//step 1 register to database
			dbu.getDbConnection("JDBC:mysql://106.51.90.215:3333/projects","root@%","root");
			
			
			
			//step 3 create a query ad Statement 
			String query="INSERT INTO project VALUE('TY_PROJ_7909', 'Robertz', '10/05/2024', 'FireFlink_8957744' ,'Completed', 0)";
			 int result = dbu.executenonSelectQuery(query);
			
			
			 
			 // step 5 fetch the data 
			System.out.println(result);
			
			dbu.closeDbConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		 // finally { con.close(); }
		 
	}
}
