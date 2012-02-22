
<!-- Name 			: combo_field.jsp											 -->
<!-- Description	: 업무목록 페이지들의 상세필터에서 조건이 콤보리스트인 항목 화면 		 -->
<!-- Author			: Maninsoft, Inc.											 -->
<!-- Created Date	: 2011.9.													 -->

<%@page import="net.smartworks.model.work.FormField"%>
<%@page import="net.smartworks.model.instance.WorkInstance"%>
<%@page import="net.smartworks.model.instance.Instance"%>
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

	// 호출시에 전달한 operator, operandValue 값들을 가져온다..
	String operator = request.getParameter("operator");
	String operandValue = request.getParameter("operandValue");
	// 참거짓 비교에 사용되는 계산자들의 키맵을 가져온다..
	KeyMap[] generalOpers = ConditionOperator.generalOperators;
%>
<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!--  좌측의 필드항목과 우측의 값을 계산하는 조건실행을 위한 오퍼레이터 선택박스 -->
<input name="hdnFieldType" type="hidden" value="<%=FormField.TYPE_COMBO %>"/>
<select name="selFilterOperator" class="selb_size_sec">
	<%
	for (KeyMap generalOper : generalOpers) {
	%>
		<option value="<%=generalOper.getId()%>"<%if (operator != null && operator.equals(generalOper.getId())) {%>selected <%}%>>
			<fmt:message key="<%=generalOper.getKey() %>" />
		</option>
	<%
	}
	%>
</select>
<span class="str_field">
	<select name="txtFilterStringOperand">
		<option value="<%=Instance.STATUS_RUNNING%>" <%if((operandValue != null) && Integer.parseInt(operandValue) == Instance.STATUS_RUNNING){%> selected<%} %>>
			<fmt:message key="content.status.running" />
		</option>
		<option value="<%=Instance.STATUS_DELAYED_RUNNING%>" <%if((operandValue != null) && Integer.parseInt(operandValue) == Instance.STATUS_DELAYED_RUNNING){%> selected<%} %>>
			<fmt:message key="content.status.delayed_running" />
		</option>
		<option value="<%=Instance.STATUS_RETURNED%>" <%if((operandValue != null) && Integer.parseInt(operandValue) == Instance.STATUS_RETURNED){%> selected<%} %>>
			<fmt:message key="content.status.returned" />
		</option>
		<option value="<%=Instance.STATUS_COMPLETED%>" <%if((operandValue != null) && Integer.parseInt(operandValue) == Instance.STATUS_COMPLETED){%> selected<%} %>>
			<fmt:message key="content.status.completed" />
		</option>
	</select> 
</span>

<!--  현재 콘디션을 삭제할 수 있는 샂제 버튼 -->
<span class="btn_x_grb_posi">
	<button class="btn_x_grb js_remove_condition"></button> 
</span>
