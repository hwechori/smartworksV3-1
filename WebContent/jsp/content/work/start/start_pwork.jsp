<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.util.SmartTest"%>
<%@page import="net.smartworks.model.community.User"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>

<script type="text/javascript">
	function submitForms() {
		if ($('form.js_validation_required').validate().form()) {
			var params = $('form').serialize();
			var url = "start_new_pwork.sw";
			$.ajax({
				url : url,
				type : 'POST',
				data : params,
				success : function(data, status, jqXHR) {
					document.location.href = data.href;
				},
				error : function(jqXHR, status, error) {
					console.log(jqXHR);
					console.log(status);
					console.log(error);
				}
			});
		} else {
			return;
		}
		return;
	}
</script>

<%
	String companyId = (String) session.getAttribute("companyId");
	String userId = (String) session.getAttribute("userId");
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String workId = request.getParameter("workId");
	User cUser = SmartUtil.getCurrentUser(request);

	Work work = smartWorks.getWorkById(companyId, cUser.getId(), workId);
	SmartWork cWork = null;
	if (work.getClass().equals(SmartWork.class))
		cWork = (SmartWork) work;
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 폼- 확장 -->
<div class="form_wrap up up_padding">
	<div class="form_title">
		<div class="ico_pworks title"><%=cWork.getFullpathName()%>

			<span class="txt_btn padding_l10"> <a href=""><fmt:message
						key="common.upload.button.view_process" />▼</a> </span>

		</div>

		<div class="txt_btn">
			<div>
				<a href=""><img src="images/btn_referw.gif"
					title="<fmt:message key='common.button.approval'/>" /> </a>
			</div>
		</div>
		<div class="solid_line"></div>
	</div>

	<div class="form_contents">

		<div class="txt_btn">
			<div>
				<a class="js_toggle_form_detail"
					href="load_detail_form.sw?key=<%=cWork.getId()%>"><fmt:message
						key="common.upload.button.detail" /> </a>
			</div>
			<div style="display: none">
				<a class="js_toggle_form_detail"
					href="load_brief_form.sw?key=<%=cWork.getId()%>"><fmt:message
						key="common.upload.button.brief" /> </a>
			</div>
		</div>


		<form name='frmInstanceSubject' class="js_validation_required">
			<table>
				<colgroup>
					<col class="item">
					<col class="field">
					<col class="item">
					<col class="field">
				</colgroup>
				<tbody>
					<tr>
						<td><fmt:message key='common.upload.field.subject' />
						</td>
						<td colspan="3"><input name="hdnProcessWorkId" type="hidden"
							value="<%=workId%>"><input
							class="fieldline essen required" name="txtInstanceSubject"
							type="text"></td>
					</tr>
				</tbody>
			</table>
		</form>

		<div class="dash_line"></div>



		<div id="form_import">
			<jsp:include page="/jsp/content/work/form/load_brief_form.jsp"></jsp:include>
		</div>
	</div>

	<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
</div>
<!-- 폼- 확장 //-->

