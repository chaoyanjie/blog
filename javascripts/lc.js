var indexConfig=[{"cnName":"json 美化工具","ding":"100","url":"jsonFormatUtil.html"}];
var ynConfig=[{"cnName":"kindeditor 与 easyUI结合扩展上传图片 按钮 ","ding":"1","url":"easyUiKinderEditor.html"}];

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