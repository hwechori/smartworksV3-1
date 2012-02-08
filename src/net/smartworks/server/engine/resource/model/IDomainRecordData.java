package net.smartworks.server.engine.resource.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 도메인 데이터 레코드 인터페이스를 정의한다.
 * 
 * @author jhnam
 * @version $Id: IDomainRecordData.java,v 1.1 2011/11/08 03:15:09 kmyu Exp $
 */
public interface IDomainRecordData {

	/**
	 * workItemId
	 * 
	 * @return
	 */
	public String getWorkItemId();
	
	/**
	 * @param workItemId
	 */
	public void setWorkItemId(String workItemId);
	
	/**
	 * 폼 레코드 아이디
	 * 
	 * @return
	 */
	public String getRecordId();
	
	/**
	 * @param recordId
	 */
	public void setRecordId(String recordId);
	
	/**
	 * 도메인 데이터 필드가 소속된 폼 아이디
	 * 
	 * @return
	 */
	public String getFormId();
	
	/**
	 * @param formId
	 */
	public void setFormId(String formId);
	
	/**
	 * 도메인 데이터 필드가 소속된 폼 버전
	 * 
	 * @return
	 */
	public int getFormVersion();
	
	/**
	 * @param formVersion
	 */
	public void setFormVersion(int formVersion);
	
	/**
	 * @return the creator
	 */
	public String getCreator();
	
	/**
	 * @param creator the creator to set
	 */
	public void setCreator(String creator);
	
	/**
	 * @return the creatorId
	 */
	public String getCreatorId();
	
	/**
	 * @param creatorId the creatorId to set
	 */
	public void setCreatorId(String creatorId);

	/**
	 * @return the createdTime
	 */
	public Date getCreatedTime();

	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Date createdTime);
	
	/**
	 * 새로 저장된 데이터인지 여부
	 * 
	 * @return
	 */
	public boolean isNew();
	
	/**
	 * @param isNew
	 */
	public void setNew(boolean isNew);
	
	/**
	 * 업무에 설정된 의견 개수 
	 * 
	 * @return
	 */
	public int getOpinionCount();
	/**
	 * @param opinionCount
	 */
	public void setOpinionCount(int opinionCount);
	
	/**
	 * 도메인 데이터 필드 데이터 리스트
	 * 
	 * @return
	 */
	public Map<String, IDomainFieldData> getDataFieldMap();
	
	/**
	 * 도메인 데이터 필드를 추가한다.
	 * 
	 * @param fieldData
	 */
	public void addDataField(IDomainFieldData fieldData);
	
	/**
	 * fieldId로 도메인 데이터 필드를 찾는다.
	 * 
	 * @param fieldId
	 * @return
	 */
	public IDomainFieldData getDataField(String fieldId);
	
	/**
	 * fieldId로 데이터 필드를 제거한다.
	 * 
	 * @param fieldId
	 * @return
	 */
	public IDomainFieldData removeDataField(String fieldId);
	
	/**
	 * 릴레이션을 가진 데이터 필드 리스트를 찾는다.
	 * 
	 * @return
	 */
	public List<IDomainFieldData> getRelationDataFieldList();
}
