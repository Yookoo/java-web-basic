$(function() {
	$('#tabs').tabs({
		fit : true,
		border : false,
	});

	$('#nav').tree({
		url : '/EasyuiBackManager/NavigationServlet',
		lines : true,
		onLoadSuccess : function(node, data) {
			var _this = this;
			if (data) {
				$(data).each(function(index, value) {
					if (this.state == 'closed') {
						$(_this).tree('expandAll');
					}
				});
			}
		},
		onClick : function(node) {
			// console.log(node); // 在用户点击的时候提示
			if (node.url) {
				if ($('#tabs').tabs('exists', node.text)) {
					$('#tabs').tabs('select', node.text)
				} else {
					$('#tabs').tabs('add', {
						title : node.text,
						closable : true,
						iconCls : node.iconCls,
						href : 'jsp/'+ node.url + '.jsp',
					});
				}
			}
		},
	});

});