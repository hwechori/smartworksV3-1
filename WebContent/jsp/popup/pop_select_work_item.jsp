<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.service.impl.SmartWorks"%>
<%@page import="net.smartworks.model.instance.FieldData"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.instance.info.IWInstanceInfo"%>
<%@page import="net.smartworks.model.instance.info.InstanceInfoList"%>
<%@page import="net.smartworks.model.instance.info.RequestParams"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String workId = request.getParameter("workId");
	
	RequestParams params = new RequestParams();
	params.setCountInPage(20);
	params.setPageNumber(1);
	User cUser = SmartUtil.getCurrentUser();
	InformationWork work = (InformationWork) smartWorks.getWorkById(workId);
	InstanceInfoList instanceList = smartWorks.getIWorkInstanceList(workId, params);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!--  전체 레이아웃 -->
<div class="pop_corner_all pop_section_500">

	<!-- 팝업 타이틀 -->
	<div class="form_title">
		<div class="pop_title">업무항목</div>

		<div class="txt_btn">
			<div class="btn_x">
				<a href="" onclick="$.modal.close();return false;">X</a>
			</div>
		</div>

		<div class="solid_line"></div>
	</div>
	<!-- 팝업 타이틀 //-->

	<!-- 목록 테이블 -->
	<table>
		<tr class="tit_bg">
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
		%>
	
		<tr>
			<%
				if ((fieldDatas != null)
								&& (fieldDatas.length == displayFields.length)) {
							for (FieldData data : fieldDatas) {
			%>
			<td><a href="" class="js_content_iwork_space" workId="<%=workId%>" instId="<%=instanceInfo.getId()%>"><%=CommonUtil.toNotNull(data.getValue())%></a></td>
			<%
				}
						}
			%>
		</tr>
		<%
			}
			}
		%>
	</table>
	<!-- 목록 테이블 //-->
	
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

	<!-- 하단버튼영역 -->
	<div class="glo_btn_space">

		<div class="float_right">
			<span class="btn_gray"> <a onclick="$.modal.close();return false;" href=""> <span
					class="Btn01Start"></span> <span class="Btn01Center">닫기</span> <span
					class="Btn01End"></span> </a> </span>
		</div>

	</div>
	<!-- 하단버튼영역 //-->




</div>
<!-- 전체 레이아웃//-->
