<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,xueshe.com.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${club.CLname}-详情</title>
<link rel="stylesheet" href="style/club/club.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
/* $(document).ready(function(){
	$("#no_button").hover(function(){
		$("#club_about #select_button").show();
	});
})
 */
 function show(x){
	x.next.style.display="block";
}
</script>
</head>
<body>
	<div class="body">
		<jsp:include page="header.jsp"></jsp:include>

		<div class="content_wrap">
			<div class="content">
				<div id="clubs_h">
					<div class="decoration_block"></div>
					<div class="decoration_note">社团名称</div>
				</div>
				<div id="club_name">${club.CLname}</div>
				<div id="clubs_h">
					<div class="decoration_block"></div>
					<div class="decoration_note">社团简介</div>
				</div>
				<div id="club_about">${club.CLabout}</div>
				<div id="clubs_h">
					<div class="decoration_block"></div>
					<div class="decoration_note">加入社团</div>
				</div>
				<div id="club_about">
								<a href="StudentClubServlet?option=select&clno=${club.CLno}">
									<div class="select_button" id="select_button">未加入?<span>申请加入</span></div>
									<p style="color:red">${message}</p>
								</a>
				</div>
				<div id="clubs_h">
					<div class="decoration_block"></div>
					<div class="decoration_note">可选课程</div>
				</div>
				<div id="club_course">
					<ul id="course_list">
					<c:forEach var="unselectedCourse" items="${unselectedCourseList}" varStatus="status">
						<li class="course_item">
							<div class="course">
								<a href="CourseInfoServlet?cno=${unselectedCourse.cno}"><div class="course_name">
								${unselectedCourse.cname}&nbsp;|&nbsp;${unselectedCourse.cteacher}
								</div>
								</a>
								<a href="StudentCourseServlet?option=select&cno=${unselectedCourse.cno}&clno=${club.CLno}">
									<div class="select_button">选择</div>
								</a>
							</div>
						</li>
					</c:forEach>
					</ul>
				</div>
				<div id="clubs_h">
					<div class="decoration_block"></div>
					<div class="decoration_note">已选课程</div>
				</div>
				<div id="club_course">
					<ul id="course_list">
					<c:forEach var="selectedCourse" items="${selectedCourseList}" varStatus="status">
						<li class="course_item">
							<div class="course">
								<a href="CourseInfoServlet?cno=${selectedCourse.cno}"><div class="course_name">
								${selectedCourse.cname}&nbsp|&nbsp${selectedCourse.cteacher}
								</div> 
								</a>
								<a href="StudentCourseServlet?option=delete&cno=${selectedCourse.cno}&clno=${club.CLno}">
									<div class="select_button">删除</div>
								</a>
							</div>
						</li>
					</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>