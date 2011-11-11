<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.util.SmartTest"%>
<%@page import="net.smartworks.model.community.User"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>

<script type="text/javascript">
function newInformationWork() {
	var frmApproval = document.frmApproval;
	var frmForward = document.frmForward;
	var frmScheduleWork = document.frmScheduleWork;

	var workId = Request('workId');
	var frmTotal = document.getElementById(workId);
	if(frmTotal){
		if(frmApproval){
			
		}
		if(frmFormward){
			
		}
		if(frmScheduleWork){
			
		}
		frmTotal.action = "create_iwork.sw";
		frmTotal.submit();
	}else{
		
	}
}
</script>
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
<div class="form_wrap up up_padding">
	<div class="form_title">
		<div class="ico_iworks title"><%=cWork.getFullpathName()%></div>
		<div class="txt_btn">
			<div>
				<a href=""><img src="images/btn_approvep.gif" title="<fmt:message key='common.button.approval'/>" /> </a>
			</div>
			<div>
				<a href=""><img src="images/btn_referw.gif" title="<fmt:message key='common.button.forward'/>" /> </a>
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
		<div id="form_import">
			<jsp:include page="/jsp/content/work/form/load_brief_form.jsp"></jsp:include>
		</div>
	</div>
	<jsp:include page="/jsp/content/upload/check_schedule_work.jsp"></jsp:include>
	<!-- 폼- 확장 //-->
	<jsp:include page="/jsp/content/upload/upload_buttons.jsp"></jsp:include>
</div>