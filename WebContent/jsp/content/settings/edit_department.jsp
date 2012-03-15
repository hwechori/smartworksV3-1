<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.model.community.Department"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	
	String departId = request.getParameter("departId");
	String parentId = request.getParameter("parentId");
	Department department = (SmartUtil.isBlankObject(departId)) ? new Department() : smartWorks.getDepartmentById(departId);
	if(SmartUtil.isBlankObject(parentId) && !SmartUtil.isBlankObject(department.getParent())) parentId = department.getParent().getId();	
	Department parentDepart = (SmartUtil.isBlankObject(parentId)) ? new Department() : smartWorks.getDepartmentById(parentId);
%>
<script type="text/javascript">

	// 근무시간정책을 수정하기 버튼을 클릭하면, 
	// 모든정보를 JSON형식으로 Serialize해서 서버의 set_work_hour_policy.sw 서비스를 호출하여 수정한다.
	function submitForms(e) {
		var editDepartment = $('.js_edit_department_page');
		if (SmartWorks.GridLayout.validate(editDepartment.find('form.js_validation_required'), editDepartment.find('.js_profile_error_message'))) {
			var forms = editDepartment.find('form');
			var paramsJson = {};
			paramsJson['departmentId'] = editDepartment.attr('departId');
			for(var i=0; i<forms.length; i++){
				var form = $(forms[i]);
				if(form.attr('name') === 'frmSmartForm'){
					paramsJson['formId'] = form.attr('formId');
					paramsJson['formName'] = form.attr('formName');
				}
				paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
			}
			console.log(JSON.stringify(paramsJson));
			
			var url = "set_department.sw";
			var departId = editDepartment.attr('departId'); 
			var confirmMessage = smartMessage.get("saveConfirmation");
			if(isEmpty(departId)){
				url = "create_department.sw";
				confirmMessage = smartMessage.get("createConfirmation")
			}
			smartPop.confirm( confirmMessage, function(){
				var progressSpan = editDepartment.find('.js_progress_span');
				smartPop.progressCont(progressSpan);
				$.ajax({
					url : url,
					contentType : 'application/json',
					type : 'POST',
					data : JSON.stringify(paramsJson),
					success : function(data, status, jqXHR) {
						// 사용자정보 수정이 정상적으로 완료되었으면, 현재 페이지에 그대로 있는다.
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.INFORM, isEmpty(departId) ? smartMessage.get('createDepartmentSucceed') : smartMessage.get('setDepartmentSucceed'), function(){
							document.location.href = "organization_management.sw";					
						});
					},
					error : function(e) {
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.ERROR, isEmpty(departId) ? smartMessage.get('createDepartmentError') : smartMessage.get('setDepartmentError'));
					}
				});
			});
		}
	};

</script>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="js_edit_department_page" departId="<%=departId %>" parentId="<%=parentId%>">

	<!-- 부서추가 -->
	<!-- 타이틀 영역 -->
	<div style="display:block">
		<div class="default_title_space">
			<%
			if(SmartUtil.isBlankObject(departId)){
			%>
				<div class="title"><fmt:message key="settings.title.add_department"/></div>
			<%
			}else{
			%>
				<div class="title"><fmt:message key="settings.title.modify_department"/></div>
			<%
			}
			%>
		</div>
		<!-- 타이틀 영역 //-->
		
		<form name="frmEditDepartment" class="boTb js_validation_required">
			<table class="mt10">
				<tbody>
					<tr>
						<%
						String parentName = (SmartUtil.isBlankObject(department.getParent())) ? "" : department.getParent().getName();
						if(SmartUtil.isBlankObject(departId) && !SmartUtil.isBlankObject(parentDepart)) parentName = parentDepart.getName(); 
						%>
						<th width="20%" ><fmt:message key="settings.title.department.parent_name"/></th>
						<td width="80%">
							<input name="txtParentName" readonly type="text" value="<%=parentName %>" />
							<input name="hdnParentId" type="hidden" value="<%=CommonUtil.toNotNull(parentId) %>" />
						</td>	
					</tr>
					<tr>
						<th><fmt:message key="profile.title.department"/><span class="essen_n"></span></th>
						<td><input name="txtDepartmentName" class="fieldline required" type="text" value="<%=CommonUtil.toNotNull(department.getName()) %>" /></td>
					</tr>
				</tbody>
			</table>
		</form>
	
		<!-- Btn -->
		<div class="tr mt8">
			<!-- 실행시 데이터 유효성 검사이상시 에러메시지를 표시할 공간 -->
			<span class="form_space sw_error_message js_profile_error_message" style="text-align:right; color: red"></span>
			<!--  실행시 표시되는 프로그래스아이콘을 표시할 공간 -->
			<span class="js_progress_span"></span>
			<span class="btn_gray">
				<a href="" onclick='submitForms(); return false;'>
					<span class="txt_btn_start"></span>
					<%
					if(SmartUtil.isBlankObject(departId)){
					%>
						<span class="txt_btn_center"><fmt:message key="common.button.add_new"/></span>
					<%
					}else{
					%>
						<span class="txt_btn_center"><fmt:message key="common.button.modify"/></span>
					<%
					}
					%>
					<span class="txt_btn_end"></span>
				</a>
			</span>
			<%
			if(!SmartUtil.isBlankObject(departId)){
			%>
				<span class="btn_gray">
					<a href="" class="js_delete_department">
						<span class="txt_btn_start"></span>
							<span class="txt_btn_center"><fmt:message key="common.button.delete"/></span>
						<span class="txt_btn_end"></span>
					</a>
				</span>
			<%
			}
			%>
		</div>
		<!-- Btn //-->
	</div>
	<!-- 부서추가 //-->
</div>									
