package xueshe.com.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xueshe.com.dao.StudentClubDao;
import xueshe.com.model.Student;


@WebServlet("/StudentClubServlet")
public class StudentClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentClubServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String clno=request.getParameter("clno");
		Student student=(Student) request.getSession().getAttribute("student");
		String sno=student.getSno();
		StudentClubDao scd=new StudentClubDao();
		if(request.getParameter("option").equals("select")) {
			if(scd.insertStudentClub(sno,clno)==false) {
				request.setAttribute("message", "已加入该社团，请勿重复加入！！！");
				RequestDispatcher rd=request.getRequestDispatcher("club.jsp");
				rd.forward(request, response);
			}else {
				scd.insertStudentClub(sno,clno);
				request.setAttribute("message", "已加入该社团");
				RequestDispatcher rd=request.getRequestDispatcher("club.jsp");
				rd.forward(request, response);
			}	
		}		
		String url="club.jsp?clno="+request.getParameter("clno");
		response.sendRedirect(url);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
