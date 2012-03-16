<%@page import="net.smartworks.model.work.info.SmartTaskInfo"%>
<%@page import="net.smartworks.model.instance.Instance"%>
<%@page import="net.smartworks.model.instance.SortingField"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.service.impl.SmartWorks"%>
<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.PWInstanceInfo"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.instance.info.InstanceInfo"%>
<%@page import="net.smartworks.model.work.ProcessWork"%>
<%@page import="net.smartworks.model.instance.FieldData"%>
<%@page import="net.smartworks.model.instance.info.InstanceInfoList"%>
<%@page import="net.smartworks.model.instance.info.RequestParams"%>
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
	ProcessWork work = (ProcessWork)session.getAttribute("smartWork");
	SmartTaskInfo[] tasks = work.getDiagram().getTasks();
	SmartTaskInfo startTask = null;
	if(!SmartUtil.isBlankObject(tasks)){
		for(int i=0; i<tasks.length; i++){
			if(tasks[i].isStartTask()){
				startTask = tasks[i];
				break;
			}
		}
		startTask = tasks[0];
	}
	String workId = work.getId();
	InstanceInfoList instanceList = smartWorks.getPWorkInstanceList(workId, params);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 목록페이지 -->
<table>
	<%
	SortingField sortedField = new SortingField();
	int pageSize = 20, totalPages = 1, currentPage = 1;
	if (instanceList != null && work != null) {
		int type = instanceList.getType();
		sortedField = instanceList.getSortedField();
		if(sortedField==null) sortedField = new SortingField();
	%>
		<tr class="tit_bg">
	 		<th class="r_line" style="width:40px;">
				<span><fmt:message key="common.title.number"/></span>
			</th>
			<th class="r_line">
	 			<a href="" class="js_select_field_sorting" fieldId="<%=FormField.ID_STATUS%>"><fmt:message key='common.title.status'/>
			 		<%
					if(sortedField.getFieldId().equals(FormField.ID_STATUS)){
						if(sortedField.isAscending()){ %>▼<%}else{ %>▼<%}} 
					%>
				</a>				
			</th>
			<th class="r_line">
	 			<a href="" class="js_select_field_sorting" fieldId="<%=FormField.ID_OWNER%>"><fmt:message key='common.title.owner'/>
			 		<%
					if(sortedField.getFieldId().equals(FormField.ID_OWNER)){
						if(sortedField.isAscending()){ %>▼<%}else{ %>▼<%}} 
					%>
				</a>/				
	 			<a href="" class="js_select_field_sorting" fieldId="<%=FormField.ID_CREATED_DATE%>"><fmt:message key='common.title.created_date'/>
			 		<%
					if(sortedField.getFieldId().equals(FormField.ID_CREATED_DATE)){
						if(sortedField.isAscending()){ %>▼<%}else{ %>▼<%}} 
					%>
				</a>
			</th>				
			<th class="r_line">
	 			<a href="" class="js_select_field_sorting" fieldId="<%=FormField.ID_SUBJECT%>"><fmt:message key='common.title.instance_subject'/>
			 		<%
					if(sortedField.getFieldId().equals(FormField.ID_SUBJECT)){
						if(sortedField.isAscending()){ %>▼<%}else{ %>▼<%}} 
					%>
				</a>				
			</th>
			<th class="r_line">
	 			<a href="" class="js_select_field_sorting" fieldId="<%=FormField.ID_LAST_TASK%>"><fmt:message key='common.title.last_task'/>
			 		<%
					if(sortedField.getFieldId().equals(FormField.ID_SUBJECT)){
						if(sortedField.isAscending()){ %>▼<%}else{ %>▼<%}} 
					%>
				</a>						
			</th>
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
		pageSize = instanceList.getPageSize();
		totalPages = instanceList.getTotalPages();
		currentPage = instanceList.getCurrentPage();
		int currentCount = instanceList.getTotalSize()-(currentPage-1)*pageSize;
		if(instanceList.getInstanceDatas() != null) {
			PWInstanceInfo[] instanceInfos = (PWInstanceInfo[])instanceList.getInstanceDatas();
			for (PWInstanceInfo instanceInfo : instanceInfos) {
				UserInfo owner = instanceInfo.getOwner();
				UserInfo lastModifier = instanceInfo.getLastModifier();
				TaskInstanceInfo lastTask = instanceInfo.getLastTask();
				String target = instanceInfo.getController() + "?cid=" + instanceInfo.getContextId() + "&workId=" + workId;
				String statusImage = "";
				String statusTitle = "";
				switch (instanceInfo.getStatus()) {
				// 인스턴스가 현재 진행중인 경우..
				case Instance.STATUS_RUNNING:
					statusImage = "images/icon_status_running.jpg";
					statusTitle = "content.status.running";
					break;
				// 인스턴스가 지연진행중인 경우....
				case Instance.STATUS_DELAYED_RUNNING:
					statusImage = "images/icon_status_d_running.jpg";
					statusTitle = "content.status.delayed_running";
					break;
				// 인스턴스가 반려된 경우...
				case Instance.STATUS_RETURNED:
					statusImage = "images/icon_status_returned.jpg";
					statusTitle = "content.status.returned";
					break;
				// 인스턴스가 완료된 경우...
				case Instance.STATUS_COMPLETED:
					statusImage = "images/icon_status_completed.jpg";
					statusTitle = "content.status.completed";
					break;
				// 기타 잘못되어 상태가 없는 경우..
				default:
					statusImage = "images/icon_status_not_yet.jpg";
					statusTitle = "content.status.not_yet";
				}
			%>
				<tr class="instance_list js_content_pwork_space" href="<%=target%>">
					<td class="tc"><%=currentCount%></td>
					<td>
						<div>
							<img src="<%=statusImage%>" title="<fmt:message key='<%=statusTitle%>'/>"/>
						</div>
					</td>
					<td>
						<div class="noti_pic">
							<img src="<%=owner.getMinPicture()%>" title="<%=owner.getLongName()%>" class="profile_size_s" />
						</div>
						<div class="noti_in">
							<span class="t_name"><%=owner.getLongName()%></span>
							<div class="t_date"><%if(instanceInfo.getCreatedDate()!=null){%><%=instanceInfo.getCreatedDate().toLocalString()%><%} %></div>
						</div>
					</td>
					<td>
						<%=instanceInfo.getSubject()%>
						<%if(instanceInfo.getSubInstanceCount()>0){ %><font class="t_sub_count">[<b><%=instanceInfo.getSubInstanceCount() %></b>]</font><%} %>
						<%if(instanceInfo.isNew()){ %><span class="icon_new"></span><%} %>
					</td>
					<td><%=lastTask.getName()%></td>
					<td>
						<%
						if(!SmartUtil.isBlankObject(lastModifier)){
						%>
							<div class="noti_pic">
								<img src="<%=lastModifier.getMinPicture()%>" title="<%=lastModifier.getLongName()%>" class="profile_size_s" />
							</div>
							<div class="noti_in">
								<span class="t_name"><%=lastModifier.getLongName()%></span>
								<div class="t_date"><%=instanceInfo.getLastModifiedDate().toLocalString()%></div>
							</div>
						<%
						}
						%>
					</td>
				</tr>
	<%
				currentCount--;
			}
		}
	}else if(!SmartUtil.isBlankObject(work)){
			sortedField = new SortingField();
	%>
		<tr class="tit_bg">
	 		<th class="r_line" style="width:40px;">
				<span><fmt:message key="common.title.number"/></span>
			</th>
			<th class="r_line">
	 			<a href="" class="js_select_field_sorting" fieldId="<%=FormField.ID_STATUS%>"><fmt:message key='common.title.status'/>
			 		<%
					if(sortedField.getFieldId().equals(FormField.ID_STATUS)){
						if(sortedField.isAscending()){ %>▼<%}else{ %>▼<%}} 
					%>
				</a>				
			</th>
			<th class="r_line">
	 			<a href="" class="js_select_field_sorting" fieldId="<%=FormField.ID_OWNER%>"><fmt:message key='common.title.owner'/>
			 		<%
					if(sortedField.getFieldId().equals(FormField.ID_OWNER)){
						if(sortedField.isAscending()){ %>▼<%}else{ %>▼<%}} 
					%>
				</a>/				
	 			<a href="" class="js_select_field_sorting" fieldId="<%=FormField.ID_CREATED_DATE%>"><fmt:message key='common.title.created_date'/>
			 		<%
					if(sortedField.getFieldId().equals(FormField.ID_CREATED_DATE)){
						if(sortedField.isAscending()){ %>▼<%}else{ %>▼<%}} 
					%>
				</a>
			</th>				
			<th class="r_line">
	 			<a href="" class="js_select_field_sorting" fieldId="<%=FormField.ID_SUBJECT%>"><fmt:message key='common.title.instance_subject'/>
			 		<%
					if(sortedField.getFieldId().equals(FormField.ID_SUBJECT)){
						if(sortedField.isAscending()){ %>▼<%}else{ %>▼<%}} 
					%>
				</a>				
			</th>
			<th class="r_line">
	 			<a href="" class="js_select_field_sorting" fieldId="<%=FormField.ID_LAST_TASK%>"><fmt:message key='common.title.last_task'/>
			 		<%
					if(sortedField.getFieldId().equals(FormField.ID_SUBJECT)){
						if(sortedField.isAscending()){ %>▼<%}else{ %>▼<%}} 
					%>
				</a>						
			</th>
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
	}
	%>
</table>
<!-- 목록페이지 //-->

<%
if(instanceList == null || work == null || SmartUtil.isBlankObject(instanceList.getInstanceDatas())){
%>
	<div><fmt:message key="common.message.no_instance"/></div>

<%
}
if(!SmartUtil.isBlankObject(sortedField)){
%>
	<form name="frmSortingField">
		<input name="hdnSortingFieldId" type="hidden" value="<%=sortedField.getFieldId()%>">
		<input name="hdnSortingIsAscending" type="hidden" value="<%=sortedField.isAscending()%>">
	</form>
<%
}
%>
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
