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
	String companyId = (String) session.getAttribute("companyId");
	String userId = (String) session.getAttribute("userId");

	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	String cid = request.getParameter("cid");
	String wid = request.getParameter("wid");

	String workId = SmartUtil.getSpaceIdFromContentContext(cid);
	User cUser = SmartUtil.getCurrentUser();
	InformationWork work = (InformationWork) smartWorks.getWorkById(companyId, cUser.getId(), workId);
	CommentInstance[] comments = smartWorks.getRecentCommentsInWorkManual(companyId, workId, 3);
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />


<div class="contents_space">
	<!-- 업무설명 영역 -->
	<div class="det_contents">
		<table>
			<colgroup>
				<col class="item">
				<col class="field">
			</colgroup>
			<tbody>
				<tr>
					<td><img src="<%=work.getForm().getOrgImage()%>" width="349"
						height="289" />
					</td>
					<td><%=work.getForm().getDescription()%></td>
				</tr>
			</tbody>
		</table>
	</div>

	<!-- 라인 -->
	<div class="solid_line_s"></div>
	<!-- 업무 설명 영역 //-->

	<!-- 댓글 -->
	<div class="list_replay">
		<ul>
			<%
				if (comments != null) {
					for (CommentInstance comment : comments) {
						User commentor = comment.getCommentor();
			%>
			<li>
				<div class="noti_pic">
					<img src="<%=commentor.getMidPicture()%>" align="bottom" />
				</div>
				<div class="noti_in">
					<span class="t_name"><%=commentor.getLongName()%></span><<span
						class="t_date"><%=comment.getLastModifiedDate()%></span>
					<div><%=comment.getComment()%></div>
				</div></li>
			<%
				}
				}
			%>
		</ul>
	</div>

	<div class="list_replay">
		<textarea class="up_textarea" rows="5" cols="" name="txtaEventContent"
			placeholder="<fmt:message key='work.message.leave_question'/>">
			<fmt:message key='work.message.leave_question' />
		</textarea>
	</div>

	<!-- 댓글 //-->

	<!-- 라인 -->
	<div class="solid_line_s"></div>

</div>
