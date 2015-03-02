
var Ldata = function(l, h) {
	this.l = l;
	this.h = h;
}; (function($) {
	$.DataFrom = function(args) {
		var AK = 'iG2ffdkYaq8kIjrSfvjMcUrf'; // 初始化 frontia
		args.frontia.init(AK); // 创建一种角色
		var role = new args.Role('role_name'); // 设置当前执行环境的角色
		args.frontia.setCurrentAccount(role); // 创建一组权限
		var acl = new args.ACL(); // 为前面创建的角色设置权限
		acl.setReadAccess(role, true);
		acl.setWriteAccess(role, true);
		this.insert = function(d, id) { // 要插入的数据内容
			 console.log('id:'+id+"===data:"+d.l+","+d.h);
			var docs = {
				demo: {
					"name": id,
					"data": d,
					"Now": Date.now()
				}
			}; // 将数据标准化，转换成 Frontia.Data 对象。
			var data = new args.Data(docs); // 对这组数据进行授权操作，确保数据不会被权限外的人访问到
			data.setAcl(acl); // 将这段数据插入
			args.storage.insertData(data, { // 插入成功的回调
				success: function(result) {
					console.log(arguments);
					console.log('插入成功');
				},
				// 插入失败的回调
				error: function() {
					console.log('插入error');
				}
			})
		}
		this.find = function(id,show) { // 创建一个查询语句
			var query = new args.Query();
			query.on('demo.name').equal(id);
			args.storage.findData(query, { // 查询成功的回调
				success: function(response) {
					var docs = response.result || [];
					console.log('执行查询方法....'+id+':'+docs);
					show(docs);
					return docs;
					//console.log(JSON.stringify(docs));
				},
				// 查询失败的回调
				error: function() {
					console.log('查找失败');
						obj1=null;
							
					return null;
				}
			})
		}
		this.delete = function(id) { // 创建一个查询语句
			var query = new args.Query();
			query.on('demo.name').equal(id); // 删除数据
			args.storage.deleteData(query, { // 删除成功的回调
				success: function(response) {
					var count = response.response_params.count || 0;
					console.log('成功删除了 ' + count + ' 条记录');
				},
				// 查询失败的回调
				error: function() {
					console.log('删除失败');
				}
			})
		}
		this.update = function(d, id) { // 更新的规则
			var update = {
				'$set': {
					"demo.name": id,
					"demo.data": d,
					"demo.Now": Date.now()
				}
			}; // 标准化文档为 Frontia.Data
			var data = new args.Data(update);
			data.setAcl(acl); // 查找的语句
			var query = new args.Query();
			query.on('demo.name').equal(id);
			args.storage.updateData(query, data, { // 插入成功的回调
				success: function(response) { //console.log(arguments);
					var count = response.response_params.count || 0;
					console.log('成功更新了 ' + count + ' 条记录');
				},
				// 插入失败的回调
				error: function() {
					console.log('更新失败');
				}
			})
		}
	};
})(jQuery);
