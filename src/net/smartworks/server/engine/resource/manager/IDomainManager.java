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
	 * 폼 아이디, xml 컨텐트를 받아 폼을 배치한다.
	 * 데이터 필드를 추출하여 관련 DAO로 넘긴다.
	 * 
	 * @param userId
	 * @param formDef
	 * @throws SmartServerRuntimeException
	 */
	public void deployDomain(String companyId, String userId, IFormDef formDef) throws SmartServerRuntimeException;
	
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
	 * 도메인 배치해제
	 * 
	 * @param userId
	 * @param formId
	 * @param formVersion
	 * @throws SmartServerRuntimeException
	 */
	public void undeployDomain(String userId, String formId, int formVersion) throws SmartServerRuntimeException;
	
	/**
	 * 패키지 아이디, 버전으로 도메인 배치해제
	 * 
	 * @param userId
	 * @param packageId
	 * @param version
	 * @throws SmartServerRuntimeException
	 */
	public void undeployDomainByPackage(String userId, String packageId, int version) throws SmartServerRuntimeException;
	
	/**
	 * 도메인 아이디, 레코드 아이디로 도메인 데이터를 찾는다.
	 * 
	 * @param userId
	 * @param domainId
	 * @param recordId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IDomainRecordData retrieveDomainRecord(String userId, String domainId, String recordId) throws SmartServerRuntimeException;
	
	/**
	 * 워크아이템 아이디로 부터 도메인 데이터 레코드를 찾아 리턴한다.
	 * 
	 * @param userId
	 * @param workItemId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IDomainRecordData retieveDomainRecordByWorkItemId(String userId, String workItemId) throws SmartServerRuntimeException;
	
	/**
	 * 폼 아이디, 레코드 아이디로 부터 도메인 데이터 레코드를 찾아 리턴한다.
	 * 
	 * @param userId
	 * @param formId
	 * @param recordId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IDomainRecordData retrieveDomainRecordByRecordId(String userId, String formId, String recordId) throws SmartServerRuntimeException;	
	
	/**
	 * 폼 아이디, 레코드 아이디로 해당 레코드의 제목에 해당하는 값을 조회
	 * 
	 * @param userId
	 * @param formId
	 * @param recordId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public Object retrieveDomainRecordTitle(String userId, String formId, String recordId) throws SmartServerRuntimeException;
	
	/**
	 * 도메인 데이터 레코드를 저장한다.
	 * 
	 * @param userId
	 * @param record
	 * @throws SmartServerRuntimeException
	 */
	public void createDomainRecord(String userId, IDomainRecordData record) throws SmartServerRuntimeException;
	
	/**
	 * 도메인 데이터 레코드를 업데이트한다.
	 * 
	 * @param userId
	 * @param record
	 * @throws SmartServerRuntimeException
	 */
	public void updateDomainRecord(String userId, IDomainRecordData record) throws SmartServerRuntimeException;
	
	/**
	 * 워크아이템 아이디와 관련된 도메인 데이터 레코드를 삭제한다.
	 * 
	 * @param userId
	 * @param workItemId
	 * @throws SmartServerRuntimeException
	 */
	public void deleteDomainRecord(String userId, String workItemId) throws SmartServerRuntimeException;
	
	/**
	 * recordId, formId로 도메인 레코드를 삭제한다.
	 * 
	 * @param userId
	 * @param formId
	 * @param recordId
	 * @throws SmartServerRuntimeException
	 */
	public void deleteDomainRecord(String userId, String formId, String recordId) throws SmartServerRuntimeException;
	
	/**
	 * 패키지 아이디, 버전으로 모든 폼을 찾아 폼에 속한 필드를 찾는다. 
	 * 
	 * @param userId
	 * @param packageId
	 * @param version
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormDef> findFormFieldByPackage(String userId, String packageId, int version) throws SmartServerRuntimeException;
	
	/**
	 * 폼 아이디로 폼 필드 리스트를 찾는다.
	 * 
	 * @param userId
	 * @param formId
	 * @param deployedCondition 배포된 검색 조건만 원할 경우 true
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IFormFieldDef> findFormFieldByForm(String userId, String formId, boolean deployedCondition) throws SmartServerRuntimeException;
	
	/**
	 * 폼 아이디로 도메인 레코드를 찾는다.
	 * 
	 * @param userId
	 * @param formId
	 * @param pageCount
	 * @param recordCount
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IDomainRecordDataList findRecordByFormId(String userId, String formId, int pageCount, int recordCount) throws SmartServerRuntimeException;
	
	/**
	 * 테이블 이름으로 도메인 레코드를 찾는다.
	 * 
	 * @param userId
	 * @param tableName
	 * @param formId
	 * @param pageCount
	 * @param recordCount
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IDomainRecordDataList findRecordByTableName(String userId, String tableName, String formId, int pageCount, int recordCount) throws SmartServerRuntimeException;
	
	/**
	 * 폼 아이디의 폼에 소속된 도메인 데이터 중에서 레코드 아이디가 recordId이고 필드 아이디가 formFieldId인 데이터를 검색
	 * 
	 * @param userId
	 * @param formId
	 * @param recordId
	 * @param formFieldId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public Object retrieveSelectedDomainData(String userId, String formId, String recordId, String formFieldId) throws SmartServerRuntimeException;
	
	/**
	 * 폼 전체 정보를 조회한다.
	 * 
	 * @param userId
	 * @param formId
	 * @param searchCond
	 * @param orderCond
	 * @param pageCount
	 * @param recordCount
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IDomainRecordDataList searchDomainRecord(String userId, String formId, Map<String, String[]> searchCond, Map<String, Object> orderCond, int pageCount, int recordCount) throws SmartServerRuntimeException;
	
	/**
	 * 도메인 아이디로 도메인 조회
	 * 
	 * @param userId
	 * @param domainId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IDomain retrieveDomain(String userId, String domainId) throws SmartServerRuntimeException;
	
	/**
	 * 시스템 테이블 이름으로 시스템 도메인을 찾는다.
	 * 
	 * @param userId
	 * @param systemTableName
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IDomain retrieveSystemDomain(String userId, String systemTableName) throws SmartServerRuntimeException;
	
	/**
	 * 폼 아이디로 도메인 조회
	 * 
	 * @param userId
	 * @param formId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IDomain retrieveDomainByForm(String userId, String formId) throws SmartServerRuntimeException;
	
	/**
	 * 도메인 아이디로 도메인 필드 리스트를 검색
	 * 
	 * @param userId
	 * @param domainId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IDomainField> findDomainFieldList(String userId, String domainId) throws SmartServerRuntimeException;
	
	/**
	 * 모든 도메인 정보 검색
	 * 
	 * @param userId
	 * @param condition
	 * @param pageCount
	 * @param recordCount
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IDomainList searchDomainByCondition(String userId, Map<String, Object> condition, int pageCount, int recordCount) throws SmartServerRuntimeException;
	
	/**
	 * 폼 아이디, 버전, 필터 조건으로 도메인 데이터 레코드를 검색한다.
	 * 
	 * @param userId
	 * @param formId
	 * @param version
	 * @param mappingId
	 * @param filter
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IDomainRecordData> findMappingRecord(String userId, String formId, int version, String mappingId, IDomainRecordData filter) throws SmartServerRuntimeException;
	
	/**
	 * 매핑 레코드를 내보내기(write)한다.
	 * 
	 * @param userId
	 * @param form
	 * @param record
	 * @throws SmartServerRuntimeException
	 */
	public void exportMappingRecord(String userId, IFormDef form, IDomainRecordData record) throws SmartServerRuntimeException;
	
	/**
	 * 필드 뷰 정보를 업데이트한다.
	 * 
	 * @param fieldViewList
	 */
	public void updateDomainFieldView(List<IDomainFieldView> fieldViewList);
	
	/**
	 * 폼 아이디로 필드 뷰 정보를 검색
	 * 
	 * @param formId
	 * @return
	 */
	public List<IDomainFieldView> findDomainFieldViewList(String formId);
	
	/**
	 * 도메인을 업데이트한다.
	 * 
	 * @param userId
	 * @param domain
	 */
	public void updateDomain(String userId, IDomain domain);
	
	/**
	 * formId에 해당하는 폼과 관련된 데이터 목록에서 searchWord로 데이터를 통합검색한다.
	 * 
	 * @param formId
	 * @param searchWord
	 * @param pageCount
	 * @param recordCount
	 * @return
	 */
	public IDomainRecordDataList searchRecordBySearchWord(String formId, String searchWord, int pageCount, int recordCount);
	
	/**
	 * 가젯 모델로 부터 쿼리를 추출한다.
	 * 
	 * @param gadget
	 */
	public void createQueryFromGadget(IGadgetModel gadget);
	
	/**
	 * 차트 가젯의 정보로 부터 xml 데이터를 생성하여 리턴
	 * 
	 * @param userId
	 * @param gadget
	 */
	public String createGadgetData(String userId, String gadgetId);

	/**
	 * 기본 차트 (업무 처리 건수/업무 지연 건수) 데이터를 생성하여 리턴
	 * 
	 * @param userId
	 * @param basicType
	 * @param formId
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	public String createBasicGadgetData(String userId, String basicType, String formId, String fromDate, String toDate);
	
	/**
	 * 가젯 아이디로 그리드 데이터를 찾는다.
	 * 
	 * @param gadgetId
	 * @return
	 * @deprecated
	 */
	public List<IDomainRecordData> getGadgetGridData(String gadgetId);

	/**
	 * 가젯 아이디로 가젯 사이즈를 구한다.
	 * 
	 * @param gadgetId
	 * @return
	 */
	public long getGadgetGridDataSize(String gadgetId) ;
	
	/**
	 * 가젯 아이디로 그리드 데이터를 찾는다.(페이징)
	 * 
	 * @param gadgetId
	 * @return
	 */
	public List<IDomainRecordData> getGadgetGridData(String gadgetId, int pageNo, int pageSize);
	
	
	/**
	 * formId, formFieldId의 필드 뷰 순서를 올리거나 내린다.
	 * 
	 * @param userId
	 * @param formId
	 * @param formFieldId
	 * @param orderUp true이면 순서를 올린다.
	 */
	public void doReorderField(String userId, String formId, String formFieldId, boolean orderUp);
	
}
