<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.model.KeyMap"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.util.LocaleInfo"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser(request, response);
	KeyMap[] timeZoneNames = LocalDate.getAvailableTimeZoneNames(cUser.getLocale());
%>
<script type="text/javascript">
	function submitForms(e) {
		if ($('form.js_validation_required').validate().form()) {
			var params = $('form').serialize();
			var url = "modify_my_profile.sw";
			$.ajax({
				url : url,
				type : 'POST',
				data : params,
				success : function(data, status, jqXHR) {
					document.location.href = data.href;
					alert(data);
				},
				error : function(jqXHR, status, error) {
					console.log(status);
					console.log(error);
					alert(error);
				}
			});
		} else {
			return;
		}
		return;
	}
</script>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />
<div class="pop_section">

	<div class="pop_top">
		<div class="pop_portlet_l"></div>
		<div class="pop_portlet">
			<div class="pop_title">
				<fmt:message key="content.title.my_profile"></fmt:message>
			</div>

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
				<form name="frmMyProfileSetting" class="js_validation_required">
				<div class="margin_t10 txt_btn">
					<div class="po_right essen_gn">
						<fmt:message key="profile.title.required_field" />
					</div>
				</div>
				<div class="table_line"></div>

				<div class="photo_section">
					<img src="<%=cUser.getOrgPicture() %>" /> <input name="filUserProfilePicture" type="file"
						onchange="" style="width: 90px; border: 0;" size="1" >
				</div>

				<div class="table_section">
					<table class="table_nomal">
						<tr>
							<th><fmt:message key="profile.title.company" />
							</th>
							<td colspan="3">
								<div>
									<input name="txtUserProfileCompany" type="text" class="required"
										readonly="readonly" value="<%=CommonUtil.toNotNull(cUser.getCompany())%>" title="">
								</div>
							</td>
						</tr>
						<tr>
							<th width="25%"><fmt:message
									key="profile.title.user_id" />
							</th>
							<td width="65%" colspan="3"><input
								name="txtUserProfileUserId" type="text" readonly="readonly"
								value="<%=CommonUtil.toNotNull(cUser.getId())%>">
							</td>
						</tr>

						<tr>
							<th class="essen_n"><fmt:message
									key="profile.title.user_name" />
							</th>
							<td colspan="3">
								<div class="fieldline">
									<input name="txtUserProfileUserName" type="text" class="required"
										value="<%=CommonUtil.toNotNull(cUser.getName())%>">
								</div>
							</td>
						</tr>

						<tr>
							<th><fmt:message
									key="profile.title.employee_id" />
							</th>
							<td colspan="3">
								<div class="fieldline">
									<input name="txtUserProfileEmpId" type="text"
										value="<%=CommonUtil.toNotNull(cUser.getEmployeeId())%>" title="">
								</div>
							</td>
						</tr>

						<tr>
							<th class="essen_n"><fmt:message
									key="profile.title.password" />
							</th>
							<td colspan="3">
								<div class="fieldline">
									<input name="pwUserProfilePW" type="password" class="required"
										value="<%=CommonUtil.toNotNull(cUser.getPassword())%>" title="">
								</div>
							</td>
						</tr>
						<tr>
							<th class="essen_n"><fmt:message
									key="profile.title.password_confirm" />
							</th>
							<td colspan="3">
								<div class="fieldline">
									<input name="pwUserProfilePWCfm" type="password" class="required"
										value="<%=CommonUtil.toNotNull(cUser.getPassword())%>" title="">
								</div>
							</td>
						</tr>
						<tr>
							<th class="essen_n"><fmt:message
									key="profile.title.department" />
							</th>
							<td colspan="3">
								<div class="fieldline">
									<input name="txtUserProfileDepartment" type="text" class="required"
										companyId="<%=cUser.getCompanyId()%>"
										value="<%=CommonUtil.toNotNull(cUser.getDepartment())%>" title="">
								</div>
							</td>
						</tr>
						<tr>
							<th class="essen_n"><fmt:message
									key="profile.title.position" />
							</th>
							<td colspan="3">
								<div class="fieldline">
									<input name="txtUserProfilePosition" type="text" class="required"
										value="<%=CommonUtil.toNotNull(cUser.getPosition())%>" title="">
								</div>
							</td>
						</tr>
						<tr>
							<th class="essen_n"><fmt:message key="profile.title.locale" />
							</th>
							<td colspan="3"><select name="selUserProfileLocale">
									<%
										for (String locale : LocaleInfo.supportingLocales) {
											String strKey = "common.title.locale." + locale;
									%>
									<option value="<%=locale%>" <%if (cUser.getLocale().equals(locale)) {%> selected
										<%}%>>
										<fmt:message key="<%=strKey%>" />
									</option>
									<%
										}
									%>
							</select>
							</td>
						</tr>
						<tr>
							<th class="essen_n"><fmt:message
									key="profile.title.timezone" />
							</th>
							<td colspan="3"><select name="selUserProfileTimeZone">
									<%
										for (KeyMap timeZoneName : timeZoneNames) {
									%>
									<option value="<%=timeZoneName.getId()%>"
										<%if (cUser.getTimeZone().equals(timeZoneName.getId())) {%>
										selected <%}%>><%=timeZoneName.getKey()%></option>
									<%
										}
									%>
							</select>
							</td>
						</tr>
						<tr>
							<th><fmt:message
									key="profile.title.phone_no" />
							</th>
							<td colspan="3">
								<div class="fieldline">
									<input name="txtUserProfilePhoneNo" type="text"
										value="<%=CommonUtil.toNotNull(cUser.getPhoneNo())%>" title="">
								</div>
							</td>
						</tr>
						<tr>
							<th><fmt:message
									key="profile.title.cell_phone_no" />
							</th>
							<td colspan="3">
								<div class="fieldline">
									<input name="txtUserProfileCellNo" type="text"
										value="<%=CommonUtil.toNotNull(cUser.getCellPhoneNo())%>" title="">
								</div>
							</td>
						</tr>
					</table>
				</div>
				</form>
			</div>
			<!-- 컨텐츠 //-->

			<!-- 버튼 영역 -->
			<div class="pop_btn_space">
				<div class="float_right padding_r10">
					<a href="" onclick='submitForms(); return false;'> <span
						class="btn_gray"><span class="Btn01Start"></span> <span
							class="Btn01Center"><fmt:message key="popup.button.modify_my_profile"/></span> <span class="Btn01End"></span>
					</a> </span> <span class="btn_gray space_l5"> <a href=""
						onclick="return true;"> <span
							class="Btn01Start"></span> <span class="Btn01Center"><fmt:message key="common.button.cancel"/></span> <span
							class="Btn01End"></span> </a> </span>
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
