<%@page import="net.smartworks.model.instance.info.TaskInstanceInfo"%>
<%@page import="net.smartworks.model.instance.TaskInstance"%>
<%@page import="net.smartworks.model.work.InformationWork"%>
<%@page import="net.smartworks.model.community.WorkSpace"%>
<%@page import="net.smartworks.model.instance.InformationWorkInstance"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String workId = request.getParameter("workId");
	String instanceId = request.getParameter("instanceId");
	User cUser = SmartUtil.getCurrentUser(request, response);

	InformationWorkInstance instance = (InformationWorkInstance)smartWorks.getWorkInstanceById(cUser.getCompanyId(), cUser.getId(), instanceId);
	User owner = instance.getOwner();
	WorkSpace workSpace = instance.getWorkSpace();
	InformationWork work = (InformationWork)instance.getWork();
	int numberOfRelatedWorks = instance.getNumberOfRelatedWorks();
	int numberOfHistories = 0;
	if(!instance.isApprovalWork()){
		TaskInstanceInfo[] tasks = instance.getTasks();
		if(tasks != null){
			for(TaskInstanceInfo task : tasks){
				if(task.getType() == TaskInstance.TYPE_INFORMATION_TASK_ASSIGNED || task.getType() == TaskInstance.TYPE_INFORMATION_TASK_CREATED
					|| task.getType() == TaskInstance.TYPE_INFORMATION_TASK_UDATED){
					numberOfHistories++;
				}
			}
		}
	}
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />
<!-- 컨텐츠 레이아웃-->
    <div class="section_portlet">
    <div class="portlet_t">
      <div class="portlet_tl"></div>
    </div>
    <div class="portlet_l" style="display: block;">
    <ul class="portlet_r" style="display: block;">
            
            <!-- 타이틀 -->
            	<div class="body_titl_pic">

                    <div class="">
                        <div class="noti_pic"><img src="<%=instance.getOwner().getMidPicture() %>" /></div>
                        <div class="noti_in_bodytitle">
                            <span class="t_name"><%=instance.getOwner().getLongName()%></span>
                            <%if(workSpace != null && !workSpace.getId().equals(owner.getId())){ %><span class="arr">▶</span><span class="ico_division_s"><%=workSpace.getName() %></span><%} %>
                            <span class="t_date"><%=instance.getCreatedDate().toLocalString() %></span>
                            <div class=""><span class="ico_iworks t_date"><%=work.getFullpathName() %></span> <span class="title_picico"><%=instance.getSubject()%></span></div>
                        </div>
                    </div>
                    
            <!-- 우측 버튼-->
             <div class="txt_btn">
                <div class="po_right"><a href=""><fmt:message key="common.button.copy_url"/></a></div>
            </div>
            
            <div class="txt_btn">
                <div class="po_right"><a href=""><img src="images/btn_print.gif" title=<fmt:message key="cmmon.button.print"/> /></a></div>
                <div class="po_right"><a href=""><img src="images/btn_mail.gif" title=<fmt:message key="common.button.email"/> /></a></div>
                <div class="po_right"><a href=""><img src="images/btn_approvep.gif" title=<fmt:message key="common.button.approval"/> /></a></div>
                <div class="po_right"><a href=""><img src="images/btn_referw.gif" title=<fmt:message key="cmmon.button.forward"/> /></a></div>
            </div>
            <!-- 우측 버튼 -->
                    
                	<div class="solid_line"></div>
                </div>
            <!-- 타이틀 -->
            
<!-- 상세보기 컨텐츠 -->
<div class="contents_space">
            
            <!-- 업무 내용 --> 
            <div class="list_contents">      
                <table>
                <colgroup>
                        <col width="12%">
                        <col width="13%">
                        <col width="12%">
                        <col width="12%">
                        <col width="12%">
                        <col width="12%">
                        <col width="12%">
                        <col width="12%">
                    </colgroup>
                <tbody>
                    <tr>
                        <th style=" text-align:right">작성자</th>
                        <td class="r_line">선임 신현성</td>
                        <th>회의일자</th>
                        <td class="r_line">2011.11.15</td>
                        <th>회의시간</th>
                        <td class="r_line">13:00</td>
                        <th>회의장소</th>
                        <td>회의실</td>
                    </tr>
                    <tr>
                        <th style=" text-align:right">참석자</th>
                        <td colspan="7">정보관리업무 제목 목록입니다</td>
                    </tr>
                    
                    <tr>
                        <th style=" text-align:right">회의안건</th>
                        <td colspan="7">정보관리업무 제목 목록입니다</td>
                    </tr>
                    
                    <tr>
                        <th style=" text-align:right">회의내용</th>
                        <td colspan="7">정보관리업무 제목 목록입니다</td>
                    </tr>
                </tbody>
                </table> 
        </div>
          <!-- 업무 내용 //--> 
</div>

<!-- 버튼 영역 -->
<div class="glo_btn_space">

<div class="txt_btn info_repl">
    <%if(numberOfRelatedWorks > 0){ %><div class="po_left"><a href=""><fmt:message key="common.title.refering_works"/><span class="t_up_num">[<%=numberOfRelatedWorks %>]</span></a></div><%} %>
    <%if(numberOfHistories > 0){ %><div class="po_left"><a href=""><fmt:message key="common.title.update_history"/><span class="t_up_num">[<%=numberOfHistories %>]</span></a></div><%} %>
    <div class="po_left"><fmt:message key="common.title.last_modification"/><a href=""><img src="<%=instance.getLastModifier().getMinPicture() %>" alt="size24" width="24" height="24" /> <%=instance.getLastModifier().getLongName() %></a> <span class="t_date"> <%= instance.getLastModifiedDate().toLocalString() %> </span></div>
</div>     
<!-- 수정, 삭제버튼 -->
    <div class="float_right">
        <span class="btn_gray">
            <span class="Btn01Start"></span>
            <span class="Btn01Center">수정하기</span>
            <span class="Btn01End"></span>
            </span>

         <span class="btn_gray space_l5">
            <span class="Btn01Start"></span>
            <span class="Btn01Center">삭제하기</span>
            <span class="Btn01End"></span></span>
     </div>
<!-- 수정, 삭제버튼 //-->    
  
</div>
<!-- 버튼 영역 //-->     

</ul>
</div>
<div class="portlet_b" style="display: block;"></div>
</div> 
<!-- 컨텐츠 레이아웃//-->

<!-- 댓글 영역 -->
<div class="gr_up_point posit_point"></div>
  <!-- 댓글 목록 -->
  <div class="gr_portlet">
    <div class="gr_portlet_t">
      <div class="gr_portlet_tl"></div>
    </div>
    <div class="gr_portlet_l" style="display: block;">
    <ul class="gr_portlet_r" style="display: block;">
    
    
<!-- 올리기 -->
<div class="detail_up_wrap">
	<jsp:include page="/jsp/content/upload/select_upload_action.jsp"></jsp:include>    
</div>
<!-- 올리기 //-->

    
<!-- 목록시작 -->
<div class="replay">
    <ul>
    <li class="dash_line">
        <div class="det_title">
            <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
            <div class="noti_in">
                <span class="t_name">Minashin</span><span class="arr">▶</span><span class="ico_division_s">마케팅/디자인팀</span><span class="t_date"> 2011.10.13</span>
                <div>회의록 내용 중 빠진 부분이나 수정할 사항이 있으시면 참석자 누구든 수정해주시기 바랍니다^^</div>
            </div>
        </div>
    </li>
    <li>
        <div class="det_title">
            <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
            <div class="noti_in">
                <span class="t_name">Minashin</span><span class="arr">▶</span><span class="ico_division_s">마케팅/디자인팀</span><span class="t_date"> 2011.10.13</span>
                <div>회의록 내용 중 빠진 부분이나 수정할 사항이 있으시면 참석자 누구든 수정해주시기 바랍니다^^</div>
            </div>
        </div>
    </li>
    <li class="end">
        <div class="det_title">
            <div class="noti_pic"><img src="images/pic_size_29.jpg" alt="신민아" align="bottom"/></div>
            <div class="noti_in">
                <span class="t_name">Minashin</span><span class="arr">▶</span><span class="ico_division_s">마케팅/디자인팀</span><span class="t_date"> 2011.10.13</span>
                <div>회의록 내용 중 빠진 부분이나 수정할 사항이 있으시면 참석자 누구든 수정해주시기 바랍니다^^</div>
            </div>
        </div>
    </li>
    </ul>
</div>
<!-- 목록 끝 //-->

    </ul>
    </div>
    <div class="gr_portlet_b" style="display: block;"></div>
    </div>
  <!-- 댓글 목록 //-->
  
<!-- 댓글 영역 //-->

<!-- 목록 버튼 -->
<div class="" style=" text-align:center">
<div class="btn_gray" >
    <a href=""> <span class="Btn01Start"></span> <span
        class="Btn01Center">목 록</span> <span class="Btn01End"></span>
    </a>
</div>
</div>
<!-- 목록 버튼//-->
