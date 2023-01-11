package xueshe.com.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xueshe.com.dao.StudentCourseDao;
import xueshe.com.dao.StudentDao;
import xueshe.com.model.Club;
import xueshe.com.model.Course;
import xueshe.com.model.Student;

@WebServlet(name="LoginServlet",urlPatterns={"/login.do"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		StudentDao studentdao=new StudentDao();
		//传课程
//		StudentCourseDao scd = new StudentCourseDao();
//		Student student2 = (Student) request.getSession().getAttribute("student");
//		String sno = student2.getSno();
//		Calendar a = Calendar.getInstance();
//		String currentYear = "" + a.get(Calendar.YEAR);
//		ArrayList<Course> CourseList = scd.getAllSelectedCoursesIgnoreClub(sno,currentYear);
		HttpSession session=request.getSession(false); 
//		session.setAttribute("CourseList", CourseList);
		try {
			Student student=studentdao.getStudentBySno(username);
			if(student==null)
			{
				request.setAttribute("message", "不存在该学生");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}else if(!student.getSpassword().equals(password)){
				request.setAttribute("message", "学号或密码错误");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			else{
				session.setAttribute("student", student);
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
