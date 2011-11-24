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
	String type = request.getParameter("type");
	String leftOperandId = request.getParameter("leftOperandId");
	if(leftOperandId==null){
		leftOperandId = "";
	}
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser(request);
	KeyMap[] generalOpers = ConditionOperator.generalOperators;
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />


<%
if(type != null && Integer.parseInt(type) == SmartWork.TYPE_INFORMATION){
%>
<option type="<%=FormField.FIELD_OWNER.getPageName()%>"
	value="<%=FormField.ID_OWNER%>"
	<%if (leftOperandId.equals(FormField.ID_OWNER)) {%> selected
	<%}%>>
	<fmt:message key='common.title.owner' />
</option>
<option type="<%=FormField.FIELD_CREATED_DATE.getPageName()%>"
	value="<%=FormField.ID_CREATED_DATE%>"
	<%if (leftOperandId.equals(FormField.ID_CREATED_DATE)) {%>
	selected <%}%>>
	<fmt:message key='common.title.created_date' />
</option>
<option type="<%=FormField.FIELD_LAST_MODIFIER.getPageName()%>"
	value="<%=FormField.ID_LAST_MODIFIER%>"
	<%if (leftOperandId.equals(FormField.ID_LAST_MODIFIER)) {%>
	selected <%}%>>
	<fmt:message key='common.title.last_modifier' />
</option>
<option type="<%=FormField.FIELD_LAST_MODIFIED_DATE.getPageName()%>"
	value="<%=FormField.ID_LAST_MODIFIED_DATE%>"
	<%if (leftOperandId.equals(FormField.ID_LAST_MODIFIED_DATE)) {%>
	selected <%}%>>
	<fmt:message key='common.title.last_modified_date' />
</option>
<%
}else if(type != null && Integer.parseInt(type) == SmartWork.TYPE_PROCESS){
%>
<option type="<%=FormField.FIELD_STATUS.getPageName()%>"
	value="<%=FormField.ID_STATUS%>"
	<%if (leftOperandId.equals(FormField.ID_STATUS)) {%> selected
	<%}%>>
	<fmt:message key='common.title.status' />
</option>
<option type="<%=FormField.FIELD_SUBJECT.getPageName()%>"
	value="<%=FormField.ID_SUBJECT%>"
	<%if (leftOperandId.equals(FormField.ID_SUBJECT)) {%>
	selected <%}%>>
	<fmt:message key='common.title.subject' />
</option>
<option type="<%=FormField.FIELD_RUNNING_TASK.getPageName()%>"
	value="<%=FormField.ID_RUNNING_TASK%>"
	<%if (leftOperandId.equals(FormField.ID_RUNNING_TASK)) {%>
	selected <%}%>>
	<fmt:message key='common.title.running_task' />
</option>
<option type="<%=FormField.FIELD_OWNER.getPageName()%>"
	value="<%=FormField.ID_OWNER%>"
	<%if (leftOperandId.equals(FormField.ID_OWNER)) {%>
	selected <%}%>>
	<fmt:message key='common.title.starter' />
</option>
<option type="<%=FormField.FIELD_LAST_MODIFIER.getPageName()%>"
	value="<%=FormField.ID_LAST_MODIFIER%>"
	<%if (leftOperandId.equals(FormField.ID_LAST_MODIFIER)) {%>
	selected <%}%>>
	<fmt:message key='common.title.performer' />
</option>
<option type="<%=FormField.FIELD_LAST_MODIFIED_DATE.getPageName()%>"
	value="<%=FormField.ID_LAST_MODIFIED_DATE%>"
	<%if (leftOperandId.equals(FormField.ID_LAST_MODIFIED_DATE)) {%>
	selected <%}%>>
	<fmt:message key='common.title.performed_date' />
</option>
<%
}
%>