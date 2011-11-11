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

<div class="up_wrap">
	<div class="up_point posit_event"></div>
	<div class="form_wrap up up_padding">
		<!-- 폼- 확장 -->
		<div class="form_title">
			<div class="input_1line_first">
				<input class="fieldline" type="text"
					placeholder="<fmt:message key='common.upload.message.event'/>">
			</div>

			<div class="input_1line">
				<div class="float_left">
					<input class="fieldline space_data" type="text" value="2010.11.10">
				</div>

				<!-- 캘린더 -->
				<div class="basic_calender select_free_layer"
					style="display: none; top: 23px;">

					<div class="_move_control move_month">
						<strong class="_now">2011. 11</strong>

						<button class="_yprev btn_yprev img_btn"
							style="width: 14px; height: 13px;"></button>

						<button class="_prev btn_prev img_btn"
							style="width: 13px; height: 13px;"></button>

						<button class="_next btn_next img_btn"
							style="width: 13px; height: 13px;"></button>

						<button class="_ynext btn_ynext img_btn"
							style="width: 14px; height: 13px;"></button>

					</div>

					<table class="_date_table" cellspacing="0" cellpadding="0"
						border="0">
						<colgroup>
							<col width="25" span="7">
						</colgroup>
						<thead>
							<tr class="_days">
								<th></th>
								<th></th>
								<th></th>
								<th></th>
								<th></th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr class="_week">
								<td class=" range_out_holiday">30</td>
								<td class=" range_out">31</td>
								<td class="">1</td>
								<td class="today selected_area"><strong>2</strong></td>
								<td class="">3</td>
								<td class="">4</td>
								<td class="">5</td>
							</tr>
							<tr class="_week">
								<td class=" holiday">6</td>
								<td class="">7</td>
								<td class="">8</td>
								<td class="">9</td>
								<td class="">10</td>
								<td class="">11</td>
								<td class="">12</td>
							</tr>
							<tr class="_week">
								<td class=" holiday">13</td>
								<td class="">14</td>
								<td class="">15</td>
								<td class="">16</td>
								<td class="">17</td>
								<td class="">18</td>
								<td class="">19</td>
							</tr>
							<tr class="_week">
								<td class=" holiday">20</td>
								<td class="">21</td>
								<td class="">22</td>
								<td class="">23</td>
								<td class="">24</td>
								<td class="">25</td>
								<td class="">26</td>
							</tr>
							<tr class="_week">
								<td class=" holiday">27</td>
								<td class="">28</td>
								<td class="">29</td>
								<td class="">30</td>
								<td class=" range_out">1</td>
								<td class=" range_out">2</td>
								<td class=" range_out">3</td>
							</tr>
							<tr class="_week">
								<td class=" range_out_holiday">4</td>
								<td class=" range_out">5</td>
								<td class=" range_out">6</td>
								<td class=" range_out">7</td>
								<td class=" range_out">8</td>
								<td class=" range_out">9</td>
								<td class=" range_out">10</td>
							</tr>
						</tbody>
					</table>

				</div>
				<!-- 캘린더//-->

				<div class="float_left">
					<select>
						<option>09:00</option>
						<option>10:00</option>
						<option>11:00</option>
						<option>12:00</option>
					</select>
				</div>
				<div class="float_left txt_btn">
					<a href="" class="space_l10"
						onclick="$(this).hide().siblings().show().parent().next('div').toggle(); return false;"><fmt:message
							key="common.upload.button.add_eventend" /> </a> <a
						style="display: none" href="" class="space_l10"
						onclick="$(this).hide().siblings().show().parent().next('div').toggle(); return false;"><fmt:message
							key="common.upload.button.delete_eventend" /> </a>
				</div>
				<!-- 종료 날짜 추가 내용 -->
				<div class="float_left space_l10" style='display: none'>
					<div class="float_left">
						<input class="fieldline space_data" type="text" value="2010.11.10">
					</div>
					<div class="float_left">
						<select>
							<option>09:00</option>
							<option>10:00</option>
							<option>11:00</option>
							<option>12:00</option>
						</select>
					</div>
				</div>
				<!-- 종료 날짜 추가 내용 //-->

				<div class="float_left txt_btn">
					<input class="space_l10" name="chkEventAlarm" type="checkbox"
						value=""
						onclick="$(this).parent().next('div').toggle();" />
					<fmt:message key="common.upload.button.set_alarm" />
				</div>
				<!-- 알림 설정 내용 -->
				<div class="float_left" style="display: none;">
					<select>
						<option>정 시</option>
						<option>5분전</option>
						<option>10분전</option>
						<option>15분전</option>
					</select>
				</div>
				<!-- 알림 설정 내용 //-->

				<div class="float_left txt_btn">
					<input class="space_l10" name="chkEventRepeat"
						onclick="$(this).parent().parent().next('div').toggle();"
						type="checkbox" value="" />
					<fmt:message key="common.upload.button.set_repeat" />
				</div>

			</div>

			<!-- 반복 이벤트 설정 -->
			<div id="form_pop" style='display: none'>
				<div class="input_1line">
					<div class="float_left">
						<select>
							<option>매일</option>
							<option>매주</option>
							<option>매주 월-금</option>
							<option>매월</option>
							<option>매년</option>
						</select>
					</div>
					<div class="float_left space_l10">
						<input id="" class="fieldline" style="width: 19px" type="text"
							value="1"> 주마다
					</div>
					<div class="pos_day">
						<input name="" type="checkbox"><label>월</label> <input
							name="" type="checkbox"><label>화</label> <input name=""
							type="checkbox"><label>수</label> <input name=""
							type="checkbox"><label>목</label> <input name=""
							type="checkbox"><label>금</label> <input name=""
							type="checkbox"><label>토</label> <input name=""
							type="checkbox"><label>일</label>
					</div>
				</div>

				<div class="input_1line">
					<span class=""> <select>
							<option>오전12:30</option>
							<option>오전01:00</option>
							<option>오전01:30</option>
							<option>오전02:00</option>
							<option>오전02:30</option>
					</select> </span> <span class="space_l5"> <select>
							<option>1일 뒤</option>
							<option>2일 뒤</option>
							<option>3일 뒤</option>
							<option>4일 뒤</option>
							<option>5일 뒤</option>
							<option>6일 뒤</option>
							<option>1주 뒤</option>
							<option>2주 뒤</option>
					</select> </span> - <span class="space_l5"> <select>
							<option>오전12:30</option>
							<option>오전01:00</option>
							<option>오전01:30</option>
							<option>오전02:00</option>
							<option>오전02:30</option>
					</select> </span> <span class="pos_day"> <input name="" type="checkbox"><label>종일</label>
					</span>

				</div>
			</div>
			<!-- 반복 이벤트 설정 //-->

			<div class="input_1line">
				<input class="fieldline" id="" type="text" title=""
					placeholder="<fmt:message key='common.upload.event.place'/>">
			</div>
			<div class="input_1line fieldline js_user_names" ><div class="js_selected_users float_left"></div>
				<input class="js_auto_complete" href='user_name.sw'
					type="text" title=""
					placeholder="<fmt:message key='common.upload.event.related_users'/>">
<!-- 				<div class='js_srch_x'></div>
 -->			</div>
			<div class="js_user_list" style="display: none"></div>

			<div>
				<textarea class="up_textarea" cols="" rows="5">
					<fmt:message key='common.upload.event.content' />
				</textarea>
			</div>
		</div>
		<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
	</div>
</div>
