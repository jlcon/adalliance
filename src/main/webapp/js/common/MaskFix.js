Ext.form.Basic.prototype.afterAction = function(action, success) {
    if (action.waitMsg) {
        var messageBox = Ext.MessageBox,
            waitMsgTarget = this.waitMsgTarget;
        if (waitMsgTarget === true) {
            this.owner.el.unmask();
        } else if (waitMsgTarget) {
            waitMsgTarget.unmask();
        } else {
            // Do not fire the hide event because that triggers complex processing
            // which is not necessary just for the wait window, and which may interfere with the app.
            messageBox.suspendEvents(true);
            messageBox.hide();
            messageBox.resumeEvents();
        }
    }
    if (success) {
        if (action.reset) {
            this.reset();
        }
        Ext.callback(action.success, action.scope || action, [this, action]);
        this.fireEvent('actioncomplete', this, action);
    } else {
        Ext.callback(action.failure, action.scope || action, [this, action]);
        this.fireEvent('actionfailed', this, action);
    }
}