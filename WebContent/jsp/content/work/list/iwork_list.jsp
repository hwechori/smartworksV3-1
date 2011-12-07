<%@page import="net.smartworks.model.report.ChartReport"%>
<%@page import="net.smartworks.model.report.info.ReportInfo"%>
<%@page import="net.smartworks.model.filter.info.SearchFilterInfo"%>
<%@page import="net.smartworks.model.report.Report"%>
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

	String workId = SmartUtil.getSpaceIdFromContentContext(cid);
	User cUser = SmartUtil.getCurrentUser(request, response);
	InformationWork work = (InformationWork) smartWorks.getWorkById(cUser.getCompanyId(), cUser.getId(), workId);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 컨텐츠 레이아웃-->
<div class="section_portlet">
	<div class="portlet_t">
		<div class="portlet_tl"></div>
	</div>
	<div class="portlet_l" style="display: block;">
		<ul class="portlet_r" style="display: block;">

			<!-- 타이틀 -->
			<div class="body_titl">
				<div class="body_titl_iworks title"><%=work.getName()%></div>

				<!-- 우측 버튼 -->
				<div class="txt_btn">

					<!-- 수정하기 -->
					<div class="float_right space_l5">
						<%
							if (cUser.getUserLevel() == User.USER_LEVEL_AMINISTRATOR) {
						%>
						<span class="btn_gray"> <span class="Btn01Start"></span> <span
							class="Btn01Center"><fmt:message
									key='common.button.modify' /> </span> <span class="Btn01End"></span>
						</span>
						<%
							}
						%>
					</div>
					<!-- 수정하기 //-->

					<!-- 최종수정자 -->
					<div class="float_right">
						<img class="pho_user"
							title="<fmt:message key="common.title.last_modifier" />"
							src="<%=work.getLastModifier().getMinPicture()%>"> <span
							class="t_name"><%=work.getLastModifier().getLongName()%></span> <span
							class="t_date"><%=work.getLastModifiedDate().toLocalString()%>
						</span>
					</div>
					<!-- 최종수정자 //-->

				</div>
				<!-- 우측 버튼 //-->




				<div class="solid_line"></div>
			</div>
			<!-- 타이틀 -->


			<!-- 컨텐츠 -->
			<div class="contents_space js_content_div">

				<!-- 업무 정의 영역 -->
				<div class="">
					<%if(work.getDesc()!= null && !work.getDesc().equals("")) {%>
					<%=work.getDesc()%>
					<%}else{ %><fmt:message key="common.message.no_work_desc" />
					<%} %>
				</div>
				<!-- 업무 정의 영역 //-->

				<!-- 버튼 영역-->
				<div class="txt_btn solid_line_sb margin_t15">
					<span class="po_left bu_work_explan"> <a
						class="js_view_work_manual" href=""><fmt:message
								key="common.button.view.work_manual" />▼</a> <a
						style="display: none" class="js_view_work_manual" href=""><fmt:message
								key="common.button.close.work_manual" />▼</a> </span> <span
						class="po_left"> <%
 	if (work.getManualFileName() != null) {
 %> <a href="" class="bu_video space_r2"
						title="<fmt:message key='work.title.manual_file'/>"></a> <%
 	}
 	if (work.getHelpUrl() != null) {
 %> <a href="<%=work.getHelpUrl()%>" class="bu_webex"
						title="<fmt:message key='work.title.help_url'/>" target="_blank">
					</a> <%
 	}
 %> </span>

					<!-- 우측 권한 아이콘-->
					<span> <%
 	switch (work.getAccessPolicy().getLevel()) {
 	case AccessPolicy.LEVEL_PUBLIC:
 %>
						<div class="ch_right">
							<fmt:message key="common.security.access.public" />
						</div> <%
 	break;
 	case AccessPolicy.LEVEL_PRIVATE:
 %>
						<div class="ch_right">
							<fmt:message key="common.security.access.private" />
						</div> <%
 	break;
 	case AccessPolicy.LEVEL_CUSTOM:
 %>
						<div class="ch_right">
							<fmt:message key="common.security.access.custom" />
						</div> <%
 	break;
 	}
 %>
						<div class="po_right">
							<span class="bu_read"></span>
						</div> <%
 	switch (work.getWritePolicy().getLevel()) {
 	case WritePolicy.LEVEL_PUBLIC:
 %>
						<div class="ch_right">
							<fmt:message key="common.security.write.public" />
						</div> <%
 	break;
 	case WritePolicy.LEVEL_CUSTOM:
 %>
						<div class="ch_right">
							<fmt:message key="common.security.write.custom" />
						</div> <%
 	break;
 	}
 %>
						<div class="po_right">
							<span class="bu_regit"></span>
						</div> <%
 	switch (work.getEditPolicy().getLevel()) {
 	case EditPolicy.LEVEL_WIKI:
 %>
						<div class="ch_right">
							<fmt:message key="common.security.edit.wiki" />
						</div> <%
 	break;
 	case EditPolicy.LEVEL_BLOG:
 %>
						<div class="ch_right">
							<fmt:message key="common.security.edit.blog" />
						</div> <%
 	break;
 	}
 %>
						<div class="po_right">
							<span class="bu_modfy"></span>
						</div> </span>
					<!-- 우측 권한 아이콘-->

				</div>
				<!-- 버튼 영역 //-->


			</div>
			<div id="work_manual" style="display: none">
				<jsp:include page="/jsp/content/work/list/iwork_manual.jsp"></jsp:include>
			</div>

			<!-- 목록영역  -->
			<div class="contents_space">

				<!--통계메뉴 영역-->
				<div class="txt_btn margin_b5 margin_t10 js_work_report">

					<div class="po_right">
						<a href="work_report.sw?workId=<%=work.getId()%>"
							class="js_new_work_report">새 통계분석 만들기</a>
					</div>
					<div class="po_right bu_stat">
						<select name="selMyReportList" class="js_select_work_report"
							href="work_report.sw?workId=<%=workId%>">
							<%
								Report[] infoReports = ChartReport.DEFAULT_CHARTS_INFORMATION;
								if (infoReports != null) {
									for (Report report : infoReports) {
							%>
							<option value="<%=report.getId()%>">
								<fmt:message key="<%=report.getName()%>" />
							</option>
							<%
									}
								}
							%>
							<%
								ReportInfo[] reports = work.getReports();
								if (reports != null) {
									for (ReportInfo report : reports) {
							%>
							<option value="<%=report.getId()%>"><%=report.getName()%></option>
							<%
									}
								}
							%>
						</select>
					</div>
				</div>

				<!--통계메뉴 영역//-->

				<div id="chart_target" class="js_work_report_form margin_b5">
				</div>

				<!-- 목록보기 -->
				<div class="">

					<!-- 목록보기 타이틀-->
					<div class="list_title_space js_work_list_title">

						<div class="txt_btn posi_ab">

							<div class="title">
								<fmt:message key="common.title.instance_list" />
							</div>
							<div class="po_left">
								<div class="srch_wh srch_wsize">
									<input id="" class="nav_input" type="text"
										placeholder="<fmt:message key='search.search_work' />">
									<button onclick=""
										title="<fmt:message key='search.search_work'/>"></button>
								</div>
							</div>

							<div class="po_left">
								<form class="form_space" name="frmIworkFilterName">
									<select name="selFilterName" class="js_select_filter"
										href="search_filter.sw?workId=<%=workId%>">
										<option value="<%=SearchFilter.FILTER_ALL_INSTANCES%>"
											selected>
											<fmt:message key='filter.name.all_instances' />
										</option>
										<option value="<%=SearchFilter.FILTER_MY_INSTANCES%>">
											<fmt:message key='filter.name.my_instances' />
										</option>
										<option value="<%=SearchFilter.FILTER_RECENT_INSTANCES%>">
											<fmt:message key='filter.name.recent_instances' />
										</option>
										<option value="<%=SearchFilter.FILTER_MY_RECENT_INSTANCES%>">
											<fmt:message key='filter.name.my_recent_instances' />
										</option>
										<%
											SearchFilterInfo[] filters = work.getSearchFilters();
											if (filters != null) {
												for (SearchFilterInfo filter : filters) {
										%>
										<option value="<%=filter.getId()%>">
											<%=filter.getName()%>
										</option>
										<%
											}
											}
										%>
									</select>
								</form>
							</div>
							<a href="search_filter.sw?workId=<%=workId%>"
								class="js_search_filter"><div class="po_left">
									<fmt:message key='filter.button.search_filter' />
								</div> </a>
						</div>

						<div class="txt_btn">
							<div class="po_right">
								<a href="">엑셀로 등록하기</a>
							</div>
							<div class="po_right">
								<a href="new_iwork.sw?workId=<%=workId%>"
									class="js_create_new_work">새항목 등록하기</a>
							</div>
						</div>
					</div>
					<!-- 목록보기 타이틀-->

					<!-- 상세필터 -->
					<div id="search_filter" class="filter_section js_new_work_form"></div>
					<!-- 상세필터 -->

					<!-- 목록 테이블 -->
					<div class="list_contents">
						<div id='iwork_list_page'>
							<jsp:include
								page="/jsp/content/work/list/iwork_instance_list.jsp"></jsp:include>
						</div>

						<!-- 목록 테이블 //-->

					</div>
					<!-- 목록영역 // -->
		</ul>
	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 컨텐츠 레이아웃//-->
