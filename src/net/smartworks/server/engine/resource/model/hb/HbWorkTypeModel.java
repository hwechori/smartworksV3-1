package net.smartworks.server.engine.resource.model.hb;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import net.smartworks.server.engine.resource.model.IWorkTypeModel;
import net.smartworks.server.engine.resource.model.IWorkTypePerformerLineModel;
import net.smartworks.server.engine.resource.util.XmlUtil;

/**
 * IWorkTypeModel 하이버네이트 타입 구현
 * 
 * @author jhnam
 * @version $Id: HbWorkTypeModel.java,v 1.1 2011/11/08 03:15:01 kmyu Exp $
 */
public class HbWorkTypeModel implements IWorkTypeModel, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 유니크 아이디
	 */
	private String id;
	/**
	 * 워크 타입 이름
	 */
	private String name;
	/**
	 * 폼 유니크 아이디
	 */
	private String formUid;
	/**
	 * 폼 스텝 카운트
	 */
	private int stepCount;
	/**
	 * 타입
	 */
	private String type;
	/**
	 * 기한 - 날짜
	 */
	private int duration;
	/**
	 * performerLine
	 */
	private Set<IWorkTypePerformerLineModel> performerLineSet = new HashSet<IWorkTypePerformerLineModel>();	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the formUid
	 */
	public String getFormUid() {
		return formUid;
	}
	
	/**
	 * @param formUid the formUid to set
	 */
	public void setFormUid(String formUid) {
		this.formUid = formUid;
	}
	
	/**
	 * @return the stepCount
	 */
	public int getStepCount() {
		return stepCount;
	}
	
	/**
	 * @param stepCount the stepCount to set
	 */
	public void setStepCount(int stepCount) {
		this.stepCount = stepCount;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	/**
	 * @return
	 */
	public Set<IWorkTypePerformerLineModel> getPerformerLineSet() {
		return performerLineSet;
	}

	/**
	 * @param performerLine
	 */
	public void setPerformerLineSet(Set<IWorkTypePerformerLineModel> performerLine) {
		this.performerLineSet = performerLine;
	}
	
	/**
	 * @param performerLine
	 */
	public void addPerformerLine(IWorkTypePerformerLineModel performerLine) {
		this.performerLineSet.add(performerLine);
	}
	
	/**
	 * @param performerLine
	 */
	public void removePerformerLine(IWorkTypePerformerLineModel performerLine) {
		this.performerLineSet.remove(performerLine);
	}
	
	/**
	 * clear
	 */
	public void clearPerformerLine() {
		this.performerLineSet.clear();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		
		if(!(obj instanceof HbWorkTypeModel))
			return false;
		
		HbWorkTypeModel model = (HbWorkTypeModel)obj;
		
		if(this.id == null || model.getId() == null)
			return false;
		
		if(this.id.equals(model.getId()) && this.stepCount == model.getStepCount())
			return true;
		else
			return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public String toString() {
		try {
			return XmlUtil.beanToXmlString("WorkType", this, this.getClass());
		} catch (Exception e) {
			return "";
		}
	}
	
}
