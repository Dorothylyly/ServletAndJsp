// JavaScript Document

var windowTag;	//窗口标记

//页面加载完毕后执行
window.onload = function () {
	var objDemo = document.getElementById("demo");
	var objSmallBox = document.getElementById("small-box");
	var objMark = document.getElementById("mark");
	var objFloatBox = document.getElementById("float-box");
	var objBigBox = document.getElementById("big-box");
	var objBigBoxImage = objBigBox.getElementsByTagName("img")[0];

	objMark.onmouseover = function () {
		objFloatBox.style.display = "block"
		objBigBox.style.display = "block"
	}

	objMark.onmouseout = function () {
		objFloatBox.style.display = "none"
		objBigBox.style.display = "none"
	}

	objMark.onmousemove = function (ev) {
		var _event = ev || window.event;  //兼容多个浏览器的event参数模式
		var left = _event.clientX - objDemo.offsetLeft - objSmallBox.offsetLeft - objFloatBox.offsetWidth / 2;
		//alert("鼠标X坐标：" +_event.clientX + "、Demo：" + objDemo.offsetLeft + "、SmallBox:" + objSmallBox.offsetLeft + "、放大镜的宽度" + objFloatBox.offsetWidth/2);
		var top = _event.clientY - objDemo.offsetTop - objSmallBox.offsetTop - objFloatBox.offsetHeight / 2;
		//alert("left:" + left + "，top" + top);
		
		if (left < 0) {
			left = 0;
		} else if (left > (objMark.offsetWidth - objFloatBox.offsetWidth)) {
			left = objMark.offsetWidth - objFloatBox.offsetWidth;
		}

		if (top < 0) {
			top = 0;
		} else if (top > (objMark.offsetHeight - objFloatBox.offsetHeight)) {
			top = objMark.offsetHeight - objFloatBox.offsetHeight;
		}

		objFloatBox.style.left = left + "px";   //oSmall.offsetLeft的值是相对什么而言
		objFloatBox.style.top = top + "px";
		
		var percentX = left / (objMark.offsetWidth - objFloatBox.offsetWidth);
		var percentY = top / (objMark.offsetHeight - objFloatBox.offsetHeight);
	
		//alert("Mark可视宽度：" + objMark.offsetWidth + "、放大镜的可视宽度：" + objFloatBox.offsetWidth);
		//alert("percentX:" + percentX + "，percentY:" + percentY);

		objBigBoxImage.style.left = -percentX * (objBigBoxImage.offsetWidth - objBigBox.offsetWidth) + "px";
		objBigBoxImage.style.top = -percentY * (objBigBoxImage.offsetHeight - objBigBox.offsetHeight) + "px";
		//alert("图片的可是宽度：" + objBigBoxImage.offsetWidth + "，大图容器的可视宽度：" + objBigBox.offsetWidth);
		//alert(objBigBoxImage.style.left);
	}
	
	var oBtn = document.getElementById("buy");
	var errMsg = document.getElementById("errmsg").innerText;
	var buyW = document.getElementById("buyWindow");
	var login = document.getElementById("login");
	var loginState = document.getElementById("loginState").value;
	var errMsgText = document.getElementById("errmsg2").innerText;
	var errMsgID = document.getElementById("errmsg2");
	var sBtn = document.getElementById("goodcar");
	
	//点击购物车按钮
	sBtn.onclick = function(){
		if(loginState == 0){			
			login.style.display = "block"
			windowTag = 1;
			openNew();
			return false;
		}
	}
	
	//点击确定购买按钮
	oBtn.onclick = function(){
		if(loginState == 0){			
			login.style.display = "block"
			windowTag = 1;
			openNew();
			return ;
		}else{
			buyW.style.display = "block";
			windowTag = 2;
			openNew();
			return;
		}		
	}
	
	//如果有错误提示的话，就显示登录窗口
	if(errMsgText != null && errMsgText != ""){
		login.style.display = "block";
		errMsgID.style.display = "block";
		windowTag = 1;
		openNew();
		return;
	}
	
	//如果有错误提示的话，就显示支付窗口
	if(errMsg != null && errMsg != ""){
		buyW.style.display = "block";
		windowTag = 2;
		openNew();
		return;
	}
}

//数量加减
var newNum
function operationType(obj){
	var num = document.getElementById("num").value;
	var repertory = parseInt(document.getElementById("repertory").innerHTML);
	var numText = document.getElementById("num");
	var math = /^[0-9]*$/;
	var type = obj.value;
	
	if(num > repertory){
		document.getElementById("buy").className = "submit_buy_2";
		document.getElementById("goodcar").className = "submit_goodcar_2";
		document.getElementById("buy").disabled = "disabled";
		document.getElementById("goodcar").disabled = "disabled";
	}
	
	if(num <= repertory){
		document.getElementById("buy").disabled = "";
		document.getElementById("goodcar").disabled = "";
		document.getElementById("buy").className = "submit_buy";
		document.getElementById("goodcar").className = "submit_goodcar";
		document.getElementById("addNum").disabled = "";
	}
	
	if(type == "+"){
		if(num >= repertory){
			document.getElementById("addNum").disabled = "disabled";
			document.getElementById("subNum").disabled = "";
		}else{
			newNum = parseInt(num) + 1;
			numText.value = newNum;
			document.getElementById("subNum").disabled = "";
		}
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
		document.getElementById("subNum").disabled = "";
	}
	
	if(!math.test(num)){
		numText.value = 1;
		document.getElementById("subNum").disabled = "";
	}
}

//淡白色屏保
function openNew(){
	//获取页面的高度和宽度
	var sWidth = document.body.scrollWidth;
	var sHeight = document.body.scrollHeight;
	
	var oMask = document.createElement("div");	//createElement创建一个元素
		oMask.id = "mask_buy";
		oMask.style.height = sHeight + "px";
		oMask.style.width = sWidth + "px";
		document.body.appendChild(oMask);		//添加节点方法
	
	//点击关闭按钮
	var oClose = document.getElementById("closeLogin");
	var oClose2 = document.getElementById("closeBuy");
	var buyW = document.getElementById("buyWindow");
	var login = document.getElementById("login");
		//点击登陆框以外的区域也可以关闭登陆框
	oClose.onclick = oClose2.onclick = oMask.onclick = function(){
			if(windowTag == 1){
				login.style.display = "none";
				document.body.removeChild(oMask);	//移除子节点
			}else{
				buyW.style.display = "none";
				document.body.removeChild(oMask);	//移除子节点
			}
		}
}