
<!-- Name 			: my_recent_instances.jsp								 -->
<!-- Description	: 현재사용자의 최근 처리한 항목들을 보여주는 화면   				 -->
<!-- Author			: Maninsoft, Inc.										 -->
<!-- Created Date	: 2011.9.												 -->

<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.model.instance.info.EventInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.FileInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.ImageInstanceInfo"%>
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
			switch(workInstance.getType()){
			case Instance.TYPE_IMAGE:
				ImageInstanceInfo image = (ImageInstanceInfo)workInstance;
	%>			
				<li>
					<a href="<%=image.getController()%>?cid=<%=image.getContextId()%>&workId=<%=work.getId()%>" class="js_content" title="<%=work.getFullpathName()%>">
						<span class="icon_pe">
							<img src="<%=image.getImgSource()%>" title="<%=CommonUtil.toNotNull(image.getContent())%>" class="profile_size_s">
						</span> 
						<span class="nav_sub_area"><%=image.getSubject()%>
							<%if(image.getSubInstanceCount()>0){ %><font class="t_sub_count">[<b><%=image.getSubInstanceCount() %></b>]</font><%} %>
						</span>
					</a>
				</li>
			<%
				break;
			case Instance.TYPE_FILE:
			case Instance.TYPE_EVENT:
			case Instance.TYPE_BOARD:
			case Instance.TYPE_MEMO:
				WorkInstanceInfo socialInstance = (WorkInstanceInfo)workInstance;
	%>			
				<li>
					<a href="<%=socialInstance.getController()%>?cid=<%=socialInstance.getContextId()%>&workId=<%=work.getId()%>" class="js_content" title="<%=work.getFullpathName()%>">
						<span class="<%=work.getIconClass() %>"></span>
						<span class="nav_sub_area"><%=socialInstance.getSubject()%>
							<%if(socialInstance.getSubInstanceCount()>0){ %><font class="t_sub_count">[<b><%=socialInstance.getSubInstanceCount() %></b>]</font><%} %>
						</span>
					</a>
				</li>
			<%
				break;
			default:
			%>	
				<li>
					<a href="<%=((WorkInstanceInfo)workInstance).getController()%>?cid=<%=((WorkInstanceInfo)workInstance).getContextId()%>&workId=<%=work.getId()%>" class="js_content" title="<%=work.getFullpathName()%>">
						<span class="icon_pe">
							<img src="<%=owner.getMinPicture()%>" title="<%=owner.getLongName()%>" class="profile_size_s">
						</span> 
						<span class="nav_sub_area"><%=workInstance.getSubject()%>
							<%if(((WorkInstanceInfo)workInstance).getSubInstanceCount()>0){ %><font class="t_sub_count">[<b><%=((WorkInstanceInfo)workInstance).getSubInstanceCount() %></b>]</font><%} %>
						</span>
					</a>
				</li>
	<%	
			}
		}
	}
	%>
</ul>
