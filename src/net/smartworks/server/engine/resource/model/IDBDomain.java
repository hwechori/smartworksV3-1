package net.smartworks.server.engine.resource.model;

import java.util.Map;

/**
 * 폼과 도메인과의 매핑 모델을 정의한다. 
 * 테이블 : SWDomain
 * 
 * @author jhnam
 * @version $Id: IDBDomain.java,v 1.1 2011/11/08 00:41:09 kmyu Exp $
 */
public interface IDBDomain extends IDomain {

	/**
	 * 테이블 이름 접두어
	 */
	public static final String TABLE_NAME_PREFIX = "SBZT";
	/**
	 * ?
	 */
	public static final int TABLE_NAME_SEQUENCE_SIZE = 5;
	
	/**
	 * 회사 아이디
	 * 
	 * @return
	 */
	public String getCompanyId();
	/**
	 * @param companyId
	 */
	public void setCompanyId(String companyId);
	/**
	 * 도메인 테이블 매핑 아이디
	 * 
	 * @return
	 */
	public String getId();
	/**
	 * @param id
	 */
	public void setId(String id);
	
	/**
	 * 폼 아이디
	 * 
	 * @return
	 */
	public String getFormId();
	/**
	 * @param formId
	 */
	public void setFormId(String formId);
	
	/**
	 * 폼 버전
	 * 
	 * @return
	 */
	public int getFormVersion();
	/**
	 * @param formVersion
	 */
	public void setFormVersion(int formVersion);
	
	/**
	 * 폼 이름
	 * @return
	 */
	public String getFormName();
	/**
	 * @param formName
	 */
	public void setFormName(String formName);
	
	/**
	 * 테이블 오너
	 * 
	 * @return
	 */
	public String getTblOwner();
	/**
	 * @param tblOwner
	 */
	public void setTblOwner(String tblOwner);
	
	/**
	 * 테이블 이름
	 * 
	 * @return
	 */
	public String getTblName();
	/**
	 * @param tblName
	 */
	public void setTblName(String tblName);
	
	/**
	 * 키 칼럼
	 * 
	 * @return
	 */
	public String getKeyColumn();
	/**
	 * @param column
	 */
	public void setKeyColumn(String column);
	
	/**
	 * 대표 필드 아이디
	 * 
	 * @return
	 */
	public String getTitleFieldId();	
	/**
	 * @param titleFieldId
	 */
	public void setTitleFieldId(String titleFieldId);
	
	/**
	 * 마스터 도메인 아이디
	 * 
	 * @return
	 */
	public String getMasterId();
	/**
	 * @param masterId
	 */
	public void setMasterId(String masterId);
	
	/**
	 * 마스터 필드 아이디
	 * 
	 * @return
	 */
	public String getMasterFieldId();
	/**
	 * @param masterFieldId
	 */
	public void setMasterFieldId(String masterFieldId);
	
	/**
	 * 시스템 도메인 여부
	 * 
	 * @return
	 */
	public String getSystemDomainYn();
	/**
	 * @param systemDomainYn
	 */
	public void setSystemDomainYn(String systemDomainYn);
	
	/**
	 * @return the publishMode
	 */
	public String getPublishMode();
	/**
	 * @param publishMode the publishMode to set
	 */
	public void setPublishMode(String publishMode);
	
	/**
	 * 도메인 테이블이 가지는 필드만을 관리한다. 마스터 도메인이라면 디테일 도메인의 필드까지 관리하지 않는다. 
	 * 도메인 필드 맵. 키 - 필드 아이디, 값 - 도메인 필드
	 * 
	 * @return
	 */
	public Map<String, IDBDomainField> getDomainFieldMap();
	
	/**
	 * 도메인 필드를 추가한다.
	 * 
	 * @param domainField
	 */
	public void addFormField(IDBDomainField domainField);
	
	/**
	 * 도메인 필드 아이디로 도메인 필드를 찾는다.
	 * 
	 * @param domainFieldId
	 * @return
	 */
	public IDBDomainField getDomainField(String domainFieldId);
}
