package net.smartworks.server.engine.resource.manager;

import java.util.List;

import net.smartworks.server.engine.resource.exception.SmartServerRuntimeException;
import net.smartworks.server.engine.resource.model.IOrgCompanyModel;
import net.smartworks.server.engine.resource.model.IOrgContactModel;
import net.smartworks.server.engine.resource.model.IOrgDeptModel;
import net.smartworks.server.engine.resource.model.IOrgRoleModel;
import net.smartworks.server.engine.resource.model.IOrgUserModel;

/**
 * 조직을 관리하는 매니저
 * 
 * @author jhnam
 * @version $Id: IOrganizationManager.java,v 1.1 2011/11/08 03:15:12 kmyu Exp $
 */
public interface IOrganizationManager {

	/**
	 * 연락처 조회
	 * 
	 * @param userId
	 * @param contactId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IOrgContactModel retrieveContact(String userId, String contactId) throws SmartServerRuntimeException;
	
	/**
	 * 연락처 생성
	 * 
	 * @param userId
	 * @param contact
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IOrgContactModel createContact(String userId, IOrgContactModel contact) throws SmartServerRuntimeException;
	
	/**
	 * 연락처 정보 갱신
	 * 
	 * @param userId
	 * @param contact
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IOrgContactModel updateContact(String userId, IOrgContactModel contact) throws SmartServerRuntimeException;
	
	/**
	 * 연락처 삭제
	 * 
	 * @param userId
	 * @param contactId
	 * @throws SmartServerRuntimeException
	 */
	public void deleteContact(String userId, String contactId) throws SmartServerRuntimeException;
	
	/**
	 * 회사 조회
	 * 
	 * @param userId
	 * @param companyId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IOrgCompanyModel retrieveCompany(String userId, String companyId) throws SmartServerRuntimeException;
	
	/**
	 * 회사 생성
	 * 
	 * @param userId
	 * @param company
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IOrgCompanyModel createCompany(String userId, IOrgCompanyModel company) throws SmartServerRuntimeException;
	
	/**
	 * 회사 정보 갱신
	 * 
	 * @param userId
	 * @param company
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IOrgCompanyModel updateCompany(String userId, IOrgCompanyModel company) throws SmartServerRuntimeException;
	
	/**
	 * 회사 삭제
	 * 
	 * @param userId
	 * @param companyId
	 * @throws SmartServerRuntimeException
	 */
	public void deleteCompany(String userId, String companyId) throws SmartServerRuntimeException;
	
	/**
	 * 회사 검색
	 * 
	 * @param userId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IOrgCompanyModel> findAllCompany(String userId) throws SmartServerRuntimeException;
	
	/**
	 * 역할 조회
	 * 
	 * @param userId
	 * @param roleId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IOrgRoleModel retrieveRole(String userId, String roleId) throws SmartServerRuntimeException;
	
	/**
	 * 역할 생성
	 * 
	 * @param userId
	 * @param role
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IOrgRoleModel createRole(String userId, IOrgRoleModel role) throws SmartServerRuntimeException;
	
	/**
	 * 역할 정보 갱신
	 * 
	 * @param userId
	 * @param role
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IOrgRoleModel updateRole(String userId, IOrgRoleModel role) throws SmartServerRuntimeException;
	
	/**
	 * 역할 삭제
	 * 
	 * @param userId
	 * @param roleId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public void deleteRole(String userId, String roleId) throws SmartServerRuntimeException;
	
	/**
	 * 역할 검색
	 * 
	 * @param userId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IOrgRoleModel> findAllRole(String userId) throws SmartServerRuntimeException;
	
	/**
	 * 루트 부서를 생성한다.
	 * 
	 * @param userId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IOrgDeptModel retrieveRootDept(String userId) throws SmartServerRuntimeException;
	
	/**
	 * 부서 아이디로 부서를 찾는다.
	 * 
	 * @param userId
	 * @param deptId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IOrgDeptModel retrieveDept(String userId, String deptId) throws SmartServerRuntimeException;
	
	/**
	 * 부서를 생성한다.
	 * 
	 * @param userId
	 * @param dept
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IOrgDeptModel createDept(String userId, IOrgDeptModel dept) throws SmartServerRuntimeException;
	
	/**
	 * 부서를 업데이트한다.
	 * 
	 * @param userId
	 * @param dept
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IOrgDeptModel updateDept(String userId, IOrgDeptModel dept) throws SmartServerRuntimeException;

	/**
	 * 부서를 삭제한다.
	 * 
	 * @param userId
	 * @param deptId
	 * @throws SmartServerRuntimeException
	 */
	public void deleteDept(String userId, String deptId) throws SmartServerRuntimeException;
	
	/**
	 * 부서로 자식 부서를 찾는다.
	 * 
	 * @param userId
	 * @param parentId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IOrgDeptModel> findChildDept(String userId, String parentId) throws SmartServerRuntimeException;

	/**
	 * 사용자 아이디로 사용자를 찾는다.
	 * 
	 * @param userId
	 * @param id
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IOrgUserModel retrieveUser(String userId, String id) throws SmartServerRuntimeException;
	
	/**
	 * 사용자를 생성한다.
	 * 
	 * @param userId
	 * @param user
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IOrgUserModel createUser(String userId, IOrgUserModel user) throws SmartServerRuntimeException;
	
	/**
	 * 사용자를 업데이트한다.
	 * 
	 * @param userId
	 * @param user
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public IOrgUserModel updateUser(String userId, IOrgUserModel user) throws SmartServerRuntimeException;
	
	/**
	 * 사용자를 삭제한다.
	 * 
	 * @param userId
	 * @param id
	 * @throws SmartServerRuntimeException
	 */
	public void deleteUser(String userId, String id) throws SmartServerRuntimeException;
	
	/**
	 * 부서에 소속된 사용자를 찾는다.
	 * 
	 * @param userId
	 * @param deptId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public List<IOrgUserModel> findUserByDept(String userId, String deptId) throws SmartServerRuntimeException;
	
	/**
	 * userId의 화면 표시 이름을 찾아 리턴한다.
	 * 
	 * @param userId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String getUserDispName(String userId) throws SmartServerRuntimeException;
	
	/**
	 * 로고 이름을 리턴한다.
	 * 
	 * @param userId
	 * @return
	 * @throws SmartServerRuntimeException
	 */
	public String retrieveLogo(String userId) throws SmartServerRuntimeException;
	
	/**
	 * 로고를 업데이트한다.
	 * 
	 * @param userId
	 * @param pictureName
	 * @throws SmartServerRuntimeException
	 */
	public void updateLogo(String userId, String pictureName) throws SmartServerRuntimeException;
	
}
