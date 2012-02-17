package net.smartworks.server.engine.resource.model.hb;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import net.smartworks.server.engine.resource.model.IAuthResourceModel;
import net.smartworks.server.engine.resource.model.IDBDomain;
import net.smartworks.server.engine.resource.model.IDBDomainField;

/**
 * IDBDomain 하이버네이트 구현
 * 
 * @author jhnam
 * @version $Id: HbDBDomain.java,v 1.1 2011/11/08 00:41:08 kmyu Exp $
 */
public class HbDBDomain implements IDBDomain, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 회사 아이디
	 */
	private String companyId;
	/**
	 * 도메인 매핑 아이디
	 */
	private String id;
	/**
	 * 폼 아이디
	 */
    private String formId;
    /**
     * 폼 버전
     */
    private int formVersion;
    /**
     * 폼 이름
     */
    private String formName;
    /**
     * 테이블 오너
     */
    private String tblOwner;
    /**
     * 테이블 이름
     */
    private String tblName;
    /**
     * 키 칼럼
     */
    private String keyColumn;
    /**
     * 대표 필드 아이디
     */
    private String titleFieldId;
    /**
     * 마스터 도메인 아이디 - 자신이 마스터 도메인이라면 null이다.
     */
    private String masterId;
    /**
     * 자신의 마스터 도메인과 연결되는 필드 아이디 
     */
    private String masterFieldId;
    /**
     * 시스템 도메인 여부
     */
    private String systemDomainYn;
    /**
     * 공개 모드 - 기본은 전체공개
     */
    private String publishMode = IAuthResourceModel.PERMISSION_PUB_ALL;
    
    /**
     * 도메인 필드 맵
     */
    private Map<String, IDBDomainField> domainFieldMap;
    
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#getFormId()
	 */
	public String getFormId() {
		return this.formId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#getFormName()
	 */
	public String getFormName() {
		return this.formName;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#getFormVersion()
	 */
	public int getFormVersion() {
		return this.formVersion;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#getCompanyId()
	 */
	public String getCompanyId() {
		return this.companyId;
	}
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#getId()
	 */
	public String getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#getKeyColumn()
	 */
	public String getKeyColumn() {
		return this.keyColumn;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#getTitleFieldId()
	 */
	public String getTitleFieldId() {
		return this.titleFieldId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#getTblName()
	 */
	public String getTblName() {
		return this.tblName;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#getTblOwner()
	 */
	public String getTblOwner() {
		return this.tblOwner;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#setFormId(java.lang.String)
	 */
	public void setFormId(String formId) {
		this.formId = formId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#setFormName(java.lang.String)
	 */
	public void setFormName(String formName) {
		this.formName = formName;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#setFormVersion(int)
	 */
	public void setFormVersion(int formVersion) {
		this.formVersion = formVersion;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#setCompanyId(java.lang.String)
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#setId(java.lang.String)
	 */
	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#setKeyColumn(java.lang.String)
	 */
	public void setKeyColumn(String keyColumn) {
		this.keyColumn = keyColumn;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#setTitleFieldId(java.lang.String)
	 */
	public void setTitleFieldId(String titleFieldId) {
		this.titleFieldId = titleFieldId;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#setTblName(java.lang.String)
	 */
	public void setTblName(String tblName) {
		this.tblName = tblName;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#setTblOwner(java.lang.String)
	 */
	public void setTblOwner(String tblOwner) {
		this.tblOwner = tblOwner;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#getMasterId()
	 */
	public String getMasterId() {
		return this.masterId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#setMasterId(java.lang.String)
	 */
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#getMasterFieldId()
	 */
	public String getMasterFieldId() {
		return this.masterFieldId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#setMasterFieldId(java.lang.String)
	 */
	public void setMasterFieldId(String masterFieldId) {
		this.masterFieldId = masterFieldId;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#getSystemDomainYn()
	 */
	public String getSystemDomainYn() {
		return this.systemDomainYn;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#setSystemDomainYn(java.lang.String)
	 */
	public void setSystemDomainYn(String systemDomainYn) {
		this.systemDomainYn = systemDomainYn;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#getPublishMode()
	 */
	public String getPublishMode() {
		return this.publishMode;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#setPublishMode(java.lang.String)
	 */
	public void setPublishMode(String publishMode) {
		this.publishMode = publishMode;
	}	
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#addFormField(com.maninsoft.smart.domain.db.model.IDBDomainField)
	 */
	public void addFormField(IDBDomainField domainField) {
		
		if(this.domainFieldMap == null) 
			this.domainFieldMap = new HashMap<String, IDBDomainField>();
		
		this.domainFieldMap.put(domainField.getId(), domainField);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#getDomainFieldMap()
	 */
	public Map<String, IDBDomainField> getDomainFieldMap() {
		return this.domainFieldMap;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomain#getDomainField(java.lang.String)
	 */
	public IDBDomainField getDomainField(String domainFieldId) {
		return this.domainFieldMap.containsKey(domainFieldId) ? this.domainFieldMap.get(domainFieldId) : null;
	}
	
}
