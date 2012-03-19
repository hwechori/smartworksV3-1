
<!-- Name 			: pwork_space.jsp						 -->
<!-- Description	: 프로세스업무 인스턴스 공간을 표시하는 페이지    -->
<!-- Author			: Maninsoft, Inc.						 -->
<!-- Created Date	: 2011.9.								 -->

<%@page import="net.smartworks.server.engine.common.util.CommonUtil"%>
<%@page import="net.smartworks.model.instance.Instance"%>
<%@page import="net.smartworks.model.instance.WorkInstance"%>
<%@page import="net.smartworks.util.SmartTest"%>
<%@page import="net.smartworks.model.work.ProcessWork"%>
<%@page import="net.smartworks.model.instance.ProcessWorkInstance"%>
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
	// 스마트웍스 서비스들을 사용하기위한 핸들러를 가져온다. 현재사용자 정보도 가져온다..
	ISmartWorks smartWorks = (ISmartWorks) request.getAttribute("smartWorks");
	User cUser = SmartUtil.getCurrentUser();
	
	String cid = request.getParameter("cid");
	String instId = SmartUtil.getSpaceIdFromContentContext(cid);
	String workId = request.getParameter("workId");
	String taskInstId = request.getParameter("taskInstId");
	
	ProcessWorkInstance instance = null;
	WorkInstance workInstance = (WorkInstance)session.getAttribute("workInstance");
	if(SmartUtil.isBlankObject(workInstance) || !workInstance.getId().equals(instId)) 
		instance = (ProcessWorkInstance)smartWorks.getWorkInstanceById(SmartWork.TYPE_PROCESS, workId, instId);
	else
		instance = (ProcessWorkInstance)workInstance;
	
	User owner = instance.getOwner();
	WorkSpace workSpace = instance.getWorkSpace();
	ProcessWork work = (ProcessWork)instance.getWork();
	workId = work.getId();
	
	TaskInstanceInfo[] taskHistories = instance.getTasks();
	TaskInstanceInfo selectedTask = (SmartUtil.isBlankObject(taskHistories)) ? null : taskHistories[0];
	if(!SmartUtil.isBlankObject(taskInstId)){
		for(TaskInstanceInfo taskInstance : taskHistories){
			if(taskInstance.getId().equals(taskInstId)){
				selectedTask = taskInstance;
				break;
			}
		}
	}
	session.setAttribute("cid", cid);
	session.removeAttribute("wid");
	session.setAttribute("workInstance", instance);
	
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />
<!-- 컨텐츠 레이아웃-->
<div class="section_portlet js_pwork_space_page" workId="<%=workId%>" instId="<%=instId%>" taskInstId=<%=CommonUtil.toNotNull(taskInstId) %>>
    <div class="portlet_t"><div class="portlet_tl"></div></div>
    <div class="portlet_l" style="display: block;">
	    <ul class="portlet_r" style="display: block;">		            
			<!-- 타이틀 -->
			<div class="body_titl_pic">		
	                <div class="noti_pic mr7 mb5"><img src="<%=instance.getOwner().getMidPicture() %>"  class="profile_size_m"/></div>
	                <div class="noti_in_bodytitle mb5">
	                    <span class="t_name"><%=instance.getOwner().getLongName()%></span>
	                    <span class="t_date"><%=instance.getCreatedDate().toLocalString()%></span>
	                    <div class="">
	                    	<span class="title_picico fl mr7"><%=instance.getSubject()%></span>
	                    	<span class="icon_pworks t_date"> <%=work.getFullpathName() %></span> 
	                    </div>
	                </div>
		                    
	            <!-- 우측 버튼-->
	            <div class="txt_btn">
	                <div class="fr t_s11"><a class="js_copy_address" href=""><fmt:message key="common.button.copy_url"/></a></div>
	            </div>
	            
				<!-- 전자결재, 업무전달 버튼들 -->
				<div class="txt_btn image_posi fr">
	                <div class="icon_print_w">
	                	<a href="" title="<fmt:message key='common.button.print'/>"></a>
	                </div>
	                <div class="icon_mail_w">
	                	<a href="" title="<fmt:message key='common.button.email'/>"></a>
	                </div>
	                <div><a href="" class="js_view_instance_diagram"><fmt:message key="common.button.view_instance_diagram"/>▼</a></div>
	                <div style="display:none"><a href="" class="js_close_instance_diagram"><fmt:message key="common.button.close_instance_diagram"/>▼</a></div>
	            </div>
	            <!-- 우측 버튼 -->
		                    
               	<div class="solid_line cb"></div>
			</div>
			<!-- 타이틀 -->
					 		            
			<!-- 프로세스 영역 -->
			<div class="define_space" style="height:59px; padding: 0 45px;">
			
				<!-- 방향 Prev -->
        		<a href="" class="js_instance_tasks_left"><div class="proc_btn_prev" style="display:block"></div></a>
	        	<!-- 방향 Prev //-->
	        	
				<div class="process_section js_instance_tasks_holder">
			        <div class="proc_start_compl fl js_task_start js_instance_task"><fmt:message key="process.task.start"/></div>
			        <div class="proc_arr_next fl js_instance_task_arrow"></div>
			        
			        <!-- 태스크 시작-->
			        <div class="process_space js_instance_tasks">			        
						<ul>
				        	<%
				        	if(!SmartUtil.isBlankObject(taskHistories)){	
				        		for(int i=0; i<taskHistories.length; i++){
				        			TaskInstanceInfo task = taskHistories[i];
				        			String statusClass = "proc_task not_yet";
				        			String formMode = (task.getAssignee().getId().equals(cUser.getId()) 
				        								&& ( 	task.getStatus()==TaskInstance.STATUS_RUNNING
				        									 || task.getStatus()==TaskInstance.STATUS_DELAYED_RUNNING) ) ? "edit" : "view";
				        			boolean isSelectable = ((task.getStatus()==TaskInstance.STATUS_RUNNING||task.getStatus()==TaskInstance.STATUS_DELAYED_RUNNING)
				        										&& !task.getAssignee().getId().equals(cUser.getId())) ? false : true;
				        			if(task.getStatus() == TaskInstance.STATUS_RETURNED)
				        				statusClass = "proc_task returned";
				        			else if(task.getStatus() == TaskInstance.STATUS_RUNNING)
				        				statusClass = "proc_task running";
				        			else if(task.getStatus() == TaskInstance.STATUS_DELAYED_RUNNING)
				        				statusClass = "proc_task delayed";
				        			else if(task.getStatus() == TaskInstance.STATUS_COMPLETED)
				        				statusClass = "proc_task completed";
				        			else
				        				statusClass = "proc_task not_yet";				        				
				        		
				        	%>
			            			<!-- 태스크 --> 
						            <li class="<%=statusClass %> js_instance_task <%if(isSelectable){%>js_select_task_instance<%} %>" formId="<%=task.getFormId() %>" taskInstId="<%=task.getId()%>" formMode="<%=formMode %>">
					                    <!-- task 정보 -->
					                    <img src="<%=task.getOwner().getMinPicture()%>" class="noti_pic profile_size_s">
					                    <div class="noti_in_s">
						                    <%=i+1%>) <%=task.getName() %>
						                    <div class="t_date"><%=task.getLastModifiedDate().toLocalString() %></div>
					                    </div>
					                    <!-- task 정보 //-->
						            </li>
				            		<!-- 태스크 //--> 
						            <!--화살표-->
						            <li class="proc_arr_next fl js_instance_task_arrow"></li>
						            <!--화살표-->
			            	<%
				        		}
				        	}
			            	%>
		            	</ul>
			        </div>
			        <!-- 태스크 시작//-->
           			<%
           			if(taskHistories[taskHistories.length-1].getStatus() == Instance.STATUS_COMPLETED){
           			%>
				        <div class="proc_start_compl fl js_task_stop js_instance_task"><fmt:message key="process.task.stop"/></div>
			        <%
			        }
			        %>			        
				</div>
				
				<!-- 방향 Next -->
	    		<a href="" class="js_instance_tasks_right"><div class="proc_btn_next"  style="display:block"></div></a>
	    		<!-- 방향 Next //-->
			</div>
			<!--프로세스 영역//-->
				
			<!-- 상세보기 컨텐츠 -->
			<div class="contents_space">
				<div class="up_point pos_default js_form_content_pointer"></div>
				<div class="form_wrap up up_padding form_read js_form_content"></div>
			</div>
	
			<!-- 버튼 영역 -->
			<div class="glo_btn_space">
			
				<div class="txt_btn task_information">
				    <div class="po_left"><fmt:message key="common.title.last_modification"/> :  
				    	<a href=""><img src="<%=instance.getLastModifier().getMinPicture() %>" class="profile_size_s" /> <%=instance.getLastModifier().getLongName() %></a>
				    	<span class="t_date"> <%= instance.getLastModifiedDate().toLocalString() %> </span>
				    </div>
				</div>     

				<!-- 수정, 삭제버튼 -->
			    <div class="fr">
					<!--  실행시 표시되는 프로그래스아이콘을 표시할 공간 -->
					<div class="form_space js_progress_span" ></div>
					
					<!-- 실행시 데이터 유효성 검사이상시 에러메시지를 표시할 공간 -->
					<span class="form_space sw_error_message js_space_error_message" style="text-align:right; color: red"></span>

					<span class="btn_gray ml5 js_btn_complete" style="display:none">
			        	<a href="" class="js_perform_task_instance">
				            <span class="txt_btn_start"></span>
				            <span class="txt_btn_center"><fmt:message key="common.button.complete"/></span>
				            <span class="txt_btn_end"></span>
				    	</a>
			   		</span>
					<span class="btn_gray ml5 js_btn_return" style="display:none">
			        	<a href="" class="js_return_task_instance">
				            <span class="txt_btn_start"></span>
				            <span class="txt_btn_center"><fmt:message key="common.button.return"/></span>
				            <span class="txt_btn_end"></span>
				    	</a>
			   		</span>
					<span class="btn_gray ml5 js_btn_reassign" style="display:none">
			        	<a href="" class="js_reassign_task_instance">
				            <span class="txt_btn_start"></span>
				            <span class="txt_btn_center"><fmt:message key="common.button.reassign"/></span>
				            <span class="txt_btn_end"></span>
				    	</a>
			   		</span>
					<span class="btn_gray ml5 js_btn_temp_save" style="display:none">
			        	<a href="" class="js_temp_save_task_instance">
				            <span class="txt_btn_start"></span>
				            <span class="txt_btn_center"><fmt:message key="common.button.temp_save"/></span>
				            <span class="txt_btn_end"></span>
				    	</a>
			   		</span>
				</div>
				<!-- 수정, 삭제버튼 //-->    					  
			</div>
			<!-- 버튼 영역 //-->     				
		</ul>
	</div>
	<div class="portlet_b" style="display: block;"></div>
</div> 
<!-- 컨텐츠 레이아웃//-->
<script type="text/javascript">

	function clickOnTask(input){
		var pworkSpace = input.parents('.js_pwork_space_page');
		var workId = pworkSpace.attr("workId");
		var formId = input.attr("formId");
		var formMode = input.attr("formMode");
		var instId = input.attr("taskInstId");
		var formContent = pworkSpace.find('div.js_form_content');
		var formContentPointer = pworkSpace.find('div.js_form_content_pointer');
		var selectedTask = input;
		pworkSpace.find('.js_instance_task').removeClass('selected');
		selectedTask.addClass('selected');
		formContentPointer.css({"left": selectedTask.position().left + selectedTask.outerWidth()/2 + "px"});
		new SmartWorks.GridLayout({
			target : formContent,
			mode : formMode,
			workId : workId,
			formId : formId,
			taskInstId : instId,
			onSuccess : function(){
				formContent.attr('taskInstId', instId);
				smartPop.closeProgress();																
			},
			onError : function(){
				smartPop.closeProgress();
				
			}
		});
		if(formMode==="edit"){
			pworkSpace.find('.js_btn_complete').show();
			pworkSpace.find('.js_btn_return').show();
			pworkSpace.find('.js_btn_reassign').show();
			pworkSpace.find('.js_btn_temp_save').show();
		}else{
			pworkSpace.find('.js_btn_complete').hide();
			pworkSpace.find('.js_btn_return').hide();
			pworkSpace.find('.js_btn_reassign').hide();
			pworkSpace.find('.js_btn_temp_save').hide();			
		}
	}
	
	var getTasksWidth = function(tasks, arrows){
		var width = 0;
		if(isEmpty(tasks) || isEmpty(arrows)) return width;
		
		for(var i=0; i<tasks.length; i++){
			width = width + $(tasks[i]).outerWidth();
		}
		for(var j=0; j<arrows.length; j++)
			width = width + $(arrows[j]).outerWidth() + 10;
		return width;
	};
	
	var pworkSpace = $('.js_pwork_space_page');
	var taskInstId = pworkSpace.attr('taskInstId');
	var instanceTasksHolder = pworkSpace.find(".js_instance_tasks_holder");
	var instanceTasks = instanceTasksHolder.find(".js_instance_tasks");
	var instanceLeft = pworkSpace.find('.js_instance_tasks_left');	
	var instanceRight = pworkSpace.find('.js_instance_tasks_right');

	var taskStart = instanceTasksHolder.find('.js_task_start');
	var taskStop = instanceTasksHolder.find('.js_task_stop');
	var tasks = instanceTasks.find(".js_instance_task");
	var arrows = instanceTasksHolder.find('.js_instance_task_arrow');
	var selectedTask = $(tasks[0]);
	var viewWidth = instanceTasksHolder.width();
	var tasksWidth = getTasksWidth(tasks, arrows);
	if(isEmpty(taskInstId)){
 		instanceLeft.hide();
		if(tasksWidth>viewWidth)
			instanceRight.show();
		else
			instanceRight.hide();
 	}else{
 		for(var i=0; i<tasks.length; i++){
			var task = $(tasks[i]).find('a');
			if(task.attr('taskInstId') === taskInstId)
				break;
		}
		var selectedIndex = i;
		if(selectedIndex<tasks.length)
			selectedTask = $(tasks[selectedIndex]);
		if(selectedIndex<tasks.length && selectedTask.position().top>=selectedTask.height()){
			var width = 0;
			for(var i=selectedIndex; i>=0; i--){
				width = width + $(tasks[i]).outerWidth() + $(arrows[i]).outerWidth() + 10;
				if(width>viewWidth) break;
			}
			if(i>-1){
				for(var j=0; j<i+1; j++){
					$(tasks[j]).hide();
					$(arrows[j]).hide();
				}
				taskStart.hide();
			}
		}
		if(selectedIndex == tasks.length-1)
			instanceRight.hide();
		else
			instanceRight.show();
			
 	}
	
	if(!isEmpty(selectedTask)) clickOnTask(selectedTask);
		
</script>

<jsp:include page="/jsp/content/work/space/space_instance_list.jsp">
	<jsp:param value="<%=work.getId() %>" name="workId"/>
	<jsp:param value="<%=instId %>" name="instId"/>
</jsp:include>	
