/*	
 * $Id$
 * created by    : hsshin
 * creation-date : 2011. 11. 25.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.service.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.community.info.WorkSpaceInfo;
import net.smartworks.model.instance.FieldData;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.instance.info.IWInstanceInfo;
import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.model.instance.info.TaskInstanceInfo;
import net.smartworks.model.instance.info.WorkInstanceInfo;
import net.smartworks.model.work.FormField;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkCategoryInfo;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.server.engine.category.manager.ICtgManager;
import net.smartworks.server.engine.category.model.CtgCategory;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.manager.ISwdManager;
import net.smartworks.server.engine.infowork.domain.model.SwdDataField;
import net.smartworks.server.engine.infowork.domain.model.SwdDomain;
import net.smartworks.server.engine.infowork.domain.model.SwdDomainCond;
import net.smartworks.server.engine.infowork.domain.model.SwdDomainFieldView;
import net.smartworks.server.engine.infowork.domain.model.SwdRecord;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfFormFieldDef;
import net.smartworks.server.engine.pkg.manager.IPkgManager;
import net.smartworks.server.engine.pkg.model.PkgPackage;
import net.smartworks.server.engine.pkg.model.PkgPackageCond;
import net.smartworks.util.LocalDate;

public class ModelConverterInfo extends ModelConverter {

	private static IPkgManager getPkgManager() {
		return SwManagerFactory.getInstance().getPkgManager();
	}
	private static ICtgManager getCtgManager() {
		return SwManagerFactory.getInstance().getCtgManager();
	}
	private static ISwdManager getSwdManager() {
		return SwManagerFactory.getInstance().getSwdManager();
	}
	private static ISwfManager getSwfManager() {
		return SwManagerFactory.getInstance().getSwfManager();
	}

	private static PkgPackage getPkgPackageByPackageId(String packageId) throws Exception {
		if (CommonUtil.isEmpty(packageId))
			return null;
		PkgPackageCond pkgCond = new PkgPackageCond();
		pkgCond.setPackageId(packageId);
		PkgPackage pkg = getPkgManager().getPackage("", pkgCond, IManager.LEVEL_LITE);
		return pkg;
	}

	private static CtgCategory getCtgCategoryByCategoryId(String categoryId) throws Exception {
		if (CommonUtil.isEmpty(categoryId))
			return null;
		return getCtgManager().getCategory("", categoryId, IManager.LEVEL_LITE);
	}

	public static WorkInfo getWorkInfoByPackageId(String packageId) throws Exception {
		PkgPackage pkg = getPkgPackageByPackageId(packageId);
		return getSmartWorkInfoByPkgPackage(null, pkg);
	}

	public static SmartWorkInfo getSmartWorkInfoByPkgPackage(SmartWorkInfo workInfo, PkgPackage pkg) throws Exception {
		if (pkg == null)
			return null;
		if (workInfo == null) 
			workInfo = new SmartWorkInfo();

		getWorkInfoByPkgPackage(workInfo, pkg);

		Map<String, WorkCategoryInfo> pkgCtgPathMap = getPkgCtgInfoMapByPackage(pkg);
		workInfo.setMyCategory(pkgCtgPathMap.get("category"));
		workInfo.setMyGroup(pkgCtgPathMap.get("group"));

		return workInfo;
	}

	public static WorkCategoryInfo getWorkCategoryInfoByCtgCategory(WorkCategoryInfo workCtgInfo, CtgCategory argCtg) throws Exception {
		if (argCtg == null)
			return null;
		if (workCtgInfo == null) 
			workCtgInfo = new WorkCategoryInfo();
		
		CtgCategory ctg = (CtgCategory)argCtg;
		String ctgId = ctg.getObjId();
		String ctgName = ctg.getName();
		WorkCategoryInfo workCtg = new WorkCategoryInfo(ctgId, ctgName);
		return workCtg;
	}

	public static Map<String, WorkCategoryInfo> getPkgCtgInfoMapByPackage(PkgPackage pkg) throws Exception {
		
		String categoryId = pkg.getCategoryId();
		if (CommonUtil.isEmpty(categoryId) || categoryId.equalsIgnoreCase(CtgCategory.ROOTCTGID))
			return null;

		CtgCategory ctg = getCtgCategoryByCategoryId(categoryId);
		CtgCategory parentCtg = getCtgCategoryByCategoryId(ctg.getParentId());
		
		Map<String, WorkCategoryInfo> resultMap = new HashMap<String, WorkCategoryInfo>();
		if (parentCtg == null || parentCtg.getObjId().equalsIgnoreCase(CtgCategory.ROOTCTGID)) {
			resultMap.put("category", (WorkCategoryInfo)getWorkCategoryInfoByCtgCategory(null, ctg));
			resultMap.put("group", null);
		} else {
			resultMap.put("category", (WorkCategoryInfo)getWorkCategoryInfoByCtgCategory(null, parentCtg));
			resultMap.put("group", (WorkCategoryInfo)getWorkCategoryInfoByCtgCategory(null, ctg));
		}
		return resultMap;
	}

	public static WorkInfo getWorkInfoByPkgPackage(WorkInfo workInfo, PkgPackage pkg) throws Exception {
		if (pkg == null)
			return null;
		if (workInfo == null) 
			workInfo = new WorkInfo();

		workInfo.setId(pkg.getPackageId());
		workInfo.setName(pkg.getName());
		if (pkg.getType().equalsIgnoreCase("PROCESS")) {
			workInfo.setType(SmartWork.TYPE_PROCESS);	
		} else if (pkg.getType().equalsIgnoreCase("SINGLE")) {
			workInfo.setType(SmartWork.TYPE_INFORMATION);	
		} else if (pkg.getType().equalsIgnoreCase("GANTT")) {
			workInfo.setType(SmartWork.TYPE_SCHEDULE);	
		}
		return workInfo;
	}

	public static InstanceInfo getInstanceInfoBySwdRecord(InstanceInfo instanceInfo, SwdRecord swdRecord) throws Exception {
		if (swdRecord == null)
			return null;
		if (instanceInfo == null) 
			instanceInfo = new InstanceInfo();
		
		String id = swdRecord.getRecordId();
		SwdDomainCond swdDomainCond = new SwdDomainCond();
		swdDomainCond.setObjId(swdRecord.getDomainId());

		SwdDomain swdDomain = getSwdManager().getDomain("", swdDomainCond, IManager.LEVEL_LITE);
		String titleFieldId = swdDomain.getTitleFieldId();
		String titleFieldName = "";
		List<SwdDomainFieldView> list = getSwdManager().findDomainFieldViewList(swdDomain.getFormId());
		Iterator<SwdDomainFieldView> iter = list.iterator();
		for(;iter.hasNext();) {
			SwdDomainFieldView swdDomainFV = iter.next();
			if(swdDomainFV.getFormFieldId().equals(titleFieldId)) {
				titleFieldName = swdDomainFV.getFormFieldName();
			}
		}

		String subject = titleFieldName;
		int type = WorkInstance.TYPE_INFORMATION;

		WorkInfo work = getWorkInfoByPackageId((getSwfManager().getForm("", swdDomain.getFormId())).getPackageId());
		WorkSpaceInfo workSpace = null;

		UserInfo owner = getUserInfoByUserId(swdRecord.getCreationUser());
		UserInfo lastModifier = getUserInfoByUserId(swdRecord.getModificationUser()); 
		LocalDate lastModifiedDate = new LocalDate(swdRecord.getModificationDate().getTime());

		instanceInfo.setId(id);
		instanceInfo.setLastModifiedDate(lastModifiedDate);
		instanceInfo.setLastModifier(lastModifier);
		instanceInfo.setOwner(owner);
		instanceInfo.setSubject(subject);
		instanceInfo.setType(type);
		instanceInfo.setWork(work);
		instanceInfo.setWorkSpace(workSpace);
		SwdDataField[] swdDataFields = swdRecord.getDataFields();

		FieldData[] fieldDatas = ModelConverterInfo.getFieldDataArrayBySwdDataFieldArray(swdDataFields);

		List<SwdDomainFieldView> fieldViewList = getSwdManager().findDomainFieldViewList(swdDomain.getFormId());
		List<SwfFormFieldDef> formFieldDefList = getSwfManager().findFormFieldByForm(swdDomain.getFormId(), true);
		
		Set<String> fieldIdSet = new HashSet<String>();
		for (int i = 0; i < fieldViewList.size(); i++) {
			SwdDomainFieldView dfv = fieldViewList.get(i);
			if (dfv.getDispOrder() > -1)
				fieldIdSet.add(dfv.getFormFieldId());
		}
		List<FormField> resultList = new ArrayList<FormField>();
		for (int i = 0; i < formFieldDefList.size(); i++) {
			SwfFormFieldDef sfd = formFieldDefList.get(i);
			String formFieldId = sfd.getId();
			String viewingType = sfd.getViewingType();

			if (fieldIdSet.contains(formFieldId) && !viewingType.equals("richEditor") && !viewingType.equals("textArea") && !viewingType.equals("dataGrid")) {
				FormField formField = new FormField();
				formField.setId(formFieldId);
				formField.setName(sfd.getName());
				formField.setType(sfd.getType());
				resultList.add(formField);
			}
		}
		FormField[] formFields = new FormField[resultList.size()];
		resultList.toArray(formFields);

		List<FieldData> fieldDataList = new ArrayList<FieldData>();
		if(formFields.length != fieldDatas.length) {
			for(int i=0; i < formFields.length; i++) {
				for(int j=0; j < fieldDatas.length; j++) {
					if(formFields[i].getId().equals(fieldDatas[j].getFieldId())) {
						fieldDataList.add(fieldDatas[j]);
					}
				}
			}
		}
		FieldData[] resultFieldDatas = new FieldData[fieldDataList.size()];
		fieldDataList.toArray(resultFieldDatas);

		((IWInstanceInfo)instanceInfo).setDisplayDatas(resultFieldDatas);

		return instanceInfo;
	}

	public static FieldData[] getFieldDataArrayBySwdDataFieldArray(SwdDataField[] swdDataFields) throws Exception {
		if (CommonUtil.isEmpty(swdDataFields))
			return null;
		FieldData[] fieldDatas = new FieldData[swdDataFields.length];
		for (int i = 0; i < swdDataFields.length; i++) {
			SwdDataField swdDataField = swdDataFields[i];
			fieldDatas[i] = getFieldDataBySwdDataField(null, swdDataField);
		}
		return fieldDatas;
	}

	public static FieldData getFieldDataBySwdDataField(FieldData fieldData, SwdDataField swdDataField) throws Exception {
		if (swdDataField == null)
			return null;
		if (fieldData == null)
			fieldData = new FieldData();

		fieldData.setFieldId(swdDataField.getId());
		fieldData.setValue(swdDataField.getValue());
		fieldData.setFieldType(swdDataField.getType());

		return fieldData;
	}

	public static WorkInstanceInfo getWorkInstanceInfoBySwdRecord(WorkInstanceInfo workInstanceInfo, SwdRecord swdRecord) throws Exception {
		if (swdRecord == null)
			return null;
		if (workInstanceInfo == null) 
			workInstanceInfo = new WorkInstanceInfo();
		
		getInstanceInfoBySwdRecord(workInstanceInfo, swdRecord);
		
		TaskInstanceInfo[] runningTasks = null; //TODO 실행중 태스크?

		workInstanceInfo.setRunningTasks(runningTasks);

		return workInstanceInfo;
	}

	public static IWInstanceInfo[] getIWInstanceInfoArrayBySwdRecordArray(SwdRecord[] swdRecords) throws Exception {
		if (CommonUtil.isEmpty(swdRecords))
			return null;

		IWInstanceInfo[] iWInstanceInfos = new IWInstanceInfo[swdRecords.length];
		for (int i =0; i < swdRecords.length; i ++) {
			SwdRecord swdRecord = swdRecords[i];
			IWInstanceInfo iWInstanceInfo = (IWInstanceInfo)getIWInstanceInfoBySwdRecord(null, swdRecord);
			iWInstanceInfos[i] = iWInstanceInfo; 
		}
		return iWInstanceInfos;
	}

	public static IWInstanceInfo getIWInstanceInfoBySwdRecord(IWInstanceInfo iWInstanceInfo, SwdRecord swdRecord) throws Exception {
		if (swdRecord == null)
			return null;
		if (iWInstanceInfo == null) 
			iWInstanceInfo = new IWInstanceInfo();

		getWorkInstanceInfoBySwdRecord(iWInstanceInfo, swdRecord);

		return iWInstanceInfo;
	}

}