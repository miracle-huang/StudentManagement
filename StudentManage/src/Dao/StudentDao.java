package Dao;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
 
import Model.Student;
import Util.JDBCUtils;
 
public class StudentDao {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	//添加学生操作
	public boolean insert(Student student){
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into student (stuId, stuName, stuSex, stuClassId, stuPassword) "
					+ "values('"
					+ student.getStuId()
					+ "','"
					+ student.getStuName()
					+ "','"
					+ student.getStuSex()
					+ "','"
					+ student.getStuClassId()
					+ "','"
					+ student.getStuPassword()
					+ "')";
			System.out.println("添加SQL语句为：" + sql);
			int num = stmt.executeUpdate(sql);
			if (num > 0){
				return true;
			}
			return false;
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
	
	//查询所有的student对象
	public ArrayList<Student> findAll(){
		ArrayList<Student> list = new ArrayList<Student>();
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from student";
			System.out.println("查询所有的SQL语句：" + sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Student student = new Student();
				student.setStuId(rs.getString("stuId"));
				student.setStuName(rs.getString("stuName"));
				student.setStuSex(rs.getString("stuSex"));
				student.setStuClassId(rs.getString("stuClassId"));
				student.setStuPassword(rs.getString("stuPassword"));
				list.add(student);
			}
			return list;
		} catch(Exception ee) {
			ee.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	
	//根据ID查询
	public Student find(String stuId){
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from student where stuId = '" + stuId + "'";
			rs = stmt.executeQuery(sql);
			System.out.println("单个查询SQL语句：" + sql);
			while (rs.next()) {
				Student student = new Student();
				student.setStuId(rs.getString("stuId"));
				student.setStuName(rs.getString("stuName"));
				student.setStuSex(rs.getString("stuSex"));
				student.setStuClassId(rs.getString("stuClassId"));
				student.setStuPassword(rs.getString("stuPassword"));
				return student;
			}
			return null;
		}catch(Exception ee){
			ee.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	
	//删除学生
	public boolean delete(String stuId){
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "delete from student where stuId='" + stuId + "'";
			System.out.println("删除的SQL语句是：" + sql);
			int num = stmt.executeUpdate(sql);
			if (num > 0){
				return true;
			}
			return false;
		} catch (Exception ee){
			ee.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
	
	//修改用户
	public boolean update(Student student){
	try{
		conn = JDBCUtils.getConnection();
		stmt = conn.createStatement();
		String sql = "update student set stuName='" + student.getStuName() 
					+ "',stuSex='" + student.getStuSex()
					+ "',stuClassId='" + student.getStuClassId() 
					+ "',stuPassword='"+ student.getStuPassword() 
					+ "' where stuId='" + student.getStuId() + "'";
		System.out.println("修改的SQL语句是：" + sql);
		int num = stmt.executeUpdate(sql);
		if (num > 0){
			return true;
		}
		return false;
		} catch (Exception ee){
			ee.printStackTrace();
		} finally {
			JDBCUtils.release(rs, stmt, conn);
		}
		return false;
	}
	
}