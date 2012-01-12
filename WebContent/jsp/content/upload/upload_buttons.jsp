
<!-- Name 			: upload_buttons.jsp											 -->
<!-- Description	: 새로운 업무나 파일들을 올릴때 사용되는 버튼들(공간 및 권한지정 포함)       -->
<!-- Author			: Maninsoft, Inc.												 -->
<!-- Created Date	: 2011.9.														 -->

<%@page import="net.smartworks.model.community.info.CommunityInfo"%>
<%@page import="net.smartworks.model.community.Group"%>
<%@page import="net.smartworks.model.security.AccessPolicy"%>
<%@page import="net.smartworks.model.community.Department"%>
<%@page import="net.smartworks.model.community.Community"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	// 호출하면서 설정된 WorkSpace ID 및 Work ID 를 가져온다..
	String wid = request.getParameter("wid");
	if (SmartUtil.isBlankObject(wid))
		wid = cUser.getId();
	String workId = request.getParameter("workId");
	
	// 실행한 업무에 대한 정보들을 가져온다.. 업무의 권한정보를 설정할 때 사용된다..
	SmartWork work = (SmartWork)smartWorks.getWorkById(workId);
	if (SmartUtil.isBlankObject(work))
		work = new SmartWork();
	
	// 현재 사용자가 속해있는 부서나 커뮤너티 목록들을 가져온다..
	CommunityInfo[] communities = smartWorks.getMyCommunities();
%>

<div class="glo_btn_space">

	<!--  완료 및 취소 버튼 -->
	<div class="float_right">
		<span class="btn_gray"> 
			<!--  완료버튼을 클릭시 해당 업로드 화면페이지에 있는 submitForms()함수를 실행한다.. -->
			<a href="" onclick='submitForms();return false;'> 
				<span class="Btn01Start"></span>
				<span class="Btn01Center"><fmt:message key="common.button.complete"/></span> 
				<span class="Btn01End"></span> 
			</a>
		</span> 
				
		<span class="btn_gray">
			<!--  취소버튼을 클릭시 sw_act_work 에서 click event 로 정의 되어있는 함수를 실행한다... -->
			<a href="" class="js_cancel_action"> 
				<span class="Btn01Start"></span> 
				<span class="Btn01Center"><fmt:message key="common.button.cancel" /></span> 
				<span class="Btn01End"></span> 
			</a> 
		</span>
	</div>
	<!--  완료 및 취소 버튼 //-->

	<!--  접근권한 및 등록할 공간정보를 선택하는 박스들 -->
	<form name="frmAccessSpace" class="float_right padding_r10">
		<div id="" class="float_right form_space">
		
			<!--  현재사용자가 선택할 수 있는 업무공간들을 구성한다.. -->
			<select name="selWorkSpace">
				<option  value="<%=cUser.getId()%>">
					<fmt:message key="common.upload.space.self" />
				</option>
				<optgroup
					label="<fmt:message key="common.upload.space.department"/>">
					<%
					// 현재사용자가 속해있는 부서들을 선택하는 옵션들을 구성한다..
					for (CommunityInfo community : communities) {
						if (community.getClass().equals(Department.class)) {
					%>
							<option value="<%=community.getId()%>"><%=community.getName()%></option>
					<%
						}
					}
					%>
				</optgroup>
				<optgroup label="<fmt:message key="common.upload.space.group"/>">
					<%
					// 현재사용자가 속해있는 그룹들을 선택하는 옵션들을 구성한다..
					for (CommunityInfo community : communities) {
						if (community.getClass().equals(Group.class)) {
					%>
							<option value="<%=community.getId()%>"><%=community.getName()%></option>
					<%
						}
					}
					%>
				</optgroup>
			</select>
		</div>

		<div id="" class="float_right form_space">
			<!--  현재업무의 접근(읽기)권한 중에 선택가능한 권한들을 구성한다... -->
			<select name="selAccessLevel">
				<%
				// 읽기권한이 공개 이면, 공개, 비공개, 사용자 지정중에 선택할 수 있다..
				int accessLevel = work.getAccessPolicy().getLevel();
				if (accessLevel == AccessPolicy.LEVEL_PUBLIC) {
				%>
					<option selected value="<%=AccessPolicy.LEVEL_PUBLIC%>"><fmt:message key="common.security.access.public" /></option>
					<option value="<%=AccessPolicy.LEVEL_PRIVATE%>"><fmt:message key="common.security.access.private" /></option>
					<option value="<%=AccessPolicy.LEVEL_CUSTOM%>"><fmt:message key="common.security.access.custom" /></option>
				<%
				// 읽기권한이 사용자지정이면, 비공개 또는 사용자지정 중에서 선택할 수 있다..
				} else if (work.getAccessPolicy().getLevel() == AccessPolicy.LEVEL_CUSTOM) {
				%>
					<option value="<%=AccessPolicy.LEVEL_PRIVATE%>"><fmt:message key="common.security.access.private" /></option>
					<option selected value="<%=AccessPolicy.LEVEL_CUSTOM%>"><fmt:message key="common.security.access.custom" /></option>
				<%
				// 읽기권한이 비공개이면, 비공개만 해당된다...
				} else if (work.getAccessPolicy().getLevel() == AccessPolicy.LEVEL_PUBLIC) {
				%>
					<option value="<%=AccessPolicy.LEVEL_PRIVATE%>"><fmt:message key="common.security.access.private" /></option>
				<%
				}
				%>
			</select>
		</div>
		
		<!--  실행시 표시되는 프로그래스아이콘을 표시할 공간 -->
		<div class="float_right form_space js_progress_span" ></div>
		
		<!-- 실행시 데이터 유효성 검사이상시 에러메시지를 표시할 공간 -->
		<span class="fload_right form_space" style="text-align:right; color: red" id="error_message_span"></span>
	</form>
	<!--  접근권한 및 등록할 공간정보를 선택하는 박스들 //-->
</div>
