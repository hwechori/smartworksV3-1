
<!-- Name 			: boolean_field.jsp											 -->
<!-- Description	: 업무목록 페이지들의 상세필터에서 조건이 참거짓인 항목 화면 			 -->
<!-- Author			: Maninsoft, Inc.											 -->
<!-- Created Date	: 2011.9.													 -->

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
<select name="selFilterOperator" class="selb_size_sec">
	<%
	for (KeyMap generalOper : generalOpers) {
	%>
		<option value="<%=generalOper.getId()%>" <%if (operator != null && operator.equals(generalOper.getId())) {%>selected <%}%>>
			<fmt:message key="<%=generalOper.getKey() %>" />
		</option>
	<%
	}
	%>
</select>

<!--  참거짓을 선택할 수 있는 선택박스 -->
<span class="str_field">
	<input name="hdnFieldType" type="hidden" value="<%=FormField.TYPE_CHECK_BOX %>"/>
	<select name="txtFilterStringOperand">
			<option value="true" <%if((operandValue != null) && operandValue.equals("true")){%> selected<%} %>>
				<fmt:message key="filter.operand.true" />
			</option>
			<option value="false" <%if((operandValue != null) && operandValue.equals("false")){%> selected<%} %>>
				<fmt:message key="filter.operand.false" />
			</option>
	</select> 
</span>

<!--  현재 콘디션을 삭제할 수 있는 샂제 버튼 -->
<span class="btn_delete_posi">
	<button class="btn_delete js_remove_condition"></button> 
</span>
