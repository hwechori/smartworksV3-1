$(function() {
	
	$('a.js_start_work_service').live('click', function(e) {
		var input = $(e.target);
		var target = $('#content');
		var workId = input.parents('.js_tab_workbench_page').attr('workId');
		$.ajax({
			url : "start_work_service.sw?workId=" + workId,
			success : function(data, status, jqXHR) {
				target.html(data);
			}			
		});
		return false;
	});

	$('a.js_stop_work_service').live('click', function(e) {
		var input = $(e.target);
		var target = $('#content');
		var workId = input.parents('.js_tab_workbench_page').attr('workId');
		$.ajax({
			url : "stop_work_service.sw?workId=" + workId,
			success : function(data, status, jqXHR) {
				target.html(data);
			}			
		});
		return false;
	});

	$('a.js_start_work_editing').live('click', function(e) {
		var input = $(e.target);
		var target = $('#content');
		var workId = input.parents('.js_tab_workbench_page').attr('workId');
		$.ajax({
			url : "start_work_editing.sw?workId=" + workId,
			success : function(data, status, jqXHR) {
				target.html(data);
			}			
		});
		return false;
	});

	$('a.js_stop_work_editing').live('click', function(e) {
		var input = $(e.target);
		var target = $('#content');
		var workId = input.parents('.js_tab_workbench_page').attr('workId');
		$.ajax({
			url : "stop_work_editing.sw?workId=" + workId,
			success : function(data, status, jqXHR) {
				target.html(data);
			}			
		});
		return false;
	});
	
	$('a.js_tab_smart_builder').live('click', function(e) {
		var input = $(e.target);
		var target = $('#content');
		var url = input.attr('href');
		$.ajax({
			url : url,
			success : function(data, status, jqXHR) {
				target.html(data);
			}			
		});
		return false;
	});
	
	$('a.js_add_work_category').live('click', function(e) {
		smartPop.createWorkCategory('', '', '');
		return false;
	});
	
	$('.js_text_work_category').live('click', function(e) {
		var input = $(e.target);
		var categoryId = input.attr('categoryId');
		var categoryName = input.attr('categoryName');
		var categoryDesc = input.attr('categoryDesc');
		smartPop.createWorkCategory(categoryId, categoryName, categoryDesc);
		return false;
	});
	
	$('.js_remove_work_category').live('click', function(e) {
		var input = $(e.target);
		var categoryId = input.attr('categoryId');
		var categoryName = input.attr('categoryName');
		var paramsJson = {};
		paramsJson['categoryId'] = categoryId;
		smartPop.confirm("[" + categoryName + "]" + smartMessage.get("removeConfirmation"), 
			function(){
				$.ajax({
					url : "remove_category.sw",
					contentType : 'application/json',
					type : 'POST',
					data : JSON.stringify(paramsJson),
					success : function(data, status, jqXHR) {
	 					smartPop.showInfo(smartPop.INFORM, smartMessage.get('removeCategorySucceed'), function(){
							document.location.href = document.location.href;
	 						smartPop.close();
	  					});
					},
					error : function() {
	 					smartPop.showInfo(smartPop.ERROR, smartMessage.get('removeCategoryError'), function(){
	 						smartPop.close();
	  					});
					}					
				});
			},
			function(){
			});

		return false;
	});
	
	$('.js_add_work_definition').live('click', function(e) {
		var input = $(e.target);
		var parentId = input.attr('parentId');
		var parentName = input.attr('parentName');
		smartPop.createWorkDefinition(parentId, parentName, "", "", "", "", "", "");
		return false;
	});
	
	$('.js_change_work_definition').live('click', function(e) {
		var input = $(e.target);
		var workId = input.attr('workId');
		var workName = input.attr('workName');
		var workTypeName = input.attr('workTypeName');
		var workDesc = input.attr('workDesc');
		var categoryId = input.attr('categoryId');
		var groupId = input.attr('groupId');
		smartPop.createWorkDefinition("", "", workId, workName, workTypeName, workDesc, categoryId, groupId);
		return false;
	});
	
	$('.js_remove_work_definition').live('click', function(e) {
		var input = $(e.target);
		var workId = input.attr('workId');
		var workName = input.attr('workName');
		var paramsJson = {};
		paramsJson['workId'] = workId;
		smartPop.confirm("[" + workName + "]" + smartMessage.get("removeConfirmation"), 
			function(){
				$.ajax({
					url : "remove_work_definition.sw",
					contentType : 'application/json',
					type : 'POST',
					data : JSON.stringify(paramsJson),
					success : function(data, status, jqXHR) {
	 					smartPop.showInfo(smartPop.INFORM, smartMessage.get('removeWorkDefinitionSucceed'), function(){
							document.location.href = document.location.href;
	 						smartPop.close();
	  					});
					},
					error : function() {
	 					smartPop.showInfo(smartPop.ERROR, smartMessage.get('removeWorkDefinitionError'), function(){
	 						smartPop.close();
	  					});
					}					
				});
			},
			function(){
			});

		return false;
	});
	
	$('.js_select_work_category').live('change', function(e) {
		var input = $(e.target);
		var target = input.parents('.js_new_work_definition_page').find('.js_work_group_target');
		var categoryId = input.find('option:selected').attr('value');
		console.log('target=', target , 'categoryId=', categoryId);
		alert('in');
		$.ajax({
			url : "group_options_by_category.sw",
			data : {
				categoryId : categoryId
			},
			success : function(data, status, jqXHR) {
				target.html(data);
			}			
		});
		return false;
	});
	
});
