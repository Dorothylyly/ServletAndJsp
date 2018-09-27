// JavaScript Document
//首页js

function showmenu(id){
	for(var i=1; i<=9; i++){
		document.getElementById("menu"+i).style.display = "none";
	}
	document.getElementById("menu"+id).style.display = "block";
}

