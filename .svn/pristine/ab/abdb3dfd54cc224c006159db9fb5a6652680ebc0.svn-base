$(function(){
	addUser();
});

function addUser(){
	$("#addUser").bind("click",function(){
		var tmp = "usercode="+$("#usercode").val() + "&password="+ $("#password").val();
		$.ajax({
	  		url:"user/addUser",
	  		type:"post",
	  		dataType:"text",
	  		//contentType:"application/json;charset=utf-8",
	  		data:tmp,
	  		success:function(data){
	  		},
	  		error:function(data){
	  			alert("ajax提交失败，请重新尝试！");
	  		}
	  	}); 
	});
	
}