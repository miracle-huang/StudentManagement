package Dao;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
 
import Model.Course;
import Util.JDBCUtils;
 
public class CourseDao {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	//添加课程操作
	public boolean insert(Course course){
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into course (courseId, courseTime, credit, courseName) "
					+ "values('"
					+ course.getCourseId()
					+ "','"
					+ course.getCourseTime()
					+ "',"
					+ course.getCredit()
					+ ",'"
					+ course.getCourseName()
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
	
	//查询所有的course对象
	public ArrayList<Course> findAll(){
		ArrayList<Course> list = new ArrayList<Course>();
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from course";
			System.out.println("查询所有的SQL语句：" + sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getString("courseId"));
				course.setCourseName(rs.getString("courseName"));
				course.setCredit(rs.getInt("credit"));
				course.setCourseTime(rs.getString("CourseTime"));
				list.add(course);
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
	public Course find(String courseId){
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from course where courseId = '" + courseId + "'";
			rs = stmt.executeQuery(sql);
			System.out.println("单个查询SQL语句：" + sql);
			while (rs.next()) {
				Course course = new Course();
				course.setCourseId(rs.getString("CourseId"));
				course.setCourseName(rs.getString("CourseName"));
				course.setCredit(rs.getInt("Credit"));
				course.setCourseTime(rs.getString("CourseTime"));
				return course;
			}
			return null;
		}catch(Exception ee){
			ee.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	
	//删除班级
	public boolean delete(String courseId){
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "delete from course where courseId= '" + courseId + "'";
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
	
	//修改班级
	public boolean update(Course course){
	try{
		conn = JDBCUtils.getConnection();
		stmt = conn.createStatement();
		String sql = "update course set courseTime='" + course.getCourseTime() 
					+ "',credit=" + course.getCredit()
					+ ",courseName='" + course.getCourseName() 
					+ "' where courseId='" + course.getCourseId() + "'";
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