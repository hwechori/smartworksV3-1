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
	CommentInstance[] comments = smartWorks.getRecentCommentsInWorkManual(workId, 3);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />


<div class="contents_space">

	<!-- 업무 정의 영역 -->
	<div class=""><%if(!SmartUtil.isBlankObject(work.getDesc())) {%><%=work.getDesc()%> <%}else{ %><fmt:message key="common.message.no_work_desc" /><%}%></div>
	<!-- 업무 정의 영역 //-->

	<div class="border">

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
							<td><%if(!SmartUtil.isBlankObject(desc)){%><%=desc%><%}else{ %><fmt:message key="common.message.no_form_desc"/><%} %></td>
						<%
						}
						%>
					</tr>
				</tbody>
			</table>
		</div>
	
		<!-- 라인 -->
		<div class="solid_line_s"></div>
		<!-- 업무 설명 영역 //-->
	
	   <!-- 댓글 -->
	   <div class="replay_point posit_default"></div>
	   <div class="replay_section">  
	        <div class="list_replay">
	            <ul>
		            <li><img class="repl_tinfo"><a href=""><strong>7</strong>개의 댓글 모두 보기</a></li>
					<%
					if (comments != null) {
						for (CommentInstance comment : comments) {
							User commentor = comment.getCommentor();
					%>
							<li>
								<div class="noti_pic">
									<img src="<%=commentor.getMinPicture()%>" align="bottom" />
								</div>
								<div class="noti_in">
									<span class="t_name"><%=commentor.getLongName()%></span><span
										class="t_date"><%=comment.getLastModifiedDate().toLocalString()%></span>
									<div><%=comment.getComment()%></div>
								</div>
							</li>
					<%
						}
					}
					%>
				</ul>
	        </div>
	        
	        <div class="replay_input">
				<textarea class="up_textarea" rows="5" cols="" name="txtaEventContent"
					placeholder="<fmt:message key='work.message.leave_question'/>"><fmt:message key='work.message.leave_question' />
				</textarea>
	        </div>
	    
	    </div>
	    <!-- 댓글 //-->
	</div>

	<!-- 우측 버튼 -->
	<div class="txt_btn">

		<!-- 수정하기 -->
		<div class="float_right space_l5">
			<%
			if (cUser.getUserLevel() == User.USER_LEVEL_AMINISTRATOR) {
			%>
				<span class="btn_gray"> 
					<span class="Btn01Start"></span> 
					<span class="Btn01Center"><fmt:message key='common.button.modify' /> </span>
					<span class="Btn01End"></span>
				</span>
			<%
			}
			%>
		</div>
		<!-- 수정하기 //-->

		<!-- 최종수정자 -->
		<div class="float_right">
			<img class="pho_user" title="<fmt:message key="common.title.last_modifier" />" src="<%=work.getLastModifier().getMinPicture()%>"> 
			<span class="t_name"><%=work.getLastModifier().getLongName()%></span>
			<span class="t_date"><%=work.getLastModifiedDate().toLocalString()%></span>
		</div>
		<!-- 최종수정자 //-->

		<span class="float_right">
			<%
			if (work.getManualFileName() != null) {
			%>
				<a href="" class="bu_video space_r2" title="<fmt:message key='work.title.manual_file'/>"></a> 
			<%
			}
			if (work.getHelpUrl() != null) {
			%> 
				<a href="<%=work.getHelpUrl()%>" class="bu_webex" title="<fmt:message key='work.title.help_url'/>" target="_blank"></a>
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
				<div class="ch_right"><fmt:message key="common.security.access.public" /></div>
			<%
				break;
			case AccessPolicy.LEVEL_PRIVATE:
			%>
				<div class="ch_right"><fmt:message key="common.security.access.private" /></div> 
			<%
				break;
			case AccessPolicy.LEVEL_CUSTOM:
			%>
				<div class="ch_right"><fmt:message key="common.security.access.custom" /></div> 
			<%
				break;
			}
			%>
				
			<div class="float_right"><span class="bu_read" title="<fmt:message key='common.security.title.access'/>"></span></div>
			<%
			switch (work.getWritePolicy().getLevel()) {
			case WritePolicy.LEVEL_PUBLIC:
			%>
				<div class="ch_right"><fmt:message key="common.security.write.public" /></div> 
			<%
				break;
			case WritePolicy.LEVEL_CUSTOM:
			%>
				<div class="ch_right"><fmt:message key="common.security.write.custom" /></div> 
			<%
				break;
			}
			%>
				
			<div class="float_right"><span class="bu_regit"  title="<fmt:message key='common.security.title.write'/>"></span></div> 
			<%
			switch (work.getEditPolicy().getLevel()) {
			case EditPolicy.LEVEL_WIKI:
			 %>
				<div class="ch_right"><fmt:message key="common.security.edit.wiki" /></div> 
			<%
				break;
			case EditPolicy.LEVEL_BLOG:
			%>
				<div class="ch_right"><fmt:message key="common.security.edit.blog" /></div> 
			<%
			 	break;
			 }
			 %>
			<div class="float_right"><span class="bu_modfy"  title="<fmt:message key='common.security.title.edit'/>"></span></div> 
		</span>
		<!-- 우측 권한 아이콘-->
	</div>
	<!-- 우측 버튼 //-->
</div>
