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
	String cid = request.getParameter("cid");
	String wid = request.getParameter("wid");

	String workId = SmartUtil.getSpaceIdFromContentContext(cid);
	User cUser = SmartUtil.getCurrentUser();
	InformationWork work = (InformationWork) smartWorks.getWorkById(companyId, workId);
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

				<!-- 우측 버튼-->
				<div class="txt_btn">
					<%
						switch (work.getAccessPolicy().getLevel()) {
						case AccessPolicy.LEVEL_PUBLIC:
					%>
					<div class="po_right">
						<fmt:message key="common.security.access.public" />
					</div>
					<%
						break;
						case AccessPolicy.LEVEL_PRIVATE:
					%>
					<div class="po_right">
						<fmt:message key="common.security.access.private" />
					</div>
					<%
						break;
						case AccessPolicy.LEVEL_CUSTOM:
					%>
					<div class="po_right">
						<fmt:message key="common.security.access.custom" />
					</div>
					<%
						break;
						}
					%>
					<div class="po_right">읽기권한(아이콘) :</div>
					<%
						switch (work.getWritePolicy().getLevel()) {
						case WritePolicy.LEVEL_PUBLIC:
					%>
					<div class="po_right">
						<fmt:message key="common.security.write.public" />
					</div>
					<%
						break;
						case WritePolicy.LEVEL_CUSTOM:
					%>
					<div class="po_right">
						<fmt:message key="common.security.write.custom" />
					</div>
					<%
						break;
						}
					%>
					<div class="po_right">등록권한(아이콘) :</div>
					<%
						switch (work.getEditPolicy().getLevel()) {
						case EditPolicy.LEVEL_WIKI:
					%>
					<div class="po_right">
						<fmt:message key="common.security.edit.wiki" />
					</div>
					<%
						break;
						case EditPolicy.LEVEL_BLOG:
					%>
					<div class="po_right">
						<fmt:message key="common.security.edit.blog" />
					</div>
					<%
						break;
						}
					%>
					<div class="po_right">수정권한(아이콘) :</div>
				</div>
				<!-- 우측 버튼 -->

				<div class="solid_line"></div>
			</div>
			<!-- 타이틀 -->

			<!-- 컨텐츠 -->
			<div class="contents_space">

				<!-- 업무 정의 영역 -->
				<div class=""><%=work.getDesc()%></div>

				<!-- 업무 정의 영역 //-->

				<!-- 버튼 영역-->
				<div class="txt_btn posi_ab">
					<div class="po_left">
						<a class="js_view_iwork_manual" href=""><fmt:message
								key="common.button.view.work_manual" />▼</a> <a
							style="display: none" class="js_view_iwork_manual" href=""><fmt:message
								key="common.button.close.work_manual" />▼</a>
					</div>
				</div>
				<div class="txt_btn">

					<%
					if(cUser.getUserLevel() == User.USER_LEVEL_AMINISTRATOR){
					%>
					<div class="float_right padding_l10">
						<a href=""></a><span class="btn_gray"> <span
							class="Btn01Start"></span> <span class="Btn01Center"><fmt:message
									key='common.button.modify' />
						</span> <span class="Btn01End"></span> </span></a>
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

				</div>
				<!-- 라인 -->
				<div class="solid_line_s"></div>
				<!-- 버튼 영역 //-->

			</div>
			<div id="iwork_manual" style="display: none">
				<jsp:include page="/jsp/content/work/list/iwork_manual.jsp"></jsp:include>
			</div>
			<div>
				<div class="po_right"><%=work.getLastModifier().getLongName()%>
					<%=work.getLastModifiedDate().toLocalString()%></div>
				<img class="po_right"
					src="<%=work.getLastModifier().getMinPicture()%>" />
				<div class="po_right">
					<fmt:message key="common.title.last_modifier" />
					:
				</div>
			</div>


			<div class=" contents_space">
				<!-- 목록보기 -->
				<!-- 목록보기 타이틀-->
				<div class="list_title_space">

					<div class="txt_btn posi_ab">
						<div class="po_left title">
							<fmt:message key='common.title.instance_list' />
						</div>

						<div class="po_left">
							<div class="srch">
								<input id="" class="input js_auto_complete" type="text"
									placeholder="<fmt:message key='search.search_work' />"
									href="iwork_instance.sw">
							</div>
						</div>

						<div class="po_left">
							<form class="form_space" name="frmIworkFilterName" class="js_select_filter">
								<select name="selFilterName" >
									<option value="<%=SearchFilter.BASIC_FILTER_ALL_INSTANCES %>"
										selected>
										<fmt:message key='filter.name.all_instances' />
									</option>
									<option value="<%=SearchFilter.BASIC_FILTER_MY_INSTANCES %>">
										<fmt:message key='filter.name.my_instances' />
									</option>
									<option
										value="<%=SearchFilter.BASIC_FILTER_RECENT_INSTANCES %>">
										<fmt:message key='filter.name.recent_instances' />
									</option>
									<option
										value="<%=SearchFilter.BASIC_FILTER_MY_RECENT_INSTANCES %>">
										<fmt:message key='filter.name.my_recent_instances' />
									</option>
									<%
									SearchFilter[] filters = work.getSearchFilters();
									if(filters != null){
										for(SearchFilter filter : filters){	
									%>
									<option
										value="<%=filter.getId() %>">
										<%=filter.getName() %>
									</option>									
									<%
									}
									}%>
								</select>
							</form>
						</div>
						<div class="po_left"><fmt:message key='filter.button.search_filter' /></div>
					</div>

					<div class="txt_btn">
						<div class="po_right">
							<a href="">목록보기</a>
						</div>
						<div class="po_right">
							<a href="">엑셀 불러오기</a>
						</div>

					</div>
					<!-- 목록보기 타이틀-->


					<!-- 목록 테이블 -->
					<div class="list_contents">
						<table>
							<colgroup>
								<col class="item">
								<col class="field">
								<col class="field">
							</colgroup>
							<tbody>
								<tr>
									<th></th>
									<%
									FormField[] fields = work.getDisplayFields();
									if(fields!=null){
										for(FormField field : fields){											
									%>
									<th class="r_line"><%=field.getName() %></th>
									<%
										}
									}
									%>
									<th><fmt:message key='common.title.last_modifier'/>/<fmt:message key='common.title.last_modified_date'/></th>
								</tr>
								<div id='iwork_list_page'>
									<jsp:include page="/jsp/content/work/list/instance_list_page.jsp"></jsp:include>
								</div>
							</tbody>
						</table>
						<div class="padding_l10">
							<a href="">더보기</a>
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
