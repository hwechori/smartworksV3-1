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
	String workId = request.getParameter("workId");
	User cUser = SmartUtil.getCurrentUser();

	Work work = smartWorks.getWorkById(workId);
	SmartWork cWork = null;
	if (work.getClass().equals(SmartWork.class))
		cWork = (SmartWork) work;
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 폼- 확장 -->
<div id="form_wrap">
	<div id="form_title">
		<div class="ico_iworks title"><%=cWork.getFullpathName()%></div>
		<div class="txt_btn float_left padding_l10">
			<a href="">프로세스 보기▼</a>
		</div>
		<div class="txt_btn">
			<div>
				<a href=""><fmt:message
									key="common.upload.button.forwardee" /></a>
			</div>
			<div>
				<a href=""><fmt:message
									key="common.upload.button.approval" /></a>
			</div>
		</div>
	</div>

	<div id="form_contents">
		<table>
			<colgroup>
				<col class="item">
				<col class="field">
				<col class="item">
				<col class="field">
			</colgroup>
			<tbody>
				<tr class="js_start_tab_form">
					<td colspan="4">
						<div class="txt_btn">
							<div>
							<a href="load_detail_form.sw?key=<%=cWork.getId()%>"><fmt:message
									key="common.upload.button.detail" /> </a>
							</div>
							<div class="current">
							<a href="load_brief_form.sw?key=<%=cWork.getId()%>"><fmt:message
									key="common.upload.button.brief" /> </a>
							</div>
						</div>
					</td>
				</tr>
					<div id="form_import">
						<jsp:include page="/jsp/content/work/form/load_brief_form.jsp"></jsp:include>
					</div></td>
				<tr>
					<td>제 목</td>
					<td colspan="3" class=""><div class="fieldline essen">
							<input id="" type="text" title="" value="">
						</div></td>
				</tr>
				<tr>
					<td>과제명</td>
					<td>
						<div class="ico_space">
							<div class="fieldline">
								<input id="" type="text" title="" value="">
							</div>
							<div class="ico_posi">
								<img src="../images/btn_s_search.jpg" />
							</div>
						</div>
					</td>
					<td class="padding_l20">진행단계</td>
					<td>
						<div>
							<form name="form" id="form">
								<select name="jumpMenu" id="jumpMenu"
									onchange="MM_jumpMenu('parent',this,0)" style="width: 100%;">
									<option>계획</option>
									<option>item2</option>
									<option>item3</option>
									<option>item4</option>
								</select>
							</form>
						</div>
					</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>
						<div class="ico_space">
							<div class="fieldline essen">
								<input id="" type="text" title="" value="">
							</div>
							<div class="ico_posi">
								<img src="../images/btn_s_person.png" />
							</div>
						</div>
					</td>
					<td class="padding_l20">작성일자</td>
					<td>
						<div class="ico_space">
							<div class="fieldline essen">
								<input id="" type="text" title="" value="">
							</div>
							<div class="ico_posi">
								<img src="../images/btn_s_calendar.png" />
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>시작시간</td>
					<td>
						<div class="">
							<form name="form" id="form">
								<select name="jumpMenu" id="jumpMenu" class="essen"
									onchange="MM_jumpMenu('parent',this,0)" style="width: 100%;">
									<option>09:00</option>
									<option>10:00</option>
									<option>item3</option>
									<option>item4</option>
								</select>
							</form>
						</div>
					</td>
					<td class="padding_l20">종료시간</td>
					<td>
						<div class="">
							<form name="form" id="form">
								<select name="jumpMenu" id="jumpMenu" class="essen"
									onchange="MM_jumpMenu('parent',this,0)" style="width: 100%;">
									<option>09:00</option>
									<option>10:00</option>
									<option>item3</option>
									<option>item4</option>
								</select>
							</form>
						</div>
					</td>
				</tr>
				<tr>
					<td>장 소</td>
					<td colspan="3" class=""><div class="fieldline essen">
							<input id="" type="text" title="" value="">
						</div></td>
				</tr>
				<tr>
					<td>내 용</td>
					<td colspan="3" class="">
						<div class="up_form textarea_size">
							<textarea class="up up_textarea essen" name="내용" cols="" rows="5"
								value="내용"></textarea>
						</div>
					</td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td colspan="3" class="">
						<div class="btn_space">
							<div class="fieldline">
								<input id="" type="text" title="" value="">
							</div>

							<div class="btn_wh btn_posi">
								<a href=""> <span class="Btn01Start"></span> <span
									class="Btn01Center">첨부파일</span> <span class="Btn01End"></span>
								</a>
							</div>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>


</div>
<!-- 폼- 확장 //-->
<div id="form_works">
	<table>
		<colgroup>
			<col class="item">
			<col class="field">
			<col class="item">
			<col class="field">
		</colgroup>
		<tbody>
			<tr>
				<th colspan="2"><%=cWork.getFullpathName()%></th>
				<td colspan="2">
					<div class="txt_btn">
						<div>
							<a class="js_select_forwardee" href=""><fmt:message
									key="common.upload.button.forwardee" /> </a>
						</div>
						<div>
							<a class="js_select_approval" href=""><fmt:message
									key="common.upload.button.approval" /> </a>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="4" class="solid_line"></td>
			</tr>
			<tr class="js_start_tab_form">
				<td colspan="4">
					<div class="txt_btn">
						<div>
							<a href="load_detail_form.sw?key=<%=cWork.getId()%>"><fmt:message
									key="common.upload.button.detail" /> </a>
						</div>
						<div class="current">
						</div>
					</div>
					<div id="form_import">
						<jsp:include page="/jsp/content/work/form/load_brief_form.jsp"></jsp:include>
					</div></td>
			</tr>
		</tbody>
	</table>
</div>
<jsp:include page="/jsp/content/upload/check_schedule_work.jsp"></jsp:include>
