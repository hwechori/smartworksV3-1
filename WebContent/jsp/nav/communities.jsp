
<!-- Name 			: communities.jsp										 		 -->
<!-- Description	: 좌측의 Navigation Bar 에서 현재사용자의 커뮤너티들을 찾아서 페이징하는 박스 -->
<!-- Author			: Maninsoft, Inc.												 -->
<!-- Created Date	: 2011.9.														 -->

<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>

<!-- 나의 커뮤너티 와 검색박스가 있는 헤더  -->
<ul class="navi_tit">

	<!-- 나의 커뮤너티 라벨과 클릭시 아래의 커뮤너티선택트리화면을 접었다 폈다하는 기능 제공  -->
	<!-- *** js_collapse_parent_siblings : sw_act_nav.js 에서 이클래스의 클릭이벤트를 받아서 -->
	<!--            아래의 js_callapsible 클래스를 찾아 toggle 한다 -->
	<li>
		<a href="" class="js_collapse_parent_siblings arr_on"><fmt:message key="nav.communities.my_communities" /></a>
		<span></span><!--  프로그래스아이콘이 실행되는 곳 -->
	</li>
	
	<!--  검색박스를 제공하여, 초성검색 기능을 제공 -->
	<li class="nav_srch js_srch_my_com">
		<div class="srch srch_wsize">
			<input id="" class="nav_input js_auto_complete" type="text" title="<fmt:message key='search.search_people_depart_group'/>"
				placeholder="<fmt:message key='search.search_people_depart_group'/>" href="community.sw">
			<div class='srch_ico js_srch_x'></div>
		</div>
		<!-- nav 검색 리스트 -->
		<div class="nav_srch_list" style="display: none"></div>
		<!-- nav 검색 리스트 -->
	</li>
	<!--  검색박스를 제공하여, 초성검색 기능을 제공 //-->
	
</ul>
<!-- 나의 커뮤너티 와 검색박스가 있는 헤더 // -->

<!--  나의부서, 나의 그룹에서 커뮤너티를 찾을수 있는 트리 화면  -->
<div class='navi_list js_collapsible js_nav_my_com'>
	<!-- 내부 메뉴 -->
	<div class="categ_link js_nav_tab_com">
	
		<!-- 아래 class="btn_my_group_add"는 그룹 추가 버튼입니다 -->
		<a href="my_groups.sw" title="<fmt:message key='nav.communities.my_groups'/>">
			<span class="btn_my_group">
				<span class="btn_my_group_add js_add_new_group" title="<fmt:message key='nav.communities.add_group'/>" style="display:none"></span>
			</span>
		</a>
		<a href="my_departments.sw" class="" title="<fmt:message key='nav.communities.my_departments'/>">
			<span class="btn_my_depart current"></span>
		</a> 
		<span class="js_progress_span"  style="float:right;" ></span><!--  프로그래스아이콘이 실행되는 곳 -->

	</div>
	<div id='my_communities'>
		<jsp:include page='/jsp/nav/my_departments.jsp' />
	</div>
	<!--내부메뉴//-->
</div>
<!--  나의부서, 나의 그룹에서 커뮤너티를 찾을수 있는 트리 화면 //-->
