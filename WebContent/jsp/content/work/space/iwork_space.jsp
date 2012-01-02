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
	String cid = request.getParameter("cid");
	String wid = request.getParameter("wid");
	String workId = request.getParameter("workId");
	String instanceId = request.getParameter("instanceId");
	User cUser = SmartUtil.getCurrentUser();

	InformationWorkInstance instance = (InformationWorkInstance)smartWorks.getWorkInstanceById(instanceId);
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
                <div class="po_right"><a class="js_copy_address" href=""><fmt:message key="common.button.copy_url"/></a></div>
            </div>
            
            <div class="txt_btn">
                <div class="po_right"><a href=""><img src="images/btn_print.gif" alt="프린트" /></a></div>
                <div class="po_right"><a href=""><img src="images/btn_mail.gif" alt="메일" /></a></div>
                <div class="po_right"><a href=""><img src="images/btn_approvep.gif" alt="전자결재" /></a></div>
                <div class="po_right"><a href=""><img src="images/btn_referw.gif" alt="참조자 지정" /></a></div>
            </div>
            <!-- 우측 버튼 -->
                    
                	<div class="solid_line"></div>
                </div>
            <!-- 타이틀 -->
            
<!-- 상세보기 컨텐츠 -->
<div class="contents_space">
            
       <!-- 업무 내용 --> 
       <div class="list_contents js_form_content">      
       </div>
       <!-- 업무 내용 //--> 
</div>

<!-- 버튼 영역 -->
<div class="glo_btn_space">

<div class="txt_btn info_repl">
    <%if(numberOfRelatedWorks > 0){ %><div class="po_left"><a href="">참조업무 <span class="t_up_num">[<%=numberOfRelatedWorks %>]</span></a></div><%} %>
    <%if(numberOfHistories > 0){ %><div class="po_left"><a href="">수정이력 <span class="t_up_num">[<%=numberOfHistories %>]</span></a></div><%} %>
    <div class="po_left">최종수정: <a href=""><img src="<%=instance.getLastModifier().getMinPicture() %>" alt="size24" width="24" height="24" /> <%=instance.getLastModifier().getLongName() %></a> <span class="t_date"> <%= instance.getLastModifiedDate().toLocalString() %> </span></div>
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
    <div id="upload">
    <div class="up_works"><a class="" href="">업무</a></div>
    <div class="up_file"><a class="" href="">파일</a></div>
    <div class="up_memo"><a class="" href="">메모</a></div>
    </div>
      
    <div class="up_wrap">
    <div class="up_point posit_works"></div>
    <!-- 폼- 디폴트-->
        <div class="start_worksinput">
        <div class="input_size srch">
            <input class="js_auto_complete" type="text" href="work_name.sw"
                placeholder="<fmt:message key='common.upload.message.work'/>">
            <div class="srch_ico js_srch_x"></div>
    
        </div>
    
        <div class="btn_gray btn_right" id="all_work_btn" style="display: none">
            <a href=""> <span class="Btn01Start"></span> <span
                class="Btn01Center"><fmt:message
                        key="common.upload.button.all_works" /> </span> <span class="Btn01End"></span>
            </a>
        </div>
    
    
        <!--검색 자동완성어 리스트-->
        <div class="srch_list" id="upload_work_list" style="display: none">
        </div>
        <!--검색 자동완성어 리스트//-->
        
    </div>
    <!-- 폼- 디폴트//-->   
         
    </div>
    
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
