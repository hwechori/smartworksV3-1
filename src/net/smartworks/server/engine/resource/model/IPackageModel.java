package net.smartworks.server.engine.resource.model;

import java.util.Date;
import java.util.List;


/**
 * 업무패키지 모델
 * <li> 매핑 테이블 : SWPackage
 * 
 * @author jhnam
 * @version $Id: IPackageModel.java,v 1.1 2011/11/08 03:15:08 kmyu Exp $
 */
public interface IPackageModel {
	/**
	 * 개발 중인 상태 - UNDER_DEVEL
	 */
	public static final String STATUS_UNDER_DEVEL = "CHECKED-OUT";	
	/**
	 * 체크인 상태 - CHECKED-IN
	 */
	public static final String STATUS_CHECKED_IN = "CHECKED-IN";	
	/**
	 * 배치된 상태 - DEPLOYED
	 */
	public static final String STATUS_DEPLOYED = "DEPLOYED";
	
	public static final String TYPE_PROCESS = "PROCESS";
	public static final String TYPE_SINGLE = "SINGLE";
	public static final String TYPE_GANTT = "GANTT";
	
	public String getId();
	public void setId(String id);
	
	public String getPackageId();
	public void setPackageId(String packageId);
	
	public int getVersion();
	public void setVersion(int version);
	
	public String getStatus();
	public void setStatus(String status);
	
	public String getLatestDeployedYn();
	public void setLatestDeployedYn(String latestDeployedYn);
	
	public String getCategoryId();
	public void setCategoryId(String categoryId);
	
	public String getName();
	public void setName(String name);
	
	public String getType();
	public void setType(String type);
	
	public Date getCreatedTime();
	public void setCreatedTime(Date createdTime);

	public String getCreator();
	public void setCreator(String creator);
	public String getCreatorName();
	
	public String getModifier();
	public void setModifier(String modifier);
	public String getModifierName();
	
	public Date getModifiedTime();
	public void setModifiedTime(Date modifiedTime);
	
	public String getDescription();
	public void setDescription(String description);
	
	public String getContent();
	public void setContent(String content);
	public List<String> getFormContentList();
	public void setFormContentList(List<String> formModelList);
	
}
