package net.smartworks.server.engine.resource.model;

/**
 * 업무 폼 내용
 * <li> 매핑 테이블 : SWForm
 * 
 * @author jhnam
 * @version $Id: IFormContent.java,v 1.1 2011/11/08 03:15:09 kmyu Exp $
 */
public interface IFormContent {

	/**
	 * @return the id
	 */
	public String getId();
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id);
	
	/**
	 * @return the packageId
	 */
	public String getPackageId();

	/**
	 * @param packageId the packageId to set
	 */
	public void setPackageId(String packageId);
	
	/**
	 * @return the formId
	 */
	public String getFormId();

	/**
	 * @param formId the formId to set
	 */
	public void setFormId(String formId);

	/**
	 * @return the version
	 */
	public int getVersion();

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version);
	
	/**
	 * @return the content
	 */
	public String getContent();
	
	/**
	 * @param content the content to set
	 */
	public void setContent(String content);
	
}
