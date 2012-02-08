package net.smartworks.server.engine.resource.model;

import java.util.Date;

/**
 * 권한 리소스 모델
 * <li> 매핑 테이블 : SWAuthResource
 * 
 * @author jhnam
 * @version $Id: IAuthResourceModel.java,v 1.1 2011/11/08 03:15:10 kmyu Exp $
 */
public interface IAuthResourceModel {

	/**
	 * 전체 공개
	 */
	public static final String PERMISSION_PUB_ALL = "PUB_ALL";	
	/**
	 * 선택 공개
	 */
	public static final String PERMISSION_PUB_SELECT = "PUB_SELECT";
	/**
	 * 비공개 - 사용한 사람 이외에는 비공개
	 */
	public static final String PERMISSION_PUB_NO = "PUB_NO";
	
	/**
	 * 읽기 모드
	 */
	public static final String MODE_READ = "R";
	/**
	 * 쓰기 모드
	 */
	public static final String MODE_WRITE = "W";
	
	/**
	 * @return the id
	 */
	public String getId();
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id);
	
	/**
	 * @return the type
	 */
	public int getType();
	
	/**
	 * @return the resourceId
	 */
	public String getResourceId();

	/**
	 * @param resourceId the resourceId to set
	 */
	public void setResourceId(String resourceId);
	
	/**
	 * @param type the type to set
	 */
	public void setType(int type);
	
	/**
	 * @return the mode
	 */
	public String getMode();

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode);
	
	/**
	 * @return the permission
	 */
	public String getPermission();

	/**
	 * @param permission the permission to set
	 */
	public void setPermission(String permission);
	
	/**
	 * @return the creator
	 */
	public String getCreator();
	
	/**
	 * @param creator the creator to set
	 */
	public void setCreator(String creator);
	
	/**
	 * @return the createdTime
	 */
	public Date getCreatedTime();
	
	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Date createdTime);
	
	/**
	 * @return the modifier
	 */
	public String getModifier();
	
	/**
	 * @param modifier the modifier to set
	 */
	public void setModifier(String modifier);
	
	/**
	 * @return the modifiedTime
	 */
	public Date getModifiedTime();
	
	/**
	 * @param modifiedTime the modifiedTime to set
	 */
	public void setModifiedTime(Date modifiedTime);
	
	/**
	 * @return the name
	 */
	public String getName();
	
	/**
	 * @param name the name to set
	 */	
	public void setName(String name);
}
