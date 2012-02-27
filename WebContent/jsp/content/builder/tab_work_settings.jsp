<%@page import="net.smartworks.model.work.SmartForm"%>
<%@page import="net.smartworks.model.security.EditPolicy"%>
<%@page import="net.smartworks.model.security.WritePolicy"%>
<%@page import="net.smartworks.model.security.AccessPolicy"%>
<%@page import="net.smartworks.model.work.InformationWork"%>
<%@page import="net.smartworks.model.work.FormField"%>
<%@page import="net.smartworks.util.SmartMessage"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	
	String cid = request.getParameter("cid");
	String workId = SmartUtil.getSpaceIdFromContentContext(cid);
	
	SmartWork work = (SmartWork) smartWorks.getWorkById(workId);
	
	session.setAttribute("cid", cid);
	session.removeAttribute("wid");
	session.setAttribute("smartWork", work);

%>
<script type="text/javascript">

	// 근무시간정책을 수정하기 버튼을 클릭하면, 
	// 모든정보를 JSON형식으로 Serialize해서 서버의 set_work_hour_policy.sw 서비스를 호출하여 수정한다.
	function submitForms(e) {
		var tabWorkSettings = $('.js_tab_work_settings_page');
		if(tabWorkSettings.find('.js_display_field_items tr').length==2){
			smartPop.showInfo(smartPop.ERROR, smartMessage.get('noneDisplayFieldError'));			
			return;
		}
		if (SmartWorks.GridLayout.validate(tabWorkSettings.find('form.js_validation_required'), tabWorkSettings.find('.js_profile_error_message'))) {
			var forms = tabWorkSettings.find('form');
			var paramsJson = {};
			var workId = tabWorkSettings.attr('workId');
			paramsJson['workId'] = workId
			for(var i=0; i<forms.length; i++){
				var form = $(forms[i]);
				if(form.attr('name') === 'frmSmartForm'){
					paramsJson['formId'] = form.attr('formId');
					paramsJson['formName'] = form.attr('formName');
				}
				paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
			}
			console.log(JSON.stringify(paramsJson));
			
			var url = "set_work_settings.sw";
			var confirmMessage = smartMessage.get("saveConfirmation");
			smartPop.confirm( confirmMessage, function(){
				var progressSpan = tabWorkSettings.find('.js_progress_span');
				smartPop.progressCont(progressSpan);
				$.ajax({
					url : url,
					contentType : 'application/json',
					type : 'POST',
					data : JSON.stringify(paramsJson),
					success : function(data, status, jqXHR) {
						// 사용자정보 수정이 정상적으로 완료되었으면, 현재 페이지에 그대로 있는다.
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.INFORM, smartMessage.get('setWorkSettingsSucceed'), function(){
							document.location.href = "tab_work_settings.sw?cid=bd.sp."+ workId;					
						});
					},
					error : function(e) {
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.ERROR, smartMessage.get('setWorkSettingsError'));
					}
				});
			});
		}
	};
</script>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 컨텐츠 레이아웃-->
<div class="section_portlet js_tab_work_settings_page" workId="<%=workId%>">
	<div class="portlet_t"><div class="portlet_tl"></div></div>
	<div class="portlet_l" style="display: block;">
		<ul class="portlet_r" style="display: block;">
			<!-- 타이틀 -->
			<div class="body_titl">
				<div class="body_titl_iworks title"><%=work.getName() %></div>
				<span class="t_location"><%=work.getFullpathName() %></span>
				<!-- tab -->
				<div id="" class="tab_adm float_right">
					<ul class="clear">
						<li><div><a href="tab_workbench.sw?cid=<%=cid %>" class="js_tab_smart_builder"><span class="btn_wo_adm"></span><fmt:message key="builder.title.work_definition"/></a></div></li>
						<li class="current"><div><a><span class="btn_set_adm"></span><fmt:message key="builder.title.work_settings"/></a></div></li>
						<li><div class="end"><a href="tab_work_sharing.sw?cid=<%=cid %>" class="js_tab_smart_builder"><span class="btn_app_shar"></span><fmt:message key="builder.title.work_sharing"/></a></div></li>
					</ul>
				</div>
				<!-- tab//-->
				<div class="solid_line clear"></div>
			</div>
			<!-- 타이틀 -->
			<!-- 컨텐츠 -->
			<div class="contents_space">
		
				<!-- 타이틀 영역 -->
				<%
				String title = "";
				switch(work.getType()){
				case SmartWork.TYPE_INFORMATION : 
					title = SmartMessage.getString("builder.title.iwork_settings");
					break;
				case SmartWork.TYPE_PROCESS :
					title = SmartMessage.getString("builder.title.pwork_settings");
					break;
				case SmartWork.TYPE_SCHEDULE :
					title = SmartMessage.getString("builder.title.swork_settings");
					break;
				}
				%>
				<div class="default_title_space"><div class="title"><%=title %></div></div>
				<!-- 타이틀 영역// -->

				<!-- 목록 -->
				<form name="frmWorkSettings" class="list_contents js_validation_required">

					<%
					if(work.getType() == SmartWork.TYPE_INFORMATION){
						InformationWork informationWork = (InformationWork)work;
						SmartForm smartForm = informationWork.getForm();
						FormField[] formFields = null;
						if(smartForm != null)
							formFields = smartForm.getFields();
						FormField[] displayFields = informationWork.getDisplayFields();
					%>
						<!-- 보이는 항목,안보이는 항목 설정-->
						<div class="clear">
							<div class="left40 gray_style">
								<table class="js_display_field_items">
									<tr>
										<th width="20px"><fmt:message key="builder.title.key_field"/></th>
										<th><fmt:message key="builder.title.display_fields"/></th>
										<th width="50px"><fmt:message key="builder.title.move_item"/></th>
									</tr>
									<tr class="list_action_item" style="display:none">
										<td class="rdo_key_field" >
											<div class="keyOption">
												<a href=""><div class="ico_key js_key_field"></div></a>
											</div>										
										</td>
										<td class="js_input_display_field"></td>
										<td class="btn_move_field" >
											<span class="move_actions">
												<span class="js_up_field_item" title="<fmt:message key="builder.button.move_up_item"/>"><a href="" class="ico_up"></a></span>
												<span style="display:none" class="js_down_field_item" title="<fmt:message key="builder.button.move_down_item"/>"><a href="" class="ico_down"></a></span>
												<span class="js_hide_field_item" title="<fmt:message key="builder.button.hide_item"/>"><a href="" class="ico_hide"></a></span>
											</span>
										</td>
									</tr>
									<%
									if(!SmartUtil.isBlankObject(displayFields) && displayFields.length>0){
										String keyId = (SmartUtil.isBlankObject(informationWork.getKeyField())) ? displayFields[0].getId() : informationWork.getKeyField().getId();
									%>
										<input name="rdoKeyField" type="hidden" value="<%=keyId%>"/>
									<%
										int count = 0;;
										for(FormField formField : displayFields){
											String checkedClass = (formField.getId().equals(keyId)) ? "checked" : "";
									%>
											<tr class="list_action_item">
												<td class="rdo_key_field" >
													
													<!-- key Option -->
													<div class="keyOption <%=checkedClass %>" >
														<a href=""><div class="ico_key js_key_field <%=checkedClass %>" fieldId="<%=formField.getId() %>"></div></a>
													</div>
										
												</td>
												
												<td><input name="hdnDisplayFields" type="hidden" value="<%=formField.getId()%>" fieldName="<%=formField.getName() %>"/><%=formField.getName() %></td>
												<td class="btn_move_field" >
													<span class="move_actions">
														<span <%if(count==0){ %>style="display:none"<%} %> class="js_up_field_item" title="<fmt:message key="builder.button.move_up_item"/>"><a href="" class="ico_up"></a></span>
														<span <%if(count==displayFields.length-1){ %>style="display:none"<%} %> class="js_down_field_item ico_down" title="<fmt:message key="builder.button.move_down_item"/>" ><a href="" class="ico_down"></a></span>
														<span class="js_hide_field_item" title="<fmt:message key="builder.button.hide_item"/>"><a href="" class="ico_hide"></a></span>
													</span>
												</td>
											</tr>
										<%
											count++;
										}
										%>
									<%
									}
									%>
								</table>
							</div>
	
							<div class="right40 gray_style">
								<table class="js_hidden_field_items">
									<tr>
										<th width="20px"><fmt:message key="builder.title.move_item"/></th>
										<th><fmt:message key="builder.title.hidden_fields"/></th>
									</tr>
									<tr class="list_action_item" style="display:none"> 
										<td class="btn_move_field">
											<span class="move_actions" title="<fmt:message key="builder.button.show_item"/>"><span class="js_show_field_item"><a href="" class="ico_show"></a></span></span>
										</td>
										<td></td>
									</tr>
									<%
									if(!SmartUtil.isBlankObject(formFields) && formFields.length>0){
										for(FormField formField : formFields){
											boolean isDisplayField = false;
											for(FormField disField : displayFields){
												if(formField.getId().equals(disField.getId())){
													isDisplayField = true;
													break;
												}
											}
											if(isDisplayField) continue;
									%>
											<tr class="list_action_item" fieldId="<%=formField.getId()%>">
												<td class="btn_move_field">
													<span class="move_actions" title="<fmt:message key="builder.button.show_item"/>"><span class="js_show_field_item"><a href="" class="ico_show"></a></span></span>
												</td>
												<td><%=formField.getName()%></td>
											</tr>
									<%
										}
									}
									%>
								</table>
							</div>
						</div>
						<!-- 보이는 항목, 안보이는 항목 //-->
	
						<div class=" clear padding_t20">
							<table>
								<tbody class="js_display_field_list">
									<tr class="tit_bg">
										<%
										if(!SmartUtil.isBlankObject(informationWork.getDisplayFields()) && informationWork.getDisplayFields().length>0){
											for(FormField formField : displayFields){									
										%>					
											<th class="r_line"><%=formField.getName() %></th>
										<%
											}
										}else if(!SmartUtil.isBlankObject(formFields)){
											FormField formField = formFields[0];
										%>
											<th class="r_line"><%=formField.getName() %></th>
										<%
										}
										%>
										<th class="r_line"><fmt:message key='common.title.last_modifier' /> / <fmt:message key='common.title.last_modified_date' /></th>
										<th style="display:none" class="r_line"></th>
									</tr>
								</tbody>
							</table>
						</div>
					<%
					}
					%>
					<!-- 권한 -->
					<%
					int accessLevel = (SmartUtil.isBlankObject(work.getAccessPolicy())) ? AccessPolicy.LEVEL_DEFAULT : work.getAccessPolicy().getLevel();
					int writeLevel = (SmartUtil.isBlankObject(work.getWritePolicy())) ? WritePolicy.LEVEL_DEFAULT : work.getWritePolicy().getLevel();
					int editLevel = (SmartUtil.isBlankObject(work.getEditPolicy())) ? EditPolicy.LEVEL_DEFAULT : work.getEditPolicy().getLevel();
					
					%>
					<div class="margin_t10 gray_style">
						<table>
							<tr>
								<th width="30%"><fmt:message key="common.security.title.access"/></th>
								<td width="70%">
									<input name="rdoAccessLevel" type="radio" value="<%=AccessPolicy.LEVEL_PUBLIC %>" <%if(accessLevel==AccessPolicy.LEVEL_PUBLIC){ %>checked<%} %>/>
									<span <%if(accessLevel==AccessPolicy.LEVEL_PUBLIC){ %>class="t_bold"<%} %>><fmt:message key="common.security.access.public"/> <fmt:message key="common.security.default"/></span> 
									<input name="rdoAccessLevel" type="radio" value="<%=AccessPolicy.LEVEL_PRIVATE %>"  <%if(accessLevel==AccessPolicy.LEVEL_PRIVATE){ %>checked<%} %>/>
									<span <%if(accessLevel==AccessPolicy.LEVEL_PRIVATE){ %>class="t_bold"<%} %>><fmt:message key="common.security.access.private"/></span> 
									<input name="rdoAccessLevel" type="radio" value="<%=AccessPolicy.LEVEL_CUSTOM %>"  <%if(accessLevel==AccessPolicy.LEVEL_CUSTOM){ %>checked<%} %>/>
									<span <%if(accessLevel==AccessPolicy.LEVEL_CUSTOM){ %>class="t_bold"<%} %>><fmt:message key="common.security.access.custom"/></span>
								</td>
							</tr>
						</table>
					</div>
					<!-- 권한 //-->

					<!-- 권한 -->
					<div class="margin_t10 gray_style">
						<table>
							<tr>
								<th width="30%"><fmt:message key="common.security.title.write"/></th>
								<td width="70%">
									<input name="rdoWriteLevel" type="radio" value="<%=WritePolicy.LEVEL_PUBLIC %>" <%if(writeLevel==WritePolicy.LEVEL_PUBLIC){ %>checked<%} %>/>
									<span <%if(writeLevel==WritePolicy.LEVEL_PUBLIC){ %>class="t_bold"<%} %>><fmt:message key="common.security.write.public"/> <fmt:message key="common.security.default"/></span> 
									<input name="rdoWriteLevel" type="radio" value="<%=WritePolicy.LEVEL_CUSTOM %>" <%if(writeLevel==WritePolicy.LEVEL_CUSTOM){ %>checked<%} %>/>
									<span <%if(writeLevel==WritePolicy.LEVEL_CUSTOM){ %>class="t_bold"<%} %>><fmt:message key="common.security.write.custom"/></span>
							</tr>
						</table>
					</div>
					<!-- 권한 //-->

					<!-- 권한 -->
					<div class="margin_t10 gray_style">
						<table>
							<tr>
								<th width="30%"><fmt:message key="common.security.title.edit"/></th>
								<td width="70%">
									<input name="rdoEditLevel" type="radio" value="<%=EditPolicy.LEVEL_WIKI %>" <%if(editLevel==EditPolicy.LEVEL_WIKI){ %>checked<%} %>/>
									<span <%if(editLevel==EditPolicy.LEVEL_WIKI){ %>class="t_bold"<%} %>><fmt:message key="common.security.edit.wiki"/> <fmt:message key="common.security.default"/></span> 
									<input name="rdoEditLevel" type="radio" value="<%=EditPolicy.LEVEL_BLOG %>" <%if(editLevel==EditPolicy.LEVEL_BLOG){ %>checked<%} %>/>
									<span <%if(editLevel==EditPolicy.LEVEL_BLOG){ %>class="t_bold"<%} %>><fmt:message key="common.security.edit.blog"/></span> 
								</td>
							</tr>
						</table>
					</div>
					<!-- 권한 //-->					
				<!-- 목록 //-->
				</div>
				<!-- 컨텐츠 //-->
				
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
								<span class="Btn01Center"><fmt:message key="common.button.modify"/></span>
								<span class="Btn01End"></span>
							</a>
						</span> 
					</div>
				</div>
				<!-- 버튼영역 //-->
			</ul>		
		</div>	
		<div class="portlet_b" style="display: block;"></div>
	</div>
</div>
<!-- 컨텐츠 레이아웃//-->
