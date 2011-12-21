function getExt(fileName) {
	var pos = fileName.lastIndexOf('.');
	var ext = 'none';
	var extTypes = new Array("asf", "avi", "bmp", "doc", "exe", "gif", "hwp", "jpg", "mid", "mp3",
			"mpeg", "mpg", "pdf", "pds", "ppt", "rar", "txt", "wav", "wma", "wmv", "word", "xls", "zip");
	if (pos != -1) {
		var extTemp = fileName.substring( pos + 1, fileName.length);
		for(var i=0; i<extTypes.length; i++) {
			if(extTemp === extTypes[i])
				ext = extTemp;
		}
	}
	return ext;
}


function fileUploader(groupId, target) {
	
	var template = '<div class="qq-uploader js_form_file_field">' + 
    '<div class="qq-upload-drop-area"><span>' + language.message("uploadDropArea") + '</span></div>' +
    '<div class="qq-upload-button">' + language.message("uploadFile") + '</div>' +
    '<ul class="qq-upload-list"></ul>' + 
    '</div>';

	var uploadFileTemplate = '<li>' +
	'<span></span>' +
	'<a href="#" class="qq-upload-file"></a>' +
	'<span class="qq-upload-spinner"></span>' +
	'<span class="qq-upload-size"></span>' +
	'<a class="qq-upload-cancel" href="#">' + language.message("cancelUpload") + '</a>' +
	'<span class="qq-upload-failed-text">' + language.message("uploadFailed") + '</span>' +
	'<a href="#" class="qq-delete-text" style="display:none">X</a>' +
	'</li>';

	return new qq.FileUploader({
        element: $(target)[0],

        params: {
        	groupId : groupId
        },
        sizeLimit: 67108864,
        messages: {
            typeError: language.message('uploadTypeError'),
            sizeError: language.message('uploadSizeError'),
            minSizeError: language.message('uploadMinSizeError'),
            emptyError: language.message('uploadEmptyError'),
            onLeave: language.message('uploadOnLeave')            
        },
        action: 'upload_temp_file.sw',
        onSubmit: function(id, fileName) {
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
	    			if(fileName === name) 
	    				return false;
        		}
        	}
        	return true;
        },
        onComplete : function(id, fileName, responseJSON){
        	var file = $(this.element).find('.qq-upload-list li[qqFileId=' + id + ']');
        	if(isZeroLength(file)) return;
        	
        	file.attr('fileId', responseJSON.fileId).attr('fileName', fileName).attr('fileSize', responseJSON.fileSize);
        	var ext = getExt(fileName);
    		file.find('.qq-upload-file').prev('span').addClass('ico_file_' + ext);
        	file.find('.qq-upload-file').attr('href', 'download_file.sw?fileId=' + responseJSON.fileId + "&fileName=" + fileName);
        	file.find('.qq-delete-text').show();
        	if(file.hasClass('qq-upload-success') && $('form.js_validation_required').find('.sw_required').hasClass('sw_error')){
        		$('form.js_validation_required').find('.sw_required').removeClass('sw_error');
				$('form.js_validation_required').validate({ showErrors: showErrors}).form();
        	}
        	if(file.hasClass('qq-upload-success')){
	        	var target = file.parents('div.js_file_uploader:first').prev('img.js_auto_picture');
	        	target.attr("src", responseJSON.pullPathName);
        	}
        },
        fileTemplate : uploadFileTemplate,
        template : template,
        debug: true
    });
}

function createUploader(groupId, target, isMultiple, isProfile, isTempFile, fileList){
	var uploadFileTemplate = '<li>' +
	'<span></span>' +
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
	} else if(isTempFile==="true") {
		fileUploader(groupId, target);
		var uploader = $(target).find('.qq-uploader');
		uploader.attr('isMultiple', isMultiple).attr('groupId', groupId);
		if(isProfile) uploader.find('.qq-upload-list').hide();
		if(!isZeroLength(fileList)) $(fileList).appennTo(uploader.fild('.qq-upload-list'));
	} else if(!isProfile){
		$.ajax({				
			url : "find_file_group.sw",
			data : {
				groupId : groupId
			},
			type : "GET",
			context : this,
			success : function(data, status, jqXHR) {
				console.log(data);
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
					
					var ext = getExt(fileName);

					var file = $(uploadFileTemplate).appendTo(files);
					file.attr('fileId', data[i].id).attr('fileName', fileName).attr('fileSize', data[i].fileSize);
					file.find('.qq-upload-file').prev('span').addClass('ico_file_' + ext);
					file.find('.qq-upload-file').text(displayFileName);
		        	file.find('.qq-upload-file').attr('href', 'download_file.sw?fileId=' + data[i].id + "&fileName=" + fileName);
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
	'<span></span>' +
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
					
					var ext = getExt(fileName);
					
					var file = $(viewFileTemplate).appendTo(files);
					file.attr('fileId', data[i].id);
					file.find('.qq-upload-file').prev('span').addClass('ico_file_' + ext);
					file.find('.qq-upload-file').text(displayFileName);
		        	file.find('.qq-upload-file').attr('fileName', fileName).attr('href', 'download_file.sw?fileId=' + data[i].id + "&fileName=" + fileName);
					file.find('.qq-upload-size').text(getBytesWithUnit(data[i].fileSize));
				}
			},
			error : function(e) {
				alert(e);
			}
		});
	}

}