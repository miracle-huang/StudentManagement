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
import Dao.StudentDao;
import Model.Student;
import Model.User;
import Model.Grade;
 
@WebServlet("/FindScoreServlet")
public class FindScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		User users = (User)request.getSession().getAttribute("user");	
		String id = null;
		if (users.getIdentity() == "admin") {
			id = request.getParameter("id");
		} else if (users.getIdentity() == "student") {
			id = users.getUsername();
		}
		String func = request.getParameter("func");
		
		try {
			StudentDao stuDao = new StudentDao();
			Student student = stuDao.find(id);
			if(student != null){
				try {
					GradeDao gradeDao = new GradeDao();
					ArrayList<Grade> list = (ArrayList<Grade>) gradeDao.find(id);
					session.setAttribute("grade", list);
					if(func.equals("show")){
						response.sendRedirect(request.getContextPath() + "/Jsp/FindScore.jsp");
					}else{
						response.sendRedirect(request.getContextPath() + "/Jsp/UpdDelScore.jsp");
					}
				} catch(Exception ee) {
					ee.printStackTrace();
				}
			}else{
				request.setAttribute("errerMsg", "没有该学生");
				if(func.equals("show")){
					request.getRequestDispatcher("/Jsp/FindScore.jsp").forward(request, response);
				}else{
					request.getRequestDispatcher("/Jsp/UpdDelScore.jsp").forward(request, response);
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