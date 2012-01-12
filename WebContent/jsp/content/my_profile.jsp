
<!-- Name 			: my_profile.jsp										 -->
<!-- Description	: 현재사용자 프로파일 정보를 조회하고 수정하는 화면 				 -->
<!-- Author			: Maninsoft, Inc.										 -->
<!-- Created Date	: 2011.9.												 -->

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

	// 사용가능한 타임존들을 가져와서, 타임존 선택박스에 리스트로 보여준다.
	KeyMap[] timeZoneNames = LocalDate.getAvailableTimeZoneNames(cUser.getLocale());
%>
<script type="text/javascript">

	// 개인정보프로파일 수정하기 버튼을 클릭하면, 
	// 모든정보를 JSON형식으로 Serialize해서 서버의 update_my_profile.sw 서비스를 호출하여 수정한다.
	function submitForms(e) {
		var myProfile = $('.js_my_profile_page');
		if (SmartWorks.GridLayout.validate(myProfile.find('form.js_validation_required'))) {
			var forms = myProfile.find('form');
			var paramsJson = {};
			for(var i=0; i<forms.length; i++){
				var form = $(forms[i]);
				if(form.attr('name') === 'frmSmartForm'){
					paramsJson['formId'] = form.attr('formId');
					paramsJson['formName'] = form.attr('formName');
				}
				paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
			}
			console.log(JSON.stringify(paramsJson));
			var url = "update_my_profile.sw";
			var progressSpan = myProfile.find('.js_progress_span');
			smartPop.progressCont(progressSpan);
			$.ajax({
				url : url,
				contentType : 'application/json',
				type : 'POST',
				data : JSON.stringify(paramsJson),
				success : function(data, status, jqXHR) {
					// 사용자정보 수정이 정상적으로 완료되었으면, 현재 페이지에 그대로 있는다.
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.INFORM, smartMessage.get('setMyProfileSucceed'));
				},
				error : function(e) {
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.ERROR, smartMessage.get('setMyProfileError'));
				}
			});
		}
	};
</script>

<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 컨텐츠 레이아웃-->
<div class="section_portlet js_my_profile_page">
	<div class="portlet_t">
		<div class="portlet_tl"></div>
	</div>
	<div class="portlet_l" style="display: block;">
		<ul class="portlet_r" style="display: block;">

			<!-- 타이틀 -->
			<div class="body_titl">
				<div class="body_titl_iworks title"><fmt:message key="content.title.my_profile"></fmt:message></div>

				<!-- 우측 버튼 -->
				<div class="txt_btn">
					<div class="po_right essen_gn"><fmt:message key="profile.title.required_field" /></div>
				</div>
				<!-- 우측 버튼 //-->
				<div class="solid_line"></div>
			</div>
			<!-- 타이틀 -->
			
			<!-- 컨텐츠 -->
			<form name="frmMyProfileSetting" class="js_validation_required">
				<div class="contents_space">
					<div class="photo_section">
					
						<!--  *** js_my_profile_field : sw_act_work.js에서 화면로딩이 완료되면 이 클래스로 찾아서,  	-->
						<!--      현재사용자의 사진을 보여주고, 다른 사진을 올리줄 있도록하는 기능을 제공한다. 			-->
						<div class="js_my_profile_field js_auto_load_profile"></div>
						<div class="t_text_s11"><fmt:message key="profile.title.size_desc"/></div>
					</div>					
					<span class="table_nomal600 ">
						<table>
							<tr>
								<td><fmt:message key="profile.title.user_id" /></td>
								<td>
									<input name="txtUserProfileUserId" type="text" readonly="readonly"
										value="<%=CommonUtil.toNotNull(cUser.getId())%>">
								</td>
							</tr>		
							<tr>
								<td><fmt:message key="profile.title.user_name" /><span class="essen_n"></span></td>
								<td>
									<input name="txtUserProfileUserName" class="fieldline required" type="text" value="<%=CommonUtil.toNotNull(cUser.getName())%>">		
								</td>
							</tr>
							<tr>
								<td><fmt:message key="profile.title.employee_id" /></td>
								<td>
									<input name="txtUserProfileEmpId" class="fieldline" type="text" value="<%=CommonUtil.toNotNull(cUser.getEmployeeId())%>">		
								</td>
							</tr>		
							<tr>
								<td><fmt:message key="profile.title.password" /><span class="essen_n"></span></td>
								<td>
									<input name="pwUserProfilePW" class="fieldline required" type="password" value="<%=CommonUtil.toNotNull(cUser.getPassword())%>">		
								</td>
							</tr>
							<tr>
								<td><fmt:message key="profile.title.password_confirm" /><span class="essen_n"></span></td>
								<td>
									<input name="pwUserProfilePWCfm" type="password" class="required fieldline" value="<%=CommonUtil.toNotNull(cUser.getPassword())%>">		
								</td>
							</tr>
							<tr>
								<td><fmt:message key="profile.title.department" /><span class="essen_n"></span></td>
								<td>
									<input name="txtUserProfileDepartment" type="text" class="required fieldline" companyId="<%=cUser.getCompanyId()%>" value="<%=CommonUtil.toNotNull(cUser.getDepartment())%>">		
								</td>
							</tr>
							<tr>
								<td><fmt:message key="profile.title.position" /><span class="essen_n"></span></td>
								<td>
									<input name="txtUserProfilePosition" type="text" class="required fieldline" value="<%=CommonUtil.toNotNull(cUser.getPosition())%>">		
								</td>
							</tr>
							<tr>
								<td><fmt:message key="profile.title.locale" /><span class="essen_n"></span></td>
								<td>
									<select name="selUserProfileLocale">
										<%
										for (String locale : LocaleInfo.supportingLocales) {
											String strKey = "common.title.locale." + locale;
										%>
											<option value="<%=locale%>" <%if (cUser.getLocale().equals(locale)) {%> selected <%}%>><fmt:message key="<%=strKey%>" /></option>
										<%
										}
										%>
									</select>
								</td>
							</tr>
							<tr>
								<td><fmt:message key="profile.title.timezone" /><span class="essen_n"></span></td>
								<td>
									<select name="selUserProfileTimeZone">
										<%
										for (KeyMap timeZoneName : timeZoneNames) {
										%>
											<option value="<%=timeZoneName.getId()%>" <%if (cUser.getTimeZone().equals(timeZoneName.getId())) {%> selected <%}%>><%=timeZoneName.getKey()%></option>
										<%
										}
										%>
									</select>
								</td>
							</tr>
							<tr>
								<td><fmt:message key="profile.title.phone_no" /></td>
								<td>
									<input name="txtUserProfilePhoneNo" class="fieldline" type="text" value="<%=CommonUtil.toNotNull(cUser.getPhoneNo())%>" title="">
								</td>
							</tr>
							<tr>
								<td><fmt:message key="profile.title.cell_phone_no" /></td>
								<td>
									<input name="txtUserProfileCellNo" class="fieldline" type="text" value="<%=CommonUtil.toNotNull(cUser.getCellPhoneNo())%>" title="">
								</td>
							</tr>
						</table>
					</span>
				</form>
			</div>
			<!-- 컨텐츠 //-->
			
			<!-- 버튼 영역 -->
			<div class="glo_btn_space">
				<div class="float_right padding_r10">
					<!-- 실행시 데이터 유효성 검사이상시 에러메시지를 표시할 공간 -->
					<span class="fload_right form_space" style="text-align:right; color: red" id="error_message_span"></span>
					<!--  실행시 표시되는 프로그래스아이콘을 표시할 공간 -->
					<span class="js_progress_span"></span>
					<span class="btn_gray">
						<a href="" onclick='submitForms(); return false;'>
							<span class="Btn01Start"></span>
							<span class="Btn01Center"><fmt:message key="popup.button.modify_my_profile"/></span>
							<span class="Btn01End"></span>
						</a> 
					</span>
					 <span class="btn_gray space_l5"> 
						 <a href="" onclick="return true;"> 
						 	<span class="Btn01Start"></span>
						 	<span class="Btn01Center"><fmt:message key="common.button.cancel"/></span>
						 	<span class="Btn01End"></span> 
						 </a>
					</span>
				</div>
			</div>
			<!-- 버튼 영역 //-->
						
		</ul>
	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 컨텐츠 레이아웃//-->		
