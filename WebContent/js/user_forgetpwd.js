// JavaScript Document

var code ;											//在全局定义验证码												
var codes;											//转化成大写的验证

var get = function(id){                             //get是变量名，把此方法赋值给get
	return document.getElementById(id);             //返回获取的ID参数
}

//为字符串增加trim方法，使用正则表达式截取空格
String.prototype.trim = function(){                         
	return this.replace(/^\s*/,"").replace(/\s*$/,"");		
}

//验证码的函数
function createCode(){ 
	code = new Array();
	var codeLength = 4;										//验证码的长度
	var checkCode = get("checkCode");
	checkCode.value = "";
	var selectChar = new Array(2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');
	for(var i=0; i<codeLength; i++){   
		var charIndex = Math.floor(Math.random()*58);   
		code += selectChar[charIndex];
	}
	if(code.length != codeLength){   
		createCode();
	}
	checkCode.value = code;
	codes = code.toUpperCase(); 							//将验证码转化成大写
}

//负责处理用户名表单submit事件的函数
function checkUserName(){
	var userName = document.userNameForm.userName.value; 	//获取用户名的值
	var exreg = /^.{3,16}$/;								//用户名正则表达式
	var inputCode = get("code").value.toUpperCase();		//将输入的验证码转换成大写。		
	
	//判断用户名
//	if(userName == null || userName.trim() == ""){			
//		get("userName_msg").innerHTML = '请输入用户名。';
//		return false;										
//	}else if(!exreg.test(userName)){
//		get("userName_msg").innerHTML = '您输入的账户名不存在，请核对后重新输入。';
//		return false;
//	}else{													
//		get("userName_msg").innerHTML = "";
//	}
	
	//判断密码
	if(inputCode.length <= 0){ 								
		get("UserName_Codemsg").innerHTML = '<font color="red" size="2px">请输入验证码</font>';  
		return false;
	}else if(inputCode != codes){ 							
		get("UserName_Codemsg").innerHTML = '<font color="red" size="2px">您输入验证码有误，请重新输入。</font>';      
		createCode();  
		return false;
	}else{													
		get("UserName_Codemsg").innerHTML = "";
	}
	return true;
}

//负责处理邮箱表单submit事件的函数
//function checkEail(){
//	var Email = document.EmailForm.mail.value; 				//获取邮箱的值
//	var exreg = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;	//邮箱验证
//	var inputCode = get("code").value.toUpperCase();		//将输入的验证码转换成大写。		
//	
//	//判断用户名
//	if(Email == null || Email.trim() == ""){			
//		get("Email_msg").innerHTML = '请输入邮箱。';
//		return false;										
//	}else if(!exreg.test(Email)){
//		get("Email_msg").innerHTML = '邮箱格式错误，请输入您正确的邮箱。';
//		return false;
//	}else{													
//		get("Email_msg").innerHTML = "";
//	}
//	
//	//判断密码
//	if(inputCode.length <= 0){ 								
//		get("Email_Codemsg").innerHTML = '<font color="red" size="2px">请输入验证码</font>';  
//		return false;
//	}else if(inputCode != codes){ 							
//		get("Email_Codemsg").innerHTML = '<font color="red" size="2px">您输入验证码有误，请重新输入。</font>';      
//		createCode();  
//		return false;
//	}else{													
//		get("Email_Codemsg").innerHTML = "";
//	}
//	return true;
//}

//负责处理密码表单submit事件的函数
function checkPwd(){
	var Pwd = document.PwdForm.pwd.value; 					//获取密码的值
	var Pwd2 = document.PwdForm.repwd.value;				//获取确认密码值
	var exreg = /^[\x21-\x7E]{6,20}$/;						//密码正则表达式。		
	
	//判断用户名
	if(Pwd == null || Pwd.trim() == ""){			
		get("Pwd_msg").innerHTML = '请输入密码。';
		return false;										
	}else if(!exreg.test(Pwd)){
		get("Pwd_msg").innerHTML = '6-20个字符，建议由数字和符合两种以上组合。';
		return false;
	}else{													
		get("Pwd_msg").innerHTML = "";
	}
	
	//判断确认密码
	if(Pwd2 == null || Pwd2.trim() == ""){          
		get("rePwd_msg").innerHTML = '请再次输入密码。';     
		return false;
	}else if(Pwd != Pwd2 || Pwd2 == ""){
		get("rePwd_msg").innerHTML = '您输入的两次密码不一致，请再次确认。';       
		return false;
	}else{
		get("rePwd_msg").innerHTML = "";
	}
	//get("line").style.background = "#C00";
	return true;
}

//自动跳转到登陆
function jump(){
	var num = parseInt(document.getElementById("time").innerHTML);
	num--;
	if(num > 0){
		document.getElementById("time").innerHTML = num;
	}
	window.setTimeout("jump()",1000);
}