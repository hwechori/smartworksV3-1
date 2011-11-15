/* 
 * $Id$
 * created by    : yukm
 * creation-date : 2011. 11. 15.
 * =========================================================
 * Copyright (c) 2011 ManinSoft, Inc. All rights reserved.
 */

package net.smartworks.server.service.util;

import net.smartworks.model.work.WorkCategory;
import net.smartworks.server.engine.category.model.CtgCategory;
import net.smartworks.server.engine.common.util.CommonUtil;

public class ModelConverter {
	
	public static Object[] arrayToArray(Object[] argObj) throws Exception {

		if (CommonUtil.isEmpty(argObj))
			return null;

		if (argObj instanceof CtgCategory[]) {
			CtgCategory[] ctgs = (CtgCategory[])argObj;
			
			WorkCategory[] workCtgs = new WorkCategory[ctgs.length];
			int i = 0;
			for (CtgCategory ctg : ctgs) {
				
				String ctgId = ctg.getObjId();
				String ctgName = ctg.getName();
				String ctgDesc = ctg.getDescription();
				
				WorkCategory workCtg = new WorkCategory(ctgId, ctgName);
				workCtg.setDesc(ctgDesc);
				workCtgs[i] = workCtg; 
				i++;
			}
			return workCtgs;
		} else {
			return null;
		}
	}
}
