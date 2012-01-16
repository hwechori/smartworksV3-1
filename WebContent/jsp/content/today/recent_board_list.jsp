
<!-- Name 			: recent_board_list.jsp									 -->
<!-- Description	: 현재사용자에게 해당되는 최근 공지사항들 5개만 나타내주는 화면 	 -->
<!-- Author			: Maninsoft, Inc.										 -->
<!-- Created Date	: 2011.9.												 -->

<%@page import="net.smartworks.model.community.info.DepartmentInfo"%>
<%@page import="net.smartworks.model.community.info.GroupInfo"%>
<%@page import="net.smartworks.model.community.info.WorkSpaceInfo"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.instance.info.BoardInstanceInfo"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.calendar.*"%>
<%@ page import="net.smartworks.util.*"%>
<%@ page import="net.smartworks.model.instance.*"%>
<%@ page import="net.smartworks.model.community.*"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다 
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	// 현재사용자에게 해당되는 최근 5개의 공지사항을 가져온다.... 
	BoardInstanceInfo[] boards = smartWorks.getMyRecentBoardInstances();
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="notice">
	<%
	// 공지사항이 있으면 화면을 그린다...
	if(boards != null && boards.length>0){
		
		// 처음 공지사항은 최근 것이므로 별도로 왼쪽에 내용미리보기와 함께 표시하기 위해 분리한다...
		BoardInstanceInfo board = boards[0];
		WorkSpaceInfo workSpace = board.getWorkSpace();
		String workSpaceIco = "";
		UserInfo owner = board.getOwner();
		String boardContext = ISmartWorks.CONTEXT_PREFIX_BOARD_SPACE + board.getId();
		// 커뮤너티 타입(그룹, 부서)에 따라 공간아이콘값을 가져온다...
		if(workSpace.getClass().equals(GroupInfo.class))
			workSpaceIco = "images/ico_group_s.gif";
		else if(workSpace.getClass().equals(DepartmentInfo.class))
			workSpaceIco = "images/ico_division_s.gif";
	
	%>
		<!-- 처음게시판(헤드라인 공지사항)을 표시한다 -->
		<div class="headlineNotice">
			<a href="board_list.sw?cid=<%=boardContext%>wid=<%=workSpace.getId() %>" class="more"><fmt:message key="common.button.view_all"/></a>
			<a href="board_space.sw?cid=<%=boardContext%>">
				<span class="title"><%=board.getSubject() %></span>
				<span class="index">
					<span class="t_name"><%=board.getOwner().getLongName() %></span> 
					<span class="arr">▶</span>
					<img src="<%=workSpaceIco%>"><%if(!workSpaceIco.equals("")){%><%=workSpace.getName() %><%} %>
					<span class="date t_date"><%=board.getLastModifiedDate().toLocalString() %></span>
				</span>
				<span class="info"></span>
				<span class="content"><%=board.getBriefContent() %></span>
			</a>
		</div>
		<!-- 처음게시판(헤드라인 공지사항)을 표시한다 //-->

		<!-- 나머지 4개를 리스트로 표시한다 -->
		<div class="recentNotice">
			<table>
				<%
				for(int i=1; i<boards.length; i++) {
					board = boards[i];
					workSpace = board.getWorkSpace();
					boardContext = ISmartWorks.CONTEXT_PREFIX_BOARD_SPACE + board.getId();
					if(workSpace.getClass().equals(GroupInfo.class))
						workSpaceIco = "images/ico_group_s.gif";
					else if(workSpace.getClass().equals(DepartmentInfo.class))
						workSpaceIco = "images/ico_division_s.gif";
					else
						workSpaceIco = "";
				%>			
					<tr>
						<td class="title"><a href="board_space.sw?cid=<%=boardContext%>"><%=board.getSubject()%></a> 
							<span class="t_name"><%=board.getOwner().getLongName() %></span> 
							<span class="arr">▶</span>
							<img src="<%=workSpaceIco%>"><%if(!workSpaceIco.equals("")){%><%=workSpace.getName()%><%} %>
						</td>
						<td class="date t_date"><%=board.getLastModifiedDate().toLocalString() %></td>
					</tr>
				<%
				}
				%>
			</table>
		</div>
		<!-- 나머지 4개를 리스트로 표시한다 //-->
	<%
	}
	%>
</div>
