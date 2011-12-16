<%@page import="net.smartworks.model.report.Report"%>
<%@page import="net.smartworks.model.instance.Instance"%>
<%@page import="net.smartworks.model.work.FormField"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.model.KeyMap"%>
<%@page import="net.smartworks.model.filter.ConditionOperator"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String strWorkType = request.getParameter("workType");
	int workType = SmartWork.TYPE_INFORMATION;
	if(strWorkType != null && !strWorkType.equals("")) workType = Integer.parseInt(strWorkType);

	String fieldId = request.getParameter("fieldId");
	if(fieldId==null){
		fieldId = "";
	}
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	KeyMap[] generalOpers = ConditionOperator.generalOperators;
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />


<%
if(workType == SmartWork.TYPE_INFORMATION){
%>
<option page="<%=FormField.FIELD_OWNER.getPageName()%>"
	type="<%=FormField.FIELD_OWNER.getType() %>" 
	value="<%=FormField.ID_OWNER%>"
	<%if (fieldId.equals(FormField.ID_OWNER)) {%> selected
	<%}%>>
	<fmt:message key='common.title.owner' />
</option>
<option page="<%=FormField.FIELD_CREATED_DATE.getPageName()%>"
	type="<%=FormField.FIELD_CREATED_DATE.getType() %>" 
	value="<%=FormField.ID_CREATED_DATE%>"
	<%if (fieldId.equals(FormField.ID_CREATED_DATE)) {%>
	selected <%}%>>
	<fmt:message key='common.title.created_date' />
</option>
<option page="<%=FormField.FIELD_LAST_MODIFIER.getPageName()%>"
	type="<%=FormField.FIELD_LAST_MODIFIER.getType() %>" 
	value="<%=FormField.ID_LAST_MODIFIER%>"
	<%if (fieldId.equals(FormField.ID_LAST_MODIFIER)) {%>
	selected <%}%>>
	<fmt:message key='common.title.last_modifier' />
</option>
<option page="<%=FormField.FIELD_LAST_MODIFIED_DATE.getPageName()%>"
	type="<%=FormField.FIELD_LAST_MODIFIED_DATE.getType() %>" 
	value="<%=FormField.ID_LAST_MODIFIED_DATE%>"
	<%if (fieldId.equals(FormField.ID_LAST_MODIFIED_DATE)) {%>
	selected <%}%>>
	<fmt:message key='common.title.last_modified_date' />
</option>
<%
}else if(workType == SmartWork.TYPE_PROCESS){
%>
<option page="<%=FormField.FIELD_STATUS.getPageName()%>"
	type="<%=FormField.FIELD_STATUS.getType() %>" 
	value="<%=FormField.ID_STATUS%>"
	<%if (fieldId.equals(FormField.ID_STATUS)) {%> selected
	<%}%>>
	<fmt:message key='common.title.status' />
</option>
<option page="<%=FormField.FIELD_SUBJECT.getPageName()%>"
	type="<%=FormField.FIELD_SUBJECT.getType() %>" 
	value="<%=FormField.ID_SUBJECT%>"
	<%if (fieldId.equals(FormField.ID_SUBJECT)) {%>
	selected <%}%>>
	<fmt:message key='common.title.subject' />
</option>
<option page="<%=FormField.FIELD_LAST_TASK.getPageName()%>"
	type="<%=FormField.FIELD_LAST_TASK.getType() %>" 
	value="<%=FormField.ID_LAST_TASK%>"
	<%if (fieldId.equals(FormField.ID_LAST_TASK)) {%>
	selected <%}%>>
	<fmt:message key='common.title.last_task' />
</option>
<option page="<%=FormField.FIELD_OWNER.getPageName()%>"
	type="<%=FormField.FIELD_OWNER.getType() %>" 
	value="<%=FormField.ID_OWNER%>"
	<%if (fieldId.equals(FormField.ID_OWNER)) {%>
	selected <%}%>>
	<fmt:message key='common.title.starter' />
</option>
<option page="<%=FormField.FIELD_LAST_MODIFIER.getPageName()%>"
	type="<%=FormField.FIELD_LAST_MODIFIER.getType() %>" 
	value="<%=FormField.ID_LAST_MODIFIER%>"
	<%if (fieldId.equals(FormField.ID_LAST_MODIFIER)) {%>
	selected <%}%>>
	<fmt:message key='common.title.performer' />
</option>
<option page="<%=FormField.FIELD_LAST_MODIFIED_DATE.getPageName()%>"
	type="<%=FormField.FIELD_LAST_MODIFIED_DATE.getType() %>" 
	value="<%=FormField.ID_LAST_MODIFIED_DATE%>"
	<%if (fieldId.equals(FormField.ID_LAST_MODIFIED_DATE)) {%>
	selected <%}%>>
	<fmt:message key='common.title.performed_date' />
</option>
<%
}
%>