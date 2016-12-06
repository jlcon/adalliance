var sysinfo = 'yht';
var tb = Ext.create('Ext.toolbar.Toolbar',{
	region:'north',
	split: false,
	border:false,
	items:[{
		text:'新增分类',
		iconCls:'newOpt',
		listeners:{
			click:function(){
				optWindow(sysinfo,'new');
			}
		}
	},{
		text:'编辑分类',
		iconCls:'EditIco',
		listeners:{
			click:function(){
			}
		}
	},{
		text:'删除分类',
		iconCls:'DelIco',
		listeners:{
			click:function(){
			}
		}
	}]
});

function delNode(node){
	if(node.length == 0){
		AlertError('错误','请选择需要删除的节点！');
		return;
	}
	
	if(node[0].get('system') == 'yes'){
		AlertError('错误','系统菜单无法删除！');
		return;
	}
		if(node[0].parentNode.isRoot()){
		AlertError('错误','不能删除根节点！');
		return;
	}
	if(node[0].hasChildNodes()){
		AlertError('错误','包含子节点！');
		return;
	}
	
	Ext.Ajax.request({
	    url: '/manager/menu/deleteNodeById.htm',
	    params: {
	        menuId: node[0].get('menuId')
	    },
	    success: function(response){
	    	try{
			    node[0].remove();
		        tree.getSelectionModel().deselectAll(true);
	    	} catch(e) {
	    		AlertError(e.name,e.message);
	    	}
	    },
	    failure: function(response){
	    	alert(response.responseText);
	    }
	});
}