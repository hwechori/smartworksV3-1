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

	String contextId = request.getParameter("contextId");
	String spaceId = request.getParameter("spaceId");
	String fromDate = request.getParameter("fromDate");
	String toDate = request.getParameter("toDate");
	String maxSizeStr = request.getParameter("maxSize");
	int maxSize = (SmartUtil.isBlankObject(maxSizeStr)) ? 20 : Integer.parseInt(maxSizeStr);
	
	TaskInstanceInfo[] moreTasks = smartWorks.getTaskInstancesByDate(contextId, spaceId, LocalDate.convertLocalStringToLocalDate(fromDate), LocalDate.convertLocalStringToLocalDate(toDate), maxSize);

	if(!SmartUtil.isBlankObject(moreTasks) && moreTasks.length >0){
		session.setAttribute("taskHistories", moreTasks);
%>
		<jsp:include page="/jsp/content/community/space/space_task_histories.jsp"></jsp:include>
	<%
	}
	%>											
