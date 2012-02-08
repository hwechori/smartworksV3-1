package net.smartworks.server.engine.resource.model.hb;

import java.io.Serializable;

import net.smartworks.server.engine.resource.model.IFormContent;

/**
 * IFormContent 하이버네이트 구현
 * 
 * @author jhnam
 * @version $Id: HbFormContent.java,v 1.1 2011/11/08 03:15:04 kmyu Exp $
 */
public class HbFormContent implements IFormContent, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 폼 유니크 아이디
	 */
	private String id;
	/**
	 * 패키지 아이디
	 */
	private String packageId;	
	/**
	 * 폼 아이디
	 */
	private String formId;
	/**
	 * 폼 버전
	 */
	private int version;
	/**
	 * 폼 내용
	 */
	private String content;
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormContent#getContent()
	 */
	public String getContent() {
		return this.content;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormContent#getId()
	 */
	public String getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormContent#getPackageId()
	 */
	public String getPackageId() {
		return this.packageId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormContent#getFormId()
	 */
	public String getFormId() {
		return this.formId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormContent#getVersion()
	 */
	public int getVersion() {
		return this.version;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormContent#setContent(java.lang.String)
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormContent#setId(java.lang.String)
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormContent#setPackageId(java.lang.String)
	 */
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormContent#setFormId(java.lang.String)
	 */
	public void setFormId(String formId) {
		this.formId = formId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IFormContent#setVersion(int)
	 */
	public void setVersion(int version) {
		this.version = version;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		
		if(!(obj instanceof HbFormContent))
			return false;
		
		HbFormContent model = (HbFormContent)obj;
		
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
		return this.content;
	}
	
}
