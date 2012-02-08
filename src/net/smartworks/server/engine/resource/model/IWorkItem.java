package net.smartworks.server.engine.resource.model;

import java.util.Date;
import java.util.Map;

/**
 * 워크아이템 모델, 완전한 워크아이템 정보를 모두 갖는다.
 * 일반적으로 워크아이템의 상세 정보를 보여줄 경우에 사용한다.
 * 
 * @author jhnam
 * @version $Id: IWorkItem.java,v 1.1 2011/11/08 02:51:00 kmyu Exp $
 */
public interface IWorkItem {

	/**
	 * 상태 - 생성됨 : 1
	 */
	public static final int STATUS_CREATED = 1;
	/**
	 * 상태 - 실행 준비됨 : 2
	 */
	public static final int STATUS_READY = 2;
	/**
	 * 상태 - 진행중 : 11
	 */
	public static final int STATUS_RUNNING = 11;
	/**
	 * 상태 - 완료 대기 중 : 12
	 */
	public static final int STATUS_WAITING_COMPLETION = 12;
	/**
	 * 상태 - 보류 : 13
	 */
	public static final int STATUS_SUSPENDED = 13;
	/**
	 * 상태 - 실패 : 19
	 */
	public static final int STATUS_FAULTED = 19;
	/**
	 * 상태 - 완료 : 21
	 */
	public static final int STATUS_COMPLETED = 21;
	/**
	 * 상태 - 중단 : 22
	 */
	public static final int STATUS_TERMINATED = 22;
	
	/**
	 * 타입 PROCESS 프로세스에 참여한 업무 - 1  
	 */
	public static final int TYPE_PROCESS = 1;
	/**
	 * 타입 ADHOC 비정형 프로세스에 참여한 업무 - 2  
	 */	
	public static final int TYPE_ADHOC = 2;
	/**
	 * 타입 BASIC 프로세스에 참여하지 않은 업무 - 3 
	 */	
	public static final int TYPE_BASIC = 3;
	
	/**
	 * 할당 타입 : 사용자 - 1
	 */
	public static final int ASSING_TYPE_USER = 1;
	/**
	 * 할당 타입 : 부서 - 2
	 */
	public static final int ASSING_TYPE_DEPT = 2;
	/**
	 * 할당 타입 : 그룹 - 3
	 */
	public static final int ASSING_TYPE_GROUP = 3;
	/**
	 * 할당 타입 : 역할 - 4
	 */
	public static final int ASSING_TYPE_ROLE = 4;
	
	/**
	 * 등급 상 - H
	 */
	public static final String GRADE_HIGH = "H";
	/**
	 * 등급 중 - M
	 */
	public static final String GRADE_MIDDLE = "M";
	/**
	 * 등급 하 - L
	 */
	public static final String GRADE_LOW = "L";
	
	/**
	 * 할당한 이가 프로세스 - PROCESS
	 */
	public static final String ASSIGNER_PROCESS = "PROCESS";
	/**
	 * 할당한 이가 프로세스 - SYSTEM
	 */
	public static final String ASSIGNER_SYSTEM = "SYSTEM";
	
	/**
	 * @return the id
	 */
	public String getId();
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id);
	
	/**
	 * @return the workTypeId
	 */
	public String getWorkTypeId();
	
	/**
	 * @param workTypeId the workTypeId to set
	 */
	public void setWorkTypeId(String workTypeId);
	
	/**
	 * @return the title
	 */
	public String getTitle();
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title);
	
	/**
	 * @return the status
	 */
	public int getStatus();
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status);
	
	/**
	 * @return the assigner
	 */
	public String getAssigner();

	/**
	 * @param assigner the assigner to set
	 */
	public void setAssigner(String assigner);
	
	/**
	 * @return the assigneeType
	 */
	public int getAssigneeType();
	
	/**
	 * @param assigneeType the assigneeType to set
	 */
	public void setAssigneeType(int assigneeType);
	
	/**
	 * @return the assignee
	 */
	public String getAssignee();
	
	/**
	 * @param assignee the assignee to set
	 */
	public void setAssignee(String assignee);
	
	/**
	 * @return the performer
	 */
	public String getPerformer();
	
	/**
	 * @param performer the performer to set
	 */
	public void setPerformer(String performer);
	
	/**
	 * @return the keyword
	 */
	public String getKeyword();
	
	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword);
	
	/**
	 * @return the importance
	 */
	public String getImportance();
	
	/**
	 * @param importance the importance to set
	 */
	public void setImportance(String importance);
	
	/**
	 * @return the priority
	 */
	public String getPriority();
	
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority);
	
	/**
	 * @return the createdTime
	 */
	public Date getCreatedTime();
	
	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Date createdTime);
	
	/**
	 * @return the completedTime
	 */
	public Date getCompletedTime();
	
	/**
	 * @param completedTime the completedTime to set
	 */
	public void setCompletedTime(Date completedTime);
	
	/**
	 * @return the dueTime
	 */
	public Date getDueTime();
	
	/**
	 * @param dueTime the dueTime to set
	 */
	public void setDueTime(Date dueTime);
	
	/**
	 * @return the previousId
	 */
	public String getPreviousId();
	
	/**
	 * @param previousId the previousId to set
	 */
	public void setPreviousId(String previousId);
	
	/**
	 * @return the step
	 */
	public int getStep();

	/**
	 * @param step the step to set
	 */
	public void setStep(int step);
	
	/**
	 * @return the type
	 */
	public int getType();
	
	/**
	 * @param type the type to set
	 */
	public void setType(int type);
	
	/**
	 * @return the refId
	 */
	public String getRefId();
	
	/**
	 * @param refId the refId to set
	 */
	public void setRefId(String refId);
	
	/**
	 * @return the groupId
	 */
	public String getGroupId();
	
	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(String groupId);
	
	/**
	 * @return the deletedYn
	 */
	public String getDeletedYn();

	/**
	 * @param deletedYn the deletedYn to set
	 */
	public void setDeletedYn(String deletedYn);
	
	/**
	 * @return the data
	 */
	public String getData();
	
	/**
	 * @param data the data to set
	 */
	public void setData(String data);
	
	/**
	 * @return the description
	 */	
	public String getDescription();
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description);
	
	/**
	 * @return the props
	 */	
	public Map<String, String> getProps();
	
	/**
	 * @param props the props to set
	 */	
	public void setProps(Map<String, String> props);
	
	/**
	 * @param name
	 * @param data
	 */
	public void addProp(String name, String data);
	
}
