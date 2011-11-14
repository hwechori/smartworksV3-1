<%@page import="net.smartworks.model.community.Group"%>
<%@page import="net.smartworks.model.work.AccessPolicy"%>
<%@page import="net.smartworks.model.community.Department"%>
<%@page import="net.smartworks.model.community.Community"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%
	String wid = request.getParameter("wid");
	if (wid == null)
		wid = SmartUtil.getCurrentUser().getId();

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");

	String workId = request.getParameter("workId");
	User cUser = SmartUtil.getCurrentUser();

	Work work = smartWorks.getWorkById(workId);
	if (work == null)
		work = new Work();
	Community[] communities = smartWorks.getMyCommunities();
%>

<!-- 등록 취소 버튼 -->
<div class="glo_btn_space">

	<div class="float_right">
		<span class="btn_gray"> 
		<a href="" onclick='submitForms(); return false;'> 
			<span class="Btn01Start"></span>
				<span class="Btn01Center"><fmt:message
						key="common.button.complete"/>
				</span> 
			<span class="Btn01End"></span> </a> </span> 
			
			<span class="btn_gray">
			<a href=""> <span class="Btn01Start"></span> <span
				class="Btn01Center"><fmt:message key="common.button.cancel" />
			</span> <span class="Btn01End"></span> </a> </span>
	</div>

	<form name="frmAccessSpace" class="float_right padding_r10">
		<div id="" class="float_right form_space">
			<select name="selWorkSpace">
				<option  value="<%=cUser.getId()%>">
					<fmt:message key="common.upload.space.self" />
				</option>
				<optgroup
					label="<fmt:message key="common.upload.space.department"/>">
					<%
						for (Community community : communities) {
							if (community.getClass().equals(Department.class)) {
					%>
					<option value="<%=community.getId()%>"><%=community.getName()%></option>
					<%
						}
						}
					%>
				</optgroup>
				<optgroup label="<fmt:message key="common.upload.space.group"/>">
					<%
						for (Community community : communities) {
							if (community.getClass().equals(Group.class)) {
					%>
					<option value="<%=community.getId()%>"><%=community.getName()%></option>
					<%
						}
						}
					%>
				</optgroup>
			</select>
		</div>

		<div id="" class="float_right form_space">
			<select name="selAccessLevel">
				<%
					int accessLevel = work.getAccessPolicy().getLevel();
					if (accessLevel == AccessPolicy.LEVEL_PUBLIC) {
				%>
				<option selected value="<%=AccessPolicy.LEVEL_PUBLIC%>">
					<fmt:message key="common.upload.open.public" />
				</option>
				<option value="<%=AccessPolicy.LEVEL_PRIVATE%>">
					<fmt:message key="common.upload.open.private" />
				</option>
				<option value="<%=AccessPolicy.LEVEL_CUSTOM%>">
					<fmt:message key="common.upload.open.custom" />
				</option>
				<%
					} else if (work.getAccessPolicy().getLevel() == AccessPolicy.LEVEL_CUSTOM) {
				%>
				<option value="<%=AccessPolicy.LEVEL_PRIVATE%>">
					<fmt:message key="common.upload.open.private" />
				</option>
				<option selected value="<%=AccessPolicy.LEVEL_CUSTOM%>">
					<fmt:message key="common.upload.open.custom" />
				</option>
				<%
					} else if (work.getAccessPolicy().getLevel() == AccessPolicy.LEVEL_PUBLIC) {
				%>
				<option value="<%=AccessPolicy.LEVEL_PRIVATE%>">
					<fmt:message key="common.upload.open.private" />
				</option>
				<%
					}
				%>
			</select>
		</div>
	</form>

</div>
<!-- 등록 취소 버튼//-->