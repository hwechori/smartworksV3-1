/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 11. 23.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.service.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.smartworks.model.community.User;
import net.smartworks.model.community.info.DepartmentInfo;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.community.info.WorkSpaceInfo;
import net.smartworks.model.filter.Condition;
import net.smartworks.model.filter.SearchFilter;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.model.security.AccessPolicy;
import net.smartworks.model.security.EditPolicy;
import net.smartworks.model.security.WritePolicy;
import net.smartworks.model.work.FormField;
import net.smartworks.model.work.ProcessWork;
import net.smartworks.model.work.SmartDiagram;
import net.smartworks.model.work.SmartForm;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.Work;
import net.smartworks.model.work.WorkCategory;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkCategoryInfo;
import net.smartworks.model.work.info.WorkInfo;
import net.smartworks.server.engine.authority.manager.ISwaManager;
import net.smartworks.server.engine.authority.model.SwaResource;
import net.smartworks.server.engine.authority.model.SwaResourceCond;
import net.smartworks.server.engine.category.manager.ICtgManager;
import net.smartworks.server.engine.category.model.CtgCategory;
import net.smartworks.server.engine.common.collection.manager.IColManager;
import net.smartworks.server.engine.common.collection.model.ColList;
import net.smartworks.server.engine.common.collection.model.ColListCond;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.model.Filter;
import net.smartworks.server.engine.common.model.Filters;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.model.SwdRecordCond;
import net.smartworks.server.engine.infowork.form.manager.ISwfManager;
import net.smartworks.server.engine.infowork.form.model.SwfField;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfFormCond;
import net.smartworks.server.engine.infowork.form.model.SwfFormat;
import net.smartworks.server.engine.organization.manager.ISwoManager;
import net.smartworks.server.engine.organization.model.SwoUserExtend;
import net.smartworks.server.engine.pkg.manager.IPkgManager;
import net.smartworks.server.engine.pkg.model.PkgPackage;
import net.smartworks.server.engine.pkg.model.PkgPackageCond;
import net.smartworks.server.engine.process.link.model.LnkObject;
import net.smartworks.server.engine.process.process.manager.IPrcManager;
import net.smartworks.server.engine.process.process.model.PrcProcess;
import net.smartworks.server.engine.process.process.model.PrcProcessCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.server.engine.process.process.model.PrcProcessInstCond;
import net.smartworks.util.LocalDate;

public class ModelConverter {
	
	private static ISwoManager getSwoManager() {
		return SwManagerFactory.getInstance().getSwoManager();
	}
	private static IPkgManager getPkgManager() {
		return SwManagerFactory.getInstance().getPkgManager();
	}
	private static IPrcManager getPrcManager() {
		return SwManagerFactory.getInstance().getPrcManager();
	}
	private static ICtgManager getCtgManager() {
		return SwManagerFactory.getInstance().getCtgManager();
	}
	private static ISwaManager getSwaManager() {
		return SwManagerFactory.getInstance().getSwaManager();
	}
	private static ISwfManager getSwfManager() {
		return SwManagerFactory.getInstance().getSwfManager();
	}
	private static IColManager getColManager() {
		return SwManagerFactory.getInstance().getColManager();
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
	private static PrcProcessInst getPrcProcessInstByProcessInst(String prcInstanceId) throws Exception {
		if (CommonUtil.isEmpty(prcInstanceId))
			return null;
		return getPrcManager().getProcessInst("", prcInstanceId, IManager.LEVEL_LITE);
	}
	
	// #########################################  INFO  ########################################################################
	
	public static InstanceInfo getInstanceInfoByProcessInstId(String processInstId) throws Exception {
		PrcProcessInst prcInst = getPrcProcessInstByProcessInst(processInstId);
		return getInstanceInfoByPrcInst(null, prcInst);
	}
	public static InstanceInfo[] getInstanceInfoArrayByPrcInstArray(PrcProcessInst[] prcInsts) throws Exception {
		if (CommonUtil.isEmpty(prcInsts))
			return null;
		InstanceInfo[] instanceInfos = new InstanceInfo[prcInsts.length];
		for (int i = 0; i < prcInsts.length; i++) {
			PrcProcessInst prcInst = prcInsts[i];
			instanceInfos[i] = getInstanceInfoByPrcInst(null, prcInst);
		}
		return instanceInfos;
	}
	public static void setPolicyToWork(SmartWork work, String resourceId) throws Exception {
		/* -- 공개여부 --
		 공개 / 비공개*/

		/* -- 형태 --
		 블로그형 : v2.0 구조
		 위키형 : 누구나 수정 가능*/

		 /*-- 작성권한 --
		 전체 / 선택사용자*/
		//resourceId = formId , processId;
		AccessPolicy accessPolicy = new AccessPolicy();
		WritePolicy writePolicy = new WritePolicy();
		EditPolicy editPolicy = new EditPolicy();

		SwaResourceCond swaResourceCond = new SwaResourceCond();
		swaResourceCond.setResourceId(resourceId);//formid
		SwaResource[] swaResources = getSwaManager().getResources("", swaResourceCond, IManager.LEVEL_LITE);
		
		if (CommonUtil.isEmpty(swaResources)) {
			accessPolicy.setLevel(AccessPolicy.LEVEL_DEFAULT);
			writePolicy.setLevel(WritePolicy.LEVEL_DEFAULT);
			editPolicy.setLevel(EditPolicy.LEVEL_BLOG);
		} else {
			for(SwaResource swaResource : swaResources) {
				if(CommonUtil.toNotNull(swaResource.getMode()).equals("R")) {
					if(swaResource.getPermission().equals("PUB_ALL"))
						accessPolicy.setLevel(AccessPolicy.LEVEL_DEFAULT);
					else if(swaResource.getPermission().equals("PUB_SELECT"))
						accessPolicy.setLevel(AccessPolicy.LEVEL_CUSTOM);
					else
						accessPolicy.setLevel(AccessPolicy.LEVEL_PRIVATE);
				} else if(CommonUtil.toNotNull(swaResource.getMode()).equals("W")) {
					if(swaResource.getPermission().equals("PUB_ALL"))
						writePolicy.setLevel(WritePolicy.LEVEL_DEFAULT);
					else
						writePolicy.setLevel(WritePolicy.LEVEL_CUSTOM);
				} else if(CommonUtil.toNotNull(swaResource.getMode()).equals("M")) {
					if(swaResource.getPermission().equals("PUB_ALL"))
						editPolicy.setLevel(EditPolicy.LEVEL_DEFAULT);
					else if(swaResource.getPermission().equals("PUB_SELECT"))
						editPolicy.setLevel(EditPolicy.LEVEL_BLOG);
					else
						editPolicy.setLevel(EditPolicy.LEVEL_BLOG);
				}
			}
		}
		
		work.setAccessPolicy(accessPolicy);
		work.setWritePolicy(writePolicy);
		work.setEditPolicy(editPolicy);
			
	}
	
	
	public static InstanceInfo getInstanceInfoByPrcInst(InstanceInfo instInfo, PrcProcessInst prcInst) throws Exception {
		if (prcInst == null)
			return null;
		if (instInfo == null) 
			instInfo = new InstanceInfo();

		instInfo.setId(prcInst.getObjId());//processInstanceId
		instInfo.setSubject(prcInst.getTitle());
		instInfo.setLastModifiedDate(new LocalDate());
		instInfo.setLastModifier(getUserInfoByUserId(prcInst.getModificationUser()));
		instInfo.setOwner(getUserInfoByUserId(prcInst.getCreationUser()));
		if (prcInst.getStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_COMPLETE)) {
			instInfo.setStatus(Instance.STATUS_COMPLETED);
		} else if (prcInst.getStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING)) {
			instInfo.setStatus(Instance.STATUS_RUNNING);
		}
		if (prcInst.getType() != null && prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_PROCESS)) {
			instInfo.setType(WorkInstance.TYPE_PROCESS);
		} else if (prcInst.getType() != null && prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_INFORMATION)) {
			instInfo.setType(WorkInstance.TYPE_INFORMATION);
		} else if (prcInst.getType() != null && prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_SCHEDULE)) {
			instInfo.setType(WorkInstance.TYPE_SCHEDULE);
		}
		instInfo.setWork(getSmartWorkInfoByPackageId(prcInst.getPackageId()));
		//TODO workspaceid > ??
		instInfo.setWorkSpace(new WorkSpaceInfo());
		
		return instInfo;
	}
	
	public static WorkInfo getWorkInfoByPackageId(String packageId) throws Exception {
		PkgPackage pkg = getPkgPackageByPackageId(packageId);
		return getSmartWorkInfoByPkgPackage(null, pkg);
	}
	public static WorkInfo[] getWorkInfoArrayByPkgPackageArray(PkgPackage[] pkgs) throws Exception {
		if (CommonUtil.isEmpty(pkgs))
			return null;
		WorkInfo[] workInfos = new WorkInfo[pkgs.length];
		for (int i = 0; i < pkgs.length; i++) {
			PkgPackage pkg = pkgs[i];
			workInfos[i] = getWorkInfoByPkgPackage(null, pkg);
		}
		return workInfos;
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

	public static SmartWorkInfo getSmartWorkInfoByPackageId(String packageId) throws Exception {
		PkgPackage pkg = getPkgPackageByPackageId(packageId);
		return getSmartWorkInfoByPkgPackage(null, pkg);
	}
	public static SmartWorkInfo[] getSmartWorkInfoArrayByPkgPackageArray(PkgPackage[] pkgs) throws Exception {
		if (CommonUtil.isEmpty(pkgs))
			return null;
		SmartWorkInfo[] smartWorkInfos = new SmartWorkInfo[pkgs.length];
		for (int i = 0; i < pkgs.length; i++) {
			PkgPackage pkg = pkgs[i];
			smartWorkInfos[i] = getSmartWorkInfoByPkgPackage(null, pkg);
		}
		return smartWorkInfos;
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
	
	public static WorkCategoryInfo[] getWorkCategoryInfoArrayByCtgCategoryArray(CtgCategory[] argCtgs) throws Exception {
		if (CommonUtil.isEmpty(argCtgs))
			return null;
		
		WorkCategoryInfo[] workCtgs = new WorkCategoryInfo[argCtgs.length];
		for (int i =0; i < argCtgs.length; i ++) {
			CtgCategory ctg = argCtgs[i];
			WorkCategoryInfo workCtg = (WorkCategoryInfo)getWorkCategoryInfoByCtgCategory(null, ctg);
			workCtgs[i] = workCtg; 
		}
		return workCtgs;
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
	
	public static UserInfo getUserInfoByUserId(String userId) throws Exception {
		if (CommonUtil.isEmpty(userId))
			return null;
		SwoUserExtend userExtend = getSwoManager().getUserExtend(userId, userId);
		return getUserInfoBySwoUserExtend(null, userExtend);
	}
	public static UserInfo getUserInfoBySwoUserExtend(UserInfo userInfo, SwoUserExtend userExtend) throws Exception {
		if (userExtend == null)
			return null;
		if (userInfo == null) 
			userInfo = new UserInfo();
		
		userInfo.setId(userExtend.getId());
		userInfo.setName(userExtend.getName());
		userInfo.setDepartment(new DepartmentInfo(userExtend.getDepartmentId(), userExtend.getDepartmentName()));
		userInfo.setMidPictureName(userExtend.getPictureName());
		userInfo.setMinPictureName(userExtend.getPictureName());
		//userInfo.setPicturePath(picturePath);
		userInfo.setPosition(userExtend.getPosition());
		return userInfo;
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
	
	
	
	// #########################################  specific class  ########################################################################
	
	
	public static User[] getUserArrayBySwoUserExtendArray(SwoUserExtend[] userExtends) throws Exception {
		if (CommonUtil.isEmpty(userExtends))
			return null;
		User[] users = new User[userExtends.length];
		for (int i =0; i < userExtends.length; i++) {
			SwoUserExtend userExtend = userExtends[i];
			users[i] = getUserBySwoUserExtend(null, userExtend);
		}
		return users;
	}
	public static User getUserByUserId(String userId) throws Exception {
		if (CommonUtil.isEmpty(userId))
			return null;
		SwoUserExtend userExtend = getSwoManager().getUserExtend(userId, userId);
		return getUserBySwoUserExtend(null, userExtend);
	}
	public static User getUserBySwoUserExtend(User user, SwoUserExtend userExtend) throws Exception {
		if (userExtend == null)
			return null;
		if (user == null)
			user = new User();
		
		user.setId(userExtend.getId());
		user.setName(userExtend.getName());
		user.setDepartment(userExtend.getDepartmentName());
		user.setMidPictureName(userExtend.getPictureName());
		user.setMinPictureName(userExtend.getPictureName());
		user.setPosition(userExtend.getPosition());
		String locale = userExtend.getLocale();
		if (locale == null)
			locale = "ko";
		if (locale.equalsIgnoreCase("kor"))
			locale = "ko";
		if (locale.equalsIgnoreCase("eng"))
			locale = "en";
		user.setLocale(locale);
		user.setOrgPictureName(userExtend.getPictureName());
		user.setCompany(userExtend.getCompanyName());
		user.setTimeZone(userExtend.getTimeZone());
		user.setUserLevel(-1);//userExtend.getUserLevel();
		return user;
	}
	
	
	public static Work getWorkByCtgCategory(Work work, CtgCategory ctg) throws Exception {
		if (ctg == null)
			return null;
		if (work == null)
			work = new Work();
			
		String ctgId = ctg.getObjId();
		String ctgName = ctg.getName();
		String ctgDesc = ctg.getDescription();
		int ctgType = -1;
		work.setId(ctgId);
		work.setName(ctgName);
		work.setDesc(ctgDesc);
		work.setType(-1);
		
		return work;
	}
	public static WorkCategory getWorkCategoryByCtgCategory(WorkCategory workCategory, CtgCategory ctg) throws Exception {
		if (ctg == null)
			return null;
		if (workCategory == null)
			workCategory = new WorkCategory();
		
		getWorkByCtgCategory(workCategory, ctg);
		
		return workCategory;
	}
	
	
	public static Work getWorkByPkgPackage(Work work, PkgPackage pkg) throws Exception {
		if (pkg == null)
			return null;
		if (work == null)
			work = new Work();
			
		String ctgId = pkg.getObjId();
		String ctgName = pkg.getName();
		String ctgDesc = pkg.getDescription();
		//TODO
		int ctgType = -1;
		work.setId(ctgId);
		work.setName(ctgName);
		work.setDesc(ctgDesc);
		work.setType(-1);
		
		return work;
	}
	public static SmartWork getSmartWorkByPkgPackage(String userId, SmartWork smartWork, PkgPackage pkg) throws Exception {
		if (pkg == null)
			return null;
		if (smartWork == null)
			smartWork = new SmartWork();
		
		getWorkByPkgPackage(smartWork, pkg);
		
		setPolicyToWork(smartWork, getResourceIdByPkgPackage(pkg));
		
		smartWork.setLastModifier(getUserByUserId(pkg.getModificationUser()));
		smartWork.setLastModifiedDate(new LocalDate(pkg.getModificationDate().getTime()));
		
		smartWork.setSearchFilters(getSearchFilterArrayByPkgPackage(userId, pkg));
		
		Map<String, WorkCategory> pkgCtgPathMap = getPkgCtgMapByPackage(pkg);
		smartWork.setMyCategory(pkgCtgPathMap.get("category"));
		smartWork.setMyGroup(pkgCtgPathMap.get("group"));
		
		return smartWork;
	}
	
	public static ProcessWork getProcessWorkByPkgPackage(String userId, ProcessWork processWork, PkgPackage pkg) throws Exception {
		if (pkg == null)
			return null;
		if (processWork == null)
			processWork = new ProcessWork();
		
		getSmartWorkByPkgPackage(userId, processWork, pkg);
		
		processWork.setHelpUrl("HELP URL");
		processWork.setManualFileName("MANUAL FILE NAME");
		processWork.setManualFilePath("MANUAL FILE PATH");
		
		return processWork;
	}
	
	public static SearchFilter[] getSearchFilterArrayByPkgPackage(String userId, PkgPackage pkg) throws Exception {
		if (pkg == null)
			return null;
		
		ColListCond listCond = new ColListCond();
		String pkgType = pkg.getType();
		if (pkgType.equalsIgnoreCase("PROCESS") || pkgType.equalsIgnoreCase("GANTT")) {
			//processinst.cond.admin@maninsoft.co.kr
			listCond.setType("processinst.cond." + userId);
		} else {
			//record.cond.admin@maninsoft.co.kr
			listCond.setType("record.cond." + userId);
		}
		String resourceId = getResourceIdByPkgPackage(pkg);
		if (CommonUtil.isEmpty(resourceId))
			return null;
		listCond.setCorrelation(resourceId);
		
		ColList filterList = getColManager().getList(userId, listCond, IManager.LEVEL_ALL);
		
		return getSearchFilterArrayByColList(pkgType, filterList);
	}
	public static SearchFilter[] getSearchFilterArrayByColList(String type, ColList list) throws Exception {
		if (list == null)
			return null;
		
		LnkObject[] filterItemArray = list.getItems();
		
		if (CommonUtil.isEmpty(filterItemArray))
			return null;
		
		List<SearchFilter> filterList = new ArrayList<SearchFilter>();
		for (int i = 0; i < filterItemArray.length; i++) {

			LnkObject filterItem = filterItemArray[i];
			
			String name = filterItem.getLabel();
			String conditionStr = filterItem.getExpression();
			Condition[] conditions = null;
			if (!CommonUtil.isEmpty(conditionStr)) {
				Filter[] filters = null;
				if (type.equalsIgnoreCase("PROCESS") || type.equalsIgnoreCase("GANTT")) {
					PrcProcessInstCond prcCond = (PrcProcessInstCond)PrcProcessInstCond.toObject(conditionStr);
					if (prcCond == null)
						continue;
					filters = prcCond.getFilter();
				} else {
					SwdRecordCond recCond = (SwdRecordCond)SwdRecordCond.toObject(conditionStr);
					if (recCond == null)
						continue;
					filters = recCond.getFilter();
				}
				if (filters == null)
					continue;
				Condition[] condArray = new Condition[filters.length];
				for (int j = 0; j < filters.length; j++) {
					Filter filter = filters[i];
					String leftOperType = filter.getLeftOperandType();
					String leftOperValue = filter.getLeftOperandValue();
					String rightOperType = filter.getRightOperandType();
					String rightOperValue = filter.getRightOperandValue();
					String operator = filter.getOperator();
					
					Condition cond = new Condition(new FormField(leftOperValue, leftOperValue, leftOperType) , operator, new FormField(rightOperValue, rightOperValue, rightOperType));
					condArray[i] = cond;
				}
				conditions = condArray;
			}
			
			SearchFilter searchFilter = new SearchFilter();
			searchFilter.setId(name);
			searchFilter.setName(name);
			searchFilter.setConditions(conditions);
			
			filterList.add(searchFilter);
		}
		SearchFilter[] searchFilter = new SearchFilter[filterList.size()];
		filterList.toArray(searchFilter);
		
		return searchFilter;
	}
	
	public static String getResourceIdByPkgPackage(PkgPackage pkg) throws Exception {
		if (pkg == null)
			return null;
		
		String type = pkg.getType();
		String packageId = pkg.getPackageId();
		
		if (type.equalsIgnoreCase("PROCESS") || type.equalsIgnoreCase("GANTT")) {
			PrcProcessCond prcCond = new PrcProcessCond();
			prcCond.setDiagramId(packageId);
			PrcProcess[] prc = getPrcManager().getProcesses("", prcCond, IManager.LEVEL_LITE);
			if (CommonUtil.isEmpty(prc)) {
				return null;
			} else {
				return prc[0].getProcessId();
			}
		} else if (type.equalsIgnoreCase("SINGLE")) {
			SwfFormCond formCond = new SwfFormCond();
			formCond.setPackageId(packageId);
			
			SwfForm[] form = getSwfManager().getForms("", formCond, IManager.LEVEL_LITE);
			if (CommonUtil.isEmpty(form)) {
				return null;
			} else {
				return form[0].getId();
			}
		} 
		return null;
	}
	
	public static Map<String, WorkCategory> getPkgCtgMapByPackage(PkgPackage pkg) throws Exception {
		
		String categoryId = pkg.getCategoryId();
		if (CommonUtil.isEmpty(categoryId) || categoryId.equalsIgnoreCase(CtgCategory.ROOTCTGID))
			return null;
		
		CtgCategory ctg = getCtgCategoryByCategoryId(categoryId);
		CtgCategory parentCtg = getCtgCategoryByCategoryId(ctg.getParentId());
		
		Map<String, WorkCategory> resultMap = new HashMap<String, WorkCategory>();
		if (parentCtg == null || parentCtg.getObjId().equalsIgnoreCase(CtgCategory.ROOTCTGID)) {
			resultMap.put("category", (WorkCategory)getWorkCategoryByCtgCategory(null, ctg));
			resultMap.put("group", null);
		} else {
			resultMap.put("category", (WorkCategory)getWorkCategoryByCtgCategory(null, parentCtg));
			resultMap.put("group", (WorkCategory)getWorkCategoryByCtgCategory(null, ctg));
		}
		return resultMap;
	}
	public static FormField[] getFormFieldArrayBySwfFieldArray(SwfField[] fields) throws Exception {
		if (CommonUtil.isEmpty(fields))
			return null;
		
		FormField[] formFields = new FormField[fields.length];
		for (int i = 0; i < fields.length; i++) {
			SwfField field = fields[i];
			formFields[i] = getFormFieldBySwfField(null, field);
		}
		return formFields;
	}
	public static FormField getFormFieldBySwfField(FormField formField, SwfField swField) throws Exception {
		if (swField == null)
			return null;
		if (formField == null)
			formField = new FormField();
		
		/*<field id="4" name="내용" systemType="text" array="false" required="true" system="false">
			<format type="richEditor" viewingType="richEditor"/>
		</field>*/
		String id = swField.getId();
		String name = swField.getName();
		SwfFormat format = swField.getFormat();
		String type = format.getType();
		
		formField.setId(id);
		formField.setName(name);
		formField.setType(type);
		
		return formField;
	}
	public static SmartForm getSmartFormBySwfFrom(SmartForm smartForm, SwfForm swForm) throws Exception {
		if (swForm == null)
			return null;
		if (smartForm == null)
			smartForm = new SmartForm();
		
		String description = swForm.getDescription();
		String id = swForm.getId();
		String minImageName = "";
		String orgImageName = "";
		String name = swForm.getName();
		SwfField[] swFields = swForm.getFields();
		
		smartForm.setDescription(description);
		smartForm.setFields(getFormFieldArrayBySwfFieldArray(swFields));
		smartForm.setId(id);
		smartForm.setMinImageName(minImageName);
		smartForm.setName(name);
		smartForm.setOrgImageName(orgImageName);
		
		return smartForm;
	}
	
}
