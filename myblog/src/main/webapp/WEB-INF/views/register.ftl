<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
<title>注册新用户</title>
<!-- 引入公用css文件 -->
<#include "/base/baseCSS.ftl"> 
<!-- 文件的css -->
<link rel="stylesheet" href="../static/css/register.css">
</head>
<body>
<div class="container">
	<div class="BigBox">
		<!-- 注册框 -->
		<div class="registerBox">
			<form role="form">
				<!-- 头像 -->
				<div class="form-group">
					<div class="titleImage">
						<img src="../static/image/demo.jpg" class="img-circle">
					</div>
				</div>
				<!-- 姓名 -->
				<div class="form-group">
					<div class="textClass">
						<label class="wordClass">姓名</label>
						<input class="wirteClass" type="text" name="name" id="name">
					</div>
				</div>
				<!-- 密码 -->
				<div class="form-group">
					<div class="passwordClass">
						<label class="wordClass">密码</label>
						<input class="wirteClass" type="password" name="password" id="password">
					</div>
				</div>
				<!-- 再一次输入密码 -->
				<div class="form-group">
					<div class="newPasswordClass">
						<label class="wordClass">确认密码</label>
						<input class="supWirteClass" type="password" name="newPassword" id="newPassword">
					</div>
				</div>
				<!-- 电话号码 -->
				<div class="form-group">
					<div class="phoneClass">
						<label class="wordClass">手机号码</label>
						<input class="supWirteClass" type="text" name="phone" id="phone">
					</div>
				</div>
				<!-- 邮箱 -->
				<div class="form-group">
					<div class="mailBoxClass">
						<label class="wordClass">邮箱</label>
						<input class="wirteClass" type="text" name="mailBox" id="mailBox">
					</div>
				</div>
				<!-- 密保问题 -->
				<div class="form-group">
					<div class="pwdSafeClass">
						<label class="wordClass">密保问题</label>
						<input class="easyui-combobox" type="text" name="pwdSafe" id="pwdSafe">
					</div>
				</div>
				
				<!-- 密保问题答案 -->
				<div class="form-group">
					<div class="pwdSafeClassAn">
						<label class="wordClass">答案</label>
						<input class="wirteClass" type="text" name="pwdSafeAn" id="pwdSafeAn">
					</div>
				</div>
				<!-- 性别 -->
				<div class="form-group">
					<div class="SexClass">
						<label class="wordClass">性别</label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" checked="checked" name="Sex" value="1">
						<label class="wordClass">男性</label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="Sex" value="2">
						<label class="wordClass">女性</label>
					</div>
				</div>
				
				<!-- 注册 -->
				<div class="form-group">
					<div class="zhuceClass">
						<button  class="zhuCeBtnClass" type="button" id="zhuCeBtn">注册</button>
					</div>
				</div>
			</form>
		</div>
		
	</div>
</div>
</body>
<!-- 引入公用js文件 -->
<#include "/base/baseJS.ftl"> 
<!-- login的js文件 -->
<script type="text/javascript" src="../static/js/register.js"></script>
</html>