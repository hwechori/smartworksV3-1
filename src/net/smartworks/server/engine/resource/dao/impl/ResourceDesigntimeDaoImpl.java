/*
 * created by    : mhchang
 * creation-date : 2008. 08. 11
 * 
 * =========================================================
 * Copyright (c) 2008 ManInSoft. All rights reserved.
 */
package net.smartworks.server.engine.resource.dao.impl;

import java.util.HashMap;
import java.util.Map;

import net.smartworks.server.engine.common.collection.model.ColValue;
import net.smartworks.server.engine.common.collection.model.ColValueCond;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.common.util.SmartUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.model.SwdDomain;
import net.smartworks.server.engine.infowork.domain.model.SwdDomainCond;
import net.smartworks.server.engine.infowork.domain.model.SwdField;
import net.smartworks.server.engine.infowork.form.exception.SwfException;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfFormCond;
import net.smartworks.server.engine.process.deploy.exception.DepException;
import net.smartworks.server.engine.process.process.model.PrcProcess;
import net.smartworks.server.engine.process.process.model.PrcProcessCond;
import net.smartworks.server.engine.process.script.util.F2SUtil;
import net.smartworks.server.engine.process.xpdl.util.ProcessModelHelper;
import net.smartworks.server.engine.process.xpdl.xpdl2.PackageType;
import net.smartworks.server.engine.process.xpdl.xpdl2.ProcessType1;
import net.smartworks.server.engine.resource.exception.SmartServerRuntimeException;
import net.smartworks.server.engine.resource.model.IPackageModel;
import net.smartworks.server.engine.resource.model.IProcessModel;
import net.smartworks.server.service.SmartApi;

public class ResourceDesigntimeDaoImpl extends HbResourceDesigntimeDaoImpl {
	private ISwfManager swfManager = null;

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.hb.HbResourceDesigntimeDaoImpl#deployPackage(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void deployPackage(String userId, String companyId, String packageId, int version) throws SmartServerRuntimeException {
		this.releaseForms(userId, packageId, version);
		super.deployPackage(userId, companyId, packageId, version);
		try {
			IProcessModel model = this.retrieveProcessByPackage(packageId, version);
			if (model == null) {
				ColValueCond cond = new ColValueCond();
				cond.setType("domain");
				cond.setRef(packageId);
				ColValue[] values = SwManagerFactory.getInstance().getColManager().getValues(userId, cond, IManager.LEVEL_LITE);
				SwdDomain domain = null;
				String titleField = null;
				Map<String, SwdField> fieldMap = null;
				if (!CommonUtil.isEmpty(values)) {
					for (ColValue value : values) {
						SwManagerFactory.getInstance().getColManager().removeValue(userId, value.getObjId());
						domain = (SwdDomain)SwdDomain.toObject(value.getValue());
						if (domain == null)
							continue;
						titleField = domain.getTitleFieldId();
						SwdField[] fields = domain.getFields();
						if (CommonUtil.isEmpty(fields))
							continue;
						fieldMap = new HashMap<String, SwdField>();
						for (SwdField field : fields) {
							if (field.getDisplayOrder() == -1)
								continue;
							fieldMap.put(field.getFormFieldId(), field);
						}
					}
					if (!CommonUtil.isEmpty(titleField) || !CommonUtil.isEmpty(fieldMap)) {
						String formId = domain.getFormId();
						SwdDomainCond dcond = new SwdDomainCond();
						dcond.setFormId(formId);
						SwdDomain ndomain = SwManagerFactory.getInstance().getSwdManager().getDomain(userId, dcond, IManager.LEVEL_ALL);
						if (ndomain != null) {
							boolean changed = false;
							
							if (!CommonUtil.isEmpty(titleField)) {
								ndomain.setTitleFieldId(titleField);
								changed = true;
							}
							
							SwdField[] nfields = ndomain.getFields();
							if (!CommonUtil.isEmpty(nfields)) {
								for (SwdField nfield : nfields) {
									String fieldId = nfield.getFormFieldId();
									if (!fieldMap.containsKey(fieldId)) {
										nfield.setDisplayOrder(-1);
										continue;
									}
									SwdField field = fieldMap.get(fieldId);
									nfield.setDisplayOrder(field.getDisplayOrder());
								}
								changed = true;
							}
							if (changed)
								SwManagerFactory.getInstance().getSwdManager().setDomain(userId, ndomain, IManager.LEVEL_ALL);
						}
					}
				}
			} else {
				String xpdl = this.retrieveProcessContent(model.getProcessId(), model.getVersion());
				if (xpdl == null || xpdl.length() == 0)
					return;
				SwManagerFactory.getInstance().getDepManager().deploy(userId, xpdl, null);
			}
		} catch (Exception e) {
			throw new SmartServerRuntimeException(e);
		}
	}
	protected void releaseForms(String userId, String packageId, int version) throws SmartServerRuntimeException {
		SwfFormCond cond = new SwfFormCond();
		cond.setPackageId(packageId);
		cond.setVersion(version);
		SwfForm[] forms = null;
		try {
			forms = getSwfManager().getForms(userId, cond, null);
		} catch (SwfException e) {
			throw new SmartServerRuntimeException(e);
		}
		if (CommonUtil.isEmpty(forms))
			return;
		
		SwfForm form = null;
		String id = null;
		for (int i=0; i<forms.length; i++) {
			form = forms[i];
			id = form.getId();
			if (F2SUtil.formMap.containsKey(id))
				F2SUtil.formMap.remove(id);
			if (SmartUtil.formMap.containsKey(id))
				SmartUtil.formMap.remove(id);
		}
	}

	/* (non-Javadoc)
	 * @see com.maninsoft.smart.server.dao.hb.HbResourceDesigntimeDaoImpl#undeployPackage(java.lang.String, java.lang.String, int)
	 */
	@Override
	public void undeployPackage(String userId, String packageId, int version) throws SmartServerRuntimeException {
		try {
			IPackageModel pkg = this.retrievePackage(packageId, version);
			if (pkg == null)
				return;
			String type = pkg.getType();
			if (type != null && type.equalsIgnoreCase(IPackageModel.TYPE_SINGLE)) {
				SwfFormCond fcond = new SwfFormCond();
				fcond.setPackageId(packageId);
				SwfForm[] forms = SwManagerFactory.getInstance().getSwfManager().getForms(userId, fcond, IManager.LEVEL_ALL);
				SwfForm form = null;
				if (forms != null)
					form = forms[0];
				
				if (form != null || CommonUtil.isEmpty(form.getId())) {
					String formId = form.getId();
					SwdDomainCond cond = new SwdDomainCond();
					cond.setFormId(formId);
					SwdDomain domain = SwManagerFactory.getInstance().getSwdManager().getDomain(userId, cond, IManager.LEVEL_ALL);
					if (domain != null) {
						ColValue value = new ColValue();
						value.setName(domain.getFormName());
						value.setType("domain");
						value.setRef(packageId);
						value.setValue(domain.toString());
						SwManagerFactory.getInstance().getColManager().setValue(userId, value, IManager.LEVEL_ALL);
					}
				}
			}
		} catch (SmartServerRuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new SmartServerRuntimeException(e);
		}
		super.undeployPackage(userId, packageId, version);
		try {
			SwManagerFactory.getInstance().getDepManager().undeploy(userId, packageId);
		} catch (DepException e) {
			throw new SmartServerRuntimeException(e);
		}
	}
	public IPackageModel updatePackage(String userId, IPackageModel obj) throws SmartServerRuntimeException {
		if (obj == null)
			return null;
		
		IPackageModel pkg = super.updatePackage(userId, obj);
		
		String type = obj.getType();
		String status = obj.getStatus();
		if (type == null || status == null || !type.equals(IPackageModel.TYPE_PROCESS) || !status.equals(IProcessModel.STATUS_DEPLOYED))
			return pkg;

		String name = obj.getName();
		PrcProcessCond cond = new PrcProcessCond();
		cond.setDiagramId(obj.getPackageId());
		try {
			PrcProcess[] prcs = SwManagerFactory.getInstance().getPrcManager().getProcesses(userId, cond, IManager.LEVEL_ALL);
			if (CommonUtil.isEmpty(prcs))
				return pkg;
			
			if (prcs.length > 1)
				throw new Exception("More than 1 processes with packageId: " + obj.getPackageId());
			
			PrcProcess prc = prcs[0];
			if (CommonUtil.isEqual(name, prc.getName()))
				return pkg;

			
			prc = SwManagerFactory.getInstance().getPrcManager().getProcess(userId, prc.getObjId(), IManager.LEVEL_ALL);
			prc.setName(name);
			String ctt = prc.getDiagram();
			if (ctt != null) {
				PackageType xpdlPkg = ProcessModelHelper.load(ctt);
				ProcessType1 xpdlPrc = (ProcessType1)xpdlPkg.getWorkflowProcesses().getWorkflowProcess().get(0);
				xpdlPkg.setName(name);
				xpdlPrc.setName(name);
				ctt = ProcessModelHelper.save(xpdlPkg, "UTF-8");
				prc.setDiagram(ctt);
			}
			SwManagerFactory.getInstance().getPrcManager().setProcess(userId, prc, IManager.LEVEL_ALL);
			return pkg;
			
		} catch (Exception e) {
			throw new SmartServerRuntimeException(e);
		}
	}
	
	protected ISwfManager getSwfManager() {
		if (swfManager == null)
			swfManager = SwManagerFactory.getInstance().getSwfManager();
		return swfManager;
	}
	
}
