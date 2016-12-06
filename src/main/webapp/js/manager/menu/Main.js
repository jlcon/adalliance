Ext.require([
    '*'
]);
Ext.onReady(function() {
	Ext.QuickTips.init();
	
	var viewport = Ext.create('Ext.Viewport', {
        layout: 'border',
        items: [
          tb,tree
        ]
    });
	tree.expandAll();
});