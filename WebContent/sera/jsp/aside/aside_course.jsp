
<!-- Name 			: nav.jsp										 		 -->
<!-- Description	: 화면 왼쪽의 Navigation Bar 를 구성하는 화면  				 -->
<!-- Author			: Y.S. JUNG												 -->
<!-- Created Date	: 2011.9.												 -->

<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다 
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	// 호출할때 전달된 cid(Context ID, 패이지 컨택스트를 지정하는 변수), 
	// wid(WorkSpace Id, 공간을 저정하는 변수) 를 가져옮..
	String cid = request.getParameter("cid");
	if (SmartUtil.isBlankObject(cid))
		cid = ISmartWorks.CONTEXT_PREFIX_HOME + cUser.getId();
	String wid = request.getParameter("wid");
	if (SmartUtil.isBlankObject(wid))
		wid = cUser.getId();
	WorkSpace workSpace = smartWorks.getWorkSpaceById(wid);
%>
    
<!-- Aside Block1 -->
<div class="aside_block">
	<div class="header">
		<div class="icon_as_mycourse fl">내 코스 <span class="num_cus">(23)</span></div>
		<div class="icon_as_more"><a href="" class="mt10"> </a></div>
	</div>
	<div class="content">
		<dl>
			<dt>운영코스 (10)</dt>
			<dd>
				<ul>
					<li><span class="t_blue">코스명1</span> 자화상 그리기</li>
					<li><span class="t_blue">코스명2</span> 자기 소개하기</li>
					<li><span class="t_blue">코스명3</span> 길거리 사진찍기 공유하기</li>
				</ul>
			</dd>
		</dl>
	</div>
	<div class="content">
		<dl>
			<dt>참여코스 (13)</dt>
			<dd>
				<ul>
					<li><span class="t_blue">코스명1</span> 자화상 그리기</li>
					<li><span class="t_blue">코스명2</span> 자기 소개하기</li>
					<li><span class="t_blue">코스명3</span> 길거리 사진찍기 공유하기</li>
				</ul>
			</dd>
		</dl>
	</div>
</div>
<!-- Aside Block1 //-->

  <!-- Aside Block2 -->
<div class="aside_block m0">
	<div class="header">
		<div class=" icon_as_badge fl">뱃 지 (16)</div>
		<div class="icon_as_more"><a href="" class="mt10"> </a></div>
	</div>
	<div class="list">
		<dl>
			<dd><div class="badge_df"> </div></dd>
			<dd><div class="badge_df"> </div></dd>
			<dd><div class="badge_df"> </div></dd>
			<dd><div class="badge_df"> </div></dd>
			<dd><div class="badge_df"> </div></dd>
			<dd><div class="badge_df"> </div></dd>
			<dd><div class="badge_df"> </div></dd>
			<dd><div class="badge_df"> </div></dd>
			<dd><div class="badge_df"> </div></dd>
			<dd><div class="badge_df"> </div></dd>
			<dd><div class="badge_df"> </div></dd>
		</dl>
	</div>
</div>
<!-- Aside Block2 //-->
	
<!-- Aside Block3 -->
<div class="aside_block m0">
	<div class="header">
		<div class=" icon_as_friend fl">친 구 (1000)</div>
		<div class="icon_as_more"><a href="" class="mt10"> </a></div>
	</div>
	<div class="list">
		<dl>
			<dd><div class="friend_df"> </div></dd>
			<dd><div class="friend_df"> </div></dd>
			<dd><div class="friend_df"> </div></dd>
			<dd><div class="friend_df"> </div></dd>
			<dd><div class="friend_df"> </div></dd>
			<dd><div class="friend_df"> </div></dd>
			<dd><div class="friend_df"> </div></dd>
			<dd><div class="friend_df"> </div></dd>
			<dd><div class="friend_df"> </div></dd>
			<dd><div class="friend_df"> </div></dd>
			<dd><div class="friend_df"> </div></dd>
		</dl>
	</div>
</div>
<!-- Aside Block3 //-->

 <!-- Aside Block4 -->
<div class="aside_block">
	<div class="header">
		<div class="icon_as_srtrend fl">트렌드 세라 (23)</div>
		<div class="icon_as_more"><a href="" class="mt10"> </a></div>
	</div>
	<div class="content">
		<dl>
			<dd>
				<ul>
					<li>[정치인 공부하기] 새누리당으로...</li>
					<li>[정치인 공부하기] 한나라당이...</li>
				</ul>
			</dd>
		</dl>
	</div>
</div>
<!-- Aside Block4 //-->
      
