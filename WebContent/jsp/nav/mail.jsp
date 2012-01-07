
<!-- Name 			: mail.jsp										 				 -->
<!-- Description	: 좌측의 Navigation Bar에서 메일의 폴더들과 관련 기능들을 보여주는 화면 	 -->
<!-- Author			: Y.S. JUNG														 -->
<!-- Created Date	: 2011.9.														 -->

<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.service.ISmartWorks"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다 
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User currentUser = SmartUtil.getCurrentUser();
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=currentUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 메일 해더 부분  -->
<ul>
	<li>
		<!-- 메일 라벨과 클릭시 아래의 메일폴더선택트리화면을 접었다 폈다하는 기능 제공  -->
		<!-- *** js_collapse_parent_siblings : sw_act_nav.js 에서 이클래스의 클릭이벤트를 받아서 -->
		<!--            아래의 js_callapsible 클래스를 찾아 toggle 한다 -->
		<a href="" class="js_collapse_parent_siblings arr_on"><fmt:message key="nav.mail" /></a>
	</li>
</ul>
<!-- 메일 해더 부분  //-->
	
<!-- 메일 폴더및 관련기능들  -->
<div class='navi_list js_collapsible'>
	<!-- 내부 메뉴 -->
	<div class="categ_link js_nav_tab_mail">
		<a href="fetch_unread_mails.sw" title="<fmt:message key='nav.mail.fetch_unread_mails'/>"><img src="images/ic_mail.png"/></a>
		<a href="write_new_mail.sw" title="<fmt:message key='nav.mail.new_mail'/>"><img src="images/ic_mail.png"/></a>
		<a href="create_new_folder.sw" title="<fmt:message key='nav.mail.new_folder'/>"><img src="images/ic_mail.png"/></a>
		<a href="delete_existing_folder.sw" title="<fmt:message key='nav.mail.delete_folder'/>"><img src="images/ic_mail.png"/></a>
	</div>
	<div id='my_mail'>
		<!--  메일서버에서 현재사용자의 메일폴더정보를 가져와서 보여준다.. -->
   		<jsp:include page="my_all_mail_folders.jsp" />
	</div>
	<!--내부메뉴//-->
</div>
<!-- 메일 폴더및 관련기능들 // -->
	