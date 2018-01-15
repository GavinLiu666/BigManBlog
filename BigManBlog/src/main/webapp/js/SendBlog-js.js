;
window.onload=function(){
	
	
	/*********获取项目名*****************/
	var base = location.pathname;
	
	base = base.slice(0,base.indexOf('/',1));

	/************************************************************/
	/*var btmSendBlog = document.getElementById("sendBlog");
	btmSendBlog.onclick=function (){
		var frame = document.getElementsByClassName('cke_wysiwyg_frame')[0];

		var body = frame.contentWindow.document;
		var xmlhttp;
		if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
		  }
		else{// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		xmlhttp.onreadystatechange=function(){
		  if (xmlhttp.readyState==4 && xmlhttp.status==200){
//		    document.getElementById("myDiv").innerHTML=xmlhttp.responseText;  //返回值
			  location.reload();
		    }
		  }
		xmlhttp.open("POST",base+"/blog//sendMicroBlog.do",true);
		xmlhttp.setRequestHeader("Context-Type", "application/x-www-form-urlencoded");
		xmlhttp.send(body);
	}*/
	/************************************************************/
	var btmSendMicroBlog = document.getElementById("sendMicroBlog");
	btmSendMicroBlog.onclick=function (){
		var microText = document.getElementById('microBlog');
		console.log(microText);
		var xmlhttp;
		if (window.XMLHttpRequest){
			xmlhttp=new XMLHttpRequest();
		}
		else{
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.open("POST",base+"/blog/sendMicroBlog.do",true);
		xmlhttp.send(microText.textContent);
		
		xmlhttp.onreadystatechange=function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200){
				location.reload();
			}
		}
	}
	/********------------------------------------------*************************/
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}