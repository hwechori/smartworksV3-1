package net.smartworks.server.engine.resource.model;

/**
 * 의견 모델
 * <li> 매핑 테이블 : SWOrgDept
 * 
 * @author jhnam
 * @version $Id: IOrgDeptModel.java,v 1.1 2011/11/08 03:15:08 kmyu Exp $
 */
public interface IOrgDeptModel {

	/**
	 * 타입 일반 - BASIC
	 */
	public static final String TYPE_BASIC = "BASIC";
	
	/**
	 * @return the id
	 */
	public String getId();
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id);
	
	/**
	 * @return the companyId
	 */
	public String getCompanyId();
	
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId);
	
	/**
	 * @return the parentId
	 */
	public String getParentId();
	
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId);
	
	/**
	 * @return the type
	 */
	public String getType();
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type);
	
	/**
	 * @return the name
	 */
	public String getName();
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name);
	
	/**
	 * @return the description
	 */
	public String getDescription();
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description);
	
}
