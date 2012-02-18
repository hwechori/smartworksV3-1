package net.smartworks.server.engine.resource.dao;


/**
 * DDL을 위한 DAO
 * 
 * @author jhnam
 * @version $Id: IDomainDdlDao.java,v 1.1 2011/11/08 00:41:08 kmyu Exp $
 */
public interface IDomainDdlDao {
	/**
	 * 폼 아이디, 버전 정보로 도메인 정보를 삭제한다.
	 * 
	 * @param formId
	 * @param formVersion
	 */
	public void deleteDomain(String formId, int formVersion);
	
	/**
	 * 패키지 아이디, 버전으로 도메인 생성
	 * 
	 * @param packageId
	 * @param version
	 */
	public void createDomainByPackage(String companyId, String packageId, int version);
	
	/**
	 * 패키지 아이디, 버전으로 도메인 삭제
	 * 
	 * @param packageId
	 * @param version
	 */
	public void deleteDomainByPackage(String packageId, int version);
	
}
