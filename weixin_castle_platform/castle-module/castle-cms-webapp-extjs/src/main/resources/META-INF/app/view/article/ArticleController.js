Ext.define("app.view.article.ArticleController", {
	extend : "Ext.app.ViewController",
	alias : "controller.article",
	mixins : {
		center : "app.view.main.CenterController"
	},

	onItemClick : function(grid, item) {
		
	},

	onAdd : function(button) {
		var code = "articleform";
		var tab = this.findTabByCode(code);
		if (!tab) {
			var view = Ext.create("app.view.article.ArticleForm", {
				id : code,
				closable : true,
				title : "新建文章",
				iconCls : "fa fa-user"
			});
			tab = this.addViewToCenter(code, view);
		}
		this.activeTab(tab);
	},
	
	onRowEdit : function(grid, rowIndex, colIndex) {
		var item = grid.getStore().getAt(rowIndex);
		var code = "articleform" + item.id;
		var tab = this.findTabByCode(code);
		if (!tab) {
			var view = Ext.create("app.view.article.ArticleForm", {
				id : code,
				closable : true,
				title : "编辑文章【" + item.get("title") + "】",
				iconCls : "fa fa-user"
			});
			view.loadRecord(item);
			tab = this.addViewToCenter(code, view);
		}
		this.activeTab(tab);
	},
	
	onRowDelete : function(grid, rowIndex, colIndex) {
		var menu = grid.getStore().getAt(rowIndex);
		Ext.Msg.confirm("提示", "您确定要删除【" + menu.get("title") + "】？", function(choice) {
			if (choice === "yes") {

				var store = grid.getStore();

				Ext.Ajax.request({
					url : Ext.ctx + "/article/delete",
					params : {
						id : menu.id
					},
					method : "POST",
					success : function(response) {
						Ext.toast("操作成功", null, "t");
						store.remove(menu);
					}
				});
			}
		}, this);
	},

	onFormSave : function(button) {
		var formPanel = button.up("articleform");
		var form = formPanel.getForm();
		var store = this.getViewModel().getStore("list");

		var me = this;
		if (form.isValid()) {
			form.submit({
				success : function(form, action) {
					Ext.toast("操作成功", null, "t");
					store.reload();
					me.closeTab(formPanel);
				},
				failure : function(form, action) {
					Ext.toast("操作失败", null, "t");
				}
			});
		}
	},

	onDelete : function(button) {
		var grid = button.up("articlelist");
		var data = grid.getSelection();
		if (data.length == 0) {
			Ext.Msg.alert("提示", "您最少要选择一条数据");
		} else {
			Ext.Msg.confirm("提示", "您确定要删除所选数据？", function(choice) {
				if (choice === "yes") {
					var ids = [];
					Ext.each(data, function(record, index, array) {
						ids.push(record.id);
					});

					var store = this.getViewModel().getStore("list");

					Ext.Ajax.request({
						url : Ext.ctx + "/article/delete",
						params : {
							ids : ids
						},
						method : "POST",
						success : function(response) {
							Ext.toast("操作成功", null, "t");
							store.remove(data);
						}
					});
				}
			}, this);
		}
	}
});