package net.smartworks.server.engine.resource.model.hb;

import java.io.Serializable;

import net.smartworks.server.engine.resource.model.ICategoryModel;
import net.smartworks.server.engine.resource.util.XmlUtil;

/**
 * ICategoryModel 하이버네이트 타입 구현
 * 
 * @author jhnam
 * @version $Id: HbCategoryModel.java,v 1.1 2011/11/08 03:15:02 kmyu Exp $
 */
public class HbCategoryModel implements ICategoryModel, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 카테고리 아이디
	 */
	private String id;
	/**
	 * 부모 카테고리 아이디
	 */
	private String parentId;
	/**
	 * 화면에 표시될 순서
	 */
	private int dispOrder;
	/**
	 * 카테고리 이름
	 */	
	private String name;
	/**
	 * 설명
	 */	
	private String description;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}
	
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the dispOrder
	 */
	public int getDispOrder() {
		return dispOrder;
	}

	/**
	 * @param dispOrder the dispOrder to set
	 */
	public void setDispOrder(int dispOrder) {
		this.dispOrder = dispOrder;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		
		if(!(obj instanceof HbCategoryModel))
			return false;
		
		HbCategoryModel model = (HbCategoryModel)obj;
		
		if(this.id == null || model.getId() == null)
			return false;
		
		if(this.id.equals(model.getId()))
			return true;
		else
			return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public String toString() {
		try {
			return XmlUtil.beanToXmlString("Category", this, this.getClass());
		} catch (Exception e) {
			return "";
		}
	}
	
}
