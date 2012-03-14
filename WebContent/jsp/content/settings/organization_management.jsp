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
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 컨텐츠 레이아웃-->
<div class="section_portlet js_organization_management_page">
	<div class="portlet_t"><div class="portlet_tl"></div></div>
	<div class="portlet_l" style="display: block;">
		<ul class="portlet_r" style="display: block;">
			<!-- 타이틀 -->
			<div class="body_titl">
				<div class="body_titl_iworks title_noico"><fmt:message key="settings.title.organization_management.setting"/></div>
				<div class="solid_line"></div>
			</div>
			<!-- 타이틀 //-->
			
			<!-- 컨텐츠 -->
			<div class="contents_space">
				<div>
					<table>
						<tbody>
							<tr>
								<td width="35%" class="vt"><div class="pop_list_area "><jsp:include page="/jsp/content/settings/comlist_by_depart.jsp"></jsp:include></div></td>
								<td width="65%" class="vt">
									<div class="tr mb2">
										<span class="btnIconsCreate"><a class="btnIconsTail js_new_department" href=""><fmt:message key="settings.button.add_department"/></a></span>
										<span class="btnIconsCreate"><a class="btnIconsTail js_new_member" href=""><fmt:message key="settings.button.add_member"/></a></span>
									</div>
									<!-- 상단 우측 버튼//-->
					
									<!-- 회사정보 -->
									<div class="gray_style table_nomal600 mb10">
										<table>
											<tbody>
												<tr>
													<th class="tc"><fmt:message key="profile.title.company"/></th>
													<td><%=CommonUtil.toNotNull(cUser.getCompany()) %></td>
												</tr>
											</tbody>
										</table>
									</div>
									<!-- 회사정보//-->
									<div class="js_edit_member"></div>									
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 컨텐츠 //-->
		</ul>
	</div>
	<div class="portlet_b" style="display: block;"></div>
</div>
<!-- 컨텐츠 레이아웃//-->
