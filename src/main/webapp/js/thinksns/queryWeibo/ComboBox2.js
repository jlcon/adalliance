var combobox2 = Ext.create('Ext.form.field.ComboBox',{
	xtype		: 'combobox',
	id			: 'combo2',
    name		: 'combo2',
    queryMode	: 'remote',
    labelWidth	: 30,
    editable	: false,
    allowBlank	: true,
    typeAhead	: true,
//    pageSize	: 30,
    minChars	: 1,
    emptyText	: '分组选择',
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
	        url: '/js/旺财狗/会员管理/站长管理/combo2.json',
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
    triggerAction	: 'all'
});