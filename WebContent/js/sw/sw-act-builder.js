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

	$('.js_up_field_item').live('click', function(e) {
		var input = $(e.target);
		var selectedItem = input.parents('tr:first');
		var prevs = selectedItem.prevAll('tr').length;
		var nexts = selectedItem.nextAll('tr').length;
		if(prevs>2){
			var prevItem = selectedItem.prev('tr');
			selectedItem.insertBefore(prevItem);
			if(prevs==3){
				prevItem.find('.js_up_field_item').show();
				selectedItem.find('.js_up_field_item').hide();
			}
			if(nexts==0){
				prevItem.find('.js_down_field_item').hide();
				selectedItem.find('.js_down_field_item').show();				
			}
		}
		var displayItemList = selectedItem.parents('.js_tab_work_settings_page').find('.js_display_field_list');
		var itemList = displayItemList.find('th');
		$(itemList[prevs-2]).insertBefore($(itemList[prevs-3]));
		return false;
	});

	$('.js_down_field_item').live('click', function(e) {
		var input = $(e.target);
		var selectedItem = input.parents('tr:first');
		var prevs = selectedItem.prevAll('tr').length;
		var nexts = selectedItem.nextAll('tr').length;
		if(nexts>0){
			var nextItem = selectedItem.next('tr');
			selectedItem.insertAfter(nextItem);
			if(prevs==2){
				nextItem.find('.js_up_field_item').hide();
				selectedItem.find('.js_up_field_item').show();
			}
			if(nexts==1){
				nextItem.find('.js_down_field_item').show();
				selectedItem.find('.js_down_field_item').hide();				
			}
		}
		var displayItemList = selectedItem.parents('.js_tab_work_settings_page').find('.js_display_field_list');
		var itemList = displayItemList.find('th');
		$(itemList[prevs-2]).insertAfter($(itemList[prevs-1]));
		return false;
	});

	$('.js_hide_field_item').live('click', function(e) {
		
		var input = $(e.target);
		var selectedItem = input.parents('tr:first');
		var prevs = selectedItem.prevAll('tr').length;
		var nexts = selectedItem.nextAll('tr').length;
		var displayItemList = selectedItem.parents('.js_tab_work_settings_page').find('.js_display_field_list');
		var hiddenFieldItems = selectedItem.parents('.js_tab_work_settings_page').find('.js_hidden_field_items');
		var displayFieldItems = selectedItem.parents('.js_display_field_items');
		if(prevs==2) selectedItem.next().find('.js_up_field_item').hide();
		if(nexts==0) selectedItem.prev().find('.js_down_field_item').hide();
		selectedItem.remove();
		if(selectedItem.find('.js_key_field').hasClass('checked')){
			var newKeyField = $(displayFieldItems.find('tr')[2]).find('.js_key_field').addClass('checked');
			newKeyField.parents('.key_option').addClass('checked');
			displayFieldItems.find('input[name="rdoKeyField"]').attr('value', newKeyField.attr('fieldId'));
		}
		var itemList = displayItemList.find('th');
		$(itemList[prevs-2]).remove();

		var formField = selectedItem.find('input[name="hdnDisplayFields"]');
		var fieldId = formField.attr('value');
		var fieldName = formField.attr('fieldName');
		var hiddenItem = $(hiddenFieldItems.find('tr')[1]).clone().show();
		hiddenItem.attr('fieldId', fieldId);
		hiddenItem.find('td:last').html(fieldName);
		hiddenItem.appendTo(hiddenFieldItems);
		return false;
	});

	$('.js_show_field_item').live('click', function(e) {

		var input = $(e.target);
		var selectedItem = input.parents('tr:first');
		var displayItemList = selectedItem.parents('.js_tab_work_settings_page').find('.js_display_field_list');
		var displayFieldItems = selectedItem.parents('.js_tab_work_settings_page').find('.js_display_field_items');
		selectedItem.remove();
		var fieldId = selectedItem.attr('fieldId');
		var fieldName = selectedItem.find('td:last').html();
		var displayItem = $(displayFieldItems.find('tr')[1]).clone().show();
		displayItem.find('.js_key_field').attr('fieldId', fieldId);
		displayItem.find('.js_input_display_field').html('<input name="hdnDisplayFields" type="hidden" value="' + fieldId + '" fieldName="' + fieldName + '"/>' + fieldName);
		displayItem.appendTo(displayFieldItems);

		var displayItems = displayFieldItems.find('tr').length;
		if(displayItems==3){
			var newKeyField = displayItem.find('.js_key_field').addClass('checked');
			newKeyField.parents('.key_option').addClass('checked');
			displayFieldItems.find('input[name="rdoKeyField"]').attr('value', newKeyField.attr('fieldId'));		
			displayItem.find('.js_up_field_item').hide();
		}else if(displayItems>3){
			displayItem.prev().find('.js_down_field_item').show();
		}
		var itemList = displayItemList.find('th');
		$(itemList[itemList.length-1]).clone().html(fieldName).show().insertBefore($(itemList[itemList.length-2]));
		
		return false;
	});
	
	$('a .js_key_field').live('click', function(e){
		var input = $(e.target);
		if(input.hasClass('checked')) return false;
		input.addClass('checked').parents('.key_option').addClass('checked');
		input.parents('tr:first').siblings().find('.key_option').removeClass('checked').find('.js_key_field').removeClass('checked');
		input.parents('.js_tab_work_settings_page').find('input[name="rdoKeyField"]').attr('value', input.attr('fieldId'));
		return false;
	});
});
