<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.service.ISmartWorks"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User currentUser = SmartUtil.getCurrentUser();
%>

<fmt:setLocale value="<%=currentUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<ul>
	<li><a href="" class="js_collapse_parent_siblings arr_on"><fmt:message key="nav.mail" /></a>
	</li>
</ul>


<div class='navi_list js_collapsible'>
	<!-- 내부 메뉴 -->
	<div class="categ_link js_nav_tab_mail">
		<a href="fetch_unread_mails.sw" title="<fmt:message key='nav.mail.fetch_unread_mails'/>"><img src="images/ic_mail.png"/></a>
		<a href="write_new_mail.sw" title="<fmt:message key='nav.mail.new_mail'/>"><img src="images/ic_mail.png"/></a>
		<a href="create_new_folder.sw" title="<fmt:message key='nav.mail.new_folder'/>"><img src="images/ic_mail.png"/></a>
		<a href="delete_existing_folder.sw" title="<fmt:message key='nav.mail.delete_folder'/>"><img src="images/ic_mail.png"/></a>
	</div>
	<div id='my_mail_folder'>
<%--  		<jsp:include page="my_all_mail_folders.jsp" />
 --%>	</div>
	<!--내부메뉴//-->
</div>
