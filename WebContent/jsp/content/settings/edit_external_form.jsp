<%@page import="net.smartworks.model.work.FormField"%>
<%@page import="net.smartworks.model.service.ExternalForm"%>
<%@page import="net.smartworks.model.service.Variable"%>
<%@page import="net.smartworks.model.service.WebService"%>
<%@page import="net.smartworks.model.approval.Approval"%>
<%@page import="net.smartworks.model.approval.ApprovalLine"%>
<%@page import="net.smartworks.model.community.Community"%>
<%@page import="net.smartworks.model.calendar.CompanyEvent"%>
<%@page import="net.smartworks.model.calendar.CompanyCalendar"%>
<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.model.calendar.WorkHour"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.model.calendar.WorkHourPolicy"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	
	String formId = request.getParameter("formId");
	ExternalForm externalForm = new ExternalForm();
	if(!SmartUtil.isBlankObject(formId)){
		externalForm =  smartWorks.getExternalFormById(formId);
	}
%>
<script type="text/javascript">

	// 근무시간정책을 수정하기 버튼을 클릭하면, 
	// 모든정보를 JSON형식으로 Serialize해서 서버의 set_work_hour_policy.sw 서비스를 호출하여 수정한다.
	function submitForms(e) {
		var editExternalForm = $('.js_edit_external_form_page');
		if (SmartWorks.GridLayout.validate(editExternalForm.find('form.js_validation_required'), editExternalForm.find('.js_profile_error_message'))) {
			var forms = editExternalForm.find('form');
			var paramsJson = {};
			paramsJson['formId'] = editExternalForm.attr('formId');
			for(var i=0; i<forms.length; i++){
				var form = $(forms[i]);
				if(form.attr('name') === 'frmSmartForm'){
					paramsJson['formId'] = form.attr('formId');
					paramsJson['formName'] = form.attr('formName');
				}
				paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
			}
			console.log(JSON.stringify(paramsJson));
			
			var url = "set_external_form.sw";
			var formId = editExternalForm.attr('formId'); 
			var confirmMessage = smartMessage.get("saveConfirmation");
			if(isEmpty(formId)){
				url = "create_external_form.sw";
				confirmMessage = smartMessage.get("createConfirmation")
			}
			smartPop.confirm( confirmMessage, function(){
				var progressSpan = editExternalForm.find('.js_progress_span');
				smartPop.progressCont(progressSpan);
				$.ajax({
					url : url,
					contentType : 'application/json',
					type : 'POST',
					data : JSON.stringify(paramsJson),
					success : function(data, status, jqXHR) {
						// 사용자정보 수정이 정상적으로 완료되었으면, 현재 페이지에 그대로 있는다.
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.INFORM, isEmpty(formId) ? smartMessage.get('createExternalFormSucceed') : smartMessage.get('setExternalFormSucceed'), function(){
							document.location.href = "external_form.sw";					
						});
					},
					error : function(e) {
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.ERROR, isEmpty(formId) ? smartMessage.get('createExternalFormError') : smartMessage.get('setExternalFormError'));
					}
				});
			});
		}
	};
	
	function closePage() {
		$('.js_edit_web_service_page').parent().slideUp(500).html('');
	};	
</script>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="form_wrap up up_padding margin_b2 clear js_edit_external_form_page" formId="<%=CommonUtil.toNotNull(formId)%>">
	<div class="form_title">
		<%
		if(SmartUtil.isBlankObject(formId)){
		%>
			<div class="ico_iworks title_noico"><fmt:message key="settings.title.externalform.new"/></div>
		<%
		}else{
		%>
			<div class="ico_iworks title_noico"><fmt:message key="settings.title.externalform.edit"/></div>
		<%
		}
		%>
		<div class="solid_line clear"></div>
	</div>

	<form name="frmEditExternalForm" class="form_layout margin_b10 js_validation_required">
		<table>
			<tbody>
				<tr>
					<td width="20%"><fmt:message key="settings.title.externalform.name"/><span class="essen_n"></span></td>
					<td colspan="3" width="80%" ><input name="txtExternalFormName" type="text" class="fieldline required" value="<%=CommonUtil.toNotNull(externalForm.getName())%>"/>
					</td>
				</tr>
				<tr>
					<td><fmt:message key="settings.title.externalform.desc"/></td>
					<td colspan="3"><textarea name="txtExternalFormDesc" rows="3" class="fieldline"><%=CommonUtil.toNotNull(externalForm.getDesc()) %></textarea>
					</td>
				</tr>
				<tr>
					<td><fmt:message key="settings.title.externalform.url"/><span class="essen_n"></span></td>
					<td>
						<div class="btn_fb_space">
							<input name="txtExternalFormURL" class="fieldline required" type="text" value="<%=CommonUtil.toNotNull(externalForm.getUrl())%>">
						</div>
					</td>
				</tr>
				<tr>
					<td><fmt:message key="settings.title.externalform.edit_method"/><span class="essen_n"></span></td>
					<td>
						<input name="txtEditMethod" class="fieldline required" type="text" value="<%=CommonUtil.toNotNull(externalForm.getEditMethod())%>">
					</td>
				</tr>
				<tr>
					<td><fmt:message key="settings.title.externalform.view_method"/><span class="essen_n"></span></td>
					<td>
						<input name="txtViewMethod" class="fieldline required" type="text" value="<%=CommonUtil.toNotNull(externalForm.getViewMethod())%>">
					</td>
				</tr>
				<tr>
					<td><fmt:message key="settings.title.externalform.edit_variables"/><span class="essen_n"></span></td>
					<td>
						<table style="width:100%">
							<tr>
								<th style="width:30%"><fmt:message key="settings.title.variable.name"/></th>
								<th style="width:30%"><fmt:message key="settings.title.variable.element_name"/></th>
								<th style="width:30%"><fmt:message key="settings.title.variable.element_type"/></th>
								<th style="width:10%"><a href="" class="js_add_variable_item"> + </a></th>
							</tr>
							<%
							int editVarCount = (externalForm.getEditVariables()==null) ? 0 : externalForm.getEditVariables().length;
							%>
							<tr style="display:none" varCount="<%=editVarCount %>">
								<th><input class="fieldline required variableName" name="txtEditVariableName" type="text" value=""></th>
								<th><input class="fieldline required elementName" name="txtEditElementName" type="text" value=""></th>
								<th><select class="fieldline required elementType" name="selEditElementType">
										<%
										for(int i=0; i<FormField.FORM_FIELD_TYPES_VARIABLE.length; i++){
											String elementType = FormField.FORM_FIELD_TYPES_VARIABLE[i];
											String elementTypeName = FormField.FORM_FIELD_TYPE_NAMES_VARIABLE[i];
										%>
											<option value="<%=elementType%>"><%=elementTypeName%></option>
										<%
										}
										%>
									</select>
								</th>
								<th><a href="" class="js_remove_variable_item"> - </a></th>
							</tr>				
							<%
							if(editVarCount>0){
								Variable[] editVariables = externalForm.getEditVariables();
								for(int count=1; count<editVariables.length+1; count++){
									Variable editVariable = editVariables[count-1]; 
							%>
									<tr>
										<th><input class="fieldline required" name="txtEditVariableName<%=count %>" type="text" value="<%=CommonUtil.toNotNull(editVariable.getName())%>"></th>
										<th><input class="fieldline required" name="txtEditElementName<%=count %>" type="text" value="<%=CommonUtil.toNotNull(editVariable.getElementName())%>"></th>
										<th><select class="fieldline required" name="selEditElementType<%=count %>">
												<%
												for(int i=0; i<FormField.FORM_FIELD_TYPES_VARIABLE.length; i++){
													String elementType = FormField.FORM_FIELD_TYPES_VARIABLE[i];
													String elementTypeName = FormField.FORM_FIELD_TYPE_NAMES_VARIABLE[i];
												%>
													<option value="<%=elementType%>" <%if(elementType.equals(editVariable.getElementType())){ %>selected<%} %>><%=elementTypeName %></option>
												<%
												}
												%>
											</select>
										</th>
										<th><a href="" class="js_remove_variable_item"> - </a></th>
									</tr>				
							<%
								}
							}
							%>
						</table>
					</td>
				</tr>
				<tr>
					<td><fmt:message key="settings.title.externalform.view_variables"/><span class="essen_n"></span></td>
					<td>
						<table style="width:100%">
							<tr>
								<th style="width:30%"><fmt:message key="settings.title.variable.name"/></th>
								<th style="width:30%"><fmt:message key="settings.title.variable.element_name"/></th>
								<th style="width:30%"><fmt:message key="settings.title.variable.element_type"/></th>
								<th style="width:10%"><a href="" class="js_add_variable_item"> + </a></th>
							</tr>
							<%
							int viewVarCount = (externalForm.getViewVariables()==null) ? 0 : externalForm.getViewVariables().length;
							%>
							<tr style="display:none" varCount="<%=viewVarCount%>">
								<th><input class="fieldline required variableName" name="txtViewVariableName" type="text" value=""></th>
								<th><input class="fieldline required elementName" name="txtViewElementName" type="text" value=""></th>
								<th><select class="fieldline required elementType" name="selViewElementType">
										<%
										for(int i=0; i<FormField.FORM_FIELD_TYPES_VARIABLE.length; i++){
											String elementType = FormField.FORM_FIELD_TYPES_VARIABLE[i];
											String elementTypeName = FormField.FORM_FIELD_TYPE_NAMES_VARIABLE[i];
										%>
											<option value="<%=elementType%>"><%=elementTypeName%></option>
										<%
										}
										%>
									</select>
								</th>
								<th><a href="" class="js_remove_variable_item"> - </a></th>
							</tr>				
							<%
							if(viewVarCount>0){
								Variable[] viewVariables = externalForm.getViewVariables();
								for(int count=1; count<viewVariables.length+1; count++){
									Variable viewVariable = viewVariables[count-1]; 
							%>
									<tr>
										<th><input class="fieldline required" name="txtViewVariableName<%=count %>" type="text" value="<%=CommonUtil.toNotNull(viewVariable.getName())%>"></th>
										<th><input class="fieldline required" name="txtViewElementName<%=count %>" type="text" value="<%=CommonUtil.toNotNull(viewVariable.getElementName())%>"></th>
										<th><select class="fieldline required" name="selViewElementType<%=count %>">
												<%
												for(int i=0; i<FormField.FORM_FIELD_TYPES_VARIABLE.length; i++){
													String elementType = FormField.FORM_FIELD_TYPES_VARIABLE[i];
													String elementTypeName = FormField.FORM_FIELD_TYPE_NAMES_VARIABLE[i];
												%>
													<option value="<%=elementType%>" <%if(elementType.equals(viewVariable.getElementType())){ %>selected<%} %>><%=elementTypeName %></option>
												<%
												}
												%>
											</select>
										</th>
										<th><a href="" class="js_remove_variable_item"> - </a></th>
									</tr>				
							<%
								}
							}
							%>
						</table>
					</td>
				</tr>
				<tr>
					<td><fmt:message key="settings.title.externalform.return_variables"/><span class="essen_n"></span></td>
					<td>
						<table style="width:100%">
							<tr>
								<th style="width:30%"><fmt:message key="settings.title.variable.name"/></th>
								<th style="width:30%"><fmt:message key="settings.title.variable.element_name"/></th>
								<th style="width:30%"><fmt:message key="settings.title.variable.element_type"/></th>
								<th style="width:10%"><a href="" class="js_add_variable_item"> + </a></th>
							</tr>
							<%
							int returnVarCount = (externalForm.getReturnVariables()==null) ? 0 : externalForm.getReturnVariables().length;
							%>
							<tr style="display:none" varCount="<%=returnVarCount%>">
								<th><input class="fieldline required variableName" name="txtReturnVariableName" type="text" value=""></th>
								<th><input class="fieldline required elementName" name="txtReturnElementName" type="text" value=""></th>
								<th><select class="fieldline required elementType" name="selReturnElementType">
										<%
										for(int i=0; i<FormField.FORM_FIELD_TYPES_VARIABLE.length; i++){
											String elementType = FormField.FORM_FIELD_TYPES_VARIABLE[i];
											String elementTypeName = FormField.FORM_FIELD_TYPE_NAMES_VARIABLE[i];
										%>
											<option value="<%=elementType%>"><%=elementTypeName%></option>
										<%
										}
										%>
									</select>
								</th>
								<th><a href="" class="js_remove_variable_item"> - </a></th>
							</tr>				
							<%
							if(returnVarCount>0){
								Variable[] returnVariables = externalForm.getReturnVariables();
								for(int count=1; count<returnVariables.length+1; count++){
									Variable returnVariable = returnVariables[count-1]; 
							%>
									<tr>
										<th><input class="fieldline required" name="txtReturnVariableName<%=count %>" type="text" value="<%=CommonUtil.toNotNull(returnVariable.getName())%>"></th>
										<th><input class="fieldline required" name="txtReturnElementName<%=count %>" type="text" value="<%=CommonUtil.toNotNull(returnVariable.getElementName())%>"></th>
										<th><select class="fieldline required" name="selReturnElementType<%=count %>">
												<%
												for(int i=0; i<FormField.FORM_FIELD_TYPES_VARIABLE.length; i++){
													String elementType = FormField.FORM_FIELD_TYPES_VARIABLE[i];
													String elementTypeName = FormField.FORM_FIELD_TYPE_NAMES_VARIABLE[i];
												%>
													<option value="<%=elementType%>" <%if(elementType.equals(returnVariable.getElementType())){ %>selected<%} %>><%=elementTypeName %></option>
												<%
												}
												%>
											</select>
										</th>
										<th><a href="" class="js_remove_variable_item"> - </a></th>
									</tr>				
							<%
								}
							}
							%>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</form>

	<!-- 버튼영역 -->
	<div class="glo_btn_space">
		<!-- 실행시 데이터 유효성 검사이상시 에러메시지를 표시할 공간 -->
		<span class="form_space sw_error_message js_profile_error_message" style="text-align:right; color: red"></span>
		<!--  실행시 표시되는 프로그래스아이콘을 표시할 공간 -->
		<span class="js_progress_span"></span>
		<div class="float_right">
			<span class="btn_gray"> 
				<a href="" onclick='submitForms(); return false;'>
					<span class="Btn01Start"></span>
					<%
					if(SmartUtil.isBlankObject(formId)){
					%>
						<span class="Btn01Center"><fmt:message key="common.button.add_new"/></span> 
					<%
					}else{
					%>
						<span class="Btn01Center"><fmt:message key="common.button.modify"/></span>
					<%
					}
					%>
					<span class="Btn01End"></span>
				</a>
			</span> 
			<span class="btn_gray"> 
				<a href="" onclick='closePage();return false;'>
					<span class="Btn01Start"></span>
					<span class="Btn01Center"><fmt:message key="common.button.cancel"/></span> 
					<span class="Btn01End"></span>
				</a>
			</span>
		</div>
	</div>
	<!-- 버튼영역 //-->

</div>
<!-- 추가하기 테이블 //-->
