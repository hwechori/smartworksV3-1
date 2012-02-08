package net.smartworks.server.engine.resource.model;

import java.util.List;

/**
 * 도메인 레코드 검색시 리턴값에 사용될 도메인 레코드 리스트
 * 
 * @author jhnam
 * @version $Id: IDomainRecordDataList.java,v 1.1 2011/11/08 03:15:09 kmyu Exp $
 */
public interface IDomainRecordDataList {

	/**
	 * 검색 조건에 맞는 총 도메인 레코드 개수를 리턴한다.
	 * 
	 * @return
	 */
	public int getTotalCount();
	
	/**
	 * 검색 조건에 맞는 총 도메인 레코드 개수를 설정한다.
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(int totalCount);
	
	/**
	 * 도메인 모델을 리턴한다.
	 * 
	 * @return
	 */
	public IDomain getDomain();
	
	/**
	 * 도메인 모델을 설정한다.
	 * 
	 * @param domain
	 */
	public void setDomain(IDomain domain);
	
	/**
	 * 도메인 필드 리스트를 리턴한다.
	 * 
	 * @return
	 */
	public List getDomainFieldList();
	
	/**
	 * 도메인 필드 리스트를 설정한다.
	 * 
	 * @param fieldList
	 */
	public void setDomainFieldList(List fieldList);
	
//	/**
//	 * 보여줄 필드 정보를 추가한다.
//	 * 
//	 * @param fieldId 보여줄 폼 필드 정보
//	 */
//	public void addDispFieldId(String fieldId);
//	
//	/**
//	 * 보여줄 필드 정보 리스트를 리턴한다.
//	 * 
//	 * @return
//	 */
//	public List<String> getDispFieldIdList();
	
	/**
	 * 검색 조건에 맞는 도메인 레코드 리스트를 리턴한다.
	 * 
	 * @return
	 */
	public List<IDomainRecordData> getDomainRecordList();
	
	/**
	 * 검색 조건에 맞는 도메인 레코드 리스트를 설정한다.
	 * 
	 * @param domainRecordList
	 */
	public void setDomainRecordList(List<IDomainRecordData> domainRecordList);
	
	/**
	 * 도메인 레코드를 추가한다.
	 * 
	 * @param recordData
	 */
	public void addDomainRecord(IDomainRecordData recordData);
	
}
