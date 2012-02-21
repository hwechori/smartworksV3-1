
<!-- Name 			: pwork_space.jsp						 -->
<!-- Description	: 프로세스업무 인스턴스 공간을 표시하는 페이지    -->
<!-- Author			: Maninsoft, Inc.						 -->
<!-- Created Date	: 2011.9.								 -->

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

	session.setAttribute("cid", cid);
	session.removeAttribute("wid");
	session.setAttribute("workInstance", instance);
	
%>
<fmt:setLocale value="<%=cUser.getLocale() %>" scope="request" />
<fmt:setBundle basename="resource.smartworksMessage" scope="request" />
<!-- 컨텐츠 레이아웃-->
<div class="section_portlet js_pwork_space_page" workId="<%=workId%>" instId="<%=instId%>" taskInstId=<%=taskInstId %>>
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
	                    	<span class="title_picico float_left mr7"><%=instance.getSubject()%></span>
	                    	<span class="ico_pworks t_date"> <%=work.getFullpathName() %></span> 
	                    </div>
	                </div>
		                    
	            <!-- 우측 버튼-->
	            <div class="txt_btn">
	                <div class="po_right t_s11"><a class="js_copy_address" href=""><fmt:message key="common.button.copy_url"/></a></div>
	            </div>
	            
				<!-- 전자결재, 업무전달 버튼들 -->
				<div class="txt_btn image_posi">
	                <div class="po_right ico_print">
	                	<a href="" title="<fmt:message key='common.button.print'/>"></a>
	                </div>
	                <div class="po_right ico_mail">
	                	<a href="" title="<fmt:message key='common.button.email'/>"></a>
	                </div>
	                <div class="po_right"><a href="" class="js_view_instance_diagram"><fmt:message key="common.button.view_instance_diagram"/>▼</a></div>
	                <div class="po_right" style="display:none"><a href="" class="js_close_instance_diagram"><fmt:message key="common.button.close_instance_diagram"/>▼</a></div>
	            </div>
	            <!-- 우측 버튼 -->
		                    
               	<div class="solid_line clear"></div>
			</div>
			<!-- 타이틀 -->

			<div class="define_space js_process_instance_viewer" style="display:none; height:512px;"></div>
					 		            
			<!-- 프로세스 영역 -->
			<div class="define_space" style="height:59px">
			
				<!-- 방향 Prev -->
	        		<a href="" class="js_instance_tasks_left" style="display:block"><div class="proc_btn_prev float_left"></div></a>
	        	<!-- 방향 Prev //-->
	        	
				<div class="proce_section">
			        <div class="proc_start_compl float_left"> 시작 </div>
			        <div class="proc_arr_next float_left"></div>
			        
			        <!-- 태스크 시작-->
			        <div class="proce_space js_instance_tasks_holder">			        
						<div class="js_instance_tasks">
							<ul><li class="proc_task not_yet js_instance_task_placeholder" style="display:none"></li></ul>
							
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
						            <li class="<%=statusClass %> js_instance_task">
						                <a <%if(isSelectable){ %> href="" class="js_select_task_instance" <%} %> formId="<%=task.getFormId() %>" taskInstId="<%=task.getId()%>" formMode=<%=formMode %>>
							                    <!-- task 정보 -->
							                    <img src="<%=task.getOwner().getMinPicture()%>" class="noti_pic profile_size_s">
							                    <div class="noti_in_s">
								                    <%=i+1%>) <%=task.getName() %>
								                    <div class="t_date"><%=task.getLastModifiedDate().toLocalString() %></div>
							                    </div>
							                    <!-- task 정보 //-->
						                </a>
						            </li>
				            		<!-- 태스크 //--> 
			            			<%
			            			if(i<taskHistories.length-1){
			            			%>
							            <!--화살표-->
							            <li class="proc_arr_next float_left"></li>
							            <!--화살표-->
							        <%
							        }
							        %>
			            	<%
				        		}
				        	}
			            	%>
			            	</ul>
			        	</div>
			        </div>
			        <!-- 태스크 시작//-->
			        
				</div>
				
				<!-- 방향 Next -->
	    		<a href="" class="js_instance_tasks_right" style="display:block"><div class="proc_btn_next float_right"></div></a>
	    		<!-- 방향 Next //-->
			</div>
			<!--프로세스 영역//-->
				
			<!-- 상세보기 컨텐츠 -->
			<div class="contents_space">
				<div class="up_point posit_default"></div>
				<div class="form_wrap up up_padding form_read js_form_content">
		       </div>
			</div>
	
			<!-- 버튼 영역 -->
			<div class="glo_btn_space">
			
				<div class="txt_btn info_repl">
				    <div class="po_left"><fmt:message key="common.title.last_modification"/> :  
				    	<a href=""><img src="<%=instance.getLastModifier().getMinPicture() %>" class="profile_size_s" /> <%=instance.getLastModifier().getLongName() %></a>
				    	<span class="t_date"> <%= instance.getLastModifiedDate().toLocalString() %> </span>
				    </div>
				</div>     

				<!-- 수정, 삭제버튼 -->
			    <div class="float_right">
					<!--  실행시 표시되는 프로그래스아이콘을 표시할 공간 -->
					<div class="form_space js_progress_span" ></div>
					
					<!-- 실행시 데이터 유효성 검사이상시 에러메시지를 표시할 공간 -->
					<span class="form_space sw_error_message js_space_error_message" style="text-align:right; color: red"></span>

					<span class="btn_gray space_l5 js_btn_complete" style="display:none">
			        	<a href="" class="js_perform_task_instance">
				            <span class="Btn01Start"></span>
				            <span class="Btn01Center"><fmt:message key="common.button.complete"/></span>
				            <span class="Btn01End"></span>
				    	</a>
			   		</span>
					<span class="btn_gray space_l5 js_btn_return" style="display:none">
			        	<a href="" class="js_return_task_instance">
				            <span class="Btn01Start"></span>
				            <span class="Btn01Center"><fmt:message key="common.button.return"/></span>
				            <span class="Btn01End"></span>
				    	</a>
			   		</span>
					<span class="btn_gray space_l5 js_btn_reassign" style="display:none">
			        	<a href="" class="js_reassign_task_instance">
				            <span class="Btn01Start"></span>
				            <span class="Btn01Center"><fmt:message key="common.button.reassign"/></span>
				            <span class="Btn01End"></span>
				    	</a>
			   		</span>
					<span class="btn_gray space_l5 js_btn_temp_save" style="display:none">
			        	<a href="" class="js_temp_save_task_instance">
				            <span class="Btn01Start"></span>
				            <span class="Btn01Center"><fmt:message key="common.button.temp_save"/></span>
				            <span class="Btn01End"></span>
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
		var formContent = $('div.js_form_content');
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
	
	var pworkSpace = $('.js_pwork_space_page');
	var taskInstId = pworkSpace.attr('taskInstId');
	var instanceTasksHolder = pworkSpace.find(".js_instance_tasks_holder");
	var instanceTasks = instanceTasksHolder.find(".js_instance_tasks");
	var placeHolderTask = instanceTasks.find('.js_instance_task_placeholder').hide();
	var left = instanceTasks.position().left;
	var width = instanceTasks.width();
	var remainingWidth = width+left;

	var tasksRight = instanceTasksHolder.width();
	var tasks = instanceTasks.find(".js_instance_task");
	var selectedTask = $(tasks[0]);
	if(isEmpty(taskInstId)){
		for(var i=0; i<tasks.length; i++){
			var task = $(tasks[i]);
			if(task.position().left+task.width()>tasksRight)
				break;
		}
		if(tasks.length>0 && i<tasks.length && i>=0){
			var task = $(tasks[i]);
			placeHolderTask.remove().width(task.width()).show().insertBefore(task);
		}
	}else{
		for(var i=0; i<tasks.length; i++){
			var task = $(tasks[i]).find('a');
			if(task.attr('taskInstId') === taskInstId)
				break;
		}
		var selectedIndex = i;
		if(selectedIndex<tasks.length)
			selectedTask = $(tasks[selectedIndex]);
		if(selectedIndex<tasks.length && selectedTask.position().left+selectedTask.width()>tasksRight){
			left = tasksRight - selectedTask.position().left+selectedTask.width();
			for(var j=0; j<tasks.length; j++){
				var task = $(tasks[j]);
				if(task.position().left+left>=0){
					left=-task.position().left;
					tasksRight = taskRight + left;
					break;
				}
			}
			for(var k=0; k<tasks.length; k++){
				var task = $(tasks[k]);
				if(task.position().left+task.width()+left>tasksRight)
					break;
			}
			if(tasks.length>0 && k<tasks.length && k>=0){
				var task = $(tasks[k]);
				placeHolderTask.remove().width(task.width()).show().insertBefore(task);
			}
			instanceTasks.css({"left": left + "px"});
		}
	}

	var instanceLeft = pworkSpace.find('.js_instance_tasks_left');	
	var instanceRight = pworkSpace.find('.js_instance_tasks_right');	
	if(left<0)
		instanceLeft.show();
	else
		instanceLeft.hide();
	remainingWidth = instanceTasks.width()+left;
	if(remainingWidth <= instanceTasksHolder.width())
		instanceRight.hide();
	else
		instanceRight.show();
	
	if(!isEmpty(selectedTask)) clickOnTask(selectedTask.find('a'));
		
</script>

<jsp:include page="/jsp/content/work/space/space_instance_list.jsp">
	<jsp:param value="<%=work.getId() %>" name="workId"/>
	<jsp:param value="<%=instId %>" name="instId"/>
</jsp:include>	
