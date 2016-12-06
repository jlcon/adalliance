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
            			fieldLabel:'最低付款金额(元)',
            			emptyText:'余额达到这个最低值时给于结算'
					},{
						xtype: 'radiogroup',
						fieldLabel: '劳务税',
						columns:2,
						items: [
						     {boxLabel: '不代扣', name: 'item2',inputValue:'item1',checked:true},
						     {boxLabel: '带扣', name: 'item2',inputValue:'item2'}
						]
					},{
						xtype:'checkboxgroup',
					    fieldLabel: '结算周期',
					    name: 'cbg1',
					    columns: 1,
					    vertical: false,
					    items: [
					    		{ boxLabel: '日结 每日结算一次', name: 'rb', inputValue: '1' },
					            { boxLabel: '周结 每周在一个指定的星期几结算', name: 'rb', inputValue: '2', checked: true },
					            { boxLabel: '月结 每月在一个指定的月号结算', name: 'rb', inputValue: '3' }
					          ]}]
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
				fieldLabel: '结算方式',
				columns:3,
				items: [
				     {boxLabel: '自动结算', name: 'item2',inputValue:'item1',checked:true},
				     {boxLabel: '手动结算', name: 'item2',inputValue:'item2'},
				     {boxLabel: '提现', name: 'item2',inputValue:'item2'}
				]
			},{
    			fieldLabel:'手续费(%)',
    			emptyText:'扣除相应手续费'
			},combobox,combobox2]
        }]
    }]
});