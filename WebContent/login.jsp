<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生社团管理系统-欢迎登录</title>
<link rel="stylesheet" href="style/login/style.css" type="text/css">
<link rel="stylesheet" href="style/login/back.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		function check() {
			var username = document.getElementById('username');
			var password = document.getElementById('password');
			if (username.value == "") {
				alert("请输入学号！");
				return false;
			} else if (password.value == "") {
				alert("请输入密码！");
				return false;
			}
		}
</script>

</head>
<body>

	<div class="wrap">
		<div id="logo">
			<a href="index.jsp" style="text-decoration:none;">
				<img  width="110" height="100" style="float:left;border-radius: 50%;" alt="学社" src="images/shetuan.png">
				<h1 style="font-size: 40px;margin-left: 130px;color:brown;line-height:100px;">欢迎登陆</h1>
			</a>
		</div>
	</div>
	<div id="content">
		<div class="login_wrap">
			<div class="login_banner">
				<div class="login_part">
					<div class="login_form">
						<form action="login.do" method="post">
							<h1>登录</h1>
							<h1 style="height: 260px;margin-left: 50px;">
									<div class="name">
										<label class="name_label"></label> <input class="text"
											type="text" name="username" id="username" placeholder="学号" />
									</div>
									<div class="psd">
										<label class="psd_label"></label> <input class="text"
											type="password" name="password" id="password"
											placeholder="密码" />
									</div>
									<div class="auto_login">
										<input type="checkbox">自动登录
										<label>${message}</label>
									</div>
									<div class="button">
										<div class="button_bg">
											<input type="submit" value="登&nbsp;&nbsp;&nbsp;&nbsp;录"
												onClick="return check()" />
										</div>
									</div>
									<div class="tips">注意：默认密码为学号后6位,登录后请及时修改</div>
							</h1>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<canvas id="canv"></canvas><!-- 26668791879 -->
<script type="text/javascript">
    $(document).ready(function() {
        var w = $(window).width();
        var h = $(window).height();
        $('#canv').width(w).height(h);
    })
</script>
<script type="text/javascript" src="js/back.js"></script>
</body>
</html>