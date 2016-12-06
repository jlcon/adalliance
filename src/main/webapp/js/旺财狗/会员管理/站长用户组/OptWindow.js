var win;
var _parentid;
var _nodeid = null;
var _sysinfo;
var _optType;
function optWindow(sysinfo,optType){
	_optType = optType;

	if(_optType=='edit'){
		
	} else {
	
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
        		
        		if(_optType=='edit'){
        			
        		}

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
					id:'roleid',
				    xtype: 'radiogroup',
				    fieldLabel: '用户角色',
				    items: [
				        {boxLabel: '网站主', name: 'role',inputValue:'wzz',checked:true},
				        {boxLabel: '联盟客服', name: 'role',inputValue:'llkf'},
				        {boxLabel: '广告商', name: 'role',inputValue:'ggs'}
				    ]
				},{
		            id		: 'text',
		            name		: 'text',
		            fieldLabel	: '用户名'
		        },{
		            id			: 'url',
		            name		: 'url',
		            allowBlank	: true,
		            fieldLabel	: '用户密码'
		        },{
		            id			: 'code',
		            name		: 'code',
		            allowBlank	: false,
		            fieldLabel	: '联系人'
		        },{
		            id			: 'qq',
		            name		: 'qq',
		            allowBlank	: false,
		            fieldLabel	: 'QQ'
		        }]
	    }],
	    buttons: [{
	        text: '确定',
	        handler: function() {
	        	
	            var myForm = Ext.getCmp('myForm').getForm();
	            if (myForm.isValid()) {
	            	myForm.submit({
	            		url:_optType=='edit'?'':'',
	            		waitTitle:'提交',
	            		waitMsg:'数据提交中请稍候...',
	                    success: function(form, action) {
	                    	
	                    	var leaf = Ext.getCmp('leafid').getChecked()[0].inputValue;
	                    	var tmp = tree.getSelectionModel().getSelection()[0];
	                    	if(_optType=='edit'){
	                    		
	                    	} else {
					        
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