<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>学生社团管理系统后台-登录</title>
<link rel="stylesheet" href="css/backstyle.css" type="text/css" />
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript" src="js/modernizr.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/vector.js"></script>
   <!--  <script src="jquery.min.js"></script> -->
<script type="text/javascript">
    $(function(){
        Victor("container", "output");   //登陆背景函数
        $("#login").focus();
        $(document).keydown(function(event){
            if(event.keyCode==13){
                $("#entry_btn").click();
            }
        });
    });
    function check() {
		var username = document.getElementById('username');
		var password = document.getElementById('password');
		if (username.value == "") {
			alert("管理员账号：admin");
			return false;
		} else if (password.value == "" || password.value !='admin') {
			alert("密码错误，请重新输入！");
			return false;
		}
	}
</script>
</head>
<body>
	<div id="container">
    <div id="output">
        <div class="containerT">
            <h1>学社后台管理系统</h1>
            
            <form class="form" id="login" action="../BackendLogin.do" method="post">
                <input type="text" placeholder="用户名" id="username" name="username">
                <input type="password" placeholder="密码" id="password" name="password">
                <button type="submit" id="entry_btn" onClick="return check()">登录</button>
                <div id="prompt" class="inputwrapper animate4 bounceIn">
                	<label>
                		<input type="checkbox" class="remember" name="signin" /> 
                		自动登录</label>
                </div>
            </form>
            
        </div>
    </div>
	</div>
	<div class="loginfooter">
		<p>&copy; 2021. 学社 XS.com All Rights Reserved.</p>
	</div>
</body>
</html>