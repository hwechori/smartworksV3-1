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
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	InstanceInfo[] workInstances = smartWorks.getMyRecentInstances();
	String iconType = null;
	String classType = null;
	String instanceContext = null;
	String targetContent = null;
%>

<ul>
	<%
		if (workInstances != null) {
			for (InstanceInfo workInstance : workInstances) {
				SmartWorkInfo work = (SmartWorkInfo) workInstance.getWork();
				UserInfo owner = workInstance.getOwner();
				String userContext = ISmartWorks.CONTEXT_PREFIX_USER_SPACE
						+ owner.getId();
				if (workInstance.getWork().getType() == SmartWork.TYPE_PROCESS) {
					iconType = "ico_pworks";
					instanceContext = ISmartWorks.CONTEXT_PREFIX_PWORK_SPACE
							+ workInstance.getId();
					targetContent = "pwork_space.sw";
				} else if (workInstance.getWork().getType() == SmartWork.TYPE_INFORMATION) {
					iconType = "ico_iworks";
					instanceContext = ISmartWorks.CONTEXT_PREFIX_IWORK_SPACE
							+ workInstance.getId();
					targetContent = "iwork_space.sw";
				} else if (workInstance.getWork().getType() == SmartWork.TYPE_SCHEDULE) {
					iconType = "ico_sworks";
					instanceContext = ISmartWorks.CONTEXT_PREFIX_SWORK_SPACE
							+ workInstance.getId();
					targetContent = "swork_space.sw";
				}
	%>
	<li>
	<a
		href="<%=targetContent%>?cid=<%=instanceContext%>"
		class="js_content" title="<%=work.getFullpathName()%>">
			<span class="ico_pe"><img src="<%=owner.getMinPicture()%>" title="<%=owner.getLongName()%>"
			width="20" height="20" border="0"></span> 
			<span class="nav_subtitl_area"><%=workInstance.getSubject()%></span></a>
	</li>
	<%
		}
		}
	%>
</ul>
