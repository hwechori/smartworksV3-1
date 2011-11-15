/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 11. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.service.util;

import java.util.HashMap;
import java.util.Map;

import net.smartworks.model.work.SmartWork;
import net.smartworks.model.work.WorkCategory;
import net.smartworks.server.engine.category.model.CtgCategory;
import net.smartworks.server.engine.common.manager.IManager;
import net.smartworks.server.engine.common.util.CommonUtil;
import net.smartworks.server.engine.factory.SwManagerFactory;
import net.smartworks.server.engine.pkg.model.PkgPackage;

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
