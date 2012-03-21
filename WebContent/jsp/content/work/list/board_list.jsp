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
		var url = "set_instance_list_params.sw";
		$.ajax({
			url : url,
			contentType : 'application/json',
			type : 'POST',
			data : JSON.stringify(paramsJson),
			success : function(data, status, jqXHR) {
				$('#board_instance_list_page').html(data);
				smartPop.closeProgress();
			},
			error : function(xhr, ajaxOptions, thrownError) {
				smartPop.closeProgress();
				smartPop.showInfo(smartPop.ERROR, smartMessage.get('workListError'));
			}
		});
	};

	selectListParam = function(progressSpan, isGray){
		var boardList = $('.js_board_list_page');
		var forms = boardList.find('form:visible');
		var paramsJson = {};
		var workId = boardList.attr('workId');
		paramsJson["href"] = "jsp/content/work/list/board_instance_list.jsp?workId=" + workId;
		var searchFilters = boardList.find('form[name="frmSearchFilter"]');
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

%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<jsp:include page="/jsp/content/upload/select_upload_action.jsp"></jsp:include>

<!-- 컨텐츠 레이아웃-->
<div class="section_portlet js_work_list_page js_board_list_page" workId="<%=SmartWork.ID_BOARD_MANAGEMENT%>">
	<div class="portlet_t"><div class="portlet_tl"></div></div>
	<div class="portlet_l" style="display: block;">
		<ul class="portlet_r" style="display: block;">

			<!-- 타이틀 -->
			<div class="body_titl">
				<div class="body_titl_iworks title">
					<div class="title myspace_h"><%=workSpaceName %>
						<span class="bul_space"><fmt:message key="space.title.boards"/></span>
					</div>
				</div>
				<!-- 우측 버튼 -->
				<div class="txt_btn">
				</div>
				<div class="solid_line"></div>
			</div>
			<!-- 타이틀 -->

			<!-- 목록보기 -->
			<div class=" contents_space">
				<!-- 목록보기 타이틀-->
				<div class="list_title_space js_work_list_title mt15">
					<div class="title"><fmt:message key="common.title.instance_list" /></div>					
					<div class="title_line_options">
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
 				<div class="list_contents">
					<div id='board_instance_list_page'>
 						<jsp:include page="/jsp/content/work/list/board_instance_list.jsp"/>
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
