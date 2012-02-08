package net.smartworks.server.engine.resource.model;

/**
 * 업무 수행자 라인
 * 
 * @author jhnam
 * @version $Id: IWorkTypePerformerLineModel.java,v 1.1 2011/11/08 03:15:08 kmyu Exp $
 */
public interface IWorkTypePerformerLineModel {

	/**
	 * @return the workTypeId
	 */
	public String getWorkTypeId();
	
	/**
	 * @param workTypeId the workTypeId to set
	 */
	public void setWorkTypeId(String workTypeId);
	
	/**
	 * @return the step
	 */
	public int getStep();
	
	/**
	 * @param step the step to set
	 */
	public void setStep(int step);
	
	/**
	 * @return the performerType
	 */
	public int getPerformerType();
	
	/**
	 * @param performerType the performerType to set
	 */
	public void setPerformerType(int performerType);
	
	/**
	 * @return the performer
	 */
	public String getPerformer();
	
	/**
	 * @param performer the performer to set
	 */
	public void setPerformer(String performer);
	
}
