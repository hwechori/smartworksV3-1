<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	
	String userId = request.getParameter("userId");
	User user = (SmartUtil.isBlankObject(userId)) ? new User() : smartWorks.getUserById(userId);
	
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="js_edit_member" userId="<%=userId%>">
	<!-- 사용자추가 -->
	<!-- 타이틀 영역 -->
	<div style="display:block">
		<div class="default_title_space">
			<%
			if(SmartUtil.isBlankObject(userId)){
			%>
				<div class="title"><fmt:message key="settings.title.organization.add_user"/></div>
			<%
			}else{
			%>
				<div class="title"><fmt:message key="settings.title.organization.modify_user"/></div>
			<%
			}
			%>
		</div>
		<!-- 타이틀 영역 //-->
		
		<div class="boTb">
			<table class="margin_t10">
				<tbody>
					<tr>
						<td width="20%" >부서별</td>
						<td width="80%">맨인소프트</td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input class="fieldline" type="text" title="" value="" /></td>
					</tr>
					<tr>
						<td>사용자 아이디</td>
						<td>
						<input class="fieldline" type="text" title="" value="" />
						<div class="txt_btn float_left">※ Email을 입력 하세요</div>
						
						<div class="float_right margin_t2">
							<div class="btnIconStart">
								<a class="btnIconsTail" href="">중복확인</a>
							</div>
						</div>
						</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input class="fieldline" type="text" title="" value="" /></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input class="fieldline" type="text" title="" value="" /></td>
					</tr>
					<tr>
						<td>사용자 번호</td>
						<td><input class="fieldline" type="text" title="" value="" /></td>
					</tr>
					<tr>
						<td>직 위</td>
						<td><input class="fieldline" type="text" title="" value="" /></td>
					</tr>
					<tr>
						<td>역 할</td>
						<td>
							<select name="">
								<option>부서원</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>사용자 수준</td>
						<td><select name="">
							<option>사용자</option>
						</select></td>
					</tr>
					<tr>
						<td>언 어</td>
						<td><select name="">
							<option>한국어</option>
						</select></td>
					</tr>
					<tr>
						<td>내선번호</td>
						<td><input class="fieldline" type="text" title="" value="" /></td>
					</tr>
					<tr>
						<td>휴대번호</td>
						<td><input class="fieldline" type="text" title="" value="" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<!-- Btn -->
		<div class="text_align_r margin_t8">
			<span class="btn_gray">
				<span class="Btn01Start"></span>
				<span class="Btn01Center">저장</span>
				<span class="Btn01End"></span>
			</span>
		</div>
		<!-- Btn //-->
	</div>
	<!-- 사용자추가 //-->
</div>										
