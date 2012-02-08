package net.smartworks.server.engine.resource.manager;


/**
 * SmartServerManager, 각 매니저들을 참조한다.
 */
public class SmartServerManager {

	/**
	 * singleton
	 */
	private static SmartServerManager serverManager;
	/**
	 * 조직 관리 매니저
	 */
	private IOrganizationManager organManager;
	/**
	 * 코드 관리 매니저
	 */
	private ICodeManager codeManager;
	/**
	 * 카테고리 매니저
	 */
	private ICategoryManager categoryManager;
	/**
	 * 리소스 디자인타임 매니저
	 */
	private IResourceDesigntimeManager resourceDesigntimeManager;
	/**
	 * 리소스 런타임 매니저
	 */
	private IResourceRuntimeManager resourceRuntimeManager;	
	/**
	 * 도메인 관리 매니저
	 */
	private IDomainManager domainManager;
	/**
	 * 문서 관리 매니저
	 */
	private IDocumentManager documentManager;	

	/**
	 * 권한 관리 매니저
	 */
	private IAuthorityManager authorityManager;
	
	/**
	 * factory method
	 * 
	 * @return
	 */
	public static SmartServerManager createInstance() {
		if(serverManager == null) 
			serverManager = new SmartServerManager();
		
		return serverManager;
	}
	
	/**
	 * singleton
	 * 
	 * @return
	 */
	public static SmartServerManager getInstance() {
		return serverManager;
	}
	
	/**
	 * private constructor
	 */
	private SmartServerManager() {		
	}
	
	/**
	 * @return the organManager
	 */
	public IOrganizationManager getOrganManager() {
		return organManager;
	}

	/**
	 * @param organManager the organManager to set
	 */
	public void setOrganManager(IOrganizationManager organManager) {
		this.organManager = organManager;
	}

	/**
	 * @return the codeManager
	 */
	public ICodeManager getCodeManager() {
		return codeManager;
	}

	/**
	 * @param codeManager the codeManager to set
	 */
	public void setCodeManager(ICodeManager codeManager) {
		this.codeManager = codeManager;
	}
	
	/**
	 * @return the categoryManager
	 */
	public ICategoryManager getCategoryManager() {
		return categoryManager;
	}
	
	/**
	 * @param categoryManager the categoryManager to set
	 */
	public void setCategoryManager(ICategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}
	
	/**
	 * @return the documentManager
	 */
	public IDocumentManager getDocumentManager() {
		return documentManager;
	}
	
	/**
	 * @param documentManager the documentManager to set
	 */
	public void setDocumentManager(IDocumentManager documentManager) {
		this.documentManager = documentManager;
	}
	
	/**
	 * @return the resourceDesignManager
	 */
	public IResourceDesigntimeManager getResourceDesigntimeManager() {
		return resourceDesigntimeManager;
	}

	/**
	 * @param resourceDesignManager the resourceDesignManager to set
	 */
	public void setResourceDesigntimeManager(
			IResourceDesigntimeManager resourceDesigntimeManager) {
		this.resourceDesigntimeManager = resourceDesigntimeManager;
	}

	/**
	 * @return the resourceRuntimeManager
	 */
	public IResourceRuntimeManager getResourceRuntimeManager() {
		return resourceRuntimeManager;
	}

	/**
	 * @param resourceRuntimeManager the resourceRuntimeManager to set
	 */
	public void setResourceRuntimeManager(
			IResourceRuntimeManager resourceRuntimeManager) {
		this.resourceRuntimeManager = resourceRuntimeManager;
	}

	/**
	 * @return the domainManager
	 */
	public IDomainManager getDomainManager() {
		return domainManager;
	}

	/**
	 * @param domainManager the domainManager to set
	 */
	public void setDomainManager(IDomainManager domainManager) {
		this.domainManager = domainManager;
	}

	/**
	 * @return the authorityManager
	 */
	public IAuthorityManager getAuthorityManager() {
		return authorityManager;
	}

	/**
	 * @param authorityManager the authorityManager to set
	 */
	public void setAuthorityManager(IAuthorityManager authorityManager) {
		this.authorityManager = authorityManager;
	}

}
