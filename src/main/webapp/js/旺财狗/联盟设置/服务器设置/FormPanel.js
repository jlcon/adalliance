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
                fieldLabel: '主站服务器IP',
                name: 'batchNo'
            },{
                fieldLabel: '图片服务器',
                name: 'batchNo'
            },{
                fieldLabel: '同步服务器',
                name: 'batchNo'
            },{
				xtype: 'radiogroup',
				fieldLabel: '缓存类型',
				items: [
				     {boxLabel: 'Memcached', name: 'item1',inputValue:'item1',checked:true},
				     {boxLabel: '文件', name: 'item2',inputValue:'item2'},
				     {boxLabel: '不缓存', name: 'item2',inputValue:'item2'}
				]
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
                fieldLabel: 'JS服务器',
                name: 'batchNo'
            },{
                fieldLabel: '跳转服务器',
                name: 'batchNo'
            },{
				xtype: 'radiogroup',
				fieldLabel: 'Master/Slave',
				items: [
				     {boxLabel: '开启', name: 'item1',inputValue:'item1',checked:true},
				     {boxLabel: '关闭', name: 'item2',inputValue:'item2'}
				]
			},{
                fieldLabel: '缓存时间（秒）',
                name: 'batchNo'
            }]
        }]
    }]
});