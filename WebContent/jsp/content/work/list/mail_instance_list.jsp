<%@page import="net.smartworks.model.instance.info.MailInstanceInfo"%>
<%@page import="net.smartworks.model.mail.MailFolder"%>
<%@page import="net.smartworks.model.work.MailWork"%>
<%@page import="net.smartworks.model.instance.SortingField"%>
<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.service.impl.SmartWorks"%>
<%@page import="net.smartworks.model.instance.info.IWInstanceInfo"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.instance.info.InstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.InstanceInfoList"%>
<%@page import="net.smartworks.model.instance.info.RequestParams"%>
<%@page import="net.smartworks.model.instance.FieldData"%>
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
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String cid = request.getParameter("cid");
	String wid = request.getParameter("wid");

	RequestParams params = new RequestParams();
	params.setCountInPage(20);
	params.setPageNumber(1);
	params.setSortingField(new SortingField("date", false));
	String folderId = SmartUtil.getSpaceIdFromContentContext(cid);
	folderId = MailFolder.ID_INBOX;
	User cUser = SmartUtil.getCurrentUser();
	MailWork work = new MailWork(folderId, MailFolder.getFolderNameById(folderId), "");
	InstanceInfoList instanceList = smartWorks.getMailInstanceList(folderId, params);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 목록 테이블 -->
<table>
	<%
	SortingField sortedField = null;
	int countInPage = 0, totalPages = 0, currentPage = 0;
	if (instanceList != null
			&& (instanceList.getInstanceDatas() != null)
			&& (work != null)) {
		int type = instanceList.getType();
		sortedField = instanceList.getSortedField();
		if(sortedField==null) sortedField = new SortingField();
		countInPage = instanceList.getCountInPage();
		totalPages = instanceList.getTotalPages();
		currentPage = instanceList.getCurrentPage();
		currentPage = 1;
		FormField[] displayFields = work.getDisplayFields();
		MailInstanceInfo[] instanceInfos = (MailInstanceInfo[]) instanceList.getInstanceDatas();
	%>
	<tr class="tit_bg">
		<%
			FormField[] fields = work.getDisplayFields();
			if (fields != null) {
				for (FormField field : fields) {
			%>
 		<th class="r_line"><a href="" class="js_select_field_sorting" fieldId="<%=field.getId()%>"><%=field.getName()%> <%if(sortedField.getFieldId().equals(field.getId())){
 				if(sortedField.isAscending()){ %>▼<%}else{ %>▼<%}} %></a>
		</th>
<%-- 		<th class="r_line"><%=field.getName()%> <img class="bu_arr_b">
		</th>
 --%>			<%
				}
			}
			%>
	</tr>


		<%
		for (MailInstanceInfo instanceInfo : instanceInfos) {
			UserInfo owner = instanceInfo.getOwner();
			UserInfo lastModifier = instanceInfo.getLastModifier();
			cid = SmartWorks.CONTEXT_PREFIX_MAIL_SPACE + instanceInfo.getId();
			wid = instanceInfo.getWorkSpace().getId();
			String target = "mail_space.sw?cid=" + cid + "&wid=" + wid;
		%>
	<tr>
		<td><a href="<%=target%>" class="js_content"><%=CommonUtil.toNotNull(instanceInfo.getSender().getName())%></a></td>
		<td><a href="<%=target%>" class="js_content"><%=CommonUtil.toNotNull(instanceInfo.getSubject())%></a></td>
		<td><a href="<%=target%>" class="js_content"><%=CommonUtil.toNotNull(instanceInfo.getSendDate().toLocalString())%></a></td>
		<td><a href="<%=target%>" class="js_content"><%=CommonUtil.toNotNull(instanceInfo.getSize())%>B</a></td>
		<td><a href="<%=target%>" class="js_content"></a></td>
	</tr>
	<%
		}
	}
	%>
</table>
<form name="frmSortingField">
<%-- 	<input name="hdnSortingFieldId" type="hidden" value="<%=sortedField.getFieldId()%>" >
	<input name="hdnSortingIsAscending" type="hidden" value="<%=sortedField.isAscending()%>" >
 --%></form>
<!-- 목록 테이블 //-->

<form name="frmInstanceListPaging">
	<!-- 페이징 -->
	<div class="paginate">
		<%
			if (currentPage > 0 && totalPages > 0 && currentPage <= totalPages) {
				boolean isFirst10Pages = (currentPage <= 10) ? true : false;
				boolean isLast10Pages = ((currentPage / 10) == (totalPages / 10)) ? true
						: false;
				int startPage = (currentPage / 10) * 10 + 1;
				int endPage = isLast10Pages ? totalPages : startPage + 9;
				if (!isFirst10Pages) {
		%>
		<a class="pre_end js_select_paging" href="" title="<fmt:message key='common.title.first_page'/>">
			<span class="spr"></span><input name="hdnPrevEnd" type="hidden" value="false"> </a>		
		<a class="pre js_select_paging" href="" title="<fmt:message key='common.title.prev_10_pages'/> ">
			<span class="spr"></span><input name="hdnPrev10" type="hidden" value="false"></a>
		<%
			}
				for (int num = startPage; num <= endPage; num++) {
					if (num == currentPage) {
		%>
		<strong><%=num%></strong>
		<input name="hdnCurrentPage" type="hidden" value="<%=num%>"/>
		<%
			} else {
		%>
		<a class="num js_select_current_page" href=""><%=num%></a>
		<%
			}
				}
				if (!isLast10Pages) {
		%>
		<a class="next js_select_paging" title="<fmt:message key='common.title.next_10_pages'/> ">
			<span class="spr"></span><input name="hdnNext10" type="hidden" value="false"/></a>
		<a class="next_end js_select_paging" title="<fmt:message key='common.title.last_page'/> ">
		<span class="spr"><input name="hdnNextEnd" type="hidden" value="false"/></span> </a>
		<%
			}
			}
		%>
	</div>
	
	<div class="num_box">
		<select name="selListCountInPage" title="<fmt:message key='common.title.count_in_page'/> " onchange="selectListParam();return false;">
			<option <%if (countInPage == 10) {%> selected <%}%>>10</option>
			<option <%if (countInPage == 20) {%> selected <%}%>>20</option>
			<option <%if (countInPage == 30) {%> selected <%}%>>30</option>
			<option <%if (countInPage == 50) {%> selected <%}%>>50</option>
		</select>
	</div>
	<!-- 페이징 //-->
</form>
