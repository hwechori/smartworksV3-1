package net.smartworks.server.engine.resource.model;

/**
 * 조직 - 역할
 * 
 * @author jhnam
 * @version $Id: IOrgRoleModel.java,v 1.1 2011/11/08 03:15:07 kmyu Exp $
 */
public interface IOrgRoleModel {

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
