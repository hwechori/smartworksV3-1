package net.smartworks.server.engine.resource.manager.impl;

import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.resource.dao.IResourceRuntimeDao;
import net.smartworks.server.engine.resource.exception.SmartServerRuntimeException;
import net.smartworks.server.engine.resource.manager.IResourceRuntimeManager;
import net.smartworks.server.engine.resource.model.IFormModel;
import net.smartworks.server.engine.resource.model.IFormModelList;
import net.smartworks.server.engine.resource.model.IPackageModel;
import net.smartworks.server.engine.resource.model.IPackageModelList;
import net.smartworks.server.engine.resource.model.IProcessModel;
import net.smartworks.server.engine.resource.model.IProcessModelList;
import net.smartworks.server.engine.resource.model.IWorkTypeModel;
import net.smartworks.server.engine.resource.model.IWorkTypeModelList;

/**
 * IResourceRuntimeManager ����
 * 
 * @author jhnam
 * @version $Id: ResourceRuntimeManagerImpl.java,v 1.1 2011/11/08 03:15:16 kmyu Exp $
 */
public class ResourceRuntimeManagerImpl implements IResourceRuntimeManager {

	/**
	 * resourceRuntimeDao
	 */
	private IResourceRuntimeDao resourceRuntimeDao;
	
	/**
	 * @return
	 */
	public IResourceRuntimeDao getResourceRuntimeDao() {
		return this.resourceRuntimeDao;
	}
	
	/**
	 * @param resourceRuntimeDao
	 */
	public void setResourceRuntimeDao(IResourceRuntimeDao resourceRuntimeDao) {
		this.resourceRuntimeDao = resourceRuntimeDao;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#findFormByPackage(java.lang.String, java.lang.String, int)
	 */
	public List<IFormModel> findFormByPackage(String userId, String packageId,
			int version) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.findFormByPackage(packageId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#findFormByProcess(java.lang.String, java.lang.String, int)
	 */
	public List<IFormModel> findFormByProcess(String userId, String processId,
			int version) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.findFormByProcess(processId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#findFormByProcess(java.lang.String, java.lang.String)
	 */
	public List<IFormModel> findFormByProcess(String userId, String processUid)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.findFormByProcess(processUid);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#findLatestFormByPackage(java.lang.String, java.lang.String)
	 */
	public List<IFormModel> findLatestFormByPackage(String userId,
			String packageId) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.findLatestFormByPackage(packageId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#findLatestFormByProcess(java.lang.String, java.lang.String)
	 */
	public List<IFormModel> findLatestFormByProcess(String userId,
			String processId) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.findLatestFormByProcess(processId);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#findSingleFormByPackage(java.lang.String, java.lang.String, int)
	 */
	public List<IFormModel> findSingleFormByPackage(String userId,
			String packageId, int version) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.findSingleFormByPackage(packageId, version);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#findLatestFormByCategory(java.lang.String, java.lang.String, java.lang.String)
	 */
	public List<IFormModel> findLatestFormByCategory(String userId,
			String categoryId, String type) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.findLatestFormByCategory(categoryId, type);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#findSingleFormList(java.lang.String, java.lang.String)
	 */
	public List<IFormModel> findSingleFormList(String userId, String categoryId)
			throws SmartServerRuntimeException {		
		return this.resourceRuntimeDao.findSingleFormList(categoryId);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#findInstuctionForm(java.lang.String)
	 */
	public List<IFormModel> findInstuctFormList(String userId)
			throws SmartServerRuntimeException {		
		return this.resourceRuntimeDao.findInstuctFormList();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#findProcessStartForm(java.lang.String, java.lang.String)
	 */
	public List<IFormModel> findProcessStartForm(String userId,
			String processUid) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.findProcessStartForm(processUid);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#findProcessStartForm(java.lang.String, java.lang.String, int)
	 */
	public List<IFormModel> findProcessStartForm(String userId,
			String processId, int processVersion)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.findProcessStartForm(processId, processVersion);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#findProcessVersionList(java.lang.String, java.lang.String)
	 */
	public List<IProcessModel> findProcessVersionList(String userId,
			String processId) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.findProcessVersionList(processId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#findProcessVersions(java.lang.String, java.lang.String)
	 */
	public List<Integer> findProcessVersions(String userId, String processId)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.findProcessVersions(processId);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#findLatestProcessByCategory(java.lang.String, java.lang.String)
	 */
	public List<IProcessModel> findLatestProcessByCategory(String userId,
			String categoryId) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.findLatestProcessByCategory(categoryId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveForm(java.lang.String, java.lang.String)
	 */
	public IFormModel retrieveForm(String userId, String formUid)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveForm(formUid);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveForm(java.lang.String, java.lang.String, int)
	 */
	public IFormModel retrieveForm(String userId, String formId, int version)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveForm(formId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveFormContent(java.lang.String, java.lang.String)
	 */
	public String retrieveFormContent(String userId, String formUid)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveFormContent(formUid);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveFormContent(java.lang.String, java.lang.String, int)
	 */
	public String retrieveFormContent(String userId, String formId, int version)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveFormContent(formId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveLatestForm(java.lang.String, java.lang.String)
	 */
	public IFormModel retrieveLatestForm(String userId, String formId)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveLatestForm(formId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveLatestFormContent(java.lang.String, java.lang.String)
	 */
	public String retrieveLatestFormContent(String userId, String formId)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveLatestFormContent(formId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveLatestFormVersion(java.lang.String, java.lang.String)
	 */
	public int retrieveLatestFormVersion(String userId, String formId)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveLatestFormVersion(formId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveLatestPackage(java.lang.String, java.lang.String)
	 */
	public IPackageModel retrieveLatestPackage(String userId, String packageId)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveLatestPackage(packageId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveLatestPackageVersion(java.lang.String, java.lang.String)
	 */
	public int retrieveLatestPackageVersion(String userId, String packageId)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveLatestPackageVersion(packageId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveLatestProcess(java.lang.String, java.lang.String)
	 */
	public IProcessModel retrieveLatestProcess(String userId, String processId)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveLatestProcess(processId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveLatestProcessByPackage(java.lang.String, java.lang.String)
	 */
	public IProcessModel retrieveLatestProcessByPackage(String userId,
			String packageId) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveLatestProcessByPackage(packageId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveLatestProcessContent(java.lang.String, java.lang.String)
	 */
	public String retrieveLatestProcessContent(String userId, String processId)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveLatestProcessContent(processId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveLatestProcessVersion(java.lang.String, java.lang.String)
	 */
	public int retrieveLatestProcessVersion(String userId, String processId)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveLatestProcessVersion(processId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrievePackage(java.lang.String, java.lang.String, int)
	 */
	public IPackageModel retrievePackage(String userId, String packageId,
			int version) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrievePackage(packageId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveProcess(java.lang.String, java.lang.String)
	 */
	public IProcessModel retrieveProcess(String userId, String processUid)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveProcess(processUid);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveProcess(java.lang.String, java.lang.String, int)
	 */
	public IProcessModel retrieveProcess(String userId, String processId,
			int version) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveProcess(processId, version);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveProcessByPackage(java.lang.String, java.lang.String, int)
	 */
	public IProcessModel retrieveProcessByPackage(String userId,
			String packageId, int version) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveProcessByPackage(packageId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveProcessContent(java.lang.String, java.lang.String)
	 */
	public String retrieveProcessContent(String userId, String processUid)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveProcessContent(processUid);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveProcessContent(java.lang.String, java.lang.String, int)
	 */
	public String retrieveProcessContent(String userId, String processId,
			int version) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveProcessContent(processId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveWorkType(java.lang.String, java.lang.String)
	 */
	public IWorkTypeModel retrieveWorkType(String userId, String workTypeId)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveWorkType(workTypeId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveWorkTypeByForm(java.lang.String, java.lang.String)
	 */
	public IWorkTypeModel retrieveWorkTypeByForm(String userId, String formUid)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveWorkTypeByForm(formUid);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveWorkTypeByForm(java.lang.String, java.lang.String, int)
	 */
	public IWorkTypeModel retrieveWorkTypeByForm(String userId, String formId,
			int version) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveWorkTypeByForm(formId, version);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#retrieveFormByWorkType(java.lang.String, java.lang.String, int)
	 */	
	public IFormModel retrieveFormByWorkType(String userId, String workTypeId) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.retrieveFormByWorkType(workTypeId);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#doMoveCategory(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void doMovePackageCategory(String userId, String packageId,
			String toCategoryId) throws SmartServerRuntimeException {
		this.resourceRuntimeDao.doMovePackageCategory(packageId, toCategoryId);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#searchDeployedProcess(java.lang.String, int, int)
	 */
	public IProcessModelList searchDeployedProcess(String userId, int pageCount,
			int recordCount) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.searchDeployedProcess(pageCount, recordCount);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#searchFormByCondition(java.lang.String, java.util.Map, int, int)
	 */
	public IFormModelList searchFormByCondition(String userId,
			Map<String, Object> condition, int pageCount, int recordCount)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.searchFormByCondition(condition, pageCount, recordCount);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#searchFormCount(java.lang.String, java.util.Map)
	 */
	public int searchFormCount(String userId, Map<String, Object> condition)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.searchFormCount(condition);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#searchLatestDeployedProcess(java.lang.String, int, int)
	 */
	public IProcessModelList searchLatestDeployedProcess(String userId,
			int pageCount, int recordCount) throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.searchLatestDeployedProcess(pageCount, recordCount);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#searchPackageByCondition(java.lang.String, java.util.Map, java.util.Map, int, int)
	 */
	public IPackageModelList searchPackageByCondition(String userId,
			Map<String, Object> condition, Map<String, String> orderCondition, int pageCount, int recordCount)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.searchPackageByCondition(condition, orderCondition, pageCount, recordCount);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#searchPackageCount(java.lang.String, java.util.Map)
	 */
	public int searchPackageCount(String userId, Map<String, Object> condition)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.searchPackageCount(condition);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#searchProcessByCondition(java.lang.String, java.util.Map, int, int)
	 */
	public IProcessModelList searchProcessByCondition(String userId,
			Map<String, Object> condition, int pageCount, int recordCount)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.searchProcessByCondition(condition, pageCount, recordCount);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#searchProcessCount(java.lang.String, java.util.Map)
	 */
	public int searchProcessCount(String userId, Map<String, Object> condition)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.searchProcessCount(condition);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#searchWorkTypeByCondition(java.lang.String, java.util.Map, int, int)
	 */
	public IWorkTypeModelList searchWorkTypeByCondition(String userId,
			Map<String, Object> condition, int pageCount, int recordCount)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.searchWorkTypeByCondition(condition, pageCount, recordCount);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.api.IResourceRuntimeManager#searchWorkTypeCount(java.lang.String, java.util.Map)
	 */
	public int searchWorkTypeCount(String userId, Map<String, Object> condition)
			throws SmartServerRuntimeException {
		return this.resourceRuntimeDao.searchWorkTypeCount(condition);
	}

}
