package net.smartworks.server.service.util;

import java.util.HashMap;
import java.util.Map;

import net.smartworks.model.BaseObject;
import net.smartworks.model.community.Department;
import net.smartworks.model.community.User;
import net.smartworks.model.community.info.DepartmentInfo;
import net.smartworks.model.community.info.UserInfo;
import net.smartworks.model.community.info.WorkSpaceInfo;
import net.smartworks.model.instance.Instance;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.instance.info.InstanceInfo;
import net.smartworks.model.work.FormField;
import net.smartworks.model.work.SmartForm;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.WorkCategory;
import net.smartworks.model.work.info.SmartWorkInfo;
import net.smartworks.model.work.info.WorkCategoryInfo;
import net.smartworks.server.engine.category.model.CtgCategory;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.infowork.domain.model.SwdField;
import net.smartworks.server.engine.infowork.form.model.SwfField;
import net.smartworks.server.engine.infowork.form.model.SwfForm;
import net.smartworks.server.engine.infowork.form.model.SwfFormat;
import net.smartworks.server.engine.organization.manager.ISwoManager;
import net.smartworks.server.engine.organization.model.SwoUserExtend;
import net.smartworks.server.engine.pkg.manager.IPkgManager;
import net.smartworks.server.engine.pkg.model.PkgPackage;
import net.smartworks.server.engine.pkg.model.PkgPackageCond;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.util.LocalDate;


/**
 * 
 * 
 *  이전 ModelConverter 버젼 파일 삭제예정
 * 
 * 
 */ 


public class IModelConverter {

	private static ISwoManager getSwoManager() {
		return SwManagerFactory.getInstance().getSwoManager();
	}

	private static IPkgManager getPkgManager() {
		return SwManagerFactory.getInstance().getPkgManager();
	}

	// 개발 하기 불편..완료후 변경?
	public static InstanceInfo[] getInstanceInfoArrayByPrcInstArray(PrcProcessInst[] prcInsts) throws Exception {

		if (CommonUtil.isEmpty(prcInsts))
			return null;

		InstanceInfo[] instInfos = new InstanceInfo[prcInsts.length];

		for (int i = 0; i < prcInsts.length; i++) {
			PrcProcessInst prcInst = prcInsts[i];
			InstanceInfo instInfo = new InstanceInfo();

			instInfo.setId(prcInst.getObjId());// processInstanceId
			instInfo.setLastModifiedDate(new LocalDate());
			instInfo.setLastModifier(getUserInfoByUserId(prcInst.getModificationUser()));
			instInfo.setOwner(getUserInfoByUserId(prcInst.getCreationUser()));
			if (prcInst.getStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_COMPLETE)) {
				instInfo.setStatus(Instance.STATUS_COMPLETED);
			} else if (prcInst.getStatus().equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING)) {
				instInfo.setStatus(Instance.STATUS_RUNNING);
			}
			instInfo.setSubject(prcInst.getTitle());
			if (prcInst.getType() != null && prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_PROCESS)) {
				instInfo.setType(WorkInstance.TYPE_PROCESS);
			} else if (prcInst.getType() != null && prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_INFORMATION)) {
				instInfo.setType(WorkInstance.TYPE_INFORMATION);
			} else if (prcInst.getType() != null && prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_SCHEDULE)) {
				instInfo.setType(WorkInstance.TYPE_SCHEDULE);
			}
			instInfo.setWork(getSmartWorkInfoByPkgId(prcInst.getPackageId()));
			// TODO workspaceid > ??
			instInfo.setWorkSpace(new WorkSpaceInfo());

			instInfos[i] = instInfo;
		}
		return instInfos;
	}

	public static SmartWorkInfo getSmartWorkInfoByPkgId(String packageId) throws Exception {
		if (CommonUtil.isEmpty(packageId))
			return null;

		PkgPackageCond pkgCond = new PkgPackageCond();
		pkgCond.setPackageId(packageId);
		PkgPackage pkg = getPkgManager().getPackage("", pkgCond, IManager.LEVEL_LITE);
		if (pkg == null)
			return null;
		return getSmartWorkInfoByPkg(pkg);

	}

	public static SmartWorkInfo[] getSmartWorksInfoArrayByPkgArray(PkgPackage[] pkgs) throws Exception {

		if (CommonUtil.isEmpty(pkgs))
			return null;

		SmartWorkInfo[] smartWorkInfos = new SmartWorkInfo[pkgs.length];
		for (int i = 0; i < pkgs.length; i++) {
			PkgPackage pkg = pkgs[i];
			smartWorkInfos[i] = getSmartWorkInfoByPkg(pkg);
		}
		return smartWorkInfos;
	}

	public static SmartWorkInfo getSmartWorkInfoByPkg(PkgPackage pkg) throws Exception {

		SmartWorkInfo workInfo = new SmartWorkInfo();

		if (pkg.getType().equalsIgnoreCase("PROCESS")) {
			workInfo.setType(SmartWork.TYPE_PROCESS);
		} else if (pkg.getType().equalsIgnoreCase("SINGLE")) {
			workInfo.setType(SmartWork.TYPE_INFORMATION);
		} else if (pkg.getType().equalsIgnoreCase("GANTT")) {
			workInfo.setType(SmartWork.TYPE_SCHEDULE);
		}

		Map<String, WorkCategoryInfo> pkgCtgPathMap = getPkgCtgInfoMapByPackage(pkg);
		workInfo.setMyCategory(pkgCtgPathMap.get("category"));
		workInfo.setMyGroup(pkgCtgPathMap.get("group"));

		workInfo.setId(pkg.getPackageId());
		workInfo.setName(pkg.getName());
		return workInfo;
	}

	public static UserInfo getUserInfoByUserId(String userId) throws Exception {

		if (CommonUtil.isEmpty(userId))
			return null;
		SwoUserExtend userExtend = getSwoManager().getUserExtend(userId, userId);
		if (userExtend == null)
			return null;

		UserInfo userInfo = new UserInfo();

		userInfo.setId(userExtend.getId());
		userInfo.setName(userExtend.getName());
		userInfo.setDepartment(new DepartmentInfo(userExtend.getDepartmentId(), userExtend.getDepartmentName()));
		userInfo.setMidPictureName(userExtend.getPictureName());
		userInfo.setMinPictureName(userExtend.getPictureName());
		// userInfo.setPicturePath(picturePath);
		userInfo.setPosition(userExtend.getPosition());
		return userInfo;
	}

	public static WorkCategoryInfo getWorkCategoryInfoByCtg(CtgCategory argCtg) throws Exception {
		CtgCategory ctg = (CtgCategory) argCtg;
		String ctgId = ctg.getObjId();
		String ctgName = ctg.getName();

		WorkCategoryInfo workCtg = new WorkCategoryInfo(ctgId, ctgName);

		return workCtg;
	}

	public static WorkCategoryInfo[] getWorkCategoryInfoArrayByCtgArray(CtgCategory[] argCtgs) throws Exception {
		if (CommonUtil.isEmpty(argCtgs))
			return null;

		WorkCategoryInfo[] workCtgs = new WorkCategoryInfo[argCtgs.length];
		int i = 0;
		for (CtgCategory ctg : argCtgs) {

			WorkCategoryInfo workCtg = (WorkCategoryInfo) getWorkCategoryInfoByCtg(ctg);
			workCtgs[i] = workCtg;
			i++;
		}
		return workCtgs;
	}

	public static Map<String, WorkCategoryInfo> getPkgCtgInfoMapByPackage(PkgPackage pkg) throws Exception {

		String categoryId = pkg.getCategoryId();
		if (CommonUtil.isEmpty(categoryId) || categoryId.equalsIgnoreCase(CtgCategory.ROOTCTGID))
			return null;

		CtgCategory ctg = SwManagerFactory.getInstance().getCtgManager().getCategory("", categoryId, IManager.LEVEL_LITE);

		CtgCategory parentCtg = SwManagerFactory.getInstance().getCtgManager().getCategory("", ctg.getParentId(), IManager.LEVEL_LITE);

		Map<String, WorkCategoryInfo> resultMap = new HashMap<String, WorkCategoryInfo>();
		if (parentCtg == null || parentCtg.getObjId().equalsIgnoreCase(CtgCategory.ROOTCTGID)) {
			resultMap.put("category", (WorkCategoryInfo) getWorkCategoryInfoByCtg(ctg));
			resultMap.put("group", null);
		} else {
			resultMap.put("category", (WorkCategoryInfo) getWorkCategoryInfoByCtg(parentCtg));
			resultMap.put("group", (WorkCategoryInfo) getWorkCategoryInfoByCtg(ctg));
		}
		return resultMap;
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static User getUserByUserId(String userId) throws Exception {

		if (CommonUtil.isEmpty(userId))
			return null;
		SwoUserExtend userExtend = getSwoManager().getUserExtend(userId, userId);
		if (userExtend == null)
			return null;

		User user = new User();

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
		user.setUserLevel(-1);// userExtend.getUserLevel();

		return user;
	}

	public static WorkCategory getWorkCategoryByCtg(CtgCategory ctg) throws Exception {
		String ctgId = ctg.getObjId();
		String ctgName = ctg.getName();
		String ctgDesc = ctg.getDescription();

		WorkCategory workCtg = new WorkCategory(ctgId, ctgName);
		workCtg.setDesc(ctgDesc);

		return workCtg;
	}

	public static Map<String, WorkCategory> getPkgCtgMapByPackage(PkgPackage pkg) throws Exception {

		String categoryId = pkg.getCategoryId();
		if (CommonUtil.isEmpty(categoryId) || categoryId.equalsIgnoreCase(CtgCategory.ROOTCTGID))
			return null;

		CtgCategory ctg = SwManagerFactory.getInstance().getCtgManager().getCategory("", categoryId, IManager.LEVEL_LITE);

		CtgCategory parentCtg = SwManagerFactory.getInstance().getCtgManager().getCategory("", ctg.getParentId(), IManager.LEVEL_LITE);

		Map<String, WorkCategory> resultMap = new HashMap<String, WorkCategory>();
		if (parentCtg == null || parentCtg.getObjId().equalsIgnoreCase(CtgCategory.ROOTCTGID)) {
			resultMap.put("category", (WorkCategory) getWorkCategoryByCtg(ctg));
			resultMap.put("group", null);
		} else {
			resultMap.put("category", (WorkCategory) getWorkCategoryByCtg(parentCtg));
			resultMap.put("group", (WorkCategory) getWorkCategoryByCtg(ctg));
		}
		return resultMap;
	}

	public static FormField[] getFormFieldArrayBySwfFieldArray(SwfField[] fields) throws Exception {
		if (CommonUtil.isEmpty(fields))
			return null;

		FormField[] formFields = new FormField[fields.length];
		for (int i = 0; i < fields.length; i++) {
			SwfField field = fields[i];
			FormField formField = new FormField();

			/*
			 * <field id="4" name="내용" systemType="text" array="false"
			 * required="true" system="false"> <format type="richEditor"
			 * viewingType="richEditor"/> </field>
			 */
			String id = field.getId();
			String name = field.getName();
			SwfFormat format = field.getFormat();
			String type = format.getType();

			formField.setId(id);
			formField.setName(name);
			formField.setType(type);
			formFields[i] = formField;
		}
		return formFields;
	}

	public static SmartForm getSmartFormBySwFrom(SwfForm swForm) throws Exception {
		if (swForm == null)
			return null;

		String description = swForm.getDescription();
		String id = swForm.getId();
		String minImageName = "";
		String orgImageName = "";
		String name = swForm.getName();
		SwfField[] swFields = swForm.getFields();

		SmartForm smartForm = new SmartForm();

		smartForm.setDescription(description);
		smartForm.setFields(getFormFieldArrayBySwfFieldArray(swFields));
		smartForm.setId(id);
		smartForm.setMinImageName(minImageName);
		smartForm.setName(name);
		smartForm.setOrgImageName(orgImageName);

		return smartForm;
	}

	// public static UserInfo getUserInfoBySwUser(SwoUser swUser) throws
	// Exception {
	//
	// String id = swUser.getId();
	// String name = swUser.getName();
	// SwoCompany companyObj =
	// SwManagerFactory.getInstance().getSwoManager().getCompany(id,
	// swUser.getCompanyId(), IManager.LEVEL_LITE);
	// SwoDepartment departmentObj =
	// SwManagerFactory.getInstance().getSwoManager().getDepartment(id,
	// swUser.getDeptId(), IManager.LEVEL_LITE);
	//
	// String locale = swUser.getLang();
	// if (locale == null)
	// locale = "ko";
	// if (locale.equalsIgnoreCase("kor"))
	// locale = "ko";
	// if (locale.equalsIgnoreCase("eng"))
	// locale = "en";
	// String orgPictureName = swUser.getPicture();
	// String position = swUser.getPosition();
	//
	// UserInfo userInfo = new UserInfo();
	//
	// userInfo.setId(id);
	// userInfo.setName(name);
	// userInfo.setDepartment(new DepartmentInfo(departmentObj.getId(),
	// departmentObj.getName()));
	// userInfo.setMidPictureName(orgPictureName);
	// userInfo.setMinPictureName(orgPictureName);
	// //userInfo.setPicturePath(picturePath);
	// userInfo.setPosition(position);
	//
	// return userInfo;
	//
	// }
	// // @Deprecated
	// // public static Object objectToObject(Object argObj) throws Exception {
	// //
	// // if (argObj instanceof CtgCategory) {
	// // CtgCategory ctg = (CtgCategory)argObj;
	// //
	// // String ctgId = ctg.getObjId();
	// // String ctgName = ctg.getName();
	// // String ctgDesc = ctg.getDescription();
	// //
	// // WorkCategory workCtg = new WorkCategory(ctgId, ctgName);
	// // workCtg.setDesc(ctgDesc);
	// //
	// // return workCtg;
	// //
	// // } else if (argObj instanceof PkgPackage) {
	// // PkgPackage pkg = (PkgPackage)argObj;
	// //
	// // String pkgId = pkg.getPackageId();
	// // String pkgName = pkg.getName();
	// // String pkgDesc = pkg.getDescription();
	// //
	// // SmartWork work = new SmartWork(pkgId, pkgName);
	// //
	// // Map<String, WorkCategory> pkgCtgPathMap =
	// getPkgCtgMapByPackageId(pkg);
	// // work.setMyCategory(pkgCtgPathMap.get("category"));
	// // work.setMyGroup(pkgCtgPathMap.get("group"));
	// // if (pkg.getType().equalsIgnoreCase("PROCESS")) {
	// // work.setType(SmartWork.TYPE_PROCESS);
	// // } else if (pkg.getType().equalsIgnoreCase("SINGLE")) {
	// // work.setType(SmartWork.TYPE_INFORMATION);
	// // } else if (pkg.getType().equalsIgnoreCase("GANTT")) {
	// // work.setType(SmartWork.TYPE_SCHEDULE);
	// // }
	// // work.setDesc(pkgDesc);
	// //
	// // return work;
	// //
	// // } else if (argObj instanceof PrcProcessInst) {
	// // PrcProcessInst prcInst = (PrcProcessInst)argObj;
	// //
	// // String prcInstId = prcInst.getObjId();
	// // String prcInstType = prcInst.getType();
	// // Date prcInstLastModifiedDate = prcInst.getModificationDate();
	// // String prcInstLastModifier = prcInst.getModificationUser();
	// // String prcInstOwner = prcInst.getCreationUser();
	// // String prcInstStatus = prcInst.getStatus(); // CODE 값으로 변경
	// // String prcInstSubject = prcInst.getTitle();
	// //
	// // WorkInstance workInst = new WorkInstance();
	// //
	// // workInst.setId(prcInstId);
	// //
	// // if
	// (prcInstStatus.equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_COMPLETE))
	// {
	// // workInst.setStatus(WorkInstance.STATUS_COMPLETED);
	// // } else if
	// (prcInstStatus.equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING))
	// {
	// // workInst.setStatus(WorkInstance.STATUS_RUNNING);
	// // }
	// // if (prcInst.getType() != null) {
	// // if
	// (prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_PROCESS))
	// {
	// // //workInst.setInstanceType(WorkInstance.TYPE_PROCESS);
	// // } else if
	// (prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_INFORMATION))
	// {
	// // //workInst.setInstanceType(WorkInstance.TYPE_INFORMATION);
	// // } else if
	// (prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_SCHEDULE))
	// {
	// // //workInst.setInstanceType(WorkInstance.TYPE_SCHEDULE);
	// // }
	// // } else {
	// // //TODO prcInst.getType()
	// // //type 이 새로 추가되었기 때문에 이전 데이터에는 type 내용이 없음 그럴때는
	// // //임시로 prcinst.getDiagramId()의값이 있으면 프로세 없으면 정보관리 업무로 임시적으로 컨버팅한다
	// // //일정관리 업무는 구별할 방법이 없음.....
	// // //새로 오픈할 때에는 삭제 필요
	// // if (prcInst.getDiagramId() == null) {
	// // //workInst.setInstanceType(WorkInstance.TYPE_INFORMATION);
	// // } else {
	// // //workInst.setInstanceType(WorkInstance.TYPE_PROCESS);
	// // }
	// // }
	// // workInst.setLastModifiedDate(new
	// LocalDate(prcInstLastModifiedDate.getTime()));
	// //
	// workInst.setLastModifier((User)objectToObject(SwManagerFactory.getInstance().getSwoManager().getUser(prcInstLastModifier,
	// prcInstLastModifier, IManager.LEVEL_LITE)));
	// //
	// workInst.setOwner((User)objectToObject(SwManagerFactory.getInstance().getSwoManager().getUser(prcInstOwner,
	// prcInstOwner, IManager.LEVEL_LITE)));
	// // workInst.setSubject(prcInstSubject);
	// //
	// // return workInst;
	// //
	// // } else if (argObj instanceof SwoUser) {
	// // SwoUser swUser = (SwoUser)argObj;
	// //
	// // String id = swUser.getId();
	// // String name = swUser.getName();
	// // SwoCompany companyObj =
	// SwManagerFactory.getInstance().getSwoManager().getCompany(id,
	// swUser.getCompanyId(), IManager.LEVEL_LITE);
	// // String company = companyObj == null ? swUser.getCompanyId() :
	// companyObj.getName();
	// // SwoDepartment departmentObj =
	// SwManagerFactory.getInstance().getSwoManager().getDepartment(id,
	// swUser.getDeptId(), IManager.LEVEL_LITE);
	// // String department = departmentObj == null ? swUser.getDeptId() :
	// departmentObj.getName();
	// //
	// // String locale = swUser.getLang();
	// // if (locale == null)
	// // locale = "ko";
	// // if (locale.equalsIgnoreCase("kor"))
	// // locale = "ko";
	// // if (locale.equalsIgnoreCase("eng"))
	// // locale = "en";
	// // String orgPictureName = swUser.getPicture();
	// // String picturePath = "";
	// // String position = swUser.getPosition();
	// // String timeZone = swUser.getStdTime();
	// // int userLevel = -1;
	// //
	// // User user = new User();
	// //
	// // user.setId(id);
	// // user.setName(name);
	// // user.setCompany(company);
	// // user.setDepartment(department);
	// // user.setLocale(locale);
	// // user.setMidPictureName(orgPictureName);
	// // user.setMinPictureName(orgPictureName);
	// // user.setOrgPictureName(orgPictureName);
	// //// user.setPicturePath(picturePath);
	// // user.setPosition(position);
	// // user.setTimeZone(timeZone);
	// // user.setUserLevel(userLevel);
	// //
	// // return user;
	// //
	// // } else {
	// // return null;
	// // }
	// // }
	// //
	// // @Deprecated
	// // public static Object[] arrayToArray(Object[] argObj) throws Exception
	// {
	// //
	// // if (CommonUtil.isEmpty(argObj))
	// // return null;
	// //
	// // if (argObj instanceof CtgCategory[]) {
	// // CtgCategory[] ctgs = (CtgCategory[])argObj;
	// //
	// // WorkCategory[] workCtgs = new WorkCategory[ctgs.length];
	// // int i = 0;
	// // for (CtgCategory ctg : ctgs) {
	// //
	// // WorkCategory workCtg = (WorkCategory)objectToObject(ctg);
	// // workCtgs[i] = workCtg;
	// // i++;
	// // }
	// // return workCtgs;
	// //
	// // } else if (argObj instanceof PkgPackage[]) {
	// // PkgPackage[] pkgs = (PkgPackage[])argObj;
	// //
	// // SmartWork[] works = new SmartWork[pkgs.length];
	// // int i = 0;
	// // for (PkgPackage pkg : pkgs) {
	// //
	// // SmartWork work = (SmartWork)objectToObject(pkg);
	// //
	// // Map<String, WorkCategory> pkgCtgPathMap =
	// getPkgCtgMapByPackageId(pkg);
	// //
	// // work.setMyCategory(pkgCtgPathMap.get("category"));
	// // work.setMyGroup(pkgCtgPathMap.get("group"));
	// //
	// // works[i] = work;
	// // i++;
	// // }
	// // return works;
	// //
	// // } else if (argObj instanceof PrcProcessInst[]) {
	// // PrcProcessInst[] prcInsts = (PrcProcessInst[])argObj;
	// //
	// // WorkInstance[] workInsts = new WorkInstance[prcInsts.length];
	// //
	// // int i = 0;
	// // for (PrcProcessInst prcInst : prcInsts) {
	// // WorkInstance workInst = (WorkInstance)objectToObject(prcInst);
	// // workInsts[i] = workInst;
	// // i++;
	// // }
	// // return workInsts;
	// //
	// // } else {
	// // return null;
	// // }
	// // }
	// protected static Map<String, WorkCategory>
	// getPkgCtgMapByPackageId(PkgPackage pkg) throws Exception {
	//
	// String categoryId = pkg.getCategoryId();
	// if (CommonUtil.isEmpty(categoryId) ||
	// categoryId.equalsIgnoreCase(CtgCategory.ROOTCTGID))
	// return null;
	//
	// CtgCategory ctg =
	// SwManagerFactory.getInstance().getCtgManager().getCategory("",
	// categoryId, IManager.LEVEL_LITE);
	//
	// CtgCategory parentCtg =
	// SwManagerFactory.getInstance().getCtgManager().getCategory("",
	// ctg.getParentId(), IManager.LEVEL_LITE);
	//
	// Map<String, WorkCategory> resultMap = new HashMap<String,
	// WorkCategory>();
	// if (parentCtg == null ||
	// parentCtg.getObjId().equalsIgnoreCase(CtgCategory.ROOTCTGID)) {
	// resultMap.put("category", (WorkCategory)objectToObject(ctg));
	// resultMap.put("group", null);
	// } else {
	// resultMap.put("category", (WorkCategory)objectToObject(parentCtg));
	// resultMap.put("group", (WorkCategory)objectToObject(ctg));
	// }
	// return resultMap;
	// }

}
