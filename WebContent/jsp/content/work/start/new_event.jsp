<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.util.SmartTest"%>
<%@page import="net.smartworks.model.community.User"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

		<div class="input_1line">
			<div class="fieldline space_date float_left">
				<input id="" type="text" value="2010.11.10" title="">
			</div>

			<div class="float_left">
				<select name="jumpMenu" id="jumpMenu"
					onchange="MM_jumpMenu('parent',this,0)" style="width: 100%;">
					<option>09:00</option>
					<option>10:00</option>
					<option>11:00</option>
					<option>12:00</option>
				</select>
			</div>
			<div class="float_left txt_btn">
				<a href="" class="space_l"
					onclick="$(this).hide().siblings().show().parent().next('div').toggle(); return false;"><fmt:message
						key="common.upload.button.add_eventend" />
				</a> <a style="display: none" href="" class="space_l"
					onclick="$(this).hide().siblings().show().parent().next('div').toggle(); return false;"><fmt:message
						key="common.upload.button.delete_eventend" />
				</a>
			</div>

			<div class="float_left space_l" style="display: none;">
				<div class="fieldline space_date float_left">
					<input id="" type="text" value="2010.11.10" title="">
				</div>
				<div class="float_left">
					<select name="jumpMenu" id="jumpMenu"
						onchange="MM_jumpMenu('parent',this,0)" style="width: 100%;">
						<option>09:00</option>
						<option>10:00</option>
						<option>11:00</option>
						<option>12:00</option>
					</select>
				</div>
			</div>

			<div class="float_left txt_btn">
				<a href="" class="space_l"
					onclick="$(this).parent().next('div').toggle(); return false;"><input type="checkbox"><fmt:message
						key="common.upload.button.set_alarm" />
				</a>
			</div>
			<div>
			</div>

			<div class="float_left txt_btn">
				<a href="" class="space_l"
					onclick="$(this).parent().next('div').toggle(); return false;"><fmt:message
						key="common.upload.button.set_repeat" />
				</a>
			</div>
			<div>
			</div>

		</div>

		<div class="input_1line">
			<input class="up" id="" type="text" title="" placeholder="<fmt:message key='common.upload.event.place' />">
		</div>
		<div class="input_1line js_user_name">
			<div class="js_users"></div>
			<input class="up js_auto_complete" href="user_name.sw" type="text" title="" placeholder="<fmt:message key='common.upload.event.related_users' />">
		</div>
		<div style="display: none"></div>


		<div class="up_form" style="height: 65px;">
			<textarea class="up up_textarea" name="파일에 대한 부연설명을 입력하세요!" cols=""
				rows="5"><fmt:message key='common.upload.event.content' />
                </textarea>
		</div>


		<!-- 하단 등록,취소 버튼 -->
		<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
