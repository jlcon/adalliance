var combobox = Ext.create('Ext.form.field.ComboBox',{
	xtype		: 'combobox',
	id			: 'combo1',
    name		: 'combo1',
    queryMode	: 'remote',
    editable	: false,
    allowBlank	: true,
    typeAhead	: true,
//    pageSize	: 30,
    minChars	: 1,
    emptyText	: '每周的星期几结算',
    listeners	: {
    	select	: function(combo, records, eOpts){
    		
    	}
    },
    store: new Ext.data.JsonStore({
	    storeId: 'comboStore',
	    pageSize: 30,
	    autoLoad:true,
	    proxy: {
	        type: 'ajax',
	        url: '/js/旺财狗/联盟设置/财务相关/combo.json',
	        reader: {
	            type: 'json',
	            root: 'result',
	            totalProperty:'totalCount',
	            idProperty: 'name'
	        }
	    },
	    fields: ['key','value'],
	    listeners:{
	    	load:function(){
	    	}
	    }
	}),
    valueField		: 'value',
    displayField	: 'key',
    triggerAction	: 'all',
    fieldLabel		: '周结日期'
});