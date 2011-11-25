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
	String companyId = (String) session.getAttribute("companyId");
	String userId = (String) session.getAttribute("userId");

	ISmartWorks smartWorks = (ISmartWorks) request
			.getAttribute("smartWorks");
	String cid = request.getParameter("cid");
	String wid = request.getParameter("wid");

	RequestParams params = new RequestParams();
	params.setCountInPage(20);
	params.setPageNumber(2);
	String workId = SmartUtil.getSpaceIdFromContentContext(cid);
	User cUser = SmartUtil.getCurrentUser(request);
	InformationWork work = (InformationWork) smartWorks.getWorkById(
			companyId, cUser.getId(), workId);
	InstanceInfoList instanceList = smartWorks.getIWorkInstanceList(
			companyId, cUser.getId(), workId, params);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />
<!-- 목록 테이블 -->
<table>
	<tr class="tit_bg">
		<th></th>
		<%
			FormField[] fields = work.getDisplayFields();
			if (fields != null) {
				for (FormField field : fields) {
		%>
		<th class="r_line"><%=field.getName()%> <img class="bu_arr_b">
		</th>
		<%
			}
			}
		%>
		<th><fmt:message key='common.title.last_modifier' />/<fmt:message
				key='common.title.last_modified_date' /></th>
	</tr>


	<%
		int countInPage = 0, totalPages = 0, currentPage = 0;
		if (instanceList != null
				&& (instanceList.getInstanceDatas() != null)
				&& (work != null)) {
			int type = instanceList.getType();
			countInPage = instanceList.getCountInPage();
			totalPages = instanceList.getTotalPages();
			currentPage = instanceList.getCurrentPage();
			FormField[] displayFields = work.getDisplayFields();
			IWInstanceInfo[] instanceInfos = (IWInstanceInfo[]) instanceList
					.getInstanceDatas();
			for (IWInstanceInfo instanceInfo : instanceInfos) {
				UserInfo owner = instanceInfo.getOwner();
				UserInfo lastModifier = instanceInfo.getLastModifier();
				FieldData[] fieldDatas = instanceInfo.getDisplayDatas();
				cid = SmartWorks.CONTEXT_PREFIX_IWORK_SPACE
						+ instanceInfo.getId();
				wid = instanceInfo.getWorkSpace().getId();
				String target = "iwork_space.sw?cid=" + cid + "&wid=" + wid;
	%>



	<tr>
		<td><a href="<%=target%>"><img
				src="<%=owner.getMinPicture()%>" title="<%=owner.getLongName()%>" />
		</a>
		</td>
		<%
			if ((fieldDatas != null)
							&& (fieldDatas.length == displayFields.length)) {
						for (FieldData data : fieldDatas) {
		%>
		<td><a href="<%=target%>"><%=data.getValue()%></a></td>
		<%
			}
					}
		%>
		<td><a href="<%=target%>"><div class="noti_pic">
					<img src="<%=lastModifier.getMinPicture()%>"
						title="<%=lastModifier.getLongName()%>" align="bottom" />
				</div>
				<div class="noti_in">
					<span class="t_name"><%=lastModifier.getLongName()%></span>
					<div class="t_date"><%=instanceInfo.getLastModifiedDate()
							.toLocalString()%></div>
				</div> </a></td>
	</tr>
	<%
		}
		}
	%>
</table>
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
	<a class="pre_end" title="<fmt:message key='common.title.first_page'/>"><span
		class="spr"></span> </a> <a class="pre"
		title="<fmt:message key='common.title.prev_10_pages'/> "><span
		class="spr"></span> </a>
	<%
		}
			for (int num = startPage; num <= endPage; num++) {
				if (num == currentPage) {
	%>
	<strong><%=num%></strong>
	<%
		} else {
	%>
	<a class="num" href=""><%=num%></a>
	<%
		}
			}
			if (!isLast10Pages) {
	%>
	<a class="next"
		title="<fmt:message key='common.title.next_10_pages'/> "><span
		class="spr"></span> </a> <a class="next_end"
		title="<fmt:message key='common.title.last_page'/> "><span
		class="spr"></span> </a>
	<%
		}
		}
	%>
</div>

<div class="num_box">
	<select name=""
		title="<fmt:message key='common.title.count_in_page'/> ">
		<option <%if (countInPage == 10) {%> selected <%}%>>10</option>
		<option <%if (countInPage == 20) {%> selected <%}%>>20</option>
		<option <%if (countInPage == 30) {%> selected <%}%>>30</option>
		<option <%if (countInPage == 50) {%> selected <%}%>>50</option>
	</select>
</div>
<!-- 페이징 //-->
