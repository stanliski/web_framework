$(function(){
	init();
	
	buildMenu();
});

function init(){
	
	$("#header").load("html/common/header.html");
	
}

function buildMenu(){
	$.ajax({
  		url:"menu/buildMenu",
  		type:"post",
  		dataType: 'json',
        contentType:'application/json;charset=UTF-8',        
  		success:function(result){
  			$.each(result.data,function(i,item){
  				var submenu = "";
  				$.each(item.subMenu,function(j,subItem){
  					submenu = submenu + '<li><a class="font-yh" onclick=loadHtml(\"'+subItem.link+'\") >'+subItem.name+'</a></li>';
  				});
  				
  				$("#menu-accordion").accordion("add",{
  					title: item.name,
  				    content: '<ul class="sub-menu">'+submenu+'</ul>'
  				});
  			});
  		},
  		error:function(data){
  			alert("ajax提交失败，请重新尝试！");
  		}
  	}); 
}

function loadHtml(url){
	$("#main").load(url);
}