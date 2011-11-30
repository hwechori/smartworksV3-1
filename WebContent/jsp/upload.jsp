<%@page import="net.smartworks.server.engine.common.model.SmartServerConstant"%>
<%@page import="net.smartworks.server.engine.common.util.id.IDCreator"%>
<%@page import="net.smartworks.server.engine.docfile.manager.IDocFileManager"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%
	User cUser = SmartUtil.getCurrentUser(request, response);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="uplaodForm" action="../upload_file.sw" method="post" enctype="multipart/form-data">
<div id="file">
<input type="hidden" name="userId" value="<%=cUser.getId()%>">
<input name="upload" type="file" size="30"><p>
<input type="submit" value="UPLOAD">
</div>
</form>

</body>
</html> --%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link href="../css/fileuploader/fileuploader.css" rel="stylesheet" type="text/css">	
    <style>    	
		body {font-size:13px; font-family:arial, sans-serif; width:700px; margin:100px auto;}
    </style>	
</head>
<body>
<form name="uploadForm">
<input type="hidden" id="groupId" name="groupId" value="<%=IDCreator.createId(SmartServerConstant.DOCUMENT_GROUP_ABBR)%>">
    <p><a href="http://github.com/valums/file-uploader">Back to project page</a></p>
    <p>This is Smartworks.net File Uploader!!</p>
	<p>To upload a file, click on the button below. Drag-and-drop is supported in FF, Chrome.</p>
	<p>Progress-bar is supported in FF3.6+, Chrome6+, Safari4+</p>
	
	<div id="file-uploader-demo1">		
		<noscript>			
			<p>Please enable JavaScript to use file uploader.</p>
			<!-- or put a simple form for upload here -->
		</noscript>
	</div>

<script type="text/javascript" src="../js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery/jquery.ui.core.js"></script>
<script src="../js/jquery/fileuploader/fileuploader.js" type="text/javascript"></script>
<script>
	function createUploader(){            
	    var uploader = new qq.FileUploader({
	        element: $('#file-uploader-demo1')[0],
	        params : {
	        	groupId : $('#groupId').val()
	        },
	        action: '../ajax_upload_file.sw',
	        onSubmit : function(id, fileName) {
	        },
	        onComplete : function(id, fileName, responseJSON){
	        },
	        debug: true
	    });           
	}
// in your app create uploader as soon as the DOM is ready
// don't wait for the window to load  
	window.onload = createUploader;
</script>
</form>
</body>
</html>