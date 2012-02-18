package net.smartworks.server.engine.resource.manager;

import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.resource.exception.SmartServerRuntimeException;
import net.smartworks.server.engine.resource.model.IDomain;
import net.smartworks.server.engine.resource.model.IDomainField;
import net.smartworks.server.engine.resource.model.IDomainFieldView;
import net.smartworks.server.engine.resource.model.IDomainList;
import net.smartworks.server.engine.resource.model.IDomainRecordData;
import net.smartworks.server.engine.resource.model.IDomainRecordDataList;
import net.smartworks.server.engine.resource.model.IFormDef;
import net.smartworks.server.engine.resource.model.IFormFieldDef;
import net.smartworks.server.engine.resource.model.IGadgetModel;

/**
 * 도메인 데이터 관리자 인터페이스
 * 
 * @author jhnam
 * @version $Id: IDomainManager.java,v 1.1 2011/11/08 03:15:12 kmyu Exp $
 */
public interface IDomainManager {

	/**
	 * 도메인 배치해제
	 * 
	 * @param userId
	 * @param formId
	 * @param formVersion
	 * @throws SmartServerRuntimeException
	 */
	public void undeployDomain(String userId, String formId, int formVersion) throws SmartServerRuntimeException;
	
	/**
	 * 패키지 아이디, 버전으로 도메인 배치
	 * 
	 * @param userId
	 * @param packageId
	 * @param version
	 * @throws SmartServerRuntimeException
	 */
	public void deployDomainByPackage(String userId, String companyId, String packageId, int version) throws SmartServerRuntimeException;
	
	/**
	 * 패키지 아이디, 버전으로 도메인 배치해제
	 * 
	 * @param userId
	 * @param packageId
	 * @param version
	 * @throws SmartServerRuntimeException
	 */
	public void undeployDomainByPackage(String userId, String packageId, int version) throws SmartServerRuntimeException;

}
