var store = new Ext.data.JsonStore({
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
    fields: ['name', 'email','work','phone','groupname','writetime','weekdays'],
    groupField: 'groupname'
});

var sm = Ext.create('Ext.selection.CheckboxModel');
var xq = [' 星期一',' 星期二',' 星期三',' 星期四',' 星期五',' 星期六',' 星期日'];
var nodemenu = null;
var grid = Ext.create('Ext.grid.GridPanel',{
	id:'mygrid',
	region:'center',
	store:store,
	forceFit: true,
	rowLines:true,
	columnLines: true,
    selModel: sm,
    viewConfig:{  
	   enableTextSelection:true  
	},
	features: [{
        id: 'group',
        ftype: 'grouping',
        groupHeaderTpl: ['<div>{name:this.formatName}</div>',
                         {
                             formatName: function(name) {
                            	 var name = Ext.String.trim(name);
                            	 if(name == '')
                            		 return '没写日志的同学';
                            	 else if(name=='android用户组')
                            		 return 'Android';
                            	 else if(name=='ios用户组')
                            		 return 'IOS';
                            	 else if(name=='web前端')
                            		 return '前端';
                            	 else if(name=='java组')
                            		 return 'JAVA';
                                 return name;
                             }
                         }
                     ],
        hideGroupedHeader: true,
        enableGroupingMenu: false
    }],
    columns: [
        { text: '同学名字', dataIndex: 'name',width:100},
        { text: '工作内容', dataIndex: 'work',renderer: function(value, meta, record) {
        	meta.style = 'overflow:auto;padding: 3px 6px;text-overflow: ellipsis;white-space: nowrap;white-space:normal;line-height:20px;';
        	if(value != undefined&&(value.indexOf('习') > 0||value.indexOf('研究') >= 0)){
        		meta.style = "background-color:yellow;";
        	}
            return value;
       },width:840},
       { text: '分组', dataIndex: 'groupname',width:100},
       { text: '时间', dataIndex: 'writetime',width:150,renderer: function(value, meta, record) {
    	   if(record.get('weekdays')!=undefined){
    		   value += xq[record.get('weekdays')];
    	   }
           return value;   
       }}
    ],
    listeners:{
    	itemcontextmenu:function(his, record, item, index, e){
    		/*e.preventDefault();    
    	    e.stopEvent();// 取消浏览器默认事件
    	    if(nodemenu!=null){
    	    	nodemenu.destroy();
    	    }
	    	nodemenu = new Ext.menu.Menu({ 
    	        items : [{    
    	            text : '按时间查看...',    
    	            handler : function() {  
    	                alert(record.raw.name);    
    	            }    
    	        }]
    	    });
    	    nodemenu.showAt(e.getXY());// 菜单打开的位置  
*/		}
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