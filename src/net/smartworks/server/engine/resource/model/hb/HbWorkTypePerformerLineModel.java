package net.smartworks.server.engine.resource.model.hb;

import java.io.Serializable;

import net.smartworks.server.engine.resource.model.IWorkTypePerformerLineModel;
import net.smartworks.server.engine.resource.util.XmlUtil;

/**
 * IWorkTypePerformerLine 하이버네이트 구현
 * 
 * @author jhnam
 * @version $Id: HbWorkTypePerformerLineModel.java,v 1.1 2011/11/08 03:15:03 kmyu Exp $
 */
public class HbWorkTypePerformerLineModel implements IWorkTypePerformerLineModel, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 유니크 아이디
	 */
	private String id;
	/**
	 * 워크 타입 아이디
	 */
	private String workTypeId;
	/**
	 * 업무 수행 스텝
	 */
	private int step;
	/**
	 * 수행자 타입
	 */
	private int performerType;
	/**
	 * 수행자
	 */
	private String performer;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the workTypeId
	 */
	public String getWorkTypeId() {
		return workTypeId;
	}
	
	/**
	 * @param workTypeId the workTypeId to set
	 */
	public void setWorkTypeId(String workTypeId) {
		this.workTypeId = workTypeId;
	}
	
	/**
	 * @return the step
	 */
	public int getStep() {
		return step;
	}
	
	/**
	 * @param step the step to set
	 */
	public void setStep(int step) {
		this.step = step;
	}
	
	/**
	 * @return the performerType
	 */
	public int getPerformerType() {
		return performerType;
	}
	
	/**
	 * @param performerType the performerType to set
	 */
	public void setPerformerType(int performerType) {
		this.performerType = performerType;
	}
	
	/**
	 * @return the performer
	 */
	public String getPerformer() {
		return performer;
	}
	
	/**
	 * @param performer the performer to set
	 */
	public void setPerformer(String performer) {
		this.performer = performer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		
		if(!(obj instanceof HbWorkTypePerformerLineModel))
			return false;
		
		HbWorkTypePerformerLineModel model = (HbWorkTypePerformerLineModel)obj;
		
		if(this.id == null || model.getId() == null)
			return false;
		
		if(this.id.equals(model.getId()))
			return true;
		else
			return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public String toString() {
		try {
			return XmlUtil.beanToXmlString("PerformerLine", this, this.getClass());
		} catch (Exception e) {
			return "";
		}
	}
}
