<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<c:set var="base" value="${pageContext.request.contextPath}"></c:set>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar user panel (optional) -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${user.user_pic}" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${user.username}
          <!-- Status -->
          <a href="#"><i class="fa fa-circle text-success"></i> 在线</a></p>
        </div>
      </div>

      <!-- search form (Optional) -->
      <form  class="sidebar-form">
        <div class="input-group">
          <input type="text" id="friend" class="form-control" placeholder="搜索用户...">
          <span class="input-group-btn">
              <button type="button"  id="search-btn" 
              class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
        </div>
        <b id="error" style="color: red;padding-left: 20px;"></b>
      </form>
<script type="text/javascript" src="${base}/js/jquery-1.11.1.js"></script>

<script    type="text/javascript" >


$("#search-btn").click(function() {
	/** *******获取项目名**************** */
	var base = location.pathname;
	base = base.slice(0, base.indexOf('/', 1));
	/** ******************************** */
	var name = $('#friend').val();
	var url = base + "/user/search.do";
	var data = {
		"name" : name
	};
	$.ajax({
		"url" : url,
		"type" : "POST",
		"dataType" : "text",
		"data" : data,
		"success" : function(userInfo) {
			console.log(userInfo);
			if (userInfo == 'error')
				$('#error').val('未找到该用户');
			if (userInfo == 'success') {
				window.location.assign(base + "/user/friend.do");
			}
		}
	});
});


</script> 

      <!-- /.search form -->

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">目录</li>
        <!-- Optionally, you can add icons to the links -->
        <li class="active"><a href="#"><i class="fa fa-hand-o-right"></i> <span>个人状态</span></a></li>
        <li><a href="#"><i class="fa fa-hand-o-right"></i> <span>热门博客</span></a></li>
        <li class="treeview">
          <a href="#"><i class="fa fa-hand-o-right"></i> <span>朋友圈</span>
            <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="#">博客</a></li>
            <li><a href="#">视频</a></li>
          </ul>
        </li>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>
