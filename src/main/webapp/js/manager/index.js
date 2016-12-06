Ext.require([
    'Ext.tab.*',
    'Ext.window.*',
    'Ext.tip.*',
    'Ext.layout.container.Border'
]);
Ext.onReady(function(){
	Ext.define('TreeModel', {
	    extend: 'Ext.data.Model',
	    fields: [
	        {name: 'text',     type: 'string'},
	        {name: 'code',     type: 'string'},
	        {name: 'url',     type: 'string'},
	        {name: 'type',     type: 'string'},
	        {name: 'icon',     type: 'string'},
	        {name: 'expanded', type: 'bool'},
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
	    },
	    folderSort: true
	});
	var menutree = Ext.create('Ext.tree.Panel', {
	    title: '功能菜单',
	    region: 'west',
	    animate:true,
	    animateShadow:true,
	    useArrows: true,
	    frame: true,
	    border:false,
	    bodyBorder:false,
	    width: 200,
	    store: store,
	    rootVisible: false,
	    listeners:{
	    	itemclick:function(v,record ,index ,eOpts ){
	    		var mytab = Ext.getCmp('mytab');
	    		var thetab = mytab.queryById(record.raw.menuId);
	    		if (thetab == null&&record.raw.code != undefined&&record.raw.leaf==true) {
	    			mytab.add({
	    				id:record.raw.menuId,
	    	            closable: true,
	    	            title: record.raw.text,
	    	            html:'<iframe src="/manager/menu/toPage.htm?code='+encodeURIComponent(record.raw.url)+'" frameborder=0  scrolling="auto" frameborder="0" width="100%" height="100%"></iframe>'
	    	        }).show();
	    		} else if(thetab != null){
	    			thetab.show();
	    		}
	    	}
	    }
	});
	
	//menutree.expandAll();
	Ext.create('Ext.container.Viewport', {
	    layout: 'border',
	    defaults: {  
	        split: true,                 //是否有分割线  
	        collapsible: false           //是否可以折叠  
//	        bodyStyle: 'padding:15px'  
	    }, 
	    items: [{
	        region: 'north',
	        html: '<h>欢迎使用工作管理台</h><a href="/logout" style="float:right">退出登录</a>',
	        border: false,
	        frame:true,
	        margin: '0 0 5 0'
	    }, menutree, {
	    	id:'mytab',
	        region: 'center',
	        xtype: 'tabpanel', // TabPanel itself has no title
	        activeTab: 0,      // First tab active by default
	        items: {
	            title: '欢迎使用',
	            html: '<div style="margin-left:300px;margin-top:200px;">&gt;Hello World !</div>'
	        }
	    }]
	});
});