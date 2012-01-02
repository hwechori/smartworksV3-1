<%@page import="net.smartworks.model.mail.MailFolder"%>
<%@page import="net.smartworks.model.instance.MailInstance"%>
<%@page import="net.smartworks.model.work.MailWork"%>
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
	String folderId = request.getParameter("folderId");
	String msgId = request.getParameter("msgId");
	User cUser = SmartUtil.getCurrentUser();

	MailInstance instance = smartWorks.getMailInstanceById(folderId, msgId);	
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
                            <span class="t_date"><%=instance.getCreatedDate().toLocalString() %></span>
<%--                             <div class=""><span class="ico_iworks t_date"><%=work.getFullpathName() %></span> <span class="title_picico"><%=instance.getSubject()%></span></div>
 --%>                            <div class=""><span class="ico_iworks t_date">받은 편지함</span> <span class="title_picico"><%=instance.getSubject()%></span></div>
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
		  <div id='msgText'>
		  <iframe id='msgTextIframe' align='center' frameborder='0' height='100%' width='100%' style='font-size: 11px;font: arial, sans-serif;' scrolling='no' src='webmail/dumpPart.service?partid='<%=instance.getPartId()%>' width='100%' border='0'/>
		  </div>
       </div>
       <!-- 업무 내용 //--> 
</div>

</ul>
</div>
<div class="portlet_b" style="display: block;"></div>
</div> 
<!-- 컨텐츠 레이아웃//-->
