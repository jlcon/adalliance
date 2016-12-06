var sysinfo = 'yht';
var tb = Ext.create('Ext.toolbar.Toolbar',{
	region:'north',
	split: false,
	border:false,
	items:[{
		text:'新增会员',
		iconCls:'newOpt',
		listeners:{
			click:function(){
				optWindow(sysinfo,'new');
			}
		}
	},{
		text:'编辑会员',
		iconCls:'EditIco',
		listeners:{
			click:function(){
			}
		}
	},{
		text:'批量激活',
		iconCls:'activate',
		listeners:{
			click:function(){
				
			}
		}
	},{
		text:'批量锁定',
		iconCls:'lockico',
		listeners:{
			click:function(){
			}
		}
	},{
		text:'批量删除',
		iconCls:'DelIco',
		listeners:{
			click:function(){
			}
		}
	},{
		text:'会员状态',
		iconCls:'SelectIco',
		menu:['<b class="menu-title">请选择过滤条件</b>',
	    	{
	    		text:'待审核',
	    		checked: true,
                group: 'type',
	    		handler:function(){
//	    			store.reload({
//	    				params:{type:'yht'}
//	    			});
//	    			sysinfo = 'yht';
//	    			tree.getSelectionModel().deselectAll(true);
	    		}
	    	},{
	    		text:'已审核',
	    		checked: false,
	    		group: 'type',
	    		handler:function(){
//	    			store.reload({
//	    				params:{type:'yjh'}
//	    			});
//	    			sysinfo = 'yjh';
//	    			tree.getSelectionModel().deselectAll(true);
	    		}
	    	},{
	    		text:'已锁定',
	    		checked: false,
	    		group: 'type',
	    		handler:function(){
//	    			store.reload({
//	    				params:{type:'sys'}
//	    			});
//	    			sysinfo = 'sys';
//	    			tree.getSelectionModel().deselectAll(true);
	    		}
	    	}
	    ]
	},'-',{
		text:'刷新',
		iconCls:'refreshOpt',
		listeners:{
			click:function(){
				store.reload();
				tree.expandAll();
			}
		}
	},'->',combobox,combobox2,{
		xtype :'textfield'
	},{
		xtype	:'button',
		text	:'搜索',
		iconCls: 'searchOpt'
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