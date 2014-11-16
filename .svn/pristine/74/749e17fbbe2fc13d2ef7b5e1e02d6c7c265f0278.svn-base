$(function(){
	login();
});


function login(){
	
	$("#login-warn-msg a").bind("click",function(){
		$("#login-warn-msg").hide();
	});
	
	$("#login-btn").bind("click",function(){
		//var tmp = "usercode="+$("#usercode").val() + "&password="+ $("#password").val();
		$.ajax({
	  		url:"user/login",
	  		type:"post",
	  		//dataType:"text",
	  		//contentType:"application/json;charset=utf-8",
	  		//data:tmp,
	  		dataType: 'json',
	        contentType:'application/json;charset=UTF-8',        
	  		data:JSON.stringify({usercode:$("#usercode").val(),password:$("#password").val()}),
	  		success:function(data){
	  			if(data.data === LoginResultType.LOGIN_SUCCESS){
	  				window.location = "index";
	  			}else if(data.data === LoginResultType.PASSWORD_IS_WRONG){
	  				$("#login-warn-msg strong").text("密码错误！");
	  				$("#login-warn-msg").show();
	  			}else if(data.data === LoginResultType.USER_IS_NOT_EXIT){
	  				$("#login-warn-msg strong").text("用户不存在！");
	  				$("#login-warn-msg").show();
	  			}
	  		},
	  		error:function(data){
	  			alert("ajax提交失败，请重新尝试！");
	  		}
	  	}); 
	});
	
}