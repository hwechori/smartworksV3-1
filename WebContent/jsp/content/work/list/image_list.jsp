<%@page import="net.smartworks.model.work.FileCategory"%>
<%@page import="net.smartworks.model.community.WorkSpace"%>
<%@page import="net.smartworks.model.work.info.ImageCategoryInfo"%>
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
	session.setAttribute("cid", cid);
	session.setAttribute("wid", wid);
	
	User cUser = SmartUtil.getCurrentUser();
	
	WorkSpace workSpace = smartWorks.getWorkSpaceById(wid);

%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<jsp:include page="/jsp/content/upload/select_upload_action.jsp"></jsp:include>

<!-- 컨텐츠 레이아웃-->
<div class="section_portlet js_image_list_page js_work_list_page">
	<div class="portlet_t"><div class="portlet_tl"></div></div>
	<div class="portlet_l" style="display: block;">
		<ul class="portlet_r" style="display: block;">
			<!-- 타이틀 -->
			<div class="body_titl">
				<div class="body_titl_iworks title">
					<div class="title myspace_h"><%=workSpace.getName() %>
						<span class="bul_space"><fmt:message key="space.title.pictures"/></span>
					</div>
				</div>                   
      			<!-- 필터 -->
           		<div class="txt_btn">
       				<select class="js_image_display_by">
               			<option selected value="<%=FileCategory.DISPLAY_BY_CATEGORY%>"><fmt:message key="space.title.by_category"/></option>
           				<option value="<%=FileCategory.DISPLAY_BY_YEAR%>"><fmt:message key="space.title.by_year"/></option>
           				<option value="<%=FileCategory.DISPLAY_BY_OWNER%>"><fmt:message key="space.title.by_owner"/></option>
             		</select>
          		</div>
        		<!-- 필터//-->
				<div class="solid_line"></div>
			</div>
			<!-- 타이틀 -->
			<!-- 컨텐츠 -->
			<div class="contents_space">
               
				<!-- 사진 목록 -->
				<div class="picture_section js_image_instance_list">
					<jsp:include page="/jsp/content/work/list/image_instance_list.jsp">
						<jsp:param value="<%=FileCategory.DISPLAY_BY_CATEGORY %>" name="displayType"/>
						<jsp:param value="" name="parentId"/>
					</jsp:include>
				</div>
      			<!-- 사진 목록// -->
			</div>
			<!-- 컨텐츠 //-->
		</ul>
	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 컨텐츠 레이아웃//-->
