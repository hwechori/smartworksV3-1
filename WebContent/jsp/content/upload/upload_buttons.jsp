
<!-- Name 			: upload_buttons.jsp											 -->
<!-- Description	: 새로운 업무나 파일들을 올릴때 사용되는 버튼들(공간 및 권한지정 포함)       -->
<!-- Author			: Maninsoft, Inc.												 -->
<!-- Created Date	: 2011.9.														 -->

<%@page import="net.smartworks.model.community.info.GroupInfo"%>
<%@page import="net.smartworks.model.community.info.DepartmentInfo"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
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

	String cid = (String)session.getAttribute("cid");
	String wid = (String)session.getAttribute("wid");

	// cid를 가지고 현재 공간의 타입을 가져온다.
	int spaceType = SmartUtil.getSpaceTypeFromContentContext(cid);
	
	// 호출하면서 설정된 Work ID와 Instance ID 를 가져온다..
	String workId = request.getParameter("workId");
	String instId = request.getParameter("instId");
	
	// 홈이아닌 업무공간에서 실행되었으면 세션어트리뷰터에 저장된 work object를 가져오고,
	// 그렇지 않으면 workId로 업무에 대한 정보들을 가져온다.. 업무의 권한정보를 설정할 때 사용된다..
	SmartWork work = (SmartWork)session.getAttribute("smartWork");
	if(SmartUtil.isBlankObject(work) || work.getId().equals(workId))
		work = (SmartWork)smartWorks.getWorkById(workId);
	if (SmartUtil.isBlankObject(work))
		work = new SmartWork();
	
	// 현재 사용자가 속해있는 부서나 커뮤너티 목록들을 가져온다..
	CommunityInfo[] communities = smartWorks.getMyCommunities();
%>

<div class="glo_btn_space js_upload_buttons_page">

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
	<form name="frmAccessSpace" class="float_right padding_r10 js_validation_required">
		<div id="" class="float_right form_space">
		
			<!--  현재사용자가 선택할 수 있는 업무공간들을 구성한다.. -->
			<%
			if((spaceType == ISmartWorks.SPACE_TYPE_DEPARTMENT)
				|| (spaceType == ISmartWorks.SPACE_TYPE_GROUP)
				|| (spaceType == ISmartWorks.SPACE_TYPE_USER)){
			%>
				<input name="selWorkSpace" type="hidden" value="<%=wid%>">
			<%
			}else if(spaceType == ISmartWorks.SPACE_TYPE_WORK_INSTANCE){
			%>
				<input name="selWorkSpace" type="hidden" value="<%=instId%>">
			<%
			}else{
			%>
				<select name="selWorkSpace">
					<option  value="<%=cUser.getId()%>"><fmt:message key="common.upload.space.self" /></option>
					<optgroup label="<fmt:message key="common.upload.space.department"/>">
						<%
						// 현재사용자가 속해있는 부서들을 선택하는 옵션들을 구성한다..
						for (CommunityInfo community : communities) {
							if (community.getClass().equals(DepartmentInfo.class)) {
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
							if (community.getClass().equals(GroupInfo.class)) {
						%>
								<option value="<%=community.getId()%>"><%=community.getName()%></option>
						<%
							}
						}
						%>
					</optgroup>
				</select>
			<%
			}
			%>
		</div>

		<div id="" class="float_right form_space">
			<!--  현재업무의 접근(읽기)권한 중에 선택가능한 권한들을 구성한다... -->
			<select name="selAccessLevel" class="js_select_access_level">
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
				} else if (accessLevel == AccessPolicy.LEVEL_CUSTOM) {
				%>
					<option value="<%=AccessPolicy.LEVEL_PRIVATE%>"><fmt:message key="common.security.access.private" /></option>
					<option selected value="<%=AccessPolicy.LEVEL_CUSTOM%>"><fmt:message key="common.security.access.custom" /></option>
				<%
				// 읽기권한이 비공개이면, 비공개만 해당된다...
				} else if (accessLevel == AccessPolicy.LEVEL_PRIVATE) {
				%>
					<option value="<%=AccessPolicy.LEVEL_PRIVATE%>"><fmt:message key="common.security.access.private" /></option>
				<%
				}
				%>
			</select>
		</div>

		<!-- 접근권한이 사용자지정인 경우에 공개할 사용자들을 선택하는 화면 -->
		<div class="float_right form_space js_access_level_custom" <%if(work.getAccessPolicy().getLevel() != AccessPolicy.LEVEL_CUSTOM){ %> style="display:none"<%} %>>
			<span class="js_type_userField" fieldId="txtAccessableUsers" multiUsers="true">
				<div class="form_value">
					<div class="ico_fb_space">
						<div class="fieldline js_community_names sw_required">
							<div class="js_selected_communities user_sel_area">
								<%
								if(!SmartUtil.isBlankObject(work.getAccessPolicy().getCommunitiesToOpen())){
									String comName = "";
									for(CommunityInfo community : work.getAccessPolicy().getCommunitiesToOpen()){	
										if(community.getClass().equals(UserInfo.class))
											comName = ((UserInfo)community).getLongName();
										else 
											comName = community.getName();
									%>
										<span>
											<span class="js_community_item user_select" comId="<%=community.getId()%>"><%=comName %>
												<span class='btn_x_gr'><a class='js_remove_community' href=''> x</a></span>
											</span>
										</span>
									<%
									}
								}
								%>
							</div>
							<input class="js_auto_complete" href="community_name.sw" type="text">
							<div class="js_srch_x"></div>
						</div>
						<div class="js_community_list commu_list" style="display: none"></div>
						<span class="js_community_popup"></span><a href="" class="js_userpicker_button"><span class="ico_fb_users"></span></a>
					</div>
				</div>
			</span>
		</div>
		<!-- 접근권한이 사용자지정인 경우에 공개할 사용자들을 선택하는 화면 //-->
		
		<!--  실행시 표시되는 프로그래스아이콘을 표시할 공간 -->
		<div class="float_right form_space js_progress_span" ></div>
		
		<!-- 실행시 데이터 유효성 검사이상시 에러메시지를 표시할 공간 -->
		<span class="float_right form_space" style="text-align:right; color: red" id="error_message_span"></span>
	</form>
	<!--  접근권한 및 등록할 공간정보를 선택하는 박스들 //-->
</div>
