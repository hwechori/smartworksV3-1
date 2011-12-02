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
<script type="text/javascript" src="../js/sw/sw-all.js"></script>
<script type="text/javascript" src="../js/sw/sw-nav.js"></script>
<script src="../js/jquery/fileuploader/fileuploader.js" type="text/javascript"></script>
<script>
	var fileTemplate = '<li>' +
    '<span class="qq-upload-file"></span>' +
    '<span class="qq-upload-spinner"></span>' +
    '<span class="qq-upload-size"></span>' +
    '<a class="qq-upload-cancel" href="#">Cancel</a>' +
    '<span class="qq-upload-failed-text">Failed</span>' +
    '<span class="qq-delete-text" style="display:none">X</span>' +
	'</li>';
	
	function fileUploader(groupId) {
		return new qq.FileUploader({
	        element: $('#file-uploader-demo1')[0],
	
	        params : {
	        	groupId : groupId
	        },
	        action: '../ajax_upload_file.sw',
	        onSubmit : function(id, fileName) {
	        	var files = $(this.element).find('.qq-upload-list li');
	        	for(var i = 0;i < files.length;i++) {
	        		var file = $(files[i]);
	        		var name = file.find('.qq-upload-file').text();
	        		if(fileName === name) {
	        			return false;
	        		}
	        	}
	        	return true;
	        },
	        onComplete : function(id, fileName, responseJSON){
	        	var files = $(this.element).find('.qq-upload-list li');
	        	for(var i = 0;i < files.length;i++) {
	        		var file = $(files[i]);
	        		file.attr('fileId', responseJSON.fileId);
	        		var name = file.find('.qq-upload-file').text();
	        		if(fileName === name) {
	        			var del = file.find('.qq-delete-text');
	        			del.show();
	        			return;
	        		}
	        	}
	        },
	        fileTemplate : fileTemplate, 
	        debug: true
	    });
	}
	
	function createUploader(groupId){
		if(!groupId) {
			groupId = '<%=IDCreator.createId(SmartServerConstant.DOCUMENT_GROUP_ABBR)%>';
		} else {
			$.ajax({				
				url : "../find_file_group.sw",
				data : {
					groupId : groupId
				},
				type : "GET",
				context : this,
				success : function(data, status, jqXHR) {
					var uploader = fileUploader(groupId);
					// var uploader_div = $(uploader.element);
					var uploader_div = $('#file-uploader-demo1');
					var files = uploader_div.find('.qq-upload-list');
					for(var i in data) {
						var file = $(fileTemplate).appendTo(files);
						file.attr('fileId', data[i].id);
						file.find('.qq-upload-file').text(data[i].fileName);
						file.find('.qq-upload-size').text(data[i].fileSize);
						file.find('.qq-upload-cancel').remove();
						file.find('.qq-upload-spinner').remove();
						file.find('.qq-delete-text').show();
					}
				},
				failure : function(e) {
					alert(e);
				}
			});
		}
	}
// in your app create uploader as soon as the DOM is ready
// don't wait for the window to load  
	window.onload = function(){
		createUploader('fg_fe6e2de9854c46b2ac6536b378156354');
	};
</script>
</form>
</body>
</html>