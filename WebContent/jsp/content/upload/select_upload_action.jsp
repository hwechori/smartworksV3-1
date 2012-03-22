
<!-- Name 			: select_upload_action.jsp										 -->
<!-- Description	: 새롭게 시작하거나 올리고자 하는 업무들 선택하는 아이콘들        			 -->
<!-- Author			: Maninsoft, Inc.												 -->
<!-- Created Date	: 2011.9.														 -->

<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	int spaceType = SmartUtil.getSpaceTypeFromContentContext((String)session.getAttribute("cid"));
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<%
switch(spaceType){
case ISmartWorks.SPACE_TYPE_MEMO_LIST:
%>
	<!--  업로드할 항목(새업무, 사진, 파일, 이벤트, 메모, 공지)을 선택하는 아이콘들  -->
	<div id="upload" class="js_select_action js_select_upload_action_page">
		<div class="up_memo up_icon_list">
			<a class="current" href="new_memo.sw"><fmt:message key='common.upload.memo' /> </a>
		</div>
	</div>
	<!--  업로드할 항목(새업무, 사진, 파일, 이벤트, 메모, 공지)을 선택하는 아이콘들 // -->
	
	<!-- 새업무 등록시에는 업무를 선택하는 자동검색 및 전체업무찾기 버튼을 을 보여준다... -->
	<div class="upload_up_wrap js_upload_form" id="upload_form_box">
		<jsp:include page="/jsp/content/work/start/new_memo.jsp" />
	</div>
	<!-- 새업무 등록시에는 업무를 선택하는 자동검색 및 전체업무찾기 버튼을 을 보여준다... //-->
<%
	break;
case ISmartWorks.SPACE_TYPE_IMAGE_LIST:
	%>
	<!--  업로드할 항목(새업무, 사진, 파일, 이벤트, 메모, 공지)을 선택하는 아이콘들  -->
	<div id="upload" class="js_select_action js_select_upload_action_page">
		<div class="up_pic up_icon_list">
			<a class="current" href="new_picture.sw"><fmt:message key='common.upload.picture' /> </a>
		</div>
	</div>
	<!--  업로드할 항목(새업무, 사진, 파일, 이벤트, 메모, 공지)을 선택하는 아이콘들 // -->
	
	<!-- 새업무 등록시에는 업무를 선택하는 자동검색 및 전체업무찾기 버튼을 을 보여준다... -->
	<div class="upload_up_wrap js_upload_form" id="upload_form_box">
		<jsp:include page="/jsp/content/work/start/new_picture.jsp" />
	</div>
	<!-- 새업무 등록시에는 업무를 선택하는 자동검색 및 전체업무찾기 버튼을 을 보여준다... //-->
<%
	break;
case ISmartWorks.SPACE_TYPE_FILE_LIST:
	%>
	<!--  업로드할 항목(새업무, 사진, 파일, 이벤트, 메모, 공지)을 선택하는 아이콘들  -->
	<div id="upload" class="js_select_action js_select_upload_action_page">
		<div class="up_file up_icon_list">
			<a class="current" href="new_file.sw"><fmt:message key='common.upload.file' /> </a>
		</div>	
	</div>
	<!--  업로드할 항목(새업무, 사진, 파일, 이벤트, 메모, 공지)을 선택하는 아이콘들 // -->
	
	<!-- 새업무 등록시에는 업무를 선택하는 자동검색 및 전체업무찾기 버튼을 을 보여준다... -->
	<div class="upload_up_wrap js_upload_form" id="upload_form_box">
		<jsp:include page="/jsp/content/work/start/new_file.jsp" />
	</div>
	<!-- 새업무 등록시에는 업무를 선택하는 자동검색 및 전체업무찾기 버튼을 을 보여준다... //-->
<%
	break;
case ISmartWorks.SPACE_TYPE_EVENT_LIST:
	%>
	<!--  업로드할 항목(새업무, 사진, 파일, 이벤트, 메모, 공지)을 선택하는 아이콘들  -->
	<div id="upload" class="js_select_action js_select_upload_action_page">
		<div class="up_event up_icon_list">
			<a class="current" href="new_event.sw"><fmt:message key='common.upload.event' /></a>
		</div>
	</div>
	<!--  업로드할 항목(새업무, 사진, 파일, 이벤트, 메모, 공지)을 선택하는 아이콘들 // -->
	
	<!-- 새업무 등록시에는 업무를 선택하는 자동검색 및 전체업무찾기 버튼을 을 보여준다... -->
	<div class="upload_up_wrap js_upload_form" id="upload_form_box">
		<jsp:include page="/jsp/content/work/start/new_event.jsp" />
	</div>
	<!-- 새업무 등록시에는 업무를 선택하는 자동검색 및 전체업무찾기 버튼을 을 보여준다... //-->
<%
	break;
case ISmartWorks.SPACE_TYPE_BOARD_LIST:
	%>
	<!--  업로드할 항목(새업무, 사진, 파일, 이벤트, 메모, 공지)을 선택하는 아이콘들  -->
	<div id="upload" class="js_select_action js_select_upload_action_page">
		<div class="up_board up_icon_list">
			<a class="current" href="new_board.sw"><fmt:message key='common.upload.board' /></a>
		</div>
	</div>
	<!--  업로드할 항목(새업무, 사진, 파일, 이벤트, 메모, 공지)을 선택하는 아이콘들 // -->
	
	<!-- 새업무 등록시에는 업무를 선택하는 자동검색 및 전체업무찾기 버튼을 을 보여준다... -->
	<div class="upload_up_wrap js_upload_form" id="upload_form_box">
		<jsp:include page="/jsp/content/work/start/new_board.jsp" />
	</div>
	<!-- 새업무 등록시에는 업무를 선택하는 자동검색 및 전체업무찾기 버튼을 을 보여준다... //-->
<%
	break;
case ISmartWorks.SPACE_TYPE_AWORK_LIST:
	%>
	<!--  업로드할 항목(새업무, 사진, 파일, 이벤트, 메모, 공지)을 선택하는 아이콘들  -->
	<div id="upload" class="js_select_action js_select_upload_action_page">
		<div class="up_works up_icon_list">
			<a class="current" href="start_work.sw"><fmt:message key='common.upload.work' /></a>
		</div>
	</div>
	<!--  업로드할 항목(새업무, 사진, 파일, 이벤트, 메모, 공지)을 선택하는 아이콘들 // -->
	
	<!-- 새업무 등록시에는 업무를 선택하는 자동검색 및 전체업무찾기 버튼을 을 보여준다... -->
	<div class="upload_up_wrap js_upload_form" id="upload_form_box">
		<jsp:include page="/jsp/content/upload/start_work.jsp" />
	</div>
	<!-- 새업무 등록시에는 업무를 선택하는 자동검색 및 전체업무찾기 버튼을 을 보여준다... //-->
<%
	break;
default:
%>
	<!--  업로드할 항목(새업무, 사진, 파일, 이벤트, 메모, 공지)을 선택하는 아이콘들  -->
	<div id="upload" class="js_select_action js_select_upload_action_page">
		<div class="up_memo up_icon_list">
			<a class="current" href="new_memo.sw"><fmt:message key='common.upload.memo' /> </a>
		</div>
		<div class="up_pic up_icon_list">
			<a href="new_picture.sw"><fmt:message key='common.upload.picture' /> </a>
		</div>
		<div class="up_file up_icon_list">
			<a href="new_file.sw"><fmt:message key='common.upload.file' /> </a>
		</div>	
		<%
		// 실행되는 위치가 태스크 공간일 경우에는 이벤트등록하는 기능은 제외한다...
		if(spaceType != ISmartWorks.SPACE_TYPE_WORK_INSTANCE 
			&& spaceType != ISmartWorks.SPACE_TYPE_TASK_INSTANCE) {
		%>
			<div class="up_event up_icon_list">
				<a href="new_event.sw"><fmt:message key='common.upload.event' /></a>
			</div>
		<%
		} 
		%>
		<% 
		// 실행되는 위치가 태스크 공간일 경우에는 공지등록하는 기능을 제외한다....
		if(spaceType != ISmartWorks.SPACE_TYPE_WORK_INSTANCE 
			&& spaceType != ISmartWorks.SPACE_TYPE_TASK_INSTANCE 
			&& spaceType != ISmartWorks.SPACE_TYPE_USER) {
		%>
			<div class="up_board up_icon_list">
				<a href="new_board.sw"><fmt:message key='common.upload.board' /></a>
			</div>
		<%
		} 
		%>
		<div class="up_works up_icon_list">
			<a href="start_work.sw"><fmt:message key='common.upload.work' /></a>
		</div>
	</div>
	<!--  업로드할 항목(새업무, 사진, 파일, 이벤트, 메모, 공지)을 선택하는 아이콘들 // -->
	
	<!-- 새업무 등록시에는 업무를 선택하는 자동검색 및 전체업무찾기 버튼을 을 보여준다... -->
	<div class="upload_up_wrap js_upload_form" id="upload_form_box">
		<jsp:include page="/jsp/content/work/start/new_memo.jsp" />
	</div>
	<!-- 새업무 등록시에는 업무를 선택하는 자동검색 및 전체업무찾기 버튼을 을 보여준다... //-->
<%
}
%>	