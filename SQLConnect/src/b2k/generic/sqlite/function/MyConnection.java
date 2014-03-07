/**
 * 
 */
package b2k.generic.sqlite.function;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author khai.nld
 * 
 */
public class MyConnection {


	public static Connection getSQLiteConnection(String database) {
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + database);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
