<%@page import="net.smartworks.model.instance.info.InstanceInfo"%>
<%@page import="net.smartworks.model.community.Group"%>
<%@page import="net.smartworks.model.community.Department"%>
<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
<%@page import="net.smartworks.model.instance.TaskInstance"%>
<%@page import="net.smartworks.model.calendar.WorkHourPolicy"%>
<%@page import="net.smartworks.util.SmartMessage"%>
<%@page import="net.smartworks.model.community.WorkSpace"%>
<%@page import="java.util.Calendar"%>
<%@page import="net.smartworks.model.calendar.CompanyCalendar"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	String spaceId = request.getParameter("spaceId");
	String fromDate = request.getParameter("fromDate");
	String maxSizeStr = request.getParameter("maxSize");
	int maxSize = (SmartUtil.isBlankObject(maxSizeStr)) ? 20 : Integer.parseInt(maxSizeStr);

	InstanceInfo[] subInstances = smartWorks.getSpaceInstancesByDate(spaceId, LocalDate.convertLocalStringToLocalDate(fromDate), maxSize); 

	if(!SmartUtil.isBlankObject(subInstances) && subInstances.length >0){
		session.setAttribute("subInstances", subInstances);
%>
		<jsp:include page="/jsp/content/work/space/space_sub_instances.jsp"></jsp:include>
	<%
	}
	%>											
