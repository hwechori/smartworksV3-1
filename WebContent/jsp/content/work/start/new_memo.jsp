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
			var url = "create_new_memo.sw";
			$.ajax({
				url : url,
				type : 'POST',
				data : {
					params : params
				},
				success : function(data, status, jqXHR) {
					alert("success");
				},
				exception : function(e) {
					alert(e);
				}
			});
		} else {
			return;
		}
		return;
	}
</script>

<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<div class="up_wrap">
	<div class="up_point posit_memo"></div>
	<div class="form_wrap up up_padding">


		<!-- 폼- 확장 -->
		<form name='frmMemo' class="form_title js_validation_required">
			<div>
				<textarea class="up_textarea required" name="txtMemoDesc" cols=""
					rows="5"></textarea>
			</div>
		</form>
		<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>

	</div>
</div>
