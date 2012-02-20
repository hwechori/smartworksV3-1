
<!-- Name 			: pop_new_category.jsp									 -->
<!-- Description	: 새로운 업무카테고리를 생성하는 팝업화면 						 -->
<!-- Author			: Maninsoft, Inc.										 -->
<!-- Created Date	: 2011.9.												 -->

<%@page import="net.smartworks.model.community.Group"%>
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
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다 
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	String categoryId = request.getParameter("categoryId");
	String categoryName = request.getParameter("categoryName");
	String categoryDesc = request.getParameter("categoryDesc");
	
%>
<script type="text/javascript">

	// 개인정보프로파일 수정하기 버튼을 클릭하면, 
	// 모든정보를 JSON형식으로 Serialize해서 서버의 update_my_profile.sw 서비스를 호출하여 수정한다.
	function submitForms(e) {
		var newCategory = $('.js_new_category_page');
		if (SmartWorks.GridLayout.validate(newCategory.find('form.js_validation_required'), $('.js_pop_error_message'))) {
			var forms = newCategory.find('form');
			var categoryId = newCategory.attr('categoryId');
			var paramsJson = {};
			if(!isEmpty(categoryId)) paramsJson['categoryId'] = categoryId;
			for(var i=0; i<forms.length; i++){
				var form = $(forms[i]);
				if(form.attr('name') === 'frmSmartForm'){
					paramsJson['formId'] = form.attr('formId');
					paramsJson['formName'] = form.attr('formName');
				}
				paramsJson[form.attr('name')] = mergeObjects(form.serializeObject(), SmartWorks.GridLayout.serializeObject(form));
			}
			console.log(JSON.stringify(paramsJson));
			var progressSpan = newCategory.find('.js_progress_span');
			smartPop.progressCont(progressSpan);
			var url = "create_new_category.sw";
			if(!isEmpty(categoryId)) url = "set_category.sw"
			$.ajax({
				url : url,
				contentType : 'application/json',
				type : 'POST',
				data : JSON.stringify(paramsJson),
				success : function(data, status, jqXHR) {
					// 사용자정보 수정이 정상적으로 완료되었으면, 현재 페이지에 그대로 있는다.
					smartPop.closeProgress();
 					smartPop.showInfo(smartPop.INFORM, isEmpty(categoryId) ? smartMessage.get('createCategorySucceed') : smartMessage.get('setCategorySucceed'), function(){
						document.location.href = document.location.href;
 						smartPop.close();
  					});
				},
				error : function(e) {
					smartPop.closeProgress();
					smartPop.showInfo(smartPop.ERROR, isEmpty(categoryId) ? smartMessage.get('createCategoryError') : smartMessage.get('setCategoryError'));
				}
			});
		}
	};
</script>

<!--  다국어 지원을 위해, 로케일 및 다국어 resource bundle 을 설정 한다. -->
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!--  전체 레이아웃 -->
<div class="pop_corner_all js_new_category_page" categoryId="<%=CommonUtil.toNotNull(categoryId)%>" categoryName="<%=CommonUtil.toNotNull(categoryName)%>" categoryDesc="<%=CommonUtil.toNotNull(categoryDesc)%>">

	<!-- 팝업 타이틀 -->
	<div class="form_title">
		<%
		if(SmartUtil.isBlankObject(categoryId)){
		%>
			<div class="pop_title"><fmt:message key="builder.title.new_category"></fmt:message></div>
		<%
		}else{
		%>
			<div class="pop_title"><fmt:message key="builder.title.text_category"></fmt:message></div>
		<%
		}
		%>
		<div class="txt_btn">
		<a href="" onclick="smartPop.close();return false;">
			<div class="btn_x">
			</div>
			</a>
		</div>
		<div class="solid_line"></div>
	</div>
	<!-- 팝업 타이틀 //-->
	<!-- 컨텐츠 -->
	<form name="frmNewWorkCategroy" class="js_validation_required">
		<div class="contents_space">
			<table>
				<tr>
					<td><fmt:message key="builder.title.category_name" /><span class="essen_n"></span></td>
					<td>
						<input name="txtCategoryName" class="fieldline required" type="text" value="<%=CommonUtil.toNotNull(categoryName)%>">		
					</td>
				</tr>
				<tr>
					<td><fmt:message key="common.title.desc" /></td>
					<td>
						<textarea name="txtCategoryDesc" class="fieldline" rows="4"><%=CommonUtil.toNotNull(categoryDesc) %></textarea>	
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 컨텐츠 //-->
	<!-- 버튼 영역 -->
	<div class="glo_btn_space">
	
	<!-- 실행시 데이터 유효성 검사이상시 에러메시지를 표시할 공간 -->
	<div class="sw_error_message js_pop_error_message" style="color: red"></div>
	<!--  실행시 표시되는 프로그래스아이콘을 표시할 공간 -->
			
		<div class="float_right padding_r10">
			<span class="js_progress_span float_right"></span>
			<span class="btn_gray">
				<a href="" onclick='submitForms(); return false;'>
					<span class="Btn01Start"></span>
					<%
					if(SmartUtil.isBlankObject(categoryId)){
					%>
						<span class="Btn01Center"><fmt:message key="common.button.create"/></span>
					<%
					}else{
					%>
						<span class="Btn01Center"><fmt:message key="common.button.modify"/></span>
					<%
					}
					%>
					<span class="Btn01End"></span>
				</a> 
			</span>
			 <span class="btn_gray space_l5"> 
				 <a href="" class="js_close_new_category"> 
				 	<span class="Btn01Start"></span>
				 	<span class="Btn01Center"><fmt:message key="common.button.cancel"/></span>
				 	<span class="Btn01End"></span> 
				 </a>
			</span>
		</div>
	</div>
	<!-- 버튼 영역 //-->

</div>
<!-- 전체 레이아웃//-->
