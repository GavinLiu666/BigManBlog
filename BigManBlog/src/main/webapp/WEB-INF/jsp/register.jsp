<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="base" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html >
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>大佬博客 | 注册</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="${base}/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${base}/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="${base}/bower_components/Ionicons/css/ionicons.min.css">
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
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href="../../index2.html"><b>大佬博客</b>BigMan</a>
  </div>

  <div class="register-box-body">
    <p class="login-box-msg">注    册</p>
		<span id ='message' style="color:red;">${requestScope.message }</span>
    <form action="${base }/register" method="post">
      <div class="form-group has-feedback">
        <input type="text" class="form-control" id="username" name="username"  placeholder="用户名">
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" id="password" name="password" placeholder="密码">
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="confirmPwd" id="confirmPwd"  class="form-control" placeholder="确认密码">
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" id="question"  name="question"  placeholder="密保问题">
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" id="answer" name="answer" placeholder="密保答案">
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> 我同意 <a href="#">《大佬协议》</a>
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" class="btn btn-primary btn-block btn-flat">注册</button>
        </div>
        <!-- /.col -->
      </div>
    </form>

    <div class="social-auth-links text-center">
      <p>- OR -</p>
      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-qq"></i> 使用QQ登录</a>
      <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-weixin"></i> 使用微信登录</a>
    </div>

    <a href="${base}/index.jsp" class="text-center">我已经有一个账户</a>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 3 -->
<script src="${base}/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${base}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="${base}/plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
    /*用户名验证*/
    $('#username').blur(function(){
    	var h=$('#username').val();
    	var reg = /^[\u4E00-\u9FA5\w]{4,10}$/;
    	if(!reg.test(h)){
    		$('#message').text('用户名为4~10字符');
    	}else{
    		$('#message').text('');
    	}
    });
    
    /*密码验证*/
    $('#password').blur(function(){
    	var h=$('#password').val();
    	var reg = /^[a-zA-Z][\w]{5,17}$/;
    	if(!reg.test(h)){
    		$('#message').text('密码为6~10字符，以字母开头');
    	}else{
    		$('#message').text('');
    	}
    });
     
    
  });
</script>
</body>
</html>
