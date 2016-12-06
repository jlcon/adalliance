var store = new Ext.data.JsonStore({
    storeId: 'myStore',
    pageSize: pageSize,
    autoLoad:true,
    proxy: {
        type: 'ajax',
        url: '/js/旺财狗/会员管理/站长用户组/grid.json',
        reader: {
            type: 'json',
            root: 'result',
            totalProperty:'totalCount',
            idProperty: 'name'
        }
    },
    fields: ['a','b', 'c', 'd',	'e','f','g','h','i','j','k']
});

var sm = Ext.create('Ext.selection.CheckboxModel');
var grid = Ext.create('Ext.grid.GridPanel',{
	id:'mygrid',
	region:'center',
	store:store,
	forceFit: false,
	columnLines: true,
    selModel: sm,
    viewConfig:{  
	   enableTextSelection:true  
	},
    columns: [
        { text: 'ID', dataIndex: 'a',width:120},
        { text: '分组名称', dataIndex: 'b',width:170},
        { text: '站长数量', dataIndex: 'c',width:140}
    ],
    listeners:{
    	celldblclick:function(table, td, cellIndex, record, tr, rowIndex, e, eOpts){
//    		showWindow(record.get('logId'));
    	}
    },
    bbar: Ext.create('Ext.PagingToolbar', {
        store: store,
        displayInfo: true,
        displayMsg: '第{0}到{1}条/ 共 {2}',
        emptyMsg: "没有数据显示"
    })
});
function getSelected(){
	var sel = grid.getSelectionModel().getSelection();
	return sel;
}