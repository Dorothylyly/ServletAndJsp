//数量加减
var newNum
function operationType(obj){
	var num = document.getElementById("num").value;
	var numText = document.getElementById("num");
	var type = obj.value;
	var math = /^[0-9]*$/;
	
	if(type == "+"){
		newNum = parseInt(num) + 1;
		numText.value = newNum;
		document.getElementById("subNum").disabled = "";
	}
	
	if(type == "-"){
		if(num <= 1){
			document.getElementById("subNum").disabled = "disabled";
		}else if(num > 1){
			newNum = parseInt(num) - 1;
			numText.value = newNum;
			document.getElementById("addNum").disabled = "";
		}
	}
	
	if(num < 1){
		numText.value = 1;
	}
	
	if(!math.test(num)){
		numText.value = 1;
	}
}

//全选
function selectAll(){
	var ck = document.getElementsByName("produce");
	var ac2 = document.getElementById("action2");
	for(var i=0; i<ck.length; i++){
		if(ck[i].type = "checkbox"){
			ck[i].checked = document.getElementById("action").checked;
		}
	}
	ac2.checked = document.getElementById("action").checked;
}

//全选
function selectAll2(){
	var ck = document.getElementsByName("produce");
	var ac = document.getElementById("action");
	for(var i=0; i<ck.length; i++){
		if(ck[i].type = "checkbox"){
			ck[i].checked = document.getElementById("action2").checked;
		}
	}
	ac.checked = document.getElementById("action2").checked;;
}