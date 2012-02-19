
<!-- Name 			: pop_new_work_definition.jsp							 -->
<!-- Description	: 새로운 업무w정의를 생성하는 팝업화면 						 -->
<!-- Author			: Maninsoft, Inc.										 -->
<!-- Created Date	: 2011.9.												 -->

<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@page import="net.smartworks.model.work.WorkCategory"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.community.Group"%>
<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.model.KeyMap"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.util.LocaleInfo"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다 
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	String parentId = request.getParameter("parentId");
	String parentName = request.getParameter("parentName");
	String workId = request.getParameter("workId");
	String workName = request.getParameter("workName");
	String workTypeName = request.getParameter("workTypeName");
	String workDesc = request.getParameter("workDesc");
	String categoryId = request.getParameter("categoryId");
	String groupId = request.getParameter("groupId");
	
%>
<script type="text/javascript">

	// 개인정보프로파일 수정하기 버튼을 클릭하면, 
	// 모든정보를 JSON형식으로 Serialize해서 서버의 update_my_profile.sw 서비스를 호출하여 수정한다.
	function submitForms(e) {
		var newWorkDefinition = $('.js_new_work_definition_page');
		if (SmartWorks.GridLayout.validate(newWorkDefinition.find('form.js_validation_required'), $('.js_pop_error_message'))) {
			var forms = newWorkDefinition.find('form');
			var workId = newWorkDefinition.attr('workId');
			var paramsJson = {};
			var url = "create_new_work_definition.sw";
			if(isEmpty(workId)){
				paramsJson['parentId'] = newWorkDefinition.attr('parentId');
			}else{
				paramsJson['workId'] = workId;
				url = "set_work_definition.sw";
			}
			for(var i=0; i<forms.length; i++){
				var form = $(forms[i]);
				if(form.attr('name') === 'frmSmartForm'){
					paramsJson['formId'] = form.attr('formId');
					paramsJson['formName'] = form.attr('formName');
				}
				paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
			}
			console.log(JSON.stringify(paramsJson));
			var progressSpan = newWorkDefinition.find('.js_progress_span');
			smartPop.progressCont(progressSpan);
			$.ajax({
				url : url,
				contentType : 'application/json',
				type : 'POST',
				data : JSON.stringify(paramsJson),
				success : function(data, status, jqXHR) {
					// 사용자정보 수정이 정상적으로 완료되었으면, 현재 페이지에 그대로 있는다.
					smartPop.closeProgress();
 					smartPop.showInfo(smartPop.INFORM, (isEmpty(workId) ? smartMessage.get('createWorkDefinitionSucceed') : smartMessage.get('setWorkDefinitionSucceed'), function(){
						document.location.href = document.location.href;
 						smartPop.close();
  					});
				},
				error : function(e) {
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.ERROR, (isEmpty(workId) ? smartMessage.get('createWorkDefinitionError') : smartMessage.get('setWorkDefinitionError'));
				}
			});
		}
	};
</script>

<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!--  전체 레이아웃 -->
<div class="pop_corner_all js_new_work_definition_page" parentId="<%=parentId%>" workId="<%=workId%>">

	<!-- 팝업 타이틀 -->
	<div class="form_title">
		<%
		if(SmartUtil.isBlankObject(workId)){
		%>
			<div class="pop_title"><fmt:message key="builder.title.new_work_definition"></fmt:message></div>
		<%
		}else{
		%>
			<div class="pop_title"><fmt:message key="builder.title.change_work_definition"></fmt:message></div>
		<%
		}
		%>
		<div class="txt_btn">
			<div class="btn_x">
				<a href="" onclick="smartPop.close();return false;">X</a>
			</div>
		</div>
		<div class="solid_line"></div>
	</div>
	<!-- 팝업 타이틀 //-->
	<!-- 컨텐츠 -->
	<form name="frmNewWorkDefinition" class="js_validation_required">
		<div class="contents_space">
			<table>
				<%
				if(SmartUtil.isBlankObject(workId)){
				%>
					<tr>
						<td><fmt:message key="builder.title.category_name" /></td>
						<td>
							<input readonly class="fieldline" type="text" value="<%=parentName%>">		
						</td>
					</tr>
				<%
				}
				%>
				<tr>
					<td><fmt:message key="builder.title.work_name" /><span class="essen_n"></span></td>
					<td>
						<input name="txtWorkName" class="fieldline required" type="text" value="<%=CommonUtil.toNotNull(workName)%>">		
					</td>
				</tr>
				<%
				if(SmartUtil.isBlankObject(workId)){
				%>				
					<tr>
						<td><fmt:message key="builder.title.work_type" /></td>
						<td>
							<input name="chkWorkType" class="required" type="checkbox" value="<%=SmartWork.TYPE_INFORMATION%>"><fmt:message key="common.title.information_work"/>	
							<input name="chkWorkType" class="required" type="checkbox" value="<%=SmartWork.TYPE_PROCESS%>"><fmt:message key="common.title.process_work"/>	
							<input name="chkWorkType" class="required" type="checkbox" value="<%=SmartWork.TYPE_SCHEDULE%>"><fmt:message key="common.title.schedule_work"/>	
							<input name="chkWorkType" class="required" type="checkbox" value="<%=WorkCategory.TYPE_CATEGORY%>"><fmt:message key="common.title.work_group"/>	
						</td>
					</tr>
				<%
				}else{
					WorkInfo[] workCategories = smartWorks.getAllWorksByCategoryId("");
				%>
					<tr>
						<td><fmt:message key="builder.title.category_name"/></td>
						<td>
							<select name="selWorkCategoryId">
								<%
								if(!SmartUtil.isBlankObject(workCategories)){
									for(WorkInfo category : workCategories){
										if(category.getType()!= WorkCategory.TYPE_CATEGORY) continue;
								%>
										<option value="<%=category.getId()%>" <%if(category.getId().equals(categoryId)){%>selected<%} %>><%=category.getName() %></option>
								<%
									}
								}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<td><fmt:message key="builder.title.group_name"/></td>
						<td>
							<select name="selWorkGroupId">
								<%
								if(!SmartUtil.isBlankObject(groupId)){
									WorkInfo[] groups = smartWorks.getAllWorksByCategoryId(groupId);
									if(!SmartUtil.isBlankObject(groups)){
										for(WorkInfo group : groups){
											if(group.getType()!= WorkCategory.TYPE_CATEGORY) continue;
								%>
											<option value="<%=group.getId()%>" <%if(group.getId().equals(groupId)){%>selected<%} %>><%=group.getName() %></option>
								<%
										}
									}
								}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<td><fmt:message key="builder.title.work_type" /></td>
						<td>
							<input type="text" readonly value="<%=CommonUtil.toNotNull(workTypeName)%>">	
						</td>
					</tr>
				<%
				}
				%>
				<tr>
					<td><fmt:message key="common.title.desc" /></td>
					<td>
						<textarea name="txtaWorkDesc" class="fieldline" rows="4"><%=CommonUtil.toNotNull(workDesc) %></textarea>	
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 컨텐츠 //-->
	<!-- 버튼 영역 -->
	<div class="glo_btn_space">
		<div class="float_right padding_r10">
			<!-- 실행시 데이터 유효성 검사이상시 에러메시지를 표시할 공간 -->
			<span class="form_space sw_error_message js_pop_error_message" style="text-align:right; color: red"></span>
			<!--  실행시 표시되는 프로그래스아이콘을 표시할 공간 -->
			<span class="js_progress_span float_right"></span>
			<span class="btn_gray">
				<a href="" onclick='submitForms(); return false;'>
					<span class="Btn01Start"></span>
					<%
					if(SmartUtil.isBlankObject(workId)){
					%>
						<span class="Btn01Center"><fmt:message key="common.button.create"/></span>
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
			 <span class="btn_gray space_l5"> 
				 <a href="" class="js_close_new_work"> 
				 	<span class="Btn01Start"></span>
				 	<span class="Btn01Center"><fmt:message key="common.button.cancel"/></span>
				 	<span class="Btn01End"></span> 
				 </a>
			</span>
		</div>
	</div>
	<!-- 버튼 영역 //-->

</div>
<!-- 전체 레이아웃//-->