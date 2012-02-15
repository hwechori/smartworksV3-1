<%@page import="net.smartworks.model.community.Group"%>
<%@page import="net.smartworks.model.community.Department"%>
<%@page import="net.smartworks.model.instance.info.MemoInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.ImageInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.FileInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.EventInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.BoardInstanceInfo"%>
<%@page import="net.smartworks.model.community.info.WorkSpaceInfo"%>
<%@page import="net.smartworks.model.instance.Instance"%>
<%@page import="net.smartworks.model.work.SocialWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.instance.info.WorkInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
<%@page import="net.smartworks.model.instance.TaskInstance"%>
<%@page import="net.smartworks.model.calendar.CompanyEvent"%>
<%@page import="net.smartworks.util.SmartMessage"%>
<%@page import="net.smartworks.model.calendar.WorkHourPolicy"%>
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

	LocalDate fromDate = new LocalDate();

	String fromDateStr = request.getParameter("fromDate"); //yyyy-MM-dd HH:mm:ss.SSS
	String maxSizeStr = request.getParameter("maxSize");
	if(!SmartUtil.isBlankObject(fromDate)) fromDate = LocalDate.convertLocalStringToLocalDate(fromDateStr);
	int maxSize = (SmartUtil.isBlankObject(maxSizeStr)) ? 20 : Integer.parseInt(maxSizeStr);
	
	TaskInstanceInfo[] moreTasks = smartWorks.getCastTaskInstancesByDate(fromDate, maxSize);

	if(!SmartUtil.isBlankObject(moreTasks) && moreTasks.length >0){
		session.setAttribute("taskHistories", moreTasks);
%>
		<!-- 컨텐츠 -->
		<div class="contents_space">			
			<jsp:include page="/jsp/content/community/space/space_task_histories.jsp"></jsp:include>
		</div>
	<%
	}
	%>											
