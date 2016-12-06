var win;
var _parentid;
var _nodeid = null;
var _sysinfo;
var _optType;
function optWindow(sysinfo,optType){
	_optType = optType;
	var parentids = tree.getSelectionModel().getSelection();
	
	if(parentids.length==0){
		AlertError("错误","请选择父节点！");
		return;
	}
	_sysinfo = sysinfo;
	if(_optType=='edit'){
		_parentid = parentids[0].parentNode.get('menuId');
		_nodeid = parentids[0].get('menuId');
	} else {
		_parentid = parentids[0].get('menuId');
	}
	if(win==''||win==null||win==undefined){
	
		win = Ext.create('widget.window', {
	    title		: '添加/编辑',
	    closable	: true,
	    closeAction	: 'hide',
	    width		: 450,
	    modal		: true,
	    bodyBorder	: false,
	    border		: false,
	    resizable	: false,
	    layout: {
	        type: 'form',
	        padding: 5
	    },
        listeners	:{
        	show:function(win){
        		Ext.getCmp('myForm').getForm().reset();
        		if(_parentid!=null){
        			Ext.getCmp('parentId').setValue(_parentid);
        		}
        		Ext.getCmp('type').setValue(_sysinfo);
        		if(_optType=='edit'){
        			Ext.getCmp('myForm').getForm().load({
		    				url:'/manager/menu/getNodeById.htm',
		    				params:{menuId:_nodeid}
		    			});
		    		Ext.getCmp('parentId').setValue(_parentid);
        		}
        		_parentid = null;
        		_nodeid = null;
        	}
        },
	    items: [{
	    	xtype		:'form',
	    	layout		:'form',
	    	id			:'myForm',
	    	frame		:true,
	    	border		:false,
	    	defaultType	: 'textfield',
	    	defaults	:{
	    		labelWidth	:70,
	    		anchor		: '100%',
	    		allowBlank	: false,
	    		msgTarget	: 'side'
	    	},
	    	items:[
	    		{
	    			xtype		:'hiddenfield',
//	    			xtype		:'textfield',
		            id			:'parentId',
		            name		:'parentId',
		            allowBlank	: true,
		            fieldLabel	: 'parentId'
		        },{
	    			xtype		:'hiddenfield',
//	    			xtype		:'textfield',
		            name		:'menuId',
		            allowBlank	: true,
		            fieldLabel	: 'menuId'
		        },{
	    			xtype		:'hiddenfield',
//	    			xtype		:'textfield',
		            id		:'type',
		            name		:'type',
		            allowBlank	: true,
		            fieldLabel	: 'menuId'
		        },{
		            id		: 'text',
		            name		: 'text',
		            fieldLabel	: '节点名称'
		        },{
		            id			: 'url',
		            name		: 'url',
		            allowBlank	: true,
		            fieldLabel	: 'url'
		        },{
		            id			: 'code',
		            name		: 'code',
		            allowBlank	: false,
		            fieldLabel	: 'code'
		        },{
		        	id:'leafid',
                    xtype: 'radiogroup',
                    fieldLabel: '类型',
                    items: [
                        {boxLabel: '文件夹', name: 'leaf',inputValue:'false',checked:true},
                        {boxLabel: '节点', name: 'leaf',inputValue:'true'}
                    ]
                },{
                    xtype: 'radiogroup',
                    id:'expandedid',
                    fieldLabel: '默认展开',
                    items: [
                        {boxLabel: '展开', name: 'expanded',inputValue:'true',checked:true},
                        {boxLabel: '关闭', name: 'expanded',inputValue:'false'}
                    ]
                }]
	    }],
	    buttons: [{
	        text: '确定',
	        handler: function() {
	        	
	            var myForm = Ext.getCmp('myForm').getForm();
	            if (myForm.isValid()) {
	            	myForm.submit({
	            		url:_optType=='edit'?'/manager/menu/updateNodeById.htm':'/manager/menu/addNode.htm',
	            		waitTitle:'提交',
	            		waitMsg:'数据提交中请稍候...',
	                    success: function(form, action) {
	                    	
	                    	var leaf = Ext.getCmp('leafid').getChecked()[0].inputValue;
	                    	var tmp = tree.getSelectionModel().getSelection()[0];
	                    	if(_optType=='edit'){
	                    		tmp.set('text',Ext.getCmp('text').getValue());
	                    		tmp.set('leaf',leaf);
	                    		tmp.set('code',Ext.getCmp('code').getValue());
	                    		tmp.set('url',Ext.getCmp('url').getValue());
	                    		tmp.set('expanded',Ext.getCmp('expandedid').getChecked()[0].inputValue);
	                    	} else {
					        	insertNode(tmp,{
					        			menuId:action.result.msg,
						        		text:Ext.getCmp('text').getValue(),
						        		leaf:leaf,
						        		code:Ext.getCmp('code').getValue(),
						        		url:Ext.getCmp('url').getValue(),
						        		expanded:Ext.getCmp('expandedid').getChecked()[0].inputValue
					        		});
	                    	}
				        	myForm.reset();
				        	win.close();
	                    },
	                    failure: function(form, action) {
	                        Ext.MessageBox.show({
					           title: '错误',
					           msg: action.result.errorMessage,
					           buttons: Ext.MessageBox.OK,
					           icon: Ext.MessageBox.ERROR
					       });
	                    }
	                });
	            }
	        }
	    },{
	        text: '取消',
	        handler: function() {
	            win.close();
	        }
	    }]
	    });
    }
    win.show();
}

function insertNode(pnode,node){
	pnode.appendChild(node);
//	store.sync();
//	alert(pnode.get('text'));
}