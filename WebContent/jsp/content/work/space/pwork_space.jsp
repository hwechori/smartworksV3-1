
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
	            <div class="">
	                <div class="noti_pic"><img src="<%=instance.getOwner().getMidPicture() %>"  class="profile_size_m"/></div>
	                <div class="noti_in_bodytitle">
	                    <span class="t_name"><%=instance.getOwner().getLongName()%></span>
	                    <span class="t_date"><%=instance.getCreatedDate().toLocalString()%></span>
	                    <div class="">
	                    	<span class="ico_pworks t_date"><%=work.getFullpathName() %></span> 
	                    	<span class="title_picico"><%=instance.getSubject()%></span>
	                    </div>
	                </div>
	            </div>
		                    
	            <!-- 우측 버튼-->
	            <div class="txt_btn">
	                <div class="po_right"><a class="js_copy_address" href=""><fmt:message key="common.button.copy_url"/></a></div>
	            </div>
	            
				<!-- 전자결재, 업무전달 버튼들 -->
				<div class="txt_btn">
	                <div class="po_right">
	                	<a href=""><img src="images/btn_print.gif" title="<fmt:message key='common.button.print'/>" /></a>
	                </div>
	                <div class="po_right">
	                	<a href=""><img src="images/btn_mail.gif" title="<fmt:message key='common.button.email'/>" /></a>
	                </div>
	                <div class="po_right"><a href="" class="js_view_instance_diagram"><fmt:message key="common.button.view_instance_diagram"/>▼</a></div>
	                <div class="po_right" style="display:none"><a href="" class="js_close_instance_diagram"><fmt:message key="common.button.close_instance_diagram"/>▼</a></div>
	            </div>
	            <!-- 우측 버튼 -->
		                    
               	<div class="solid_line"></div>
			</div>
			<!-- 타이틀 -->

			<div class="define_space js_process_instance_viewer" style="display:none;height:512px;">
			</div>
					 		            
			<!-- 프로세스 영역 -->
			<div class="define_space">
				<div class="proce_section">
			    
			        <!-- 방향 Prev -->
	        		<div class="float_left_nowidth"><a href="" class="js_instance_tasks_left" style="display:none"><img class="proc_btn_prev"></a></div>
			        
			        <div class="proc_task_completed float_left_nowidth padding_r10"> 시작 </div>
			        <div class="proc_arr_next float_left_nowidth padding_r10"></div>
			        
			        <!-- 태스크 시작-->
			        <div class="proce_space js_instance_tasks_holder" style="overflow:hidden;width:92%;backgroud-color:yellow;">			        
						<div class="js_instance_tasks" style="white-space:nowrap;position:absolute;">
							<div class="proc_task_yet float_left_nowidth js_instance_task_placeholder" style="display:none"><span class="pcenter"></span></div>
				        	<%
				        	if(!SmartUtil.isBlankObject(taskHistories)){	
				        		for(int i=0; i<taskHistories.length; i++){
				        			TaskInstanceInfo task = taskHistories[i];
				        			String statusClass = "proc_task_yet";
				        			String formMode = (task.getAssignee().getId().equals(cUser.getId()) 
				        								&& ( 	task.getStatus()==TaskInstance.STATUS_RUNNING
				        									 || task.getStatus()==TaskInstance.STATUS_DELAYED_RUNNING) ) ? "edit" : "view";
				        			boolean isSelectable = ((task.getStatus()==TaskInstance.STATUS_RUNNING||task.getStatus()==TaskInstance.STATUS_DELAYED_RUNNING)
				        										&& !task.getAssignee().equals(cUser.getId())) ? false : true;
				        			if(task.getStatus() == TaskInstance.STATUS_RETURNED)
				        				statusClass = "proc_task_returned";
				        			else if(task.getStatus() == TaskInstance.STATUS_RUNNING)
				        				statusClass = "proc_task_running";
				        			else if(task.getStatus() == TaskInstance.STATUS_DELAYED_RUNNING)
				        				statusClass = "proc_task_delayed";
				        			else if(task.getStatus() == TaskInstance.STATUS_COMPLETED)
				        				statusClass = "proc_task_completed";
				        			else
				        				statusClass = "proc_task_not_yet";				        				
				        		
				        	%>
			            			<!-- 태스크 --> 
						            <div class="<%=statusClass %> float_left_nowidth padding_r10 js_instance_task">
						                <a <%if(isSelectable){ %> href="" class="js_select_task_instance" <%} %> formId="<%=task.getFormId() %>" taskInstId="<%=task.getId()%>" formMode=<%=formMode %>>
							                <span class="pstart"></span>
							                <span class="pcenter">
							                    <!-- task 정보 -->
							                    <div class="float_left_nowidth"><img align="bottom" src="<%=task.getOwner().getMinPicture()%>" class="profile_size_s"></div>
							                    <div class="noti_in">
								                    <span><%=i+1%>) <%=task.getName() %></span>
								                    <div class="t_date"><%=task.getLastModifiedDate().toLocalString() %></div>
							                    </div>
							                    <!-- task 정보 //-->
							                </span>
							                <span class="pend"></span>
						                </a>
						            </div>
				            		<!-- 태스크 //--> 
			            			<%
			            			if(i<taskHistories.length-1){
			            			%>
							            <!--화살표-->
							            <li class="proc_arr_next float_left_nowidth padding_r10"></li>
							            <!--화살표-->
							        <%
							        }
							        %>
			            	<%
				        		}
				        	}
			            	%>
			        	</div>
			        </div>
			        <!-- 태스크 시작//-->
			        
			        <!-- 방향 Next -->
		    		<div class="float_right"><a href="" class="js_instance_tasks_right" style="display:none"><img class="proc_btn_next"></a></div>
			
				</div>
			</div>
			<!--프로세스 영역//-->
				
			<!-- 상세보기 컨텐츠 -->
			<div class="contents_space">				            
		       <div class="list_contents js_form_content">      
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
			        	<a href="" class="js_complete_pwork_instance">
				            <span class="Btn01Start"></span>
				            <span class="Btn01Center"><fmt:message key="common.button.complete"/></span>
				            <span class="Btn01End"></span>
				    	</a>
			   		</span>
					<span class="btn_gray space_l5 js_btn_return" style="display:none">
			        	<a href="" class="js_return_pwork_instance">
				            <span class="Btn01Start"></span>
				            <span class="Btn01Center"><fmt:message key="common.button.return"/></span>
				            <span class="Btn01End"></span>
				    	</a>
			   		</span>
					<span class="btn_gray space_l5 js_btn_reassign" style="display:none">
			        	<a href="" class="js_reassign_pwork_instance">
				            <span class="Btn01Start"></span>
				            <span class="Btn01Center"><fmt:message key="common.button.reassign"/></span>
				            <span class="Btn01End"></span>
				    	</a>
			   		</span>
					<span class="btn_gray space_l5 js_btn_temp_save" style="display:none">
			        	<a href="" class="js_temp_save_pwork_instance">
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

	var pworkSpace = $('.js_pwork_space_page');
	var instanceTasksHolder = pworkSpace.find(".js_instance_tasks_holder");
	var instanceTasks = instanceTasksHolder.find(".js_instance_tasks");
	var placeHolderTask = instanceTasks.find('.js_instance_task_placeholder').hide();
	var left = instanceTasks.position().left;
	var width = instanceTasks.width();
	var remainingWidth = width+left;

	var tasksRight = instanceTasksHolder.width();
	var tasks = instanceTasks.find(".js_instance_task");
	for(var i=0; i<tasks.length; i++){
		var task = $(tasks[i]);
		if(task.position().left+task.width()>tasksRight)
			break;
	}
	if(tasks.length>0 && i<tasks.length && i>=0){
		var task = $(tasks[i]);
		placeHolderTask.remove().width(task.width()).show().insertBefore(task);
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
		
</script>

<jsp:include page="/jsp/content/work/space/space_instance_list.jsp">
	<jsp:param value="<%=work.getId() %>" name="workId"/>
	<jsp:param value="<%=instId %>" name="instId"/>
</jsp:include>	
