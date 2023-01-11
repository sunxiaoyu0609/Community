<%@page import="xueshe.com.model.Club"%>
<%@page import="xueshe.com.dao.StudentClubDao"%>
<%@page import="xueshe.com.dao.ClubDao"%>    <!--   new      -->  
<%@page import="xueshe.com.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,xueshe.com.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="style/club/club.css" type="text/css">
<link rel="stylesheet" href="style/club/myclub.css" type="text/css">
<title>我的社团</title>
</head>
<body>
	<div class="body">
		<jsp:include page="header.jsp"></jsp:include>
		<div class="content">
			<div id="clubs_h">
				<div class="decoration_block"></div>
				<div class="decoration_note">我加入的社团</div>
			 	 <%Student student = (Student) request.getSession().getAttribute("student");
			 	 	/* Club club=(Club) request.getSession().getAttribute("club"); */
			 	 %>
				<%--  <%out.print(student.getSname());%> --%>
				
				<div class="clubs">
					<!-- 社团名称 -->
					<table border="1">
						<tr>
						  <th>社团名称</th>
						  <th>社团logo</th>
						  <th>操作</th>
						</tr>
						<tr>
						  <%StudentClubDao scd = new StudentClubDao();
					 			ArrayList<Club> ClubList = scd.getAllSelectedClubs(student.getSno());
								for(Club club:ClubList) {
							%><td class="cname"><a><%out.println(club.getCLname()); %></a></td>
						  <td><img src="images/clubs/<%=club.getCLno()%>/thumbnail.jpg"></td>
						  <td class="operate"><a href="StudentAllClubServlet?option=delete&sno=${student.sno}&CLno=<%=club.getCLno()%>">退出该社团</a><br></td>
						</tr><%}%>
						
					</table>
				</div>
			</div>
			<div id="club_course">
				<ul id="course_list">
					<c:forEach var="Course" items="${ClubList}" varStatus="status">
						<li class="course_item">
							<div class="course">
								<a href="ClubInfoServlet?clno=${Club.clno}">
								<div class="course_name">${Club.clname}</div>
								</a>
								<a href="myClub.jsp?option=delete&clno=${Club.clno}">
									<div class="select_button">退出</div>
								</a>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>