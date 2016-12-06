var combobox2 = Ext.create('Ext.form.field.ComboBox',{
	xtype		: 'combobox',
    queryMode	: 'remote',
    editable	: false,
    allowBlank	: true,
    typeAhead	: true,
//    pageSize	: 30,
    minChars	: 1,
    emptyText	: '每月的几号结算',
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
	        url: '/js/旺财狗/联盟设置/财务相关/combo2.json',
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
    fieldLabel		: '月结几号'
});