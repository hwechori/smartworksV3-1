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
	<div class="headlineNotice">
		<a href="#" class="more"></a>
		<a href="#">
			<span class="title">올레캠퍼스 자바개발자 교육과정 소개합니다</span>
			<span class="index ico_division_s">한라공조협력업체 정보화시스템 고도화 프로젝트</span>
			<span class="info">개발팀 신현성, 19:00</span>
			<span class="content">올레캠퍼스 자바개발자 교육과정 소개합니다. 올레캠퍼스 자바개발자 교육과정 소개합니다. 올레캠퍼..</span>
		</a>
	</div>
	<div class="recentNotice">
		<table>
			<tr>
				<td class="title"><a href="#">워크샵 일정계획 공지합니다</a></td>
				<td class="index ico_division_s">한라공조협력업체 정보화시스템 고도화</td>
				<td class="writer"><a href="#"><img width="20" height="20" alt="기술연구소장 유광민" src="images/no_user_picture_min.jpg"> 기술연구소 유광민</a></td>
				<td class="date">01-30 23:14</td>
			</tr>
			<tr>
				<td class="title"><a href="#">워크샵 일정계획 공지합니다</a></td>
				<td class="index ico_division_s">한라공조협력업체 정보화시스템 고도화</td>
				<td class="writer"><a href="#"><img width="20" height="20" alt="기술연구소장 유광민" src="images/no_user_picture_min.jpg"> 기술연구소 유광민</a></td>
				<td class="date">01-30 23:14</td>
			</tr>
			<tr>
				<td class="title"><a href="#">올레캠퍼스 자바개발자 교육과정 소개합니다.</a></td>
				<td class="index ico_division_s">한라공조협력업체 </td>
				<td class="writer"><a href="#"><img width="20" height="20" alt="기술연구소장 유광민" src="images/no_user_picture_min.jpg"> 기술연구소 유광민</a></td>
				<td class="date">01-30 23:14</td>
			</tr>
			<tr>
				<td class="title"><a href="#">워크샵 일정계획 공지합니다</a></td>
				<td class="index ico_division_s">한라공조협력업체 정보화시스템 고도화</td>
				<td class="writer"><a href="#"><img width="20" height="20" alt="기술연구소장 유광민" src="images/no_user_picture_min.jpg"> 기술연구소 유광민</a></td>
				<td class="date">01-30 23:14</td>
			</tr>
			
		</table>
	</div>
</div>
<!-- 공지사항 정연희 추가 style end-->

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
			<div class="float_left_nowidth">
				<a href="user_space.sw?cid=<%=owner.getId()%>"><img
					src="<%=owner.getMinPicture()%>" width="20" height="20" alt="<%=owner.getLongName()%>"
					/> </a>
			</div>
			<div class="">
			<a href="board_space.sw?cid=<%=boardContext%>&wid=<%=owner.getId()%>">
				<span class="noti_tit_snew"><%=board.getSubject()%></span> 
			</a>
					
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
				
			</div>
		</li>
		<%
			}
		}
		%>
	</ul>
</div>
<!--공지사항//-->