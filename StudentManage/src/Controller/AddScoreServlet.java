package Controller;
 
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import Dao.AdministratorDao;
import Dao.ClassesDao;
import Dao.CourseDao;
import Dao.GradeDao;
import Dao.StudentDao;
import Model.Administrator;
import Model.Classes;
import Model.Course;
import Model.Grade;
import Model.Student;
 
@WebServlet("/AddScoreServlet")
public class AddScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String stuId = request.getParameter("stuId");
		String stuName = request.getParameter("stuName");
		String courseId = request.getParameter("courseId");
		String tcId = request.getParameter("tcId");
		String courseGrade = request.getParameter("courseGrade");
		String classId = request.getParameter("classId");
		
		try{
			StudentDao stuDao = new StudentDao();
			CourseDao courseDao = new CourseDao();
			AdministratorDao adminDao = new AdministratorDao();
			ClassesDao classesDao = new ClassesDao();
			GradeDao gradeDao = new GradeDao();
			
			Student stu = stuDao.find(stuId);
			Course course = courseDao.find(courseId);
			Administrator admin = adminDao.find(tcId);
			Classes classes = classesDao.find(classId);
			Grade grade = new Grade();
			
			grade.setStuId(stuId);
			grade.setStuName(stuName);
			grade.setCourseId(courseId);
			grade.setTcId(tcId);
			grade.setCourseGrade(courseGrade);
			grade.setClassId(classId);
			if (stu.getStuName() == null) {
				request.setAttribute("errerMsg", "姓名为空");
				request.getRequestDispatcher("/Jsp/AddScore.jsp").forward(request, response);
			}
			if(stu != null || stu.getStuName() == stuName){
				if(course != null){
					if(admin != null){
						if(classes != null){
							if(gradeDao.insert(grade)){
								response.sendRedirect(request.getContextPath() + "/Jsp/AddScore.jsp");
							}else{
								request.setAttribute("errerMsg", "添加失败");
								request.getRequestDispatcher("/Jsp/AddScore.jsp").forward(request, response);
							}
						}else{
							request.setAttribute("errerMsg", "没有该班级");
							request.getRequestDispatcher("/Jsp/AddScore.jsp").forward(request, response);
						}
					}else{
						request.setAttribute("errerMsg", "没有该教师ID");
						request.getRequestDispatcher("/Jsp/AddScore.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("errerMsg", "没有该课程ID");
					request.getRequestDispatcher("/Jsp/AddScore.jsp").forward(request, response);
				}
			} 
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
 
}