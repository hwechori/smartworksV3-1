package net.smartworks.server.engine.resource.manager;

import java.util.List;

import net.smartworks.server.engine.resource.exception.SmartServerRuntimeException;
import net.smartworks.server.engine.resource.model.ICategoryModel;

/**
 * 카테고리를 관리하는 매니저
 * 
 * @author jhnam
 * @version $Id: ICategoryManager.java,v 1.1 2011/11/08 03:15:12 kmyu Exp $
 */
public interface ICategoryManager {

	/**
	 * 카테고리 루트 이름 - 패키지
	 */
	public static final String CATEGORY_ROOT_NAME_PKG = "_PKG_ROOT_";
	/**
	 * 카테고리 루트 이름 - 코드
	 */
	public static final String CATEGORY_ROOT_NAME_CODE = "_CODE_ROOT_";
	/**
	 * 카테고리 루트 이름 - 문서
	 */
	public static final String CATEGORY_ROOT_NAME_DOCUMENT = "_DOC_ROOT_";
	
	/**
	 * 카테고리 루트 이름 리스트
	 */
	public static final String[] CATEGORY_ROOT_NAMES = {
		CATEGORY_ROOT_NAME_PKG, CATEGORY_ROOT_NAME_CODE, CATEGORY_ROOT_NAME_DOCUMENT
	};
	
	/**
	 * 루트 카테고리를 찾는다. 루트 카테고리는 다른 타입의 카테고리 루트(패키지, 코드 등...)들을 갖는다. 관리 UI를 위해 필요하다.
	 * 
	 * @param userId
	 * @return
	 * @throws SmartServerRuntimeException
	 * @deprecated
	 * 
	 * 삭제될 메서드 이기 때문에 파라미터에 String temp를 추가하여 화면단(jsp)에서 에러를 유도 하여 새로운 API로 변경한다
	 */
	public ICategoryModel retrieveRootCategory(String userId, String temp) throws SmartServerRuntimeException;
	
	/**
	 * 패키지 카테고리 루트를 찾는다.
	 * 
	 * @param userId
	 * @return
	 * @throws SmartServerRuntimeException
	 * @deprecated
	 * 
	 * 삭제될 메서드 이기 때문에 파라미터에 String temp를 추가하여 화면단(jsp)에서 에러를 유도 하여 새로운 API로 변경한다
	 */
	public ICategoryModel retrievePkgRootCategory(String userId, String temp) throws SmartServerRuntimeException;
	
	/**
	 * 코드 카테고리 루트를 찾는다.
	 * 
	 * @param userId
	 * @return
	 * @throws SmartServerRuntimeException
	 * @deprecated
	 * 
	 * 삭제될 메서드 이기 때문에 파라미터에 String temp를 추가하여 화면단(jsp)에서 에러를 유도 하여 새로운 API로 변경한다
	 */
	public ICategoryModel retrieveCodeRootCategory(String userId, String temp) throws SmartServerRuntimeException;
	
	/**
	 * 부모 카테고리를 찾는다.
	 * 
	 * @param userId
	 * @param categoryId
	 * @return
	 * @throws SmartServerRuntimeException
	 * @deprecated
	 * 
	 * 삭제될 메서드 이기 때문에 파라미터에 String temp를 추가하여 화면단(jsp)에서 에러를 유도 하여 새로운 API로 변경한다
	 */
	public ICategoryModel retrieveParentCategory(String userId, String categoryId, String temp) throws SmartServerRuntimeException;
	
	/**
	 * 카테고리 아이디로 카테고리를 찾는다.
	 * 
	 * @param userId
	 * @param categoryId
	 * @return
	 * @throws SmartServerRuntimeException
	 * @deprecated
	 * 
	 * 삭제될 메서드 이기 때문에 파라미터에 String temp를 추가하여 화면단(jsp)에서 에러를 유도 하여 새로운 API로 변경한다
	 */
	public ICategoryModel retrieveCategory(String userId, String categoryId, String temp) throws SmartServerRuntimeException;
	
	/**
	 * 카테고리 아이디로 카테고리 이름을 찾는다.
	 * 
	 * @param userId
	 * @param categoryId
	 * @return
	 * @throws SmartServerRuntimeException
	 * @deprecated
	 * 
	 * 삭제될 메서드 이기 때문에 파라미터에 String temp를 추가하여 화면단(jsp)에서 에러를 유도 하여 새로운 API로 변경한다
	 */
	public String retrieveCategoryName(String userId, String categoryId, String temp) throws SmartServerRuntimeException;

	/**
	 * 카테고리 아이디로 자식 카테고리 리스트를 검색한다.
	 *  
	 * @param userId
	 * @param categoryId
	 * @return
	 * @throws SmartServerRuntimeException
	 * @deprecated
	 * 
	 * 삭제될 메서드 이기 때문에 파라미터에 int temp를 추가하여 화면단(jsp)에서 에러를 유도 하여 새로운 API로 변경한다
	 */
	public List<ICategoryModel> findChildren(String userId, String categoryId, int temp) throws SmartServerRuntimeException;
	/**
	 * 카테고리 아이디로 자식 카테고리 리스트를 검색한다.
	 * disableCategoryId UI에서 비활성 시킬 카테고리 아이디(없다면 null)
	 *  
	 * @param userId
	 * @param categoryId
	 * @return
	 * @throws SmartServerRuntimeException
	 * @deprecated
	 * 
	 * 삭제될 메서드 이기 때문에 파라미터에 String temp를 추가하여 화면단(jsp)에서 에러를 유도 하여 새로운 API로 변경한다
	 */
	public List<ICategoryModel> findChildren(String userId, String categoryId, String disableCategoryId, String temp) throws SmartServerRuntimeException;
	
	/**
	 * 카테고리를 생성한다.
	 * 
	 * @param userId
	 * @param parentCategoryId
	 * @param name
	 * @param desc
	 * @return
	 * @throws SmartServerRuntimeException
	 * @deprecated
	 * 
	 * 삭제될 메서드 이기 때문에 파라미터에 String temp를 추가하여 화면단(jsp)에서 에러를 유도 하여 새로운 API로 변경한다
	 */
	public ICategoryModel createCategory(String userId, String parentCategoryId, String name, String desc, String temp) throws SmartServerRuntimeException;
	
	/**
	 * 카테고리를 생성한다.
	 * 
	 * @param userId
	 * @param category
	 * @return
	 * @throws SmartServerRuntimeException
	 * @deprecated
	 * 
	 * 삭제될 메서드 이기 때문에 파라미터에 String temp를 추가하여 화면단(jsp)에서 에러를 유도 하여 새로운 API로 변경한다
	 */
	public ICategoryModel createCategory(String userId, ICategoryModel category, String temp) throws SmartServerRuntimeException;
	
	/**
	 * 카테고리 이름을 변경한다.
	 * 
	 * @param userId
	 * @param categoryId
	 * @param name 동일한 이름을 가진 카테고리가 존재하면 예외를 던진다.
	 * @param desc 설명 
	 * @return
	 * @throws SmartServerRuntimeException
	 * @deprecated
	 * 
	 * 삭제될 메서드 이기 때문에 파라미터에 String temp를 추가하여 화면단(jsp)에서 에러를 유도 하여 새로운 API로 변경한다
	 */
	public ICategoryModel updateCategory(String userId, String categoryId, String name, String desc, String temp) throws SmartServerRuntimeException;
	
	/**
	 * 카테고리 정보를 업데이트 한다.
	 * 
	 * @param userId
	 * @param category
	 * @return
	 * @throws SmartServerRuntimeException
	 * @deprecated
	 * 
	 * 삭제될 메서드 이기 때문에 파라미터에 String temp를 추가하여 화면단(jsp)에서 에러를 유도 하여 새로운 API로 변경한다
	 */
	public ICategoryModel updateCategory(String userId, ICategoryModel category, String temp) throws SmartServerRuntimeException;
	
	/**
	 * 카테고리 아이디로 카테고리를 삭제한다.
	 * 
	 * @param userId
	 * @param categoryId
	 * @throws SmartServerRuntimeException 카테고리에 소속된 데이터가 하나라도 존재하면 예외를 던진다.
	 * @deprecated
	 * 
	 * 삭제될 메서드 이기 때문에 파라미터에 String temp를 추가하여 화면단(jsp)에서 에러를 유도 하여 새로운 API로 변경한다
	 */
	public void deleteCategory(String userId, String categoryId, String temp) throws SmartServerRuntimeException;

	/**
	 * 카테고리 표시 순서를 바꾼다.
	 * 
	 * @param userId
	 * @param categoryId
	 * @param orderUp true이면 표시 순서를 올리고 false이면 내린다.
	 * @throws SmartServerRuntimeException
	 * @deprecated
	 * 
	 * 삭제될 메서드 이기 때문에 파라미터에 String temp를 추가하여 화면단(jsp)에서 에러를 유도 하여 새로운 API로 변경한다
	 */
	public void doReorderCategory(String userId, String categoryId, boolean orderUp, String temp) throws SmartServerRuntimeException;
	
}
