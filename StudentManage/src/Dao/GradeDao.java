package Dao;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
 
import Model.Grade;
import Util.JDBCUtils;
 
public class GradeDao {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	//添加成绩操作
	public boolean insert(Grade grade){
		try {
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into grade (stuId, stuName, courseId, tcId, courseGrade, classId) "
					+ "values('"
					+ grade.getStuId()
					+ "','"
					+ grade.getStuName()
					+ "','"
					+ grade.getCourseId()
					+ "','"
					+ grade.getTcId()
					+ "','"
					+ grade.getCourseGrade()
					+ "','"
					+ grade.getClassId()
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
	
	//查询所有的grade对象
	public ArrayList<Grade> findAll(){
		ArrayList<Grade> list = new ArrayList<Grade>();
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from grade";
			System.out.println("查询所有的SQL语句：" + sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Grade grade = new Grade();
				grade.setCourseId(rs.getString("courseId"));
				grade.setStuName(rs.getString("stuName"));
				grade.setCourseGrade(rs.getString("courseGrade"));
				grade.setStuId(rs.getString("stuId"));
				grade.setTcId(rs.getString("tcId"));
				grade.setClassId(rs.getString("classId"));
				list.add(grade);
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
	public ArrayList<Grade> find(String stuId){
		ArrayList<Grade> list = new ArrayList<Grade>();
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from grade where stuId = '" + stuId + "'";
			rs = stmt.executeQuery(sql);
			System.out.println("单个查询SQL语句：" + sql);
			while (rs.next()) {
				Grade grade = new Grade();
				grade.setCourseId(rs.getString("courseId"));
				grade.setStuName(rs.getString("stuName"));
				grade.setCourseGrade(rs.getString("courseGrade"));
				grade.setStuId(rs.getString("stuId"));
				grade.setTcId(rs.getString("tcId"));
				grade.setClassId(rs.getString("classId"));
				list.add(grade);
			}
			return list;
		}catch(Exception ee){
			ee.printStackTrace();
		}finally{
			JDBCUtils.release(rs, stmt, conn);
		}
		return null;
	}
	
	//删除成绩
	public boolean delete(Grade grade){
		try{
			conn = JDBCUtils.getConnection();
			stmt = conn.createStatement();
			String sql = "delete from grade where stuId= '" + grade.getStuId()
							+ "' and stuName = '" + grade.getStuName()
							+ "' and courseId = '" + grade.getCourseId()
							+ "' and tcId = '" + grade.getTcId()
							+ "' and courseGrade = '" + grade.getCourseGrade()
							+ "' and classId = '" + grade.getClassId()
							+ "'";
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
	
	//修改成绩
	public boolean update(Grade grade){
	try{
		conn = JDBCUtils.getConnection();
		stmt = conn.createStatement();
		String sql = "update grade set "
					+ "courseGrade='" + grade.getCourseGrade() 
					+ "' where stuId='" + grade.getStuId()
					+"' and stuName= '" + grade.getStuName()
					+"' and courseId='" + grade.getCourseId()
					+"' and tcId='"  + grade.getTcId()
					+"' and classId='" + grade.getClassId()
					+ "'";
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