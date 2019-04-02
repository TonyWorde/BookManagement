package DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DBUtil {
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static{
		try {
			ResourceBundle rb = ResourceBundle.getBundle("config");
			driver = rb.getString("driver");
			url = rb.getString("url");
			username =rb.getString("username");
			password = rb.getString("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static Connection open(){
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void close(Connection conn,Statement stmt){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}