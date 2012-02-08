package net.smartworks.server.engine.resource.model;

import java.util.Date;

/**
 * 업무 폼 모델
 * <li> 매핑 테이블 : SWForm
 * 
 * @author jhnam
 * @version $Id: IFormModel.java,v 1.1 2011/11/08 03:15:07 kmyu Exp $
 */
public interface IFormModel {

	/**
	 * 체크아웃 상태 - CHECKED-OUT
	 */
	public static final String STATUS_CHECKED_OUT = "CHECKED-OUT";
	/**
	 * 체크인 상태 - CHECKED-IN
	 */
	public static final String STATUS_CHECKED_IN = "CHECKED-IN";
	/**
	 * 배치 - DEPLOYED
	 */
	public static final String STATUS_DEPLOYED = "DEPLOYED";

	/**
	 * 양식
	 */
	public static final String TYPE_NONE = "NONE";
	/**
	 * 정보관리 업무
	 */
	public static final String TYPE_SINGLE = "SINGLE";
	/**
	 * 프로세스 업무
	 */
	public static final String TYPE_PROCESS = "PROCESS";
	
	/**
	 * @return the id
	 */
	public String getId();

	/**
	 * @param id the id to set
	 */
	public void setId(String id);

	/**
	 * @return the packageId
	 */
	public String getPackageId();

	/**
	 * @param packageId the packageId to set
	 */
	public void setPackageId(String packageId);

	/**
	 * @return the formId
	 */
	public String getFormId();

	/**
	 * @param formId the formId to set
	 */
	public void setFormId(String formId);

	/**
	 * @return the version
	 */
	public int getVersion();

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version);

	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * @param name the name to set
	 */
	public void setName(String name);
	
	/**
	 * @return the type
	 */
	public String getType();

	/**
	 * @param type the type to set
	 */
	public void setType(String type);

	/**
	 * @return the status
	 */
	public String getStatus();

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status);
	
	/**
	 * @return the publishMode
	 */
	public String getPublishMode();

	/**
	 * @param publishMode the publishMode to set
	 */
	public void setPublishMode(String publishMode);

	/**
	 * @return the creator
	 */
	public String getCreator();
	
	/**
	 * @return the creatorName
	 */
	public String getCreatorName();

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
	 * @return the creatorName
	 */
	public String getModifierName();
	
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
	 * @return the keyword
	 */
	public String getKeyword();

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword);

	/**
	 * @return the ownerDept
	 */
	public String getOwnerDept();

	/**
	 * @param ownerDept the ownerDept to set
	 */
	public void setOwnerDept(String ownerDept);

	/**
	 * @return the owner
	 */
	public String getOwner();

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner);

	/**
	 * @return the encoding
	 */
	public String getEncoding();

	/**
	 * @param encoding the encoding to set
	 */
	public void setEncoding(String encoding);

	/**
	 * @return the description
	 */
	public String getDescription();

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description);

	/**
	 * @return the content
	 */
	public String getContent();

	/**
	 * @param content the content to set
	 */
	public void setContent(String content);
	
}
