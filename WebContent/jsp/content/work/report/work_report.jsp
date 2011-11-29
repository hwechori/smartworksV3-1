<%@page import="net.smartworks.model.report.Report"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@page import="net.smartworks.util.SmartTest"%>
<%@page import="net.smartworks.model.community.User"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>

<script type="text/javascript">
function submitForms(e) {
	if ($('form.js_validation_required').validate().form()) {
		var scheduleWork = document.getElementsByName('frmScheduleWork');
		if(scheduleWork[0].chkScheduleWork.value === 'on'){
			scheduleWork[0].hdnSchedulePerformer.value = $(scheduleWork[0].txtSchedulePerformer).attr('uid');
		}
		var params = $('form').serialize();
		var url = "create_new_iwork.sw";
		$.ajax({
			url : url,
			type : 'POST',
			data : params,
			success : function(data, status, jqXHR) {
				document.location.href = data.href;
			},
			error : function(e) {
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
	String workId = request.getParameter("workId");
	String reportId = request.getParameter("reportId");
	User cUser = SmartUtil.getCurrentUser(request, response);

 	SmartWork work = (SmartWork)smartWorks.getWorkById(cUser.getCompanyId(), cUser.getId(), workId);
 	Report report = smartWorks.getReportById(cUser.getCompanyId(), cUser.getId(), reportId);

 %>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />
<!--  전체 레이아웃 -->
<div class="up_wrap">
    	<div class="form_wrap up up_padding">
        
            
            <!-- 컨텐츠 -->
            <div class="contents_space">
              <div class="border"> 
              
              <div class="list_title_space">
                <div class="title_stat">새 통계분석 만들기</div>   
             </div>
                  
                <table class="margin_t10">
                <tbody>
                    <tr>
                    	<td width="11%"><div class="essen_r">제 목</div></td>
                      <td width="89%" colspan="3"><div class="fieldline"><input id="" type="text" title="" value="" ></div></td>
                  </tr>
                     <tr>
                    	<td>보고서 종류</td>
                        <td colspan="3" class="">
                        	<input name="" type="radio" >차트
                            <input name="" type="radio" >매트릭스
                            <input name="" type="radio" >테이블
                        </td>
                    </tr>
                    <tr>
                    	<td><div class="essen_r">차트 종류</div></td>
                        <td colspan="3" class="">
                        	  <select name="jumpMenu" id="jumpMenu">
                                <option>컬럼차트</option>
                                <option>막대차트</option>
                              </select>
                        </td>
                    </tr>
                     <tr>
                    	<td><div class="essen_r">X축</div></td>
                        <td colspan="3" class="">
                        	  <select name="jumpMenu" id="jumpMenu">
                                <option>업무처리기간</option>
                                <option> </option>
                              </select>
                        </td>
                    </tr>
                    <tr>
                    	<td><div class="essen_r">Y축</div></td>
                        <td colspan="3" class="">
                        	  <select name="jumpMenu" id="jumpMenu">
                                <option>총 처리건수</option>
                                <option> </option>
                              </select>
                        </td>
                    </tr>
                    <tr>
                    	<td><div class="essen_r">Z축</div></td>
                        <td colspan="3" class="">
                        	  <select name="jumpMenu" id="jumpMenu">
                                <option>업무처리기간</option>
                                <option> </option>
                              </select>
                        </td>
                    </tr>
                    <tr><td>상세필터</td></tr>
                </tbody>
                </table> 
                </div>               
            </div>
            

<!-- 등록 취소 버튼 -->
<div class="glo_btn_space">
    
    <div class="float_right padding_r10">
        <span class="btn_gray">
            <a href="">
            <span class="Btn01Start"></span>
            <span class="Btn01Center">저장</span>
            <span class="Btn01End"></span>            </a>        </span>

         <span class="btn_gray space_l5">
            <a href="">
            <span class="Btn01Start"></span>
            <span class="Btn01Center">취소</span>
            <span class="Btn01End"></span>            </a>        </span>    </div>
    
    <div class="float_right padding_r10">  
    
    <form  class="float_right form_space">
    	<img class="bu_read">
         <select>
              <option>전체공개</option>
              <option>비공개</option>
         </select>
    </form>
    </div>
</div>
<!-- 등록 취소 버튼//-->
	</div>    
</div>
<!-- 전체 레이아웃//-->
