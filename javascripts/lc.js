var indexConfig=[{"name":"aa","cnName":"dd"},{"name":"bb","cnName":"ee"}];


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