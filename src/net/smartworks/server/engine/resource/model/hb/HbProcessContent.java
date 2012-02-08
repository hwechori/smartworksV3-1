package net.smartworks.server.engine.resource.model.hb;

import java.io.Serializable;

import net.smartworks.server.engine.resource.model.IProcessContent;

/**
 * IProcessContent 하이버네이트 구현
 * 
 * @author jhnam
 * @version $Id: HbProcessContent.java,v 1.1 2011/11/08 03:15:03 kmyu Exp $
 */
public class HbProcessContent implements IProcessContent, Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 프로세스 유니크 아이디
	 */
	private String id;
	/**
	 * 패키지 아이디
	 */
	private String packageId;
	/**
	 * 프로세스 버전
	 */
	private int version;
	/**
	 * 프로세스 아이디
	 */
	private String processId;	
	/**
	 * 프로세스 내용
	 */
	private String content;
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IProcessContent#getId()
	 */
	public String getId() {
		return this.id;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IProcessContent#getPackageId()
	 */
	public String getPackageId() {
		return this.packageId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IProcessContent#getProcessId()
	 */
	public String getProcessId() {
		return this.processId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IProcessContent#getVersion()
	 */
	public int getVersion() {
		return this.version;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IProcessContent#getContent()
	 */
	public String getContent() {
		return this.content;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IProcessContent#setId(java.lang.String)
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IProcessContent#setPackageId(java.lang.String)
	 */
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IProcessContent#setProcessId(java.lang.String)
	 */
	public void setProcessId(String processId) {
		this.processId = processId;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IProcessContent#setVersion(int)
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.model.IProcessContent#setContent(java.lang.String)
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
