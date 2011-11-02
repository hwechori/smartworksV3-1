<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>

<div id="up_event">
	<div class="up_form up_size js_upload_input">
		<div class="up_point posit_event"></div>
		<input class="up" id="" type="text"
			title="<fmt:message key='common.upload.message.event'/>"
			placeholder="<fmt:message key='common.upload.message.event'/>">
	</div>

	<div class="js_upload_form_detail" style="display: none">
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
				<a href="" class="space_l">종료날짜 추가하기</a>
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

		</div>

		<div class="input_1line">
			<input class="up" id="" type="text" title="" value="장소">
		</div>
		<div class="input_1line">
			<input class="up" id="" type="text" title="" value="참여자">
		</div>

		<div class="up_form" style="height: 65px;">
			<textarea class="up up_textarea" name="파일에 대한 부연설명을 입력하세요!" cols=""
				rows="5" value="파일에 대한 부연설명을 입력하세요">파일에 대한 부연설명을 입력하세요!
                </textarea>
		</div>


		<!-- 하단 등록,취소 버튼 -->
		<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
	</div>
</div>
