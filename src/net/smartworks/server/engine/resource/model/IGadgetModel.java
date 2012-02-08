package net.smartworks.server.engine.resource.model;

import java.util.Date;

/**
 * 가젯 정보 모델
 * 
 * @author jhnam
 * @version $Id: IGadgetModel.java,v 1.1 2011/11/08 03:15:07 kmyu Exp $
 */
public interface IGadgetModel {
	
	public String getId();
	public void setId(String id);
	
	public String getUserId();
	public void setUserId(String userId);
	
	public String getName();
	public void setName(String name);
	
	public String getType();
	public void setType(String type);
	
	public String getFormId();
	public void setFormId(String formId);
	
	public String getQuery();
	public void setQuery(String query);
	
	public String getClassName();
	public void setClassName(String className);
	
	public String getLocation();
	public void setLocation(String location);
	
	public String getContent();
	public void setContent(String content);
	
	public Date getCreatedTime();
	public void setCreatedTime(Date createdTime);

	public String getEnabledYn();
	public void setEnabledYn(String enabledYn);
	
}
