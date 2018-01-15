<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="base" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>大佬微博BigMan</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="${base}/bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${base}/bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="${base}/bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${base}/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect. -->
  <link rel="stylesheet" href="${base}/dist/css/skins/skin-blue.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"> -->
</head>

<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

  <!-- 导入导航栏 -->
  <c:import url="/WEB-INF/inc/header.jsp"></c:import>
  
  <!-- 导入左侧边栏 -->
  <c:import url="/WEB-INF/inc/left-side.jsp"></c:import>

  <!-- 内容栏开始 -->
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        用户信息
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><b>开通会员</b></a></li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">

      <div class="row">
        <div class="col-md-3">

          <!-- Profile Image -->
          <div class="box box-primary">
            <div class="box-body box-profile">
              <img class="profile-user-img img-responsive img-circle" 
               src="${user.user_pic}" alt="这里放一张图片">

              <h3 class="profile-username text-center">${user.username }</h3>

              <p class="text-muted text-center">软件开发工程师</p>

              <ul class="list-group list-group-unbordered">
                <li class="list-group-item">
                  <b>关注</b> <a class="pull-right">1,322</a>
                </li>
                <li class="list-group-item">
                  <b>粉丝</b> <a class="pull-right">543</a>
                </li>
                <li class="list-group-item">
                  <b>微博</b> <a class="pull-right">13,287</a>
                </li>
              </ul>

              <a href="#" class="btn btn-primary btn-block"><b>详情</b></a>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->

          <!-- About Me Box -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">我的</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <b>好友圈</b>
              <p></p>
              <b>特别关注</b>
              <p></p>
              <b>微博</b>
              <p></p>
              <b>图片</b>
              <p></p>
              <b>视频</b>
              <p></p>
              <b>音乐</b>
              <p></p>
              <b>文章</b>
              <p></p>
              <strong><i class="fa fa-file-text-o margin-r-5"></i> 公告栏</strong>
              <p>这里放置公告</p>
              <form action="${base }/user/uploadPortrait.do" method="post" enctype="multipart/form-data">
                    <span>上传文件</span>
                    <input type="file" name=onloadFile><input type="submit" value="保存">
                </form>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
        <div class="col-md-9">
          <div class="nav-tabs-custom">
            <ul class="nav nav-tabs">
              <li class="active"><a href="#activity" data-toggle="tab">朋友动态</a></li>
              <li><a href="#timeline" data-toggle="tab">个人状态</a></li>
              <li><a href="#settings" data-toggle="tab">发送微博</a></li>
            </ul>
            <div class="tab-content">
              <div class="active tab-pane" id="activity">
              <c:forEach items="${mBlogs}" var='m'  > 
                  <!-- --------------------------------------微博分界线（开始）-------------------------------------- -->
                <div class="post clearfix">
                  <div class="user-block">
                    <img class="img-circle img-bordered-sm" src="${user.user_pic}" alt="头像">
                        <span class="username">
                          <a href="${base}/user/search.do?friend=${user.username}">${user.username }</a>
                          <a href="#" class="pull-right btn-box-tool"><i class="fa fa-times"></i></a>
                        </span>
                    <span class="description"><fmt:formatDate pattern="MM月dd日 HH:mm" value="${m.create_time }"/>  来自 前后2000万 OPPO R11</span>
                  </div>
                  <!-- /.user-block -->
                  <p>${m.text }</p>
                  <ul class="list-inline">
                    <li><a href="#" class="link-black text-sm"><i class="fa fa-share margin-r-5"></i> 分享</a></li>
                    <li><a href="#" class="link-black text-sm"><i class="fa fa-thumbs-o-up margin-r-5"></i> 喜欢</a>
                    </li>
                    <li class="pull-right">
                      <a href="#" class="link-black text-sm"><i class="fa fa-comments-o margin-r-5"></i> 评论 (5)</a></li>
                  </ul>

                  <form class="form-horizontal">
                    <div class="form-group margin-bottom-none">
                      <div class="col-sm-9">
                        <input class="form-control input-sm" placeholder="有什么想说的呢？">
                      </div>
                      <div class="col-sm-3">
                        <button type="submit" class="btn btn-danger pull-right btn-block btn-sm">发送</button>
                      </div>
                    </div>
                  </form>
                </div>
                  <!-- --------------------------------------微博分界线（结束）-------------------------------------- -->
                </c:forEach>
              </div>
              <!-- /.tab-pane -->
              <div class="tab-pane" id="timeline">
                <!-- The timeline -->
                <ul class="timeline timeline-inverse">
                  <!-- timeline time label -->
                  <li class="time-label">
                        <span class="bg-red">
                             2014年2月10日
                        </span>
                  </li>
                  <!-- /.timeline-label -->
                  <!-- timeline item -->
                  <li>
                    <i class="fa fa-envelope bg-blue"></i>

                    <div class="timeline-item">
                      <span class="time"><i class="fa fa-clock-o"></i> 12:05</span>

                      <h3 class="timeline-header"><a href="#">妞妞</a> 发给你一封私信</h3>

                      <div class="timeline-body">
                          吾用一生，写一首诗，盲目寻添，只找一字，直至此刻，诗成一字，早已铭心。
                      </div>
                      <div class="timeline-footer">
                        <a class="btn btn-primary btn-xs">阅读</a>
                        <a class="btn btn-danger btn-xs">删除</a>
                      </div>
                    </div>
                  </li>
                  <!-- END timeline item -->
                  <!-- timeline item -->
                  <li>
                    <i class="fa fa-user bg-aqua"></i>

                    <div class="timeline-item">
                      <span class="time"><i class="fa fa-clock-o"></i> 5 分钟之前</span>

                      <h3 class="timeline-header no-border"><a href="#">再美不过等待</a> 接受了你的朋友请求
                      </h3>
                    </div>
                  </li>
                  <!-- END timeline item -->
                  <!-- timeline item -->
                  <li>
                    <i class="fa fa-comments bg-yellow"></i>

                    <div class="timeline-item">
                      <span class="time"><i class="fa fa-clock-o"></i> 27 分钟之前</span>

                      <h3 class="timeline-header"><a href="#">小白白</a> 评论了你的帖子</h3>

                      <div class="timeline-body">
                          这是南风说的话，没看过他的剧情，大概是在对他喜欢的姑娘表白吧
                      </div>
                      <div class="timeline-footer">
                        <a class="btn btn-warning btn-flat btn-xs">查看评论</a>
                      </div>
                    </div>
                  </li>
                  <!-- END timeline item -->
                  <!-- timeline time label -->
                  <li class="time-label">
                        <span class="bg-green">
                             2014年1月3日
                        </span>
                  </li>
                  <!-- /.timeline-label -->
                  <!-- timeline item -->
                  <li>
                    <i class="fa fa-camera bg-purple"></i>

                    <div class="timeline-item">
                      <span class="time"><i class="fa fa-clock-o"></i> 2 天前</span>

                      <h3 class="timeline-header"><a href="#">南风不竟</a> 上传了新照片</h3>

                      <div class="timeline-body">
                        <img src="http://placehold.it/150x100" alt="..." class="margin">
                        <img src="http://placehold.it/150x100" alt="..." class="margin">
                        <img src="http://placehold.it/150x100" alt="..." class="margin">
                        <img src="http://placehold.it/150x100" alt="..." class="margin">
                      </div>
                    </div>
                  </li>
                  <!-- END timeline item -->
                  <li>
                    <i class="fa fa-clock-o bg-gray"></i>
                  </li>
                </ul>
              </div>
              <!-- /.tab-pane -->
              <div class="tab-pane" id="settings">
                   <!-- 短博文分割线 -->
                  <div class="box-body">
                    <div >
                      <p><b>这里发送微博</b></p>
                    </div>
                    <div style="width:100%;" ><div style="width:100%;border:1px solid grey;font-size:16px;" 
                    contenteditable="true" id="microBlog" >渭城朝雨浥轻尘，客舍青青柳色新。 <br>  <br>   </div>
                    </div>
                  </div>
                  
                  <div class="box-footer">
                    <div class="pull-right">
                      <button type="button" class="btn btn-default"><i class="fa fa-pencil"></i>  清空</button>
                      <button type="button" id='sendMicroBlog'  class=" btn btn-primary"><i class="fa fa-envelope-o"></i> 发送</button>
                    </div>
                  </div>
                  <!-- 短博文分割线 -->
              </div>
              <!-- /.tab-pane -->
            </div>
            <!-- /.tab-content -->
          </div>
          <!-- /.nav-tabs-custom -->
        </div>
        <!-- /.col -->
      </div>
      <!-- /.row -->

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <!-- 内容栏结束 -->

  <!-- 导入底部栏 -->
  <c:import url="/WEB-INF/inc/footer.jsp"></c:import>
  
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 3 -->
<script src="${base}/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${base}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="${base}/dist/js/adminlte.min.js"></script>
<%-- <!-- CK Editor -->
<script src="${base}/bower_components/ckeditor/ckeditor.js"></script> --%>
<!-- Bootstrap WYSIHTML5 -->
<script src="${base}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- <script>
  $(function () {
    // Replace the <textarea id="editor1"> with a CKEditor
    // instance, using default configuration.
    CKEDITOR.replace('editor1')
    //bootstrap WYSIHTML5 - text editor
    $('.textarea').wysihtml5()
  }) 
</script> -->

<!-- 将博客内容发送至服务器  -->
<script src="${base}/js/SendBlog-js.js"></script>
</body>

</html>
