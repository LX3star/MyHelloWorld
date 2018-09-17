<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1.0" />
<title>登录</title>
<!-- bootstrap的css文件 -->
<link rel="stylesheet" href="../static/lib/bootstrap-3.3.7-dist/css/bootstrap.css">
<!-- 页面的css文件 -->
<link rel="stylesheet" href="../static/css/login.css">
</head>
<script>
   		var basePath = '${path}';   		
</script>
<body >
	<div class="bigBox">
		<!-- 内嵌背景视频 -->
		<div class="videoClass">
			<video class="viddeo" autoplay="autoplay" loop="loop">
	   			<source  src="../static/media/demo3.mp4" type="video/mp4" >
			</video>
		</div>
		
		<!-- 登录框 -->
		<div class= >
			<div class="from">
				<form action="#" method="post">
					<div class="form-group">
						<div class="col-xs-9 col-center-block">
							<div class="input-group">
								<span class="input-group-addon"> 
									<span class="glyphicon glyphicon-user"></span> 
									<input type="text" id="code" name="username" class="form-control" placeholder="用户名">
								</span>
							</div>
						</div>
					</div>
				
					<div class="form-group">
						<div class="col-xs-9 col-center-block">
							<div class="input-group">
								<span class="input-group-addon"> 
									<span class="glyphicon glyphicon-lock"></span> 
									<input type="password"id="password" name="password" class="form-control" placeholder="密码">
								</span>
							</div>
						</div>
					</div>
				
					<div class="form-group">
						<div class="col-xs-9 col-center-block">
							<div class="input-group">
								<span class="input-group-addon"> 
									<span class="glyphicon glyphicon-pencil"></span> 
									<input type="text" id="validCode" name="validCode" class="form-control" placeholder="验证码">
								</span>
							</div>
						</div>
					</div>

					<div class="form-group">
	
						<div class="col-xs-9 col-center-block">
							<button type="button" class="btn btn-info btn-lg">登录</button> 
						</div>
					
					</div>
					
					<div class="form-group">
						<div class="col-xs-9 col-center-block">
								<button id="registeredBtn" type="button" class="btn duuBtn btn-lg">注册</button> 
								<button type="button" class="btn tuuBtn tuuBtn-lg">忘记密码</button>					
						</div>
					</div>
					
					<div class="valid">
						<img src="" class="validImg" alt="验证码"/>
					</div>
					
				</form>
			</div>
		</div>
		
		<!-- 注册框 -->
		<div id="registeredWindow" style="display: none;width: 120px;height: 250px">
			<div style='margin:auto;width: 240px;margin-top : 40px;'>
					<label>
						账号:&nbsp;<input style="width: 160px" name="name" data-options="required:true, validType:'length[0,30]'">
					</label>
					<label>
						密码:&nbsp;<input style="width: 160px" name="name" data-options="required:true, validType:'length[0,30]'">
					</label>
					<label>
						密保:&nbsp;<input style="width: 160px" name="name" data-options="required:true, validType:'length[0,30]'">
					</label>
			</div>
		</div>
	</div>
	
		

</body>
<!-- jquery文件 -->
<script type="text/javascript" src="../static/lib/jquery/jquery-2.1.4.js"></script>
<!-- bootstrap的js文件 -->
<script type="text/javascript" src="../static/lib/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<!-- login的js文件 -->
<script type="text/javascript" src="../static/js/login.js"></script>
</html>