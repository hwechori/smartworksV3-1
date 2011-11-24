<%@page import="net.smartworks.model.work.info.SmartFormInfo"%>
<%@page import="net.smartworks.model.community.info.UserInfo"%>
<%@page import="net.smartworks.model.work.info.SmartTaskInfo"%>
<%@page import="net.smartworks.model.work.SmartForm"%>
<%@page import="net.smartworks.model.work.SmartTask"%>
<%@page import="net.smartworks.model.work.SmartDiagram"%>
<%@page import="net.smartworks.model.work.ProcessWork"%>
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
	User cUser = SmartUtil.getCurrentUser(request, response);
	ProcessWork work = (ProcessWork) smartWorks.getWorkById(companyId, cUser.getId(), workId);
	CommentInstance[] comments = smartWorks.getRecentCommentsInWorkManual(companyId, workId, 3);
	SmartDiagram diagram = work.getDiagram();
	SmartTaskInfo[] tasks = null;
	if (diagram != null)
		tasks = diagram.getTasks();
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />

<!-- 업무 설명 보기 -->
<div class="contents_space">
	<div class="border">
	
	<!-- 프로세스 영역 -->
        <div class="proce_section">
        
        <!-- 방향 Prev -->
        <div class="float_left"><a href=""><img class="proc_btn_prev"></a></div>
	
	<!--  태스크 시작 -->
	<div class="proce_space">

		<%
			if (tasks != null) {
				for (SmartTaskInfo task : tasks) {
					UserInfo assignedUser = task.getAssignedUser();
					String assigningName = task.getAssigningName();
		%>
		<!-- 태스크 -->

		<div class="proc_task_yet float_left padding_r10">
			<a class="js_select_task_manual" href="" taskId="<%=task.getId() %>"> <span class="pstart"></span> <span class="pcenter">
					<!-- task 정보 -->
					<div class="float_left">
						<img align="bottom"
							src="<%if (assignedUser != null) {%><%=assignedUser.getMidPicture()%><%} else {%><%=User.getMidNoPicture()%><%}%>">
					</div>
					<div class="noti_in">
						<span><%=task.getName()%></span>
					</div> <!-- task 정보 //--> </span> <span class="pend"></span> </a>
		</div>
		
		 <!--화살표-->
        <div class="proc_arr_next float_left padding_r10"></div>
        <!--화살표-->
        
		<!-- 태스크 //-->
		<%
			}
			}
		%>

	</div>
	<!--  태스크 시작// -->
	
	<!-- 방향 Next -->
    <div class="float_right"><a href=""><img class="proc_btn_next"></a></div>
	
</div>
<!--프로세스 영역//-->

<!-- 업무설명 영역 -->
	<%
	if(tasks!=null){
		for(int i=0; i<tasks.length; i++){
			
			SmartFormInfo form = tasks[i].getForm();
			if(form!=null){
				%>
<div class="js_task_manual padding_t5" id="<%=tasks[i].getId() %>" <%if(i!=0){ %>style="display:none"<%} %>>
	<div class="up_point posit_default"></div>
	<div class="form_wrap up up_padding">
		<div class="area">
			<!-- 업무설명 -->
			<div class="det_contents">
				<table>
					<colgroup>
						<col width="50%">
						<col width="50%">
					</colgroup>
					<tbody>
						<tr>
							<td><img src="<%=form.getOrgImage() %>" width="349"
								height="289" /></td>
							<td>Count=<%=i%><%=form.getDescription() %></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- 업무 설명 //-->
		</div>
	</div>
</div>
	<%
	}
	}
	}
	%>
<!-- 업무설명 영역 //-->
<!-- 댓글 -->
<div class="replay_point posit_default"></div>
<div class="replay_section">

	<div class="list_replay">
		<ul>
			<li class="repl_tinfo"><a href=""><strong>7</strong>개의 댓글 모두
					보기</a>
			</li>
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
			placeholder="<fmt:message key='work.message.leave_question'/>">
			<fmt:message key='work.message.leave_question' />
		</textarea>
	</div>
	
	</div>
	<!-- 댓글 //-->
	

</div>
</div>
<!-- 업무 설명 보기 -->

