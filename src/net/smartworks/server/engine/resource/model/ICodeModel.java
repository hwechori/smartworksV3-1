package net.smartworks.server.engine.resource.model;

/**
 * 코드 모델
 * <li> 매핑 테이블 : SWCode
 * 
 * @author jhnam
 * @version $Id: ICodeModel.java,v 1.1 2011/11/08 03:15:08 kmyu Exp $
 */
public interface ICodeModel {

	/**
	 * @return the id
	 */
	public String getId();
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id);
	
	/**
	 * @return the categoryId
	 */
	public String getCategoryId();
	
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId);
	
	/**
	 * @return the code
	 */
	public String getCode();
	
	/**
	 * @param code the code to set
	 */
	public void setCode(String code);
	
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
