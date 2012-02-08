package net.smartworks.server.engine.resource.manager;

import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.resource.exception.SmartServerRuntimeException;
import net.smartworks.server.engine.resource.model.IFormModel;
import net.smartworks.server.engine.resource.model.IFormModelList;
import net.smartworks.server.engine.resource.model.IPackageModel;
import net.smartworks.server.engine.resource.model.IPackageModelList;
import net.smartworks.server.engine.resource.model.IProcessModel;
import net.smartworks.server.engine.resource.model.IProcessModelList;
import net.smartworks.server.engine.resource.model.IWorkTypeModel;
import net.smartworks.server.engine.resource.model.IWorkTypeModelList;

/**
 * 런타임시 사용할 리소스 관련 API, 여기서는 배치된 리소스에 대해서만 조회한다.
 * 
 * @author jhnam
 * @version $Id: IResourceRuntimeManager.java,v 1.1 2011/11/08 03:15:13 kmyu Exp $
 */
public interface IResourceRuntimeManager {

	/**
	 * 패키지 아이디로 최신 버전을 찾는다.
	 * 
	 * @param userId
	 * @param packageId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public int retrieveLatestPackageVersion(String userId, String packageId) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디로 최신 버전을 찾는다.
	 * 
	 * @param userId
	 * @param processId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public int retrieveLatestProcessVersion(String userId, String processId) throws SmartServerRuntimeException;
	
	/**
	 * 폼 아이디로 최신 버전을 찾는다.
	 * 
	 * @param userId
	 * @param formId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public int retrieveLatestFormVersion(String userId, String formId) throws SmartServerRuntimeException;
	
	/**
	 * 패키지 아이디로 패키지를 찾는다.
	 * 
	 * @param userId
	 * @param packageId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IPackageModel retrieveLatestPackage(String userId, String packageId) throws SmartServerRuntimeException;
	
	/**
	 * 패키지 아이디로 패키지를 찾는다.
	 * 
	 * @param userId
	 * @param packageId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IPackageModel retrievePackage(String userId, String packageId, int version) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 유니크 아이디로 프로세스를 찾는다.
	 * 
	 * @param userId
	 * @param processUid
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IProcessModel retrieveProcess(String userId, String processUid) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디, 버전으로 프로세스를 찾는다.
	 * 
	 * @param userId
	 * @param processId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IProcessModel retrieveProcess(String userId, String processId, int version) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디로 배치된 최신 버전의 프로세스를 찾는다.
	 * 
	 * @param userId
	 * @param processId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IProcessModel retrieveLatestProcess(String userId, String processId) throws SmartServerRuntimeException;
	
	/**
	 * 패키지 아이디, 버전으로 프로세스를 찾는다.
	 * 
	 * @param userId
	 * @param packageId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IProcessModel retrieveProcessByPackage(String userId, String packageId, int version) throws SmartServerRuntimeException;
	
	/**
	 * 패키지 아이디로 부터 배치된 최신 버전의 프로세스를 찾는다.
	 * 
	 * @param userId
	 * @param packageId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IProcessModel retrieveLatestProcessByPackage(String userId, String packageId) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디로 배치된 것 중 최신 버전의 프로세스 내용을 찾는다.
	 * 
	 * @param userId
	 * @param processId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String retrieveLatestProcessContent(String userId, String processId) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 유니크 아이디로 프로세스 내용을 찾는다.
	 * 
	 * @param userId
	 * @param processUid
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String retrieveProcessContent(String userId, String processUid) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디, 버전으로 프로세스 내용을 찾는다.
	 * 
	 * @param userId
	 * @param processId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String retrieveProcessContent(String userId, String processId, int version) throws SmartServerRuntimeException;	
		
	/**
	 * 업무 폼 유니크 아이디로 업무 폼을 찾는다.
	 * 
	 * @param userId
	 * @param formUid
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IFormModel retrieveForm(String userId, String formUid) throws SmartServerRuntimeException;
	
	/**
	 * 업무 폼 아이디, 버전으로 업무 폼을 찾는다.
	 * 
	 * @param userId
	 * @param formId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IFormModel retrieveForm(String userId, String formId, int version) throws SmartServerRuntimeException;
	
	/**
	 * 업무 폼 아이디로 배치된 최신 버전의 업무 폼을 찾는다.
	 * 
	 * @param userId
	 * @param formId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IFormModel retrieveLatestForm(String userId, String formId) throws SmartServerRuntimeException;
	
	/**
	 * 폼 아이디로 배치된 마지막 버전의 폼 내용을 찾는다.
	 * 
	 * @param userId
	 * @param formId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String retrieveLatestFormContent(String userId, String formId) throws SmartServerRuntimeException;
	
	/**
	 * 폼 유니크 아이디로 폼 내용을 찾는다.
	 * 
	 * @param userId
	 * @param formUid
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String retrieveFormContent(String userId, String formUid) throws SmartServerRuntimeException;
	
	/**
	 * 폼 아이디, 버전로 폼 내용을 찾는다.
	 * 
	 * @param userId
	 * @param formId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String retrieveFormContent(String userId, String formId, int version) throws SmartServerRuntimeException;
	
	/**
	 * 워크타입 아이디로 부터 워크 타입을 찾는다.
	 * 
	 * @param userId
	 * @param workTypeId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IWorkTypeModel retrieveWorkType(String userId, String workTypeId) throws SmartServerRuntimeException;
	
	/**
	 * 폼 유니크 아이디로 부터 워크 타입을 찾는다.
	 * 
	 * @param userId
	 * @param formUid
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IWorkTypeModel retrieveWorkTypeByForm(String userId, String formUid) throws SmartServerRuntimeException;
	
	/**
	 * 폼 아이디, 버전으로 워크 타입을 찾는다.
	 * 
	 * @param userId
	 * @param formId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IWorkTypeModel retrieveWorkTypeByForm(String userId, String formId, int version) throws SmartServerRuntimeException;
	
	/**
	 * workTypeId로 부터 폼을 찾는다.
	 * 
	 * @param userId
	 * @param workTypeId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IFormModel retrieveFormByWorkType(String userId, String workTypeId) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디로 모든 버전을 찾는다.
	 * 
	 * @param userId
	 * @param processId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<Integer> findProcessVersions(String userId, String processId) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디로 배치된 모든 버전의 프로세스를 찾는다.
	 * 
	 * @param userId
	 * @param processId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IProcessModel> findProcessVersionList(String userId, String processId) throws SmartServerRuntimeException;
	
	/**
	 * categoryId로 카테고리에 소속된 배치된 최신 버전의 프로세스를 검색
	 * 
	 * @param userId
	 * @param categoryId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IProcessModel> findLatestProcessByCategory(String userId, String categoryId) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디와 프로세스 버전으로 업무 폼 리스트를 찾는다.
	 * 
	 * @param userId
	 * @param processId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findFormByProcess(String userId, String processId, int version) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 유니크 아이디로 해당 프로세스에 소속된 업무 폼 리스트를 찾는다.
	 * 
	 * @param userId
	 * @param processUid
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findFormByProcess(String userId, String processUid) throws SmartServerRuntimeException;
		
	/**
	 * 프로세스 아이디로 배치된 최신 버전의 프로세스에 소속된 업무 폼의 배치된 최신 버전을 찾는다.
	 * 
	 * @param userId
	 * @param processId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findLatestFormByProcess(String userId, String processId) throws SmartServerRuntimeException;	
	
	/**
	 * 패키지 아이디로 패키지에 소속된 배치된 최신 버전의 프로세스의 최신 버전의 업무 폼 리스트를 찾는다.
	 * 
	 * @param userId
	 * @param packageId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findLatestFormByPackage(String userId, String packageId) throws SmartServerRuntimeException;
	
	/**
	 * categoryId로 카테고리에 소속된 모든 폼 리스트를 검색 
	 * 
	 * @param userId
	 * @param categoryId
	 * @param type
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findLatestFormByCategory(String userId, String categoryId, String type) throws SmartServerRuntimeException;
	
	/**
	 * 패키지 아이디, 패키지 버전으로 모든 업무 폼 리스트를 찾는다.
	 *  
	 * @param userId
	 * @param packageId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findFormByPackage(String userId, String packageId, int version) throws SmartServerRuntimeException;
	
	/**
	 * 패키지 아이디, 버전으로 패키지에 소속된 단위업무 리스트를 찾는다.
	 * 
	 * @param userId
	 * @param packageId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findSingleFormByPackage(String userId, String packageId, int version) throws SmartServerRuntimeException;

	/**
	 * 단위 업무 타입 폼 리스트를 찾는다.
	 * 
	 * @param userId
	 * @param categoryId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findSingleFormList(String userId, String categoryId) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디로 배치된 최신 프로세스의 시작 업무 폼을 찾는다.
	 * 
	 * @param userId
	 * @param processId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findProcessStartForm(String userId, String processUid) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디 및 버전으로 프로세스의 시작 업무 폼을 찾는다.
	 * 
	 * @param userId
	 * @param processId
	 * @param processVersion
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findProcessStartForm(String userId, String processId, int processVersion) throws SmartServerRuntimeException;
	
	/**
	 * 지시 업무를 검색한다.
	 * 
	 * @param userId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findInstuctFormList(String userId) throws SmartServerRuntimeException;
	
	/**
	 * 패키지가 소속된 카테고리 이동
	 * 
	 * @param userId
	 * @param packageId
	 * @param toCategoryId
	 * @throws SmartServerRuntimeException
	 */
	public void doMovePackageCategory(String userId, String packageId, String toCategoryId) throws SmartServerRuntimeException;
	
	/**
	 * 업무 타입 목록 개수를 찾는다.
	 * 
	 * @param userId
	 * @param condition
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public int searchWorkTypeCount(String userId, Map<String, Object> condition) throws SmartServerRuntimeException;
	
	/**
	 * 검색 조건에 맞는 패키지 개수
	 *  
	 * @param userId
	 * @param condition
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public int searchPackageCount(String userId, Map<String, Object> condition) throws SmartServerRuntimeException;
	
	/**
	 * 검색 조건에 맞는 프로세스 개수
	 *  
	 * @param userId
	 * @param condition
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public int searchProcessCount(String userId, Map<String, Object> condition) throws SmartServerRuntimeException;
	
	/**
	 * 검색 조건에 맞는 업무 폼 개수
	 *  
	 * @param userId
	 * @param condition
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public int searchFormCount(String userId, Map<String, Object> condition) throws SmartServerRuntimeException;
	
	/**
	 * 업무 타입을 검색한다.
	 * 
	 * @param userId
	 * @param condition
	 * @param pageCount
	 * @param recordCount
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IWorkTypeModelList searchWorkTypeByCondition(String userId, Map<String, Object> condition, int pageCount, int recordCount) throws SmartServerRuntimeException;
	
	/**
	 * 검색 조건에 따라서 업무패키지 조회
	 * 
	 * @param userId
	 * @param condition
	 * @param orderCondition
	 * @param pageCount
	 * @param recordCount
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IPackageModelList searchPackageByCondition(String userId, Map<String, Object> condition, Map<String, String> orderCondition, int pageCount, int recordCount) throws SmartServerRuntimeException;
	
	/**
	 * 검색 조건에 따라서 프로세스 조회
	 * 
	 * @param userId
	 * @param condition
	 * @param pageCount
	 * @param recordCount
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IProcessModelList searchProcessByCondition(String userId, Map<String, Object> condition, int pageCount, int recordCount) throws SmartServerRuntimeException;

	/**
	 * 배치된 모든 프로세스의 모든 버전을 조회
	 * 
	 * @param userId
	 * @param pageCount
	 * @param recordCount
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IProcessModelList searchDeployedProcess(String userId, int pageCount, int recordCount) throws SmartServerRuntimeException;
	
	/**
	 * 배치된 프로세스 중에서 가장 최신 버전만 조회
	 * 
	 * @param userId
	 * @param pageCount
	 * @param recordCount
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IProcessModelList searchLatestDeployedProcess(String userId, int pageCount, int recordCount) throws SmartServerRuntimeException;

	/**
	 * 검색 조건에 따라서 업무 폼 조회
	 * 
	 * @param userId
	 * @param condition
	 * @param pageCount
	 * @param recordCount
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IFormModelList searchFormByCondition(String userId, Map<String, Object> condition, int pageCount, int recordCount) throws SmartServerRuntimeException;
	
}
