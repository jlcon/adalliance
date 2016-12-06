Ext.define('TreeModel', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'text',     type: 'string'},
        {name: 'code',     type: 'string'},
        {name: 'url',     type: 'string'},
        {name: 'type',     type: 'string'},
        {name: 'icon',     type: 'string'},
        {name: 'system', type: 'string'},
        {name: 'menuId', type: 'string'}
    ]
});
var store = Ext.create('Ext.data.TreeStore', {
    model: 'TreeModel',
    sorters: [{
	  property: 'code',
	  direction: 'ASC'
	}],
    proxy: {
        type	: 'ajax',
        url		: '/manager/menu/getMenu.htm'
//        api:{
//        	read:'/manager/menu/kjMenu.htm',
//        	destroy:'/manager/menu/deleteNodeById.htm'
//        }
    },
    folderSort: true
});
var tree = Ext.create('Ext.tree.Panel', {
    region:'center',
    viewConfig: {
    	plugins: {
    		ptype: 'treeviewdragdrop'
    	}
    },
    listeners:{
		itemmove:function( node, oldParent, newParent, index, eOpts ){
			Ext.Ajax.request({
			    url: '/manager/menu/updateNodeById.htm',
			    params: {
			        menuId: node.get('menuId'),
			        code: node.get('code'),
			        url: node.get('url'),
			        icon: node.get('icon'),
			        leaf: node.get('leaf'),
			        text: node.get('text'),
			        type: node.get('type'),
			        expanded: node.get('expanded'),
			        parentId: newParent.get('menuId')
			    },
			    success: function(response){
			    },
			    failure: function(response){
			    	alert(response.responseText);
			    }
			});
		},
		itemdblclick:function( view, record, item, index, e, eOpts ){
			optWindow(sysinfo,'edit');
		}
	},
    useArrows: true,
    rootVisible: false,
    store: store,
    multiSelect: false,
    singleExpand: false,
    columns: [{
        xtype: 'treecolumn', 
        text: '菜单',
        sortable: true,
        width:200,
        dataIndex: 'text'
    },{
        text: 'code',
        sortable: true,
        width:100,
        dataIndex: 'code'
    },{
        text: 'URL',
        sortable: true,
        dataIndex: 'url',
        width:700,
        align: 'left'
    }]
});