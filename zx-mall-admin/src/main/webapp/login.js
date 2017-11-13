// form 表单验证
$(document).ready(function() {
	$('#login-btn').click(function() {
		var username = $('#username').val();
		var password = hex_md5($('#j_password').val());
		
		alert("pwd=" + password);
		
		$.ajax({
			url:  '/mall/j_spring_security_check',
			type: 'post',
			data: {
				'j_username': username,
				'j_password': password
			},
			dataType: 'json',
			error: function(e) {
				alert('登录失败，用户名或密码错误。')
			},
			success: function(res, e, e2) {
				if(res.status === 200) {
					location.href = "index.html"
				} else {
					alert(res.msg);
					//alert('用户名或密码错误')
				}
			}
		});
	});
	
	
	/*$("#loginForm").submit(function() {
		if($(this).valid()){
			
		} else {
			alert("error");
		}
		return false;
	});*/
});