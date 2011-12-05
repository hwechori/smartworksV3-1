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
	User cUser = SmartUtil.getCurrentUser(request, response);

	ISmartWorks smartWorks = (ISmartWorks) request
			.getAttribute("smartWorks");
	InstanceInfo[] workInstances = smartWorks.getMyRecentInstances(
			cUser.getCompanyId(), cUser.getId());
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
				String workSpaceId = workInstance.getWorkSpace().getId();
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
				if (workSpaceId != null
						&& !workSpaceId.equals(SmartUtil.getCurrentUser(
								request, response).getId())) {
					classType = "";
				} else {
					classType = "js_content";
				}
	%>
	<li><a
		href="<%=targetContent%>?cid=<%=instanceContext%>&wid=<%=workSpaceId%>"
		class="<%=classType%>" title="<%=work.getFullpathName()%>"><img
			src="<%=owner.getMinPicture()%>" title="<%=owner.getLongName()%>"
			width="22" height="22" border="0"> <%=workInstance.getSubject()%></a>
	</li>
	<%
		}
		}
	%>
</ul>
