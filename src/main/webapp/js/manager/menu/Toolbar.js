var sysinfo = 'yht';
var tb = Ext.create('Ext.toolbar.Toolbar',{
	region:'north',
	split: false,
	border:false,
	items:[{
		text:'添加菜单',
		iconCls:'newOpt',
		listeners:{
			click:function(){
				optWindow(sysinfo,'new');
			}
		}
	},{
		text:'编辑菜单',
		iconCls:'EditIco',
		listeners:{
			click:function(){
				optWindow(sysinfo,'edit');
			}
		}
	},{
		text:'删除菜单',
		iconCls:'DelIco',
		listeners:{
			click:function(){
				var node = tree.getSelectionModel().getSelection();
				delNode(node);
			}
		}
	},'-',{
		text:'刷新',
		iconCls:'refreshOpt',
		listeners:{
			click:function(){
				store.reload();
				tree.expandAll();
			}
		}
	},'->',{
		text:'选择系统',
		iconCls:'SelectIco',
		menu:['<b class="menu-title">请选择需要管理的菜单</b>',
	    	{
	    		text:'易汇通',
	    		checked: true,
                group: 'type',
	    		handler:function(){
	    			store.reload({
	    				params:{type:'yht'}
	    			});
	    			sysinfo = 'yht';
	    			tree.getSelectionModel().deselectAll(true);
	    		}
	    	},{
	    		text:'易结汇',
	    		checked: false,
	    		group: 'type',
	    		handler:function(){
	    			store.reload({
	    				params:{type:'yjh'}
	    			});
	    			sysinfo = 'yjh';
	    			tree.getSelectionModel().deselectAll(true);
	    		}
	    	},{
	    		text:'系统',
	    		checked: false,
	    		group: 'type',
	    		handler:function(){
	    			store.reload({
	    				params:{type:'sys'}
	    			});
	    			sysinfo = 'sys';
	    			tree.getSelectionModel().deselectAll(true);
	    		}
	    	}
	    ]
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