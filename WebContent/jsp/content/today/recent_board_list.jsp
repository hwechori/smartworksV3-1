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
	String companyId = (String) session.getAttribute("companyId");
	String userId = (String) session.getAttribute("userId");
	
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser(request);

	BoardInstanceInfo[] boards = smartWorks.getBoardInstances(companyId, userId, new LocalDate(), 5);
%>
<!-- 공지사항 -->
<div id="notice">
	<ul>
		<%
		if(boards != null){
			for (BoardInstanceInfo board : boards) {
				UserInfo owner = board.getOwner();
				String userContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE + owner.getId();
				String boardContext = ISmartWorks.CONTEXT_PREFIX_BOARD_SPACE + board.getId();
		%>
		<li>
			<div class="noti_pic">
				<a href="user_space.sw?cid=<%=owner.getId()%>"><img
					src="<%=owner.getMinPicture()%>" alt="<%=owner.getLongName()%>"
					align="bottom" /> </a>
			</div>
			<div class="noti_in">
				<a href="user_space.sw?cid=<%=userContext%>"><span
					class="t_name"><%=owner.getLongName()%></span> </a>
				<%
					if (!board.getWorkSpace().getId().equals(owner.getId())) {
							WorkSpaceInfo workSpace = board.getWorkSpace();
							String targetContent = null;
							String commContext = null;
							if (workSpace.getClass().equals(Group.class)) {
								targetContent = "group_space.sw";
								commContext = ISmartWorks.CONTEXT_PREFIX_GROUP_SPACE + workSpace.getId();
							} else if (workSpace.getClass().equals(Department.class)) {
								targetContent = "department_space.sw";
								commContext = ISmartWorks.CONTEXT_PREFIX_DEPARTMENT_SPACE + workSpace.getId();
							}
				%>
				<span class="arr">▶</span><a
					href="<%=targetContent%>?cid=<%=commContext%>"><span
					class="ico_division_s"><%=board.getWorkSpace().getName()%></span> </a>
				<%
					}
				%>
				<span class="t_date"> <%=board.getLastModifiedDate().toLocalString()%></span>
				<a
					href="board_space.sw?cid=<%=boardContext%>&wid=<%=owner.getId()%>"><span
					class="noti_tit"><%=board.getSubject()%></span> </a>
			</div>
		</li>
		<%
			}
		}
		%>
	</ul>
</div>
<!--공지사항//-->