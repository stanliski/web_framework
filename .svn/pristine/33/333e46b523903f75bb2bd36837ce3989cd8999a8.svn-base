$(function(){
	initTree();
	
	initModal();
	
	addNode();
	/*$.ajax({
  		url:"permission/buildPermissionTree",
  		type:"post",
  		dataType: 'json',
        contentType:'application/json;charset=UTF-8',        
  		success:function(result){
  			 $("#permission-tree").treegrid({
  				 loadData:result
  			 });
  		},
  		error:function(data){
  			alert("ajax提交失败，请重新尝试！");
  		}
  	}); */
});

function initTree(){
    var lastIndex;
	var treeGrid = $("#permission-tree").treegrid({
        url: "permission/buildPermissionTree",
        ///title: "编辑treeGrid",
        rownumbers: true,
        animate:true,
        idField: "id",
        treeField: "name",
        width: "100%",
        height:"100%",
        fitColumns: true,
        singleSelect:true,
        collapsible:true,
        loadMsg:"加载数据，请稍后...",
        columns: [[
         {
            title: "",
            field: "id",
			align: "center",
			//checkbox:true,
			//复选框
			formatter:function(value,row,rowIndex){
                return "<input type='checkbox' onclick=show('"+row.id+"') id='check_"+row.id+"' "+(row.checked?'checked':'')+"/>";
            }
        }, {
            title: "名称",
            field: "name",
            width: 280,
          
            formatter:function(value,row,rowIndex){
            	return value;
            }
        },{
            title: "连接",
            field: "link",
            width: 280
        },{
            title: "pid",
            field: "parentId",
            width: 280
        }]],
        toolbar: [{
            id: "idAdd",
            text: "增加",
            iconCls: "icon-add",
            plain: "true",
            //按钮事件
            handler: function(){
            	saveNodeModal();
            }
        }, "-", {
            id: "idDelete",
            text: "删除",
            //disabled: true,
            iconCls: "icon-remove",
            //按钮事件
            handler: function(){
            }
        }, "-", {
            id: "idEdit",
            text: "修改",
            iconCls: "icon-edit",
            //disabled: true,
            handler: function(){
            }
        }, "-", {
            id: "idSave",
            text: "保存",
            iconCls: "icon-save",
            //disabled: true,
            handler: function(){
            }
        }, "-", {
            id: "idCancle",
            text: "取消编辑",
            iconCls: "icon-undo",
            //disabled: true,
            handler: function(){
            }
        }, "-"],
    });
	
	
	
};

function set_power_status(){ 
    var idList = ""; 
     $("input:checked").each(function(){
        var id = $(this).attr("id");
        if(id.indexOf("m")>-1)
            idList += id.replace("m",'')+',';
     });
    alert(idList);
};



function show(checkid){
    var s = '#check_'+checkid;
    /*选子节点*/
     var nodes = $("#permission-tree").treegrid("getChildren",checkid);
     for(i=0;i<nodes.length;i++){
        $(('#check_'+nodes[i].id))[0].checked = $(s)[0].checked;
     }
     //选上级节点
     if(!$(s)[0].checked){
	       var parent = $("#permission-tree").treegrid("getParent",checkid);
	       if(parent != null){
	    	   var children = $("#permission-tree").treegrid("getChildren",parent.id);
	           var flag = false;
	           for(i = 0; i < children.length;i ++){
	        	   if( ($(('#check_'+children[i].id))[0].checked) ){
	        		   flag = true;
	        	   }
	           }
	           if(!flag){
	        	   $(('#check_'+parent.id))[0].checked  = false;
	           }
		       while(parent){
	    		   parent = $("#permission-tree").treegrid("getParent",parent.id);
	    		   if(parent != null){
	    			   var c = $("#permission-tree").treegrid("getChildren",parent.id);
	    	           var flag = false;
	    	           for(i = 0; i < c.length;i ++){
	    	        	   if( ($(('#check_'+c[i].id))[0].checked) ){
	    	        		   flag = true;
	    	        	   }
	    	           }
	    	           if(!flag){
	    	        	   $(('#check_'+parent.id))[0].checked  = false;
	    	           }
	    		   }
		       }  
	       }
     }else{
       var parent = $("#permission-tree").treegrid("getParent",checkid);
       if(parent != null){
    	   var flag= false;
           var children = $("#permission-tree").treegrid("getChildren",parent.id);
           for(i = 0; i < children.length;i ++){
        	   if( ($(('#check_'+children[i].id))[0].checked) ){
        		   flag = true;
        	   }
           }
           if(flag)
        	   $(('#check_'+parent.id))[0].checked  = true;
           while(parent){
               parent = $("#permission-tree").treegrid("getParent",parent.id);
               if(parent != null){
            	   var children = $("#permission-tree").treegrid("getChildren",parent.id);
                   flag = false;
                   for(i = 0; i < children.length;i ++){
                	   if( ($(('#check_'+children[i].id))[0].checked) ){
                		   flag = true;
                	   }
                   }
                   if(flag)
                	   $(('#check_'+parent.id))[0].checked  = true;
               }
           }
       }
    }
};

//获取选中的结点
function getSelected(){ 
    var idList = "";  
     $("input:checked").each(function(){
        var id = $(this).attr("id"); 
         
        if(id.indexOf('check_type')== -1 && id.indexOf("check_")>-1)
            idList += id.replace("check_",'')+',';
          
     });
    alert(idList);
}

//初始化模态窗
function initModal(){
	
	$.parser.parse($("#permission-modal-div"));
	
}

//打开模态窗
function saveNodeModal(){
	$("#add-tree-nodes").window("open");
}
 
function addNode(){

	$("#add").bind("click",function(){
		
		var flag = $("#add-tree-nodes").form("enableValidation").form("validate");
		if(flag){
			var dto = $.getForm("add-tree-nodes");
			$.ajax({
		  		url:"menu/add",
		  		type:"post",
		  		dataType: 'json',
		  		data:dto,
		        contentType:'application/json;charset=UTF-8',        
		  		success:function(result){
		  			if(result.data == "success"){
		  				$("#add-tree-nodes").window("close");
			  			$("#permission-tree").treegrid({
			  		        url: "permission/buildPermissionTree"
			  			});
			  			$.clean("add-tree-nodes");
		  			}else{
		  				alert(result.data);
		  			}
		  			
		  		},
		  		error:function(data){
		  			alert("ajax提交失败，请重新尝试！");
		  		}
		  	}); 
		}
	});
}

function closeNodesModal(){
	$("#add-tree-nodes").window("close");
}
