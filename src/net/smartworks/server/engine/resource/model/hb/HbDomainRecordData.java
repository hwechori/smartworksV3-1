package net.smartworks.server.engine.resource.model.hb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.common.util.ListMap;
import net.smartworks.server.engine.resource.model.IDomainFieldData;
import net.smartworks.server.engine.resource.model.IDomainRecordData;
import net.smartworks.server.engine.resource.util.lang.DateUtil;

/**
 * IDomainDataRecord 구현
 * 
 * @author jhnam
 * @version $Id: HbDomainRecordData.java,v 1.1 2011/11/08 03:15:04 kmyu Exp $
 */
public class HbDomainRecordData implements IDomainRecordData, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * workItemId
	 */
	private String workItemId;
	/**
	 * recordId
	 */
	private String recordId;
	/**
	 * formId
	 */
	private String formId;
	/**
	 * formVersion
	 */
	private int formVersion;
	/**
	 * 새롭게 저장된 데이터 인지 여부
	 */
	private boolean isNew;
	/**
	 * 단위업무에 설정된 의견 개수
	 */
	private int opinionCount;
	/**
	 * 데이터 레코드 생성자 이름
	 */
	private String creator;
	/**
	 * 데이터 레코드 생성자 아이디
	 */
	private String creatorId;
	/**
	 * 데이터 레코드 생성시간
	 */
	private Date createdTime;
	/**
	 * domainDataFieldMap. 키-도메인 데이터 필드 아이디, 값-도메인 데이터 필드
	 */
	private Map<String, IDomainFieldData> dataFieldMap = new ListMap();	

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataRecord#getFormId()
	 */
	public String getFormId() {
		return this.formId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataRecord#getFormVersion()
	 */
	public int getFormVersion() {
		return this.formVersion;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataRecord#getRecordId()
	 */
	public String getRecordId() {
		return this.recordId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataRecord#getWorkItemId()
	 */
	public String getWorkItemId() {
		return this.workItemId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataRecord#setFormId(java.lang.String)
	 */
	public void setFormId(String formId) {
		this.formId = formId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataRecord#setFormVersion(int)
	 */
	public void setFormVersion(int formVersion) {
		this.formVersion = formVersion;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataRecord#setRecordId(java.lang.String)
	 */
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataRecord#setWorkItemId(java.lang.String)
	 */
	public void setWorkItemId(String workItemId) {
		this.workItemId = workItemId;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainRecordData#getCreatedTime()
	 */
	public Date getCreatedTime() {
		return this.createdTime;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainRecordData#getCreator()
	 */
	public String getCreator() {
		return this.creator;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainRecordData#getCreatorId()
	 */
	public String getCreatorId() {
		return this.creatorId;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainRecordData#setCreatedTime(java.util.Date)
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainRecordData#setCreator(java.lang.String)
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainRecordData#setCreatorId(java.lang.String)
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataRecord#isNew()
	 */
	public boolean isNew() {
		return isNew;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataRecord#setNew(boolean)
	 */
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainRecordData#getOpinionCount()
	 */
	public int getOpinionCount() {
		return this.opinionCount;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainRecordData#setOpinionCount(int)
	 */
	public void setOpinionCount(int opinionCount) {
		this.opinionCount = opinionCount;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataRecord#addDomainDataField(com.maninsoft.smart.server.model.IDomainDataField)
	 */
	public void addDataField(IDomainFieldData domainDataField) {
		this.dataFieldMap.put(domainDataField.getId(), domainDataField);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainDataRecord#getDomainDataFieldMap()
	 */
	public Map<String, IDomainFieldData> getDataFieldMap() {
		return this.dataFieldMap;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainRecordData#getRelationFieldDataList()
	 */
	public List<IDomainFieldData> getRelationDataFieldList() {
		
		if(this.dataFieldMap == null || this.dataFieldMap.isEmpty())
			return new ArrayList<IDomainFieldData>();
		
		List<IDomainFieldData> relationList = new ArrayList<IDomainFieldData>();		
		Iterator<IDomainFieldData> it = this.dataFieldMap.values().iterator();
		
		while(it.hasNext()) {
			IDomainFieldData data = it.next();
			if(data.isArray())
				relationList.add(data);
		}
		
		return relationList;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainRecordData#getDomainFieldData(java.lang.String)
	 */
	public IDomainFieldData getDataField(String fieldId) {
		return this.dataFieldMap == null ? null : (IDomainFieldData)this.dataFieldMap.get(fieldId) ;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IDomainRecordData#removeFieldData(java.lang.String)
	 */
	public IDomainFieldData removeDataField(String fieldId) {
		return this.dataFieldMap != null ? this.dataFieldMap.remove(fieldId) : null;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.toString()#toString()
	 */
	public String toString() {
		
		StringBuffer buffer = new StringBuffer("<DataRecord");
		buffer.append(" recordId=\"");
		buffer.append(this.recordId == null ? "" : this.recordId);
		buffer.append("\" workItemId=\"");
		buffer.append(this.workItemId == null ? "" : this.workItemId);
		buffer.append("\" formId=\"");
		buffer.append(this.formId == null ? "" : this.formId);
		buffer.append("\" formVersion=\"");
		buffer.append(this.formVersion);
		buffer.append("\" creator=\"");
		buffer.append(this.creator == null ? "" : this.creator);
		buffer.append("\" createdTime=\"");
		buffer.append(this.createdTime == null ? "" : DateUtil.formatDate(this.createdTime));		
		buffer.append("\">");
		
		Iterator<IDomainFieldData> dataIt = this.dataFieldMap.values().iterator();
		while(dataIt.hasNext()) {
			IDomainFieldData dataField = dataIt.next();
			buffer.append(dataField);
		}
		
		buffer.append("</DataRecord>");
		return buffer.toString();
	}
	
}
