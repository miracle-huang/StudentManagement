package Controller;
 
import java.io.IOException;
import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import Dao.GradeDao;
import Model.Grade;
 
@WebServlet("/DelScoreServlet")
public class DelScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String stuId = request.getParameter("stuId");
		String stuName = request.getParameter("stuName");
		String courseId = request.getParameter("courseId");
		String tcId = request.getParameter("tcId");
		String classId = request.getParameter("classId");
		String grade = request.getParameter("grade");
		
		Grade grades = new Grade();
		grades.setStuId(stuId);
		grades.setStuName(stuName);
		grades.setCourseId(courseId);
		grades.setTcId(tcId);
		grades.setClassId(classId);
		grades.setCourseGrade(grade);
		
		HttpSession session = request.getSession();
		ArrayList<Grade> list = (ArrayList<Grade>) session.getAttribute("grade");
        try {
			GradeDao gradeDao = new GradeDao();
			if (gradeDao.delete(grades)) {
				 for(int j=0;j<list.size();j++){
		             if(list.get(j) == null){
		                 list.remove(j);
		             }
		             if(list.get(j)!=null && list.get(j).getStuId().equals(stuId)
		            	&& list.get(j).getCourseId().equals(courseId)
		            	&& list.get(j).getStuName().equals(stuName)
		            	&& list.get(j).getTcId().equals(tcId)
		            	&& list.get(j).getCourseGrade().equals(grade)
		            	&& list.get(j).getClassId().equals(classId)){
		            		 list.remove(j);
		            		 break;
		            	 }
		          }
				 response.sendRedirect(request.getContextPath() + "/Jsp/UpdDelScore.jsp");
			} else {
				request.setAttribute("errerMsg", "删除失败");
				request.getRequestDispatcher("/Jsp/UpdDelScore.jsp").forward(request, response);
			}
        } catch (Exception ee) {
        	ee.printStackTrace();
        }
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
 
}