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
	
	String lineId = request.getParameter("lineId");
	ApprovalLine approvalLine = new ApprovalLine();
	if(!SmartUtil.isBlankObject(lineId)){
		approvalLine =  smartWorks.getApprovalLineById(lineId);
	}

%>
<script type="text/javascript">

	// 근무시간정책을 수정하기 버튼을 클릭하면, 
	// 모든정보를 JSON형식으로 Serialize해서 서버의 set_work_hour_policy.sw 서비스를 호출하여 수정한다.
	function submitForms(e) {
		var editApprovalLine = $('.js_edit_approval_line_page');
		if (SmartWorks.GridLayout.validate(editApprovalLine.find('form.js_validation_required'), editApprovalLine.find('.js_profile_error_message'))) {
			var forms = editApprovalLine.find('form');
			var paramsJson = {};
			paramsJson['approvalLineId'] = editApprovalLine.attr('lineId');
			for(var i=0; i<forms.length; i++){
				var form = $(forms[i]);
				if(form.attr('name') === 'frmSmartForm'){
					paramsJson['formId'] = form.attr('formId');
					paramsJson['formName'] = form.attr('formName');
				}
				paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
			}
			console.log(JSON.stringify(paramsJson));
			
			var url = "set_approval_line.sw";
			var lineId = editApprovalLine.attr('lineId'); 
			var confirmMessage = smartMessage.get("saveConfirmation");
			if(isEmpty(lineId)){
				url = "create_approval_line.sw";
				confirmMessage = smartMessage.get("createConfirmation")
			}
			smartPop.confirm( confirmMessage, function(){
				var progressSpan = editApprovalLine.find('.js_progress_span');
				smartPop.progressCont(progressSpan);
				$.ajax({
					url : url,
					contentType : 'application/json',
					type : 'POST',
					data : JSON.stringify(paramsJson),
					success : function(data, status, jqXHR) {
						// 사용자정보 수정이 정상적으로 완료되었으면, 현재 페이지에 그대로 있는다.
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.INFORM, isEmpty(lineId) ? smartMessage.get('createApprovalLineSucceed') : smartMessage.get('setApprovalLineSucceed'), function(){
							document.location.href = "approval_line.sw";					
						});
					},
					error : function(e) {
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.ERROR, isEmpty(lineId) ? smartMessage.get('createApprovalLineError') : smartMessage.get('setApprovalLineError'));
					}
				});
			});
		}
	};
	
	function closePage() {
		$('.js_edit_approval_line_page').parent().slideUp(500).html('');
	};	
</script>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="form_wrap up up_padding margin_b2 clear js_edit_approval_line_page" lineId="<%=CommonUtil.toNotNull(lineId)%>">
	<div class="form_title">
		<%
		if(SmartUtil.isBlankObject(lineId)){
		%>
			<div class="ico_iworks title_noico"><fmt:message key="settings.title.approval.new"/></div>
		<%
		}else{
		%>
			<div class="ico_iworks title_noico"><fmt:message key="settings.title.approval.edit"/></div>
		<%
		}
		%>
		<div class="solid_line clear"></div>
	</div>

	<form name="frmEditApprovalLine" class="form_layout margin_b10 js_validation_required">
		<table>
			<tbody>
				<tr>
					<th width="20%"><fmt:message key="settings.title.approval.name"/><span class="essen_n"></span></th>
					<td colspan="3" width="80%" ><input name="txtApprovalLineName" type="text" class="fieldline required" value="<%=CommonUtil.toNotNull(approvalLine.getName())%>"/>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="settings.title.approval.desc"/></th>
					<td colspan="3"><textarea name="txtaApprovalLineDesc" rows="3" class="fieldline"><%=CommonUtil.toNotNull(approvalLine.getDesc()) %></textarea>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="settings.title.approval.level"/></span></th>
					<td colspan="3">
						<select name="selApprovalLineLevel" class="js_approval_line_level">
							<option value="2" <%if(approvalLine.getApprovalLevel() == 2){ %>selected<%} %>>2<fmt:message key="settings.title.approval_level"/></option>
							<option value="3" <%if(approvalLine.getApprovalLevel() == 3){ %>selected<%} %>>3<fmt:message key="settings.title.approval_level"/></option>
							<option value="4" <%if(approvalLine.getApprovalLevel() == 4){ %>selected<%} %>>4<fmt:message key="settings.title.approval_level"/></option>
							<option value="5" <%if(approvalLine.getApprovalLevel() == 5){ %>selected<%} %>>5<fmt:message key="settings.title.approval_level"/></option>
						</select>
					</td>
				</tr>
				<tr>
					<th><fmt:message key="settings.title.approval.level_name"/><span class="essen_n"></span></th>
					<%
					if(approvalLine.getApprovalLevel()!=0){
						int widthVal = 80/approvalLine.getApprovalLevel();
						Approval[] approvals = approvalLine.getApprovals();
						for(int count=1; count<6; count++){
							String levelName = "";
							if(approvals!=null && approvals.length>=count) levelName = approvals[count-1].getName();
					%>					
							<td class="js_approval_level_name" width="<%=widthVal%>%" <%if(approvalLine.getApprovalLevel()<count){ %>style="display:none"<%} %>><input name="txtLevelName<%=count %>" type="text" class="fieldline required" value="<%=CommonUtil.toNotNull(levelName)%>"/></td>
					<%
						}
					}
					%>
				</tr>
				<tr>
					<th><fmt:message key="settings.title.approval.approver"/></span></th>
					<%
					if(approvalLine.getApprovalLevel()!=0){
						int widthVal = 80/approvalLine.getApprovalLevel();
						Approval[] approvals = approvalLine.getApprovals();
						for(int count=1; count<6; count++){
							Approval approval = new Approval();
							if(approvals!=null && approvals.length>=count) approval = approvals[count-1];
					%>					
							<td class="js_approver_type required" <%if(approvalLine.getApprovalLevel()<count){ %>style="display:none"<%} %>>
								<select name="selLevelApproverType<%=count %>" class="js_approval_approver_type">
									<option <%if(approval.getApproverType()== Approval.APPROVER_MY_BOSS){ %>selected<%} %> value="<%=Approval.APPROVER_MY_BOSS%>"><fmt:message key="settings.title.approver.team_leader"/></option>
									<option <%if(approval.getApproverType()== Approval.APPROVER_CHOOSE_USER){ %>selected<%} %> value="<%=Approval.APPROVER_CHOOSE_USER%>"><fmt:message key="settings.title.approver.select_user"/></option>
									<option <%if(approval.getApproverType()== Approval.APPROVER_CHOOSE_ON_RUNNING){ %>selected<%} %> value="<%=Approval.APPROVER_CHOOSE_ON_RUNNING%>"><fmt:message key="settings.title.approver.on_draft"/></option>
								</select>
								<div class="js_type_userField" fieldId="usrLevelApprover<%=count %>" multiUsers="false" <%if(approval.getApproverType()!=Approval.APPROVER_CHOOSE_USER){ %>style="display:none"<%} %>>
									<div class="ico_fb_space form_value" >
										<div class="fieldline js_community_names sw_required">
											<div class="js_selected_communities user_sel_area">
												<%
												if(!SmartUtil.isBlankObject(approval.getApprover())){
												%>
													<span>
														<span class='js_community_item user_select' comId="<%=approval.getApprover().getId()%>"><%=approval.getApprover().getLongName() %><span class='btn_x_gr'>
															<a class='js_remove_community' href=''> x</a>
														</span></span>
													</span>									
												<%
												}
												%>
											</div>
											<input class="js_auto_complete" href="user_name.sw" type="text">
											<div class="js_srch_x"></div>
										</div>
										<div class="js_community_list srch_list_nowid" style="display: none"></div>
										<span class="js_community_popup"></span>
										<a href="" class="js_userpicker_button"><span class="ico_fb_user"></span></a>
									</div>
								</div>								
							</td>
					<%
						}
					}
					%>
				</tr>
				<tr>
					<th><fmt:message key="settings.title.approval.mean_time"/><span class="essen_n"></span></th>
					<%
					if(approvalLine.getApprovalLevel()!=0){
						int widthVal = 80/approvalLine.getApprovalLevel();
						Approval[] approvals = approvalLine.getApprovals();
						for(int count=1; count<6; count++){
							Approval approval = new Approval();
							if(approvals!=null && approvals.length>=count) approval = approvals[count-1];
					%>					
							<td class="js_approval_mean_time" <%if(approvalLine.getApprovalLevel()<count){ %>style="display:none"<%} %>>
								<input name="txtMeanTimeDays<%=count %>" type="text" class="fieldline number required" style="width:18px" value="<%=approval.getMeanTimeDays()%>"/>
								<span><fmt:message key="settings.title.mean_time.days"/></span>
								<input name="txtMeanTimeHours<%=count %>" type="text" class="fieldline number required" style="width:18px" value="<%=approval.getMeanTimeHours()%>"/>
								<span><fmt:message key="settings.title.mean_time.hours"/></span>
								<input name="txtMeanTimeMinutes<%=count %>" type="text" class="fieldline number required" style="width:18px" value="<%=approval.getMeanTimeMinutes()%>"/>
								<span><fmt:message key="settings.title.mean_time.minutes"/></span>
							</td>
					<%
						}
					}
					%>
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
					if(SmartUtil.isBlankObject(lineId)){
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