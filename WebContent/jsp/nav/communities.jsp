<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>

<ul class="navi_tit">
	<li class="js_collapse_parent_siblings arr_on"><fmt:message
			key="nav.communities.my_communities" />
	</li>
	<li class="nav_srch">
		<div class="srch srch_wsize">
			<input id="" class="nav_input js_auto_complete" type="text"
				title="<fmt:message key='search.search_people_depart_group'/>"
				placeholder="<fmt:message key='search.search_people_depart_group'/>"
				href="community.sw">
			<div class='srch_ico js_srch_x'></div>
		</div>

		<!-- nav 검색 리스트 -->
		<div class="nav_srch_list" style="display: none"></div>
		<!-- nav 검색 리스트 -->

	</li>
</ul>


<div class='navi_list coummi js_collapsible'>
	<!-- 내부 메뉴 -->
	<div class="categ_link js_nav_tab_com">
		<a href="my_departments.sw" class="current"><fmt:message
				key="nav.communities.my_departments" /></a> <a href="my_groups.sw"><fmt:message
				key="nav.communities.my_groups" /></a>
	</div>
	<div id='my_communities'>
		<jsp:include page='/jsp/nav/my_departments.jsp' />
	</div>
	<!--내부메뉴//-->
</div>
