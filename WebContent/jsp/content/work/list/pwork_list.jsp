<%@page import="net.smartworks.model.filter.info.SearchFilterInfo"%>
<%@page import="net.smartworks.model.work.ProcessWork"%>
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
	ProcessWork work = (ProcessWork) smartWorks.getWorkById(cUser.getName(), cUser.getId(), workId);
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
				<div class="body_titl_pworks title"><%=work.getName()%>
				</div>
				
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

			<!-- 정의 영역-->
			<div class="contents_space">

				<!-- 업무 정의 -->
				<div class="">
					<%if(work.getDesc()!= null && !work.getDesc().equals("")) {%>
					<%=work.getDesc()%>
					<%}else{ %><fmt:message key="common.message.no_work_desc" />
					<%} %>
				</div>
				<!-- 업무 정의 //-->

				<!-- 버튼 영역-->
				<div class="txt_btn solid_line_sb margin_t15">
					<span class="po_left bu_work_explan">
						<a class="js_view_work_manual" href=""><fmt:message
								key="common.button.view.work_manual" />▼</a> <a
							style="display: none" class="js_view_work_manual" href=""><fmt:message
								key="common.button.close.work_manual" />▼</a>
					</span>
					<span class="po_left">
						<a href="">프로세스 다이어그램보기▼</a>
					</span>

				<!-- 우측 권한 아이콘 -->
				<span>
					<%
						switch (work.getAccessPolicy().getLevel()) {
						case AccessPolicy.LEVEL_PUBLIC:
					%>
					<span class="po_right">
						<fmt:message key="common.security.access.public" />
					</span>
					<%
						break;
						case AccessPolicy.LEVEL_PRIVATE:
					%>
					<span class="po_right">
						<fmt:message key="common.security.access.private" />
					</span>
					<%
						break;
						case AccessPolicy.LEVEL_CUSTOM:
					%>
					<span class="po_right">
						<fmt:message key="common.security.access.custom" />
					</span>
					<%
						break;
						}
					%>
					<span class="po_right">
						<span class="bu_read"></span>
					</span>
					<%
						switch (work.getWritePolicy().getLevel()) {
						case WritePolicy.LEVEL_PUBLIC:
					%>
					<span class="po_right">
						<fmt:message key="common.security.write.public" />
					</span>
					<%
						break;
						case WritePolicy.LEVEL_CUSTOM:
					%>
					<span class="po_right">
						<fmt:message key="common.security.write.custom" />
					</span>
					<%
						break;
						}
					%>
					<span class="po_right">
						<span class="bu_regit"></span>
					</span>
					<%
						switch (work.getEditPolicy().getLevel()) {
						case EditPolicy.LEVEL_WIKI:
					%>
					<span class="po_right">
						<fmt:message key="common.security.edit.wiki" />
					</span>
					<%
						break;
						case EditPolicy.LEVEL_BLOG:
					%>
					<span class="po_right">
						<fmt:message key="common.security.edit.blog" />
					</span>
					<%
						break;
						}
					%>
					<span class="po_right">
						<span class="bu_modfy"></span>
					</span>
				</span>
				<!-- 우측 권한 아이콘//-->
				
				</div>


				<%-- <div class="txt_btn">

					<%
						if (cUser.getUserLevel() == User.USER_LEVEL_AMINISTRATOR) {
					%>
					<div class="float_right padding_l10">
						<a href=""></a><span class="btn_gray"> <span
							class="Btn01Start"></span> <span class="Btn01Center"><fmt:message
									key='common.button.modify' /> </span> <span class="Btn01End"></span>
						</span></a>
					</div>
					<%
						}
					%>

					<div class="float_right">
						<%
							if (work.getManualFileName() != null) {
						%>
						<a href="" title="<fmt:message key='work.title.manual_file'/>">사용설명서(아이콘)</a>
						<%
							}
							if (work.getHelpUrl() != null) {
						%>
						<a href="<%=work.getHelpUrl()%>"
							title="<fmt:message key='work.title.help_url'/>" target="_blank">웹설명서
							보기(아이콘)</a>
						<%
							}
						%>
					</div>

				</div> --%>
				<!-- 버튼 영역 //-->

			</div>
			<!-- 정의 영역-->

			<div id="work_manual" style="display: none">
				<jsp:include page="/jsp/content/work/list/pwork_manual.jsp"></jsp:include>
			</div>
			
			
			<!-- 목록보기 -->
			<div class=" contents_space">
				<!-- 목록보기 타이틀-->
				<div class="list_title_space">

					<div class="txt_btn posi_ab">
						<div class="po_left title"><fmt:message key='common.title.instance_list' /></div>

						<div class="po_left">
							<div class="srch">
								<input id="" type="text"
									placeholder="<fmt:message key='search.search_work' />">
								<button onclick=""
									title="<fmt:message key='search.search_work' />"></button>
							</div>
						</div>
						<div class="po_left">
							<form class="form_space" name="frmPworkFilterName">
								<select name="selFilterName" class="js_select_filter"
									href="search_filter.sw?workId=<%=workId%>">
									<option value="<%=SearchFilter.FILTER_ALL_INSTANCES%>" selected>
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
									<option value="<%=SearchFilter.FILTER_MY_RUNNING_INSTANCES%>">
										<fmt:message key='filter.name.my_running_instances' />
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
							<a href="">목록보기</a>
						</div>
						<div class="po_right">
							<a href="">엑셀 불러오기</a>
						</div>
					</div>

				</div>
				<!-- 목록보기 타이틀-->
				<!-- 상세필터 -->
				<div id="search_filter" class="filter_section"></div>
				<!-- 상세필터 -->

				<!-- 목록 테이블 -->
				<div class="list_contents">
							<div id='pwork_list_page'>
								<jsp:include
									page="/jsp/content/work/list/pwork_instance_list.jsp"></jsp:include>
							</div>
				</div>
				<!-- 목록 테이블 //-->

				<!-- 목록보기 -->
			</div>
		</ul>
	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 컨텐츠 레이아웃//-->
