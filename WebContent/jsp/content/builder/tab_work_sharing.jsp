<%@page import="net.smartworks.model.work.info.SmartTaskInfo"%>
<%@page import="net.smartworks.model.work.SmartTask"%>
<%@page import="net.smartworks.model.work.SmartDiagram"%>
<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.util.SmartMessage"%>
<%@page import="net.smartworks.model.work.ScheduleWork"%>
<%@page import="net.smartworks.model.work.ProcessWork"%>
<%@page import="net.smartworks.model.work.InformationWork"%>
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
	
	String workPicture = "";
	String workType = "";
	String workManual = "";
	String workMovie = "";
	if(work.getClass().equals(InformationWork.class)){
		workPicture = ((InformationWork)work).getForm().getMinImage();
		workType = SmartMessage.getString("common.title.information_work");
		workManual = ((InformationWork)work).getManualFilePath() + ((InformationWork)work).getManualFileName();
		workPicture = ((InformationWork)work).getForm().getMinImage();
	}else if(work.getClass().equals(ProcessWork.class)){
		workPicture = ((ProcessWork)work).getDiagram().getMinImage();
		workType = SmartMessage.getString("common.title.process_work");
		workManual = ((ProcessWork)work).getManualFilePath() + ((ProcessWork)work).getManualFileName();
	}else if(work.getClass().equals(ScheduleWork.class)){
		//TO DO
		workType = SmartMessage.getString("common.title.schedule_work");
	}
	
	session.setAttribute("cid", cid);
	session.removeAttribute("wid");
	session.setAttribute("smartWork", work);

%>
<script type="text/javascript">

	// 근무시간정책을 수정하기 버튼을 클릭하면, 
	// 모든정보를 JSON형식으로 Serialize해서 서버의 set_work_hour_policy.sw 서비스를 호출하여 수정한다.
	function submitForms(e) {
		var tabWorkSharing = $('.js_tab_work_sharing_page');
		if (SmartWorks.GridLayout.validate(tabWorkSharing.find('form.js_validation_required'), tabWorkSharing.find('.js_profile_error_message'))) {
			var forms = tabWorkSharing.find('form');
			var paramsJson = {};
			var workId = tabWorkSharing.attr('workId');
			var workType = tabWorkSharing.attr('workType');
			paramsJson['workId'] = workId
			paramsJson['workType'] = workType;
			for(var i=0; i<forms.length; i++){
				var form = $(forms[i]);
				if(form.attr('name') === 'frmSmartForm'){
					paramsJson['formId'] = form.attr('formId');
					paramsJson['formName'] = form.attr('formName');
				}
				paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
			}
			console.log(JSON.stringify(paramsJson));
			
			var url = "publish_work_to_store.sw";
			var confirmMessage = smartMessage.get("publishConfirmation");
			smartPop.confirm( confirmMessage, function(){
				var progressSpan = tabWorkSharing.find('.js_progress_span');
				smartPop.progressCont(progressSpan);
				$.ajax({
					url : url,
					contentType : 'application/json',
					type : 'POST',
					data : JSON.stringify(paramsJson),
					success : function(data, status, jqXHR) {
						// 사용자정보 수정이 정상적으로 완료되었으면, 현재 페이지에 그대로 있는다.
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.INFORM, smartMessage.get('publishWorkSucceed'), function(){
							document.location.href = "tab_workbench.sw?cid=bd.sp."+ workId;					
						});
					},
					error : function(e) {
						smartPop.closeProgress();
						smartPop.showInfo(smartPop.ERROR, smartMessage.get('publishWorkError'));
					}
				});
			});
		}
	};
</script>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 컨텐츠 레이아웃-->
<div class="section_portlet js_tab_work_sharing_page" workId="<%=workId%>" workType="<%=work.getType()%>">
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
						<li><div><a href="tab_work_settings.sw?cid=<%=cid %>" class="js_tab_smart_builder"><span class="btn_set_adm"></span><fmt:message key="builder.title.work_settings"/></a></div></li>
						<li class="current"><div class="end"><a><span class="btn_app_shar"></span><fmt:message key="builder.title.work_sharing"/></a></div></li>
					</ul>
				</div>
				<!-- tab//-->
				<div class="solid_line clear"></div>
			</div>
			<!-- 타이틀 -->
			<!-- 컨텐츠 -->
			<form name="frmWorkSharing" class="contents_space js_validation_required">
				<!-- 타이틀 영역 -->
				<div class="default_title_space">
					<div class="title"><fmt:message key="builder.title.work_desc"/></div>
				</div>
				<!-- 타이틀 영역// -->
				<!-- 업무설명 -->
				<div class="form_wrap up form_layout padding_t10 padding_b10">
					<div class="left_im"><img src="<%=workPicture%>" /></div>
					<div class="right_auto">
						<table>
							<tbody>
								<tr>
									<th width="20%"><fmt:message key="builder.title.sharing_name"/><span class="essen_n"></span></th>
									<td colspan="3" width="80%"><input name="txtSharingName" class="fieldline required" type="text" value="<%=work.getName() %>" /></td>
								</tr>
								<tr>
									<th><fmt:message key="builder.title.work_name"/></th>
									<td width="30%">&nbsp;<%=work.getName() %></td>
									<th width="20%"><fmt:message key="builder.title.work_type"/></th>
									<td width="30%">&nbsp;<%=workType %></td>
								</tr>
								<tr>
									<th><fmt:message key="builder.title.work_industry"/><span class="essen_n"></span></th>
									<td>
										<select name="selSharingIndustry">
											<option></option>
										</select>
									</td>
									<th><fmt:message key="builder.title.work_job"/><span class="essen_n"></span></th>
									<td>
										<select name="selSharingJobType">
											<option></option>
										</select>
									</td>
								</tr>
								<tr>
									<th><fmt:message key="common.title.desc"/><span class="essen_n"></span></th>
									<td colspan="3">
										<textarea name="txtaSharingDesc" class="fieldline required" name="" id="" cols="" rows="5"><%=CommonUtil.toNotNull(work.getDesc()) %></textarea>
									</td>
								</tr>
								<tr>
									<th><fmt:message key="builder.title.work_manual"/></th>
									<td colspan="3"><input name="fileWorkManual" type="file" src="<%=workManual %>" /></td>
								</tr>
								<tr>
									<th><fmt:message key="builder.title.work_movie"/></th>
									<td colspan="3"><input name="fileWorkMovie" type="file" src="<%=workMovie %>" /></td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- 업무 설명 //-->
				</div>
				<!-- 타이틀 영역 -->
				<div class="default_title_space margin_t20">
					<div class="title"><fmt:message key="builder.title.work_guide"/> (<%=work.getName()%>)</div>
				</div>
				<!-- 타이틀 영역// -->
				<%
				if(work.getClass().equals(InformationWork.class)){
					InformationWork informationWork = (InformationWork)work;
				%>
					<!-- 사용자 가이드 -->
					<div class="form_wrap up form_layout padding_t10 padding_b10">
						<!-- 타이틀 -->
						<div class="form_title padding0 margin_b10">
							<div class="<%=work.getIconClass() %> title_noico"><%=work.getName() %></div>
							<div class="solid_line clear"></div>
						</div>
						<!-- 타이틀 //-->
						<div class="left_im2">
							<img src="<%=informationWork.getForm().getOrgImage() %>" width="315">
						</div>
						<div class="right_auto2">
							<table>
								<tbody>
									<tr><th><fmt:message key="builder.title.form_desc"/></th></tr>
									<tr>
										<td>
											<input type="radio" value="" /><fmt:message key="builder.button.text"/>
											<input type="radio" value="" /><fmt:message key="builder.button.editor"/>
											<textarea class="fieldline" name="txtaFormDesc" cols="" rows="9"></textarea>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<!-- 사용자 가이드 //-->
				<%
				}else if(work.getClass().equals(ProcessWork.class)){
					ProcessWork processWork = (ProcessWork)work;
					SmartDiagram diagram =  processWork.getDiagram();
				%>
					<!-- 사용자 가이드 -->
					<div class="form_wrap up form_layout padding_t10 padding_b10">
						<!-- 타이틀 -->
						<div class="form_title padding0 margin_b10">
							<div class="icon_pworks title_noico"><%=work.getName() %></div>
							<div class="solid_line clear"></div>
						</div>
						<!-- 타이틀 //-->
						<div class="left_im2">
							<img src="<%=diagram.getOrgImage() %>" width="315">
						</div>
						<div class="right_auto2">
							<table>
								<tbody>
									<tr><th><fmt:message key="builder.title.form_desc"/></th></tr>
									<tr>
										<td>
											<input type="radio" value="" /><fmt:message key="builder.button.text"/>
											<input type="radio" value="" /><fmt:message key="builder.button.editor"/>
											<textarea class="fieldline" name="txtaProcessDesc" cols="" rows="9"></textarea>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<%
					if(!SmartUtil.isBlankObject(diagram.getTasks()) && diagram.getTasks().length>0){
						for(SmartTaskInfo task : diagram.getTasks()){						
					%>
							<!-- 사용자 가이드 -->
							<div class="form_wrap up form_layout padding_t10 padding_b10">
								<!-- 타이틀 -->
								<div class="form_title padding0 margin_b10">
									<div class="icon_iworks title_noico"><%=task.getName() %></div>
									<div class="solid_line clear"></div>
								</div>
								<!-- 타이틀 //-->
								<div class="left_im2">
									<img src="<%=task.getForm().getOrgImage() %>" width="315">
								</div>
								<div class="right_auto2">
									<table>
										<tbody>
											<tr><th><fmt:message key="builder.title.form_desc"/></th></tr>
											<tr>
												<td>
													<input type="radio" value="" /><fmt:message key="builder.button.text"/>
													<input type="radio" value="" /><fmt:message key="builder.button.editor"/>
													<textarea class="fieldline" name="txtaFormDesc" cols="" rows="9"></textarea>
												</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
					<%
						}
					}
					%>
				<%
				}
				%>
				<!-- 하단버튼 영역 -->
				<div class="text_align_c margin_t10 clear">
					<!-- 실행시 데이터 유효성 검사이상시 에러메시지를 표시할 공간 -->
					<span class="form_space sw_error_message js_profile_error_message" style="text-align:right; color: red"></span>
					<!--  실행시 표시되는 프로그래스아이콘을 표시할 공간 -->
					<span class="js_progress_span"></span>
					<span class="btn_gray">
						<a href="" onclick='submitForms(); return false;'>
							<span class="Btn01Start"></span> 
							<span class="Btn01Center"><span class="btn_app_shar_go"></span><fmt:message key="builder.button.sharing_to_appstore"/></span> 
							<span class="Btn01End"></span> 
						</a>
					</span>
				</div>
				<!-- 하단 버튼 영역 //-->
			
			<!-- 컨텐츠 //-->
		</ul>
		</div>
		<div class="portlet_b" style="display: block;"></div>
	</div>
</div>
<!-- 컨텐츠 레이아웃//-->
