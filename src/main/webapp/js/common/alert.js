function AlertError(title,msg){
	Ext.MessageBox.show({
       title: title,
       msg: msg,
       buttons: Ext.MessageBox.OK,
       icon: Ext.MessageBox.ERROR
   });
}

function AlertInfo(title,msg){
	Ext.MessageBox.show({
       title: title,
       msg: msg,
       buttons: Ext.MessageBox.OK,
       icon: Ext.MessageBox.INFO
   });
}