/**
 * 
 */
package b2k.generic.mysql.function;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * @author khai.nld
 *
 */
public class MyConnection {
	
	public static Connection getMySQlConnection(String hostName, String port, String dataName, String username, String password){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://"+hostName+":"+port+"/"+dataName,username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static Connection mySQlConnection(){
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://"+"localhost"+":"+"3306"+"/"+"hotel_dl","root", "password");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
