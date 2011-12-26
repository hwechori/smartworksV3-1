<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.work.info.WorkInfo"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.work.*"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	WorkInfo[] workCategories = smartWorks.getMyAllWorksByCategoryId("");
%>
<!--  전체 레이아웃 -->
<div class="pop_corner_all pop_section_400">

	<!-- 팝업 타이틀 -->
	<div class="form_title">
		<div class="pop_title">사용자 선택</div>

		<div class="txt_btn">
			<div class="btn_x">
				<a href="" onclick="$.modal.close();return false;">X</a>
			</div>
		</div>

		<div class="solid_line"></div>
	</div>
	<!-- 팝업 타이틀 //-->

	<!-- 팝업 컨텐츠 -->
	<div class="form_contents">
		<div class="user_list_area">
			<ul>
				<%
					if(workCategories != null){
						for (WorkInfo workCategory : workCategories) {
				%>
				<li class="js_drill_down"><a href="worklist_by_category.sw"
					categoryId="<%=workCategory.getId()%>"> <span class="ico_cworks"></span>
						<span class="nav_subtitl_area"><%=workCategory.getName()%></span> </a>
					<div class="menu_2dep" style="display: none"></div>
				</li>
				<%
						}
					}
				%>
			</ul>
		</div>
	</div>
	<!-- 팝업 컨텐츠 //-->

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