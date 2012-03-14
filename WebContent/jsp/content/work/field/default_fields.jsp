
<!-- Name 			: default_fields.jsp												 -->
<!-- Description	: 업무목록 페이지들의 상세필터에서 업무별로(정보관리업무, 프로세스업무, 일정계획업무)-->
<!--				  기본으로 가지는 필드의 비교 기능    									 -->
<!-- Author			: Maninsoft, Inc.													 -->
<!-- Created Date	: 2011.9.															 -->

<%@page import="net.smartworks.model.work.SocialWork"%>
<%@page import="net.smartworks.model.report.Report"%>
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
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	// 호출할때 전달한 업무타입(정보관리업무, 프로세스업무, 일정계획업무)를 가져옴  
	String strWorkType = request.getParameter("workType");
	int workType = SmartWork.TYPE_INFORMATION;
	if(!SmartUtil.isBlankObject(strWorkType)) workType = Integer.parseInt(strWorkType);

	// 호출시 전달한 좌측의 비교필드이 아이디를 가져온다...
	String fieldId = request.getParameter("fieldId");
	if(fieldId==null){
		fieldId = "";
	}
	// 참거짓 비교에 사용되는 계산자들의 키맵을 가져온다..
	KeyMap[] generalOpers = ConditionOperator.generalOperators;
%>

<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />


<%
// 업무가 정보관리 업무인 경우.....
if(workType == SocialWork.TYPE_FILE){
%>
	<!--  필드가 업무제목인 경우   -->
	<option page="<%=FormField.FIELD_WORK_SPACE.getPageName()%>" type="<%=FormField.FIELD_WORK_SPACE.getType() %>" value="<%=FormField.ID_WORK_SPACE%>"
		<%if (fieldId.equals(FormField.ID_WORK_SPACE)) {%> selected <%}%>>
		<%=FormField.FIELD_WORK_SPACE.getName()%>
	</option>
	<!--  필드가 업무제목인 경우   -->
	<option page="<%=FormField.FIELD_FILE_CATEGORY.getPageName()%>" type="<%=FormField.FIELD_FILE_CATEGORY.getType() %>" value="<%=FormField.ID_FILE_CATEGORY%>"
		<%if (fieldId.equals(FormField.ID_FILE_CATEGORY)) {%> selected <%}%>>
		<%=FormField.FIELD_FILE_CATEGORY.getName()%>
	</option>
	<!--  필드가 업무제목인 경우   -->
	<option page="<%=FormField.FIELD_WORK.getPageName()%>" type="<%=FormField.FIELD_WORK.getType() %>" value="<%=FormField.ID_WORK%>"
		<%if (fieldId.equals(FormField.ID_WORK)) {%> selected <%}%>>
		<%=FormField.FIELD_WORK.getName()%>
	</option>
	<!--  필드가 업무제목인 경우   -->
	<option page="<%=FormField.FIELD_WORK_INSTANCE.getPageName()%>" type="<%=FormField.FIELD_WORK_INSTANCE.getType() %>" value="<%=FormField.ID_WORK_INSTANCE%>"
		<%if (fieldId.equals(FormField.ID_WORK_INSTANCE)) {%> selected <%}%>>
		<%=FormField.FIELD_WORK_INSTANCE.getName()%>
	</option>
	<!--  필드가 업무제목인 경우   -->
	<option page="<%=FormField.FIELD_FILE_TYPE.getPageName()%>" type="<%=FormField.FIELD_FILE_TYPE.getType() %>" value="<%=FormField.ID_FILE_TYPE%>"
		<%if (fieldId.equals(FormField.ID_FILE_TYPE)) {%> selected <%}%>>
		<%=FormField.FIELD_FILE_TYPE.getName()%>
	</option>
<%
// 업무가 프로세스업무인 경우...
}else if(workType == SmartWork.TYPE_PROCESS){
%>
	<!--  필드가 상태인경우   -->
	<option page="<%=FormField.FIELD_STATUS.getPageName()%>" type="<%=FormField.FIELD_STATUS.getType() %>" value="<%=FormField.ID_STATUS%>"
		<%if (fieldId.equals(FormField.ID_STATUS)) {%> selected <%}%>>
		<%=FormField.FIELD_STATUS.getName()%>
	</option>

	<!-- 필드가 인스턴스제목인경우   -->	
	<option page="<%=FormField.FIELD_SUBJECT.getPageName()%>" type="<%=FormField.FIELD_SUBJECT.getType() %>" value="<%=FormField.ID_SUBJECT%>"
		<%if (fieldId.equals(FormField.ID_SUBJECT)) {%> selected <%}%>>
		<%=FormField.FIELD_SUBJECT.getName()%>
	</option>
	
	<!-- 필드가 최종 택스크인경우  -->
	<option page="<%=FormField.FIELD_LAST_TASK.getPageName()%>" type="<%=FormField.FIELD_LAST_TASK.getType() %>" value="<%=FormField.ID_LAST_TASK%>"
		<%if (fieldId.equals(FormField.ID_LAST_TASK)) {%> selected <%}%>>
		<%=FormField.FIELD_LAST_TASK.getName()%>
	</option>
<%

// 업무가 일정계획업무인 경우, 일정계획업무는 방향을 재정립하려고 고민 중에 있음.....
}else if(workType == SmartWork.TYPE_SCHEDULE){
%>
<%	
}
%>

<!-- 필드가 최초생성자(소유자)인경우.. -->
<option page="<%=FormField.FIELD_OWNER.getPageName()%>" type="<%=FormField.FIELD_OWNER.getType() %>" value="<%=FormField.ID_OWNER%>"
	<%if (fieldId.equals(FormField.ID_OWNER)) {%> selected <%}%>>
		<%=FormField.FIELD_OWNER.getName()%>
</option>

<!-- 필드가 생성일인 경우  -->
<option page="<%=FormField.FIELD_CREATED_DATE.getPageName()%>" type="<%=FormField.FIELD_CREATED_DATE.getType() %>" value="<%=FormField.ID_CREATED_DATE%>"
	<%if (fieldId.equals(FormField.ID_CREATED_DATE)) {%> selected <%}%>>
		<%=FormField.FIELD_CREATED_DATE.getName()%>
</option>

<!-- 필드가 최종수정자인 경우  -->
<option page="<%=FormField.FIELD_LAST_MODIFIER.getPageName()%>" type="<%=FormField.FIELD_LAST_MODIFIER.getType() %>" value="<%=FormField.ID_LAST_MODIFIER%>"
	<%if (fieldId.equals(FormField.ID_LAST_MODIFIER)) {%> selected <%}%>>
		<%=FormField.FIELD_LAST_MODIFIER.getName()%>
</option>

<!-- 필드가 최종수정일인 경우  -->
<option page="<%=FormField.FIELD_LAST_MODIFIED_DATE.getPageName()%>" type="<%=FormField.FIELD_LAST_MODIFIED_DATE.getType() %>" value="<%=FormField.ID_LAST_MODIFIED_DATE%>"
	<%if (fieldId.equals(FormField.ID_LAST_MODIFIED_DATE)) {%> selected <%}%>>
		<%=FormField.FIELD_LAST_MODIFIED_DATE.getName()%>
</option>
