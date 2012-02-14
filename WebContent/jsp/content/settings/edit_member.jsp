<%@page import="net.smartworks.util.LocaleInfo"%>
<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
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

<div class="js_edit_member_page" userId="<%=userId%>">
	<!-- 회사정보 -->
	<div class="gray_style table_nomal600">
		<table>
			<tbody>
				<tr>
					<th class="text_align_c"><fmt:message key="profile.title.company"/></th>
					<td><%=CommonUtil.toNotNull(cUser.getCompany()) %></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- 회사정보//-->

	<!-- 사용자추가 -->
	<!-- 타이틀 영역 -->
	<div style="display:block">
		<div class="default_title_space">
			<%
			if(SmartUtil.isBlankObject(userId)){
			%>
				<div class="title"><fmt:message key="settings.title.add_user"/></div>
			<%
			}else{
			%>
				<div class="title"><fmt:message key="settings.title.modify_user"/></div>
			<%
			}
			%>
		</div>
		<!-- 타이틀 영역 //-->
		
		<div class="boTb">
			<table class="margin_t10">
				<tbody>
					<tr>
						<td width="20%" ><fmt:message key="profile.title.department"/></td>
						<td width="80%"><%=CommonUtil.toNotNull(user.getDepartment()) %></td>
					</tr>
					<tr>
						<td><fmt:message key="profile.title.user_name"/></td>
						<td><input name="txtMemberName" class="fieldline required" type="text" value="<%=CommonUtil.toNotNull(user.getName()) %>" /></td>
					</tr>
					<tr>
						<td><fmt:message key="profile.title.user_id"/></td>
						<td>
						<input name="txtMemberId" class="fieldline" type="text" value="<%=CommonUtil.toNotNull(user.getId()) %>" />
						<div class="txt_btn float_left">※ Email을 입력 하세요</div>
						
						<div class="float_right margin_t2">
							<div class="btnIconStart">
								<a class="btnIconsTail" href="">중복확인</a>
							</div>
						</div>
						</td>
					</tr>
					<tr>
						<td><fmt:message key="profile.title.password"/></td>
						<td><input name="pasMemberPassword" class="fieldline" type="text" value="<%=CommonUtil.toNotNull(user.getPassword()) %>" /></td>
					</tr>
					<tr>
						<td><fmt:message key="profile.title.password_confirm"/></td>
						<td><input name="pasMemberPasswordConfirm" class="fieldline" type="text" value="<%=CommonUtil.toNotNull(user.getPassword()) %>" /></td>
					</tr>
					<tr>
						<td><fmt:message key="profile.title.employee_id"/></td>
						<td><input name="txtMemberEmployeeId" class="fieldline" type="text" value="<%=CommonUtil.toNotNull(user.getEmployeeId()) %>" /></td>
					</tr>
					<tr>
						<td><fmt:message key="profile.title.position"/></td>
						<td><input name="txtMemberPosition" class="fieldline" type="text" value="<%=CommonUtil.toNotNull(user.getPosition()) %>" /></td>
					</tr>
					<tr>
						<td><fmt:message key="profile.title.role"/></td>
						<td>
							<select name="selMemberRole">
								<option <%if(user.getRole()==User.USER_ROLE_MEMBER){ %>selected<%} %> value="<%=User.USER_ROLE_MEMBER %>"><fmt:message key="department.role.head"/></option>
								<option <%if(user.getRole()==User.USER_ROLE_LEADER){ %>selected<%} %> value="<%=User.USER_ROLE_LEADER %>"><fmt:message key="department.role.member"/></option>
							</select>
						</td>
					</tr>
					<tr>
						<td><fmt:message key="profile.title.user_level"/></td>
						<td><select name="selMemberUserLevel">
							<option <%if(user.getUserLevel()==User.USER_LEVEL_INTERNAL_USER){ %>selected<%} %> value="<%=User.USER_LEVEL_INTERNAL_USER%>"><fmt:message key="organization.user_level.internal_user"/></option>
							<option <%if(user.getUserLevel()==User.USER_LEVEL_SYSMANAGER){ %>selected<%} %> value="<%=User.USER_LEVEL_SYSMANAGER%>"><fmt:message key="organization.user_level.system_user"/></option>
							<option <%if(user.getUserLevel()==User.USER_LEVEL_AMINISTRATOR){ %>selected<%} %> value="<%=User.USER_LEVEL_AMINISTRATOR%>"><fmt:message key="organization.user_level.administrator"/></option>
							<option <%if(user.getUserLevel()==User.USER_LEVEL_EXTERNAL_USER){ %>selected<%} %> value="<%=User.USER_LEVEL_EXTERNAL_USER%>"><fmt:message key="organization.user_level.external_user"/></option>
						</select></td>
					</tr>
					<tr>
						<td><fmt:message key="profile.title.locale"/></td>
						<td><select name="selMemberLocale">
							<option <%if(user.getLocale().equals(LocaleInfo.LOCALE_KOREAN)){ %>selected<%} %> value="<%=LocaleInfo.LOCALE_KOREAN%>"><fmt:message key="common.title.locale.ko"/></option>
							<option <%if(user.getLocale().equals(LocaleInfo.LOCALE_ENGLISH)){ %>selected<%} %> value="<%=LocaleInfo.LOCALE_ENGLISH%>"><fmt:message key="common.title.locale.en"/></option>
						</select></td>
					</tr>
					<tr>
						<td><fmt:message key="profile.title.phone_no"/></td>
						<td><input name="txtMemberPhoneNo" class="fieldline" type="text" value="<%=CommonUtil.toNotNull(user.getPhoneNo()) %>" /></td>
					</tr>
					<tr>
						<td><fmt:message key="profile.title.cell_phone_no"/></td>
						<td><input name="txtMemberCellPhoneNo" class="fieldline" type="text" value="<%=CommonUtil.toNotNull(user.getCellPhoneNo()) %>" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<!-- Btn -->
		<div class="text_align_r margin_t8">
			<span class="btn_gray">
				<span class="Btn01Start"></span>
				<%
				if(SmartUtil.isBlankObject(userId)){
				%>
					<span class="Btn01Center"><fmt:message key="common.button.create"/></span>
				<%
				}else{
				%>
					<span class="Btn01Center"><fmt:message key="common.button.save"/></span>
				<%
				}
				%>
				<span class="Btn01End"></span>
			</span>
		</div>
		<!-- Btn //-->
	</div>
	<!-- 사용자추가 //-->
</div>										
