var mywindow = Ext.create('widget.window', {
	title	: 'window',
	closable	: true,
	closeAction	: 'hide',
	width	: 450,
	modal	: true,
	bodyBorder	: false,
	border	: false,
	resizable	: false,
	layout: {
	    type: 'form',
	    padding: 5
	},
	listeners	:{
		show:function(win){
			Ext.getCmp('myForm').getForm().reset();
	
		}
	},
	items: [{
		xtype		:'form',
		layout		:'form',
		id		:'myForm',
		frame		:true,
		border		:false,
		defaultType	: 'textfield',
		defaults	:{
			labelWidth	: 70,
			anchor		: '100%',
			allowBlank	: false,
			msgTarget	: 'side'
		},
		items:[grid2],
		buttons: [{
	    	text: '确定',
	    	handler: function() {
			var myForm = Ext.getCmp('myForm').getForm();
	        		if (myForm.isValid()) {
	        		myForm.submit({
	        			url:_optType=='edit'?'':'',
	        			waitTitle:'提交',
	        			waitMsg:'数据提交中请稍候...',
	                		
				success: function(form, action) {
	                	
	                	
	               		 },
	                		failure: function(form, action) {
	                   			Ext.MessageBox.show({
				           title: '错误',
				           msg: action.result.errorMessage,
				           buttons: Ext.MessageBox.OK,
				           icon: Ext.MessageBox.ERROR
				       });
	                }
	            });
	        }
	    	
	               
	    	}
			},{
	    		text: '取消',
	    		handler: function() {
	        		win.close();
	    	}
		}]
	});
var store2 = new Ext.data.JsonStore({
    storeId: 'myStore',
    pageSize: pageSize,
    autoLoad:true,
    proxy: {
        type: 'ajax',
        url: '/thinksns/queryWeibo/query.htm',
        reader: {
            type: 'json',
            root: 'data',
            totalProperty:'totalPage',
            idProperty: 'name'
        }
    },
    fields: ['name', 'work','phone','groupname','writetime','weekdays'],
    groupField: 'groupname'
});
var xq = [' 星期一',' 星期二',' 星期三',' 星期四',' 星期五',' 星期六',' 星期日'];
var nodemenu = null;
var grid2 = Ext.create('Ext.grid.GridPanel',{
	id:'mygrid2',
	region:'center',
	store:store,
	forceFit: true,
	rowLines:true,
	columnLines: true,
    viewConfig:{  
	   enableTextSelection:false  
	},
    columns: [
        { text: '同学名字', dataIndex: 'name',width:100},
        /*{ text: '联系方式', dataIndex: 'phone',width:70},*/
        { text: '工作内容', dataIndex: 'work',renderer: function(value, meta, record) {
        	meta.style = 'overflow:auto;padding: 3px 6px;text-overflow: ellipsis;white-space: nowrap;white-space:normal;line-height:20px;';
        	if(value != undefined&&(value.indexOf('学习') > 0||value.indexOf('研究') > 0)){
        		meta.style = "background-color:yellow;";
        	}
            return value;   
       },width:840},
      /* { text: '分组', dataIndex: 'groupname',width:100},*/
        { text: '时间', dataIndex: 'writetime',width:150,renderer: function(value, meta, record) {
        	if(record.get('weekdays')!=undefined){
        		value += xq[record.get('weekdays')];
        	}
            return value;   
       }}
    ],
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