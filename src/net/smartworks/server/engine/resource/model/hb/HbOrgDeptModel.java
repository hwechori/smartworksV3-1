package net.smartworks.server.engine.resource.model.hb;

import java.io.Serializable;

import net.smartworks.server.engine.resource.model.IOrgDeptModel;
import net.smartworks.server.engine.resource.util.XmlUtil;

/**
 * IOrgDept 하이버네이트
 * 
 * @author jhnam
 * @version $Id: HbOrgDeptModel.java,v 1.1 2011/11/08 03:15:02 kmyu Exp $
 */
public class HbOrgDeptModel implements Serializable, IOrgDeptModel {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 부서 아이디
	 */
	private String id;
	/**
	 * 회사 아이디
	 */
	private String companyId;
	/**
	 * 부서의 부모 아이디
	 */
	private String parentId;
	/**
	 * 부서 타입
	 */
	private String type;
	/**
	 * 부서 이름
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
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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
		
		if(!(obj instanceof HbOrgDeptModel))
			return false;
		
		HbOrgDeptModel model = (HbOrgDeptModel)obj;
		
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
			return XmlUtil.beanToXmlString("Dept", this, this.getClass());
		} catch (Exception e) {
			return "";
		}
	}
	
}
