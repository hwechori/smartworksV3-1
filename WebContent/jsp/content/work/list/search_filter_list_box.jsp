<%@page import="net.smartworks.model.report.ChartReport"%>
<%@page import="net.smartworks.model.report.info.ReportInfo"%>
<%@page import="net.smartworks.model.filter.info.SearchFilterInfo"%>
<%@page import="net.smartworks.model.report.Report"%>
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
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	SmartWork work = (SmartWork)session.getAttribute("smartWork");
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<form class="form_space" name="frmIworkFilterName">
	<select name="selFilterName" class="js_select_search_filter">
		<option value="<%=SearchFilter.FILTER_ALL_INSTANCES%>" 
			<%if(SmartUtil.isBlankObject(work.getLastFilterId()) || SearchFilter.FILTER_ALL_INSTANCES.equals(work.getLastFilterId())){%> selected <%} %>>
			<fmt:message key='filter.name.all_instances' />
		</option>
		<option value="<%=SearchFilter.FILTER_MY_INSTANCES%>"
			<%if(SearchFilter.FILTER_MY_INSTANCES.equals(work.getLastFilterId())){%> selected <%} %>>
			<fmt:message key='filter.name.my_instances' />
		</option>
		<option value="<%=SearchFilter.FILTER_RECENT_INSTANCES%>"
			<%if(SearchFilter.FILTER_RECENT_INSTANCES.equals(work.getLastFilterId())){%> selected <%} %>>
			<fmt:message key='filter.name.recent_instances' />
		</option>
		<option value="<%=SearchFilter.FILTER_MY_RECENT_INSTANCES%>"
			<%if(SearchFilter.FILTER_MY_RECENT_INSTANCES.equals(work.getLastFilterId())){%> selected <%} %>>
			<fmt:message key='filter.name.my_recent_instances' /></option>
		<%
		SearchFilterInfo[] filters = work.getSearchFilters();
		if (filters != null) {
			for (SearchFilterInfo filter : filters) {
		%>
			<option value="<%=filter.getId()%>"
			<%if(filter.getId().equals(work.getLastFilterId())){%> selected <%} %>><%=filter.getName()%></option>
		<%
			}
		}
		%>
	</select>
</form>
