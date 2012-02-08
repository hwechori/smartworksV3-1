package net.smartworks.server.engine.resource.dao;

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
 * 런타임에 사용할 리소스 관련 DAO API, 여기서는 배치된 리소스에 대해서만 조회한다.
 * 
 * @author jhnam
 * @version $Id: IResourceRuntimeDao.java,v 1.1 2011/11/08 03:15:16 kmyu Exp $
 */
public interface IResourceRuntimeDao {

	/**
	 * 패키지 아이디로 배치된 최신 버전을 찾는다.
	 * 
	 * @param packageId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public int retrieveLatestPackageVersion(String packageId) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디로 배치된 최신 버전을 찾는다.
	 * 
	 * @param processId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public int retrieveLatestProcessVersion(String processId) throws SmartServerRuntimeException;
	
	/**
	 * 폼 아이디로 배치된 최신 버전을 찾는다.
	 * 
	 * @param formId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public int retrieveLatestFormVersion(String formId) throws SmartServerRuntimeException;
	
	/**
	 * 패키지 아이디로 패키지를 찾는다.
	 * 
	 * @param packageId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IPackageModel retrieveLatestPackage(String packageId) throws SmartServerRuntimeException;
	
	/**
	 * 패키지 아이디로 패키지를 찾는다.
	 * 
	 * @param packageId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IPackageModel retrievePackage(String packageId, int version) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 유니크 아이디로 프로세스를 찾는다.
	 * 
	 * @param processUid
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IProcessModel retrieveProcess(String processUid) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디, 버전으로 프로세스를 찾는다.
	 * 
	 * @param processId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IProcessModel retrieveProcess(String processId, int version) throws SmartServerRuntimeException;
	
	/**
	 * 패키지 아이디, 버전으로 프로세스를 찾는다.
	 * 
	 * @param packageId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IProcessModel retrieveProcessByPackage(String packageId, int version) throws SmartServerRuntimeException;
			
	/**
	 * 프로세스 아이디로 배치된 최신 버전의 프로세스를 찾는다.
	 * 
	 * @param userId
	 * @param processId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IProcessModel retrieveLatestProcess(String processId) throws SmartServerRuntimeException;
	
	/**
	 * 패키지 아이디로 부터 배치된 최신 버전의 프로세스를 찾는다.
	 * 
	 * @param packageId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IProcessModel retrieveLatestProcessByPackage(String packageId) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디로 배치된 것 중 최신 버전의 프로세스 내용을 찾는다.
	 * 
	 * @param processId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String retrieveLatestProcessContent(String processId) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 유니크 아이디로 프로세스 내용을 찾는다.
	 * 
	 * @param processUid
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String retrieveProcessContent(String processUid) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디, 버전으로 프로세스 내용을 찾는다.
	 * 
	 * @param processId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String retrieveProcessContent(String processId, int version) throws SmartServerRuntimeException;	
		
	/**
	 * 업무 폼 유니크 아이디로 업무 폼을 찾는다.
	 * 
	 * @param formUid
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IFormModel retrieveForm(String formUid) throws SmartServerRuntimeException;
	
	/**
	 * 업무 폼 아이디, 버전으로 업무 폼을 찾는다.
	 * 
	 * @param formId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IFormModel retrieveForm(String formId, int version) throws SmartServerRuntimeException;
	
	/**
	 * 업무 폼 아이디로 배치된 최신 버전의 업무 폼을 찾는다.
	 * 
	 * @param formId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IFormModel retrieveLatestForm(String formId) throws SmartServerRuntimeException;
	
	/**
	 * 폼 아이디로 배치된 마지막 버전의 폼 내용을 찾는다.
	 * 
	 * @param formId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String retrieveLatestFormContent(String formId) throws SmartServerRuntimeException;
	
	/**
	 * 폼 유니크 아이디로 폼 내용을 찾는다.
	 * 
	 * @param formUid
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String retrieveFormContent(String formUid) throws SmartServerRuntimeException;
	
	/**
	 * 폼 아이디, 버전로 폼 내용을 찾는다.
	 * 
	 * @param formId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String retrieveFormContent(String formId, int version) throws SmartServerRuntimeException;
	
	/**
	 * 워크타입 아이디로 부터 워크 타입을 찾는다.
	 * 
	 * @param workTypeId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IWorkTypeModel retrieveWorkType(String workTypeId) throws SmartServerRuntimeException;
	
	/**
	 * 폼 유니크 아이디로 부터 워크 타입을 찾는다.
	 * 
	 * @param formUid
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IWorkTypeModel retrieveWorkTypeByForm(String formUid) throws SmartServerRuntimeException;
	
	/**
	 * 폼 아이디, 버전으로 워크 타입을 찾는다.
	 * 
	 * @param formId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IWorkTypeModel retrieveWorkTypeByForm(String formId, int version) throws SmartServerRuntimeException;
	
	/**
	 * workTypeId로 부터 폼을 찾는다.
	 * 
	 * @param workTypeId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IFormModel retrieveFormByWorkType(String workTypeId) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디로 모든 버전을 찾는다.
	 * 
	 * @param processId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<Integer> findProcessVersions(String processId) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디로 배치된 모든 버전의 프로세스를 찾는다.
	 * 
	 * @param processId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IProcessModel> findProcessVersionList(String processId) throws SmartServerRuntimeException;
	
	/**
	 * categoryId로 카테고리에 소속된 배치된 최신 버전의 프로세스를 검색
	 * 
	 * @param categoryId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IProcessModel> findLatestProcessByCategory(String categoryId) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디와 프로세스 버전으로 업무 폼 리스트를 찾는다.
	 * 
	 * @param processId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findFormByProcess(String processId, int version) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 유니크 아이디로 해당 프로세스에 소속된 업무 폼 리스트를 찾는다.
	 * 
	 * @param processUid
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findFormByProcess(String processUid) throws SmartServerRuntimeException;	
	
	/**
	 * 프로세스 아이디로 배치된 최신 버전의 프로세스에 소속된 업무 폼의 배치된 최신 버전을 찾는다.
	 * 
	 * @param processId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findLatestFormByProcess(String processId) throws SmartServerRuntimeException;	
	
	/**
	 * 패키지 아이디로 패키지에 소속된 배치된 최신 버전의 프로세스의 최신 버전의 업무 폼 리스트를 찾는다.
	 * 
	 * @param packageId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findLatestFormByPackage(String packageId) throws SmartServerRuntimeException;
	
	/**
	 * categoryId로 카테고리에 소속된 모든 폼 리스트를 검색 
	 * 
	 * @param categoryId
	 * @param type
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findLatestFormByCategory(String categoryId, String type) throws SmartServerRuntimeException;
	
	/**
	 * 패키지 아이디, 패키지 버전으로 모든 업무 폼 리스트를 찾는다.
	 *  
	 * @param packageId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findFormByPackage(String packageId, int version) throws SmartServerRuntimeException;
	
	/**
	 * 패키지 아이디, 버전으로 패키지에 소속된 단위업무 리스트를 찾는다.
	 * 
	 * @param packageId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findSingleFormByPackage(String packageId, int version) throws SmartServerRuntimeException;
	
	/**
	 * 카테고리별 단위 업무 리스트를 리턴한다.
	 * 
	 * @param categoryID
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findSingleFormList(String categoryId) throws SmartServerRuntimeException;
	
	/**
	 * 지시업무 리스트를 검색한다.
	 * 
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findInstuctFormList() throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디로 배치된 최신 프로세스의 시작 업무 폼을 찾는다.
	 * 
	 * @param processId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findProcessStartForm(String processUid) throws SmartServerRuntimeException;
	
	/**
	 * 프로세스 아이디 및 버전으로 프로세스의 시작 업무 폼을 찾는다.
	 * 
	 * @param processId
	 * @param processVersion
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormModel> findProcessStartForm(String processId, int processVersion) throws SmartServerRuntimeException;
	
	/**
	 * 패키지가 소속된 카테고리 이동
	 * 
	 * @param packageId
	 * @param toCategoryId
	 * @throws SmartServerRuntimeException
	 */
	public void doMovePackageCategory(String packageId, String toCategoryId) throws SmartServerRuntimeException;
	
	/**
	 * 업무 타입 목록 개수를 찾는다.
	 * 
	 * @param condition
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public int searchWorkTypeCount(Map<String, Object> condition) throws SmartServerRuntimeException;
	
	/**
	 * 검색 조건에 맞는 패키지 개수
	 *  
	 * @param condition
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public int searchPackageCount(Map<String, Object> condition) throws SmartServerRuntimeException;
	
	/**
	 * 검색 조건에 맞는 프로세스 개수
	 *  
	 * @param condition
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public int searchProcessCount(Map<String, Object> condition) throws SmartServerRuntimeException;
	
	/**
	 * 검색 조건에 맞는 업무 폼 개수
	 *  
	 * @param condition
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public int searchFormCount(Map<String, Object> condition) throws SmartServerRuntimeException;
	
	/**
	 * 업무 타입을 검색한다.
	 * 
	 * @param condition
	 * @param pageNum
	 * @param countPerPage
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IWorkTypeModelList searchWorkTypeByCondition(Map<String, Object> condition, int pageNum, int countPerPage) throws SmartServerRuntimeException;
	
	/**
	 * 검색 조건에 따라서 업무패키지 조회
	 * 
	 * @param condition
	 * @param orderCondition
	 * @param pageNum
	 * @param countPerPage
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IPackageModelList searchPackageByCondition(Map<String, Object> condition, Map<String, String> orderCondition, int pageNum, int countPerPage) throws SmartServerRuntimeException;	
	
	/**
	 * 검색 조건에 따라서 프로세스 조회
	 * 
	 * @param condition
	 * @param pageNum
	 * @param countPerPage
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IProcessModelList searchProcessByCondition(Map<String, Object> condition, int pageNum, int countPerPage) throws SmartServerRuntimeException;

	/**
	 * 배치된 모든 프로세스의 모든 버전을 조회
	 * 
	 * @param pageNum
	 * @param countPerPage
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IProcessModelList searchDeployedProcess(int pageNum, int countPerPage) throws SmartServerRuntimeException;
	
	/**
	 * 배치된 프로세스 중에서 가장 최신 버전만 조회
	 * 
	 * @param pageNum
	 * @param countPerPage
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IProcessModelList searchLatestDeployedProcess(int pageNum, int countPerPage) throws SmartServerRuntimeException;

	/**
	 * 검색 조건에 따라서 업무 폼 조회
	 * 
	 * @param condition
	 * @param pageNum
	 * @param countPerPage
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IFormModelList searchFormByCondition(Map<String, Object> condition, int pageNum, int countPerPage) throws SmartServerRuntimeException;
	
}
