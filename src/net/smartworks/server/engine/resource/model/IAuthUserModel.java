package net.smartworks.server.engine.resource.model;

/**
 * 권한 사용자 모델
 * <li> 매핑 테이블 : SWAuthUser
 * 
 * @author jhnam
 * @version $Id: IAuthUserModel.java,v 1.1 2011/11/08 03:15:09 kmyu Exp $
 */
public interface IAuthUserModel {
	
	/**
	 * DEPT 타입
	 */
	public static final String TYPE_DEPT = "DEPT";
	/**
	 * USER 타입
	 */
	public static final String TYPE_USER = "USER";
	
	/**
	 * @return the id
	 */
	public String getId();
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id);
	
	/**
	 * @return the resourceId
	 */
	public String getResourceId();
	
	/**
	 * @param resourceId the resourceId to set
	 */
	public void setResourceId(String resourceId);
	
	/**
	 * @return the userId
	 */
	public String getUserId();
	
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId);
	
	/**
	 * @return the type
	 */
	public String getType();
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type);
	
	/**
	 * @return the mode
	 */
	public String getMode();

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode);
	
}
