<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.model.community.Department"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	
	String departId = request.getParameter("departId");
	Department department = (SmartUtil.isBlankObject(departId)) ? new Department() : smartWorks.getDepartmentById(departId);
	
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="js_edit_department">
	<!-- 회사정보 -->
	<div class="gray_style table_nomal600">
		<table>
			<tbody>
				<tr>
					<th class="text_align_c"><fmt:message key="profile.title.company"/></th>
					<td><%=CommonUtil.toNotNull(cUser.getCompany()) %></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- 회사정보//-->

	<!-- 부서추가 -->
	<!-- 타이틀 영역 -->
	<div style="display:block">
		<div class="default_title_space">
			<%
			if(SmartUtil.isBlankObject(departId)){
			%>
				<div class="title"><fmt:message key="settings.title.add_department"/></div>
			<%
			}else{
			%>
				<div class="title"><fmt:message key="settings.title.modify_department"/></div>
			<%
			}
			%>
		</div>
		<!-- 타이틀 영역 //-->
		
		<div class="boTb">
			<table class="margin_t10">
				<tbody>
					<tr>
						<%
						String parentName = (SmartUtil.isBlankObject(department.getParent())) ? "" : department.getParent().getName();
						%>
						<td width="20%" ><fmt:message key="settings.title.department.parent_name"/></td>
						<td width="80%"><input readonly class="fieldline" type="text" value="<%=parentName %>" /></td>
					</tr>
					<tr>
						<td><fmt:message key="profile.title.department"/></td>
						<td><input class="fieldline" type="text" title="" value="<%=CommonUtil.toNotNull(department.getName()) %>" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	
		<!-- Btn -->
		<div class="text_align_r margin_t8">
			<span class="btn_gray">
				<span class="Btn01Start"></span>
				<%
				if(SmartUtil.isBlankObject(departId)){
				%>
					<span class="Btn01Center"><fmt:message key="common.button.create"/></span>
				<%
				}else{
				%>
					<span class="Btn01Center"><fmt:message key="common.button.save"/></span>
				<%
				}
				%>
				<span class="Btn01End"></span>
			</span>
		</div>
		<!-- Btn //-->
	</div>
	<!-- 부서추가 //-->
</div>									
