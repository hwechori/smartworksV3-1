package net.smartworks.server.engine.resource.model;

import java.util.Set;

/**
 * 워크 타입 모델
 * <li> 매핑 테이블 : SWWorkType
 * 
 * @author jhnam
 * @version $Id: IWorkTypeModel.java,v 1.1 2011/11/08 03:15:10 kmyu Exp $
 */
public interface IWorkTypeModel {

	/**
	 * 워크 타입 : 일반업무 타입 - COMMON
	 */
	public static final String WORKTYPE_COMMON = "COMMON";
	/**
	 * 워크 타입 : 지시업무 타입 - INSTRUCT
	 */
	public static final String WORKTYPE_INSTRUCT = "INSTRUCT";
	/**
	 * 워크 타입 : 결재업무 타입 - SANCTION
	 */
	public static final String WORKTYPE_SANCTION = "SANCTION";
	/**
	 * 워크 타입 : 회의업무 타입 - MEETING
	 */
	public static final String WORKTYPE_MEETING = "MEETING";
	
	/**
	 * @return the id
	 */
	public String getId();
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id);
	
	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * @param name the name to set
	 */
	public void setName(String name);
	
	/**
	 * @return the formUid
	 */
	public String getFormUid();
	
	/**
	 * @param formUid the formUid to set
	 */
	public void setFormUid(String formUid);
	
	/**
	 * @return the stepCount
	 */
	public int getStepCount();
	
	/**
	 * @param stepCount the stepCount to set
	 */
	public void setStepCount(int stepCount);
	
	/**
	 * @return the type
	 */
	public String getType();
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type);
	
	/**
	 * @return the duration
	 */
	public int getDuration();
	
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration);
	
	/**
	 * @return
	 */
	public Set<IWorkTypePerformerLineModel> getPerformerLineSet();

	/**
	 * @param performerLineSet
	 */
	public void setPerformerLineSet(Set<IWorkTypePerformerLineModel> performerLineSet);
	
	/**
	 * @param performerLine
	 */
	public void addPerformerLine(IWorkTypePerformerLineModel performerLine);
	
	/**
	 * @param performerLine
	 */
	public void removePerformerLine(IWorkTypePerformerLineModel performerLine);
	
	/**
	 * clear
	 */
	public void clearPerformerLine();
}
