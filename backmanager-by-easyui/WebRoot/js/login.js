$(function() {
	//登陆界面
	$('#login').dialog({
		title : '管理员登陆',
		width : 300,
		height : 180,
		modal : true,
		iconCls : 'icon-lock',
		buttons : '#btn',
		});	
	//登陆验证
	$('#manager').validatebox({
		required : true,
		missingMessage : '请输入管理员帐号'
	});
	$('#password').validatebox({
		required : true,
		validType : 'length[3,30]',
		missingMessage : '请输入管理员密码',
		invalidMessage : '管理员密码必须在3至30位之间',	
	});
	//加载页面时判断
	if (!$('#manager').validatebox('isValid')) {
		$('#manager').focus();
	} else if (!$('#password').validatebox('isValid')) {
		$('#password').focus();
	}
	//登录按钮
	$('#loginok').click(function() {
		if (!$('#manager').validatebox('isValid')) {
			$('#manager').focus();
			} else if (!$('#password').validatebox('isValid')) {
			$('#password').focus();
			} else {
				$.ajax({
					type : 'POST',
					url : '/EasyuiBackManager/CheckLoginServlet',
					data : {
						manager : $('#manager').val(),
						password : $('#password').val(),
					},
					beforeSend : function() {
						$.messager.progress({
							text : '正在登陆中,请稍等...', 
						});
					},
					success : function(data, response, status) {
						$.messager.progress('close');
						console.log(data);
						if(data > 0){
							
							location.href = '/EasyuiBackManager/AdminServlet';
				
						} else {
							$.messager.alert('登录失败！','用户名或密码错误','warning', function() {
								$('#password').select();
							});
						};
					}, 
						
				});
			};
	});	
});