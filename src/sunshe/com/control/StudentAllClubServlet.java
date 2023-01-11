package xueshe.com.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xueshe.com.dao.ClubDao;
import xueshe.com.dao.StudentClubDao;
import xueshe.com.model.Club;
import xueshe.com.model.Student;

@WebServlet("/StudentAllClubServlet")
public class StudentAllClubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentAllClubServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String sno=request.getParameter("sno");
		String CLno=request.getParameter("CLno");
		 /* String CLabout = request.getParameter("CLabout");   new   */
		StudentClubDao studentClubDao=new StudentClubDao();	
		 /* ClubDao clubdao=new ClubDao();  new   */
		System.out.println(sno);
		System.out.println(CLno);
		/*System.out.println(CLabout);   new   */
		if (request.getParameter("option").equals("delete")) {
				studentClubDao.deleteStudentClub(sno, CLno);
				 /* clubdao.deleteStudentClub(CLno,CLabout); new   */
				response.sendRedirect("myClub.jsp");
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sno=request.getParameter("sno");
		String CLno=request.getParameter("CLno");
		/*String CLabout = request.getParameter("CLabout");   new   */
		StudentClubDao studentClubDao=new StudentClubDao();	
		/*ClubDao clubdao=new ClubDao();   new   */
			if (request.getParameter("option").equals("delete")) {
				studentClubDao.deleteStudentClub(sno, CLno);
				/*clubdao.deleteStudentClub(CLno,CLabout);   new   */
				response.sendRedirect("myClub.jsp");
			}
	}

}
