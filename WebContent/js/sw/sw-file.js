
function fileUploader(groupId, target) {
	
	var template = '<div class="qq-uploader js_form_file_field">' + 
    '<div class="qq-upload-drop-area"><span>' + language.message("uploadDropArea") + '</span></div>' +
    '<div class="qq-upload-button">' + language.message("uploadFile") + '</div>' +
    '<ul class="qq-upload-list"></ul>' + 
    '</div>';

	var uploadFileTemplate = '<li>' +
	'<a href="#" class="qq-upload-file"></a>' +
	'<span class="qq-upload-spinner"></span>' +
	'<span class="qq-upload-size"></span>' +
	'<a class="qq-upload-cancel" href="#">' + language.message("cancelUpload") + '</a>' +
	'<span class="qq-upload-failed-text">' + language.message("uploadFailed") + '</span>' +
	'<a href="#" class="qq-delete-text" style="display:none">X</a>' +
	'</li>';
	
	return new qq.FileUploader({
        element: $(target)[0],

        params : {
        	groupId : groupId
        },
        action: 'upload_temp_file.sw',
        onSubmit : function(id, fileName) {
        	var uploader = $(this.element).find('.qq-uploader');
        	var isMultiple = uploader.attr('isMultiple');
        	var files = $(this.element).find('.qq-upload-list li');
        	for(var i = 0;i < files.length;i++) {
    			var file = $(files[i]);
                if(isMultiple!=='true'){
                	file.remove();
                	// need to code for removing temp file request to server 
                	// need to code for removing temp file request to server 
                	// need to code for removing temp file request to server 
                	// need to code for removing temp file request to server 
        		}else{
	    			var name = file.find('.qq-upload-file').attr('fileName');
	    			if(fileName === name) {
	    				return false;
	    			}
        		}
        	}
        	return true;
        },
        onComplete : function(id, fileName, responseJSON){
        	var file = $(this.element).find('.qq-upload-list li[qqFileId=' + id + ']');
        	file.attr('fileId', responseJSON.fileId);
        	file.attr('fileName', fileName);
        	
    		var pos = fileName.lastIndexOf('.');
    		var ext = '';
    		if (pos != -1)
    			ext = fileName.substring( pos + 1, fileName.length);

        	file.find('.qq-upload-file').attr('href', 'download_file.sw?fileId=' + responseJSON.fileId + "&fileName=" + fileName).addClass('js_file_type_'+ ext );
        	file.find('.qq-delete-text').show();
        	if(file.hasClass('.qq-upload-success') && file.parents('.sw_required').hasClass('sw_error')){
        		file.parents('.sw_required').removeClass('sw_error');
				$('form.js_validation_required').validate({ showErrors: showErrors}).form();
        	}
        	var target = file.parents('div.js_file_uploader:first').prev().find('img.js_auto_picture');
        	target.attr("src", responseJSON.pullPathName);        	
        },
        fileTemplate : uploadFileTemplate,
        template : template,
        debug: true
    });
}

function createUploader(groupId, target, isMultiple, isProfile){
	var uploadFileTemplate = '<li>' +
	'<a href="#" class="qq-upload-file"></a>' +
	'<span class="qq-upload-spinner"></span>' +
	'<span class="qq-upload-size"></span>' +
	'<a class="qq-upload-cancel" href="#">' + language.message("cancelUpload") + '</a>' +
	'<span class="qq-upload-failed-text">' + language.message("uploadFailed") + '</span>' +
	'<a href="#" class="qq-delete-text" style="display:none">X</a>' +
	'</li>';
	
	if(!groupId) {
		groupId = randomUUID('fg_');
		fileUploader(groupId, target);
		var uploader = $(target).find('.qq-uploader');
		uploader.attr('isMultiple', isMultiple).attr('groupId', groupId);
		if(isProfile) uploader.find('.qq-upload-list').hide();
	} else if(!isProfile){
		$.ajax({				
			url : "find_file_group.sw",
			data : {
				groupId : groupId
			},
			type : "GET",
			context : this,
			success : function(data, status, jqXHR) {
				fileUploader(groupId, target);
				var uploader_div = $(target);
				uploader_div.find('.qq-uploader').attr('isMultiple', isMultiple).attr('isProfile', isProfile).attr('groupId', groupId);

				var files = uploader_div.find('.qq-upload-list');
				for(var i in data) {
					var fileName = data[i].fileName;
					var displayFileName = fileName;
					if (fileName.length > 33) {
						displayFileName = fileName.slice(0, 19) + '...' + fileName.slice(-13);
					}
					
					var pos = fileName.lastIndexOf('.');
		    		var ext = '';
		    		if (pos != -1)
		    			ext = fileName.substring( pos + 1, fileName.length);
					
					var file = $(uploadFileTemplate).appendTo(files);
					file.attr('fileId', data[i].id).attr('fileName', fileName);
					file.find('.qq-upload-file').text(displayFileName);
		        	file.find('.qq-upload-file').attr('href', 'download_file.sw?fileId=' + data[i].id).addClass('js_file_type_'+ ext );
					file.find('.qq-upload-size').text(data[i].fileSize);
					file.find('.qq-upload-cancel').remove();
					file.find('.qq-upload-spinner').remove();
					file.find('.qq-delete-text').show();
				}
			},
			error : function(e) {
				alert(e);
			}
		});
	}
}

function viewFiles(groupId, target){
	
	var viewFileTemplate = '<li>' +
	'<a href="#" class="qq-upload-file"></a>' +
	'<span class="qq-upload-size"></span>' +
	'</li>';
	
	if(!groupId) {
		return;
	} else {
		$.ajax({				
			url : "find_file_group.sw",
			data : {
				groupId : groupId
			},
			type : "GET",
			context : this,
			success : function(data, status, jqXHR) {
				var files = $(target);
				for(var i in data) {
					
					var fileName = data[i].fileName;
						
					var displayFileName = fileName;
					if (fileName.length > 33) {
						displayFileName = fileName.slice(0, 19) + '...' + fileName.slice(-13);
					}
					
					var pos = fileName.lastIndexOf('.');
		    		var ext = '';
		    		if (pos != -1)
		    			ext = fileName.substring( pos + 1, fileName.length);
					
					var file = $(viewFileTemplate).appendTo(files);
					file.attr('fileId', data[i].id);
					file.find('.qq-upload-file').text(displayFileName);
		        	file.find('.qq-upload-file').attr('fileName', fileName).attr('href', 'download_file.sw?fileId=' + data[i].id).addClass('js_file_type_'+ ext );
					file.find('.qq-upload-size').text(getBytesWithUnit(data[i].fileSize));
				}
			},
			error : function(e) {
				alert(e);
			}
		});
	}
}
