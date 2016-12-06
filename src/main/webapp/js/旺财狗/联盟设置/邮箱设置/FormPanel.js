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
            items: [
                    {
						xtype: 'radiogroup',
						fieldLabel: '何时发送电子邮件',
						columns:1,
						items: [
						     {boxLabel: '注册成功能时', name: 'item1',inputValue:'item1',checked:true},
						     {boxLabel: '会员审核通过时', name: 'item1',inputValue:'item2'},
						     {boxLabel: '网站审核通过时 ', name: 'item1',inputValue:'item3'},
						     {boxLabel: '财务结算付款时 ', name: 'item1',inputValue:'item3'}
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
				xtype: 'radiogroup',
				fieldLabel: '邮件发送方式',
				columns:1,
				items: [
				     {boxLabel: '过 PHP 函数的 Sendmail 发送(推荐此方式) 需要支持Sendmail.', name: 'item2',inputValue:'item1',checked:true},
				     {boxLabel: '通过 SOCKET 连接 SMTP 服务器发送', name: 'item2',inputValue:'item2'}
				]
			}]
        }]
    }]
});