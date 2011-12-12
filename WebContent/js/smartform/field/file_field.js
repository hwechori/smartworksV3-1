SmartWorks.FormRuntime = SmartWorks.FormRuntime || {};

SmartWorks.FormRuntime.FileFieldBuilder = {};

SmartWorks.FormRuntime.FileFieldBuilder.build = function(config) {
	var options = {
		mode : 'view', // view or edit
		container : $('<div></div>'),
		entity : null,
		value : 'fg_f8da7a2ad8df438bb7d79da3f3ba2499'
	};

	SmartWorks.extend(options, config);

	var $entity = options.entity;
	var $graphic = $entity.children('graphic');

	var readOnly = $graphic.attr('readOnly') === 'true' || options.mode === 'view';
	var id = $entity.attr('id');
	var name = $entity.attr('name');
	
	var $label = $('<label>' + name + '</label>');
	$label.appendTo(options.container);
	
	var $file = null;
		
	$file = $('<span id="' + id + '"></span>');
	$file.appendTo(options.container);

	createUploader(options.value, id, readOnly);
	
//	if(true){
//		console.log($(options.container).find('div.qq-upload-button'));
//		$(options.container).find('div.qq-upload-button').hide();
//	}
	return options.container;
};

var fileTemplate = '<li>' +
'<span class="qq-upload-file"></span>' +
'<span class="qq-upload-spinner"></span>' +
'<span class="qq-upload-size"></span>' +
'<a class="qq-upload-cancel" href="#">Cancel</a>' +
'<span class="qq-upload-failed-text">Failed</span>' +
'<span class="qq-delete-text" style="display:none">X</span>' +
'</li>';

function fileUploader(groupId, targetId) {
	return new qq.FileUploader({
        element: $('#'+ targetId)[0],

        params : {
        	groupId : groupId
        },
        action: 'ajax_upload_file.sw',
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

function createUploader(groupId, targetId, readOnly){
	if(!groupId) {
		groupId = '<%=IDCreator.createId(SmartServerConstant.DOCUMENT_GROUP_ABBR)%>';
	} else {
		$.ajax({				
			url : "find_file_group.sw",
			data : {
				groupId : groupId
			},
			type : "GET",
			context : this,
			success : function(data, status, jqXHR) {
				var uploader = fileUploader(groupId, targetId);
				// var uploader_div = $(uploader.element);
				var uploader_div = $('#'+targetId);
				
				if (readOnly)
					$('div.qq-upload-button').hide();
				
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
			error : function(e) {
				alert(e);
			}
		});
	}
}






