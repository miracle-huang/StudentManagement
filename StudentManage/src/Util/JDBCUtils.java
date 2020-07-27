package Util;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class JDBCUtils {
	// 加载驱动，并建立数据库连接
	public static Connection getConnection() throws SQLException,
				ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//注意：8.0的MySQL，所以连接方式不一样
		String url = "jdbc:mysql://localhost:3306/stu_db?useSSL=FALSE&serverTimezone=UTC";	
		String Name = "root";
		String password = "951753wnu";
			Connection conn = DriverManager.getConnection(url, Name, password);
			return conn;
		}
		// 关闭数据库连接，释放资源
		public static void release(Statement stmt, Connection conn) {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
	     public static void release(ResultSet rs, Statement stmt, 
	     		Connection conn){
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			release(stmt, conn);
		}	
}