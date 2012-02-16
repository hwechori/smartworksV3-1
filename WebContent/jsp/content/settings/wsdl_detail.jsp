<%@page import="net.smartworks.model.service.WSDLPort"%>
<%@page import="net.smartworks.model.service.WSDLDetail"%>
<%@page import="net.smartworks.model.service.Variable"%>
<%@page import="net.smartworks.model.service.WebService"%>
<%@page import="net.smartworks.model.approval.Approval"%>
<%@page import="net.smartworks.model.approval.ApprovalLine"%>
<%@page import="net.smartworks.model.community.Community"%>
<%@page import="net.smartworks.model.calendar.CompanyEvent"%>
<%@page import="net.smartworks.model.calendar.CompanyCalendar"%>
<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.model.calendar.WorkHour"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.model.calendar.WorkHourPolicy"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	
	String serviceId = request.getParameter("serviceId");
	String wsdlUri = request.getParameter("wsdlUri");
	
	WSDLDetail wsdlDetail = new WSDLDetail();
	if(!SmartUtil.isBlankObject(wsdlUri)) wsdlDetail = smartWorks.getWsdlDetailFromUri(wsdlUri);
	else if(!SmartUtil.isBlankObject(serviceId)){
		WebService webService = (WebService)session.getAttribute("webService");
		wsdlDetail = webService.getWSDLDetail();
	}
	
%>
</script>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<tr>
	<td><fmt:message key="settings.title.webservice.port"/></td>
	<td>
		<select name="selWebServicePort">
			<%
			WSDLPort[] ports = wsdlDetail.getPorts();
			if(!SmartUtil.isBlankObject(ports) && ports.length>0){
				for(WSDLPort port : ports){
			%>
					<option><%=port.getPort() %></option>
			<%
				}
			}
			%>
		</select>
	</td>
</tr>
<tr>
	<td><fmt:message key="settings.title.webservice.operation"/></td>
	<td>
		<select name="selWebServiceOperation">
			<%
			if(!SmartUtil.isBlankObject(ports) && ports.length==1){
				WSDLOperation[] operations = ports[0].getOperations();
				if(!SmartUtil.isBlankObject(operations) && operations.length>0){
					for(WSDLOperation operation : operations){
				
			%>
					<option><%=operations[] %></option>
			<%
			}
			%>
		</select>
	</td>
</tr>
<tr>
	<td><fmt:message key="settings.title.webservice.input_variables"/>
		<%if(wsdlDetail.getInputVariables()!=null && wsdlDetail.getInputVariables().length>0){%><span class="essen_n"></span><%} %>
	</td>
	<td>
		<table style="width:100%">
			<tr>
				<th style="width:33%"><fmt:message key="settings.title.variable.name"/></th>
				<th style="width:33%"><fmt:message key="settings.title.variable.element_name"/></th>
				<th style="width:33%"><fmt:message key="settings.title.variable.element_type"/></th>
			</tr>
			<%
			if(wsdlDetail.getInputVariables()!=null && wsdlDetail.getInputVariables().length>0){
				Variable[] inputVariables = wsdlDetail.getInputVariables();
				for(int count=1; count<inputVariables.length+1; count++){
					Variable inputVariable = inputVariables[count-1]; 
			%>
					<tr>
						<th><input class="fieldline required" name="txtInputVariableName<%=count %>" type="text" value="<%=CommonUtil.toNotNull(inputVariable.getName())%>"></th>
						<th><input readonly name="txtInputElementName<%=count %>" type="text" value="<%=CommonUtil.toNotNull(inputVariable.getElementName())%>"></th>
						<th><input readonly name="txtInputElementType<%=count %>" type="text" value="<%=CommonUtil.toNotNull(inputVariable.getElementType())%>"></th>
					</tr>				
			<%
				}
			}
			%>
		</table>
	</td>
</tr>
<tr>
	<td><fmt:message key="settings.title.webservice.return_variables"/>
		<%if(wsdlDetail.getReturnVariables()!=null && wsdlDetail.getReturnVariables().length>0){ %><span class="essen_n"></span><%} %>
	</td>
	<td>
		<table style="width:100%">
			<tr>
				<th style="width:33%"><fmt:message key="settings.title.variable.name"/></th>
				<th style="width:33%"><fmt:message key="settings.title.variable.element_name"/></th>
				<th style="width:33%"><fmt:message key="settings.title.variable.element_type"/></th>
			</tr>
			<%
			if(wsdlDetail.getReturnVariables()!=null && wsdlDetail.getReturnVariables().length>0){
				Variable[] returnVariables = wsdlDetail.getReturnVariables();
				for(int count=1; count<returnVariables.length+1; count++){
					Variable returnVariable = returnVariables[count-1]; 
			%>
					<tr>
						<th><input class="fieldline required" name="txtReturnVariableName<%=count %>" type="text" value="<%=CommonUtil.toNotNull(returnVariable.getName())%>"></th>
						<th><input readonly name="txtReturnElementName<%=count %>" type="text" value="<%=CommonUtil.toNotNull(returnVariable.getElementName())%>"></th>
						<th><input readonly name="txtReturnElementType<%=count %>" type="text" value="<%=CommonUtil.toNotNull(returnVariable.getElementType())%>"></th>
					</tr>				
			<%
				}
			}
			%>
		</table>
	</td>
</tr>