package net.smartworks.server.engine.resource.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.smartworks.server.engine.common.model.SmartServerConstant;
import net.smartworks.server.engine.resource.dao.IResourceRuntimeDao;
import net.smartworks.server.engine.resource.exception.SmartServerRuntimeException;
import net.smartworks.server.engine.resource.model.ICategoryModel;
import net.smartworks.server.engine.resource.model.IFormContent;
import net.smartworks.server.engine.resource.model.IFormModel;
import net.smartworks.server.engine.resource.model.IFormModelList;
import net.smartworks.server.engine.resource.model.IPackageModel;
import net.smartworks.server.engine.resource.model.IPackageModelList;
import net.smartworks.server.engine.resource.model.IProcessContent;
import net.smartworks.server.engine.resource.model.IProcessModel;
import net.smartworks.server.engine.resource.model.IProcessModelList;
import net.smartworks.server.engine.resource.model.IWorkTypeModel;
import net.smartworks.server.engine.resource.model.IWorkTypeModelList;
import net.smartworks.server.engine.resource.model.enums.FormFieldEnum;
import net.smartworks.server.engine.resource.model.enums.PackageFieldEnum;
import net.smartworks.server.engine.resource.model.enums.ProcessFieldEnum;
import net.smartworks.server.engine.resource.model.enums.WorkTypeFieldEnum;
import net.smartworks.server.engine.resource.model.hb.HbFormContent;
import net.smartworks.server.engine.resource.model.hb.HbFormModel;
import net.smartworks.server.engine.resource.model.hb.HbFormModelList;
import net.smartworks.server.engine.resource.model.hb.HbPackageModelList;
import net.smartworks.server.engine.resource.model.hb.HbProcessModelList;
import net.smartworks.server.engine.resource.model.hb.HbWorkTypeModel;
import net.smartworks.server.engine.resource.model.hb.HbWorkTypeModelList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * IResourceRuntimeDao 하이버네이트 구현
 * 
 * @author jhnam
 * @version $Id: HbResourceRuntimeDaoImpl.java,v 1.1 2011/11/08 03:15:23 kmyu Exp $
 */
public class HbResourceRuntimeDaoImpl extends HibernateDaoSupport implements IResourceRuntimeDao {

	@Autowired
	public void anyMethod(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#findFormByPackage(java.lang.String, int)
	 */
	public List<IFormModel> findFormByPackage(String packageId, int version)
			throws SmartServerRuntimeException {
		
		String hql = "from HbFormModel where packageId = :packageId and version =:version";
		Query query = this.getSession().createQuery(hql);
		query.setString("packageId", packageId);
		query.setInteger("version", version);
		return query.list();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#findFormByProcess(java.lang.String, int)
	 */
	public List<IFormModel> findFormByProcess(String processId, int version) throws SmartServerRuntimeException {
		
		// 프로세스에 소속된 폼만을 찾는다. 같은 패키지에 소속되어 있으면서 프로세스에 소속되지 않은 폼도 있다.
		StringBuffer hql = new StringBuffer("from HbFormModel where type = :type and version = :version and packageId = ");
		hql.append("(select packageId from HbProcessModel where processId = :processId and version = :version)");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString("type", IFormModel.TYPE_PROCESS);
		query.setInteger("version", version);
		query.setString("processId", processId);
		List<IFormModel> formList = query.list();
		return formList;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#findFormByProcess(java.lang.String)
	 */
	public List<IFormModel> findFormByProcess(String processUid) throws SmartServerRuntimeException {
		// 프로세스에 소속된 폼만을 찾는다. 같은 패키지에 소속되어 있으면서 프로세스에 소속되지 않은 폼도 있다.
		StringBuffer hql = new StringBuffer("from HbFormModel where type = :type and packageId = ");
		hql.append("(select packageId from HbProcessModel where id = :processUid)");
		hql.append(" and version = ");
		hql.append("(select version from HbProcessModel where id = :processUid)");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString("type", IFormModel.TYPE_PROCESS);
		query.setString("processUid", processUid);
		List<IFormModel> formList = query.list();
		return formList;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#findLatestFormByPackage(java.lang.String)
	 */
	public List<IFormModel> findLatestFormByPackage(String packageId) throws SmartServerRuntimeException {
		StringBuffer hql = new StringBuffer("from HbFormModel where packageId = :packageId and version = ");
		hql.append("(select max(version) from HbPackageModel where packageId = :packageId and status = :status)");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString("packageId", packageId);
		query.setString("status", IPackageModel.STATUS_DEPLOYED);
		return query.list();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#findLatestFormByProcess(java.lang.String)
	 */
	public List<IFormModel> findLatestFormByProcess(String processId) throws SmartServerRuntimeException {
		// 프로세스에 소속된 폼만을 찾는다. 같은 패키지에 소속되어 있으면서 프로세스에 소속되지 않은 폼도 있다.
		IProcessModel prc = this.retrieveLatestProcess(processId);
		int version = prc.getVersion();
		StringBuffer hql = new StringBuffer("from HbFormModel where type = :type and version = :version and packageId = ");
		hql.append("(select packageId from HbProcessModel where processId = :processId and version = :version)");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString("type", IFormModel.TYPE_PROCESS);
		query.setInteger("version", version);
		query.setString("processId", processId);
		List<IFormModel> formList = query.list();
		return formList;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#findLatestFormByCategory(java.lang.String, java.lang.String)
	 */
	public List<IFormModel> findLatestFormByCategory(String categoryId, String type) throws SmartServerRuntimeException {
		StringBuffer hql = new StringBuffer("from HbFormModel frm, HbPackageModel pkg where pkg.categoryId = :categoryId");
		hql.append(" and frm.packageId = pkg.packageId and frm.version = pkg.version and frm.type = :type");
		hql.append(" and pkg.latestDeployedYn = :latestDeployedYn");
		hql.append(" order by frm.name");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString("categoryId", categoryId);
		query.setString("type", type);
		query.setString("latestDeployedYn", SmartServerConstant.YES_NO_Y_VALUE);
		List<Object[]> result = query.list();
		List<IFormModel> frmList = new ArrayList<IFormModel>();
		if(result != null && !result.isEmpty()) {
			for(Object[] obj : result) {
				IFormModel frmModel = (IFormModel)obj[0];
				frmList.add(frmModel);
			}
		}
		return frmList;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#findSingleFormByPackage(java.lang.String, int)
	 */
	public List<IFormModel> findSingleFormByPackage(String packageId, int version) throws SmartServerRuntimeException {
		String hql = "from HbFormModel where type = :type and version = :version and packageId = :packageId";
		Query query = this.getSession().createQuery(hql);
		query.setString("type", IFormModel.TYPE_SINGLE);
		query.setInteger("version", version);
		query.setString("packageId", packageId);
		List<IFormModel> formList = query.list();
		return formList;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#findSingleFormList(java.lang.String)
	 */
	public List<IFormModel> findSingleFormList(String categoryId) throws SmartServerRuntimeException {
		StringBuffer sql = new StringBuffer("select f.id, f.packageId, f.version, f.formId, f.name, f.type");
		sql.append(" from SWForm f");
		sql.append(", (select packageId, max(version) as version from SWPackage where categoryId = :categoryId and status = :status group by packageId) p");
		sql.append(" where f.packageId = p.packageId");
		sql.append(" and f.version = p.version");
		sql.append(" and f.type = :type");
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.setString("categoryId", categoryId);
		query.setString("status", IPackageModel.STATUS_DEPLOYED);
		query.setString("type", IFormModel.TYPE_SINGLE);
		List<Object[]> result = query.list();
		
		if(result == null || result.isEmpty())
			return new ArrayList<IFormModel>();
		
		List<IFormModel> formList = new ArrayList<IFormModel>();
		
		for(Object[] record : result) {
			IFormModel form = new HbFormModel();
			form.setId((String)record[0]);
			form.setPackageId((String)record[1]);
			form.setVersion((Integer)record[2]);
			form.setFormId((String)record[3]);
			form.setName((String)record[4]);
			form.setType((String)record[5]);
			formList.add(form);
		}
		
		return formList;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#findInstuctFormList()
	 */
	public List<IFormModel> findInstuctFormList() throws SmartServerRuntimeException {
		String sql = "select distinct formId from SWForm where id in (select formUid from SWWorkType where type = :type)";
		Query query = this.getSession().createSQLQuery(sql);
		query.setString("type", IWorkTypeModel.WORKTYPE_INSTRUCT);
		List<String> formIdList = query.list();
		
		List<IFormModel> formList = new ArrayList<IFormModel>();
		
		if(formIdList == null || formIdList.isEmpty())
			return formList;
		
		for(String formId : formIdList) {
			IFormModel form = this.retrieveLatestForm(formId);
			
			if(form != null)
				formList.add(form);
		}
		
		return formList;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#findProcessStartForm(java.lang.String)
	 */
	public List<IFormModel> findProcessStartForm(String processUid)
			throws SmartServerRuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#findProcessStartForm(java.lang.String, int)
	 */
	public List<IFormModel> findProcessStartForm(String processId,
			int processVersion) throws SmartServerRuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#findProcessVersionList(java.lang.String)
	 */
	public List<IProcessModel> findProcessVersionList(String processId) throws SmartServerRuntimeException {
		String hql = "from HbProcessModel where status = :status and processId = :processId";
		Query query = this.getSession().createQuery(hql);
		query.setString("status", IProcessModel.STATUS_DEPLOYED);
		query.setString("processId", processId);
		return query.list();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#findProcessVersions(java.lang.String)
	 */
	public List<Integer> findProcessVersions(String processId) throws SmartServerRuntimeException {
		String hql = "select version from HbProcessModel where processId = :processId and status = :status";
		Query query = this.getSession().createQuery(hql);
		query.setString("processId", processId);
		query.setString("status", IProcessModel.STATUS_DEPLOYED);
		List<Integer> versions = query.list();
		return versions;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#findLatestProcessByCategory(java.lang.String)
	 */
	public List<IProcessModel> findLatestProcessByCategory(String categoryId) throws SmartServerRuntimeException {
		StringBuffer hql = new StringBuffer("from HbProcessModel prc, HbPackageModel pkg where pkg.categoryId = '").append(categoryId).append("'");
		hql.append(" and prc.packageId = pkg.packageId and prc.version = pkg.version");
		hql.append(" and pkg.latestDeployedYn = '").append(SmartServerConstant.YES_NO_Y_VALUE).append("' order by prc.name");
		Query query = this.getSession().createQuery(hql.toString());
		List<IProcessModel> prcList = new ArrayList<IProcessModel>();
		List<Object[]> result = query.list();
		if(result != null && !result.isEmpty()) {
			for(Object[] obj : result) {
				IProcessModel prcModel = (IProcessModel)obj[0];
				prcList.add(prcModel);
			}
		}
		return prcList;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveForm(java.lang.String)
	 */
	public IFormModel retrieveForm(String formUid) throws SmartServerRuntimeException {
		String hql = "from HbFormModel where id = :formUid";
		Query query = this.getSession().createQuery(hql);
		query.setString("formUid", formUid);
		IFormModel form = (IFormModel)query.uniqueResult();
		return form;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveForm(java.lang.String, int)
	 */
	public IFormModel retrieveForm(String formId, int version) throws SmartServerRuntimeException {
		String hql = "from HbFormModel where formId = :formId and version = :version";
		Query query = this.getSession().createQuery(hql);
		query.setString("formId", formId);
		query.setInteger("version", version);
		IFormModel form = (IFormModel)query.uniqueResult();
		return form;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveFormContent(java.lang.String)
	 */
	public String retrieveFormContent(String formUid) throws SmartServerRuntimeException {
		String hql = "from HbFormContent where id = :formUid";
		Query query = this.getSession().createQuery(hql);
		query.setString("formUid", formUid);
		IFormContent form = (HbFormContent)query.uniqueResult();
		return form != null ? form.getContent() : null;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveFormContent(java.lang.String, int)
	 */
	public String retrieveFormContent(String formId, int version) throws SmartServerRuntimeException {
		String hql = "from HbFormContent where formId = :formId and version = :version";
		Query query = this.getSession().createQuery(hql);
		query.setString("formId", formId);
		query.setInteger("version", version);
		IFormContent form = (HbFormContent)query.uniqueResult();
		return form != null ? form.getContent() : null;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveLatestForm(java.lang.String)
	 */
	public IFormModel retrieveLatestForm(String formId) throws SmartServerRuntimeException {
		String hql = "from HbFormModel where formId = '" + formId + "' and version = (";
		hql += "select max(version) from HbFormModel where formId = '" + formId + "' and status = '" + IFormModel.STATUS_DEPLOYED + "'";
		hql += ")";
		Query query = this.getSession().createQuery(hql);
		return (IFormModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveLatestFormContent(java.lang.String)
	 */
	public String retrieveLatestFormContent(String formId) throws SmartServerRuntimeException {
		String hql = "from HbFormContent where formId = '" + formId + "' and version = (";
		hql += "select max(version) from HbFormModel where formId = '" + formId + "' and status = '" + IFormModel.STATUS_DEPLOYED + "'";
		hql += ")";
		Query query = this.getSession().createQuery(hql);
		IFormContent formContent = (IFormContent)query.uniqueResult();
		return formContent != null ? formContent.getContent() : null;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveLatestFormVersion(java.lang.String)
	 */
	public int retrieveLatestFormVersion(String formId) throws SmartServerRuntimeException {
		String hql = "select max(version) from HbFormModel where formId = '" + formId + "' and status = '" + IPackageModel.STATUS_DEPLOYED + "'";
		Query query = this.getSession().createQuery(hql);
		Object obj  = query.uniqueResult();
		
		if(obj != null) 
			return ((Integer)obj).intValue();
		else 
			throw new SmartServerRuntimeException("Not found form - formId [" + formId + "]");
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveLatestPackage(java.lang.String)
	 */
	public IPackageModel retrieveLatestPackage(String packageId) throws SmartServerRuntimeException {
		String hql = "from HbPackageModel where packageId = '" + packageId + "' and version = (";
		hql += "select max(version) from HbPackageModel where packageId = '" + packageId + "' and status = '" + IFormModel.STATUS_DEPLOYED + "'";
		hql += ")";
		Query query = this.getSession().createQuery(hql);
		return (IPackageModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveLatestPackageVersion(java.lang.String)
	 */
	public int retrieveLatestPackageVersion(String packageId) throws SmartServerRuntimeException {
		String hql = "select max(version) from HbPackageModel where packageId = '" + packageId + "' and status = '" + IPackageModel.STATUS_DEPLOYED + "'";
		Query query = this.getSession().createQuery(hql);
		Object obj  = query.uniqueResult();
		
		if(obj != null)
			return ((Integer)obj).intValue();
		else 
			throw new SmartServerRuntimeException("Not found package - packageId [" + packageId + "]");
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveLatestProcess(java.lang.String)
	 */
	public IProcessModel retrieveLatestProcess(String processId) throws SmartServerRuntimeException {
		String hql = "from HbProcessModel where processId = '" + processId + "' and version = (";
		hql += "select max(version) from HbProcessModel where processId = '" + processId + "' and status = '" + IProcessModel.STATUS_DEPLOYED + "'";
		hql += ")";
		Query query = this.getSession().createQuery(hql);
		return (IProcessModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveLatestProcessByPackage(java.lang.String)
	 */
	public IProcessModel retrieveLatestProcessByPackage(String packageId) throws SmartServerRuntimeException {
		String hql = "from HbProcessModel where packageId = '" + packageId + "' and version = (";
		hql += "select max(version) from HbPackageModel where packageId = '" + packageId + "' and status = '" + IPackageModel.STATUS_DEPLOYED + "'";
		hql += ")";
		Query query = this.getSession().createQuery(hql);
		return (IProcessModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveLatestProcessContent(java.lang.String)
	 */
	public String retrieveLatestProcessContent(String processId) throws SmartServerRuntimeException {
		String hql = "from HbProcessContent where processId = '" + processId + "' and version = (";
		hql += "select max(version) from HbProcessModel where processId = '" + processId + "' and status = '" + IProcessModel.STATUS_DEPLOYED + "'";
		hql += ")";
		Query query = this.getSession().createQuery(hql);
		IProcessContent prcContent = (IProcessContent)query.uniqueResult();
		return prcContent != null ? prcContent.getContent() : null;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveLatestProcessVersion(java.lang.String)
	 */
	public int retrieveLatestProcessVersion(String processId) throws SmartServerRuntimeException {
		String hql = "select max(version) from HbProcessModel where processId = '" + processId + "' and status = '" + IPackageModel.STATUS_DEPLOYED + "'";
		Query query = this.getSession().createQuery(hql);
		Object obj  = query.uniqueResult();
		
		if(obj != null)
			return ((Integer)obj).intValue();
		else 
			throw new SmartServerRuntimeException("Not found process - processId [" + processId + "]");
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrievePackage(java.lang.String, int)
	 */
	public IPackageModel retrievePackage(String packageId, int version) throws SmartServerRuntimeException {
		String hql = "from HbProcessModel where packageId = '" + packageId + "' and version = " + version;
		Query query = this.getSession().createQuery(hql);
		return (IPackageModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveProcess(java.lang.String)
	 */
	public IProcessModel retrieveProcess(String processUid) throws SmartServerRuntimeException {
		String hql = "from HbProcessModel where id = '" + processUid + "'";
		Query query = this.getSession().createQuery(hql);
		return (IProcessModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveProcess(java.lang.String, int)
	 */
	public IProcessModel retrieveProcess(String processId, int version) throws SmartServerRuntimeException {
		String hql = "from HbProcessModel where processId = '" + processId + "' and version = " + version;
		Query query = this.getSession().createQuery(hql);
		return (IProcessModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveProcessByPackage(java.lang.String, int)
	 */
	public IProcessModel retrieveProcessByPackage(String packageId, int version) throws SmartServerRuntimeException {
		String hql = "from HbProcessModel where packageId = '" + packageId + "' and version = " + version;
		Query query = this.getSession().createQuery(hql);
		return (IProcessModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveProcessContent(java.lang.String)
	 */
	public String retrieveProcessContent(String processUid) throws SmartServerRuntimeException {
		String hql = "from HbProcessContent where id = '" + processUid + "'";
		Query query = this.getSession().createQuery(hql);
		IProcessContent prcContent = (IProcessContent)query.uniqueResult();
		return prcContent != null ? prcContent.getContent() : null;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveProcessContent(java.lang.String, int)
	 */
	public String retrieveProcessContent(String processId, int version) throws SmartServerRuntimeException {
		String hql = "from HbProcessContent where processId = '" + processId + "' and version = " + version;
		Query query = this.getSession().createQuery(hql);
		IProcessContent prcContent = (IProcessContent)query.uniqueResult();
		return prcContent != null ? prcContent.getContent() : null;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveWorkType(java.lang.String)
	 */
	public IWorkTypeModel retrieveWorkType(String workTypeId) throws SmartServerRuntimeException {
		return (IWorkTypeModel)this.getHibernateTemplate().get(HbWorkTypeModel.class, workTypeId);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveWorkTypeByForm(java.lang.String)
	 */
	public IWorkTypeModel retrieveWorkTypeByForm(String formUid) throws SmartServerRuntimeException {
		String hql = "from HbWorkTypeModel where formUid = '" + formUid + "'";
		Query query = this.getSession().createQuery(hql);
		IWorkTypeModel workType = (IWorkTypeModel)query.uniqueResult();
		return workType;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveWorkTypeByForm(java.lang.String, int)
	 */
	public IWorkTypeModel retrieveWorkTypeByForm(String formId, int version) throws SmartServerRuntimeException {
		String hql = "from HbWorkTypeModel where formUid = (select id from HbFormModel where formId = '" + formId + "' and version = " + version + ")";
		Query query = this.getSession().createQuery(hql);
		IWorkTypeModel workType = (IWorkTypeModel)query.uniqueResult();
		return workType;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#retrieveFormByWorkType(java.lang.String)
	 */	
	public IFormModel retrieveFormByWorkType(String workTypeId) throws SmartServerRuntimeException {
		String hql = "from HbFormModel where id = (select formUid from HbWorkTypeModel where id = '" + workTypeId + "')";
		Query query = this.getSession().createQuery(hql);
		IFormModel form = (IFormModel)query.uniqueResult();
		return form;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#doMoveCategory(java.lang.String, java.lang.String)
	 */
	public void doMovePackageCategory(String packageId, String toCategoryId) throws SmartServerRuntimeException {
		String hql = "from HbCategoryModel where id = '" + toCategoryId + "'";
		Query query = this.getSession().createQuery(hql);
		ICategoryModel cat = (ICategoryModel)query.uniqueResult();
		
		if(cat == null)
			throw new SmartServerRuntimeException("Invalid category, toCategoryId [" + toCategoryId + "] not found!");
		
		hql = "update HbPackageModel set categoryId = '" + toCategoryId + "' where packageId = '" + packageId + "'";
		query = this.getSession().createQuery(hql);
		query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#searchDeployedProcess(int, int)
	 */
	public IProcessModelList searchDeployedProcess(int pageCount, int recordCount) throws SmartServerRuntimeException {
		
		Map<String, Object> condition = new HashMap<String, Object>();
		return this.searchProcessByCondition(condition, pageCount, recordCount);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#searchFormByCondition(java.util.Map, int, int)
	 */
	public IFormModelList searchFormByCondition(Map<String, Object> condition, int pageCount, int recordCount) throws SmartServerRuntimeException {
		
		if(!condition.containsKey(FormFieldEnum.status.name()))
			condition.put(FormFieldEnum.status.name(), IFormModel.STATUS_DEPLOYED);
		
		IFormModelList list = new HbFormModelList();
		int totalCount = this.searchFormCount(condition);
		list.setTotalCount(totalCount);
		
		if(totalCount < 1) {
			list.setFormModelList(new ArrayList<IFormModel>());
			return list;
		}
		
		// select packageId, version from hbpackagemodel where id in (select id from hbpackagemodel where latestDepoyedYn = 'Y') 
		StringBuffer hql = new StringBuffer("from HbFormModel where id is not null");
		this.createFormWhereQuery(hql, condition);
		hql.append(" order by createdTime desc");
		
		Query query = this.getSession().createQuery(hql.toString());
		this.setFormQueryParameters(query, condition);
		
		if(recordCount > 0) {
			int firstResult = pageCount <= 0 ? 0 : (pageCount -1) * recordCount;
			query.setFirstResult(firstResult);
			query.setMaxResults(recordCount);
		}
		
		List<IFormModel> formList = query.list();		
		if(formList != null && !formList.isEmpty())
			list.setFormModelList(formList);
		
		return list;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#searchFormCount(java.util.Map)
	 */
	public int searchFormCount(Map<String, Object> condition) throws SmartServerRuntimeException {
		
		if(!condition.containsKey(FormFieldEnum.status.name()))
			condition.put(FormFieldEnum.status.name(), IFormModel.STATUS_DEPLOYED);
		
		StringBuffer hql = new StringBuffer("select count(*) from HbFormModel where id is not null");
		this.createFormWhereQuery(hql, condition);
		Query query = this.getSession().createQuery(hql.toString());
		this.setFormQueryParameters(query, condition);
		Object obj = query.uniqueResult();
		Long count = (Long)obj;
		return count.intValue();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#searchLatestDeployedProcess(int, int)
	 */
	public IProcessModelList searchLatestDeployedProcess(int pageCount, int recordCount) throws SmartServerRuntimeException {
		
		IProcessModelList list = new HbProcessModelList();
		Session session = this.getSession();
		String sql = "select count(p.id) from SWProcess p, (select processId, max(version) as v from SWProcess where status = '" + IProcessModel.STATUS_DEPLOYED + "' group by processId) b where p.processId = b.processId and p.version = b.v";
		
		Query query = session.createSQLQuery(sql);
		Object obj = query.uniqueResult();
		int totalCount = 0;
		
		if(obj instanceof Integer) {
			Integer count = (Integer)obj;
			totalCount = count.intValue();
			
		} else if(obj instanceof BigInteger) {
			BigInteger count = (BigInteger)obj;
			totalCount = count.intValue();
			
		} else if(obj instanceof Long) {
			Long count = (Long)obj;
			totalCount = count.intValue();
			
		} else if(obj instanceof Number) {
			Number count = (Number)obj;
			totalCount = count.intValue();	
		}
		list.setTotalCount(totalCount);
		
		if(totalCount < 1) {
			list.setProcessModelList(new ArrayList<IProcessModel>());
			return list;
		}
		
		sql = "select p.id from SWProcess p, (select processId, max(version) as v from SWProcess where status = '" + IProcessModel.STATUS_DEPLOYED + "' group by processId) b where p.processId = b.processId and p.version = b.v";
		query = session.createSQLQuery(sql);
		List<Object> processUids = query.list();
		
		if(processUids == null || processUids.isEmpty()) {
			list.setProcessModelList(new ArrayList<IProcessModel>());
			return list;
		}
		
		StringBuffer hql = new StringBuffer("from HbProcessModel where id in (");		
		for(int i = 0 ; i < processUids.size() ; i++) {
			hql.append("'" + processUids.get(i) + "'");
			hql.append(",");
		}
		hql.append("'') order by createdTime desc");
		
		query = session.createQuery(hql.toString());
		if(recordCount > 0) {
			int firstResult = pageCount <= 0 ? 0 : (pageCount -1) * recordCount;
			query.setFirstResult(firstResult);
			query.setMaxResults(recordCount);
		}
		
		List<IProcessModel> prcList = query.list();
		if(prcList != null && !prcList.isEmpty())
			list.setProcessModelList(prcList);
		
		return list;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#searchPackageByCondition(java.util.Map, java.util.Map, int, int)
	 */
	public IPackageModelList searchPackageByCondition(
			Map<String, Object> condition, Map<String, String> orderCondition, int pageCount, int recordCount)
			throws SmartServerRuntimeException {
		
		if(!condition.containsKey(PackageFieldEnum.status.name()))
			condition.put(PackageFieldEnum.status.name(), IPackageModel.STATUS_DEPLOYED);
		
		IPackageModelList list = new HbPackageModelList();	
		int totalCount = this.searchPackageCount(condition);
		list.setTotalCount(totalCount);
		
		if(totalCount < 1) {
			list.setPackageModelList(new ArrayList<IPackageModel>());
			return list;
		}
		
		StringBuffer hql = new StringBuffer("from HbPackageModel where id is not null ");
		this.createPackageWhereQuery(hql, condition);
		
		if(orderCondition == null || orderCondition.isEmpty())
			hql.append(" order by createdTime desc");
		else {
			hql.append(" order by ");
			
			int orderIdx = 0;
			Iterator<String> orderIt = orderCondition.keySet().iterator();
			while(orderIt.hasNext()) {
				if(orderIdx > 0)
					hql.append(", ");
				
				String orderField = orderIt.next();
				hql.append(" ");
				hql.append(orderField);
				hql.append(" ");
				hql.append(orderCondition.get(orderField));
				orderIdx++;
			}
		}
		
		Query query = this.getSession().createQuery(hql.toString());
		this.setPackageQueryParameters(query, condition);
		
		if(recordCount > 0) {
			int firstResult = pageCount <= 0 ? 0 : (pageCount -1) * recordCount;
			query.setFirstResult(firstResult);
			query.setMaxResults(recordCount);
		}
		
		List<IPackageModel> pkgList = query.list();		
		if(pkgList != null && !pkgList.isEmpty())
			list.setPackageModelList(pkgList);
		
		return list;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#searchPackageCount(java.util.Map)
	 */
	public int searchPackageCount(Map<String, Object> condition) throws SmartServerRuntimeException {
		
		if(!condition.containsKey(PackageFieldEnum.status.name()))
			condition.put(PackageFieldEnum.status.name(), IPackageModel.STATUS_DEPLOYED);
		
		StringBuffer hql = new StringBuffer("select count(*) from HbPackageModel where id is not null ");
		this.createPackageWhereQuery(hql, condition);
		Query query = this.getSession().createQuery(hql.toString());
		this.setPackageQueryParameters(query, condition);
		Object obj = query.uniqueResult();
		Long count = (Long)obj;
		return count.intValue();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#searchProcessByCondition(java.util.Map, int, int)
	 */
	public IProcessModelList searchProcessByCondition(
			Map<String, Object> condition, int pageCount, int recordCount)
			throws SmartServerRuntimeException {
		
		if(!condition.containsKey(ProcessFieldEnum.status.name()))
			condition.put(ProcessFieldEnum.status.name(), IProcessModel.STATUS_DEPLOYED);
		
		IProcessModelList list = new HbProcessModelList();
		int totalCount = this.searchProcessCount(condition);
		list.setTotalCount(totalCount);
		
		if(totalCount < 1) {
			list.setProcessModelList(new ArrayList<IProcessModel>());
			return list;
		}
		
		StringBuffer hql = new StringBuffer("from HbProcessModel where id is not null ");
		this.createProcessWhereQuery(hql, condition);
		hql.append(" order by createdTime desc");		
		Query query = this.getSession().createQuery(hql.toString());
		this.setProcessQueryParameters(query, condition);
		
		if(recordCount > 0) {
			int firstResult = pageCount <= 0 ? 0 : (pageCount -1) * recordCount;
			query.setFirstResult(firstResult);
			query.setMaxResults(recordCount);
		}
		
		List<IProcessModel> prcList = query.list();
		if(prcList != null && !prcList.isEmpty())
			list.setProcessModelList(prcList);
		
		return list;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#searchProcessCount(java.util.Map)
	 */
	public int searchProcessCount(Map<String, Object> condition) throws SmartServerRuntimeException {
		
		if(!condition.containsKey(ProcessFieldEnum.status.name()))
			condition.put(ProcessFieldEnum.status.name(), IProcessModel.STATUS_DEPLOYED);
		
		StringBuffer hql = new StringBuffer("select count(*) from HbProcessModel where id is not null ");
		this.createProcessWhereQuery(hql, condition);
		Query query = this.getSession().createQuery(hql.toString());
		this.setProcessQueryParameters(query, condition);
		Object obj = query.uniqueResult();
		Long count = (Long)obj;
		return count.intValue();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#searchWorkTypeByCondition(java.util.Map, int, int)
	 */
	public IWorkTypeModelList searchWorkTypeByCondition(
			Map<String, Object> condition, int pageCount, int recordCount)
			throws SmartServerRuntimeException {
		
		IWorkTypeModelList list = new HbWorkTypeModelList();
		int totalCount = this.searchWorkTypeCount(condition);
		list.setTotalCount(totalCount);
		
		if(totalCount < 1) {
			list.setWorkTypeModelList(new ArrayList<IWorkTypeModel>());
			return list;
		}
		
		StringBuffer hql = new StringBuffer("from HbWorkTypeModel type, HbFormModel form where type.formUid = form.id and form.status = '"  + IFormModel.STATUS_DEPLOYED + "'");
		this.createWorkTypeWhereQuery(hql, "type", "form", condition);
		hql.append(" order by form.createdTime desc");		
		Query query = this.getSession().createQuery(hql.toString());
		this.setWorkTypeQueryParameters(query, condition);
		
		if(recordCount > 0) {
			int firstResult = pageCount <= 0 ? 0 : (pageCount -1) * recordCount;
			query.setFirstResult(firstResult);
			query.setMaxResults(recordCount);
		}
		
		List<Object[]> result = query.list();
		if(result != null && !result.isEmpty()) {
			for(Object[] obj : result) {
				IWorkTypeModel workTypeModel = (IWorkTypeModel)obj[0];
				//IFormModel formModel = (IFormModel)obj[1];			
				list.addWorkTypeModel(workTypeModel);
			}
		}
		
		return list;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceRuntimeDao#searchWorkTypeCount(java.util.Map)
	 */
	public int searchWorkTypeCount(Map<String, Object> condition) throws SmartServerRuntimeException {
		
		StringBuffer hql = new StringBuffer("select count(*) from HbWorkTypeModel type, HbFormModel form where type.formUid = form.id and form.status = '"  + IFormModel.STATUS_DEPLOYED + "'");
		this.createWorkTypeWhereQuery(hql, "type", "form", condition);
		Query query = this.getSession().createQuery(hql.toString());
		this.setWorkTypeQueryParameters(query, condition);
		Object obj = query.uniqueResult();
		Long count = (Long)obj;
		return count.intValue();
	}

	/**
	 * 폼 검색 쿼리를 생성한다.
	 * 
	 * @param hql
	 * @param condition
	 */
	private void createFormWhereQuery(StringBuffer hql, Map<String, Object> condition) {
		
		if(condition.containsKey(FormFieldEnum.id.name()))
			hql.append(" and " + FormFieldEnum.id.name() + " = :" + FormFieldEnum.id.name());
			
		if(condition.containsKey(FormFieldEnum.formId.name()))
			hql.append(" and " + FormFieldEnum.formId.name() + " = :" + FormFieldEnum.formId.name());
			
		if(condition.containsKey(FormFieldEnum.version.name()))
			hql.append(" and " + FormFieldEnum.version.name() + " = :" + FormFieldEnum.version.name());
		
		if(condition.containsKey(FormFieldEnum.packageId.name()))
			hql.append(" and " + FormFieldEnum.packageId.name() + " = :" + FormFieldEnum.packageId.name());
		
		if(condition.containsKey(FormFieldEnum.creator.name()))
			hql.append(" and " + FormFieldEnum.creator.name() + " = :" + FormFieldEnum.creator.name());
			
		if(condition.containsKey(FormFieldEnum.modifier.name()))
			hql.append(" and " + FormFieldEnum.modifier.name() + " = :" + FormFieldEnum.modifier.name());

		if(condition.containsKey(FormFieldEnum.status.name()))
			hql.append(" and " + FormFieldEnum.status.name() + " = :" + FormFieldEnum.status.name());
		
		if(condition.containsKey(FormFieldEnum.type.name()))
			hql.append(" and " + FormFieldEnum.type.name() + " = :" + FormFieldEnum.type.name());
		
		if(condition.containsKey(FormFieldEnum.description.name()))
			hql.append(" and " + FormFieldEnum.description.name() + " like :" + FormFieldEnum.description.name());
			
		if(condition.containsKey(FormFieldEnum.keyword.name()))
			hql.append(" and " + FormFieldEnum.keyword.name() + " like :" + FormFieldEnum.keyword.name());
			
		if(condition.containsKey(FormFieldEnum.name.name()))
			hql.append(" and " + FormFieldEnum.name.name() + " like :" + FormFieldEnum.name.name());
		
		// modifiedTime
		if(condition.containsKey(FormFieldEnum.modifiedTimeFrom.name()) && condition.containsKey(FormFieldEnum.modifiedTimeTo.name()))
			hql.append(" and (" + FormFieldEnum.modifiedTime.name() + " between '" + condition.get(FormFieldEnum.modifiedTimeFrom.name()) + "' and '" + condition.get(FormFieldEnum.modifiedTimeTo.name()) + "')");
			
		if(condition.containsKey(FormFieldEnum.modifiedTimeFrom.name()) && !condition.containsKey(FormFieldEnum.modifiedTimeTo.name()))
			hql.append(" and " + FormFieldEnum.modifiedTime.name() + " >= '" + condition.get(FormFieldEnum.modifiedTimeFrom.name()) + "'");
			
		if(!condition.containsKey(FormFieldEnum.modifiedTimeFrom.name()) && condition.containsKey(FormFieldEnum.modifiedTimeTo.name()))
			hql.append(" and " + FormFieldEnum.modifiedTime.name() + " <= '" + condition.get(FormFieldEnum.modifiedTimeTo.name()) + "'");
			
		// createdTime
		if(condition.containsKey(FormFieldEnum.createdTimeFrom.name()) && condition.containsKey(FormFieldEnum.createdTimeTo.name()))
			hql.append(" and (" + FormFieldEnum.createdTime.name() + " between '" + condition.get(FormFieldEnum.createdTimeFrom.name()) + "' and '" + condition.get(FormFieldEnum.createdTimeTo.name()) + "')");
			
		if(condition.containsKey(FormFieldEnum.createdTimeFrom.name()) && !condition.containsKey(FormFieldEnum.createdTimeTo.name()))
			hql.append(" and " + FormFieldEnum.createdTime.name() + " >= '" + condition.get(FormFieldEnum.createdTimeFrom.name()) + "'");
			
		if(!condition.containsKey(FormFieldEnum.createdTimeFrom.name()) && condition.containsKey(FormFieldEnum.createdTimeTo.name()))
			hql.append(" and " + FormFieldEnum.createdTime.name() + " <= '" + condition.get(FormFieldEnum.createdTimeTo.name()) + "'");			
	}
	
	/**
	 * 프로세스 검색 쿼리를 생성한다.
	 * 
	 * @param hql
	 * @param condition
	 */	
	private void createProcessWhereQuery(StringBuffer hql, Map<String, Object> condition) {
		
		if(condition.containsKey(ProcessFieldEnum.id.name()))
			hql.append(" and " + ProcessFieldEnum.id.name() + " = :" + ProcessFieldEnum.id.name());
			
		if(condition.containsKey(ProcessFieldEnum.processId.name()))
			hql.append(" and " + ProcessFieldEnum.processId.name() + " = :" + ProcessFieldEnum.processId.name());
			
		if(condition.containsKey(ProcessFieldEnum.version.name()))
			hql.append(" and " + ProcessFieldEnum.version.name() + " = :" + ProcessFieldEnum.version.name());
		
		if(condition.containsKey(ProcessFieldEnum.packageId.name()))
			hql.append(" and " + ProcessFieldEnum.packageId.name() + " = :" + ProcessFieldEnum.packageId.name());
		
		if(condition.containsKey(ProcessFieldEnum.creator.name()))
			hql.append(" and " + ProcessFieldEnum.creator.name() + " = :" + ProcessFieldEnum.creator.name());
			
		if(condition.containsKey(ProcessFieldEnum.modifier.name()))
			hql.append(" and " + ProcessFieldEnum.modifier.name() + " = :" + ProcessFieldEnum.modifier.name());

		if(condition.containsKey(ProcessFieldEnum.status.name()))
			hql.append(" and " + ProcessFieldEnum.status.name() + " = :" + ProcessFieldEnum.status.name());
		
		if(condition.containsKey(ProcessFieldEnum.description.name()))
			hql.append(" and " + ProcessFieldEnum.description.name() + " like :" + ProcessFieldEnum.description.name());
			
		if(condition.containsKey(ProcessFieldEnum.keyword.name()))
			hql.append(" and " + ProcessFieldEnum.keyword.name() + " like :" + ProcessFieldEnum.keyword.name());
			
		if(condition.containsKey(ProcessFieldEnum.name.name()))
			hql.append(" and " + ProcessFieldEnum.name.name() + " like :" + ProcessFieldEnum.name.name());
		
		// modifiedTime
		if(condition.containsKey(ProcessFieldEnum.modifiedTimeFrom.name()) && condition.containsKey(ProcessFieldEnum.modifiedTimeTo.name()))
			hql.append(" and (" + ProcessFieldEnum.modifiedTime.name() + " between '" + condition.get(ProcessFieldEnum.modifiedTimeFrom.name()) + "' and '" + condition.get(ProcessFieldEnum.modifiedTimeTo.name()) + "')");
			
		if(condition.containsKey(ProcessFieldEnum.modifiedTimeFrom.name()) && !condition.containsKey(ProcessFieldEnum.modifiedTimeTo.name()))
			hql.append(" and " + ProcessFieldEnum.modifiedTime.name() + " >= '" + condition.get(ProcessFieldEnum.modifiedTimeFrom.name()) + "'");
			
		if(!condition.containsKey(ProcessFieldEnum.modifiedTimeFrom.name()) && condition.containsKey(ProcessFieldEnum.modifiedTimeTo.name()))
			hql.append(" and " + ProcessFieldEnum.modifiedTime.name() + " <= '" + condition.get(ProcessFieldEnum.modifiedTimeTo.name()) + "'");
			
		// createdTime
		if(condition.containsKey(ProcessFieldEnum.createdTimeFrom.name()) && condition.containsKey(ProcessFieldEnum.createdTimeTo.name()))
			hql.append(" and (" + ProcessFieldEnum.createdTime.name() + " between '" + condition.get(ProcessFieldEnum.createdTimeFrom.name()) + "' and '" + condition.get(ProcessFieldEnum.createdTimeTo.name()) + "')");
			
		if(condition.containsKey(ProcessFieldEnum.createdTimeFrom.name()) && !condition.containsKey(ProcessFieldEnum.createdTimeTo.name()))
			hql.append(" and " + ProcessFieldEnum.createdTime.name() + " >= '" + condition.get(ProcessFieldEnum.createdTimeFrom.name()) + "'");
			
		if(!condition.containsKey(ProcessFieldEnum.createdTimeFrom.name()) && condition.containsKey(ProcessFieldEnum.createdTimeTo.name()))
			hql.append(" and " + ProcessFieldEnum.createdTime.name() + " <= '" + condition.get(ProcessFieldEnum.createdTimeTo.name()) + "'");
	}
	
	/**
	 * 패키지 검색 쿼리를 생성한다.
	 * 
	 * @param hql
	 * @param condition
	 */	
	private void createPackageWhereQuery(StringBuffer hql, Map<String, Object> condition) {
		
		if(condition.containsKey(PackageFieldEnum.id.name()))
			hql.append(" and " + PackageFieldEnum.id.name() + " = :" + PackageFieldEnum.id.name());
			
		if(condition.containsKey(PackageFieldEnum.categoryId.name()))
			hql.append(" and " + PackageFieldEnum.categoryId.name() + " = :" + PackageFieldEnum.categoryId.name());
		
		if(condition.containsKey(PackageFieldEnum.version.name()))
			hql.append(" and " + PackageFieldEnum.version.name() + " = :" + PackageFieldEnum.version.name());
		
		if(condition.containsKey(PackageFieldEnum.packageId.name()))
			hql.append(" and " + PackageFieldEnum.packageId.name() + " = :" + PackageFieldEnum.packageId.name());
		
		if(condition.containsKey(PackageFieldEnum.creator.name()))
			hql.append(" and " + PackageFieldEnum.creator.name() + " = :" + PackageFieldEnum.creator.name());
			
		if(condition.containsKey(PackageFieldEnum.modifier.name()))
			hql.append(" and " + PackageFieldEnum.modifier.name() + " = :" + PackageFieldEnum.modifier.name());

		if(condition.containsKey(PackageFieldEnum.status.name()))
			hql.append(" and " + PackageFieldEnum.status.name() + " = :" + PackageFieldEnum.status.name());
		
		if(condition.containsKey(PackageFieldEnum.latestDeployedYn.name()))
			hql.append(" and " + PackageFieldEnum.latestDeployedYn.name() + " = :" + PackageFieldEnum.latestDeployedYn.name());
		
		if(condition.containsKey(PackageFieldEnum.description.name()))
			hql.append(" and " + PackageFieldEnum.description.name() + " like :" + PackageFieldEnum.description.name());
			
		if(condition.containsKey(PackageFieldEnum.name.name()))
			hql.append(" and " + PackageFieldEnum.name.name() + " like :" + PackageFieldEnum.name.name());
		
		if(condition.containsKey(PackageFieldEnum.type.name()))
			hql.append(" and " + PackageFieldEnum.type.name() + " = :" + PackageFieldEnum.type.name());
		
		// modifiedTime
		if(condition.containsKey(PackageFieldEnum.modifiedTimeFrom.name()) && condition.containsKey(PackageFieldEnum.modifiedTimeTo.name()))
			hql.append(" and (" + PackageFieldEnum.modifiedTime.name() + " between '" + condition.get(PackageFieldEnum.modifiedTimeFrom.name()) + "' and '" + condition.get(PackageFieldEnum.modifiedTimeTo.name()) + "')");
			
		if(condition.containsKey(PackageFieldEnum.modifiedTimeFrom.name()) && !condition.containsKey(PackageFieldEnum.modifiedTimeTo.name()))
			hql.append(" and " + PackageFieldEnum.modifiedTime.name() + " >= '" + condition.get(PackageFieldEnum.modifiedTimeFrom.name()) + "'");
			
		if(!condition.containsKey(PackageFieldEnum.modifiedTimeFrom.name()) && condition.containsKey(PackageFieldEnum.modifiedTimeTo.name()))
			hql.append(" and " + PackageFieldEnum.modifiedTime.name() + " <= '" + condition.get(PackageFieldEnum.modifiedTimeTo.name()) + "'");
			
		// createdTime
		if(condition.containsKey(PackageFieldEnum.createdTimeFrom.name()) && condition.containsKey(PackageFieldEnum.createdTimeTo.name()))
			hql.append(" and (" + PackageFieldEnum.createdTime.name() + " between '" + condition.get(PackageFieldEnum.createdTimeFrom.name()) + "' and '" + condition.get(PackageFieldEnum.createdTimeTo.name()) + "')");
			
		if(condition.containsKey(PackageFieldEnum.createdTimeFrom.name()) && !condition.containsKey(PackageFieldEnum.createdTimeTo.name()))
			hql.append(" and " + PackageFieldEnum.createdTime.name() + " >= '" + condition.get(PackageFieldEnum.createdTimeFrom.name()) + "'");
			
		if(!condition.containsKey(PackageFieldEnum.createdTimeFrom.name()) && condition.containsKey(PackageFieldEnum.createdTimeTo.name()))
			hql.append(" and " + PackageFieldEnum.createdTime.name() + " <= '" + condition.get(PackageFieldEnum.createdTimeTo.name()) + "'");		
	}
	
	/**
	 * 프로세스 검색을 위한 파라미터를 설정한다.
	 * 
	 * @param query
	 * @param condition
	 */
	private void setProcessQueryParameters(Query query, Map<String, Object> condition) {
		
		if(condition.containsKey(ProcessFieldEnum.id.name()))
			query.setParameter(ProcessFieldEnum.id.name(), condition.get(ProcessFieldEnum.id.name()));
		
		if(condition.containsKey(ProcessFieldEnum.processId.name()))
			query.setParameter(ProcessFieldEnum.processId.name(), condition.get(ProcessFieldEnum.processId.name()));
			
		if(condition.containsKey(ProcessFieldEnum.version.name()))
			query.setParameter(ProcessFieldEnum.version.name(), condition.get(ProcessFieldEnum.version.name()));
		
		if(condition.containsKey(ProcessFieldEnum.packageId.name()))
			query.setParameter(ProcessFieldEnum.packageId.name(), condition.get(ProcessFieldEnum.packageId.name()));
		
		if(condition.containsKey(ProcessFieldEnum.status.name()))
			query.setParameter(ProcessFieldEnum.status.name(), condition.get(ProcessFieldEnum.status.name()));
		
		if(condition.containsKey(ProcessFieldEnum.creator.name()))
			query.setParameter(ProcessFieldEnum.creator.name(), condition.get(ProcessFieldEnum.creator.name()));
		
		if(condition.containsKey(ProcessFieldEnum.modifier.name()))
			query.setParameter(ProcessFieldEnum.modifier.name(), condition.get(ProcessFieldEnum.modifier.name()));
		
		if(condition.containsKey(ProcessFieldEnum.description.name()))
			query.setParameter(ProcessFieldEnum.description.name(), "%" + condition.get(ProcessFieldEnum.description.name()) + "%");
			
		if(condition.containsKey(ProcessFieldEnum.keyword.name()))
			query.setParameter(ProcessFieldEnum.keyword.name(), "%" + condition.get(ProcessFieldEnum.keyword.name()) + "%");
		
		if(condition.containsKey(ProcessFieldEnum.name.name()))
			query.setParameter(ProcessFieldEnum.name.name(), "%" + condition.get(ProcessFieldEnum.name.name()) + "%");
	}
	
	/**
	 * 폼 검색을 위한 파라미터를 설정한다.
	 * 
	 * @param query
	 * @param condition
	 */
	private void setFormQueryParameters(Query query, Map<String, Object> condition) {
		
		if(condition.containsKey(FormFieldEnum.id.name()))
			query.setParameter(FormFieldEnum.id.name(), condition.get(FormFieldEnum.id.name()));
		
		if(condition.containsKey(FormFieldEnum.formId.name()))
			query.setParameter(FormFieldEnum.formId.name(), condition.get(FormFieldEnum.formId.name()));
			
		if(condition.containsKey(FormFieldEnum.version.name()))
			query.setParameter(FormFieldEnum.version.name(), condition.get(FormFieldEnum.version.name()));
		
		if(condition.containsKey(FormFieldEnum.packageId.name()))
			query.setParameter(FormFieldEnum.packageId.name(), condition.get(FormFieldEnum.packageId.name()));
		
		if(condition.containsKey(FormFieldEnum.status.name()))
			query.setParameter(FormFieldEnum.status.name(), condition.get(FormFieldEnum.status.name()));
		
		if(condition.containsKey(FormFieldEnum.type.name()))
			query.setParameter(FormFieldEnum.type.name(), condition.get(FormFieldEnum.type.name()));
		
		if(condition.containsKey(FormFieldEnum.creator.name()))
			query.setParameter(FormFieldEnum.creator.name(), condition.get(FormFieldEnum.creator.name()));
		
		if(condition.containsKey(FormFieldEnum.modifier.name()))
			query.setParameter(FormFieldEnum.modifier.name(), condition.get(FormFieldEnum.modifier.name()));
		
		if(condition.containsKey(FormFieldEnum.description.name()))
			query.setParameter(FormFieldEnum.description.name(), "%" + condition.get(FormFieldEnum.description.name()) + "%");
			
		if(condition.containsKey(FormFieldEnum.keyword.name()))
			query.setParameter(FormFieldEnum.keyword.name(), "%" + condition.get(FormFieldEnum.keyword.name()) + "%");
		
		if(condition.containsKey(FormFieldEnum.name.name()))
			query.setParameter(FormFieldEnum.name.name(), "%" + condition.get(FormFieldEnum.name.name()) + "%");
	}
	
	/**
	 * 패키지 검색을 위한 파라미터를 설정한다.
	 * 
	 * @param query
	 * @param condition
	 */
	private void setPackageQueryParameters(Query query, Map<String, Object> condition) {

		if(condition.containsKey(PackageFieldEnum.id.name()))
			query.setParameter(PackageFieldEnum.id.name(), condition.get(PackageFieldEnum.id.name()));
		
		if(condition.containsKey(PackageFieldEnum.categoryId.name()))
			query.setParameter(PackageFieldEnum.categoryId.name(), condition.get(PackageFieldEnum.categoryId.name()));
		
		if(condition.containsKey(PackageFieldEnum.latestDeployedYn.name()))
			query.setParameter(PackageFieldEnum.latestDeployedYn.name(), condition.get(PackageFieldEnum.latestDeployedYn.name()));
			
		if(condition.containsKey(PackageFieldEnum.version.name()))
			query.setParameter(PackageFieldEnum.version.name(), condition.get(PackageFieldEnum.version.name()));
		
		if(condition.containsKey(PackageFieldEnum.packageId.name()))
			query.setParameter(PackageFieldEnum.packageId.name(), condition.get(PackageFieldEnum.packageId.name()));
		
		if(condition.containsKey(PackageFieldEnum.status.name()))
			query.setParameter(PackageFieldEnum.status.name(), condition.get(PackageFieldEnum.status.name()));
		
		if(condition.containsKey(PackageFieldEnum.creator.name()))
			query.setParameter(PackageFieldEnum.creator.name(), condition.get(PackageFieldEnum.creator.name()));
		
		if(condition.containsKey(PackageFieldEnum.modifier.name()))
			query.setParameter(PackageFieldEnum.modifier.name(), condition.get(PackageFieldEnum.modifier.name()));
		
		if(condition.containsKey(PackageFieldEnum.description.name()))
			query.setParameter(PackageFieldEnum.description.name(), "%" + condition.get(PackageFieldEnum.description.name()) + "%");
			
		//if(condition.containsKey(PackageFieldEnum.status.name()))
		//	query.setParameter(PackageFieldEnum.status.name(), "%" + condition.get(PackageFieldEnum.status.name()) + "%");
		
		if(condition.containsKey(PackageFieldEnum.name.name()))
			query.setParameter(PackageFieldEnum.name.name(), "%" + condition.get(PackageFieldEnum.name.name()) + "%");

		if(condition.containsKey(PackageFieldEnum.type.name()))
			query.setParameter(PackageFieldEnum.type.name(), condition.get(PackageFieldEnum.type.name()));
	}

	/**
	 * form where query
	 * 
	 * @param buf
	 * @param workTypeAlias
	 * @param formAlias
	 * @param condition
	 */
	private void createWorkTypeWhereQuery(StringBuffer buf, String workTypeAlias, String formAlias, Map<String, Object> condition) {
		
		workTypeAlias = workTypeAlias + ".";
		formAlias = formAlias + ".";
		
		// workType
		if(condition.containsKey(WorkTypeFieldEnum.id.name()))
			buf.append(" and " + workTypeAlias + WorkTypeFieldEnum.id.name() + " = :" + WorkTypeFieldEnum.id.name());
			
		if(condition.containsKey(WorkTypeFieldEnum.formUid.name()))
			buf.append(" and " + workTypeAlias + WorkTypeFieldEnum.formUid.name() + " = :" + WorkTypeFieldEnum.formUid.name());
			
		if(condition.containsKey(WorkTypeFieldEnum.duration.name()))
			buf.append(" and " + workTypeAlias + WorkTypeFieldEnum.duration.name() + " = :" + WorkTypeFieldEnum.duration.name());
			
		if(condition.containsKey(WorkTypeFieldEnum.name.name()))
			buf.append(" and " + workTypeAlias + WorkTypeFieldEnum.name.name() + " like :" + WorkTypeFieldEnum.name.name());
			
		if(condition.containsKey(WorkTypeFieldEnum.stepCount.name()))
			buf.append(" and " + workTypeAlias + WorkTypeFieldEnum.stepCount.name() + " = :" + WorkTypeFieldEnum.stepCount.name());
		
		if(condition.containsKey(WorkTypeFieldEnum.type.name()))
			buf.append(" and " + workTypeAlias + WorkTypeFieldEnum.type.name() + " = :" + WorkTypeFieldEnum.type.name());
		
		// form
		if(condition.containsKey(FormFieldEnum.formId.name()))
			buf.append(" and " + formAlias + FormFieldEnum.formId.name() + " = :" + FormFieldEnum.formId.name());
			
		if(condition.containsKey(FormFieldEnum.description.name()))
			buf.append(" and " + formAlias + FormFieldEnum.description.name() + " like :" + FormFieldEnum.description.name());
			
		if(condition.containsKey(FormFieldEnum.keyword.name()))
			buf.append(" and " + formAlias + FormFieldEnum.keyword.name() + " like :" + FormFieldEnum.keyword.name());
			
		if(condition.containsKey(FormFieldEnum.version.name()))
			buf.append(" and " + formAlias + FormFieldEnum.version.name() + " = :" + FormFieldEnum.version.name());
						
		if(condition.containsKey(FormFieldEnum.creator.name()))
			buf.append(" and " + formAlias + FormFieldEnum.creator.name() + " = :" + FormFieldEnum.creator.name());
		
		if(condition.containsKey(FormFieldEnum.modifier.name()))
			buf.append(" and " + formAlias + FormFieldEnum.modifier.name() + " = :" + FormFieldEnum.modifier.name());
		
		if(condition.containsKey(FormFieldEnum.ownerDept.name()))
			buf.append(" and " + formAlias + FormFieldEnum.ownerDept.name() + " = :" + FormFieldEnum.ownerDept.name());
		
		if(condition.containsKey(FormFieldEnum.owner.name()))
			buf.append(" and " + formAlias + FormFieldEnum.owner.name() + " = :" + FormFieldEnum.owner.name());
		
		if(condition.containsKey(FormFieldEnum.encoding.name()))
			buf.append(" and " + formAlias + FormFieldEnum.encoding.name() + " = :" + FormFieldEnum.encoding.name());
		
		// createdTime
		if(condition.containsKey(FormFieldEnum.createdTimeFrom.name()) && condition.containsKey(FormFieldEnum.createdTimeTo.name()))
			buf.append(" and (" + formAlias + FormFieldEnum.createdTime.name() + " between '" + condition.get(FormFieldEnum.createdTimeFrom.name()) + "' and '" + condition.get(FormFieldEnum.createdTimeTo.name()) + "')");
			
		if(condition.containsKey(FormFieldEnum.createdTimeFrom.name()) && !condition.containsKey(FormFieldEnum.createdTimeTo.name()))
			buf.append(" and " + formAlias + FormFieldEnum.createdTime.name() + " >= '" + condition.get(FormFieldEnum.createdTimeFrom.name()) + "'");
			
		if(!condition.containsKey(FormFieldEnum.createdTimeFrom.name()) && condition.containsKey(FormFieldEnum.createdTimeTo.name()))
			buf.append(" and " + formAlias + FormFieldEnum.createdTime.name() + " <= '" + condition.get(FormFieldEnum.createdTimeTo.name()) + "'");
		
		// modifiedTime
		if(condition.containsKey(FormFieldEnum.modifiedTimeFrom.name()) && condition.containsKey(FormFieldEnum.modifiedTimeTo.name()))
			buf.append(" and (" + formAlias + FormFieldEnum.modifiedTime.name() + " between '" + condition.get(FormFieldEnum.modifiedTimeFrom.name()) + "' and '" + condition.get(FormFieldEnum.modifiedTimeTo.name()) + "')");
			
		if(condition.containsKey(FormFieldEnum.modifiedTimeFrom.name()) && !condition.containsKey(FormFieldEnum.modifiedTimeTo.name()))
			buf.append(" and " + formAlias + FormFieldEnum.modifiedTime.name() + " >= '" + condition.get(FormFieldEnum.modifiedTimeFrom.name()) + "'");
			
		if(!condition.containsKey(FormFieldEnum.modifiedTimeFrom.name()) && condition.containsKey(FormFieldEnum.modifiedTimeTo.name()))
			buf.append(" and " + formAlias + FormFieldEnum.modifiedTime.name() + " <= '" + condition.get(FormFieldEnum.modifiedTimeTo.name()) + "'");
	}
	
	/**
	 * query에 파라미터들을 설정한다.
	 * 
	 * @param query
	 * @param condition
	 */
	private void setWorkTypeQueryParameters(Query query, Map<String, Object> condition) {
		
		// workType
		if(condition.containsKey(WorkTypeFieldEnum.id.name()))
			query.setParameter(WorkTypeFieldEnum.id.name(), condition.get(WorkTypeFieldEnum.id.name()));
			
		if(condition.containsKey(WorkTypeFieldEnum.formUid.name()))
			query.setParameter(WorkTypeFieldEnum.formUid.name(), condition.get(WorkTypeFieldEnum.formUid.name()));
			
		if(condition.containsKey(WorkTypeFieldEnum.duration.name()))
			query.setParameter(WorkTypeFieldEnum.duration.name(), condition.get(WorkTypeFieldEnum.duration.name()));
			
		if(condition.containsKey(WorkTypeFieldEnum.name.name()))
			query.setParameter(WorkTypeFieldEnum.name.name(), "%" + condition.get(WorkTypeFieldEnum.name.name()) + "%");
			
		if(condition.containsKey(WorkTypeFieldEnum.stepCount.name()))
			query.setParameter(WorkTypeFieldEnum.stepCount.name(), condition.get(WorkTypeFieldEnum.stepCount.name()));
		
		if(condition.containsKey(WorkTypeFieldEnum.type.name()))
			query.setParameter(WorkTypeFieldEnum.type.name(), condition.get(WorkTypeFieldEnum.type.name()));
		
		// form
		if(condition.containsKey(FormFieldEnum.formId.name()))
			query.setParameter(FormFieldEnum.formId.name(), condition.get(FormFieldEnum.formId.name()));
			
		if(condition.containsKey(FormFieldEnum.description.name()))
			query.setParameter(FormFieldEnum.description.name(), "%" + condition.get(FormFieldEnum.description.name()) + "%");
			
		if(condition.containsKey(FormFieldEnum.keyword.name()))
			query.setParameter(FormFieldEnum.keyword.name(), "%" + condition.get(FormFieldEnum.keyword.name()) + "%");
		
		if(condition.containsKey(FormFieldEnum.version.name()))
			query.setParameter(FormFieldEnum.version.name(), condition.get(FormFieldEnum.version.name()));
			
		if(condition.containsKey(FormFieldEnum.name.name()))
			query.setParameter(FormFieldEnum.name.name(), "%" + condition.get(FormFieldEnum.name.name()) + "%");
					
		if(condition.containsKey(FormFieldEnum.creator.name()))
			query.setParameter(FormFieldEnum.creator.name(), condition.get(FormFieldEnum.creator.name()));
		
		if(condition.containsKey(FormFieldEnum.modifier.name()))
			query.setParameter(FormFieldEnum.modifier.name(), condition.get(FormFieldEnum.modifier.name()));
		
		if(condition.containsKey(FormFieldEnum.ownerDept.name()))
			query.setParameter(FormFieldEnum.ownerDept.name(), condition.get(FormFieldEnum.ownerDept.name()));
		
		if(condition.containsKey(FormFieldEnum.owner.name()))
			query.setParameter(FormFieldEnum.owner.name(), condition.get(FormFieldEnum.owner.name()));
			
		if(condition.containsKey(FormFieldEnum.encoding.name()))
			query.setParameter(FormFieldEnum.encoding.name(), condition.get(FormFieldEnum.encoding.name()));
	}
	
}
