var formpanel = Ext.create('Ext.panel.Panel',{
	region:'center',
	id:'showform',
	name:'overviewForm',
	frame:true,
	bodyPadding: '5 5 0',
	items:[{
        xtype: 'container',
        anchor: '100%',
        layout: 'hbox',
        items:[{
            xtype: 'container',
            flex: 1,
            layout: 'anchor',
            defaults:{
            	xtype:'textfield',
            	anchor:'95%',
            	readOnly:false,
            	allowBlank:false,
	    		labelWidth:150
	    	},
            items: [{
						xtype: 'radiogroup',
						fieldLabel: '云端作弊扫描',
						items: [
						     {boxLabel: '开启（推荐）', name: 'item1',inputValue:'item1',checked:true},
						     {boxLabel: '关闭', name: 'item1',inputValue:'item2'}
						]
					},{
						xtype: 'radiogroup',
						fieldLabel: '开启积分功能',
						items: [
						     {boxLabel: '开启', name: 'item1',inputValue:'item1',checked:true},
						     {boxLabel: '关闭', name: 'item1',inputValue:'item2'}
						]
					},{
		                fieldLabel: '1元等于多少积分',
		                name: 'batchNo',
		                emptyText:'广告收入转成积分设置，财务管理结算会自动转换成积分'
		            },{
		                fieldLabel: 'QQ OAuth2.0(APP ID)',
		                name: 'batchNo',
		                emptyText:'APP ID'
		            },{
		                fieldLabel: 'QQ OAuth2.0(APP KEY)',
		                emptyText:'APP KEY)'
		            }]
        },{
            xtype: 'container',
            flex: 1,
            defaults:{
            	xtype:'textfield',
	    		labelWidth:100,
	    		readOnly:false,
	    		allowBlank:false,
	    		anchor:'95%'
	    	},
            layout: 'anchor',
            items: [{
            	xtype		:'textarea',
                fieldLabel	: '屏蔽以下IP注册',
                name		: 'orderTotalAmount',
                emptyText	:'屏蔽IP进入管理后台，多IP用“,”分隔 如：192.168.1.1,192.168.1.2'
            },,{
				xtype: 'radiogroup',
				fieldLabel: '开启下线分成',
				items: [
				     {boxLabel: '开启', name: 'item1',inputValue:'item1',checked:true},
				     {boxLabel: '关闭', name: 'item1',inputValue:'item2'}
				]
			},{
                fieldLabel: '广告异常提示1',
                emptyText:'会员锁定或是非正常状态下还在投放代码'
            },{
            	fieldLabel: '广告异常提示2',
                emptyText:'会员锁定或是非正常状态下还在投放代码'
            },{
            	fieldLabel: '广告异常提示3',
                emptyText:'会员锁定或是非正常状态下还在投放代码'
            }]
        }]
    }]
});