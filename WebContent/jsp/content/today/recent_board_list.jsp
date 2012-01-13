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
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");

	BoardInstanceInfo[] boards = smartWorks.getBoardInstances(new LocalDate(), 5);
%>
<!-- 공지사항 정연희 추가 style begin-->
<div class="notice">
	<%
	if(boards != null && boards.length>0){
		BoardInstanceInfo board = boards[0];
		WorkSpaceInfo workSpace = board.getWorkSpace();
		String workSpaceIco = "";
		UserInfo owner = board.getOwner();
		String boardContext = ISmartWorks.CONTEXT_PREFIX_BOARD_SPACE + board.getId();
		if(workSpace.getClass().equals(GroupInfo.class))
			workSpaceIco = "images/ico_group_s.gif";
		else if(workSpace.getClass().equals(DepartmentInfo.class))
			workSpaceIco = "images/ico_division_s.gif";
	
	%>
		<div class="headlineNotice">
			<a href="board_list.sw?cid=<%=boardContext%>wid=<%=workSpace.getId() %>" class="more">전체보기</a>
			<a href="board_space.sw?cid=<%=boardContext%>">
				<span class="title"><%=board.getSubject() %></span>
				<span class="index"><img class="profile_size_s" src="<%=board.getOwner().getMinPicture()%>">
					<span class="t_name"><%=board.getOwner().getLongName() %></span> 
					<span class="arr">▶</span>
					<img src="<%=workSpaceIco%>"><%if(!workSpaceIco.equals("")){%><%=workSpace.getName() %><%} %>
					<span class="date t_date"><%=board.getLastModifiedDate().toLocalString() %></span>
				</span>
				<span class="info"></span>
				<span class="content"><%=board.getBriefContent() %></span>
			</a>
		</div>
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
							<img class="profile_size_s" src="<%=board.getOwner().getMinPicture()%>"><span class="t_name"><%=board.getOwner().getLongName() %></span> 
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
	<%
	}
	%>
</div>
<!-- 공지사항 정연희 추가 style end-->
