var indexConfig=[{"cnName":"json 美化工具","ding":"100","url":"jsonFormatUtil.html"}];
var ynConfig=[{"cnName":"kindeditor 与 easyUI结合扩展上传图片 按钮 ","ding":"1","url":"easyUiKinderEditor.html"},{"cnName":"分布式锁的实现思路","ding":"2","url":"distributed.html"}];
var mysqlTable=[{"UI":"5","cnName":"workbench","comment":"内存占用较大","data":"5","hint":"2","stable":"4"},{"UI":"3","cnName":"mysql-font","comment":"","data":"3","hint":"5","stable":"3"},{"UI":"5","cnName":"navicat","comment":"","data":"3","hint":"5","stable":"5"},{"UI":"5","cnName":"sqlyog","comment":"出现假死","data":"3","hint":"5","stable":"2"}]
;


function initTables(tmpId,obj){
	//#name
  
	var temp=obj[0];
	var properties=new Array();
	for(x in temp){
	   properties.push(x);
	}

	var htmls="";
	var templates=document.getElementById(tmpId).outerHTML;
	for(var i=0;i<obj.length;i++){
		var templateTemp=templates;
		for(var j=0;j<properties.length;j++){
			 var re =new RegExp("#"+properties[j]+"#","gim");
			 templateTemp=templateTemp.replace(re,obj[i][properties[j]]);
		}
		htmls+=templateTemp;
	}
	document.getElementById(tmpId).parentNode.innerHTML=htmls;

}