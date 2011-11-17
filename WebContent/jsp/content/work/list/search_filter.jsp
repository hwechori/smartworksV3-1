<%@page import="net.smartworks.model.filter.Condition"%>
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
	String companyId = (String) session.getAttribute("companyId");
	String userId = (String) session.getAttribute("userId");

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String workId = request.getParameter("workId");
	String filterId = request.getParameter("filterId");

	User cUser = SmartUtil.getCurrentUser();
	InformationWork work = (InformationWork) smartWorks.getWorkById(companyId, workId);
	FormField[] fields = null;
	SearchFilter filter = null;
	if ((work != null) && (work.getForm() != null))
		fields = work.getForm().getFields();
	if (filterId != null)
		filter = work.getSearchFilterById(filterId);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />


<!-- 상세 필터 -->
<div class="filter_group">
	<table>
		<tr>
			<td>
				<%
					if (fields != null && filter == null) {
				%>
				<div class="filter_area">
					<select name="selFilterLeftOperand">
						<%
							for (FormField field : fields) {
						%>
						<option value="<%=field.getId()%>"><%=field.getName()%></option>
						<%
							}
						%>
						<option value="<%=FormField.ID_OWNER%>">
							<fmt:message key='common.title.owner' />
						</option>
						<option value="<%=FormField.ID_CREATED_DATE%>">
							<fmt:message key='common.title.created_date' />
						</option>
						<option value="<%=FormField.ID_LAST_MODIFIER%>">
							<fmt:message key='common.title.last_modifier' />
						</option>
						<option value="<%=FormField.ID_LAST_MODIFIED_DATE%>">
							<fmt:message key='common.title.last_modified_date' />
						</option>
					</select> <select name="selFilterOperator">
						<option value=""></option>
					</select> <select name="selFilterRightOperand">
						<option value=""></option>
					</select>
					<div class="float_right space_l10">
						<button class="btn_x_grb"></button>
					</div>
				</div> <%
 	} else if (fields != null && filter != null) {
 		Condition[] conditions = filter.getConditions();
 		if (conditions != null) {
 			for (Condition condition : conditions) {
 %>
				<div class="filter_area">
					<select name="selFilterLeftOperand">
						<%
							for (FormField field : fields) {
						%>
						<option value="<%=field.getId()%>"><%=field.getName()%></option>
						<%
							}
						%>
						<option value="<%=FormField.ID_OWNER%>" <% %>>
							<fmt:message key='common.title.owner' />
						</option>
						<option value="<%=FormField.ID_CREATED_DATE%>">
							<fmt:message key='common.title.created_date' />
						</option>
						<option value="<%=FormField.ID_LAST_MODIFIER%>">
							<fmt:message key='common.title.last_modifier' />
						</option>
						<option value="<%=FormField.ID_LAST_MODIFIED_DATE%>">
							<fmt:message key='common.title.last_modified_date' />
						</option>
					</select> <select name="selFilterOperator">
						<option value=""></option>
					</select> <select name="selFilterRightOperand">
						<option value=""></option>
					</select>
					<div class="float_right space_l10">
						<button class="btn_x_grb"></button>
					</div>
				</div> <%
 			}

 		}
 	}
 %>
			</td>
			<td class="btn_plus"><img src="images/btn_plus.gif" /></td>
		</tr>
	</table>

	<div class="filter_btn_space">
		<div class="float_right">
			<span class="btn_gray"> <span class="Btn01Start"></span> <span
				class="Btn01Center">필터저장</span> <span class="Btn01End"></span> </span> <span
				class="btn_gray"> <span class="Btn01Start"></span> <span
				class="Btn01Center">필터실행</span> <span class="Btn01End"></span> </span>

		</div>
	</div>

</div>
