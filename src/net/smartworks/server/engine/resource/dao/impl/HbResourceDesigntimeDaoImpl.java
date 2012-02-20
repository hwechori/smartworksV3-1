package net.smartworks.server.engine.resource.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.smartworks.server.engine.common.model.SmartServerConstant;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.id.IDCreator;
import net.smartworks.server.engine.process.xpdl.util.ProcessModelHelper;
import net.smartworks.server.engine.process.xpdl.xpdl2.Activities;
import net.smartworks.server.engine.process.xpdl.xpdl2.Activity;
import net.smartworks.server.engine.process.xpdl.xpdl2.Implementation7;
import net.smartworks.server.engine.process.xpdl.xpdl2.PackageType;
import net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1;
import net.smartworks.server.engine.process.xpdl.xpdl2.Task;
import net.smartworks.server.engine.process.xpdl.xpdl2.TaskApplication;
import net.smartworks.server.engine.resource.dao.IResourceDesigntimeDao;
import net.smartworks.server.engine.resource.exception.SmartServerRuntimeException;
import net.smartworks.server.engine.resource.manager.SmartServerManager;
import net.smartworks.server.engine.resource.model.IFormContent;
import net.smartworks.server.engine.resource.model.IFormDef;
import net.smartworks.server.engine.resource.model.IFormFieldDef;
import net.smartworks.server.engine.resource.model.IFormModel;
import net.smartworks.server.engine.resource.model.IFormModelList;
import net.smartworks.server.engine.resource.model.IPackageModel;
import net.smartworks.server.engine.resource.model.IPackageModelList;
import net.smartworks.server.engine.resource.model.IProcessContent;
import net.smartworks.server.engine.resource.model.IProcessModel;
import net.smartworks.server.engine.resource.model.IProcessModelList;
import net.smartworks.server.engine.resource.model.IWorkTypeModel;
import net.smartworks.server.engine.resource.model.enums.FormFieldEnum;
import net.smartworks.server.engine.resource.model.enums.PackageFieldEnum;
import net.smartworks.server.engine.resource.model.enums.ProcessFieldEnum;
import net.smartworks.server.engine.resource.model.hb.HbFormContent;
import net.smartworks.server.engine.resource.model.hb.HbFormModel;
import net.smartworks.server.engine.resource.model.hb.HbFormModelList;
import net.smartworks.server.engine.resource.model.hb.HbPackageModel;
import net.smartworks.server.engine.resource.model.hb.HbPackageModelList;
import net.smartworks.server.engine.resource.model.hb.HbProcessModel;
import net.smartworks.server.engine.resource.model.hb.HbProcessModelList;
import net.smartworks.server.engine.resource.model.hb.HbWorkTypeModel;
import net.smartworks.server.engine.resource.util.SmartServerModelUtil;
import net.smartworks.server.engine.resource.util.SmartServerUtil;
import net.smartworks.server.engine.resource.util.XmlUtil;
import net.smartworks.server.engine.resource.util.convert.Xml2Obj;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.w3c.dom.Element;

/**
 * IResourceDesigntimeDao 하이버네이트 구현 
 * 
 * @author jhnam
 * @version $Id: HbResourceDesigntimeDaoImpl.java,v 1.1 2011/11/08 03:15:23 kmyu Exp $
 */
public class HbResourceDesigntimeDaoImpl extends HibernateDaoSupport implements IResourceDesigntimeDao {

	@Autowired
	public void anyMethod(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	/**
	 * 프로세스 템플릿 파일
	 */
	private String processTemplateFile;
	/**
	 * 간트 템플릿 파일
	 */
	private String ganttTemplateFile;
	
	/**
	 * @return the processTemplateFile
	 */
	public String getProcessTemplateFile() {
		return this.processTemplateFile;
	}

	/**
	 * @param processTemplateFile the processTemplateFile to set
	 */
	public void setProcessTemplateFile(String processTemplateFile) {		
		this.processTemplateFile = processTemplateFile;
	}
	/**
	 * @return the getGanttTemplateFile
	 */
	public String getGanttTemplateFile() {
		return this.ganttTemplateFile;
	}

	/**
	 * @param getGanttTemplateFile the getGanttTemplateFile to set
	 */
	public void setGanttTemplateFile(String ganttTemplateFile) {		
		this.ganttTemplateFile = ganttTemplateFile;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#checkInPackage(java.lang.String, java.lang.String, int)
	 */
	public void checkInPackage(String userId, String packageId, int version)
			throws SmartServerRuntimeException {
		
		Date currentTime = new Date();
		IPackageModel pkg = this.retrievePackage(packageId, version);
		
		// 1. 체크 아웃상태가 아니라면 체크인이 불가능하다
		if(!pkg.getStatus().equals(IPackageModel.STATUS_UNDER_DEVEL))
			throw new SmartServerRuntimeException("Failed to checkIn package - name [" + pkg.getName() + "], packageId [" + pkg.getPackageId() + "], version [" + pkg.getVersion() + "] because package status not checked-out!");
		
		// 2. 체크아웃 사용자와 userId가 같은지 체크한다.
		if(!pkg.getModifier().equals(userId))
			throw new SmartServerRuntimeException("Failed to checkIn package - name [" + pkg.getName() + "], Invalid user! CheckOut user - [" + pkg.getModifier() + "] checkin user - [" + userId + "]");		
	
		// 3. 체크인 플래그로 변경
		pkg.setStatus(IPackageModel.STATUS_CHECKED_IN);
		this.update(userId, pkg);
		
		// 4. 패키지에 소속된 모든 폼 체크인
		String hql = "update SWForm set modifiedTime=?, status = '" + IFormModel.STATUS_CHECKED_IN + "', modifier = '" + userId + "' where packageId = '" + packageId + "' and version =" + version;
		Query query = this.getSession().createSQLQuery(hql);
		query.setTimestamp(0, currentTime);
		query.executeUpdate();
		
		// 5. 패키지에 소속된 프로세스 체크인
		hql = "update SWProcess set modifiedTime=?, status = '" + IProcessModel.STATUS_CHECKED_IN + "', modifier = '" + userId + "' where packageId = '" + packageId + "' and version =" + version;
		query = this.getSession().createSQLQuery(hql);
		query.setTimestamp(0, currentTime);
		query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#checkOutPackage(java.lang.String, java.lang.String, int)
	 */
	public void checkOutPackage(String userId, String packageId, int version)
			throws SmartServerRuntimeException {
		
		Date currentTime = new Date();
		IPackageModel pkg = this.retrievePackage(packageId, version);
		
		// 1. 체크 인 상태가 아니라면 체크아웃이 불가능하다
		if(!pkg.getStatus().equals(IPackageModel.STATUS_CHECKED_IN))
			throw new SmartServerRuntimeException("Failed to checkOut package - name [" + pkg.getName() + "], packageId [" + pkg.getPackageId() + "], version [" + pkg.getVersion() + "] because package status not checked-in!");
			
		// 2. 체크아웃 플래그로 변경
		pkg.setStatus(IPackageModel.STATUS_UNDER_DEVEL);
		this.update(userId, pkg);
		
		// 3. 패키지에 소속된 모든 폼 체크아웃
		String hql = "update SWForm set modifiedTime=?, status = '" + IFormModel.STATUS_CHECKED_OUT + "', modifier = '" + userId + "' where packageId = '" + packageId + "' and version =" + version;
		Query query = this.getSession().createSQLQuery(hql);
		query.setTimestamp(0, currentTime);
		query.executeUpdate();
		
		// 4. 패키지에 소속된 프로세스 체크아웃
		hql = "update SWProcess set modifiedTime=?, status = '" + IProcessModel.STATUS_CHECKED_OUT + "', modifier = '" + userId + "' where packageId = '" + packageId + "' and version =" + version;
		query = this.getSession().createSQLQuery(hql);
		query.setTimestamp(0, currentTime);
		query.executeUpdate();
	}

	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#checkInForm(java.lang.String, java.lang.String, int)
	 */
	public void checkInForm(String userId, String formId, int version)
			throws SmartServerRuntimeException {

		// 1. 업무 폼을 찾는다.
		IFormModel form = this.retrieveForm(formId, version);
		
		// 2. 체크인 상태라면 체크인이 불가능하다
		if(form.getStatus().equals(IFormModel.STATUS_CHECKED_IN))
			throw new SmartServerRuntimeException("Failed to checkIn form - name [" + form.getName() + "], formId [" + form.getFormId() + "], version [" + form.getVersion() + "] because already checked-in!");
		
		// 3. 체크아웃 사용자와 userId가 같은지 체크한다.
		if(!form.getModifier().equals(userId))
			throw new SmartServerRuntimeException("Failed to checkIn form - name [" + form.getName() + "], formId [" + form.getFormId() + "], version [" + form.getVersion() + "] - invalid user!");
		
		// 4. 체크아웃 플래그를 내린다.
		form.setStatus(IFormModel.STATUS_CHECKED_IN);
		form.setModifier(userId);
		form.setModifiedTime(new Date());
		this.updateForm(userId, form);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#checkInProcess(java.lang.String, java.lang.String, int)
	 */
	public void checkInProcess(String userId, String processId, int version)
			throws SmartServerRuntimeException {
		
		// 1. 프로세스를 찾는다.
		IProcessModel process = this.retrieveProcess(processId, version);
		
		// 2. 프로세스가 체크인 상태라면 체크인이 불가능하다.
		if(process.getStatus().equals(IFormModel.STATUS_CHECKED_IN))
			throw new SmartServerRuntimeException("Failed to checkIn process - name [" + process.getName() + "], processId [" + process.getProcessId() + "], version [" + process.getVersion() + "] because already checked-in!");
		
		// 3. 체크아웃 사용자와 userId가 같은지 체크한다.
		if(!process.getModifier().equals(userId))
			throw new SmartServerRuntimeException("Failed to checkIn process - name [" + process.getName() + "], formId [" + process.getProcessId() + "], version [" + process.getVersion() + "] - invalid user!");
		
		// 4. 체크아웃 플래그를 내린다.
		process.setStatus(IFormModel.STATUS_CHECKED_IN);
		process.setModifier(userId);
		process.setModifiedTime(new Date());
		this.updateProcess(userId, process);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#checkOutForm(java.lang.String, java.lang.String, int)
	 */
	public String checkOutForm(String userId, String formId, int version)
			throws SmartServerRuntimeException {
		
		// 1. 폼 찾기
		IFormModel form = this.retrieveForm(formId, version);
		
		// 2. 체크인 상태라면 체크아웃 한다.
		if(IFormModel.STATUS_CHECKED_IN.equals(form.getStatus())) {
			form.setStatus(IFormModel.STATUS_CHECKED_OUT);
			form.setModifier(userId);
			form.setModifiedTime(new Date());			
			this.updateForm(userId, form);
			return this.retrieveFormContent(form.getFormId(), form.getVersion());
		} else 
			throw new SmartServerRuntimeException("Failed to checkOut form - name [" + form.getName() + "], formId [" + form.getFormId() + "], version [" + form.getVersion() + "] because invalid status [" + form.getStatus() + "!");
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#checkOutProcess(java.lang.String, java.lang.String, int)
	 */
	public String checkOutProcess(String userId, String processId, int version)
			throws SmartServerRuntimeException {
		
		// 1. 프로세스 찾기
		IProcessModel process = this.retrieveProcess(processId, version);
		
		// 2. 체크인 상태라면 체크아웃 한다.
		if(IFormModel.STATUS_CHECKED_IN.equals(process.getStatus())) {
			process.setStatus(IFormModel.STATUS_CHECKED_OUT);
			process.setModifier(userId);
			process.setModifiedTime(new Date());			
			this.updateProcess(userId, process);
			return this.retrieveProcessContent(process.getProcessId(), process.getVersion());
		} else 
			throw new SmartServerRuntimeException("Failed to checkOut process - name [" + process.getName() + "], formId [" + process.getProcessId() + "], version [" + process.getVersion() + "] because invalid status [" + process.getStatus() + "!");
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#deployPackage(java.lang.String, java.lang.String, int)
	 */
	public void deployPackage(String userId, String companyId, String packageId, int version)
			throws SmartServerRuntimeException {
				
		Session session = this.getSession();
		
		// 패키지 조회
		IPackageModel pkg = this.retrievePackage(packageId, version);
		
		// 체크인 상태가 아니라면 배치를 할 수 없다.
		if(!pkg.getStatus().equals(IPackageModel.STATUS_CHECKED_IN))
			throw new SmartServerRuntimeException("Can not deploy package. Current status is [" + pkg.getStatus() + "]!");
		
		// 폼 배치 
		String hql = "update HbFormModel set status = '" + IFormModel.STATUS_DEPLOYED + "' where packageId = '" + packageId + "' and version = " + version;
		Query query = session.createQuery(hql);
		query.executeUpdate();
		
		// 프로세스 배치
		hql = "update HbProcessModel set status = '" + IFormModel.STATUS_DEPLOYED + "' where packageId = '" + packageId + "' and version = " + version;
		query = session.createQuery(hql);
		query.executeUpdate();
		
		// 기존 패키지 latestDeployedYn 필드 변경
		hql = "update HbPackageModel set latestDeployedYn = '" + SmartServerConstant.YES_NO_N_VALUE + "' where packageId = '" + packageId + "'";
		query = session.createQuery(hql);
		query.executeUpdate();
		
		// 패키지 상태 변경		
		hql = "update HbPackageModel set status = '" + IFormModel.STATUS_DEPLOYED + "', latestDeployedYn = '" + SmartServerConstant.YES_NO_Y_VALUE + "' where packageId = '" + packageId + "' and version = " + version;
		query = session.createQuery(hql);
		query.executeUpdate();
		
		/*
		// 패키지 아이디, 버전보다 높은 버전이 있는지 확인한 다음 있다면 새로운 버전을 생성하지 않는다. 없다면 생성한다.
		String sql = "select count(*) from SWPackage where packageId = '" + packageId + "' and version > " + version;
		query = session.createSQLQuery(sql);
		Object countStr = query.uniqueResult();
		int count = Integer.parseInt(countStr.toString());
		
		// 패키지 아이디, 버전보다 이미 높은 버전이 존재하지 않는다면 그 다음 버전을 체크인 상태로 생성한다.
		if(count == 0)
			this.createPackageVersion(userId, packageId);
		*/
		
		// 도메인 배치
		SmartServerManager.getInstance().getDomainManager().deployDomainByPackage(userId, companyId, packageId, version);
	}
	
	/**
	 * workTypeList를 formUid로 찾는다. 
	 * 
	 * @param workTypeList
	 * @param formUid
	 * @return
	 */
	private IWorkTypeModel getWorkType(List<IWorkTypeModel> workTypeList, String formUid) {
		
		for(IWorkTypeModel workType : workTypeList) {
			if(formUid.equals(workType.getFormUid()))
				return workType;
		}
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#undeployPackage(java.lang.String, java.lang.String, int)
	 */
	public void undeployPackage(String userId, String packageId, int version)
			throws SmartServerRuntimeException {
		
		IPackageModel pkg = this.retrievePackage(packageId, version);
		
		// 배치 상태가 아니라면 배치해제를 할 수 없다.
		if(!pkg.getStatus().equals(IPackageModel.STATUS_DEPLOYED))
			throw new SmartServerRuntimeException("Invalid status - current status is [" + pkg.getStatus() + "]!");
		
		Session session = this.getSession();
		
		// 폼 배치해제
		String hql = "update HbFormModel set status = '" + IFormModel.STATUS_CHECKED_IN + "' where packageId = '" + packageId + "' and version = " + version;
		Query query = session.createQuery(hql);
		query.executeUpdate();
		
		// 프로세스 배치 해제
		hql = "update HbProcessModel set status = '" + IProcessModel.STATUS_CHECKED_IN + "' where packageId = '" + packageId + "' and version = " + version;
		query = session.createQuery(hql);
		query.executeUpdate();
		
		// latestDeployedYn이 Y라면 동일 패키지의 다른 버전의 패키지에 Y를 넘겨준다.
		String sql = "select count(*) from SWPackage where latestDeployedYn = '" + SmartServerConstant.YES_NO_Y_VALUE + "' and packageId = '" + packageId + "' and version =" + version;
		query = session.createSQLQuery(sql);
		Object count = query.uniqueResult();
		int yCount = Integer.parseInt(count.toString());
		
		if(yCount > 0) {
			hql = "update HbPackageModel set latestDeployedYn = '" + SmartServerConstant.YES_NO_Y_VALUE + "' ";
			hql += "where status = '" + IPackageModel.STATUS_DEPLOYED + "' and packageId = '" + packageId + "' and version = (";
			hql += "	select max(version) from HbPackageModel where packageId = '" + packageId + "' and latestDeployedYn = '" + SmartServerConstant.YES_NO_N_VALUE + "' and status = '" + IPackageModel.STATUS_DEPLOYED + "'";
			hql += ")";
			query = session.createQuery(hql);
			query.executeUpdate();
		}
		
		// 패키지 상태 변경
		hql = "update HbPackageModel set status = '" + IPackageModel.STATUS_CHECKED_IN + "', latestDeployedYn = '" + SmartServerConstant.YES_NO_N_VALUE + "' where packageId = '" + packageId + "' and version = " + version;
		query = session.createQuery(hql);
		query.executeUpdate();
				
		// 도메인 배치 해제
		SmartServerManager.getInstance().getDomainManager().undeployDomainByPackage(userId, packageId, version);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#createForm(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	public IFormModel createForm(String userId, String packageId, int version,
			String type, String name) throws SmartServerRuntimeException {
		
		IFormModel obj = new HbFormModel();
		obj.setPackageId(packageId);
		obj.setVersion(version);
		obj.setType(type);
		obj.setName(name);
		obj.setDescription("");
		
		this.createForm(userId, obj);
		return obj;
	}
	public IFormModel createForm(String userId, IFormModel obj) throws SmartServerRuntimeException {
		Date date = new Date();
		
		obj.setId(null);
		obj.setFormId(IDCreator.createId(SmartServerConstant.FORM_ABBR));
		obj.setCreator(userId);
		obj.setCreatedTime(date);
		obj.setModifier(userId);
		obj.setModifiedTime(date);
		obj.setStatus(IFormModel.STATUS_CHECKED_OUT);
		
		// 폼 생성
		Serializable id = this.getHibernateTemplate().save(obj);
		obj = (HbFormModel)this.getHibernateTemplate().get(HbFormModel.class, id);
		
		// 워크 타입 생성
		IWorkTypeModel workType = new HbWorkTypeModel();
		workType.setName(obj.getName());
		workType.setFormUid(obj.getId());
		workType.setDuration(0);
		workType.setStepCount(1);
		workType.setType(IWorkTypeModel.WORKTYPE_COMMON);
		this.getHibernateTemplate().save(workType);
		
		return obj;
	}

	public IFormModel cloneForm(String userId, String formId, int version, String toPkgId, int toPkgVer, String newFormName) throws SmartServerRuntimeException {
		IFormModel frm = retrieveForm(formId, version);
		frm.setType(IFormModel.TYPE_NONE);
		frm.setPackageId(toPkgId);
		frm.setVersion(toPkgVer);
		if (newFormName != null && newFormName.length() != 0) {
			frm.setName(newFormName);
		} else {
			frm.setName("사본_" + frm.getName());
		}
		frm = createForm(userId, frm);
		
		String frmId = frm.getFormId();
		int frmVersion = frm.getVersion();
		String frmName = frm.getName();
		
		String frmCtt = retrieveFormContent(formId, version);
		if (frmCtt == null || frmCtt.length() == 0)
			return frm;
		
		Element docElem;
		try {
			docElem = XmlUtil.parse(frmCtt, false, "UTF-8").getDocumentElement();
			docElem.setAttribute("id", frmId);
			docElem.setAttribute("name", frmName);
			frmCtt = XmlUtil.elementToString(docElem, "UTF-8", true, true);
		} catch (Exception e) {
			throw new SmartServerRuntimeException(e);
		}
		updateFormContent(userId, frmId, frmVersion, frmCtt);
		
		return frm;
	}
	public IFormModel cloneForm(String userId, String formId, int version, String toPkgId, int toPkgVer) throws SmartServerRuntimeException {
		return cloneForm(userId, formId, version, toPkgId, toPkgVer, null);
	}
	
	public IPackageModel clonePackage(String userId, String categoryId, String packageId, int version) throws SmartServerRuntimeException {
		IPackageModel obj = this.retrievePackage(packageId, version);
		if (obj == null)
			return null;
		
		if (categoryId == null)
			categoryId = obj.getCategoryId();
		
		obj = (IPackageModel) Xml2Obj.convert(obj.toString(), "Package", HbPackageModel.class);
		
		String type = obj.getType();
		if (type == null)
			throw new SmartServerRuntimeException("Package type is null.");
		
		if (type.equals(IPackageModel.TYPE_PROCESS)) {
			IProcessModel prc = retrieveProcessByPackage(packageId, version);
			if (prc != null)
				obj.setContent(retrieveProcessContent(prc.getId()));
		} else if (type.equals(IPackageModel.TYPE_SINGLE)) {
			List<IFormModel> frmList = findSingleFormByPackage(packageId, version);
			if (frmList != null && !frmList.isEmpty()) {
				IFormModel frm = frmList.get(0);
				String frmCtt = retrieveFormContent(frm.getId());
				obj.setContent(frmCtt);
			}
		} else if (type.equals(IPackageModel.TYPE_GANTT)) {
			// TODO
		}
		List<IFormModel> frmList = findFormByPackage(packageId, version);
		List<String> frmCList = new ArrayList<String>();
		for (Iterator<IFormModel> itr = frmList.iterator(); itr.hasNext();) {
			IFormModel frm = itr.next();
			String frmType = frm.getType();
			if (frmType != null && frmType.equalsIgnoreCase(IFormModel.TYPE_SINGLE))
				continue;
			String frmCtt = retrieveFormContent(frm.getId());
			if (frmCtt == null)
				continue;
			frmCList.add(frmCtt);
		}
		if (!frmCList.isEmpty())
			obj.setFormContentList(frmCList);
		
		obj = SmartServerModelUtil.clonePackage(obj);
		obj.setCategoryId(categoryId);
		obj.setName("사본_" + obj.getName());
		return this.createPackage(userId, categoryId, obj);
	}
	
	public IPackageModel createPackage(String userId, String categoryId, IPackageModel pkg) throws SmartServerRuntimeException {
		try {
			Date currentTime = new Date();
			String type = pkg.getType();

			String pkgId = pkg.getPackageId();
			int version = pkg.getVersion();
			String name = pkg.getName();
			String desc = pkg.getDescription();
			String ctt = pkg.getContent();
			List<String> formCttList = pkg.getFormContentList();
			
			if (pkgId == null)
				pkgId = IDCreator.createId(SmartServerConstant.PACKAGE_ABBR);
			if (version <= 0)
				version = SmartServerConstant.START_VERSION;
			
			pkg.setPackageId(pkgId);
			pkg.setCategoryId(categoryId);
			pkg.setCreator(userId);
			pkg.setCreatedTime(currentTime);
			pkg.setModifier(userId);
			pkg.setModifiedTime(currentTime);
			pkg.setLatestDeployedYn(SmartServerConstant.YES_NO_N_VALUE);
			pkg.setStatus(IPackageModel.STATUS_UNDER_DEVEL);
			pkg.setVersion(version);
			this.getHibernateTemplate().save(pkg);

			if (type != null) {
				if (type.equals(IPackageModel.TYPE_PROCESS)) {
					IProcessModel prc = new HbProcessModel();
					String prcId = IDCreator.createId(SmartServerConstant.PROCESS_ABBR);
					prc.setProcessId(prcId);
					prc.setName(name);
					prc.setPackageId(pkgId);
					prc.setVersion(version);
					prc.setStatus(IProcessModel.STATUS_CHECKED_OUT);
					prc.setCreator(userId);
					prc.setCreatedTime(currentTime);
					prc.setModifier(userId);
					prc.setModifiedTime(currentTime);
					prc.setDescription(desc == null ? "" : desc);
					
					this.getHibernateTemplate().save(prc);
					
					if (ctt != null) {
						PackageType pkgType = ProcessModelHelper.load(ctt);
						ctt = SmartServerUtil.createProcessByTemplate(pkgType, userId, pkgId, prcId, version, name);
						this.updateProcessContent(prcId, version, ctt);
					}
					
				} else if (type.equals(IPackageModel.TYPE_SINGLE)) {
					Element docElem = null;
					String frmId = null;
					if (ctt != null) {
						docElem = XmlUtil.parse(ctt, false, "UTF-8").getDocumentElement();
						frmId = CommonUtil.toNull(docElem.getAttribute("id"));
					}
					IFormModel frm = new HbFormModel();
					if (frmId == null)
						frmId = IDCreator.createId(SmartServerConstant.FORM_ABBR);
					frm.setFormId(frmId);		
					frm.setCreator(userId);
					frm.setCreatedTime(currentTime);
					frm.setModifier(userId);
					frm.setModifiedTime(currentTime);
					frm.setName(name);
					frm.setPackageId(pkgId);
					frm.setVersion(version);
					frm.setType(IFormModel.TYPE_SINGLE);
					frm.setStatus(IFormModel.STATUS_CHECKED_OUT);
					frm.setDescription(desc == null ? "" : desc);
					
					this.getHibernateTemplate().save(frm);
					
					if (docElem != null) {
						docElem.setAttribute("id", frmId);
						docElem.setAttribute("name", name);
						docElem.setAttribute("title", name);
						ctt = XmlUtil.elementToString(docElem, "UTF-8", true, true);
						
						// 폼 생성
						this.updateFormContent(frmId, version, ctt);
					}
					
					// TODO 워크 타입 생성
					IWorkTypeModel workType = new HbWorkTypeModel();
					workType.setName(name);
					workType.setFormUid(frmId);
					workType.setDuration(0);
					workType.setStepCount(1);
					workType.setType(IWorkTypeModel.WORKTYPE_COMMON);
					this.getHibernateTemplate().save(workType);
					
				} else if (type.equals(IPackageModel.TYPE_GANTT)) {
					// TODO
				}
			}
			
			if (formCttList != null && !formCttList.isEmpty()) {
				for (Iterator<String> formItr = formCttList.iterator(); formItr.hasNext();) {
					String frmCtt = formItr.next();
					Element docElem = XmlUtil.parse(frmCtt, false, "UTF-8").getDocumentElement();
					String frmId = docElem.getAttribute("id");
					String frmName = docElem.getAttribute("name");
					
					IFormModel oldFrm = this.retrieveForm(frmId, version);
					if (oldFrm != null)
						throw new Exception("Already exist form.");
					
					IFormModel frm = new HbFormModel();
					frm.setFormId(frmId);		
					frm.setCreator(userId);
					frm.setCreatedTime(currentTime);
					frm.setModifier(userId);
					frm.setModifiedTime(currentTime);
					frm.setName(frmName);
					frm.setPackageId(pkgId);
					frm.setVersion(version);
					frm.setType(IFormModel.TYPE_NONE);
					if (type != null && type.equals(IPackageModel.TYPE_PROCESS) && ctt != null && ctt.indexOf(frmId) != -1)
						frm.setType(IFormModel.TYPE_PROCESS);
					frm.setStatus(IFormModel.STATUS_CHECKED_OUT);
					frm.setDescription("");
					
					// 폼 생성
					this.getHibernateTemplate().save(frm);
					this.updateFormContent(frmId, version, frmCtt);
					
					// 워크 타입 생성
					IWorkTypeModel workType = new HbWorkTypeModel();
					workType.setName(name);
					workType.setFormUid(frmId);
					workType.setDuration(0);
					workType.setStepCount(1);
					workType.setType(IWorkTypeModel.WORKTYPE_COMMON);
					this.getHibernateTemplate().save(workType);
				}
			}
			
			return pkg;
		} catch (SmartServerRuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new SmartServerRuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#createPackage(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public IPackageModel createPackage(String userId, String categoryId,
			String type, String name, String desc)
			throws SmartServerRuntimeException {
		
		IPackageModel pkg = new HbPackageModel();
		String pkgId = IDCreator.createId(SmartServerConstant.PACKAGE_ABBR);
		Date currentTime = new Date();
		pkg.setCategoryId(categoryId);
		pkg.setName(name);
		pkg.setType(type);
		pkg.setCreator(userId);
		pkg.setCreatedTime(currentTime);
		pkg.setModifier(userId);
		pkg.setModifiedTime(currentTime);
		pkg.setPackageId(pkgId);
		pkg.setLatestDeployedYn(SmartServerConstant.YES_NO_N_VALUE);
		pkg.setStatus(IPackageModel.STATUS_UNDER_DEVEL);
		pkg.setVersion(SmartServerConstant.START_VERSION);
		pkg.setDescription(desc == null ? "" : desc);
		this.getHibernateTemplate().save(pkg);
		
		// 프로세스 생성
		if(IPackageModel.TYPE_PROCESS.equals(type)) {
			String prcId = IDCreator.createId(SmartServerConstant.PROCESS_ABBR);
			IProcessModel prc = new HbProcessModel();
			prc.setName(pkg.getName());
			prc.setPackageId(pkgId);
			prc.setProcessId(prcId);
			prc.setVersion(SmartServerConstant.START_VERSION);
			prc.setStatus(IProcessModel.STATUS_CHECKED_OUT);
			prc.setCreator(userId);
			prc.setModifier(userId);
			prc.setCreatedTime(currentTime);
			prc.setModifiedTime(currentTime);
			prc.setDescription(desc == null ? "" : desc);
			
			this.getHibernateTemplate().save(prc);
			
			// 프로세스 템플릿 저장
			String tmpContent = null;
			try {
				PackageType templateXpdl = ProcessModelHelper.createProcessTemplate(this.processTemplateFile);
				tmpContent = SmartServerUtil.createProcessByTemplate(templateXpdl, userId, pkgId, prcId, 1, pkg.getName());
				
			} catch (Exception e) {
				throw new SmartServerRuntimeException("Failed to create template process!", e);
			}
			
			this.updateProcessContent(prcId, SmartServerConstant.START_VERSION, tmpContent);
			
		// 폼 생성
		} else if(IPackageModel.TYPE_SINGLE.equals(type)) {
			IFormModel frm = new HbFormModel();
			String frmId = IDCreator.createId(SmartServerConstant.FORM_ABBR);
			frm.setFormId(frmId);		
			frm.setCreator(userId);
			frm.setCreatedTime(currentTime);
			frm.setModifier(userId);
			frm.setModifiedTime(currentTime);
			frm.setName(name);
			frm.setPackageId(pkgId);
			frm.setVersion(SmartServerConstant.START_VERSION);
			frm.setType(IFormModel.TYPE_SINGLE);
			frm.setStatus(IFormModel.STATUS_CHECKED_OUT);
			frm.setDescription(desc == null ? "" : desc);
			
			// 폼 생성
			this.getHibernateTemplate().save(frm);
			
			// 워크 타입 생성
			IWorkTypeModel workType = new HbWorkTypeModel();
			workType.setName(name);
			workType.setFormUid(frmId);
			workType.setDuration(0);
			workType.setStepCount(1);
			workType.setType(IWorkTypeModel.WORKTYPE_COMMON);
			this.getHibernateTemplate().save(workType);
			
		// 일정계획 생성
		} else if(IPackageModel.TYPE_GANTT.equals(type)) {
			String prcId = IDCreator.createId(SmartServerConstant.PROCESS_ABBR);
			IProcessModel prc = new HbProcessModel();
			prc.setName(pkg.getName());
			prc.setPackageId(pkgId);
			prc.setProcessId(prcId);
			prc.setVersion(SmartServerConstant.START_VERSION);
			prc.setStatus(IProcessModel.STATUS_CHECKED_OUT);
			prc.setCreator(userId);
			prc.setModifier(userId);
			prc.setCreatedTime(currentTime);
			prc.setModifiedTime(currentTime);
			prc.setDescription(desc == null ? "" : desc);
			
			this.getHibernateTemplate().save(prc);
			
			// 프로세스 템플릿 저장
			String tmpContent = null;
			try {
				PackageType templateXpdl = ProcessModelHelper.createProcessTemplate(this.ganttTemplateFile);
				tmpContent = SmartServerUtil.createProcessByTemplate(templateXpdl, userId, pkgId, prcId, 1, pkg.getName());
				
			} catch (Exception e) {
				throw new SmartServerRuntimeException("Failed to create template gantt!", e);
			}
			
			this.updateProcessContent(prcId, SmartServerConstant.START_VERSION, tmpContent);
		} 
		
		return pkg;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#createPackage(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public IPackageModel createPackage(String userId, String categoryId,
			String name, String desc) throws SmartServerRuntimeException {
		
		IPackageModel pkg = new HbPackageModel();
		String pkgId = IDCreator.createId(SmartServerConstant.PACKAGE_ABBR);
		Date currentTime = new Date();
		pkg.setCategoryId(categoryId);
		pkg.setName(name);
		pkg.setCreator(userId);
		pkg.setCreatedTime(currentTime);
		pkg.setModifier(userId);
		pkg.setModifiedTime(currentTime);
		pkg.setPackageId(pkgId);
		pkg.setLatestDeployedYn(SmartServerConstant.YES_NO_N_VALUE);
		pkg.setStatus(IPackageModel.STATUS_UNDER_DEVEL);
		pkg.setVersion(SmartServerConstant.START_VERSION);
		pkg.setDescription(desc == null ? "" : desc);
		
		Serializable id = this.getHibernateTemplate().save(pkg);
		pkg = (HbPackageModel)this.getHibernateTemplate().get(HbPackageModel.class, id);		
		return pkg;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#createProcess(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	public IProcessModel createProcess(String userId, String packageId,
			int version, String sname) throws SmartServerRuntimeException {
		
		// 패키지 이름을 프로세스 이름과 같게 하기 위해서 패키지 찾기
		IPackageModel pkg = this.retrievePackage(packageId, version);
		
		// 프로세스 생성
		Date currentTime = new Date();
		String prcId = IDCreator.createId(SmartServerConstant.PROCESS_ABBR);
		IProcessModel prc = new HbProcessModel();
		prc.setName(pkg.getName());
		prc.setPackageId(packageId);
		prc.setProcessId(prcId);
		prc.setVersion(version);
		prc.setStatus(IProcessModel.STATUS_CHECKED_OUT);
		prc.setCreator(userId);
		prc.setModifier(userId);
		prc.setCreatedTime(currentTime);
		prc.setModifiedTime(currentTime);
		prc.setDescription("");
		
		Serializable id = this.getHibernateTemplate().save(prc);
		prc = (HbProcessModel)this.getHibernateTemplate().get(HbProcessModel.class, id);
		
		// 프로세스 템플릿 저장
		String tmpCtt = null;
		try {
			PackageType templateXpdl = ProcessModelHelper.createProcessTemplate(this.processTemplateFile);
			tmpCtt = SmartServerUtil.createProcessByTemplate(templateXpdl, userId, packageId, prcId, 1, pkg.getName());
			
		} catch (Exception e) {
			throw new SmartServerRuntimeException("Failed to create template process!", e);
		}
		
		this.updateProcessContent(prcId, version, tmpCtt);
		return prc;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#deleteForm(java.lang.String, java.lang.String)
	 */
	public void deleteForm(String userId, String formUid)
			throws SmartServerRuntimeException {
		
		IFormModel form = this.retrieveForm(formUid);
		this.deleteForm(userId, form);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#deleteForm(java.lang.String, java.lang.String, int)
	 */
	public void deleteForm(String userId, String formId, int version)
			throws SmartServerRuntimeException {
		
		IFormModel form = this.retrieveForm(formId, version);
		this.deleteForm(userId, form);
	}
	
	/**
	 * 폼을 삭제한다.
	 * 
	 * @param userId
	 * @param form
	 */
	public void deleteForm(String userId, IFormModel form) {
		
		// 1. 워크타입 삭제
		IWorkTypeModel workTypeModel = this.retrieveWorkTypeByForm(form.getFormId(), form.getVersion());
		if(workTypeModel != null)
			this.getHibernateTemplate().delete(workTypeModel);
		// 2. 도메인 삭제
		if(IFormModel.TYPE_SINGLE.equals(form.getType()))
			SmartServerManager.getInstance().getDomainManager().undeployDomain(userId, form.getFormId(), form.getVersion());
		
		// 3. 폼 삭제
		this.getHibernateTemplate().delete(form);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#deletePackage(java.lang.String, java.lang.String, int)
	 */
	public void deletePackage(String userId, String packageId, int version)
			throws SmartServerRuntimeException {
		
		IPackageModel pkg = this.retrievePackage(packageId, version);
		if(pkg == null)
			throw new SmartServerRuntimeException("Not found package id [" + packageId + "], version [" + version + "]!");
		
		// 배치 상태라면 도메인 배치해제가 안 됨
		if(IPackageModel.STATUS_DEPLOYED.equals(pkg.getStatus()))
			throw new SmartServerRuntimeException("Can not delete package! Package [" + pkg.getName() + "] status is [" + pkg.getStatus() + "]. Please undeploy package before delete!");
		
		Session session = this.getSession();
		// 폼 삭제
		List<IFormModel> formList = this.findFormByPackage(packageId, version);
		if(formList != null && !formList.isEmpty()) {
			for(IFormModel form : formList)
				this.deleteForm(userId, form);
		}
		
		// 프로세스 삭제
		Query query = session.createQuery("delete HbProcessModel where packageId = '" + packageId + "' and version = " + version);
		query.executeUpdate();
		
		// latestDeployedYn이 Y라면 동일 패키지의 다른 버전의 패키지에 Y를 넘겨준다.
		String sql = "select count(*) from SWPackage where latestDeployedYn = '" + SmartServerConstant.YES_NO_Y_VALUE + "' and packageId = '" + packageId + "' and version =" + version;
		query = session.createSQLQuery(sql);
		Object count = query.uniqueResult();
		int yCount = Integer.parseInt(count.toString());
		
		// 패키지 삭제
		query = session.createQuery("delete HbPackageModel where packageId = '" + packageId + "' and version = " + version);
		query.executeUpdate();
		
		if(yCount > 0) {
			String hql = "update HbPackageModel set latestDeployedYn = '" + SmartServerConstant.YES_NO_Y_VALUE + "' ";
			hql += "where status = '" + IPackageModel.STATUS_DEPLOYED + "' and packageId = '" + packageId + "' and version = (";
			hql += "	select max(version) from HbPackageModel where packageId = '" + packageId + "' and latestDeployedYn = '" + SmartServerConstant.YES_NO_N_VALUE + "' and status = '" + IPackageModel.STATUS_DEPLOYED + "'";
			hql += ")";
			query = session.createQuery(hql);
			query.executeUpdate();
		}
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#deletePackageAll(java.lang.String, java.lang.String)
	 */
	public void deletePackageAll(String userId, String packageId)
			throws SmartServerRuntimeException {
		
		Session session = this.getSession();
		
		// 폼 삭제
		Query query = session.createQuery("from HbFormModel where packageId = '" + packageId + "'");
		List<IFormModel> formList = query.list();		
		if(formList != null && !formList.isEmpty()) {
			for(IFormModel form : formList)
				this.deleteForm(userId, form);
		}
		
		// 프로세스 삭제
		query = session.createQuery("delete HbProcessModel where packageId = '" + packageId + "'");
		query.executeUpdate();
		
		// 패키지 삭제
		query = session.createQuery("delete HbPackageModel where packageId = '" + packageId + "'");
		query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#deleteProcess(java.lang.String, java.lang.String)
	 */
	public void deleteProcess(String userId, String processUid)
			throws SmartServerRuntimeException {
		
		Query query = this.getSession().createQuery("delete HbProcessModel where id = '" + processUid + "'");
		query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#deleteProcess(java.lang.String, java.lang.String, int)
	 */
	public void deleteProcess(String uesrId, String processId, int version)
			throws SmartServerRuntimeException {
		
		Query query = this.getSession().createQuery("delete HbProcessModel where processId = '" + processId + "' and version = " + version);
		query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#findFormByProcess(java.lang.String, int)
	 */
	public List<IFormModel> findFormByProcess(String processId, int version)
			throws SmartServerRuntimeException {
		
		// 프로세스에 소속된 폼만을 찾는다. 같은 패키지에 소속되어 있으면서 프로세스에 소속되지 않은 폼도 있다.
		String hql = "from HbFormModel where type = '" + IFormModel.TYPE_PROCESS + "' and version =" + version + " and packageId = (";
		hql += "select packageId from HbProcessModel where processId = '" + processId + "' and version =" + version;
		hql += ")";
		Query query = this.getSession().createQuery(hql);
		List<IFormModel> formList = query.list();
		return formList;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#findFormByProcess(java.lang.String)
	 */
	public List<IFormModel> findFormByProcess(String processUid)
			throws SmartServerRuntimeException {
		
		// 프로세스에 소속된 폼만을 찾는다. 같은 패키지에 소속되어 있으면서 프로세스에 소속되지 않은 폼도 있다.
		String hql = "from HbFormModel where type = '" + IFormModel.TYPE_PROCESS + "' and packageId = (";
		hql += "select packageId from HbProcessModel where id = '" + processUid + "'";
		hql += ") and version = (";
		hql += "select version from HbProcessModel where id = '" + processUid + "'";
		hql += ")";
		Query query = this.getSession().createQuery(hql);
		List<IFormModel> formList = query.list();
		return formList;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#findFormByPackage(java.lang.String, int)
	 */
	public List<IFormModel> findFormByPackage(String packageId, int version)
			throws SmartServerRuntimeException {
		
		String hql = "from HbFormModel where packageId = '" + packageId + "' and version = " + version;
		Query query = this.getSession().createQuery(hql);
		return query.list();
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#findLatestFormByPackage(java.lang.String)
	 */
	public List<IFormModel> findLatestFormByPackage(String packageId)
			throws SmartServerRuntimeException {

		String hql = "from HbFormModel where packageId = '" + packageId + "' and version = (";
		hql += "select max(version) from HbFormModel where packageId = '" + packageId + "'";
		hql += ")";
		Query query = this.getSession().createQuery(hql);
		return query.list();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#findLatestFormByProcess(java.lang.String)
	 */
	public List<IFormModel> findLatestFormByProcess(String processId)
			throws SmartServerRuntimeException {
		
		// 프로세스에 소속된 폼만을 찾는다. 같은 패키지에 소속되어 있으면서 프로세스에 소속되지 않은 폼도 있다.
		IProcessModel prc = this.retrieveLatestProcess(processId);
		String hql = "from HbFormModel where type = '" + IFormModel.TYPE_PROCESS + "' and version =" + prc.getVersion() + " and packageId = (";
		hql += "select packageId from HbProcessModel where processId = '" + processId + "' and version =" + prc.getVersion();
		hql += ")";
		Query query = this.getSession().createQuery(hql);
		List<IFormModel> formList = query.list();
		return formList;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#findSingleFormByPackage(java.lang.String, java.lang.String, int)
	 */
	public List<IFormModel> findSingleFormByPackage(String packageId, int version) throws SmartServerRuntimeException {
		
		String hql = "from HbFormModel where type = '" + IFormModel.TYPE_SINGLE + "' and version =" + version + " and packageId = '" + packageId + "'";
		Query query = this.getSession().createQuery(hql);
		List<IFormModel> formList = query.list();
		return formList;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#findProcessVersionList(java.lang.String)
	 */
	public List<IProcessModel> findProcessVersionList(String processId)
			throws SmartServerRuntimeException {
		
		String hql = "from HbProcessModel where processId = '" + processId + "'";
		Query query = this.getSession().createQuery(hql);
		return query.list();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#findProcessVersions(java.lang.String)
	 */
	public List<Integer> findProcessVersions(String processId)
			throws SmartServerRuntimeException {
		
		String hql = "select version from HbProcessModel where processId = '" + processId + "'";
		Query query = this.getSession().createQuery(hql);
		List<Integer> versions = query.list();
		return versions;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#findFormVersions(java.lang.String)
	 */
	public List<Integer> findFormVersions(String formId)
			throws SmartServerRuntimeException {
		
		String hql = "select version from HbFormModel where formId = '" + formId + "'";
		Query query = this.getSession().createQuery(hql);
		List<Integer> versions = query.list();
		return versions;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#findFormFieldByPackage(java.lang.String, int)
	 */
	public List<IFormDef> findFormFieldByPackage(String packageId, int version)
			throws SmartServerRuntimeException {
		
		// 1. packageId, version으로 모든 폼 아이디, 버전을 찾는다.
		Session session = this.getSession();
		Query query = session.createQuery("from HbFormContent where packageId = :packageId and version = :version");
		query.setString("packageId", packageId);
		query.setInteger("version", version);
		List<IFormContent> formContentList = query.list();
		if(CommonUtil.isEmpty(formContentList))
			return new ArrayList<IFormDef>();
		
		// 2. 폼 아이디, 버전으로 모든 폼 필드를 찾는다.
		List<IFormDef> result = new ArrayList<IFormDef>();
		for(IFormContent content : formContentList) {
			if(content.getContent() != null) {
				IFormDef formDef = SmartServerModelUtil.xmlToForm(content.getContent());
				result.add(formDef);
			}
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#findFormFieldByForm(java.lang.String, boolean)
	 */
	public List<IFormFieldDef> findFormFieldByForm(String formId,
			boolean deployedCondition) throws SmartServerRuntimeException {
		
		// 폼 아이디로 가장 최근 버전의 
		Session session = this.getSession();
		StringBuffer hql = new StringBuffer("from HbFormContent where formId = :formId and version = (");
		hql.append("select max(version) from HbFormContent where formId = :formId");
		// 배포된 폼만 검색하기를 원할 경우
		if(deployedCondition) 
			hql.append(" and status = '").append(IFormModel.STATUS_DEPLOYED).append("'");
		hql.append(")");
		
		Query query = session.createQuery(hql.toString());
		query.setString("formId", formId);
		IFormContent formContent = (IFormContent)query.uniqueResult();
		if(formContent == null || formContent.getContent() == null)
			return  new ArrayList<IFormFieldDef>();

		List<IFormFieldDef> result = new ArrayList<IFormFieldDef>();
		IFormDef formDef = SmartServerModelUtil.xmlToForm(formContent.getContent());
		for (Iterator<IFormFieldDef> fieldDefIt = formDef.getFormFieldMap().values().iterator(); fieldDefIt.hasNext();) 
			result.add(fieldDefIt.next());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#findWorkType(java.lang.String, int)
	 */
	public List<IWorkTypeModel> findWorkType(String packageId, int version)
			throws SmartServerRuntimeException {
		
		String hql = "from HbWorkTypeModel where formUid in (";
		hql += "select id from HbFormModel where packageId = '" + packageId + "' and version =" + version;
		hql += ")";
		Query query = this.getSession().createQuery(hql);
		return query.list();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveForm(java.lang.String)
	 */
	public IFormModel retrieveForm(String formUid)
			throws SmartServerRuntimeException {
		
		String hql = "from HbFormModel where id = '" + formUid + "'";
		Query query = this.getSession().createQuery(hql);
		return (IFormModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveForm(java.lang.String, int)
	 */
	public IFormModel retrieveForm(String formId, int version)
			throws SmartServerRuntimeException {
		String hql = "from HbFormModel where formId = :formId and version = :version";
		Query query = this.getSession().createQuery(hql);
		query.setString("formId", formId);
		query.setInteger("version", version);
		return (IFormModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveFormContent(java.lang.String)
	 */
	public String retrieveFormContent(String formUid)
			throws SmartServerRuntimeException {

		String hql = "from HbFormContent where id = '" + formUid + "'";
		Query query = this.getSession().createQuery(hql);
		IFormContent formModel = (HbFormContent)query.uniqueResult();
		return formModel != null ? formModel.getContent() : null;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveFormContent(java.lang.String, int)
	 */
	public String retrieveFormContent(String formId, int version)
			throws SmartServerRuntimeException {
		
		String hql = "from HbFormContent where formId = '" + formId + "' and version = " + version;
		Query query = this.getSession().createQuery(hql);
		IFormContent formModel = (HbFormContent)query.uniqueResult();
		return formModel != null ? formModel.getContent() : null;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveLatestForm(java.lang.String)
	 */
	public IFormModel retrieveLatestForm(String formId)
			throws SmartServerRuntimeException {
		
		String hql = "from HbFormModel where formId = '" + formId + "' and version = (";
		hql += "select max(version) from HbFormModel where formId = '" + formId + "'";
		hql += ")";
		Query query = this.getSession().createQuery(hql);
		return (IFormModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveLatestFormContent(java.lang.String)
	 */
	public String retrieveLatestFormContent(String formId)
			throws SmartServerRuntimeException {
		
		String hql = "from HbFormContent where formId = '" + formId + "' and version = (";
		hql += "select max(version) from HbFormModel where formId = '" + formId + "'";
		hql += ")";		
		Query query = this.getSession().createQuery(hql);
		IFormContent formModel = (HbFormContent)query.uniqueResult();
		return formModel != null ? formModel.getContent() : null;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveLatestFormVersion(java.lang.String)
	 */
	public int retrieveLatestFormVersion(String formId)
			throws SmartServerRuntimeException {
		
		String hql = "select max(version) from HbFormModel where formId = '" + formId + "'";
		Query query = this.getSession().createQuery(hql);
		Object obj  = query.uniqueResult();
		
		if(obj != null) 
			return ((Integer)obj).intValue();
		else 
			throw new SmartServerRuntimeException("Not found form - formId [" + formId + "]");
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveLatestPackage(java.lang.String)
	 */
	public IPackageModel retrieveLatestPackage(String packageId)
			throws SmartServerRuntimeException {
		
		String hql = "from HbPackageModel where packageId = '" + packageId + "' and version = (";
		hql += "select max(version) from HbPackageModel where packageId = '" + packageId + "'";
		hql += ")";
		Query query = this.getSession().createQuery(hql);
		IPackageModel obj = (IPackageModel)query.uniqueResult();
		this.fillType(obj);
		return obj;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveLatestPackageVersion(java.lang.String)
	 */
	public int retrieveLatestPackageVersion(String packageId)
			throws SmartServerRuntimeException {
		
		String hql = "select max(version) from HbPackageModel where packageId = '" + packageId + "'";
		Query query = this.getSession().createQuery(hql);
		Object obj  = query.uniqueResult();
		
		if(obj != null) 
			return ((Integer)obj).intValue();
		else 
			throw new SmartServerRuntimeException("Not found package - packageId [" + packageId + "]");
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveLatestProcess(java.lang.String)
	 */
	public IProcessModel retrieveLatestProcess(String processId)
			throws SmartServerRuntimeException {
		
		String hql = "from HbProcessModel where processId = '" + processId + "' and version = (";
		hql += "select max(version) from HbProcessModel where processId = '" + processId + "'";
		hql += ")";
		Query query = this.getSession().createQuery(hql);
		return (IProcessModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveLatestProcessByPackage(java.lang.String)
	 */
	public IProcessModel retrieveLatestProcessByPackage(String packageId)
			throws SmartServerRuntimeException {
		
		String hql = "from HbProcessModel where packageId = '" + packageId + "' and version = (";
		hql += "select max(version) from HbPackageModel where packageId = '" + packageId + "'";
		hql += ")";
		Query query = this.getSession().createQuery(hql);
		return (IProcessModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveLatestProcessContent(java.lang.String)
	 */
	public String retrieveLatestProcessContent(String processId)
			throws SmartServerRuntimeException {
		
		String hql = "from HbProcessContent where processId = '" + processId + "' and version = (";
		hql += "select max(version) from HbProcessContent where processId = '" + processId + "'";
		hql += ")";
		Query query = this.getSession().createQuery(hql);
		IProcessContent prcContent =  (IProcessContent)query.uniqueResult();
		return prcContent != null ? prcContent.getContent() : null;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveLatestProcessVersion(java.lang.String)
	 */
	public int retrieveLatestProcessVersion(String processId)
			throws SmartServerRuntimeException {
		
		String hql = "select max(version) from HbProcessModel where processId = '" + processId + "'";
		Query query = this.getSession().createQuery(hql);
		Object obj  = query.uniqueResult();
		
		if(obj != null) 
			return ((Integer)obj).intValue();
		else 
			throw new SmartServerRuntimeException("Not found process - processId [" + processId + "]");
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrievePackage(java.lang.String, int)
	 */
	public IPackageModel retrievePackage(String packageId, int version)
			throws SmartServerRuntimeException {
		String hql = "from HbPackageModel where packageId = '" + packageId + "' and version = " + version;
		Query query = this.getSession().createQuery(hql);
		IPackageModel obj = (IPackageModel)query.uniqueResult();
		this.fillType(obj);
		return obj;
	}
	private void fillType(IPackageModel obj) throws SmartServerRuntimeException {
		if (obj == null)
			return;
		String type = obj.getType();
		if (type != null && type.length() != 0)
			return;
		String id = obj.getPackageId();
		int ver = obj.getVersion();
		IProcessModel prc = this.retrieveProcessByPackage(id, ver);
		if (prc != null) {
			obj.setType(IPackageModel.TYPE_PROCESS);
			return;
		}
		List list = this.findSingleFormByPackage(id, ver);
		if (list != null && !list.isEmpty()) {
			obj.setType(IPackageModel.TYPE_SINGLE);
			return;
		}
		// TODO GANTT
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveProcess(java.lang.String)
	 */
	public IProcessModel retrieveProcess(String processUid)
			throws SmartServerRuntimeException {
		
		String hql = "from HbProcessModel where id = '" + processUid + "'";
		Query query = this.getSession().createQuery(hql);
		return (IProcessModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveProcess(java.lang.String, int)
	 */
	public IProcessModel retrieveProcess(String processId, int version)
			throws SmartServerRuntimeException {
		
		String hql = "from HbProcessModel where processId = '" + processId + "' and version = " + version;
		Query query = this.getSession().createQuery(hql);
		return (IProcessModel)query.uniqueResult();
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveProcessByPackage(java.lang.String, int)
	 */
	public IProcessModel retrieveProcessByPackage(String packageId, int version)
			throws SmartServerRuntimeException {
		
		String hql = "from HbProcessModel where packageId = '" + packageId + "' and version = " + version;
		Query query = this.getSession().createQuery(hql);
		return (IProcessModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveProcessContent(java.lang.String)
	 */
	public String retrieveProcessContent(String processUid)
			throws SmartServerRuntimeException {
		
		String hql = "from HbProcessContent where id = '" + processUid + "'";
		Query query = this.getSession().createQuery(hql);
		IProcessContent prcContent =  (IProcessContent)query.uniqueResult();
		return prcContent != null ? prcContent.getContent() : null;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveProcessContent(java.lang.String, int)
	 */
	public String retrieveProcessContent(String processId, int version)
			throws SmartServerRuntimeException {
		
		String hql = "from HbProcessContent where processId = '" + processId + "' and version = " + version;
		Query query = this.getSession().createQuery(hql);
		IProcessContent prcContent =  (IProcessContent)query.uniqueResult();
		return prcContent != null ? prcContent.getContent() : null;
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveWorkType(java.lang.String)
	 */
	public IWorkTypeModel retrieveWorkType(String workTypeId)
			throws SmartServerRuntimeException {

		String hql = "from HbWorkTypeModel where id = '" + workTypeId + "'";
		Query query = this.getSession().createQuery(hql);
		return (IWorkTypeModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveWorkTypeByForm(java.lang.String)
	 */
	public IWorkTypeModel retrieveWorkTypeByForm(String formUid)
			throws SmartServerRuntimeException {
		
		String hql = "from HbWorkTypeModel where formUid = '" + formUid + "'";
		Query query = this.getSession().createQuery(hql);
		return (IWorkTypeModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#retrieveWorkTypeByForm(java.lang.String, int)
	 */
	public IWorkTypeModel retrieveWorkTypeByForm(String formId, int version)
			throws SmartServerRuntimeException {
		StringBuffer hql = new StringBuffer("from HbWorkTypeModel where formUid = ");
		hql.append("(select id from HbFormModel where formId = :formId and version = :version)");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString("formId", formId);
		query.setInteger("version", version);
		return (IWorkTypeModel)query.uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#updateForm(java.lang.String, com.maninsoft.smart.server.model.IFormModel)
	 */
	public IFormModel updateForm(String userId, IFormModel obj) throws SmartServerRuntimeException {
		// TODO interceptor로 빠져야 할 내용 Start
		String type = obj.getType();
		if (type != null && type.equalsIgnoreCase(IFormModel.TYPE_SINGLE)) {
			if (obj.getPackageId() != null) {
				IPackageModel pkg = this.retrievePackage(obj.getPackageId(), obj.getVersion());
				if (pkg != null && !CommonUtil.isEqual(obj.getName(), pkg.getName())) {
					pkg.setName(obj.getName());
					this.update(userId, pkg);
				}
			}
		}
		// TODO interceptor로 빠져야 할 내용 End
		
		obj.setModifier(userId);
		obj.setModifiedTime(new Date());
		this.getHibernateTemplate().update(obj);
		
		// 2. FORM의 XML내의  메타정보 변경
		this.updateFormContentMetaInfo(obj);
				
		// 3. WORKTYPE  메타정보 변경
		this.updateWorkTypeMetaInfo(obj);
		
		// 4. 도메인 폼  메타정보 변경
		this.updateDomainMetaInfo(obj);
		
		return (HbFormModel)this.getHibernateTemplate().get(HbFormModel.class, obj.getId());
	}
	private void updateFormContentMetaInfo(IFormModel obj) throws SmartServerRuntimeException {
		String id = obj.getFormId();
		int ver = obj.getVersion();
		String name = obj.getName();
		String content = this.retrieveFormContent(id, ver);
		try {
			if (content != null) {
				Element docElem = XmlUtil.parse(content, false, "UTF-8").getDocumentElement();
				if (CommonUtil.isEqual(docElem.getAttribute("name"), name) && 
					CommonUtil.isEqual(docElem.getAttribute("title"), name))
					return;

				docElem.setAttribute("name", name);
				docElem.setAttribute("title", name);
				content = XmlUtil.elementToString(docElem, "UTF-8", true, true);
				
				this.updateFormContent(id, ver, content);
			}
		} catch (Exception e) {
			throw new SmartServerRuntimeException("Failed to update title at form content, formId [" + id + "], version [" + ver + "]!", e);
		}
	}
	private void updateWorkTypeMetaInfo(IFormModel obj) throws SmartServerRuntimeException {
		String id = obj.getId();
		int ver = obj.getVersion();
		String name = obj.getName();
		
		String hql = "update HbWorkTypeModel set name = :name where formUid = (select id from HbFormModel where formId = :formId and version = :version)";
		Query query = this.getSession().createQuery(hql);
		query.setString("name", name);
		query.setString("formId", id);
		query.setInteger("version", ver);
		query.executeUpdate();
	}
	private void updateDomainMetaInfo(IFormModel obj) throws SmartServerRuntimeException {
		String id = obj.getId();
		int ver = obj.getVersion();
		String name = obj.getName();
		
		Query query = this.getSession().createSQLQuery("update SWDomain set formName = :name where formId = :formId");
		query.setString("name", name);
		query.setString("formId", id);
		query.executeUpdate();
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#updateFormName(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	public void updateFormName(String userId, String formId, int version, String formName)
			throws SmartServerRuntimeException {
		IFormModel obj = this.retrieveForm(formId, version);
		if (obj == null)
			return;
		
		if (CommonUtil.isEqual(obj.getName(), formName))
			return;
		
		obj.setName(formName);
		updateForm(userId, obj);
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#updateProcessName(java.lang.String, int, java.lang.String)
	 */
	public void updateProcessName(String processId, int version, String processName) throws SmartServerRuntimeException {
		IProcessModel obj = this.retrieveProcess(processId, version);
		if (obj == null)
			return;
		
		if (CommonUtil.isEqual(obj.getName(), processName))
			return;
		
		obj.setName(processName);
		this.updateProcess(obj.getModifier(), obj);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#updateFormContent(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void updateFormContent(String userId, String formUid,
			String xmlContent) throws SmartServerRuntimeException {
		
		IFormModel form = this.retrieveForm(formUid);
		
		System.out.println("************************");
		System.out.println(form.getId() + " : " + form.toString());
		System.out.println("************************");
		
		
		this.updateFormContent(userId, form.getFormId(), form.getVersion(), xmlContent);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#updateFormContent(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	public void updateFormContent(String userId, String formId, int version,
			String content) throws SmartServerRuntimeException {
		
		this.enableFormUpdate(userId, formId, version);
		
		updateFormContent(formId, version, content);
	}
	private void updateFormContent(String formId, int version, String content) throws SmartServerRuntimeException {
		String hql = "update HbFormContent set content = :content where formId = :formId and version = :version";
		Query query = this.getSession().createQuery(hql);
		query.setString("content", content);
		query.setString("formId", formId);
		query.setInteger("version", version);
		query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#updateLatestFormContent(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void updateLatestFormContent(String userId, String formId,
			String xmlContent) throws SmartServerRuntimeException {
		
		IFormModel form = this.retrieveLatestForm(formId);
		
		if(form != null)
			this.updateFormContent(userId, form.getId(), xmlContent);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#updateLatestProcessContent(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void updateLatestProcessContent(String userId, String processId, String xmlContent) throws SmartServerRuntimeException {
		IProcessModel prc = this.retrieveLatestProcess(processId);
		if(prc != null)
			this.updateProcessContent(userId, prc.getId(), xmlContent);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#updatePackage(java.lang.String, com.maninsoft.smart.server.model.IPackageModel)
	 */
	public IPackageModel updatePackage(String userId, IPackageModel obj)
			throws SmartServerRuntimeException {
		boolean isTypeNull = obj.getType() == null;
		
		obj = update(userId, obj);
		
		// TODO interceptor로 빠져야 할 내용 Start
		String pkgId = obj.getPackageId();
		int ver = obj.getVersion();
		String type = obj.getType();
		IProcessModel prc = null;
		List<IFormModel> frmList = null;
		if (type == null || type.length() == 0) {
			
		} else if (type.equals(IPackageModel.TYPE_PROCESS)) {
			prc = this.retrieveProcessByPackage(pkgId, ver);
		} else if (type.equals(IPackageModel.TYPE_SINGLE)) {
			frmList = this.findSingleFormByPackage(pkgId, ver);
		}
		if (prc == null && frmList == null) {
			prc = this.retrieveProcessByPackage(pkgId, ver);
			frmList = this.findSingleFormByPackage(pkgId, ver);
		}

		if (prc != null) {
			if (!CommonUtil.isEqual(obj.getName(), prc.getName()) || !CommonUtil.isEqual(obj.getDescription(), prc.getDescription())) {
				prc.setName(obj.getName());
				prc.setDescription(obj.getDescription());
				updateProcess(userId, prc);
			} else if (isTypeNull) {
				this.fillType(obj);
				obj = update(userId, obj);
			}
			return obj;
		} else if (frmList != null && !frmList.isEmpty()) {
			IFormModel frm = null;
			IFormModel frmTmp = null;
			String frmType = null;
			for (Iterator<IFormModel> frmItr = frmList.iterator(); frmItr.hasNext();) {
				frmTmp = frmItr.next();
				frmType = frmTmp.getType();
				if (frmType == null || frmType.equals(IFormModel.TYPE_NONE) || frmType.equals(IFormModel.TYPE_PROCESS))
					continue;
				frm = frmTmp;
				break;
			}
			if (frm != null) {
				if (!CommonUtil.isEqual(obj.getName(), frm.getName()) || !CommonUtil.isEqual(obj.getDescription(), frm.getDescription())) {
					frm.setName(obj.getName());
					frm.setDescription(obj.getDescription());
					updateForm(userId, frm);
				} else if (isTypeNull) {
					this.fillType(obj);
					obj = update(userId, obj);
				}
				return obj;
			}
		} else {
			return obj;
		}
		// TODO interceptor로 빠져야 할 내용 End
		
		return obj;
	}
	private IPackageModel update(String userId, IPackageModel pkg) throws SmartServerRuntimeException {
		pkg.setModifier(userId);
		pkg.setModifiedTime(new Date());
		this.getHibernateTemplate().update(pkg);
		return (HbPackageModel)this.getHibernateTemplate().get(HbPackageModel.class, pkg.getId());
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#updateProcess(java.lang.String, com.maninsoft.smart.server.model.IProcessModel)
	 */
	public IProcessModel updateProcess(String userId, IProcessModel obj)
			throws SmartServerRuntimeException {
		// TODO interceptor로 빠져야 할 내용 Start
		if (obj.getPackageId() != null) {
			IPackageModel pkg = this.retrievePackage(obj.getPackageId(), obj.getVersion());
			if (pkg != null && !CommonUtil.isEqual(obj.getName(), pkg.getName())) {
				pkg.setName(obj.getName());
				this.update(userId, pkg);
			}
		}
		// TODO interceptor로 빠져야 할 내용 End
		
		// 프로세스 모델 업데이트
		obj.setModifier(userId);
		obj.setModifiedTime(new Date());
		this.getHibernateTemplate().update(obj);
		
		// 프로세스의 XML내의 메타정보 변경
		updateProcessContentMetaInfo(obj);
		
		return this.retrieveProcess(obj.getId());
	}
	private void updateProcessContentMetaInfo(IProcessModel obj) throws SmartServerRuntimeException {
		String prcId = obj.getProcessId();
		int ver = obj.getVersion();
		String name = obj.getName();
		String ctt = this.retrieveProcessContent(prcId, ver);
		try {
			PackageType pkg = ProcessModelHelper.load(ctt);
			ProcessType1 prc = (ProcessType1)pkg.getWorkflowProcesses().getWorkflowProcess().get(0);
			
			boolean xpdlChanged = false;
			if (!CommonUtil.isEqual(pkg.getName(), name)) {
				pkg.setName(name);
				xpdlChanged = true;
			}
			if (prc != null && !CommonUtil.isEqual(prc.getName(), name)) {
				prc.setName(name);
				xpdlChanged = true;
			}
			
			if (xpdlChanged) {
				ctt = ProcessModelHelper.save(pkg, "UTF-8");
				this.updateProcessContent(prcId, ver, ctt);
			}
		} catch (Exception e) {
			throw new SmartServerRuntimeException("Failed to update title at process content, processId [" + prcId + "], version [" + ver + "]!", e);
		}
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#updateProcessContent(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void updateProcessContent(String userId, String processUid, String xmlContent) throws SmartServerRuntimeException {
		IProcessModel prc = this.retrieveProcess(processUid);
		if(prc != null)
			this.updateProcessContent(userId, prc.getProcessId(), prc.getVersion(), xmlContent);
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#updateProcessContent(java.lang.String, java.lang.String, int, java.lang.String)
	 */
	public void updateProcessContent(String userId, String prcId,
			int version, String xmlContent) throws SmartServerRuntimeException {
		
		IProcessModel prc = this.retrieveProcess(prcId, version);
		if (prc == null)
			throw new SmartServerRuntimeException(new StringBuffer("Cannot find process process:").append(prcId).append(" version:").append(version).append(".").toString());
		
		this.enableProcessUpdate(userId, prc);
		
		PackageType xpdl = null;
		try {
			xpdl = ProcessModelHelper.load(xmlContent);
		} catch (Exception e) {
			throw new SmartServerRuntimeException("Invalid process content!", e);
		}
		
		// process xml로 부터 모든 폼 정보를 추출하여 추출된 모든 폼은 프로세스 타입으로 해당 패키지에 있지만 프로세스에 소속되지 않은 폼은 단위업무 타입으로 업데이트한다.
		List<IFormModel> formList = this.findFormByPackage(prc.getPackageId(), version);
		List<String> processTypeFormIdList = new ArrayList<String>();
		
		// xpdl에 속한 모든 폼 아이디 리스트를 추출
		if(xpdl.getWorkflowProcesses().getWorkflowProcess() != null && xpdl.getWorkflowProcesses().getWorkflowProcess().size() > 0) {
			ProcessType1 processType = (ProcessType1)xpdl.getWorkflowProcesses().getWorkflowProcess().get(0);
			Activities acts = processType.getActivities();
			
			if(acts != null) {
				List actList = acts.getActivity();
				for(int i = 0 ; i < actList.size() ; i++) {
					Activity act = (Activity)actList.get(i);
					
					if(act.isSetImplementation()) {
						Implementation7 imp = act.getImplementation();
						if(imp.isSetTask()) {
							Task task = imp.getTask();
							if(task.isSetTaskApplication()) {
								TaskApplication taskApp = task.getTaskApplication();
								String taskAppId = taskApp.getName();
								processTypeFormIdList.add(taskAppId);
							}
						}
					}
				}
			}
		}
		
		Session session = this.getSession();
		Query query = null;
		
		// xpdl에 속한 모든 폼 아이디는 프로세스 타입으로 나머지는 단위업무 타입으로 타입 변경
		if(formList != null) {
			for(IFormModel form : formList) {
				
				String hql = null;
				if(processTypeFormIdList.contains(form.getFormId()))
					hql = "update HbFormModel set type = '" + IFormModel.TYPE_PROCESS + "' where formId = '" + form.getFormId() + "' and version =" + version;
				else
					hql = "update HbFormModel set type = '" + IFormModel.TYPE_NONE + "' where formId = '" + form.getFormId() + "' and version =" + version;
				
				query = session.createQuery(hql);
				query.executeUpdate();				
			}
		}
		
		this.updateProcessContent(prcId, version, xmlContent);
		
		prc.setModifier(userId);
		prc.setModifiedTime(new Date());
		prc.setName(xpdl.getName());
		this.getHibernateTemplate().update(prc);
	}
	private void updateProcessContent(String processId, int version, String content) throws SmartServerRuntimeException {
		String hql = "update HbProcessContent set content = :content where processId = :processId and version = :version";
		Query query = this.getSession().createQuery(hql);
		query.setString("content", content);
		query.setString("processId", processId);
		query.setInteger("version", version);
		query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#updateWorkType(java.lang.String, com.maninsoft.smart.server.model.IWorkTypeModel)
	 */
	public IWorkTypeModel updateWorkType(String userId, IWorkTypeModel workType)
			throws SmartServerRuntimeException {
		
		this.getHibernateTemplate().update(workType);
		return (IWorkTypeModel)this.getHibernateTemplate().get(HbWorkTypeModel.class, workType.getId());
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#searchFormByCondition(java.util.Map, int, int)
	 */
	public IFormModelList searchFormByCondition(Map<String, Object> condition,
			int pageCount, int recordCount) throws SmartServerRuntimeException {
		
		IFormModelList list = new HbFormModelList();
		int totalCount = this.searchFormCount(condition);
		list.setTotalCount(totalCount);
		
		if(totalCount < 1) {
			list.setFormModelList(new ArrayList<IFormModel>());
			return list;
		}
		
		StringBuffer hql = new StringBuffer("from HbFormModel where id is not null ");
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
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#searchFormCount(java.util.Map)
	 */
	public int searchFormCount(Map<String, Object> condition)
			throws SmartServerRuntimeException {
		
		StringBuffer hql = new StringBuffer("select count(*) from HbFormModel where id is not null ");
		this.createFormWhereQuery(hql, condition);
		Query query = this.getSession().createQuery(hql.toString());
		this.setFormQueryParameters(query, condition);
		Object obj = query.uniqueResult();
		Long count = (Long)obj;
		return count.intValue();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#searchPackageByCondition(java.util.Map, java.util.Map, int, int)
	 */
	public IPackageModelList searchPackageByCondition(
			Map<String, Object> condition, Map<String, String> orderCondition, int pageCount, int recordCount)
			throws SmartServerRuntimeException {
		
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
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#searchPackageCount(java.util.Map)
	 */
	public int searchPackageCount(Map<String, Object> condition)
			throws SmartServerRuntimeException {
		
		StringBuffer hql = new StringBuffer("select count(*) from HbPackageModel where id is not null ");
		this.createPackageWhereQuery(hql, condition);
		Query query = this.getSession().createQuery(hql.toString());
		this.setPackageQueryParameters(query, condition);
		Object obj = query.uniqueResult();
		Long count = (Long)obj;
		return count.intValue();
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#searchProcessByCondition(java.util.Map, int, int)
	 */
	public IProcessModelList searchProcessByCondition(
			Map<String, Object> condition, int pageCount, int recordCount)
			throws SmartServerRuntimeException {
		
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
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#searchProcessCount(java.util.Map)
	 */
	public int searchProcessCount(Map<String, Object> condition)
			throws SmartServerRuntimeException {
		
		StringBuffer hql = new StringBuffer("select count(*) from HbProcessModel where id is not null ");
		this.createProcessWhereQuery(hql, condition);
		Query query = this.getSession().createQuery(hql.toString());
		this.setProcessQueryParameters(query, condition);
		Object obj = query.uniqueResult();
		Long count = (Long)obj;
		return count.intValue();
	}
	
	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.IResourceDesigntimeDao#searchLatestPackageList(java.lang.String)
	 */
	public IPackageModelList searchLatestPackageList(String categoryId)
			throws SmartServerRuntimeException {
		
		StringBuffer sql = new StringBuffer("select");
		sql.append(" pkg.id, pkg.packageId, pkg.version, pkg.categoryId, pkg.status, pkg.name, pkg.type, pkg.latestDeployedYn");
		sql.append(", pkg.creator, pkg.createdTime, pkg.modifier, pkg.modifiedTime, pkg.description");
		sql.append(" from SWPackage pkg");
		if(!CommonUtil.isEmpty(categoryId))
			sql.append(", (select packageId, max(version) as version from SWPackage where categoryId = :categoryId group by packageId) lp ");
		else
			sql.append(", (select packageId, max(version) as version from SWPackage group by packageId) lp ");
		
		sql.append(" where");
		sql.append(" pkg.packageId = lp.packageId and ");
		sql.append(" pkg.version = lp.version");
		
		List<Object[]> res = new ArrayList<Object[]>();
		Query query = null;
		query = this.getSession().createSQLQuery(sql.toString() + " and	pkg.type = 'PROCESS' order by pkg.name asc");
		if(!CommonUtil.isEmpty(categoryId))
			query.setString("categoryId", categoryId);
		List<Object[]> prcRes = query.list();
		query = this.getSession().createSQLQuery(sql.toString() + "	and	pkg.type = 'SINGLE' order by pkg.name asc");
		if(!CommonUtil.isEmpty(categoryId))
			query.setString("categoryId", categoryId);
		List<Object[]> frmRes = query.list();
		query = this.getSession().createSQLQuery(sql.toString() + "	and	pkg.type is null order by pkg.name asc");
		if(!CommonUtil.isEmpty(categoryId))
			query.setString("categoryId", categoryId);
		List<Object[]> nullRes = query.list();
		if (prcRes != null && !prcRes.isEmpty())
			res.addAll(prcRes);
		if (frmRes != null && !frmRes.isEmpty())
			res.addAll(frmRes);
		if (nullRes != null && !nullRes.isEmpty())
			res.addAll(nullRes);
		
		IPackageModelList pkgList = new HbPackageModelList();
		if(res == null || res.isEmpty()) 
			return pkgList;
		
		List<IPackageModel> pkgModelList = new ArrayList<IPackageModel>();
		for(Object[] record : res) {
			IPackageModel pkg = new HbPackageModel();
			pkg.setId((String)record[0]);
			pkg.setPackageId((String)record[1]);
			pkg.setVersion((Integer)record[2]);
			pkg.setCategoryId((String)record[3]);
			pkg.setStatus((String)record[4]);
			pkg.setName((String)record[5]);
			pkg.setType((String)record[6]);
			
			if (pkg.getType() == null) {
				if (!CommonUtil.isEmpty(findSingleFormByPackage(pkg.getId(), pkg.getVersion()))) {
					pkg.setType("SINGLE");
				} else {
					pkg.setType("PROCESS");
				}
			}
			
			if(record[6] != null) {
				if(record[6] instanceof Character)
					pkg.setLatestDeployedYn(((Character)record[7]).toString());
				else if(record[6] instanceof String)
					pkg.setLatestDeployedYn(record[7].toString());
				else
					pkg.setLatestDeployedYn(record[7].toString());
			}
			
			pkg.setCreator((String)record[8]);
			pkg.setCreatedTime((Date)record[9]);
			pkg.setModifier((String)record[10]);
			pkg.setModifiedTime((Date)record[11]);
			pkg.setDescription((String)record[12]);
			pkgModelList.add(pkg);
		}
		
		pkgList.setTotalCount(pkgModelList.size());
		pkgList.setPackageModelList(pkgModelList);
		return pkgList;
	}

	/**
	 * 업데이트 가능한 지 확인, 현재 체크아웃 상태인지, 체크아웃 사용자와 userId가 일치하는지를 체크한다. 
	 * 체크인 상태이거나 체크아웃 사용자와 userId가 일치하지 않으면 예외를 발생한다.
	 * 
	 * @param userId
	 * @param formUid
	 * @throws SmartServerRuntimeException
	 */
	private void enableFormUpdate(String userId, String formUid) throws SmartServerRuntimeException {
		IFormModel frm = this.retrieveForm(formUid);
		enableFormUpdate(userId, frm);
	}
	private void enableFormUpdate(String userId, String formId, int formVersion) throws SmartServerRuntimeException {
		IFormModel frm = this.retrieveForm(formId, formVersion);
		enableFormUpdate(userId, frm);
	}
	private void enableFormUpdate(String user, IFormModel frm) throws SmartServerRuntimeException {
		if (frm == null)
			return;
		
		if (IFormModel.STATUS_DEPLOYED.equals(frm.getStatus())) {
			StringBuffer buf = new StringBuffer();
			buf.append("formId [").append(frm.getFormId()).append("], version [").append(frm.getVersion()).append("]");
			buf.append(" is deployed status!");
			throw new SmartServerRuntimeException(buf.toString());
		}
		
		if(IFormModel.STATUS_CHECKED_IN.equals(frm.getStatus())) {
			StringBuffer buf = new StringBuffer();
			buf.append("formId [").append(frm.getFormId()).append("], version [").append(frm.getVersion()).append("]");
			buf.append(" is checked-in status!");
			throw new SmartServerRuntimeException(buf.toString());
		}
		
		if(user == null || !user.equals(frm.getModifier())) {
			StringBuffer buf = new StringBuffer();
			buf.append("formId [").append(frm.getFormId()).append("], version [").append(frm.getVersion()).append("]");
			buf.append(" is checked-out by [").append(frm.getModifier()).append("] but user [").append(user).append("] tried to update!");
			throw new SmartServerRuntimeException(buf.toString());
		}
	}
	
	/**
	 * 프로세스가 업데이트할 수 있는지 여부를 확인하고, 업데이트할 수 없을 경우 에러를 발생합니다.
	 * @param processUid
	 * @throws SmartServerRuntimeException  
	 */
	private void enableProcessUpdate(String userId, String processUid) throws SmartServerRuntimeException {
		IProcessModel prc = this.retrieveProcess(processUid);
		this.enableProcessUpdate(userId, prc);
	}
	private void enableProcessUpdate(String userId, String processId, int version) throws SmartServerRuntimeException {
		IProcessModel prc = this.retrieveProcess(processId, version);
		this.enableProcessUpdate(userId, prc);
	}
	private void enableProcessUpdate(String user, IProcessModel prc) throws SmartServerRuntimeException {
		if (prc == null)
			return;
		
		if (IProcessModel.STATUS_DEPLOYED.equals(prc.getStatus())) {
			StringBuffer buf = new StringBuffer();
			buf.append("processId [").append(prc.getProcessId()).append("], version [").append(prc.getVersion()).append("]");
			buf.append(" is deployed status!");
			throw new SmartServerRuntimeException(buf.toString());
		}
		
		if (IProcessModel.STATUS_CHECKED_IN.equals(prc.getStatus())) {
			StringBuffer buf = new StringBuffer();
			buf.append("processId [").append(prc.getProcessId()).append("], version [").append(prc.getVersion()).append("]");
			buf.append(" is checked-in status!");
			throw new SmartServerRuntimeException(buf.toString());
		}
		
		if (user == null || !user.equals(prc.getModifier())) {
			StringBuffer buf = new StringBuffer();
			buf.append("processId [").append(prc.getProcessId()).append("], version [").append(prc.getVersion()).append("]");
			buf.append(" is checked-out by [").append(prc.getModifier()).append("] but user [").append(user).append("] tried to update!");
			throw new SmartServerRuntimeException(buf.toString());
		}
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
			
		if(condition.containsKey(PackageFieldEnum.name.name()))
			query.setParameter(PackageFieldEnum.name.name(), "%" + condition.get(PackageFieldEnum.name.name()) + "%");
	}

	public List<IProcessModel> findLatestProcessByCategory(String categoryId) throws SmartServerRuntimeException {
		StringBuffer hql = new StringBuffer("from HbProcessModel prc, HbPackageModel pkg where pkg.categoryId = '").append(categoryId).append("'");
		hql.append(" and prc.packageId = pkg.packageId and prc.version = pkg.version");
		hql.append(" order by prc.name asc, prc.version desc");
		Query query = this.getSession().createQuery(hql.toString());
		List<IProcessModel> list = new ArrayList<IProcessModel>();
		List<Object[]> result = query.list();
		Set<String> idSet = new HashSet<String>();
		if(result != null && !result.isEmpty()) {
			for (Object[] obj : result) {
				IProcessModel model = (IProcessModel)obj[0];
				if (idSet.contains(model.getId()))
					continue;
				idSet.add(model.getId());
				list.add(model);
			}
		}
		return list;
	}

	public List<IFormModel> findLatestFormByCategory(String categoryId, String type) throws SmartServerRuntimeException {
		StringBuffer hql = new StringBuffer("from HbFormModel frm, HbPackageModel pkg where pkg.categoryId = '").append(categoryId).append("'");
		hql.append(" and frm.packageId = pkg.packageId and frm.version = pkg.version and frm.type = '").append(type).append("'");
		hql.append(" order by frm.name asc, frm.version desc");
		Query query = this.getSession().createQuery(hql.toString());
		List<IFormModel> list = new ArrayList<IFormModel>();
		List<Object[]> result = query.list();
		Set<String> idSet = new HashSet<String>();
		if(result != null && !result.isEmpty()) {
			for (Object[] obj : result) {
				IFormModel model = (IFormModel)obj[0];
				if (idSet.contains(model.getId()))
					continue;
				idSet.add(model.getId());
				list.add(model);
			}
		}
		return list;
	}

}
