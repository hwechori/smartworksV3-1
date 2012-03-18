<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ page import="net.smartworks.model.community.*"%>
<%@ page import="net.smartworks.model.notice.*"%>

<script>

// 서버에서 SmartUtil.publishMessage()로 NOTICE_COUNT를 현재사용자에게 메시지를 보내면 처리하는 함수이다.
function updateNoticeCount(message){
	var type = message.body.type;
	var count = message.body.count;
	var data = "<span></span>";
	if (count > 0)
		data = "<em class='icon_number'>" + count + "<span></span></em>";

	if (type == 0) {
		$('#notification_count').html(data);
	} else if (type == 1) {
		$('#message_count').html(data);
	} else if (type == 2) {
		$('#comment_count').html(data);
	} else if (type == 3) {
		$('#assigned_count').html(data);
	} else if (type == 4) {
		$('#mailbox_count').html(data);
	} else if (type == 5) {
		$('#savedbox_count').html(data);
	}
};
</script>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 그리고 현재사용자 정보도 가져온다.	
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	String cid = request.getParameter("cid");
	if (SmartUtil.isBlankObject(cid))
		cid = ISmartWorks.CONTEXT_PREFIX_HOME + cUser.getId();
	String wid = request.getParameter("wid");
	if (SmartUtil.isBlankObject(wid))
		wid = cUser.getId();
	
	// 서버에서 현재사용자에 대한 Notice들을 가져온다.
	Notice[] notices = smartWorks.getNoticesForMe();
%>

<div class="hd_shadow">
	<!-- GNB -->
	<div class="gnb">
		<ul class="login_info">
			<li> <a href=""><%=cUser.getNickName() %></a> 님 안녕하세요 </li>
		</ul>
		<ul class="top_menu2">
			<li class="fl"> <a href="Course.sw" class="js_sera_content"> <img width="101" height="28" title="Course" alt="Course" src="sera/images/sera2_main_btnTopMenu1_off.png"> </a> </li>
			<li class="fl"> <a href="myPAGE.sw" class="js_sera_content"> <img width="101" height="28" title="myPAGE" alt="myPAGE" src="sera/images/sera2_main_btnTopMenu2_on.png"> </a> </li>
			<li class="fl"> <a href="seraCLUB.sw" class="js_sera_content"> <img width="101" height="28" title="seraCLUB" alt="seraCLUB" src="sera/images/sera2_main_btnTopMenu3_off.png"> </a> </li>
		</ul>
		<ul class="util_menu">
			<li class="seminar"></li>
			<li class="about"> <a href="">about SERA</a> </li>
			<li class="news"> <a href="">sera 소식</a> </li>
			<li class="btnLogin"> <a href="logout"> <img width="49" height="19" title="로그아웃" alt="로그아웃" src="sera/images/sera2_main_btnLogout.png"> </a> </li>
		</ul>
	</div>
	<!-- GNB //-->
	<!-- Top Navi -->
	<div class="top_navi">
		<div class="personal_info fl mt5">
			<div class="profile_pic fl"> <img width="34" height="34" src="<%=cUser.getMidPicture()%>"> </div>
			<div class="pofile_con">
				<div class="btn_log on"> </div>
				<div class="nick_name"><%=cUser.getNickName() %><span class="bul_down"><a href=""></a></span></div>
			</div>
			<!-- Btn in Gnb - 코스 만들기-->
			<div class="btn_gnb">
				<div class="btn_gnb_l">
				  <div class="btn_gnb_r">코스 만들기</div>
				</div>
			</div>
		</div>
		<!-- Global Navi Icon -->
		<div class="gni fr">
			<ul>
				<li class="icon_alarm"><a href="" title="알림">알림</a></li>
				<li class="icon_mycourse"><a href="" title="내코스">내코스</a></li>
				<li class="icon_chatting"><a href="" title="친구">친구</a></li>
				<li class="icon_message"><a href="" title="쪽지">쪽지</a></li>
				<li class="icon_chaledar"><a href="" title="캘린더">캘린더</a></li>
				<li class="icon_badge"><a href="" title="뱃지">뱃지</a></li>
				<li class="icon_event"><a href="" title="이벤트">이벤트</a></li>
			</ul>
		</div>
	</div>
	<!-- Top Navi //-->
</div>
