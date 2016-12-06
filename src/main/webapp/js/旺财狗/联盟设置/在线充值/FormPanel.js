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
            			fieldLabel:'在线充值最低额(元)'
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
				xtype: 'radiogroup',
				fieldLabel: '默认使用网关',
				columns:1,
				items: [
				     {boxLabel: '支付宝', name: 'item2',inputValue:'item1',checked:true},
				     {boxLabel: '财付通', name: 'item2',inputValue:'item2'},
				     {boxLabel: '网银在线', name: 'item2',inputValue:'item2'},
				     {boxLabel: '快钱', name: 'item2',inputValue:'item2'}
				]
			}]
        }]
    }]
});