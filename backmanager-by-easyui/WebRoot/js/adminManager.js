$(function() {

	$('#adminManager').datagrid({
		url : '/EasyuiBackManager/AdminManagerServlet',
		fit : true,
		fitColumns : true,
		pagination : true,
		rownumbers : true,
		// border : false,
		pageSize : 10,
		pageList : [ 5, 10, 15, 20 ],
		sortName : 'regdate',
		sortOrder : 'DESC',
		method : 'post',
		// 关闭此字段后可直接在本地排序;
		// remoteSort : true,
		striped : true,
		// nowrap : true,
		toolbar : '#toolbar',
		columns : [ [ {
			field : 'id',
			title : '编号',
			width : 100,
			sortable : true,
			checkbox : true,
		}, {
			field : 'name',
			title : '管理员帐号',
			width : 100,
		}, {
			field : 'email',
			title : '管理员邮箱',
			width : 100,
		}, {
			field : 'regdate',
			title : '创建时间',
			width : 100,
		}, {
			field : 'authority',
			title : '拥有权限',
			width : 100,
		}, ] ],
	});

	$('#manager_add').dialog({
		width : 350,
		title : '新增管理',
		iconCls : 'icon-add',
		modal : true,
	    closed : true,
		buttons : [
				{
				    text: '提交',
				    iconCls: 'icon-add',
				    handler: function() {
				        if ($('#manager_add').form('validate')) {
				            $.ajax({
				                url: '/EasyuiBackManager/AddManagerServlet',
				                type: 'POST',
				                data: {
				                    name: $.trim($('input[name="username"]').val()),
				                    password: $.trim($('input[name="password"]').val()),
				                    email: $.trim($('input[name="email"]').val()),
				                    authority: $('#authority').combotree('getText'),
				                },
				                beforeSend: function() {
				                    $.messager.progress({
				                        text: '正在尝试提交...',
				                    });
				                },
				                success: function(data, response, status) {
				                    $.messager.progress('close');
				                    if (data > 0) {
				                        $.messager.show({
				                            title: '提示',
				                            msg: data + '个管理新增成功！',
				                        });
				                        $('#manager_add').dialog('close').form('reset');
				                        $('#adminManager').datagrid('reload');
				                    } else {
				                        $.messager.alert('警告操作', '未知错误，请重新提交！', 'warning');
				                    }
				                },
				            });
				        }
				    },
				},
				{
				    text: '取消',
				    iconCls: 'icon-redo',
				    handler: function() {
				        $('#manager_add').dialog('close').form('reset');
				    },
				},
		  ],
		 
	});
	
	$('#manager_edit').dialog({
		width : 350,
		title : '修改管理',
		iconCls : 'icon-edit',
		modal : true,
	    closed : true,
		buttons : [
				{
				    text: '提交',
				    iconCls: 'icon-edit',
				    handler: function() {
				        if ($('#manager_edit').form('validate')) {
				        	alert($.trim($('input[name="id_edit"]').val()));
				            $.ajax({
				                url: '/EasyuiBackManager/EditManagerServlet',
				                type: 'POST',
				                data: {
				                	id: $.trim($('input[name="id_edit"]').val()),
				                    name: $.trim($('input[name="manager_edit"]').val()),
				                    password: $.trim($('input[name="password_edit"]').val()),
				                    email: $.trim($('input[name="email_edit"]').val()),
				                    authority: $('#auth_edit').combotree('getText'),
				                },
				                beforeSend: function() {
				                    $.messager.progress({
				                        text: '正在尝试提交...',
				                    });
				                },
				                success: function(data, response, status) {
				                	alert(data);
				                    $.messager.progress('close');
				                    if (data > 0) {
				                        $.messager.show({
				                            title: '提示',
				                            msg: data + '个管理修改成功！',
				                        });
				                        $('#manager_edit').dialog('close').form('reset');
				                        $('#adminManager').datagrid('reload');
				                    } else {
				                        $.messager.alert('警告操作', '未知错误，请重新提交！', 'warning');
				                    }
				                },
				            });
				        }
				    },
				},
				{
				    text: '取消',
				    iconCls: 'icon-redo',
				    handler: function() {
				        $('#manager_edit').dialog('close').form('reset');
				    },
				},
		  ],
		 
	});
	//新增校验------------------>>
	// 管理帐号
	$('input[name="username"]').validatebox({
		required : true,
		validType : 'length[2,20]',
		missingMessage : '请输入管理名称',
		invalidMessage : '管理名称在2-20 位',
	});
	// 管理密码
	$('input[name="password"]').validatebox({
		required : true,
		validType : 'length[3,30]',
		missingMessage : '请输入管理密码',
		invalidMessage : '管理密码在3-30 位',
	});
	// 管理邮箱
	$('input[name="email"]').validatebox({
		required : true,
		validType : 'email',
	});
	// 分配权限
	$('#authority').combotree({
		url : '/EasyuiBackManager/NavigationServlet',
		required : true,
		lines : true,
		multiple : true,
		checkbox : true,
		onlyLeafCheck : true,
		onLoadSuccess : function(node, data) {
			console.log(data);
			var _this = this;
			if (data) {
				$(data).each(function(index, value) {
					if (this.state == 'closed') {
						$(_this).tree('expandAll');
					}
				});
			}
		},
	});
	//修改校验------------------>>
	// 管理密码
	$('input[name="password_edit"]').validatebox({
		validType : 'length[3,30]',
		missingMessage : '请输入管理密码',
		invalidMessage : '管理密码在3-30 位',
	});
	// 管理邮箱
	$('input[name="email_edit"]').validatebox({
		required : true,
		validType : 'email',
	});
	
	manager = {
		// 点击新增
		add : function() {
			$('#manager_add').dialog('open');
			$('input[name="username"]').focus();
		},
		
		edit : function() {	 
			var rows = $('#adminManager').datagrid('getSelections');
			if (rows.length == 1) {
			    $.ajax({
			        type: 'POST',
			        url: '/EasyuiBackManager/GetManagerServlet',
			        data: {
			            id: rows[0].id,
			        },
			        beforeSend: function() {
			            $.messager.progress({
			                text: '正在尝试获取数据...',
			            });
			        },
			        success: function(data) {
			            $.messager.progress('close');
			            if (data) {
			            	//alert(data);
			                var obj = $.parseJSON(data);
			              
			                $('#manager_edit').form('load', {
			                    id_edit: obj.id,
			                    manager_edit : obj.name,
			                    email_edit : obj.email,
			                    auth_edit : obj.authority,
			                }).dialog('open');
			                //分配权限
			                $('#auth_edit').combotree({
			                    url: '/EasyuiBackManager/NavigationServlet',
			                    required: true,
			                    lines: true,
			                    multiple: true,
			                    checkbox: true,
			                    onlyLeafCheck: true,
			                    onLoadSuccess: function(node, data) {
			                        var _this = this;
			                        var auth = obj.authority.split(',');
			                        if (data) {                        	
			                            $(data).each(function(index, value) {
//			                            	if ($.inArray(value.text, auth) != -1){
//			                            		$(_this).tree('check',value.target);
//			                            	}
			                                if (this.state == 'closed') {
			                                    $(_this).tree('expandAll');
			                                }
			                            });
			                        }
			                    },
			                });
			            }
			        },
			    });
			} else if (rows.length == 0) {
			    $.messager.alert(' 警告操作', ' 编辑记录至少选定一条数据！ ', 'warning');
			} else if (rows.length > 1) {
			    $.messager.alert(' 警告操作', ' 编辑记录只能选定一条数据！ ', 'warning');
			}
		
		},
		remove : function() {
			var rows = $('#adminManager').datagrid('getSelections');
			if (rows.length == 0) {
				 $.messager.alert(' 警告操作', ' 编辑记录至少选定一条数据！ ', 'warning');
			} else if (rows.length >= 1) {
				$.messager.confirm('确认框','您真的要删除所选的记录吗？',function(flag){
					if(flag) {
						var ids = [];
						for ( var int = 0; int < rows.length; int++) {
							ids.push(rows[int].id);
						}
						console.log(ids);
						$.ajax({
					        type: 'POST',
					        url: '/EasyuiBackManager/RemoveManagerServlet',
					        data: {
					            ids : ids.join(','),
					        },
					        beforeSend: function() {
					            $.messager.progress({
					                text: '正在尝试获取数据...',
					            });
					        },
					        success: function(data) {
					            $.messager.progress('close');
					            if (data > 0) {
			                        $.messager.show({
			                            title: '提示',
			                            msg: data + '个管理删除成功！',
			                        });
			                        $('#adminManager').datagrid('reload');
			                    } else {
			                        $.messager.alert('警告操作', '未知错误，请重新提交！', 'warning');
			                    }
					        },
					    });
					}
				});
			}
		},
		//取消所有选定
		redo : function () {
		$('#adminManager').datagrid('unselectAll');
		},
		//当前页面刷新
		reload : function () {
		$('#adminManager').datagrid('reload');
		},
		search :function () {
			$('#adminManager').datagrid('load',{
				//获取input输入框的值,先选取input控件在选取name属性相符的控件
				name : $.trim($('input[name="name"]').val()),
				date_from : $('input[name="date_from"]').val(),
				date_to : $('input[name="date_to"]').val(),
				});
		},
	};
});