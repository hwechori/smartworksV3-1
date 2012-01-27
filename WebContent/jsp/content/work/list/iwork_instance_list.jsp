<%@page import="java.text.NumberFormat"%>
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
	ISmartWorks smartWorks = (ISmartWorks)request.getAttribute("smartWorks");
	RequestParams params = (RequestParams)request.getAttribute("requestParams");
	if(SmartUtil.isBlankObject(params)){
		params = new RequestParams();
		params.setPageSize(20);
		params.setCurrentPage(1);		
	}
	User cUser = SmartUtil.getCurrentUser();
	InformationWork work = (InformationWork)session.getAttribute("smartWork");
	String workId = work.getId();
	InstanceInfoList instanceList = smartWorks.getIWorkInstanceList(workId, params);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 목록 테이블 -->
<table>
	<%
	SortingField sortedField = null;
	int pageSize = 0, totalPages = 0, currentPage = 0;
	if (instanceList != null && work != null) {
		int type = instanceList.getType();
		sortedField = instanceList.getSortedField();
		if(sortedField==null) sortedField = new SortingField();
		pageSize = instanceList.getPageSize();
		totalPages = instanceList.getTotalPages();
		currentPage = instanceList.getCurrentPage();
		FormField[] displayFields = work.getDisplayFields();
		if(instanceList.getInstanceDatas() != null) {
			IWInstanceInfo[] instanceInfos = (IWInstanceInfo[]) instanceList.getInstanceDatas();
	%>
			<tr class="tit_bg">
				<%
				FormField[] fields = work.getDisplayFields();
				if (fields != null) {
					for (FormField field : fields) {
				%>
				 		<th class="r_line">
				 			<a href="" class="js_select_field_sorting" fieldId="<%=field.getId()%>"><%=field.getName()%>
						 		<%
								if(sortedField.getFieldId().equals(field.getId())){
									if(sortedField.isAscending()){ %>▼<%}else{ %>▼<%}} 
								%>
							</a>
							<span class="js_progress_span"></span>
						</th>
				<%
					}
				}
				%>
				<th>
					<a href="" class="js_select_field_sorting" fieldId="<%=FormField.ID_LAST_MODIFIER %>">
						<fmt:message key='common.title.last_modifier' /> <%if(sortedField.getFieldId().equals(FormField.ID_LAST_MODIFIER)){
							if(sortedField.isAscending()){ %>▼<%}else{ %>▼<%}} %>
					</a>/
					<a href="" class="js_select_field_sorting" fieldId="<%=FormField.ID_LAST_MODIFIED_DATE%>">
						<fmt:message key='common.title.last_modified_date' /> <%if(sortedField.getFieldId().equals(FormField.ID_LAST_MODIFIED_DATE)){
							if(sortedField.isAscending()){ %>▼<%}else{ %>▼<%}} %>
					</a>
					<span class="js_progress_span"></span>
				</th>		
			</tr>
			<%
			for (IWInstanceInfo instanceInfo : instanceInfos) {
				UserInfo owner = instanceInfo.getOwner();
				UserInfo lastModifier = instanceInfo.getLastModifier();
				FieldData[] fieldDatas = instanceInfo.getDisplayDatas();
				String cid = SmartWorks.CONTEXT_PREFIX_IWORK_SPACE + instanceInfo.getId();
				String target = "iwork_space.sw?cid=" + cid + "&workId=" + workId;
			%>
				<tr>
					<%
					if ((fieldDatas != null) && (fieldDatas.length == displayFields.length)) {
						NumberFormat nf = NumberFormat.getNumberInstance();
						NumberFormat pf = NumberFormat.getPercentInstance();
						for (FieldData data : fieldDatas) {
					%>
							<td <%if(data.getFieldType().equals(FormField.TYPE_CURRENCY) || 
									data.getFieldType().equals(FormField.TYPE_NUMBER) || 
									data.getFieldType().equals(FormField.TYPE_PERCENT)){ %>class="hAlignRight"<%} %>>
								<a href="<%=target%>" class="js_content_iwork_space" workId="<%=workId%>" instId="<%=instanceInfo.getId()%>">
									<%if(data.getFieldType().equals(FormField.TYPE_FILE)){%><img src="images/file/icon_bmp.gif" groupId="<%=data.getValue()%>">
									<%}else if(data.getFieldType().equals(FormField.TYPE_NUMBER)){%><%=data.getValue() != null ? CommonUtil.toNotNull(nf.format(Float.parseFloat(data.getValue()))) : CommonUtil.toNotNull(data.getValue())%>
									<%}else if(data.getFieldType().equals(FormField.TYPE_PERCENT)){%><%=data.getValue() != null ? CommonUtil.toNotNull(pf.format(Float.parseFloat(data.getValue())*100)) : CommonUtil.toNotNull(data.getValue())%>
									<%}else if(data.getFieldType().equals(FormField.TYPE_CURRENCY)){%><%=data.getSymbol()%><%=data.getValue() != null ? CommonUtil.toNotNull(nf.format(Float.parseFloat(data.getValue()))) : CommonUtil.toNotNull(data.getValue())%>
									<%}else if(data.getFieldType().equals(FormField.TYPE_IMAGE) ||
												data.getFieldType().equals(FormField.TYPE_RICHTEXT_EDITOR) ||
												data.getFieldType().equals(FormField.TYPE_DATA_GRID)){%>
									<%}else{%><%=CommonUtil.toNotNull(data.getValue())%><%} %>
								</a>
							</td>
					<%
						}
					}
					%>
					<td>
						<a href="<%=target%>" class="js_content_iwork_space" workId="<%=workId%>" instId="<%=instanceInfo.getId()%>">
							<div class="noti_pic js_content_iwork_space">
								<img src="<%=lastModifier.getMinPicture()%>" title="<%=lastModifier.getLongName()%>" class="profile_size_s" />
							</div>
							<div class="noti_in">
								<span class="t_name"><%=lastModifier.getLongName()%></span>
								<div class="t_date"><%=instanceInfo.getLastModifiedDate().toLocalString()%></div>
							</div>
						</a>
					</td>
				</tr>
	<%
			}
		}
	}
	%>
</table>
<form name="frmSortingField">
	<input name="hdnSortingFieldId" type="hidden" value="<%=sortedField.getFieldId()%>">
	<input name="hdnSortingIsAscending" type="hidden" value="<%=sortedField.isAscending()%>">
</form>
<!-- 목록 테이블 //-->

<form name="frmInstanceListPaging">
	<!-- 페이징 -->
	<div class="paginate">
		<%
		if (currentPage > 0 && totalPages > 0 && currentPage <= totalPages) {
			boolean isFirst10Pages = (currentPage <= 10) ? true : false;
			boolean isLast10Pages = (((currentPage - 1)  / 10) == ((totalPages - 1) / 10)) ? true : false;
			int startPage = ((currentPage - 1) / 10) * 10 + 1;
			int endPage = isLast10Pages ? totalPages : startPage + 9;
			if (!isFirst10Pages) {
		%>
				<a class="pre_end js_select_paging" href="" title="<fmt:message key='common.title.first_page'/>">
					<span class="spr"></span>
					<input name="hdnPrevEnd" type="hidden" value="false"> 
				</a>		
				<a class="pre js_select_paging" href="" title="<fmt:message key='common.title.prev_10_pages'/> ">
					<span class="spr"></span>
					<input name="hdnPrev10" type="hidden" value="false">
				</a>
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
					<span class="spr"></span>
					<input name="hdnNext10" type="hidden" value="false"/>
				</a>
				<a class="next_end js_select_paging" title="<fmt:message key='common.title.last_page'/> ">
					<span class="spr"><input name="hdnNextEnd" type="hidden" value="false"/></span> 
				</a>
		<%
			}
		}
		%>
		<span class="js_progress_span"></span>
	</div>
	
	<div class="num_box">
		<span class="js_progress_span"></span>
		<select class="js_select_page_size" name="selPageSize" title="<fmt:message key='common.title.count_in_page'/>">
			<option <%if (pageSize == 10) {%> selected <%}%>>10</option>
			<option <%if (pageSize == 20) {%> selected <%}%>>20</option>
			<option <%if (pageSize == 30) {%> selected <%}%>>30</option>
			<option <%if (pageSize == 50) {%> selected <%}%>>50</option>
		</select>
	</div>
	<!-- 페이징 //-->
</form>
