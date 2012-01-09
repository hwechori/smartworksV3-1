
<!-- Name 			: work.jsp										 				 -->
<!-- Description	: 업무를 찾는 검색박스에서 key 값을 받아 서버에서 결과를가져와 보여주는 화면  -->
<!-- Author			: Maninsoft, Inc.												 -->
<!-- Created Date	: 2011.9.														 -->

<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.SmartWorkInfo"%>
<%@ page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다.
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	// 전달된 키값으로 서버에서 업무를 찾아주는 기능을 호출한다.
	String key = request.getParameter("key");
	SmartWorkInfo[] works = smartWorks.searchWork(key);
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<ul>
	<%
	// 검색결과 값이 있으면 그 목록들을 만들어 보여줌 
	if (works != null) {
		for (SmartWorkInfo work : works) {
			String iconType = null, workContext = null, targetContent = null;
			if (work.getType() == SmartWork.TYPE_PROCESS) {
				iconType = "ico_pworks";
				workContext = ISmartWorks.CONTEXT_PREFIX_PWORK_LIST + work.getId();
				targetContent = "pwork_list.sw";
			} else if (work.getType() == SmartWork.TYPE_INFORMATION) {
				iconType = "ico_iworks";
				workContext = ISmartWorks.CONTEXT_PREFIX_IWORK_LIST + work.getId();
				targetContent = "iwork_list.sw";
			} else if (work.getType() == SmartWork.TYPE_SCHEDULE) {
				iconType = "ico_sworks";
				workContext = ISmartWorks.CONTEXT_PREFIX_SWORK_LIST + work.getId();
				targetContent = "swork_list.sw";
			}
	%>
			<li>
				<a href="<%=targetContent%>?cid=<%=workContext%>" class="js_content">
					<span class="<%=iconType%>"></span>
					<span class="nav_subtitl_area"><%=work.getFullpathName()%></span>
				</a>
			</li>
	<%
		}
		
	// 검색결과가 없으면 검색결과가 없다고 보여줌..
	}else{
	%>
		<li>
			<span><fmt:message key="search.message.no_searched_data"/></span>
		</li>
	<%
	} 
	%>
</ul>
