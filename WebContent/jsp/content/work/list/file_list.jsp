<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.server.engine.process.xpdl.xpdl2.Category"%>
<%@page import="net.smartworks.model.work.info.FileCategoryInfo"%>
<%@page import="net.smartworks.model.work.FileCategory"%>
<%@page import="net.smartworks.model.community.WorkSpace"%>
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
<script type="text/javascript">
	getIntanceList = function(paramsJson, progressSpan, isGray){
		if(isEmpty(progressSpan))
			progressSpan = $('.js_work_list_title').find('.js_progress_span:first');
		if(isGray)
			smartPop.progressContGray(progressSpan);
		else
			smartPop.progressCont(progressSpan);
		console.log(JSON.stringify(paramsJson));
		var url = "set_file_list_params.sw";
		$.ajax({
			url : url,
			contentType : 'application/json',
			type : 'POST',
			data : JSON.stringify(paramsJson),
			success : function(data, status, jqXHR) {
				$('#file_instance_list_page').html(data);
				smartPop.closeProgress();
			},
			error : function(xhr, ajaxOptions, thrownError) {
				smartPop.closeProgress();
				smartPop.showInfo(smartPop.ERROR, smartMessage.get('fileListError'));
			}
		});
	};
	
	selectListParam = function(progressSpan, isGray){
		var fileList = $('.js_file_list_page');
		var forms = fileList.find('form:visible');
		var displayType = fileList.attr("displayType");
		var categoryId = fileList.attr("categoryId");
		var paramsJson = {};
		paramsJson["displayType"] = displayType;
		paramsJson["categoryId"] = categoryId;
		paramsJson["href"] = "jsp/content/work/list/file_instance_list.jsp?displayType=" + displayType;
		var searchFilters = fileList.find('form[name="frmSearchFilter"]');
		for(var i=0; i<forms.length; i++){
			var form = $(forms[i]);
			if(form.attr('name') !== "frmSearchFilter" && !(!isEmpty(searchFilters) && form.attr('name') === "frmSearchInstance")){
				paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
			}
		}
		if(!isEmpty(searchFilters)){
			var searchFilterArray = new Array();
			for(var i=0; i<searchFilters.length; i++){
				var searchFilter = $(searchFilters[i]);
				if(searchFilter.is(':visible'))
					searchFilterArray.push(searchFilter.find(':visible').serializeObject());
			}
			paramsJson['frmSearchFilters'] = searchFilterArray;
		}
		if(isEmpty(progressSpan)) grogressSpan = fileList.find('.js_search_filter').next('span.js_progress_span:first');
		getIntanceList(paramsJson, progressSpan, isGray);		
	};
</script>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String cid = request.getParameter("cid");
	String wid = request.getParameter("wid");
	session.setAttribute("cid", cid);
	session.setAttribute("wid", wid);
	
	User cUser = SmartUtil.getCurrentUser();
	WorkSpace workSpace = smartWorks.getWorkSpaceById(wid);
	String workSpaceName = (SmartUtil.isBlankObject(wid)) ? cUser.getCompany() : workSpace.getName();
	int displayType = (SmartUtil.isBlankObject(wid)) ? FileCategory.DISPLAY_ALL : FileCategory.DISPLAY_BY_CATEGORY;

%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<jsp:include page="/jsp/content/upload/select_upload_action.jsp"></jsp:include>

<!-- 컨텐츠 레이아웃-->
<div class="section_portlet js_file_list_page" workId="<%=SmartWork.ID_FILE_MANAGEMENT %>" displayType="<%=FileCategory.DISPLAY_BY_CATEGORY%>" workSpaceId="<%=wid%>" categoryId="<%=FileCategory.ID_ALL_FILES%>">
	<div class="portlet_t"><div class="portlet_tl"></div></div>
	<div class="portlet_l" style="display: block;">
		<ul class="portlet_r" style="display: block;">

			<!-- 타이틀 -->
			<div class="body_titl">
				<div class="body_titl_iworks title">
					<div class="title myspace_h"><%=workSpaceName %>
						<span class="bul_space"><fmt:message key="space.title.files"/></span>
					</div>
				</div>
				<!-- 우측 버튼 -->
				<div class="txt_btn">
				</div>
				<div class="solid_line"></div>
			</div>
			<!-- 타이틀 -->

			<div class=" contents_space">  
				<%
				if(displayType!=FileCategory.DISPLAY_ALL){
				%>          
					<!-- Left -->
					<div class="left30 mt13 ">
						<!-- 필 터 -->
						<div class="fl">
							<select class="js_file_display_by">
							  <option value=<%=FileCategory.DISPLAY_BY_CATEGORY %>><fmt:message key="space.title.by_category"/></option>
							  <option value=<%=FileCategory.DISPLAY_BY_WORK %>><fmt:message key="space.title.by_work"/></option>
							  <option value=<%=FileCategory.DISPLAY_BY_YEAR %>><fmt:message key="space.title.by_year"/></option>
							  <option value=<%=FileCategory.DISPLAY_BY_OWNER %>><fmt:message key="space.title.by_owner"/></option>
							  <option value=<%=FileCategory.DISPLAY_BY_FILE_TYPE %>><fmt:message key="space.title.by_filetype"/></option>
							</select>
							<!-- 우측 구분 -->
							<span>검색공간</span>
							<!-- 우측 구분 //-->
						</div>
						<!-- 필 터 //-->
						<!-- 카테고리 -->
						<div class="pop_list_area mt25">
							<ul class="js_file_categories">
								<jsp:include page="/jsp/content/work/list/categories_by_type.jsp">
									<jsp:param value="<%=displayType%>" name="displayType"/>
									<jsp:param value="<%=wid%>" name="wid"/>
									<jsp:param value="" name="parentId"/>
								</jsp:include>
							</ul>
						</div>
						<!-- 카테고리 //-->
					</div>
					<!-- Left//-->
					<!-- Right -->	
					<div class="right70">
					<!-- 목록보기 -->
						<!-- 목록보기 타이틀-->
						<div class="list_title_space js_work_list_title mt15">
							<div class="title"><fmt:message key="common.title.instance_list" /></div>					
								<div class="titleLineOptions">
									<form name="frmSearchInstance" class="po_left">
										<span class="js_progress_span"></span>
										<div class="srch_wh srch_wsize">
											<input name="txtSearchInstance" class="nav_input" type="text" placeholder="<fmt:message key='search.search_instance' />">
											<button title="<fmt:message key='search.search_instance'/>" onclick="selectListParam($('.js_work_list_title').find('.js_progress_span:first'), false);return false;"></button>
										</div>
									</form>					
								</div>
						</div>
						<!-- 목록보기 타이틀-->
							
						<!-- 목록 테이블 -->
						<div class="list_contents js_file_instance_list">
							<jsp:include page="/jsp/content/work/list/file_instance_list.jsp">
								<jsp:param value="<%=FileCategory.DISPLAY_BY_CATEGORY %>" name="displayType"/>
								<jsp:param value="<%=wid %>" name="workSpaceId"/>
							</jsp:include>
						</div>
						<!-- 목록 테이블 //-->
					</div>
					<!-- 목록보기 -->
				<%
				}else{
					InformationWork work = (InformationWork)smartWorks.getWorkById(SmartWork.ID_FILE_MANAGEMENT);
					session.setAttribute("smartWork", work);
					session.removeAttribute("workInstance");
				%>
					<div>
						<jsp:include page="/jsp/content/work/report/work_report.jsp">
							<jsp:param value="<%=work.getLastReportId() %>" name="reportId"/>
						</jsp:include>
					</div>

					<!-- Right -->	
					<div>
					<!-- 목록보기 -->
						<!-- 목록보기 타이틀-->
						<div class="list_title_space js_work_list_title mt15">
							<div class="title"><fmt:message key="common.title.instance_list" /></div>					
							<div class="titleLineBtns">
								<div class="btnIconsEdit">
									<a href="search_filter.sw?workId=<%=SmartWork.ID_FILE_MANAGEMENT%>" class="js_edit_search_filter btnIconsTail"><fmt:message key='filter.button.edit_search_filter' /></a>
								</div>
							</div>
						
							<div class="titleLineOptions">
								<form name="frmSearchInstance" class="po_left">
									<span class="js_progress_span"></span>
									<div class="srch_wh srch_wsize">
										<input name="txtSearchInstance" class="nav_input" type="text" placeholder="<fmt:message key='search.search_instance' />">
											<button title="<fmt:message key='search.search_instance'/>" onclick="selectListParam($('.js_work_list_title').find('.js_progress_span:first'), false);return false;"></button>
									</div>
								</form>
								<form class="form_space po_left js_form_filter_name" name="frmIworkFilterName">
									<select name="selFilterName" class="js_select_search_filter">
										<option value="<%=SearchFilter.FILTER_ALL_INSTANCES%>" 
											<%if(SmartUtil.isBlankObject(work.getLastFilterId()) || SearchFilter.FILTER_ALL_INSTANCES.equals(work.getLastFilterId())){%> selected <%} %>>
											<fmt:message key='filter.name.all_instances' />
										</option>
										<option value="<%=SearchFilter.FILTER_MY_INSTANCES%>"
											<%if(SearchFilter.FILTER_MY_INSTANCES.equals(work.getLastFilterId())){%> selected <%} %>>
											<fmt:message key='filter.name.my_instances' />
										</option>
										<option value="<%=SearchFilter.FILTER_RECENT_INSTANCES%>"
											<%if(SearchFilter.FILTER_RECENT_INSTANCES.equals(work.getLastFilterId())){%> selected <%} %>>
											<fmt:message key='filter.name.recent_instances' />
										</option>
										<option value="<%=SearchFilter.FILTER_MY_RECENT_INSTANCES%>"
											<%if(SearchFilter.FILTER_MY_RECENT_INSTANCES.equals(work.getLastFilterId())){%> selected <%} %>>
											<fmt:message key='filter.name.my_recent_instances' />
										</option>
										<%
										SearchFilterInfo[] filters = work.getSearchFilters();
										if (filters != null) {
											for (SearchFilterInfo filter : filters) {
												if(SmartUtil.isBlankObject(filter.getId())) continue;
										%>
												<option value="<%=filter.getId()%>" <%if(filter.getId().equals(work.getLastFilterId())){%> selected <%} %>><%=CommonUtil.toNotNull(filter.getName())%></option>
										<%
											}
										}
										%>
									</select>
								</form>
							</div>
						</div>
						<!-- 목록보기 타이틀-->

						<!-- 상세필터 및 새업무등록하기 화면 -->
						<div id="search_filter" class="filter_section js_new_work_form"></div>
						<!-- 상세필터 -->
							
						<!-- 목록 테이블 -->
						<div class="list_contents">
							<div id='file_instance_list_page'>
								<jsp:include page="/jsp/content/work/list/file_instance_list.jsp">
									<jsp:param value="<%=FileCategory.DISPLAY_ALL %>" name="displayType"/>
								</jsp:include>
							</div>
						</div>
						<!-- 목록 테이블 //-->
					</div>
					<!-- 목록보기 -->
				<%
				}
				%>
			</div>
		</ul>
	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 컨텐츠 레이아웃//-->
