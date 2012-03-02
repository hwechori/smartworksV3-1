
<!-- Name 			: my_recent_instances.jsp								 -->
<!-- Description	: 현재사용자의 최근 처리한 항목들을 보여주는 화면   				 -->
<!-- Author			: Maninsoft, Inc.										 -->
<!-- Created Date	: 2011.9.												 -->

<%@page import="net.smartworks.model.instance.info.WorkInstanceInfo"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.work.info.SmartWorkInfo"%>
<%@page import="net.smartworks.model.instance.info.InstanceInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.instance.*"%>
<%@ page import="net.smartworks.model.work.*"%>
<%@ page import="net.smartworks.model.community.*"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다 
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");

	// 서버에서 현재사용자의 최근 처리항목들을 가져온다...
	InstanceInfo[] workInstances = smartWorks.getMyRecentInstances();
	String iconType = null, classType = null, instanceContext = null, targetContent = null;
%>

<ul>
	<%
	if (workInstances != null) {
		for (InstanceInfo workInstance : workInstances) {
			SmartWorkInfo work = (SmartWorkInfo) workInstance.getWork();
			UserInfo owner = workInstance.getOwner();
	%>
			<li>
				<a href="<%=((WorkInstanceInfo)workInstance).getController()%>?cid=<%=((WorkInstanceInfo)workInstance).getContextId()%>&workId=<%=work.getId()%>" class="js_content" title="<%=work.getFullpathName()%>">
					<span class="icon_pe">
						<img src="<%=owner.getMinPicture()%>" title="<%=owner.getLongName()%>" class="profile_size_s">
					</span> 
					<span class="nav_subtitl_area"><%=workInstance.getSubject()%></span>
				</a>
			</li>
		<%
			}
		}
		%>
</ul>
