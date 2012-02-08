package net.smartworks.server.engine.resource.model;

/**
 * 조직 - 회사
 * 
 * @author jhnam
 * @version $Id: IOrgCompanyModel.java,v 1.1 2011/11/08 03:15:09 kmyu Exp $
 */
public interface IOrgCompanyModel {

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
	 * @return the address
	 */
	public String getAddress();

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address);
	
}
