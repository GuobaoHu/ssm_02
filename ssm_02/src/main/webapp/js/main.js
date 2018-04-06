$().ready(function() {
		
	$("#login_form").validate({
		onsubmit:true,// 是否在提交时验证
		onfocusout: function(element) { 
						$(element).valid(); 
					},// 是否在失去焦点时验证
		onkeyup: function(element) { 
						$(element).valid(); 
				  },// 是否在敲击键盘时验证
		debug:true,//只验证不提交，用form只是为了方便使用jquery.validate表单验证工具
		
		rules: {
			username: {
				required: true,
				Uname: true
			},
			password: {
				required: true,
				minlength: 6
			},
		},
		messages: {
			username: {
				required: "请输入姓名",
				Uname: "请输入英文字母开头的5-10位字符串，例如a123456789"
			},
			password: {
				required: "请输入密码",
				minlength: jQuery.format("密码不能小于{0}个字 符")
			},
		},
		submitHandler: function(){
			$.ajax({
				type:"post",
				url:"UserValidate",
				dataType:"json",
				data:{username:$('#username').val(),password:$('#password').val()},
				success:function(data) {					
					if(data.msg === 'success') {
						$(location).prop('href','startIndex.jsp');						
					} else {
						$('#validateMsg').css('color','red').text('用户名或密码不正确，如忘记密码，请联系管理员!');						
					}
				},
				error:function(){
					$('#validateMsg').css('color','red').text('');
					$('#validateMsg').css('color','red').text('网络错误！');					
				}
			});
		}
	});
	
	$("#register_form").validate({
		rules: {
			username: {
				required: true,
				Uname: true
			},			
			password: {
				required: true,
				minlength: 6
			},
			rpassword: {
				equalTo: "#register_password"
			},
			email: {
				required: true,
				email: true
			}
		},
		messages: {
			username: {
				required: "请输入姓名",
				Uname: "请输入英文字母开头的5-10位字符串，例如a123456789"
			},
			password: {
				required: "请输入密码",
				minlength: jQuery.format("密码不能小于{0}个字 符")
			},
			rpassword: {
				equalTo: "两次密码不一样"
			},
			email: {
				required: "请输入邮箱",
				email: "请输入有效邮箱"
			}
		}
	});
	
	$("#modify_form").validate({
		onsubmit:true,// 是否在提交时验证
		onfocusout: function(element) { 
						$(element).valid(); 
					},// 是否在失去焦点时验证
		onkeyup: function(element) { 
						$(element).valid(); 
				  },// 是否在敲击键盘时验证
		debug:true,//只验证不提交，用form只是为了方便使用jquery.validate表单验证工具
		
		rules: {
			username: {
				required: true,
				Uname: true
			},
			expiredpassword: {
				required: true,
				minlength: 6
			},
			password: {
				required: true,
				minlength: 6
			},
			rpassword: {
				equalTo: "#modify_password"
			}			
		},
		messages: {
			username: {
				required: "请输入姓名",
				Uname: "请输入英文字母开头的5-10位字符串，例如a123456789"
			},
			expiredpassword: {
				required: "请输入密码",
				minlength: jQuery.format("旧密码不会小于{0}个字 符")
			},
			password: {
				required: "请输入密码",
				minlength: jQuery.format("新密码不能小于{0}个字 符")
			},
			rpassword: {
				equalTo: "两次新密码不一样"
			}
		},
		
		submitHandler: function(){
			$.ajax({
				type:"post",
				url:"UserModify",
				dataType:"json",
				data:{username:$('#username').val(),password:$('#password').val()},
				success:function(data) {					
					if(data.msg === 'success') {
						$(location).prop('href','startIndex.jsp');						
					} else {
						$('#validateMsg').css('color','red').text('用户名或密码不正确，如忘记密码，请联系管理员!');						
					}
				},
				error:function(){
					$('#validateMsg').css('color','red').text('');
					$('#validateMsg').css('color','red').text('网络错误！');					
				}
			});
		}
	});
	
	$("#createOrder_form").validate({	
		rules: {
			route: {
				required: true,
			},
			recName: {
				required: true,
				UbckSpace: true
			},
			recPC: {
				required: true,
				UphoneCode: true
			},
			recAddress: {
				required: true,
				UbckSpace: true
			},
			goodsName: {
				required: true,
				Ulegal: true
			},
			goodsNumber: {
				required: true,
				digits: true
			},
			goodsFee: {
				required: true,
				number: true
			},
			goodsRecFee: {
				number: true
			},
			sendName: {
				required: true,
				UbckSpace: true
			},
			sendPC: {
				required: true,
				UphoneCode: true
			},
			sendAddress: {
				required: true,
				UbckSpace: true
			}
		},
		messages: {
			route: {
				required: "请选择线路",
			},
			recName: {
				required: "收件人不能为空",
				UbckSpace: "不能为空"
			},
			recPC: {
				required: "联系方式不能为空",
				UphoneCode: "请输入正确格式的电话号码,如87654321或15887654321"
			},
			recAddress: {
				required: "收件地址不能为空",
				UbckSpace: "不能为空"
					
			},
			goodsName: {
				required: "商品名称不能为空",
				Ulegal: "名称中含有非法字符|;"
			},
			goodsNumber: {
				required: "数量不能为空",
				digits: "数字格式不正确"
			},
			goodsFee: {
				required: "运费不能为空",
				number: "运费必须为数字，例如15或15.00"
			},
			goodsRecFee: {
				number: "代收货款必须为数字，例如15或15.00"
			},
			sendName: {
				required: "寄件人不能为空",
				UbckSpace: "不能为空"
			},
			sendPC: {
				required: "联系方式不能为空",
				UphoneCode: "请输入正确格式的电话号码,如87654321或15887654321"
			},
			sendAddress: {
				required: "寄件地址不能为空",
				UbckSpace: "不能为空"
			}
		}
	});
	
	$("#receiver_form").validate({	
		rules: {
			recPc: {
				required: true,
				UphoneCode: true
			},
			recName: {
				required: true,
				UbckSpace: true
			},			
			recAddress: {
				required: true,
				UbckSpace: true
			}
		},
		messages: {
			recPC: {
				required: "联系方式不能为空",
				UphoneCode: "请输入正确格式的电话号码,如87654321或15887654321"
			},
			recName: {
				required: "收件人不能为空",
				UbckSpace: "不能为空"
			},			
			recAddress: {
				required: "收件地址不能为空",
				UbckSpace: "不能为空"
					
			}			
		}
	});
	
	$("#shipper_form").validate({	
		rules: {
			sendPc: {
				required: true,
				UphoneCode: true
			},
			sendName: {
				required: true,
				UbckSpace: true
			},			
			sendAddress: {
				required: true,
				UbckSpace: true
			}
		},
		messages: {
			sendPC: {
				required: "联系方式不能为空",
				UphoneCode: "请输入正确格式的电话号码,如87654321或15887654321"
			},
			sendName: {
				required: "收件人不能为空",
				UbckSpace: "不能为空"
			},			
			sendAddress: {
				required: "收件地址不能为空",
				UbckSpace: "不能为空"
					
			}			
		}
	});
});
$(function() {
	$("#modify_btn").click(function() {
		$("#modify_form").css("display", "block");
		$("#login_form").css("display", "none");
	});
	$("#back_btn").click(function() {
		$("#modify_form").css("display", "none");
		$("#login_form").css("display", "block");
	});
});

