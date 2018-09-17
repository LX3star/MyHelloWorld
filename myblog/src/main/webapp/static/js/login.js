$(function(){
	$('.validImg').click(function(){
		var reqUrl = basePath + '/servlet/ValiCodeServlet' + '?' + Math.random().toFixed(2)*100;
		$(this).find('img').attr('src', reqUrl);
	});
	$('#loginBtn').click(function(){
		login();
	});
})
function getBean(){
	var bean = {};
	bean.name = $('#name').val();
	bean.password = $('#password').val();
	bean.validCode = $('#valid').val();
	return bean;
}

function login(){
	var bean = getBean();
	$.ajax({
		url : 'tryLogin.do',
		type : 'POST',
		data : bean,
		success : function(data){
			if(data.data){
				location.replace('/huang/register/main.do');
			}
		}
	});
}