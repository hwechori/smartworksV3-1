package net.smartworks.server.engine.resource.model;

/**
 * 연락처
 * 
 * @author jhnam
 * @version $Id: IOrgContactModel.java,v 1.1 2011/11/08 03:15:09 kmyu Exp $
 */
public interface IOrgContactModel {

	/**
	 * @return the id
	 */
	public String getId();

	/**
	 * @param id the id to set
	 */
	public void setId(String id);

	/**
	 * @return the name
	 */
	public String getName();

	/**
	 * @param name the name to set
	 */
	public void setName(String name);

	/**
	 * @return the companyId
	 */
	public String getCompanyId();

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId);

	/**
	 * @return the deptId
	 */
	public String getDeptId();

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(String deptId);

	/**
	 * @return the pos
	 */
	public String getPos();

	/**
	 * @param pos the pos to set
	 */
	public void setPos(String pos);

	/**
	 * @return the email
	 */
	public String getEmail();

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email);

	/**
	 * @return the telephone
	 */
	public String getTelephone();

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone);
	
}
