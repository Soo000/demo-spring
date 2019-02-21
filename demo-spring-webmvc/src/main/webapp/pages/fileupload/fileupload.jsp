<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>文件上传</title>
		<script type="text/javascript">  
		    var i = 1;  
		    var j = 1;  
		    window.onload = function() {
		    	var addButton1 = document.getElementById("btn_add1");
		    	addButton1.onclick = function() {
		    		var newFile = '<div id="div_'+i+'"><input  name="file" type="file" /><input type="button" value="删除"  onclick="del_1('+i+')"/></div>';
		    		document.getElementById("newUpload1").innerHTML += newFile;  
		            i = i + 1;  
		    	};
		    	
		    	var addButton2 = document.getElementById("btn_add2");
		        addButton2.onclick = function() {
		        	var newFile = '<div id="div_'+j+'"><input  name="file_'+j+'" type="file" /><input type="button" value="删除"  onclick="del_2('+j+')"/></div>';
					document.getElementById("newUpload2").innerHTML += newFile;  
					j = j + 1;
		        }      
		    }; 
		  
		    function del_1(o) {
		     document.getElementById("newUpload1").removeChild(document.getElementById("div_"+o));  
		    }  
		      
		    function del_2(o) {  
		         document.getElementById("newUpload2").removeChild(document.getElementById("div_"+o));  
		    }  
		  
		</script>
	</head>
	<body>
		<h1>springMVC字节流输入上传文件</h1>   
	    <form name="userForm1" action="${pageContext.request.contextPath }/FileUploadCtrl/byteStreamFileUpload.action" enctype="multipart/form-data" method="post">  
	        <div id="newUpload1">  
	            <input type="file" name="file" />  
	        </div>  
	          
	        <input type="button" id="btn_add1" value="增加一行" />  
	        <input type="submit" value="上传" />  
	    </form>
	    
	    <br>  
	    <br>  
	    
	    <hr align="left" width="60%" color="#FF0000" size="3">  
	    <br>  
	    <br>  
	    
	    <h1>springMVC包装类上传文件</h1>   
	    <form name="userForm2" action="${pageContext.request.contextPath }/FileUploadCtrl/wrapClassFileUpload.action" enctype="multipart/form-data" method="post">  
	        <div id="newUpload2">  
	            <input type="file" name="file"/>  
	        </div>  
	        <input type="button" id="btn_add2" value="增加一行" />  
	        <input type="submit" value="上传" />
	    </form>   
	</body>
</html>