package net.smartworks.server.engine.resource.model;

/**
 * 프로세스 내용
 * <li> 매핑 테이블 : SWProcess
 * 
 * @author jhnam
 * @version $Id: IProcessContent.java,v 1.1 2011/11/08 03:15:07 kmyu Exp $
 */
public interface IProcessContent {

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
	 * @return the version
	 */
	public int getVersion();

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version);

	/**
	 * @return the processId
	 */
	public String getProcessId();

	/**
	 * @param processId the processId to set
	 */
	public void setProcessId(String processId);
	
	/**
	 * @return the content
	 */
	public String getContent();
	
	/**
	 * @param content the content to set
	 */
	public void setContent(String content);
}
