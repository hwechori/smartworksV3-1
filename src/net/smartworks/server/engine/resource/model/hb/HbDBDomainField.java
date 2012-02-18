package net.smartworks.server.engine.resource.model.hb;

import java.io.Serializable;

import net.smartworks.server.engine.resource.model.IDBDomainField;

/**
 * IDBDomainField 하이버네이트 구현
 * 
 * @author jhnam
 * @version $Id: HbDBDomainField.java,v 1.1 2011/11/08 00:41:08 kmyu Exp $
 */
public class HbDBDomainField implements IDBDomainField, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 도메인 필드 아이디
	 */
	private String id;
    /**
     * 도메인 매핑 아이디
     */
	private String domainId;
	/**
	 * 폼 필드 경로 - 다른 단위업무를 참조하는 경우 참조 폼 아이디와 폼 필드가 폼 필드 경로가 된다. 형식은 formId.formFieldId
	 */
    private String formFieldPath;
    /**
     * 폼 필드 아이디
     */
    private String formFieldId;
    /**
     * 폼 필드 이름
     */
    private String formFieldName;
    /**
     * 폼 필드 데이터 타입
     */
    private String formFieldType;
    /**
     * 도메인 필드 칼럼 이름
     */
    private String tableColName;
    /**
     * 배열 여부
     */
    private String arrayYn;
    /**
     * 레퍼런스 테이블 이름
     */
    private String refTblName;
    /**
     * 시스템 필드 여부
     */
    private String systemFieldYn;
    /**
     * 단위 업무 목록에 표시 순서, 단위업무 목록에 표시되지 않는 칼럼의 dispOrder 값은 -1이다.
     */
    private int dispOrder;
    /**
     * 단위업무 목록 테이블 너비
     */
    private float tableWidth;
    
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#getFormFieldType()
	 */
	public String getFormFieldType() {
		return this.formFieldType;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#getFormFieldId()
	 */
	public String getFormFieldId() {
		return this.formFieldId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#getFormFieldName()
	 */
	public String getFormFieldName() {
		return this.formFieldName;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#getFormFieldPath()
	 */
	public String getFormFieldPath() {
		return this.formFieldPath;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#getTableColName()
	 */
	public String getTableColName() {
		return this.tableColName;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#getDomainId()
	 */
	public String getDomainId() {
		return this.domainId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#getId()
	 */
	public String getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#getRefTblName()
	 */
	public String getRefTblName() {
		return this.refTblName;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#setFormFieldType(java.lang.String)
	 */
	public void setFormFieldType(String attrDataType) {
		this.formFieldType = attrDataType;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#setFormFieldId(java.lang.String)
	 */
	public void setFormFieldId(String attrId) {
		this.formFieldId = attrId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#setFormFieldName(java.lang.String)
	 */
	public void setFormFieldName(String attrName) {
		this.formFieldName = attrName;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#setFormFieldPath(java.lang.String)
	 */
	public void setFormFieldPath(String attrPath) {
		this.formFieldPath = attrPath;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#setTableColName(java.lang.String)
	 */
	public void setTableColName(String colName) {
		this.tableColName = colName;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#setDomainId(java.lang.String)
	 */
	public void setDomainId(String formMetaId) {
		this.domainId = formMetaId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#setId(java.lang.String)
	 */
	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#setRefTblName(java.lang.String)
	 */
	public void setRefTblName(String refTblName) {
		this.refTblName = refTblName;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#getSystemFieldYn()
	 */
	public String getSystemFieldYn() {
		return this.systemFieldYn;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#setSystemFieldYn(java.lang.String)
	 */
	public void setSystemFieldYn(String systemFieldYn) {
		this.systemFieldYn = systemFieldYn;
	}	

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#getArrayYn()
	 */
	public String getArrayYn() {
		return this.arrayYn;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.domain.db.model.IDBDomainField#setArrayYn(java.lang.String)
	 */
	public void setArrayYn(String arrayYn) {
		this.arrayYn = arrayYn;
	}

	/**
	 * @return the dispOrder
	 */
	public int getDispOrder() {
		return dispOrder;
	}

	/**
	 * @param dispOrder the dispOrder to set
	 */
	public void setDispOrder(int dispOrder) {
		this.dispOrder = dispOrder;
	}

	/**
	 * @return the tableWidth
	 */
	public float getTableWidth() {
		return tableWidth;
	}

	/**
	 * @param tableWidth the tableWidth to set
	 */
	public void setTableWidth(float tableWidth) {
		this.tableWidth = tableWidth;
	}
	
}
