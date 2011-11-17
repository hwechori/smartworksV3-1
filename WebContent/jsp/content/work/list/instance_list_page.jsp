<%@page import="net.smartworks.model.instance.FieldData"%>
<%@page import="net.smartworks.model.instance.InstanceRecord"%>
<%@page import="net.smartworks.model.instance.InstanceList"%>
<%@page import="net.smartworks.model.instance.ListRequestParams"%>
<%@page import="net.smartworks.model.work.FormField"%>
<%@page import="net.smartworks.model.work.SmartForm"%>
<%@page import="net.smartworks.model.filter.SearchFilter"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.security.EditPolicy"%>
<%@page import="net.smartworks.model.security.WritePolicy"%>
<%@page import="net.smartworks.model.security.AccessPolicy"%>
<%@page import="net.smartworks.model.work.InformationWork"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String companyId = (String) session.getAttribute("companyId");
	String userId = (String) session.getAttribute("userId");

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String cid = request.getParameter("cid");
	String wid = request.getParameter("wid");

	ListRequestParams params = new ListRequestParams();
	String workId = SmartUtil.getSpaceIdFromContentContext(cid);
	User cUser = SmartUtil.getCurrentUser();
	InformationWork work = (InformationWork) smartWorks.getWorkById(companyId, workId);
	InstanceList instanceList = smartWorks.getWorkInstanceList(companyId, workId, params);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<%
	if (instanceList != null && (instanceList.getInstanceDatas() != null) && (work != null)) {
		int type = instanceList.getType();
		int countInPage = instanceList.getCountInPage();
		int totalPages = instanceList.getTotalPages();
		int currentPage = instanceList.getCurrentPage();
		FormField[] displayFields = work.getDisplayFields();
		InstanceRecord[] instanceRecords = instanceList.getInstanceDatas();
		for (InstanceRecord instanceRecord : instanceRecords) {
			User owner = instanceRecord.getOwner();
			User lastModifier = instanceRecord.getLastModifier();
			FieldData[] fieldDatas = instanceRecord.getFieldDatas();
%>
<tr>
	<td><img src="<%=owner.getMinPicture()%>" title="owner.getLongName()"/>
	</td>
	<%
		if ((fieldDatas != null) && (fieldDatas.length == displayFields.length)) {
					for (FieldData data : fieldDatas) {
	%>
	<td><%=data.getValue()%></td>
	<%
		}
				}
	%>
	<td>
		<div class="noti_pic">
			<img src="<%=lastModifier.getMinPicture()%>"
				title="<%=lastModifier.getLongName()%>" align="bottom" />
		</div>
		<div class="noti_in">
			<span class="t_name"><%=lastModifier.getLongName()%></span>
			<div class="t_date"><%=instanceRecord.getLastModifiedDate().toLocalString()%></div>
		</div></td>
</tr>
<%
	}
	}
%>
