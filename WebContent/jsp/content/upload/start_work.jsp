<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>

<!-- 등록하기- 새업무 입력 폼-->
<div class="up_form" style="height: 450px">
	<div class="up_point posit_works"></div>
	<div class="up up_padding">
		<!-- 폼- 디폴트-->
		<div id="up_works" class="js_start_work">
			<div class="up_warp space">
				<div class="up_form">
					<input class="up input_size js_auto_complete" type="text"
						href="work_name.sw"
						placeholder="<fmt:message key='common.upload.message.work'/>">
				</div>

				<div class="btn_wh btn_right" id="all_work_btn"
					style="display: none">
					<a href=""> <span class="Btn01Start"></span> <span
						class="Btn01Center"><fmt:message
								key="common.upload.button.all_works" /> </span> <span class="Btn01End"></span>
					</a>
				</div>
			</div>

			<!--검색 자동완성어 리스트-->
			<div class="srch_list" id="upload_work_list" style="display: none">
			</div>
			<!--검색 자동완성어 리스트//-->

		</div>
		<!-- 폼- 디폴트//-->

		<!-- 폼- 업무 입력 후 -->
		<div class="js_upload_form_detail" id="form_works" style="display:none"></div>
		<!-- 폼- 업무 입력 후 //-->
	</div>
</div>
