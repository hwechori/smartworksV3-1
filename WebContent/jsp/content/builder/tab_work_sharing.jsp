<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	
	String cid = request.getParameter("cid");
	String workId = SmartUtil.getSpaceIdFromContentContext(cid);
	
	SmartWork work = (SmartWork) smartWorks.getWorkById(workId);
	
	session.setAttribute("cid", cid);
	session.removeAttribute("wid");
	session.setAttribute("smartWork", work);

%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 컨텐츠 레이아웃-->
<div class="section_portlet js_tab_work_sharing_page" workId="<%=workId%>">
	<div class="portlet_t"><div class="portlet_tl"></div></div>
	<div class="portlet_l" style="display: block;">
		<ul class="portlet_r" style="display: block;">
			<!-- 타이틀 -->
			<div class="body_titl">
				<div class="body_titl_iworks title"><%=work.getName() %></div>
				<span class="t_location"><%=work.getFullpathName() %></span>
				<!-- tab -->
				<div id="" class="tab_adm float_right">
					<ul class="clear">
						<li><div><a href="tab_workbench.sw?cid=<%=cid %>" class="js_tab_smart_builder"><span class="btn_wo_adm"></span><fmt:message key="builder.title.work_definition"/></a></div></li>
						<li><div><a href="tab_work_settings.sw?cid=<%=cid %>" class="js_tab_smart_builder"><span class="btn_set_adm"></span><fmt:message key="builder.title.work_settings"/></a></div></li>
						<li class="current"><div class="end"><a><span class="btn_app_shar"></span><fmt:message key="builder.title.work_sharing"/></a></div></li>
					</ul>
				</div>
				<!-- tab//-->
				<div class="solid_line clear"></div>
			</div>
			<!-- 타이틀 -->
			<!-- 컨텐츠 -->
			<div class="contents_space">
				<!-- 타이틀 영역 -->
				<div class="default_title_space">
					<div class="title">업무설명</div>
				</div>
				<!-- 타이틀 영역// -->
				<!-- 업무설명 -->
				<div class="form_wrap up form_layout padding_t10 padding_b10">
					<div class="left_im">
						<img src="images/ic_noimage.gif" />
					</div>
					<div class="right_auto">
						<table>
							<tbody>
								<tr>
									<th width="20%">공유이름<span class="essen_n"></span>
									</th>
									<td colspan="3" width="80%"><input class="fieldline"
										type="text" title="" value="" />
									</td>
								</tr>
								<tr>
									<th>업무이름</th>
									<td width="30%">&nbsp;</td>
									<th width="20%">종 류</th>
									<td width="30%">&nbsp;</td>
								</tr>
								<tr>
									<th>업종별 <span class="essen_n"></span>
									</th>
									<td><select>
											<option>-</option>
									</select></td>
									<th>업무별 <span class="essen_n"></span>
									</th>
									<td><select name="select">
											<option>-</option>
									</select>
									</td>
								</tr>
								<tr>
									<th>내 용 <span class="essen_n"></span>
									</th>
									<td colspan="3"><textarea class="fieldline" name="" id=""
											cols="" rows="5"></textarea></td>
								</tr>
								<tr>
									<th>메뉴얼</th>
									<td colspan="3"><input type="file" /></td>
								</tr>
								<tr>
									<th>동영상</th>
									<td colspan="3"><input type="file" /></td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- 업무 설명 //-->
				</div>
				<!-- 타이틀 영역 -->
				<div class="default_title_space margin_t20">
					<div class="title">사용자 가이드 (개인메모)</div>
				</div>
				<!-- 타이틀 영역// -->
				<!-- 사용자 가이드 -->
				<div class="form_wrap up form_layout padding_t10 padding_b10">
					<!-- 타이틀 -->
					<div class="form_title padding0 margin_b10">
						<div class="ico_iworks title_noico">개인메모</div>
						<div class="solid_line clear"></div>
					</div>
					<!-- 타이틀 //-->
					<div class="left_im2">
						<img src="images/ic_noimageB.jpg" / width="315">
					</div>
					<div class="right_auto2">
						<table>
							<tbody>
								<tr>
									<th>화면설명</th>
								</tr>
								<tr>
									<td><input name="" type="radio" value="" /> 텍스트 <input
										name="" type="radio" value="" /> 편집기 <textarea
											class="fieldline" name="textarea" id="textarea" cols=""
											rows="9"></textarea>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- 사용자 가이드 //-->
				<!-- 하단버튼 영역 -->
				<div class="text_align_c margin_t10 clear">
					<span class="btn_gray"> <span class="Btn01Start"></span> <span
						class="Btn01Center"><span class="btn_app_shar_go"></span>
							앱스토어에 공유하기</span> <span class="Btn01End"></span> </span>
				</div>
				<!-- 하단 버튼 영역 //-->
			</div>
			<!-- 컨텐츠 //-->
		</ul>
	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 컨텐츠 레이아웃//-->
