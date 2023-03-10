package xueshe.com.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xueshe.com.dao.ClubDao;
import xueshe.com.dao.StudentDao;
import xueshe.com.model.Club;
import xueshe.com.model.Student;


@WebServlet("/BackendLogin.do")
public class BackendLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BackendLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		ClubDao cd=new ClubDao();
		ArrayList<Club> clubList=new ArrayList<Club>();
		clubList=cd.findClubsByCLname("");
		request.setAttribute("clubList", clubList);
		HttpSession session=request.getSession(false); 
		session.setAttribute("clubList", clubList); 
		StudentDao studentdao=new StudentDao();
		Student student=studentdao.getStudentBySno("admin");
		session.setAttribute("student", student);
		if(username.equals("admin")&&password.equals("admin"))
		{
			request.getSession().setAttribute("login", "true");
			response.sendRedirect("backend/welcome.jsp");
		}
		else
		{
			request.getSession().setAttribute("message2", "密码错误");
			response.sendRedirect("backend/login.jsp");
		}
	}

}
