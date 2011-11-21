/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 11. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.service.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.smartworks.model.community.User;
import net.smartworks.model.instance.WorkInstance;
import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.WorkCategory;
import net.smartworks.server.engine.category.model.CtgCategory;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.organization.model.SwoCompany;
import net.smartworks.server.engine.organization.model.SwoDepartment;
import net.smartworks.server.engine.organization.model.SwoUser;
import net.smartworks.server.engine.pkg.model.PkgPackage;
import net.smartworks.server.engine.process.process.model.PrcProcessInst;
import net.smartworks.util.LocalDate;

public class ModelConverter {
	
	public static Object objectToObject(Object argObj) throws Exception {

		if (argObj instanceof CtgCategory) {
			CtgCategory ctg = (CtgCategory)argObj;
			
			String ctgId = ctg.getObjId();
			String ctgName = ctg.getName();
			String ctgDesc = ctg.getDescription();
				
			WorkCategory workCtg = new WorkCategory(ctgId, ctgName);
			workCtg.setDesc(ctgDesc);
			
			return workCtg;
			
		} else if (argObj instanceof PkgPackage) {
			PkgPackage pkg = (PkgPackage)argObj;
			
			String pkgId = pkg.getObjId();
			String pkgName = pkg.getName();
			String pkgDesc = pkg.getDescription();
				
			SmartWork work = new SmartWork(pkgId, pkgName);
				
			Map<String, WorkCategory> pkgCtgPathMap = getPkgCtgInfoMapByPackageId(pkg);
			work.setMyCategory(pkgCtgPathMap.get("category"));
			work.setMyGroup(pkgCtgPathMap.get("group"));
			if (pkg.getType().equalsIgnoreCase("PROCESS")) {
				work.setType(SmartWork.TYPE_PROCESS);	
			} else if (pkg.getType().equalsIgnoreCase("SINGLE")) {
				work.setType(SmartWork.TYPE_INFORMATION);	
			} else if (pkg.getType().equalsIgnoreCase("GANTT")) {
				work.setType(SmartWork.TYPE_SCHEDULE);	
			}
			work.setDesc(pkgDesc);
			
			return work;
			
		} else if (argObj instanceof PrcProcessInst) {
			PrcProcessInst prcInst = (PrcProcessInst)argObj;
			
			String prcInstId = prcInst.getObjId();
			String prcInstType = prcInst.getType();
			Date prcInstLastModifiedDate = prcInst.getModificationDate();
			String prcInstLastModifier = prcInst.getModificationUser();
			String prcInstOwner = prcInst.getCreationUser();
			String prcInstStatus = prcInst.getStatus(); // CODE 값으로 변경
			String prcInstSubject = prcInst.getTitle();
			
			WorkInstance workInst = new WorkInstance();
			
			workInst.setId(prcInstId);
			
			if (prcInstStatus.equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_COMPLETE)) {
				workInst.setStatus(WorkInstance.STATUS_COMPLETED);
			} else if (prcInstStatus.equalsIgnoreCase(PrcProcessInst.PROCESSINSTSTATUS_RUNNING)) {
				workInst.setStatus(WorkInstance.STATUS_RUNNING);
			}
			if (prcInst.getType() != null) {
				if (prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_PROCESS)) {
					//workInst.setInstanceType(WorkInstance.TYPE_PROCESS);
				} else if (prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_INFORMATION)) {
					//workInst.setInstanceType(WorkInstance.TYPE_INFORMATION);
				} else if (prcInst.getType().equalsIgnoreCase(PrcProcessInst.PROCESSINSTTYPE_SCHEDULE)) {
					//workInst.setInstanceType(WorkInstance.TYPE_SCHEDULE);
				}
			} else {
				//TODO prcInst.getType()
				//type 이 새로 추가되었기 때문에 이전 데이터에는 type 내용이 없음 그럴때는
				//임시로 prcinst.getDiagramId()의값이 있으면 프로세 없으면 정보관리 업무로 임시적으로 컨버팅한다
				//일정관리 업무는 구별할 방법이 없음.....
				//새로 오픈할 때에는 삭제 필요
				if (prcInst.getDiagramId() == null) {
					//workInst.setInstanceType(WorkInstance.TYPE_INFORMATION);
				} else {
					//workInst.setInstanceType(WorkInstance.TYPE_PROCESS);
				}
			}
			workInst.setLastModifiedDate(new LocalDate(prcInstLastModifiedDate.getTime()));
			workInst.setLastModifier((User)objectToObject(SwManagerFactory.getInstance().getSwoManager().getUser(prcInstLastModifier, prcInstLastModifier, IManager.LEVEL_LITE)));
			workInst.setOwner((User)objectToObject(SwManagerFactory.getInstance().getSwoManager().getUser(prcInstOwner, prcInstOwner, IManager.LEVEL_LITE)));
			workInst.setSubject(prcInstSubject);
			
			return workInst;
			
		} else if (argObj instanceof SwoUser) {
			SwoUser swUser = (SwoUser)argObj;
			
			String id = swUser.getId();
			String name = swUser.getName();
			SwoCompany companyObj = SwManagerFactory.getInstance().getSwoManager().getCompany(id, swUser.getCompanyId(), IManager.LEVEL_LITE);
			String company = companyObj == null ? swUser.getCompanyId() : companyObj.getName();
			SwoDepartment departmentObj	= SwManagerFactory.getInstance().getSwoManager().getDepartment(id, swUser.getDeptId(), IManager.LEVEL_LITE);
			String department = departmentObj == null ? swUser.getDeptId() : departmentObj.getName();
			
			String locale = swUser.getLang();
			if (locale == null)
				locale = "ko";
			if (locale.equalsIgnoreCase("kor"))
				locale = "ko";
			if (locale.equalsIgnoreCase("eng"))
				locale = "en";
			String orgPictureName = swUser.getPicture();
			String picturePath = "";
			String position = swUser.getPosition();
			String timeZone = swUser.getStdTime();
			int userLevel = -1;
			
			User user = new User();
				
			user.setId(id);
			user.setName(name);
			user.setCompany(company);
			user.setDepartment(department);
			user.setLocale(locale);
			user.setMidPictureName(orgPictureName);
			user.setMinPictureName(orgPictureName);
			user.setOrgPictureName(orgPictureName);
//			user.setPicturePath(picturePath);
			user.setPosition(position);
			user.setTimeZone(timeZone);
			user.setUserLevel(userLevel);
			
			return user;
			
		} else {
			return null;
		}
	}
	
	public static Object[] arrayToArray(Object[] argObj) throws Exception {

		if (CommonUtil.isEmpty(argObj))
			return null;

		if (argObj instanceof CtgCategory[]) {
			CtgCategory[] ctgs = (CtgCategory[])argObj;
			
			WorkCategory[] workCtgs = new WorkCategory[ctgs.length];
			int i = 0;
			for (CtgCategory ctg : ctgs) {

				WorkCategory workCtg = (WorkCategory)objectToObject(ctg);
				workCtgs[i] = workCtg; 
				i++;
			}
			return workCtgs;
			
		} else if (argObj instanceof PkgPackage[]) {
			PkgPackage[] pkgs = (PkgPackage[])argObj;
			
			SmartWork[] works = new SmartWork[pkgs.length];
			int i = 0;
			for (PkgPackage pkg : pkgs) {
				
				SmartWork work = (SmartWork)objectToObject(pkg);
				
				Map<String, WorkCategory> pkgCtgPathMap = getPkgCtgInfoMapByPackageId(pkg);

				work.setMyCategory(pkgCtgPathMap.get("category"));
				work.setMyGroup(pkgCtgPathMap.get("group"));
				
				works[i] = work; 
				i++;
			}
			return works;
			
		} else if (argObj instanceof PrcProcessInst[]) {
			PrcProcessInst[] prcInsts = (PrcProcessInst[])argObj;
			
			WorkInstance[] workInsts = new WorkInstance[prcInsts.length];
			
			int i = 0;
			for (PrcProcessInst prcInst : prcInsts) {
				WorkInstance workInst = (WorkInstance)objectToObject(prcInst);
				workInsts[i] = workInst; 
				i++;
			}
			return workInsts;
			
		} else {
			return null;
		}
	}
	protected static Map<String, WorkCategory> getPkgCtgInfoMapByPackageId(PkgPackage pkg) throws Exception {
		
		String categoryId = pkg.getCategoryId();
		if (CommonUtil.isEmpty(categoryId) || categoryId.equalsIgnoreCase(CtgCategory.ROOTCTGID))
			return null;
		
		CtgCategory ctg = SwManagerFactory.getInstance().getCtgManager().getCategory("", categoryId, IManager.LEVEL_LITE);
		
		CtgCategory parentCtg = SwManagerFactory.getInstance().getCtgManager().getCategory("", ctg.getParentId(), IManager.LEVEL_LITE);
		
		Map<String, WorkCategory> resultMap = new HashMap<String, WorkCategory>();
		if (parentCtg == null || parentCtg.getObjId().equalsIgnoreCase(CtgCategory.ROOTCTGID)) {
			resultMap.put("category", (WorkCategory)objectToObject(ctg));
			resultMap.put("group", null);
		} else {
			resultMap.put("category", (WorkCategory)objectToObject(parentCtg.getObjId()));
			resultMap.put("group", (WorkCategory)objectToObject(ctg.getObjId()));
		}
		return resultMap;
	}
}
