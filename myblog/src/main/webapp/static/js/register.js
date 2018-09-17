$(function() {
	$('#pwdSafe').combobox({
		url : 'getPwdSafeJSON.do',
		valueField : 'id',
		textField : 'text',
		panelHeight : 'auto',
		editable : false,
		onLoadSuccess : function(data) {
			if (data) {
				$(this).combobox('select', data[0].id);
			}
		},
		onLoadError : function(data) {
			console.log(data);
		},
	});
	$('#zhuCeBtn').click(function(){
		// 执行注册
		register();
	});
	
});

function getBean(){
	var bean = {};
	bean.name = $('#name').val();
	bean.password = $('#password').val();
	bean.mailBox = $('#mailBox').val();
	bean.phone = $('#phone').val();
	bean.type = $('#pwdSafe').combobox('getValue');
	bean.answer = $('#pwdSafeAn').val();
	return bean; 
}

function register(){
	var bean = getBean();
	$.ajax({
		url : 'registerUser.do',
		type: 'POST',
		data : bean,
		success : function(data){
			if (data.data){
				location.replace('/huang/login/main.do');
			}
			
		}
	});
} 