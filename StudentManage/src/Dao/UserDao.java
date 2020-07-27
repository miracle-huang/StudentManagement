package Dao;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
 
import Model.User;
import Util.JDBCUtils;
 
public class UserDao {
	//添加登录记录
	public boolean insert(User user){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			//获取数据的连接
			conn = JDBCUtils.getConnection();
			//获取Statement对象
			stmt = conn.createStatement();
			//发送SQL语句
			String sql = "insert into user(username, password, identity)" +
						"values('"
						+ user.getUsername()
						+ "','"
						+ user.getPassword()
						+ "','"
						+ user.getIdentity()
						+ "')";
			int num = stmt.executeUpdate(sql);
			if(num > 0){
				return true;
			}
			return false;
		} catch(Exception ee) {
			ee.printStackTrace();
		} finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
	
}