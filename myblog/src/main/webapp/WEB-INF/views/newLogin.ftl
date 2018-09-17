<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
<title>登录</title>
<!-- 引入公用css文件 -->
<#include "/base/baseCSS.ftl"> 
<!-- 页面的css文件 -->
<link rel="stylesheet" href="../static/css/newLogin.css">
<script>
   		var basePath = '${path}';   		
</script>
<body>
<!-- 箱子 -->
<div class="container">
	<!-- 网页内嵌视频作为背景 -->
	<div class="videoUnder" >
		<video class="videoThis" autoplay="autoplay" loop="loop" src="../static/media/demo1.mp4"></video>
	</div>
	
	<!-- 登录框 -->
	<div class="loginBox">
		<div class="loginINBox">
			<form role="form">
				<div class="form-group">
    				<div class="langClass">
    					<span class="glyphicon glyphicon-user"></span>
    					<input type="text" class="langTextClass" id="name" placeholder="请输入名称">  
    				</div>
  				</div>
  				<div class="form-group">
    				<div class="langClass">
    					<span class="glyphicon glyphicon-lock"></span>
    					<input type="password" class="langTextClass" id="password" placeholder="请输入密码">  
    				</div>
  				</div>
  				<div class="form-group">
    				<div class="langClass">
    					<span class="glyphicon glyphicon-pencil"></span>
    					<input type="text" class="langTextClass" id="valid" placeholder="请输入验证码">
    					<!-- 验证码图 -->
    					<div class="validImg">
    						<img src="" class="validImgInner"/>
    					</div>  
    				</div>
  				</div>
  				
  				<div class="form-group">
  					<button  class="loginBtnClass" type="button" id="loginBtn">登录</button> 
  				</div>
  				<div class="textLineClass">
  					<a class="zhuceTextClass" id="" href="/huang/register/main.do">注册新用户</a>
  					<a class="forgetTextClass" id="" href="http://www.runoob.com/">忘记密码</a>
  				</div>
  				
			</form>
		</div>
	</div>
</div>

</body>
<!-- 引入公用js文件 -->
<#include "/base/baseJS.ftl">
<!-- login的js文件 -->
<script type="text/javascript" src="../static/js/login.js"></script>
</html>