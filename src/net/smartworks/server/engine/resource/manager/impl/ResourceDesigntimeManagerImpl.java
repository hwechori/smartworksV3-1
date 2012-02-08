package net.smartworks.server.engine.resource.manager.impl;

import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.resource.dao.IResourceDesigntimeDao;
import net.smartworks.server.engine.resource.exception.SmartServerRuntimeException;
import net.smartworks.server.engine.resource.manager.IResourceDesigntimeManager;
import net.smartworks.server.engine.resource.model.IFormDef;
import net.smartworks.server.engine.resource.model.IFormFieldDef;
import net.smartworks.server.engine.resource.model.IFormModel;
import net.smartworks.server.engine.resource.model.IFormModelList;
import net.smartworks.server.engine.resource.model.IPackageModel;
import net.smartworks.server.engine.resource.model.IPackageModelList;
import net.smartworks.server.engine.resource.model.IProcessModel;
import net.smartworks.server.engine.resource.model.IProcessModelList;
import net.smartworks.server.engine.resource.model.IWorkTypeModel;

/**
 * IResourceManager 기본 구현
 * 
 * @version $Id: ResourceDesigntimeManagerImpl.java,v 1.1 2011/11/08 03:15:17 kmyu Exp $
 */
public class ResourceDesigntimeManagerImpl implements IResourceDesigntimeManager {

	/**
	 * resource dao
	 */
	private IResourceDesigntimeDao resourceDesigntimeDao;
	
	/**
	 * @param resourceDao
	 */
	public void setResourceDesigntimeDao(IResourceDesigntimeDao resourceDao) {
		this.resourceDesigntimeDao = resourceDao;
	}
	
	/**
	 * @return
	 */
	public IResourceDesigntimeDao getResourceDesigntimeDao() {
		return this.resourceDesigntimeDao;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#checkInPackage(java.lang.String, java.lang.String, int)
	 */
	public void checkInPackage(String userId, String packageId, int version)
			throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.checkInPackage(userId, packageId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#checkOutPackage(java.lang.String, java.lang.String, int)
	 */
	public void checkOutPackage(String userId, String packageId, int version)
			throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.checkOutPackage(userId, packageId, version);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#checkInForm(java.lang.String, java.lang.String, int)
	 */
	public void checkInForm(String userId, String formId, int version)
			throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.checkInForm(userId, formId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#checkInProcess(java.lang.String, java.lang.String, int)
	 */
	public void checkInProcess(String userId, String processId, int version)
			throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.checkInProcess(userId, processId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#checkOutForm(java.lang.String, java.lang.String, int)
	 */
	public String checkOutForm(String userId, String formId, int version)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.checkOutForm(userId, formId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#checkOutProcess(java.lang.String, java.lang.String)
	 */
	public String checkOutProcess(String userId, String processId, int version)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.checkOutProcess(userId, processId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#createForm(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	public IFormModel createForm(String userId, String packageId, int version, String type,
			String name) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.createForm(userId, packageId, version, type, name);
	}
	public IFormModel createForm(String userId, IFormModel obj) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.createForm(userId, obj);
	}

	public IFormModel cloneForm(String userId, String formId, int version, String toPkgId, int toPkgVer, String newFormName) throws SmartServerRuntimeException {
		return resourceDesigntimeDao.cloneForm(userId, formId, version, toPkgId, toPkgVer, newFormName);
	}

	public IFormModel cloneForm(String userId, String formId, int version, String toPkgId, int toPkgVer) throws SmartServerRuntimeException {
		return resourceDesigntimeDao.cloneForm(userId, formId, version, toPkgId, toPkgVer);
	}

	public IPackageModel clonePackage(String userId, String categoryId, String packageId, int version) throws SmartServerRuntimeException {
		return resourceDesigntimeDao.clonePackage(userId, categoryId, packageId, version);
	}

	public IPackageModel createPackage(String userId, String categoryId, IPackageModel pkg) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.createPackage(userId, categoryId, pkg);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#createPackage(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public IPackageModel createPackage(String userId, String categoryId,
			String type, String name, String desc)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.createPackage(userId, categoryId, type, name, desc);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#createPackage(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public IPackageModel createPackage(String userId, String categoryId,
			String name, String desc) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.createPackage(userId, categoryId, name, desc);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#createProcess(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	public IProcessModel createProcess(String userId, String packageId,
			int version, String name) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.createProcess(userId, packageId, version, name);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#deleteForm(java.lang.String, java.lang.String)
	 */
	public void deleteForm(String userId, String formUid)
			throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.deleteForm(userId, formUid);
		
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#deleteForm(java.lang.String, java.lang.String, int)
	 */
	public void deleteForm(String userId, String formId, int version)
			throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.deleteForm(userId, formId, version);
		
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#deletePackage(java.lang.String, java.lang.String, int)
	 */
	public void deletePackage(String userId, String packageId, int version)
			throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.deletePackage(userId, packageId, version);
		
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#deletePackageAll(java.lang.String, java.lang.String)
	 */
	public void deletePackageAll(String userId, String packageId)
			throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.deletePackageAll(userId, packageId);
		
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#deleteProcess(java.lang.String, java.lang.String)
	 */
	public void deleteProcess(String userId, String processUid)
			throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.deleteProcess(userId, processUid);
		
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#deleteProcess(java.lang.String, java.lang.String, int)
	 */
	public void deleteProcess(String uesrId, String processId, int version)
			throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.deleteProcess(uesrId, processId, version);
		
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#deployPackage(java.lang.String, java.lang.String, int)
	 */
	public void deployPackage(String userId, String companyId, String packageId, int version)
			throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.deployPackage(userId, companyId, packageId, version);
		
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#findWorkType(java.lang.String, java.lang.String, int)
	 */
	public List<IWorkTypeModel> findWorkType(String userId, String packageId,
			int version) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.findWorkType(packageId, version);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#findFormByProcess(java.lang.String, java.lang.String, int)
	 */
	public List<IFormModel> findFormByProcess(String userId, String processId,
			int version) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.findFormByProcess(processId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#findFormByProcess(java.lang.String, java.lang.String)
	 */
	public List<IFormModel> findFormByProcess(String userId, String processUid)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.findFormByProcess(processUid);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#findFormByPackage(java.lang.String, java.lang.String, int)
	 */
	public List<IFormModel> findFormByPackage(String userId, String packageId,
			int version) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.findFormByPackage(packageId, version);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#findSingleFormByPackage(java.lang.String, java.lang.String, int)
	 */
	public List<IFormModel> findSingleFormByPackage(String userId,
			String packageId, int version) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.findSingleFormByPackage(packageId, version);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#findLatestFormByPackage(java.lang.String, java.lang.String)
	 */
	public List<IFormModel> findLatestFormByPackage(String userId,
			String packageId) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.findLatestFormByPackage(packageId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#findLatestFormByProcess(java.lang.String, java.lang.String)
	 */
	public List<IFormModel> findLatestFormByProcess(String userId,
			String processId) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.findLatestFormByProcess(processId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#findFormFieldByPackage(java.lang.String, java.lang.String, int)
	 */
	public List<IFormDef> findFormFieldByPackage(String userId,
			String packageId, int version) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.findFormFieldByPackage(packageId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#findFormFieldByForm(java.lang.String, java.lang.String, boolean)
	 */
	public List<IFormFieldDef> findFormFieldByForm(String userId,
			String formId, boolean deployedCondition)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.findFormFieldByForm(formId, deployedCondition);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#findProcessVersionList(java.lang.String, java.lang.String)
	 */
	public List<IProcessModel> findProcessVersionList(String userId,
			String processId) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.findProcessVersionList(processId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#findProcessVersions(java.lang.String, java.lang.String)
	 */
	public List<Integer> findProcessVersions(String userId, String processId)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.findProcessVersions(processId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#findFormVersions(java.lang.String, java.lang.String)
	 */
	public List<Integer> findFormVersions(String userId, String formId)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.findFormVersions(formId);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveForm(java.lang.String, java.lang.String)
	 */
	public IFormModel retrieveForm(String userId, String formUid)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveForm(formUid);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveForm(java.lang.String, java.lang.String, int)
	 */
	public IFormModel retrieveForm(String userId, String formId, int version)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveForm(formId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveFormContent(java.lang.String, java.lang.String)
	 */
	public String retrieveFormContent(String userId, String formUid)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveFormContent(formUid);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveFormContent(java.lang.String, java.lang.String, int)
	 */
	public String retrieveFormContent(String userId, String formId, int version)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveFormContent(formId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveLatestForm(java.lang.String, java.lang.String)
	 */
	public IFormModel retrieveLatestForm(String userId, String formId)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveLatestForm(formId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveLatestFormContent(java.lang.String, java.lang.String)
	 */
	public String retrieveLatestFormContent(String userId, String formId)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveLatestFormContent(formId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveLatestFormVersion(java.lang.String, java.lang.String)
	 */
	public int retrieveLatestFormVersion(String userId, String formId)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveLatestFormVersion(formId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveLatestPackage(java.lang.String, java.lang.String)
	 */
	public IPackageModel retrieveLatestPackage(String userId, String packageId)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveLatestPackage(packageId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveLatestPackageVersion(java.lang.String, java.lang.String)
	 */
	public int retrieveLatestPackageVersion(String userId, String packageId)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveLatestPackageVersion(packageId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveLatestProcess(java.lang.String, java.lang.String)
	 */
	public IProcessModel retrieveLatestProcess(String userId, String processId)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveLatestProcess(processId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveLatestProcessByPackage(java.lang.String, java.lang.String)
	 */
	public IProcessModel retrieveLatestProcessByPackage(String userId,
			String packageId) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveLatestProcessByPackage(packageId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveLatestProcessContent(java.lang.String, java.lang.String)
	 */
	public String retrieveLatestProcessContent(String userId, String processId)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveLatestProcessContent(processId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveLatestProcessVersion(java.lang.String, java.lang.String)
	 */
	public int retrieveLatestProcessVersion(String userId, String processId)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveLatestProcessVersion(processId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrievePackage(java.lang.String, java.lang.String, int)
	 */
	public IPackageModel retrievePackage(String userId, String packageId,
			int version) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrievePackage(packageId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveProcess(java.lang.String, java.lang.String)
	 */
	public IProcessModel retrieveProcess(String userId, String processUid)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveProcess(processUid);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveProcess(java.lang.String, java.lang.String, int)
	 */
	public IProcessModel retrieveProcess(String userId, String processId,
			int version) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveProcess(processId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveProcessByPackage(java.lang.String, java.lang.String, int)
	 */
	public IProcessModel retrieveProcessByPackage(String userId,
			String packageId, int version) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveProcessByPackage(packageId, version);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveProcessContent(java.lang.String, java.lang.String)
	 */
	public String retrieveProcessContent(String userId, String processUid)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveProcessContent(processUid);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveProcessContent(java.lang.String, java.lang.String, int)
	 */
	public String retrieveProcessContent(String userId, String processId,
			int version) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveProcessContent(processId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveWorkType(java.lang.String, java.lang.String)
	 */
	public IWorkTypeModel retrieveWorkType(String userId, String workTypeId)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveWorkType(workTypeId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveWorkTypeByForm(java.lang.String, java.lang.String)
	 */
	public IWorkTypeModel retrieveWorkTypeByForm(String userId, String formUid)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveWorkTypeByForm(formUid);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#retrieveWorkTypeByForm(java.lang.String, java.lang.String, int)
	 */
	public IWorkTypeModel retrieveWorkTypeByForm(String userId, String formId,
			int version) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.retrieveWorkTypeByForm(formId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#searchLatestPackageList(java.lang.String, java.lang.String)
	 */
	public IPackageModelList searchLatestPackageList(String userId,
			String categoryId) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.searchLatestPackageList(categoryId);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#searchFormByCondition(java.lang.String, java.util.Map, int, int)
	 */
	public IFormModelList searchFormByCondition(String userId,
			Map<String, Object> condition, int pageCount, int recordCount)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.searchFormByCondition(condition, pageCount, recordCount);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#searchFormCount(java.lang.String, java.util.Map)
	 */
	public int searchFormCount(String userId, Map<String, Object> condition)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.searchFormCount(condition);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#searchPackageByCondition(java.lang.String, java.util.Map, int, int)
	 */
	public IPackageModelList searchPackageByCondition(String userId,
			Map<String, Object> condition, Map<String, String> orderCondition, int pageCount, int recordCount)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.searchPackageByCondition(condition, orderCondition, pageCount, recordCount);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#searchPackageCount(java.lang.String, java.util.Map)
	 */
	public int searchPackageCount(String userId, Map<String, Object> condition)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.searchPackageCount(condition);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#searchProcessByCondition(java.lang.String, java.util.Map, int, int)
	 */
	public IProcessModelList searchProcessByCondition(String userId,
			Map<String, Object> condition, int pageCount, int recordCount)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.searchProcessByCondition(condition, pageCount, recordCount);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#searchProcessCount(java.lang.String, java.util.Map)
	 */
	public int searchProcessCount(String userId, Map<String, Object> condition)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.searchProcessCount(condition);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#undeployPackage(java.lang.String, java.lang.String, int)
	 */
	public void undeployPackage(String userId, String packageId, int version)
			throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.undeployPackage(userId, packageId, version);
		
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#updateForm(java.lang.String, com.maninsoft.smart.server.model.IFormModel)
	 */
	public IFormModel updateForm(String userId, IFormModel formModel)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.updateForm(userId, formModel);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#updateFormName(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	public void updateFormName(String userId, String formId, int version, String formName)
			throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.updateFormName(userId, formId, version, formName);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#updateProcessName(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	public void updateProcessName(String userId, String processId, int version,
			String processName) throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.updateProcessName(processId, version, processName);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#updateFormContent(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void updateFormContent(String userId, String formUid,
			String xmlContent) throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.updateFormContent(userId, formUid, xmlContent);
		
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#updateFormContent(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	public void updateFormContent(String userId, String formId, int version,
			String xmlContent) throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.updateFormContent(userId, formId, version, xmlContent);
		
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#updateLatestFormContent(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void updateLatestFormContent(String userId, String formId,
			String xmlContent) throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.updateLatestFormContent(userId, formId, xmlContent);
		
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#updateLatestProcessContent(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void updateLatestProcessContent(String userId, String processId,
			String xmlContent) throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.updateLatestProcessContent(userId, processId, xmlContent);
		
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#updatePackage(java.lang.String, com.maninsoft.smart.server.model.IPackageModel)
	 */
	public IPackageModel updatePackage(String userId, IPackageModel packageModel)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.updatePackage(userId, packageModel);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#updateProcess(java.lang.String, com.maninsoft.smart.server.model.IProcessModel)
	 */
	public IProcessModel updateProcess(String userId, IProcessModel processModel)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.updateProcess(userId, processModel);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#updateProcessContent(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void updateProcessContent(String userId, String processUid,
			String xmlContent) throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.updateProcessContent(userId, processUid, xmlContent);
		
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#updateProcessContent(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	public void updateProcessContent(String userId, String processId,
			int version, String xmlContent) throws SmartServerRuntimeException {
		this.resourceDesigntimeDao.updateProcessContent(userId, processId, version, xmlContent);
		
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceDesigntimeManager#updateWorkType(java.lang.String, com.maninsoft.smart.server.model.IWorkTypeModel)
	 */
	public IWorkTypeModel updateWorkType(String userId, IWorkTypeModel workType)
			throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.updateWorkType(userId, workType);
	}

	public List<IProcessModel> findLatestProcessByCategory(String categoryId) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.findLatestProcessByCategory(categoryId);
	}

	public List<IFormModel> findLatestFormByCategory(String categoryId, String type) throws SmartServerRuntimeException {
		return this.resourceDesigntimeDao.findLatestFormByCategory(categoryId, type);
	}
	
}
