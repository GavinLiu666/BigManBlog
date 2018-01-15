<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="base" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>大佬博客 | 登录</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="${base}/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${base}/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="${base}/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${base}/dist/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="${base}/plugins/iCheck/square/blue.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="#"><b>大佬博客</b>BigMan</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">登 录</p>

			<div class="form-group has-feedback">
				<input type="test" class="form-control" id="username"
					name='username' placeholder="用户名"> <span
					class="glyphicon glyphicon-envelope form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input type="password" class="form-control" id="password"
					name='password' placeholder="密码"> <span
					class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="row">
				<div class="col-xs-8">
					<div class="checkbox icheck">
						<label> <input type="checkbox"> 记住我
						</label>
					</div>
				</div>
				<!-- /.col -->
				<div class="col-xs-4">
					<button type="button" onclick="login();"
						class="btn btn-primary btn-block btn-flat">登录</button>
				</div>
				<!-- /.col -->
			</div>

			<div class="social-auth-links text-center">

				<a id="showLoginMessage"
					class="btn btn-block btn-social btn-google btn-flat"> 欢迎</a>
			</div>
			<!-- /.social-auth-links -->

			<a href="#">忘记密码</a><br> <a href="${base }/BigMan/register.jsp"
				class="text-center">注册一个新用户</a>

		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 3 -->
	<script src="${base}/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="${base}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script src="${base}/plugins/iCheck/icheck.min.js"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
		var base = location.pathname;
		base = base.slice(0, base.indexOf('/', 1));//获取项目名
		function getXmlHttp() {

			var xmlhttpRequest = null;
			//获取XMLHttpRequest
			if (window.XMLHttpRequest)
				xmlhttpRequest = new XMLHttpRequest();
			else
				xmlhttpRequest = new ActiveXObject("Microsoft.XMLHttp");
			return xmlhttpRequest;
		}
		//点击登录按钮时的方法
		function login() {
			var xmlhttpRequest = getXmlHttp();
			var username = document.getElementById('username').value;
			var password = document.getElementById('password').value;
			var url = base + "/user/login.do";
			var data = "username=" + username + "&password=" + password;
			xmlhttpRequest.onreadystatechange = function() {
				if (xmlhttpRequest.readyState == 4
						&& xmlhttpRequest.status == 200) {
					var response = xmlhttpRequest.responseText;
					if (response == "success") {
						window.location.assign(base + "/user/home.do")
					}
					document.getElementById('showLoginMessage').innerHTML = response;
				}
			}
			xmlhttpRequest.open("POST", url, true);
			xmlhttpRequest.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded");
			xmlhttpRequest.send(data);
		}
	</script>
</body>
</html>