(function($){
	$.extend({
		addMessageDiv:function(id){
			/*var temp = $('<div id="message_dialog"><div><img src="" width="100" height="100"><span></span></div></div>');
			alert($(id));
			$(id).append(temp);*/
			var temp = $('<div style="width:100px;height:100px;margin:0 auto"><img src="" width="100" height="100"></div><div style="width:100%;margin:0 auto;text-align:center"><span></span></div>');
			$("#"+id).append(temp);
			$("#"+id).dialog({
				//title:title,
				modal: true,
				autoOpen: false,
				buttons: {
					"确定": function() {
						$(this).dialog( "close" );
					}
				}
			});
		},
		showMessage:function(id,img,message){
			$("#"+id).find("img").attr("src",img);
			$("#"+id).find("span").html(message);
			$("#"+id).dialog("open");
		},
		removeModal:function(selector){
			$(selector).remove();
		}
	});
	
	$.extend({
		getallinput:function(id){
			var conditions = "";
			$("div[id="+id+"] input[type=text]").each(function(i){
				if(this.value != ""){
					conditions = conditions + $(this).attr("column") +"="+this.value + "&";
				}
			});
			$("div[id="+id+"] textarea").each(function(i){
				if(this.value != ""){
					conditions = conditions + $(this).attr("column") +"="+this.value + "&";
				}
			});
			$("div[id="+id+"] input[type=password]").each(function(i){
				if(this.value != ""){
					conditions = conditions + $(this).attr("column") +"="+this.value + "&";
				}
			});
			$("div[id="+id+"] select").each(function(i){
				if(this.value != ""){
					conditions = conditions + $(this).attr("column") +"="+this.value + "&";
				}
			});
			$("div[id="+id+"] input:radio:checked").each(function(i){
				if(this.value != ""){
					conditions = conditions + $(this).attr("column") +"="+this.value + "&";
				}
			});
			return conditions;
			//alert(conditions);
		}
	});
	
	
	$.extend({
		getForm:function(id){
			var conditions = {};
			$("div[id="+id+"] .form-submit").each(function(i){
				if(this.value != ""){
					var key = $(this).attr("column");
					conditions[key] = this.value;
				}
			});
			
			return JSON.stringify(conditions);
		}
	});
	
	$.extend({
		clean:function(id){
			$("div[id="+id+"] input").each(function(i){
				this.value = "";
			});
			$("div[id="+id+"] textarea").each(function(i){
				this.value = "";
			});
		}
	});
})(jQuery);