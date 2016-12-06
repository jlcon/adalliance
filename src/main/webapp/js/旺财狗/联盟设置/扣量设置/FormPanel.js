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
                fieldLabel: 'CPS设置（%）',
                name: 'batchNo'
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
                fieldLabel: 'CPA设置（%）',
                name: 'batchNo'
            }]
        }]
    }]
});