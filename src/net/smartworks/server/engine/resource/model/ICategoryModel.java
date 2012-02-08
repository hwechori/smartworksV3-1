package net.smartworks.server.engine.resource.model;

/**
 * ī�װ? ��
 * <li> ���� ���̺� : SWCategory
 * 
 * @author jhnam
 * @version $Id: ICategoryModel.java,v 1.1 2011/11/08 03:15:10 kmyu Exp $
 */
public interface ICategoryModel {

	/**
	 * @return the id
	 */
	public String getId();
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id);
	
	/**
	 * @return the parentId
	 */
	public String getParentId();
	
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId);
	
	/**
	 * @return the name
	 */
	public String getName();
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name);
	
	/**
	 * @return the dispOrder
	 */
	public int getDispOrder();

	/**
	 * @param dispOrder the dispOrder to set
	 */
	public void setDispOrder(int dispOrder);
	
	/**
	 * @return the description
	 */
	public String getDescription();
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description);
	
}
