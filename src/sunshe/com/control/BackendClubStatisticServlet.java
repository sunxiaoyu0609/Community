package xueshe.com.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xueshe.com.dao.ClubDao;
import xueshe.com.dao.CourseDao;
import xueshe.com.dao.StudentClubDao;
import xueshe.com.dao.StudentDao;
import xueshe.com.model.Club;
import xueshe.com.model.Course;
import xueshe.com.model.CourseCount;
import xueshe.com.model.Student;


@WebServlet(name="BackendClubStatisticServlet",urlPatterns={"/BackendClubStatisticServlet","/BackendClubStatisticServlet.do"})
public class BackendClubStatisticServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BackendClubStatisticServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String option=request.getParameter("option");
		String sno=request.getParameter("sno");
		String CLno=request.getParameter("CLno");
		StudentClubDao studentClubDao=new StudentClubDao();
		Student student=new Student();
		if(option.equals("delete"))
		{
			student.setSno(request.getParameter("sno"));
			studentClubDao.deleteStudentClub(sno, CLno);
			response.sendRedirect("backend/studentclublist.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ClubDao clubDao=new ClubDao();
		String clno=request.getParameter("clno");
		Club club=clubDao.getClubByCLno(clno);
		System.out.println(clno);
		StudentClubDao sc=new StudentClubDao();
		ArrayList<Student> studentList=new ArrayList<Student>();
		studentList=sc.getStudentByClno(clno);
		int count=sc.getStudenNumbertByClno(clno);
		String sno=request.getParameter("sno");
		String CLno=request.getParameter("CLno");
		
		
		
		if(request.getParameter("option")!=null)
		{
			if(request.getParameter("option").equals("delete"))
			{
				StudentClubDao studentClubDao=new StudentClubDao();
				Student student=new Student();
				student.setSno(request.getParameter("sno"));
				studentClubDao.deleteStudentClub(sno, CLno);
//				student.setSname(request.getParameter("sname"));
//				student.setSsex(request.getParameter("ssex"));
//				student.setSpassword(request.getParameter("spassword"));
//				sd.updateStudent(student);
				response.sendRedirect("backend/studentclublist.jsp");
				return;
			}
		}
//
//		
//		String sname = request.getParameter("sname");
//		String ssex = request.getParameter("ssex");
//		String sno = request.getParameter("sno");
//		String spassword = request.getParameter("spassword");
//
//		StudentDao sd = new StudentDao();
//		if (sd.getStudentBySno(sno) == null) {
//			Student student = new Student();
//			student.setSname(sname);
//			student.setSno(sno);
//			student.setSpassword(spassword);
//			student.setSsex(ssex);
//			sd.insertStudent(student);
//			request.setAttribute("message", "添加学生成功");
//		} else {
//			request.setAttribute("message", "已经存在该学号，请前往修改");
//		}
		for(Student student:studentList) {
			System.out.println(student.getSname());
		}
		
		request.setAttribute("studentList", studentList);
		request.setAttribute("club", club);
		request.setAttribute("count", count);
		RequestDispatcher rd = request.getRequestDispatcher("backend/studentclublist.jsp");
		rd.forward(request, response);
	}

}
