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
                fieldLabel: '联盟名称',
                name: 'batchNo'
            },{
                fieldLabel: '24小时允许注册次数',
                name: 'batchStatus'
            },{
            	xtype		:'textarea',
                fieldLabel	: '屏蔽以下IP注册',
                name		: 'orderTotalAmount'
            },{
	        	xtype:'checkboxgroup',
	            fieldLabel: '允许新用户注册',
	            name: 'accuracyLoss',
	            vertical: false,
	            items: [
	                    { boxLabel: '开放站长注册', name: 'rb', inputValue: '1' },
	                    { boxLabel: '开放广告商注册', name: 'rb', inputValue: '2', checked: true }
	                ]
	        },{
				xtype: 'radiogroup',
				fieldLabel: '新增网站',
				columns	:1,
				items: [
				     {boxLabel: '人工审核', name: 'item1',inputValue:'item1',checked:true},
				     {boxLabel: '自动通过', name: 'item2',inputValue:'item2'},
				     {boxLabel: '需验证网站后自动通过', name: 'item3',inputValue:'item3'},
				     {boxLabel: '需验证网站后人工审核', name: 'item3',inputValue:'item3'}
				]
			},{
				xtype: 'radiogroup',
				fieldLabel: '赠送款项到',
				items: [
				     {boxLabel: '日款', name: 'item1',inputValue:'item1',checked:true},
				     {boxLabel: '周款', name: 'item2',inputValue:'item2'},
				     {boxLabel: '月款', name: 'item2',inputValue:'item2'}
				]
			},{
                fieldLabel: '赠送款金额',
                name: 'realCostAmount'
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
            	xtype:'checkboxgroup',
                fieldLabel: '计费模式开关',
                name: 'accuracyLoss',
                columns: 2,
                vertical: false,
                items: [
                        { boxLabel: 'CPC', name: 'rb', inputValue: '1' },
                        { boxLabel: 'CPM', name: 'rb', inputValue: '2', checked: true },
                        { boxLabel: 'CPV', name: 'rb', inputValue: '3' },
                        { boxLabel: 'CPS', name: 'rb', inputValue: '4' },
                        { boxLabel: 'CPA', name: 'rb', inputValue: '5' }
                    ]
            	},{
					xtype: 'radiogroup',
					fieldLabel: '域名限制',
					items: [
					     {boxLabel: '开启', name: 'item1',inputValue:'item1',checked:true},
					     {boxLabel: '关闭', name: 'item2',inputValue:'item2'}
					]
				},{
	                fieldLabel: '安全密钥',
	                name: 'batchProfit'
	            },{
	                fieldLabel: 'PV步长值',
	                name: 'batchProfit'
	            },{
					xtype: 'radiogroup',
					fieldLabel: '注册验证',
					items: [
					     {boxLabel: '手动审核 ', name: 'item1',inputValue:'item1',checked:true},
					     {boxLabel: 'Email 验证 ', name: 'item2',inputValue:'item2'},
					     {boxLabel: '直接通过', name: 'item3',inputValue:'item3'}
					]
				},{
					xtype: 'radiogroup',
					fieldLabel: '联盟标志',
					items: [
					     {boxLabel: '显示', name: 'item1',inputValue:'item1',checked:true},
					     {boxLabel: '关闭', name: 'item2',inputValue:'item2'}
					]
				},{
					xtype: 'radiogroup',
					fieldLabel: '会员登入验证码',
					items: [
					     {boxLabel: '启用', name: 'item1',inputValue:'item1',checked:true},
					     {boxLabel: '关闭', name: 'item2',inputValue:'item2'}
					]
				},{
					xtype: 'radiogroup',
					fieldLabel: '会员注册验证码',
					items: [
					     {boxLabel: '启用', name: 'item1',inputValue:'item1',checked:true},
					     {boxLabel: '关闭', name: 'item2',inputValue:'item2'}
					]
				},{
					xtype: 'radiogroup',
					fieldLabel: '注册赠送钱',
					items: [
					     {boxLabel: '启用', name: 'item1',inputValue:'item1',checked:true},
					     {boxLabel: '关闭', name: 'item2',inputValue:'item2'}
					]
				}]
        }]
    }]
});