<%@page import="net.smartworks.util.LocaleInfo"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
User cUser = SmartUtil.getCurrentUser(request, response);

%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />
<div class="pop_section">

	<div class="pop_top">
		<div class="pop_portlet_l"></div>
		<div class="pop_portlet">
			<div class="pop_title">개인정보 관리</div>

			<!-- 닫기 버튼 -->
			<div class="txt_btn">
				<div class="pop_btn_posi btn_x">
					<a href=""> <span> </span> </a>
				</div>
			</div>
			<!-- 닫기 버튼 //-->

		</div>
	</div>

	<!-- 컨텐츠 레이아웃 -->
	<div class="pop_l">
		<div class="pop_r">

			<!-- 컨텐츠 -->
			<div class="pop_contents">

				<div class="margin_t10 txt_btn">
					<div class="po_right essen_gn"><fmt:message key="profile.title.required_field"/></div>
				</div>
				<div class="table_line"></div>

				<div class="photo_section">
					<img src="../images/pic_size_110.jpg" /> <input type="file"
						onchange="imgSave();" style="width: 90px; border: 0;" size="1"
						name="picture">
				</div>

				<div class="table_section">
					<table class="table_nomal">
						<tr>
							<th class="essen_n" width="25%">사용자 아이디</th>
							<td width="65%" colspan="3">
								<input name="txtUserProfileUserId" type="text" readonly="readonly" value="<%=cUser.getId()%>"></td>
						</tr>

						<tr>
							<th class="essen_n">이 름</th>
							<td colspan="3">
								<div class="fieldline">
									<input name="txtUserProfileUserName" type="text" value="<%=cUser.getName() %>">
								</div></td>
						</tr>

						<tr>
							<th class="essen_n">사용자 번호</th>
							<td colspan="3">
								<div class="fieldline">
									<input name="txtUserProfileEmpId" type="text" value="<%=cUser.getEmployeeId() %>" title="">
								</div></td>
						</tr>

						<tr>
							<th class="essen_n">비밀번호</th>
							<td colspan="3">
								<div class="fieldline">
									<input name="pwUserProfilePW" type="password" value="<%=cUser.getPassword() %>" title="">
								</div></td>
						</tr>
						<tr>
							<th class="essen_n">비밀번호 확인</th>
							<td colspan="3">
								<div class="fieldline">
									<input name="pwUserProfilePWCfm" type="password" value="<%=cUser.getPassword() %>" title="">
								</div></td>
						</tr>
						<tr>
							<th class="essen_n">회사</th>
							<td colspan="3">
								<div class="fieldline">
									<input name="txtUserProfileCompany" type="text" readonly="readonly" value="<%=cUser.getCompany() %>" title="">
								</div></td>
						</tr>
						<tr>
							<th class="essen_n">부서</th>
							<td colspan="3">
								<div class="fieldline">
									<input name="txtUserProfileDepartment" type="text" companyId="<%=cUser.getCompanyId() %>" value="<%=cUser.getDepartment() %>" title="">
								</div></td>
						</tr>
						<tr>
							<th class="essen_n">직위</th>
							<td colspan="3">
								<div class="fieldline">
									<input name="txtUserProfilePosition" type="text" value="<%=cUser.getPosition() %>" title="">
								</div></td>
						</tr>
						<tr>
							<th class="essen_n">언어</th>
							<td colspan="3"><select name="selUserProfileLocale">
							<%
							for(String locale : LocaleInfo.supportingLocales){
							%>
									<option <%if(cUser.getLocale().equals(locale)){ %>selected<%} %>><fmt:message key="common.title.locale.<%=locale%>"/></option>
							<%}
							%>
							</select></td>
						</tr>
						<tr>
							<th class="essen_n">내선번호</th>
							<td colspan="3">
								<div class="fieldline">
									<input name="txtUserProfilePhoneNo" type="text" value="<%=cUser.getPhoneNo() %>" title="">
								</div></td>
						</tr>
						<tr>
							<th class="essen_n">휴대번호</th>
							<td colspan="3">
								<div class="fieldline">
									<input name="txtUserProfileCellNo" type="text" value="<%=cUser.getCellPhoneNo() %>" title="">
								</div></td>
						</tr>
					</table>
				</div>

			</div>
			<!-- 컨텐츠 //-->

			<!-- 버튼 영역 -->
			<div class="pop_btn_space">
				<div class="float_right padding_r10">
					<span class="btn_gray"> <a href=""> <span
							class="Btn01Start"></span> <span class="Btn01Center">저장</span> <span
							class="Btn01End"></span> </a> </span> <span class="btn_gray space_l5">
						<a href=""> <span class="Btn01Start"></span> <span
							class="Btn01Center">취소</span> <span class="Btn01End"></span> </a> </span>
				</div>
			</div>
			<!-- 버튼 영역 //-->


		</div>
	</div>
	<!-- 컨텐츠 레이아웃 //-->

	<div class="pop_bottom">
		<div class="pop_b_l"></div>
		<div class="pop_b_r"></div>
	</div>




</div>

<!-- 전체 레이아웃//-->
