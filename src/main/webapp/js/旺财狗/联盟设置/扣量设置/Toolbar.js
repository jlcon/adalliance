var tb = Ext.create('Ext.toolbar.Toolbar',{
	region:'north',
	split: false,
	border:false,
	items:[{
		text:'保存设置',
		iconCls:'SaveOpt',
		listeners:{
			click:function(){
				Ext.MessageBox.show({
					title: '信息',
				    msg: '保持设置成功',
				    buttons: Ext.MessageBox.OK,
				    icon: Ext.MessageBox.INFO
				});
			}
		}
	},'-',{
		text:'刷新',
		iconCls:'refreshOpt',
		listeners:{
			click:function(){
			}
		}
	}]
});