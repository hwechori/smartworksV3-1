package net.smartworks.server.engine.resource.manager;

import java.util.List;

import net.smartworks.server.engine.resource.exception.SmartServerRuntimeException;
import net.smartworks.server.engine.resource.model.IAuthResourceModel;
import net.smartworks.server.engine.resource.model.IAuthUserModel;

/**
 * 권한을 관리하는 매니저
 * 
 * @author jhnam
 * @version $Id: IAuthorityManager.java,v 1.1 2011/11/08 03:15:12 kmyu Exp $
 */
public interface IAuthorityManager {

	/**
	 * 권한을 위한 리소스를 생성한다. 사용자까지 생성한다.
	 * 
	 * @param userId
	 * @param resource
	 * @param authUserList
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IAuthResourceModel createResource(String userId, IAuthResourceModel resource, List<IAuthUserModel> authUserList) throws SmartServerRuntimeException;
	
	/**
	 * 권한 리소스를 업데이트한다. 사용자까지 모두 업데이트한다.
	 * 
	 * @param userId
	 * @param resource
	 * @param authUserList
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IAuthResourceModel updateResource(String userId, IAuthResourceModel resource, List<IAuthUserModel> authUserList) throws SmartServerRuntimeException;	
	
	/**
	 * 권한 리소스 유니크 아이디로 권한 리소스를 삭제한다. 권한 사용자까지 모두 삭제
	 * 
	 * @param userId
	 * @param id
	 * @throws SmartServerRuntimeException
	 */
	public void deleteResource(String userId, String id) throws SmartServerRuntimeException;
	
	/**
	 * 리소스 아이디, 읽기/쓰기 모드로 부터 리소스를 삭제한다.
	 * 
	 * @param userId
	 * @param resourceId
	 * @param mode
	 * @throws SmartServerRuntimeException
	 */
	public void deleteResource(String userId, String resourceId, String mode) throws SmartServerRuntimeException;
	
	/**
	 * 리소스 유니크 아이디로 리소스를 조회
	 * 
	 * @param userId
	 * @param id
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IAuthResourceModel retrieveResource(String userId, String id) throws SmartServerRuntimeException;
	
	/**
	 * 리소스 아이디, 권한 (읽기/쓰기) 모드로 리소스를 조회
	 * 
	 * @param userId
	 * @param resourceId
	 * @param mode
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IAuthResourceModel retrieveResource(String userId, String resourceId, String mode) throws SmartServerRuntimeException;	
	
	/**
	 * 리소스 아이디, 읽기/쓰기 모드로 권한 사용자를 검색 
	 * 
	 * @param userId
	 * @param resourceId
	 * @param mode
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IAuthUserModel> findUser(String userId, String resourceId, String mode) throws SmartServerRuntimeException;
	
	/**
	 * 특정 리소스에 권한 유저를 생성한다.
	 * 
	 * @param userId
	 * @param authUser
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IAuthUserModel createUser(String userId, IAuthUserModel authUser) throws SmartServerRuntimeException;
	
	/**
	 * 사용자를 삭제한다.
	 * 
	 * @param userId
	 * @param resourceId
	 * @param mode
	 * @param authUserId
	 * @param userType
	 * @throws SmartServerRuntimeException
	 */
	public void deleteUser(String userId, String resourceId, String mode, String authUserId, String userType) throws SmartServerRuntimeException;
	
	/**
	 * 읽기/쓰기 권한 모드별로 리소스 검색 
	 * 
	 * @param userId
	 * @param mode
	 * @param pageNo
	 * @param recordCount
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IAuthResourceModel> findResource(String userId, String mode, int pageNo, int recordCount) throws SmartServerRuntimeException;
	
	/**
	 * 리소스에 대해서 읽기/쓰기 접근 권한이 userId에게 있는지 여부를 판단
	 * 
	 * @param userId
	 * @param resourceId
	 * @param mode
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public boolean hasAuthority(String userId, String resourceId, String mode) throws SmartServerRuntimeException;
	
}
