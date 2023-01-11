package xueshe.com.control;

import java.io.IOException;

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

@WebServlet("/ClubInfoServlet")
public class ClubInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClubInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String clno=request.getParameter("clno");
		ClubDao cd=new ClubDao();
		Club club=cd.getClubByCLno(clno);
		request.setAttribute("club", club);
		Student student=(Student) request.getSession().getAttribute("student");
		String sno=student.getSno();
		StudentClubDao scd=new StudentClubDao();
		if(scd.ifSelectedClub(sno, clno))
		{
			String href;
			String option;
			if(request.getParameter("option")!=null)//只可能是原来选课后先要删除，故不需要判断option是否是delete
			{
				scd.deleteStudentClub(sno, clno);
				href="ClubInfoServlet?option=select&clno="+clno;
				option="选择";
			}
			else
			{
				href="ClubInfoServlet?option=delete&clno="+clno;
				option="删除";
			}
			request.setAttribute("href", href);
			request.setAttribute("option", option);
			RequestDispatcher rd = request.getRequestDispatcher("/clubInfo.jsp?cno="+clno);
			rd.forward(request, response);
		}
		else
		{
			String href;
			String option;
			if(request.getParameter("option")!=null)//只可能是原来原来未选课要选课，故不需要判断option是否是select
			{
				scd.insertStudentClub(sno, clno);
				href="ClubInfoServlet?option=delete&clno="+clno;
				option="删除";
				
			}
			else
			{
				href="ClubInfoServlet?option=select&clno="+clno;
				option="选择";
			}
			request.setAttribute("href", href);
			request.setAttribute("option", option);
			RequestDispatcher rd = request.getRequestDispatcher("/clubInfo.jsp?clno="+clno);
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
