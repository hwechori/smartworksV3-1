<%@page import="net.smartworks.model.work.FileCategory"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.work.info.FileCategoryInfo"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String wid = request.getParameter("wid");
	int displayType = Integer.parseInt(request.getParameter("displayType"));
	String parentId = request.getParameter("parentId");
	
	User cUser = SmartUtil.getCurrentUser();
	FileCategoryInfo[] categories = smartWorks.getFileCategoriesByType(displayType, wid, parentId);

%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<%
if(!SmartUtil.isBlankObject(categories) && categories.length>0){
	for(int i=0; i<categories.length; i++){
		FileCategoryInfo category = categories[i];
%>
		<li>
			<span class="dep">
				<a class="js_file_category_list" href="" categoryId="<%=category.getId()%>"> 
					<span class="<%=category.getIconClass()%>"></span>
					<span><%=category.getName() %> (<%=category.getLength() %>)</span> 
				</a> 
			</span>
		</li>
<%
	}
}
%>