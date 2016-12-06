var sysinfo = 'yht';
var tb = Ext.create('Ext.toolbar.Toolbar',{
	region:'north',
	split: false,
	border:false,
	items:['->',{
		xtype :'textfield',
		id:'uname',
		labelWidth:30,
		fieldLabel: '姓名'
	},'&nbsp',{
		xtype:'datefield',
		id:'timeStart',
		anchor: '100%',
		labelWidth:60,
		fieldLabel: '开始时间',
		format:'Y-m-d',
		editable:false,
		name:'timeStart'
	},'&nbsp',{
		xtype:'datefield',
		id:'timeEnd',
		labelWidth:60,
		fieldLabel: '截止时间',
		format:'Y-m-d',
		editable:false,
		name:'timeEnd'
	},'&nbsp',{
        xtype:'splitbutton',
        text: '搜索',
        iconCls: 'searchOpt',
        handler: function() {
			store.reload({
				params:{
		        	timeStart:Ext.getCmp('timeStart').getRawValue(),
		        	uname:Ext.getCmp('uname').getValue(),
		        	timeEnd:Ext.getCmp('timeEnd').getRawValue(),
		        	selectedNames:[]
				}
	        });
			Ext.apply(Ext.getCmp('mygrid').store.proxy.extraParams, {
				timeStart:Ext.getCmp('timeStart').getRawValue(),
	        	timeEnd:Ext.getCmp('timeEnd').getRawValue(),
	        	uname:Ext.getCmp('uname').getValue(),
	        	selectedNames:[]
			});
	    },
        menu: [
           {
            	text: '按选定人搜索',
            	handler: function() {
            		selectedRows = grid.getSelection();
            		var records = new Array();
            		for(var g1 = 0;g1 <selectedRows.length;g1++){
            			records[g1] = selectedRows[g1].get('email');
            		}
            		if(records.length == 0){
            			AlertInfo("提示","请先在表格中勾选要查看的人，还可选择查询时间范围。");
            			return;
            		}
            		store.reload({
	    				params:{
	    		        	timeStart:Ext.getCmp('timeStart').getRawValue(),
	    		        	timeEnd:Ext.getCmp('timeEnd').getRawValue(),
	    		        	selectedNames:records,
	    		        	uname:null
	    				}
	    	        });
            		Ext.apply(Ext.getCmp('mygrid').store.proxy.extraParams, {
            			timeStart:Ext.getCmp('timeStart').getRawValue(),
    		        	timeEnd:Ext.getCmp('timeEnd').getRawValue(),
    		        	selectedNames:records,
    		        	uname:null
	    			});
            	}
            },
            {
	        	text: '昨天',
	        	handler: function() {
	    			store.reload({
	    				params:{
	    		        	timeStart:dateAdd(-1),
	    		        	timeEnd:dateAdd(-1)
	    				}
	    	        });
	    			Ext.apply(Ext.getCmp('mygrid').store.proxy.extraParams, {
	    				timeStart:dateAdd(-1),
	    	        	timeEnd:dateAdd(-1)
	    			});
	    	    }
        	},{
        		text: '前天',
        		handler: function() {
        			store.reload({
        				params:{
        		        	timeStart:dateAdd(-2),
        		        	timeEnd:dateAdd(-2)
        				}
        	        });
        			Ext.apply(Ext.getCmp('mygrid').store.proxy.extraParams, {
        				timeStart:dateAdd(-2),
        	        	timeEnd:dateAdd(-2)
        			});
        	    }
        	}]
    },'-',{
		text:'刷新',
		iconCls:'refreshOpt',
		listeners:{
			click:function(){
				store.reload();
			}
		}
	}]
});
function dateAdd(add){
	var date = new Date();
	date.setDate(date.getDate()+add);
	var y = date.getFullYear(); 
	var m = date.getMonth()+1;//获取当前月份的日期 
	var d = date.getDate();
           m = m<10 ? '0'+m+"" : m;
           d = d < 10 ? '0'+d+"" : d;
	return y+"-"+m+"-"+d;
}