package net.smartworks.server.engine.resource.manager;

import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.resource.exception.SmartServerRuntimeException;
import net.smartworks.server.engine.resource.model.ICodeModel;

/**
 * 코드를 관리하는 매니저
 * 
 * @author jhnam
 * @version $Id: ICodeManager.java,v 1.1 2011/11/08 03:15:12 kmyu Exp $
 */
public interface ICodeManager {

	/**
	 * 한국어
	 */
	public static final String LANG_KOR = "KOR";
	/**
	 * 영
	 */
	public static final String LANG_ENG = "ENG";
	
	/**
	 * 프로세스 상태 코드 카테고리 - PROCESS_STATUS_CODE
	 */
	public static final String SYS_CATEGORY_PROCESS_STATUS = "PROCESS_STATUS_CODE";	
	/**
	 * 워크 상태 코드 카테고리 - WORK_STATUS_CODE
	 */
	public static final String SYS_CATEGORY_WORK_STATUS = "WORK_STATUS_CODE";
	
	/**
	 * 코드 생성
	 * 
	 * @param userId
	 * @param categoryId
	 * @param code
	 * @param name
	 * @param dispOrder
	 * @param description
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public ICodeModel createCode(String userId, String categoryId, String code, String name, int dispOrder, String description) throws SmartServerRuntimeException;
	
	/**
	 * 코드 업데이트
	 * 
	 * @param userId
	 * @param code
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public ICodeModel updateCode(String userId, ICodeModel code) throws SmartServerRuntimeException;
	
	/**
	 * 카테고리 아이디로 코드 찾기
	 * 
	 * @param userId
	 * @param categoryId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<ICodeModel> findCode(String userId, String categoryId) throws SmartServerRuntimeException;
	
	/**
	 * 코드 삭제
	 * 
	 * @param userId
	 * @param id
	 * @throws SmartServerRuntimeException
	 */
	public void deleteCode(String userId, String id) throws SmartServerRuntimeException;
	
	/**
	 * 아이디로 코드 조회
	 * 
	 * @param userId
	 * @param id
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public ICodeModel retrieveCode(String userId, String id) throws SmartServerRuntimeException;
	
	/**
	 * 카테고리 아이디, 코드로 코드 조회
	 * 
	 * @param userId
	 * @param categoryId
	 * @param code
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public ICodeModel retrieveCode(String userId, String categoryId, String code) throws SmartServerRuntimeException;
	
	/**
	 * 시스템 코드 맵을 검색
	 * 
	 * @param userId
	 * @param categoryId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public Map<String, String> findSystemCode(String categoryId) throws SmartServerRuntimeException;
	
	/**
	 * 카테고리 아이디, 코드로 코드명을 검색
	 * 
	 * @param categoryId
	 * @param code
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String getCodeName(String categoryId, String code) throws SmartServerRuntimeException;
	
	/**
	 * 국제화를 위한 메소드,
	 * id, langType에 따른 언어 이름을 리턴한다.
	 * 
	 * @param id
	 * @param langType
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String getLangName(String id, String langType) throws SmartServerRuntimeException;
	
}
