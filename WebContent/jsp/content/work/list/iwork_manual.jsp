<%@page import="net.smartworks.model.instance.WorkInstance"%>
<%@page import="net.smartworks.util.LocalDate"%>
<%@page import="net.smartworks.model.instance.CommentInstance"%>
<%@page import="net.smartworks.model.instance.MemoInstance"%>
<%@page import="net.smartworks.model.community.User"%>
<%@page import="net.smartworks.model.security.EditPolicy"%>
<%@page import="net.smartworks.model.security.WritePolicy"%>
<%@page import="net.smartworks.model.security.AccessPolicy"%>
<%@page import="net.smartworks.model.work.InformationWork"%>
<%@page import="net.smartworks.model.work.SmartWork"%>
<%@page import="net.smartworks.model.work.Work"%>
<%@page import="net.smartworks.util.SmartUtil"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="net.smartworks.service.ISmartWorks"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();

	InformationWork work = (InformationWork)session.getAttribute("smartWork");
	String workId = work.getId();
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />


<div class="contents_space js_iwork_manual_page js_sub_instance_list" workId="<%=work.getId()%>">
	<div class="border">
		
		<!-- 업무 정의 영역 -->
		<div class=""><%if(!SmartUtil.isBlankObject(work.getDesc())) {%><%=work.getDesc()%> <%}else{ %><fmt:message key="common.message.no_work_desc" /><%}%></div>
		<!-- 업무 정의 영역 //-->
		
		<!-- 업무설명 영역 -->
		<div class="det_contents">
			<table>
				<colgroup>
					<col class="item">
					<col class="field">
				</colgroup>
				<tbody>
					<tr>
						<%
						if(work.getForm() != null){
							String desc = work.getForm().getDescription();
						%>
							<td><img src="<%=work.getForm().getOrgImage()%>" width="349" height="289" /></td>
							<td class ="dline_left_gray pl10"><%if(!SmartUtil.isBlankObject(desc)){%><%=desc%><%}else{ %><fmt:message key="common.message.no_form_desc"/><%} %></td>
						<%
						}
						%>
					</tr>
				</tbody>
			</table>
		</div>
	
		<!-- 업무 설명 영역 //-->
	
	   <!-- 댓글 -->
	   <div class="reply_point pos_reply"></div>
	   <div class="reply_section">  
	        <div class="list_reply">
	            <ul class="js_comment_list">
	            	<li class="js_comment_instance" style="display:none">
						<div class="noti_pic">
							<a class="js_pop_user_info" href="<%=cUser.getSpaceController() %>?cid=<%=cUser.getSpaceContextId()%>" userId="<%=cUser.getId()%>" profile="<%=cUser.getOrgPicture()%>" userDetail="<%=SmartUtil.getUserDetailInfo(cUser.getUserInfo())%>">
								<img src="<%=cUser.getMinPicture()%>" class="profile_size_c"/>
							</a>
						</div>
						<div class="noti_in">
							<a href="<%=cUser.getSpaceController() %>?cid=<%=cUser.getSpaceContextId()%>">
								<span class="t_name"><%=cUser.getLongName()%></span>
							</a>
							<span class="t_date"><%=(new LocalDate()).toLocalString()%></span>
							<div class="js_comment_content"></div>
						</div>
	            	</li>
	            	<%
	            	if(work.getCommentCount()>WorkInstance.DEFAULT_SUB_INSTANCE_FETCH_COUNT){
	            	%>
		            	<li>
		            		<img class="repl_tinfo">
	            			<a href="comment_list_in_manual.sw?workId=<%=work.getId()%>&fetchCount=<%=WorkInstance.FETCH_ALL_SUB_INSTANCE %>" class="js_show_all_comments">
	            				<span><strong><fmt:message key="common.title.show_all_comments"><fmt:param><%=work.getCommentCount() %></fmt:param><</fmt:message></strong></span>
	            			</a>
		            	</li>
					<%
	            	}
					if(work.getCommentCount()>0) {
					%>
						<jsp:include page="/jsp/content/work/list/comment_list_in_manual.jsp">
							<jsp:param value="<%=work.getId()%>" name="workId"/>
							<jsp:param value="<%=WorkInstance.DEFAULT_SUB_INSTANCE_FETCH_COUNT%>" name="fetchCount"/>
						</jsp:include>
					<%
					}
					%>
				</ul>
	        </div>
	        
	        <div class="reply_input js_return_on_comment">
				<div class="noti_pic">
					<img src="<%=cUser.getMinPicture()%>" class="profile_size_c"/>
				</div>
				<div class="noti_in">
					<textarea style="width:95%" class="up_textarea" rows="2" name="txtaCommentContent" placeholder="<fmt:message key='work.message.leave_question'/>"></textarea>
				</div>
	        </div>
	    
	    </div>
	    <!-- 댓글 //-->
	    
	    <!-- 라인 -->
		<div class="solid_line_s t10 mb5"></div>
		
		<!-- 우측 버튼 -->
		<div class="txt_btn txt_btn_height25">
	
			<!-- 수정하기 -->
			<div class="fr ml5">
				<%
				if (cUser.getUserLevel() == User.USER_LEVEL_AMINISTRATOR) {
				%>
					<span class="btn_gray"> 
						<span class="txt_btn_start"></span> 
						<span class="txt_btn_center"><fmt:message key='common.button.modify' /> </span>
						<span class="txt_btn_end"></span>
					</span>
				<%
				}
				%>
			</div>
			<!-- 수정하기 //-->
	
			<!-- 최종수정자 -->
			<div class="po_left">
				<img class="pho_user profile_size_s" title="<fmt:message key="common.title.last_modifier" />" src="<%=work.getLastModifier().getMinPicture()%>"> 
				<span class="t_name"><%=work.getLastModifier().getLongName()%></span>
				<span class="t_date"><%=work.getLastModifiedDate().toLocalString()%></span>
			</div>
			<!-- 최종수정자 //-->
	
			<span class="po_left">
				<%
				if (work.getManualFileName() != null) {
				%>
					<a href="" class="icon_btn_video mr2" title="<fmt:message key='work.title.manual_file'/>"></a> 
				<%
				}
				if (work.getHelpUrl() != null) {
				%> 
					<a href="<%=work.getHelpUrl()%>" class="icon_btn_webex" title="<fmt:message key='work.title.help_url'/>" target="_blank"></a>
				<%
				}
				%>
			</span>
	
			<!-- 우측 권한 아이콘-->
			<span> 
				<%
				switch (work.getAccessPolicy().getLevel()) {
				case AccessPolicy.LEVEL_PUBLIC:
				%>
					<div class="ch_right mt5"><fmt:message key="common.security.access.public" /></div>
				<%
					break;
				case AccessPolicy.LEVEL_PRIVATE:
				%>
					<div class="ch_right mt5"><fmt:message key="common.security.access.private" /></div> 
				<%
					break;
				case AccessPolicy.LEVEL_CUSTOM:
				%>
					<div class="ch_right mt5"><fmt:message key="common.security.access.custom" /></div> 
				<%
					break;
				}
				%>
					
				<div class="fr mt5"><span class="icon_body_read" title="<fmt:message key='common.security.title.access'/>"></span></div>
				<%
				switch (work.getWritePolicy().getLevel()) {
				case WritePolicy.LEVEL_PUBLIC:
				%>
					<div class="ch_right  mt5"><fmt:message key="common.security.write.public" /></div> 
				<%
					break;
				case WritePolicy.LEVEL_CUSTOM:
				%>
					<div class="ch_right  mt5"><fmt:message key="common.security.write.custom" /></div> 
				<%
					break;
				}
				%>
					
				<div class="fr mt5"><span class="icon_body_register"  title="<fmt:message key='common.security.title.write'/>"></span></div> 
				<%
				switch (work.getEditPolicy().getLevel()) {
				case EditPolicy.LEVEL_WIKI:
				 %>
					<div class="ch_right mt5"><fmt:message key="common.security.edit.wiki" /></div> 
				<%
					break;
				case EditPolicy.LEVEL_BLOG:
				%>
					<div class="ch_right mt5"><fmt:message key="common.security.edit.blog" /></div> 
				<%
				 	break;
				 }
				 %>
				<div class="fr  mt5"><span class="icon_body_modify"  title="<fmt:message key='common.security.title.edit'/>"></span></div> 
			</span>
			<!-- 우측 권한 아이콘-->
		</div>
		<!-- 우측 버튼 //-->
	</div>

	
</div>
