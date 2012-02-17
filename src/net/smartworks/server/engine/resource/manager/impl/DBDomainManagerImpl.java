package net.smartworks.server.engine.resource.manager.impl;

import net.smartworks.server.engine.resource.dao.IDomainDdlDao;
import net.smartworks.server.engine.resource.exception.SmartServerRuntimeException;
import net.smartworks.server.engine.resource.manager.IDomainManager;

/**
 * IDomainManager 데이터베이스 구현
 * 
 * @author jhnam
 * @version $Id: DBDomainManagerImpl.java,v 1.1 2011/11/08 00:41:10 kmyu Exp $
 */
public class DBDomainManagerImpl implements IDomainManager {

	private IDomainDdlDao domainDdlDao;
	public IDomainDdlDao getDomainDdlDao() {
		return domainDdlDao;
	}
	public void setDomainDdlDao(IDomainDdlDao domainDdlDao) {
		this.domainDdlDao = domainDdlDao;
	}
	
	public void undeployDomain(String userId, String formId, int formVersion) throws SmartServerRuntimeException {
		this.domainDdlDao.deleteDomain(formId, formVersion);
	}
	public void deployDomainByPackage(String userId, String companyId, String packageId, int version) throws SmartServerRuntimeException {		
		this.domainDdlDao.createDomainByPackage(companyId, packageId, version);
	}
	public void undeployDomainByPackage(String userId, String packageId, int version) throws SmartServerRuntimeException {
		this.domainDdlDao.deleteDomainByPackage(packageId, version);
	}
}
